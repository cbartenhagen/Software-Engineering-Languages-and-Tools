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
	
	/*
	 * (non-Javadoc)
	 * 
	 * Goes through the drawn objects on the canvas and selects the object that is surrounding the mouse click.
	 * 
	 * @see Tool#mousePressed(java.awt.event.MouseEvent)
	 */
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
			  
			  if(TLX < BRX){
				  if(TLY < BRY){
					  TLX -= 10;
					  TLY -= 10;
					  BRX += 10;
					  BRY += 10;
				  }
				  else{
					  TLX -= 10;
					  TLY += 10;
					  BRX += 10;
					  BRY -= 10;
				  }
			  }
			  else{
				  if(TLY < BRY){
					  TLX += 10;
					  TLY -= 10;
					  BRX -= 10;
					  BRY += 10;
				  }
				  else{
					  TLX += 10;
					  TLY += 10;
					  BRX -= 10;
					  BRY -= 10;
				  }
			  }
			  
			  System.out.println(locationX + ", " + locationY + "..." + TLX + ", " + TLY + "..." + BRX + ", " + BRY);
			  
			  if(TLX < BRX){
				  if(TLY < BRY){
					  if(TLX < locationX && BRX > locationX && TLY < locationY && BRY > locationY){
						  System.out.println("Did I Break?");
						  canvas.setCurrentObject(canvas.getDrawnList().elementAt(i));
						  break;
					  }
				  }
				  else{
					  if(TLX < locationX && BRX > locationX && TLY >= locationY && BRY <= locationY){
						  System.out.println("Did I Break?");
						  canvas.setCurrentObject(canvas.getDrawnList().elementAt(i));
						  break;
					  }
				  }
			  }
			  else if(TLX >= BRX){
				  if(TLY < BRY){
					  if(TLX > locationX && BRX < locationX && TLY < locationY && BRY > locationY){
						  System.out.println("Did I Break?");
						  canvas.setCurrentObject(canvas.getDrawnList().elementAt(i));
						  break;
					  }
				  }
				  else{
					  if(TLX > locationX && BRX < locationX && TLY >= locationY && BRY <= locationY){
						  System.out.println("Did I Break?");
						  canvas.setCurrentObject(canvas.getDrawnList().elementAt(i));
						  break;
					  }
				  }
			  }
		  }
	  }
	  
	/*
	 * (non-Javadoc)
	 * 
	 * Drag around current object, unless the mouse is within 10 pixels of one of the corners, then resize.
	 * 
	 * @see Tool#mouseDragged(java.awt.event.MouseEvent)
	 */
	  public void mouseDragged(MouseEvent e){
		  int differenceX = e.getX()-startingMousePosition.x;
		  int differenceY = e.getY()-startingMousePosition.y;
		  
		  //check if there was an object selected
		  if(canvas.getCurrentObject() != null){
			  int TLX = canvas.getCurrentObject().getTopLeftX();
			  int TLY = canvas.getCurrentObject().getTopLeftY();
			  int BRX = canvas.getCurrentObject().getBottomRightX();
			  int BRY = canvas.getCurrentObject().getBottomRightY();
			  
			  //check if within one of the four corners
			  if(Math.sqrt(Math.pow(startingMousePosition.x - BRX, 2) + Math.pow(startingMousePosition.y - BRY, 2)) <= 10){
				  canvas.getCurrentObject().setBottomRightX(canvas.getCurrentObject().getBottomRightX() + differenceX);
				  canvas.getCurrentObject().setBottomRightY(canvas.getCurrentObject().getBottomRightY() + differenceY);
				  System.out.println("point1");
			  }
			  else if(Math.sqrt(Math.pow(startingMousePosition.x - TLX, 2) + Math.pow(startingMousePosition.y - TLY, 2)) <= 10){
				  canvas.getCurrentObject().setTopLeftX(canvas.getCurrentObject().getTopLeftX() + differenceX);
				  canvas.getCurrentObject().setTopLeftY(canvas.getCurrentObject().getTopLeftY() + differenceY);
				  System.out.println("point2");
			  }
			  else if(Math.sqrt(Math.pow(startingMousePosition.x - BRX, 2) + Math.pow(startingMousePosition.y - TLY, 2)) <= 10){
				  canvas.getCurrentObject().setBottomRightX(canvas.getCurrentObject().getBottomRightX() + differenceX);
				  canvas.getCurrentObject().setTopLeftY(canvas.getCurrentObject().getTopLeftY() + differenceY);
				  System.out.println("point3");
			  }
			  else if(Math.sqrt(Math.pow(startingMousePosition.x - TLX, 2) + Math.pow(startingMousePosition.y - BRY, 2)) <= 10){
				  canvas.getCurrentObject().setTopLeftX(canvas.getCurrentObject().getTopLeftX() + differenceX);
				  canvas.getCurrentObject().setBottomRightY(canvas.getCurrentObject().getBottomRightY() + differenceY);
				  System.out.println("point4");
			  }
			  
			  else{  //just move it
				  canvas.getCurrentObject().setTopLeftX(canvas.getCurrentObject().getTopLeftX() + differenceX);
				  canvas.getCurrentObject().setTopLeftY(canvas.getCurrentObject().getTopLeftY() + differenceY);
				  canvas.getCurrentObject().setBottomRightX(canvas.getCurrentObject().getBottomRightX() + differenceX);
				  canvas.getCurrentObject().setBottomRightY(canvas.getCurrentObject().getBottomRightY() + differenceY);
			  }
			  
			  canvas.update();
		  }
		  
		  startingMousePosition.x = e.getX();
		  startingMousePosition.y = e.getY();
	  }
	
}