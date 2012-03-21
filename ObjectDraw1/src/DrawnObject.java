import java.awt.Color;


public class DrawnObject {
	int topLeftX;
	int topLeftY;
	int bottomRightX;
	int bottomRightY;
	String creatorTool;
	Color color;
	
	public int getTopLeftX() {
		return topLeftX;
	}

	public void setTopLeftX(int topLeftX) {
		this.topLeftX = topLeftX;
	}

	public int getTopLeftY() {
		return topLeftY;
	}

	public void setTopLeftY(int topLeftY) {
		this.topLeftY = topLeftY;
	}

	public int getBottomRightX() {
		return bottomRightX;
	}

	public void setBottomRightX(int bottomRightX) {
		this.bottomRightX = bottomRightX;
	}

	public int getBottomRightY() {
		return bottomRightY;
	}

	public void setBottomRightY(int bottomRightY) {
		this.bottomRightY = bottomRightY;
	}

	public String getCreatorTool() {
		return creatorTool;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	//Constructor
	public DrawnObject(int TLX, int TLY, int BRX, int BRY, String creatorTool, Color color){
		topLeftX = TLX;
		topLeftY = TLY;
		bottomRightX = BRX;
		bottomRightY = BRY;
		this.creatorTool = creatorTool;
		this.color = color;
	}
	
	
}
