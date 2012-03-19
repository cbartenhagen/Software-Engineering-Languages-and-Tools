
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Panel which provides options for clearing the canvas and selecting the
 * current drawing tool.
 */
@SuppressWarnings("serial")
public class ControlPanelView extends JPanel {

  /* Class members */
  protected DrawingCanvas canvas;
  protected ControlPanelController CPcontroller;
  protected JButton clearButton;
  protected JComboBox comboBox;

  /****< Constructors >********************************************************/

  /**
   * Adds the clear canvas button and color combo box for selecting the
   * drawing color.  Creates and registers the view's controller.
   *
   * @param c reference to the associated DrawingCanvas
   */
  public ControlPanelView(DrawingCanvas c) {
	if( c == null )
	  throw new IllegalArgumentException();

    canvas = c;
    clearButton = new JButton("Clear");
    add(clearButton);
    add(new JLabel("Pen color"));
    comboBox = new JComboBox();
    comboBox.addItem("black");
    comboBox.addItem("blue");
    comboBox.addItem("green");
    comboBox.addItem("red");
    add(comboBox);
    ControlPanelController CPcontroller = createControlPanelController();
    addControlPanelListener(CPcontroller);
  }

  /****< Controller Methods >**************************************************/
  /**
   * Creates a controller associated with this view's canvas.
   *
   * This is implemented separately from addControlPanelListener() in the
   * event that a controller for a subclass of this view differs from this
   * view's controller.  For example, adding a different component to a
   * ControlPanelView would require a different controller.
   *
   * @return new controller
   */
  protected ControlPanelController createControlPanelController() {
    return new ControlPanelController(canvas);
  }

  /**
   * Registers a ControlPanelController with this view's components.
   *
   * This is implemented separately from createControlPanelController() in the
   * event that a view subclass requires different listener registration for
   * the components displayed on that view.
   *
   * @param listener controller to register
   */
  protected void addControlPanelListener(ControlPanelController listener)  {
	  if( listener != null ) {
      clearButton.addActionListener((ActionListener)listener);
      comboBox.addItemListener((ItemListener)listener);
	  } else {
	    throw new IllegalArgumentException();
    }// end argument check
  }// end protected void addControlPanelListener( EventListener )
}// end public class ControlPanelView extends JPanel
