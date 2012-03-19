

import java.util.Enumeration;

/**
 * Provides an iterator for a ToolList.
 *
 * Iterates over an Enumeration of generic objects for a similar reason that
 * the ToolList stores generic Objects. This helps minimize the number of places
 * the code needs to be changed in the event a different ToolController class
 * is used.
 */
public class ToolListIterator {

  /* Class Member Variables */
  private Enumeration<Object> enumer;

  /****< Constructor >*********************************************************/
  /**
   * Creates an iterator for the specified ToolList
   *
   * @param list ToolList to iterate over
   */
  public ToolListIterator(java.util.Vector<Object> list) {
    enumer = list.elements();
  }

  /****< Iterator Methods >****************************************************/
  /**
   * Checks if more elements are present
   *
   * @return true if the list contains more elements
   */
  public boolean hasNext() {
    return enumer.hasMoreElements();
  }

  /**
   * Fetches the next element advancing the iterator by one location
   *
   * @return the next element in the list
   */
  public Object next() {
    return enumer.nextElement();
  }
}// end public class ToolListIterator
