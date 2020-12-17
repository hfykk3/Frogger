package hud;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stud
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/p4_group_8_repo/End.png", 60, 60, true, true));
	}
	/*
	 * This sets image of frog when frog reaches end destination
	 */
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
