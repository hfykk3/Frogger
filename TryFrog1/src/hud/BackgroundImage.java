package hud;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
	
		
	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 900, true, true));
		
	}

}
