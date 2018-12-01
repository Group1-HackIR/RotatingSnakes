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

	public boolean collides(Rect other) {
		double[] md = midPoint(points[0], points[3]);
		Point otherPoints[] = other.getPoints();

		// top-left ---> top-right
		if (inRangePoint(otherPoints[2], otherPoints[3], md, 31.5 / 2)
							|| 	
		// bottom-left ---> bottom-right
		inRangePoint(otherPoints[2], otherPoints[3], md, 31.5 / 2)) {
			
		}

		return false;
	}

	boolean inRangePoint(Point p1, Point p2, double[] center, double radius) {
		if(inRange(center[0], center[0] + radius, p1.getX()) && inRange(center[1], center[1] + radius, p1.getY())) {
			System.out.println("IN RANGE.");
		}
		
		return false;
	}
	boolean inRange(double center, double d, double e) {
		return center < e && e < d;
	}
	
	boolean inRangeEQ(double min, double max, double test) {
		return min < test && test < max;
	}

	double[] midPoint(Point p1, Point p2) {
		return new double[] { (p1.getY() + p2.getY()) / 2, (p1.getX() + p1.getY()) / 2 };
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

	public void setPoints(Point[] points) {
		this.points = points;
	}

	public Point[] getPoints() {
		return points;
	}

}
