package entity;

import javafx.scene.image.Image;

public class TurtleRefactored {
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private int speed;

	public TurtleRefactored() {
	}

	public Image getTurtle1() {
		return turtle1;
	}

	public void setTurtle1(Image turtle1) {
		this.turtle1 = turtle1;
	}

	public Image getTurtle2() {
		return turtle2;
	}

	public void setTurtle2(Image turtle2) {
		this.turtle2 = turtle2;
	}

	public Image getTurtle3() {
		return turtle3;
	}

	public void setTurtle3(Image turtle3) {
		this.turtle3 = turtle3;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}