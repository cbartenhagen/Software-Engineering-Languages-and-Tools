
import java.util.Vector;

/**
 * A basic vector list that is intended to contain ToolControllers.
 *
 * Type checking is performed on object insertion, which forces a slight
 * performance penalty on program startup and for every subsequent tool that
 * is added to the list. This seems to balance extensibility with type checking
 * by confining  updates to one location if an alternative ToolController
 * class is used.
 */
public class ToolList {

  /* Class Member Variables */
  private Vector<Object> list;

  /****< Constructors >********************************************************/
  public ToolList() {
   list = new Vector<Object>(5,1);
  }

  /****< List Methods >********************************************************/
  /**
   * Adds the specified ToolController to the list
   *
   * @param item ToolController to add
   */
  public void add(ToolController item) {
    if( item != null )
    {
      list.add(item);
    }
  }

  /**
   * Creates an iterator at the beginning element of this ToolList
   *
   * @return a ToolListIterator for this ToolList
   */
  public ToolListIterator iterator() {
    return new ToolListIterator( list );
  }
}// end public class ToolList
