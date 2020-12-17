package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
		
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//s
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
	}

	public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
		if (newValue != null) {
			newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					if(getOnKeyReleased() != null) 
						getOnKeyReleased().handle(event);
					List<Actor> myActors = getObjects(Actor.class);
					for (GameWindow anActor: myActors) {
						if (anActor.getOnKeyReleased() != null) {
							anActor.getOnKeyReleased().handle(event);
						}
					}
				}
				
			});
			
			newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					if(getOnKeyPressed() != null) 
						getOnKeyPressed().handle(event);
					List<Actor> myActors = getObjects(Actor.class);
					for (GameWindow anActor: myActors) {
						if (anActor.getOnKeyPressed() != null) {
							anActor.getOnKeyPressed().handle(event);
						}
					}
				}
				
			});
		}
		
	};


	//Method to allow mute of music when playing game
	public void setMute() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case M:
					stopMusic();
					break;
				case P:
					playMusic();
					break;
				default:
					break;
				}
			}
		});
	}


	//Method to allow music to be played when game is running
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	//Method for music to stop when game ends
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
