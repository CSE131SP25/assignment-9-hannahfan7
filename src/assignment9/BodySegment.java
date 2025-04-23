package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = Color.blue;
		//See ColorUtils for some color options (or choose your own)
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getSize() {
		return this.size;
	}
	public void setX(double X) {
		this.x = X;
	}
	public void setY(double Y) {
		this.y = Y;
	}
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.setPenRadius(this.size);
		StdDraw.filledCircle(this.x, this.y, this.size);
	}
	
	
}
