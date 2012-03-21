
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * Draws the background color on the canvas, thus erasing.
 *
 * Follows the user's mouse movement and erases as the user drags the mouse
 * across the DrawingCanvas.
 */
public class EraserTool extends Tool {

  /* Class Member Variables */
  protected DrawingCanvas canvas;
  protected Point startingMousePosition;
  protected Color saveColor;

  /****< Constructors >********************************************************/
  public EraserTool(DrawingCanvas c) {
    if( c != null )
      canvas = c;
    else
      throw new IllegalArgumentException();
  }

  /****< Draw Method >*********************************************************/
  protected void drawErasure(int x, int y, int width, int height) {
    Graphics iBGraphics = canvas.getimageBufferGraphics();
    iBGraphics.fillRect(x, y, width, height);
    canvas.repaint(x, y, width, height);
  }

  /****< Event Methods >*******************************************************/
  /*(non-Javadoc)
   *
   * Establishes the starting point for erasing and sets the "drawing" color
   * to the background color.
   *
   * @see tools.Tool#mousePressed(java.awt.event.MouseEvent)
   */
  public void mousePressed(MouseEvent e)  {
    if(canvas.getCurrentObject() != null){
    	canvas.getDrawnList().remove(canvas.getCurrentObject());
    }
    canvas.setCurrentObject(null);
    canvas.update();
  }

  /* (non-Javadoc)
   *
   * Erases as the user drags the mouse across the canvas.
   *
   * @see tools.Tool#mouseDragged(java.awt.event.MouseEvent)
   */
  public void mouseDragged(MouseEvent e)  {
    /* erase  */
    Point newMousePosition = e.getPoint();
    int x0 = Math.min(startingMousePosition.x, newMousePosition.x)-2;
    int y0= Math.min(startingMousePosition.y, newMousePosition.y)-2;
    int dx = Math.abs(newMousePosition.x - startingMousePosition.x) + 5;
    int dy = Math.abs(newMousePosition.y - startingMousePosition.y) + 5;
    drawErasure(x0, y0, dx, dy);
    /* update current mouse coordinates */
    startingMousePosition = newMousePosition;
  }

  /* (non-Javadoc)
   *
   * Completes the eraser and resets the drawing color to the previous pen
   * color.
   *
   * @see tools.Tool#mouseReleased(java.awt.event.MouseEvent)
   */
  public void mouseReleased(MouseEvent e) {
    Graphics iBGraphics = canvas.getimageBufferGraphics();
    /* restore pen color  */
    iBGraphics.setColor(saveColor);
  }
}// end public class EraserTool extends Tool
