public class Rectangle {
	int x;
	int y;
	int width;
	int height;
	public Rectangle(int rX, int rY, int rWidth, int rHeight) {
		if (rWidth < 0 || rHeight < 0) {
			throw new IllegalArgumentException("Width/Height must be positive.");
		}
		x = rX;
        y = rY;
		width = rWidth;
        height = rHeight;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public String toString() {
		return "Rectangle[x=" + x + ",y=" + y + ",width=" + width + ",height=" + height + "]";
	}
}
