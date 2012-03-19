
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

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
  protected StringBuffer text;
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
    text = new StringBuffer();
  }

  /* (non-Javadoc)
   *
   * Adds a character to the string buffer
   *
   * @see tools.Tool#keyPressed(java.awt.event.KeyEvent)
   */
  public void keyPressed(KeyEvent e)  {
    char nextChar = e.getKeyChar();
    text.append(nextChar);
    Graphics iBGraphics = canvas.getimageBufferGraphics();
    iBGraphics.drawString(text.toString(), startingPosition.x,
        startingPosition.y);
    canvas.repaint();
  }
}// end public class TextTool extends Tool
