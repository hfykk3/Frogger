package entity;

import java.util.ArrayList;

import hud.End;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Actor;


public class Animal extends Actor {
	Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
	int points = 0, end = 0, carD = 0,
		imgSize = 40;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2, 
			movementX = 10.666666*2;
	boolean carDeath = false, waterDeath = false,
			stop = false, changeScore = false;
	double w = 800;
	
	ArrayList<End> inter = new ArrayList<End>();
	
	
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png", imgSize, imgSize, true, true);
		
		
		/*
		 * This tells the program what the frog should be doing
		 * when the user presses one of the respective keycode or not2
		 */
		setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
			public void handle(KeyEvent event)
			{
				if (noMove) {
					
				}
				else 
				{
				if (second) 
				{
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	second = false;
	           }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	@Override
	public void act(long now) 
	{
		int bounds = 0;
		if (getY()<0 || getY()>734) 
		{
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) 
		{
			move(movement*2, 0);
		}
		/*
		 * This if statement tells program to show image of frog's death if it hits a vehicle
		 */
		if (carDeath) 
		{
			noMove = true;
			if ((now)% 11 ==0) 
			{
				carD++;
			}
			if (carD==1)
			{
				setImage(new Image("file:src/p4_group_8_repo/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) 
			{
				setImage(new Image("file:src/p4_group_8_repo/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) 
			{
				setImage(new Image("file:src/p4_group_8_repo/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) 
			{
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) 
				{
					points-=50;
					changeScore = true;
				}
			}
			
		}
		/*
		 * This if statement tells program to show image of frog's death when it jumps 
		 * into the water and dies
		 */
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) 
			{
				carD++;
			}
			if (carD==1) 
			{
				setImage(new Image("file:src/p4_group_8_repo/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) 
			{
				setImage(new Image("file:src/p4_group_8_repo/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) 
			{
				setImage(new Image("file:src/p4_group_8_repo/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) 
			{
				setImage(new Image("file:src/p4_group_8_repo/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) 
			{
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
		//This makes frog go back to its previous position if user tries to go beyond border created
		if (getX()>600) 
		{
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) 
		{
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) 
		{
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) 
		{
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) 
		{
			//If frog stays on wet turtle for too long, frog dies of water
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) 
			{
				waterDeath = true;
			} else 
			{
				move(-1,0);
			}
		}
		//This makes program go to end screen of the game
		else if (getIntersectingObjects(End.class).size() >= 1) 
		{
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) 
			{
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413)
		{
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
	public boolean getStop() 
	{
		return end==5;
	}
	
	public int getPoints() 
	{
		return points;
	}
	
	public boolean changeScore() 
	{
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
