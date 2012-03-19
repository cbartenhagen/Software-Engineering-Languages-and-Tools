

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Generic parent class for a MiniDraw Tool.
 *
 * This class is not meant to be instantiated directly, and thus, it is declared
 * abstract. Declaring the Tool as abstract and declaring all of the appropriate
 * listener methods allows sub-classes to define only the methods that are
 * important for that tool to function.
 */
public abstract class Tool implements MouseListener,
                                      MouseMotionListener,
                                      KeyListener
{

  @Override
  public void mouseClicked(MouseEvent e) { }

  @Override
  public void mouseEntered(MouseEvent e) { }

  @Override
  public void mouseExited(MouseEvent e) { }

  @Override
  public void mousePressed(MouseEvent e) { }

  @Override
  public void mouseReleased(MouseEvent e) { }

  @Override
  public void keyPressed(KeyEvent e) { }

  @Override
  public void keyReleased(KeyEvent e) { }

  @Override
  public void keyTyped(KeyEvent e) { }

  @Override
  public void mouseDragged(MouseEvent e) { }

  @Override
  public void mouseMoved(MouseEvent e) { }
}// end public abstract class Tool implements MouseMotionListener, ...
