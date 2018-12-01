package Hackathon;

public class Rect {
	int width; 
	int height;
	public Rect(int w, int h) {
		this.width = w;
		this.height = h;
		
	}
	
	public boolean collides(){
		return false;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
}
