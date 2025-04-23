package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		this.segments = new LinkedList<>();
		deltaX = MOVEMENT_SIZE;
		deltaY = 0;
		BodySegment segmentHead = new BodySegment(0.5, 0, SEGMENT_SIZE);
		segments.add(segmentHead);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		BodySegment head = segments.get(0);
		double oldHeadX = head.getX();
		double oldHeadY = head.getY();
		head.setX(head.getX() + deltaX);
		head.setY(head.getY() + deltaY);
		
		for (int i = 1; i < segments.size(); i++) {
			double tempX = segments.get(i).getX();
			double tempY = segments.get(i).getY();
			segments.get(i).setX(oldHeadX);
			segments.get(i).setY(oldHeadY);
			oldHeadX = tempX;
			oldHeadY = tempY;
		}
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment: segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.get(0);
		double distance = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));
		if (distance <= SEGMENT_SIZE +Food.FOOD_SIZE) {
			BodySegment tail = segments.get(segments.size()-1); 
			BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE);
			segments.add(newSegment);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.get(0);
		double headX = head.getX();
		double headY = head.getY();
		return (headX >= 0 && headX <= 1 && headY >= 0 && headY <= 1);
	}
}
