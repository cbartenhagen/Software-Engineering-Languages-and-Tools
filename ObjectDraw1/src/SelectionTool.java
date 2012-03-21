import java.awt.Point;
import java.awt.event.MouseEvent;


public class SelectionTool extends Tool {
	DrawingCanvas canvas;
	protected Point startingMousePosition;
	ToolList toolList;
	
	public SelectionTool(DrawingCanvas c, ToolList l) {
	    if( c != null )
	      canvas = c;
	    else
	      throw new IllegalArgumentException();
	    
	    if( l != null )
	    	toolList = l;
	    else
	    	throw new IllegalArgumentException();
	}
	
	public void mousePressed(MouseEvent e){
		  canvas.setCurrentObject(null);
		  startingMousePosition = e.getPoint();
		  
		  int locationX = e.getX();
		  int locationY = e.getY();
		  
		  for(int i = canvas.getDrawnList().size() - 1; i >= 0; i--){
			  int TLX = canvas.getDrawnList().elementAt(i).getTopLeftX();
			  int TLY = canvas.getDrawnList().elementAt(i).getTopLeftY();
			  int BRX = canvas.getDrawnList().elementAt(i).getBottomRightX();
			  int BRY = canvas.getDrawnList().elementAt(i).getBottomRightY();
			  
			  System.out.println(locationX + ", " + locationY + "..." + TLX + ", " + TLY + "..." + BRX + ", " + BRY);
			  
			  if(TLX < locationX && BRX > locationX && TLY < locationY && BRY > locationY){
				  System.out.println("Did I Break?");
				  canvas.setCurrentObject(canvas.getDrawnList().elementAt(i));
				  break;
			  }
		  }
	  }
	  
	  public void mouseDragged(MouseEvent e){
		  int differenceX = e.getX()-startingMousePosition.x;
		  int differenceY = e.getY()-startingMousePosition.y;
		  
		  if(canvas.getCurrentObject() != null){
			  ToolListIterator iter = toolList.iterator();
			  
			  Tool thisTool = null;
			  
			  while(iter.hasNext()){
				  thisTool = ((ToolController) iter.next()).getTool();
				  if(canvas.getCurrentObject().getCreatorTool().equals(thisTool.getName())){
					  thisTool.clearThis(canvas.getCurrentObject());
				  }
			  }
			  
			  if(canvas.getCurrentObject() != null){
				  canvas.getCurrentObject().setTopLeftX(canvas.getCurrentObject().getTopLeftX() + differenceX);
				  canvas.getCurrentObject().setTopLeftY(canvas.getCurrentObject().getTopLeftY() + differenceY);
				  canvas.getCurrentObject().setBottomRightX(canvas.getCurrentObject().getBottomRightX() + differenceX);
				  canvas.getCurrentObject().setBottomRightY(canvas.getCurrentObject().getBottomRightY() + differenceY);
			  }
			  
			  if(thisTool != null){
				  thisTool.drawThis(canvas.getCurrentObject());
			  }
			  
			  startingMousePosition.x = e.getX();
			  startingMousePosition.y = e.getY();
		  }
	  }
	
}