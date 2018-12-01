package Hackathon;

public class Rect {
	int width; 
	int height;
	
	// Array of points. Bottom-left, Bottom-right, top-left, top-right
	Point points[] = new Point[4];
	
	public Rect(int w, int h) {
		this.width = w;
		this.height = h;
		
	}
	
	public boolean collides(Rect other){
		
		return false;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	double cosineLawRev() {
		return 0.0d;
	}
	
}
