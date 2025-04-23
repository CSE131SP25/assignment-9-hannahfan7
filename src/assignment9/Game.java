package assignment9;

import java.awt.event.KeyEvent;
import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.food = new Food();
		this.snake = new Snake();	
		
	}
	
	public void play() {
		while (snake.isInbounds()) {
			int dir = getKeypress();
			snake.changeDirection(dir);;
			snake.move();
			food.draw();
			
			if (snake.eatFood(food)) {
				food = new Food();
			}
			updateDrawing();
			System.out.println("Keypress: " + dir);
		}
		
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			displayGameOver();
	}
	private void displayGameOver() {
		StdDraw.clear();
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(0.5,  0.5,  "Game Over! Snake died!");
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.pause(50);
		StdDraw.show();
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5,  0.5, "Play the Snake Game! Press Space to Begin.");
		StdDraw.text(0.50,  0.40, "Controls: W A S D");
		StdDraw.show();
		
		while (true) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				Game g = new Game();
				g.play();
			}
			StdDraw.pause(10);
		}
	}
}
