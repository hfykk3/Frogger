package entity;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class Turtle extends Actor{
	TurtleRefactored data = new TurtleRefactored();
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(data.getTurtle2());
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(data.getTurtle1());
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(data.getTurtle3());
					
				}
			
		move(data.getSpeed() , 0);
		if (getX() > 600 && data.getSpeed()>0)
			setX(-200);
		if (getX() < -75 && data.getSpeed()<0)
			setX(600);
	}
	/*
	 * This method gets turtle image and sets its speed
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		data.setTurtle1(new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", w, h, true, true));
		data.setTurtle2(new Image("file:src/p4_group_8_repo/TurtleAnimation2.png", w, h, true, true));
		data.setTurtle3(new Image("file:src/p4_group_8_repo/TurtleAnimation3.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		data.setSpeed(s);
		setImage(data.getTurtle2());
	}
}
