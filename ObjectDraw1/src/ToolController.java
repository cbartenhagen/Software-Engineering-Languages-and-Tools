
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;


/**
 * Maps tool selection to a specific tool.
 *
 * Provides tool selection ability for any visual components that utilize
 * AbstractAction's. This is especially important as it allows for the addition
 * of a new Tool without rewriting a new ToolController.
 *
 * In summary, an AbstractAction is an object recognized by smart containers
 * such as JMenuBar's and JToolBar's.  These containers automatically register
 * the associate listeners and extract any information necessary to properly
 * display the object.
 *
 * For more information, consult the Java API for AbstractAction.
 */
@SuppressWarnings("serial")
public class ToolController extends AbstractAction {

  protected DrawingCanvas canvas;
  protected Tool tool;

  /****< Constructors >********************************************************/
  /**
   * Initializes a ToolController as specified.
   *
   * @param name Name of the tool which will appear on any menu containers
   * @param icon Icon which will appear in any tool bar containers
   * @param tip Tooltip help text that will appear on mouse hover
   * @param c Reference to the DrawingCanvas of the Tool
   * @param t Reference to the Tool which should be active upon selection
   */
  public ToolController(String name, Icon icon, String tip,
		        DrawingCanvas c, Tool t) {
    super(name, icon);
    tool = t;
    putValue(Action.DEFAULT, icon);
    putValue(Action.SHORT_DESCRIPTION, tip);
    setEnabled(tool != null);
    canvas = c;
  }

  /**
   * Fires whenever an action is performed, i.e. mouse click, on the controler's
   * view, i.e container.
   *
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent e) {
    canvas.setcurrentTool(tool);
  }
}// end public class ToolController extends AbstractAction
