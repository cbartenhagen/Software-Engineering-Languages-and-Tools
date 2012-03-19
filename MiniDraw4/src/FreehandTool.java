
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * Draws a Freehand shape on the DrawingCanvas.
 *
 * A Freehand shape can consist of many different points and simply follows the
 * user's mouse.  As the user moves the mouse, line segments are drawn to
 * screen.
 */
public class FreehandTool extends Tool {

  /* Class member variables */
  protected DrawingCanvas canvas;
  protected Point startingMousePosition;

  /****< Constructor >*********************************************************/
  public FreehandTool(DrawingCanvas c) {
    if( c != null )
      canvas = c;
    else
      throw new IllegalArgumentException();
  }

  /****< Draw Method >*********************************************************/
  protected void drawLineSegment(Point p1, Point p2) {
    canvas.getimageBufferGraphics().drawLine(p1.x,p1.y,
				           p2.x, p2.y);
    /* redraw only the small rectangle  */
    /* containing the new line segment  */
    int x0 = Math.min(p1.x, p2.x);
    int y0 = Math.min(p1.y, p2.y);
    int dx = Math.abs(p2.x - p1.x)+ 1;
    int dy = Math.abs(p2.y - p1.y) + 1;
    canvas.repaint(x0, y0, dx, dy);
  }

  /****< Event Handlers >******************************************************/
  /* (non-Javadoc)
   *
   * Establish starting point for next drawing.
   *
   * @see tools.Tool#mousePressed(java.awt.event.MouseEvent)
   */
  public void mousePressed(MouseEvent e)  {
    startingMousePosition = e.getPoint();
  }

  /* (non-Javadoc)
   *
   * Draws the next line segment on the canvas.
   *
   * @see tools.Tool#mouseDragged(java.awt.event.MouseEvent)
   */
  public void mouseDragged(MouseEvent e)  {
    Point newMousePosition = e.getPoint();
    drawLineSegment(startingMousePosition,
				newMousePosition);
    /* update current mouse coordinates */
    startingMousePosition = newMousePosition;
  }
}// end public class FreehandTool extends Tool
