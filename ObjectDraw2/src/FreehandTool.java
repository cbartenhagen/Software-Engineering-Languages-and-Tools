
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Vector;

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
  protected Color saveColor;
  protected Vector<Object> points;

  /****< Constructor >*********************************************************/
  public FreehandTool(DrawingCanvas c) {
    if( c != null ){
      canvas = c;
      points = new Vector<Object>();
    }
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
    Graphics iBGraphics = canvas.getimageBufferGraphics();
    saveColor = iBGraphics.getColor( );
    points = new Vector<Object>();
    points.add(e.getPoint());
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
    points.add(e.getPoint());
    /* update current mouse coordinates */
    startingMousePosition = newMousePosition;
  }
  
  /*
   * (non-Javadoc)
   * 
   * Draw final object and save it to the canvas.
   * 
   * @see Tool#mouseReleased(java.awt.event.MouseEvent)
   */
  public void mouseReleased(MouseEvent e) {
	  points.add(e.getPoint());
	  int minX = 0;
	  int minY = 0;
	  int maxX = 0;
	  int maxY = 0;
	  
	  for(int i = 0; i < points.size(); i++){
		  if(i == 0){
			  minX = ((Point) points.elementAt(i)).x;
			  maxX = ((Point) points.elementAt(i)).x;
			  minY = ((Point) points.elementAt(i)).y;
			  maxY = ((Point) points.elementAt(i)).y;
		  }
		  
		  if(minX > ((Point) points.elementAt(i)).x)
			  minX = ((Point) points.elementAt(i)).x;
		  else if(maxX < ((Point) points.elementAt(i)).x)
			  maxX = ((Point) points.elementAt(i)).x;
			  
		  if(minY > ((Point) points.elementAt(i)).y)
			  minY = ((Point) points.elementAt(i)).y;
		  if(maxY < ((Point) points.elementAt(i)).y)
			  maxY = ((Point) points.elementAt(i)).y;
		  
	  }
	  
	  for(int i = 0; i < points.size(); i++){
		  ((Point) points.elementAt(i)).x -= minX;
		  ((Point) points.elementAt(i)).y -= minY;
	  }
	  
	  //create drawn object with the intermediate points as the other things
	  DrawnObject dobject = new DrawnObject(minX,
              minY,
              maxX,
              maxY,
              getName(),
              saveColor,
              canvas.isFilled(),
              points);

	  canvas.addDrawnObject(dobject);
  }
  
  /*
   * (non-Javadoc)
   * 
   * Draws the input freehand object.
   * 
   * @see Tool#drawThis(DrawnObject)
   */
  public void drawThis(DrawnObject object){
	  Point p1 = new Point();
	  Point p2 = new Point();
	  int minX = object.topLeftX;
	  int minY = object.topLeftY;
	  
	  canvas.getimageBufferGraphics().setColor(object.getColor());
	  
	  //draw all of the individual segments
	  for(int i = 0; i < object.getOtherThings().size() - 1; i++){
		  p1.x = minX + ((Point) object.getOtherThings().elementAt(i)).x;
		  p1.y = minY + ((Point) object.getOtherThings().elementAt(i)).y;
		  p2.x = minX + ((Point) object.getOtherThings().elementAt(i + 1)).x;
		  p2.y = minY + ((Point) object.getOtherThings().elementAt(i + 1)).y;
		  drawLineSegment(p1,p2);
	  }
  }
}// end public class FreehandTool extends Tool
