
import javax.swing.*;


/**
 * Provides a Menu-type view displaying the MiniDraw Tools supplied.  Menus
 * are general hierarchical and display options via text sometimes accompanied
 * by icons.
 *
 *
 * Displays the associated buttons tools within the supplied ToolList.  The
 * ToolList itself contains the various tool controllers that will be associated
 * with this view.
 *
 * For more details, see the documentation of ToolController and ToolList.
 */
@SuppressWarnings("serial")
public class MenuBarView extends JMenuBar {

  /**
   * Constructor
   *
   * Registers the tools provided in the actions list for display as menu
   * options. This constructor should not be accessed directly, but rather, the
   * factory method provided by MiniDraw should be used.
   *
   * Only ToolControllers that are enabled, i.e. the tool is not null, are added
   * to the ToolBar.
   *
   * @param actions associated MiniDraw tools
   * @return Initialized MenuBarView
   */
  MenuBarView(ToolList actions) {
    JMenu toolMenu = new JMenu("Tool");
    ToolListIterator iter = actions.iterator();
    while(iter.hasNext()) {
      Action a = (Action) iter.next();
      if( a.isEnabled() )
        toolMenu.add(a);
    }// end tools remain
    add(toolMenu);
  }// end __ MenuBarView( ToolList )
}// end public class MenuBarView extends JMenuBar
