package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameWindow extends ImageView {

	public GameWindow() {
		super();
	}

	public GameWindow(String arg0) {
		super(arg0);
	}

	public GameWindow(Image arg0) {
		super(arg0);
	}

	public double getWidth() {
	    return this.getBoundsInLocal().getWidth();
	}

	public double getHeight() {
	    return this.getBoundsInLocal().getHeight();
	}

}