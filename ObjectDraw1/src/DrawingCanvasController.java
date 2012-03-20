
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class DrawingCanvasController implements MouseListener,
                                                MouseMotionListener,
                                                KeyListener
{
  /* Class Member Variables */
  protected DrawingCanvas canvas;

  /****< Constructors >********************************************************/
  public DrawingCanvasController(DrawingCanvas c) {
    canvas=c;
  }

  /****< Event Handlers >******************************************************/
  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
   */
  public void mousePressed(MouseEvent e) {
    Tool tool = canvas.getcurrentTool();
    if (tool != null) {
      tool.mousePressed(e);
    }
  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
   */
  public void mouseReleased(MouseEvent e) {
    Tool tool = canvas.getcurrentTool();
    if(tool != null) {
      tool.mouseReleased(e);
    }
  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
   */
  public void mouseDragged(MouseEvent e) {
    Tool tool = canvas.getcurrentTool();
    if(tool != null) {
      tool.mouseDragged(e);
    }
    else
    	canvas.mouseDragged(e);
  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
   */
  public void mouseClicked(MouseEvent e) {
    Tool tool = canvas.getcurrentTool();
    if(tool != null) {
      tool.mouseClicked(e);
    }
    else
      canvas.mousePressed(e);
  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
   */
  public void mouseEntered(MouseEvent e) {
    Tool tool = canvas.getcurrentTool();
    if(tool != null) {
      tool.mouseEntered(e);
    }
  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
   */
  public void mouseExited(MouseEvent e) {
    Tool tool = canvas.getcurrentTool();
    if(tool != null) {
      tool.mouseExited(e);
    }
  }

  /* (non-Javadoc)
   * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
   */
  public void mouseMoved(MouseEvent e) {
    Tool tool = canvas.getcurrentTool();
    if(tool != null) {
      tool.mouseMoved(e);
    }
  }

  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
   */
  public void keyPressed(KeyEvent e) {
    Tool tool = (Tool)canvas.getcurrentTool();
    if (tool != null) {
      tool.keyPressed(e);
    }
  }

  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
   */
  public void keyReleased(KeyEvent e) {
    Tool tool = (Tool)canvas.getcurrentTool();
    if(tool != null) {
      tool.keyReleased(e);
    }
  }

  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
   */
  public void keyTyped(KeyEvent e) {
    Tool tool = (Tool)canvas.getcurrentTool();
    if(tool != null) {
      tool.keyTyped(e);
    }// end tool null check
  }// end public void keyTyped( KeyEvent )
} /* end public class DrawingCanvasController */
