package p4_group_8_repo;


import java.io.FileReader;
import java.io.IOException;

import entity.Animal;
import entity.Log;
import entity.Obstacle;
import entity.Turtle;
import entity.WetTurtle;
import hud.BackgroundImage;
import hud.Digit;
import hud.End;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main extends Application {
	private AnimationTimer timer;
	private Pane root;
	private MyStage game;
	private MyStage menu;
	private MyStage help;
	Animal animal;
	

	
	public static void main(String[] args) 
	{		
		launch(args);
	}	

	    

	/*
	 * Sets up a scene for the program and shows background
	 * along with the pixels for the border of game window
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	      /*
	       * This creates a layout for the menu  
	       */
		 primaryStage.setTitle("FROGGER");
         Button start = new Button("PRESS TO START");
         Button start1 = new Button("HELP");
         start.setStyle("-fx-background-color: #1EE70A;");
         VBox border = new VBox();
         
         border.setSpacing(700);
         
   
         border.setMargin(start, new Insets(100, 100, 100, 100));
         border.setMargin(start1, new Insets(10,10, 10, 10) );
         
         ObservableList list = border.getChildren();
         
         list.addAll(start, start1);
         
         Scene menu = new Scene(border);
         
         primaryStage.setScene(menu);
         primaryStage.show();
         
	     /*
	      * This method gives you a help option
	      * to show you how to play
	      */
         EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()	{
        	 public void handle(ActionEvent e)
        	 {
        		 help = new MyStage();
        		 Scene scene = new Scene(help,600,800);
        		 
        		
        		 System.out.println("RULES!!!!");
        		 System.out.println("Use W, A, S, D to move");
        		 System.out.println("Try to get to the end without getting hit by the car");
        		 System.out.println("Do not jump into the water");
        		 System.out.println("Try to occupy all five holes");
        		 
        		
        	 }
         };
		 
         start1.setOnAction(event);
     	
         
       
         /*
          * This method allows itself to enter the game when a button is pushed
          */
      EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>()	{
    	  public void handle(ActionEvent e)
    	  {
    		  game = new MyStage();
     		    Scene scene  = new Scene(game,600,800);
     		
     		
     			BackgroundImage frogBG = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW.png");
     		    
     			game.add(frogBG);
     			
     			game.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
     			game.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 220, 166, 0.75));
     			game.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 440, 166, 0.75));
     			game.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
     			game.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 0, 276, -2));
     			game.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 400, 276, -2));
     			game.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
     			game.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 50, 329, 0.75));
     			game.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 270, 329, 0.75));
     			game.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 490, 329, 0.75));
     			game.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
     			game.add(new Turtle(500, 376, -1, 130, 130));
     			game.add(new Turtle(300, 376, -1, 130, 130));
     			game.add(new WetTurtle(700, 376, -1, 130, 130));
     			game.add(new WetTurtle(600, 217, -1, 130, 130));
     			game.add(new WetTurtle(400, 217, -1, 130, 130));
     			game.add(new WetTurtle(200, 217, -1, 130, 130));
     			game.add(new End(13,96));
     			game.add(new End(141,96));
     			game.add(new End(141 + 141-13,96));
     			game.add(new End(141 + 141-13+141-13+1,96));
     			game.add(new End(141 + 141-13+141-13+141-13+3,96));
     			
     			animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
     			
     			game.add(animal);
     			game.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 0, 649, 1, 120, 120));
     			game.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 300, 649, 1, 120, 120));
     			game.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 600, 649, 1, 120, 120));
     			game.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
     			game.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 597, -1, 50, 50));
     			game.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 597, -1, 50, 50));
     			game.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 597, -1, 50, 50));
     			game.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 597, -1, 50, 50));
     			game.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 540, 1, 200, 200));
     			game.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 540, 1, 200, 200));
     			game.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 490, -5, 50, 50));
     			game.add(new Digit(0, 30, 360, 25));
     			
     			game.start();
     			primaryStage.setScene(scene);
     	        primaryStage.show();
     	        start();
    	  }
      };
    		
      start.setOnAction(event1);
    	 }
    	

	
			

 



	/**private void displayMenu(Stage primaryStage) {
		main_menu = new MyStage();
		Scene mainMenu = new Scene (main_menu, 600, 800);
		BackgroundImage ImageBack = new BackgroundImage("file:src/p4_group_8_repo/START SCREEN.png");
		main_menu.add(ImageBack);
		
		main_menu.start();
		
		primaryStage.setScene(mainMenu);
		primaryStage.show();
		
		
	}
**/
	/*
	 * Reads File and loads the highscore into a file
	 */
	public void saveScore() throws IOException {
		   int i, space = 0;
		   try (FileReader variable= new FileReader("HIGHSCORES")) {
			   while ((i = variable.read()) != -1) {
				   int char2int = (char)i - '0';
				   game.add(new Digit(char2int, 130 - space, 30, char2int));
				   space-=20;
			   }
		   }
		   catch(IOException e) {
			   System.out.println("No File to be Detected");
		   }
		  }


	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	/*This is when the frog entity stops moving which also include the program
            	 * The music stops and it will display an alert box which displays
            	 * your highscore
            	 */
            	if (animal.getStop()) {
            		System.out.print("STOP:");
            		getBackground().stopMusic();
            		stop();
            		getBackground().stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
    
            		alert.show();
            	}
            }
        };
    }
	//Method for starting the program
	public void start() {
		getBackground().playMusic();
		getBackground().setMute();
    	createTimer();
        timer.start();
    }
	//Method for stopping the program
    public void stop() {
        timer.stop();
        
        
    }
    

    
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  getBackground().add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }

	MyStage getBackground() {
		return game;
	}

	void setBackground(MyStage background) {
		this.game = background;
	}
};
	
		
