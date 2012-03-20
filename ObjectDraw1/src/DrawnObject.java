
public class DrawnObject {
	int topLeftX;
	int topLeftY;
	int bottomRightX;
	int bottomRightY;
	String creatorTool;
	
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

	//Constructor
	public DrawnObject(int TLX, int TLY, int BRX, int BRY, String creatorTool){
		topLeftX = TLX;
		topLeftY = TLY;
		bottomRightX = BRX;
		bottomRightY = BRY;
		this.creatorTool = creatorTool;
	}
	
	
}
