
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
	  int locationX = e.getX();
	  int locationY = e.getY();
	  
	  for(int i = canvas.getDrawnList().size() - 1; i >= 0; i--){
		  int TLX = canvas.getDrawnList().elementAt(i).getTopLeftX();
		  int TLY = canvas.getDrawnList().elementAt(i).getTopLeftY();
		  int BRX = canvas.getDrawnList().elementAt(i).getBottomRightX();
		  int BRY = canvas.getDrawnList().elementAt(i).getBottomRightY();
		  
		  if(TLX < BRX){
			  if(TLY < BRY){
				  if(TLX < locationX && BRX > locationX && TLY < locationY && BRY > locationY){
					  canvas.getDrawnList().remove(i);
					  break;
				  }
			  }
			  else{
				  if(TLX < locationX && BRX > locationX && TLY >= locationY && BRY <= locationY){
					  canvas.getDrawnList().remove(i);
					  break;
				  }
			  }
		  }
		  else if(TLX >= BRX){
			  if(TLY < BRY){
				  if(TLX > locationX && BRX < locationX && TLY < locationY && BRY > locationY){
					  canvas.getDrawnList().remove(i);
					  break;
				  }
			  }
			  else{
				  if(TLX > locationX && BRX < locationX && TLY >= locationY && BRY <= locationY){
					  canvas.getDrawnList().remove(i);
					  break;
				  }
			  }
		  }
	  }
    canvas.update();
  }

  /* (non-Javadoc)
   *
   * Erases as the user drags the mouse across the canvas.
   *
   * @see tools.Tool#mouseDragged(java.awt.event.MouseEvent)
   */
  public void mouseDragged(MouseEvent e)  {
  }

  /* (non-Javadoc)
   *
   * Completes the eraser and resets the drawing color to the previous pen
   * color.
   *
   * @see tools.Tool#mouseReleased(java.awt.event.MouseEvent)
   */
  public void mouseReleased(MouseEvent e) {
  }
}// end public class EraserTool extends Tool
