package entity;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class WetTurtle extends Actor{
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(data.getTurtle2());
					data.setSunk(false);
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(data.getTurtle1());
					data.setSunk(false);
				}
				else if (now/900000000 %4 == 2) {
					setImage(data.getTurtle3());
					data.setSunk(false);
				} else if (now/900000000 %4 == 3) {
					setImage(data.getTurtle4());
					data.setSunk(true);
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
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		data.setTurtle1(new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", w, h, true, true));
		data.setTurtle2(new Image("file:src/p4_group_8_repo/TurtleAnimation2Wet.png", w, h, true, true));
		data.setTurtle3(new Image("file:src/p4_group_8_repo/TurtleAnimation3Wet.png", w, h, true, true));
		data.setTurtle4(new Image("file:src/p4_group_8_repo/TurtleAnimation4Wet.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		data.setSpeed(s);
		setImage(data.getTurtle2());
	}
	
	public boolean isSunk() {
		return data.isSunk();
	}
}
