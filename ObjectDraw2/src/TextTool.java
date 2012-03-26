
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Draws text on the canvas.
 *
 * The user selects the starting point with the mouse and then types in the
 * desired text.  Currently, the font is not selectable.  A new text box will
 * begin when the user clicks on a different canvas location.  Changing the
 * current tool, in effect, also stops current text entry.
 */
public class TextTool extends Tool {

  /* Class member variables */
  protected DrawingCanvas canvas;
  protected Point startingPosition;
  protected Font font = new Font("Serif", Font.BOLD, 24);

  /****< Constructor >*********************************************************/
  public TextTool(DrawingCanvas c) {
    if( c != null )
      canvas = c;
    else
      throw new IllegalArgumentException();
  }

  /****< Event Handler Methods >***********************************************/
  /* (non-Javadoc)
   *
   * Returns focus to the drawing canvas and stores the starting location for
   * the text display.
   * @see tools.Tool#mousePressed(java.awt.event.MouseEvent)
   */
  public void mousePressed(MouseEvent e)  {
    canvas.requestFocus();
    startingPosition = e.getPoint();
    Graphics iBGraphics = canvas.getimageBufferGraphics();
    iBGraphics.setFont(font);
    
    Vector<Object> theString = new Vector<Object>();
    theString.add(new String(""));
    DrawnObject dobject = new DrawnObject(e.getX(),
            e.getY(),
            e.getX(),
            e.getY()+5,
            getName(),
            canvas.getpenColor(),
            canvas.isFilled(),
            theString);
    
    canvas.addDrawnObject(dobject);
  }

  /* (non-Javadoc)
   *
   * Adds a character to the string buffer
   *
   * @see tools.Tool#keyPressed(java.awt.event.KeyEvent)
   */
  public void keyPressed(KeyEvent e)  {
    char nextChar = e.getKeyChar();
    
    
    if(canvas.getDrawnList().size() > 0){
    	System.out.println(canvas.getDrawnList().elementAt(canvas.getDrawnList().size()-1).getCreatorTool());
	    if(canvas.getDrawnList().elementAt(canvas.getDrawnList().size()-1).getCreatorTool().equals(getName())){
	System.out.println("Hello2");
	        String text = ((String) (canvas.getDrawnList().elementAt(canvas.getDrawnList().size()-1).getOtherThings().elementAt(0)));
	        text += nextChar;
	        Vector<Object> theString = new Vector<Object>();
	        theString.add(text);
	        int width = text.length() * 10;
	        canvas.getDrawnList().elementAt(canvas.getDrawnList().size()-1).setBottomRightX(canvas.getDrawnList().elementAt(canvas.getDrawnList().size()-1).topLeftX + width);
	        canvas.getDrawnList().elementAt(canvas.getDrawnList().size() - 1).setOtherThings(theString);
	        canvas.update();
	    }
    
    }
    
    
    canvas.repaint();
  }
  
  public void drawThis(DrawnObject object){
      Graphics iBGraphics = canvas.getimageBufferGraphics();
      Color bufferColor = iBGraphics.getColor();
      iBGraphics.setColor(object.getColor());
      System.out.println((String) object.getOtherThings().elementAt(0));
      iBGraphics.drawString(((String) (object.getOtherThings().elementAt(0))), object.getTopLeftX(),
          object.getTopLeftY());
      iBGraphics.setColor(bufferColor);
      
	  
  }
}// end public class TextTool extends Tool
