package duckwars;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.io.File;

import java.text.DecimalFormat;

import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * Title: 			Duck Wars
 * 
 * Date Written:	10/9/2017 - 12/15/2017
 * 
 * Due Date:		12/15/2017 @ 2:00PM - 3:50PM
 * 
 * Student: 		Elaine Schultz
 * 
 * Instructor: 		Steve Harper 
 * 
 * Compiler:		Eclipse IDE for Java Developers
 * Version:			Oxygen.1a Release (4.7.1a)
 * Build id: 		20171005-1200
 * OS: 				Windows 8.1, v.6.3, x86_64 / win32
 * 
 * Description:		Duck Wars is a two-dimensional game that requires collision and dodging.
 * 					The player controls man’s best friend, the dog, and bites those ducks who
 * 					claimed war among humanity because of Duck Season. The player’s arsenal is biting.
 * 					There is a wave of ducks per level; however, the ducks are able to fire back with
 * 					their own poo. The ducks begin from emerging out of their pond, at the top of the screen.
 * 					Do not allow them get to the ground; if they are successful of taking down man’s
 * 					loyal companion first then its game over.
 * 					
 * 					The goal of the player is to defeat	all the ducks without dying or to prevent the ducks
 * 					reaching the ground. The player earns one hundred points when colliding with the duck, but
 * 					can lose points	and health when hit by duck doo-doo. (-50 Health and -25 points from Score.)
 * 					The maximum points for health is five hundred.
 *
 * Adjustments:		12/16/2017 - Corrected some error spellings, added in one integer called
 * 					maxLevel for ease of value adjustment. Now the maximum level is easily changeable.
 * 					Three new methods were created called removeDucks(), resetGame(), and playAgain().
 * 					Lastly, a new imageicon called tryAgain was created for the JOptionPane for Yes & No.
 * 					Using the same image from SSB4 which came from SMASH Wiki.
 * 
 * Credit belongs to the following sources for coding information which helped run this Java Game.
 * 
 * Instructor:		Professor Harper for explaining flowcharts and diagrams with Java,
 * 					collision detection, methods and parameters. And thank you for allowing us to test
 * 					and use code examples from your DolphinHelp Java game.
 * 
 * 					Evaluation from December 15, 2017:
 * 					Feedback for making a method to reset the game was completed at December 16th
 * 					and tested which works better versus restarting the whole game. Lastly, to mention
 * 					when overhearing my professor mentioning ideas with Duck Hunt.
 *
 * Students:		Thanks to Andrew and Torie for mentioning about the NES classic game called Duck Hunt.
 * 
 * Book Sources:	PROGRAMMING VIDEO GAMES FOR THE EVIL GENIUS by Ian Cinnamon.
 * 					Credit for explaining and example of code from games called Snake Pit
 * 					and	Space Destroyers. The use of For Loops, JLabels, ImageIcons, ArrayLists and setBounds
 * 					with the keyboard between the mouse. The mouse was temporary used and removed later.
 * 					ISBN: 978-0-07-149752-7
 * 					MHID: 0-07-149752-8
 * 					Publisher: McGraw-Hill Education; 1 edition (February 29, 2008)
 * 					Available to purchase:
 * 					https://www.mhprofessional.com/9780071497527-usa-programming-video-games-for-the-evil-genius-group
 * 					https://www.amazon.com/Programming-Video-Games-Evil-Genius/dp/0071497528
 * 
 * 					Advanced Do-It-Yourself Java Games: An Introduction to Java Threads and Animated Video Games (Book 3)
 * 					by Annette Godtland.
 * 					Credit for explaining and examples about Classes, JOptionPane, Methods, Keyboard, Thread, and Timer.
 *					ISBN: 978-1537130972
 *					Publisher: Godtland Software Corporation, Publishing Division; 1st edition (August, 16 2016)
 *					Website: http://www.godtlandsoftware.com/DIYJava/index.html
 *					Available to purchase: https://www.amazon.com/dp/1537130978
 * 
 * Online Sources:	The following credit for explanations, use of examples, converters, images and sound:
 * 
 * 					Duck Hunt from Wikipedia:
 * 					https://en.wikipedia.org/wiki/Duck_Hunt
 * 
 * 					Original Duck Hunt (SSB4) image came from "SMASH" Wiki:
 * 					https://www.ssbwiki.com/Duck_Hunt_(SSB4)
 * 
 * 					Duck Hunt sounds came from the following source:
 * 					https://downloads.khinsider.com/game-soundtracks/album/duck-hunt
 * 					Submitted by Mr. ATLien
 * 
 * 					Converted MP3 audio to WAV:
 * 					https://audio.online-convert.com/convert-to-wav
 * 					
 * 					Class Thread:
 * 					https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
 * 
 * 					Class JOptionPane:
 * 					https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * 
 * 					Java: How to play .wav files:
 * 					https://www.youtube.com/watch?v=QVrxiJyLTqU
 * 					Credit for explaining and demonstration by user JavaTutorials101
 * 
 * 					How to restart the game in Java[duplicate]
 * 					https://stackoverflow.com/questions/37436784/how-to-restart-the-game-in-java
 * 					Suggestion from user eldo (The last posted comment that mentions separate method.)
 * 
 * Personal Notes:	I acknowledge this game is only a starting point when working with 2D graphics.
 * 					Majority of the images were created	by Photoshop CS5. This game can lag depending
 * 					upon the computer hardware. Suggestion is to use the java.util.Timer instead of
 * 					Thread sleep intervals. It's not bug free and super smooth game, but it gives an
 * 					idea and the concept of what a Java game can do.
 * 
 * Hardware Spec:	The following computer hardware was tested with an i7-4790K paired with 32GB memory,
 * 					1TB 850 SSD, and a GTX 1070 8GB. Lag isn't too noticeable for a low population of ducks.
 * 					Lag can occur any time, but it's very noticeable with non-dedicated graphics.
 * 					In other words, integrated graphics alone may lag more with this game.
 */
@SuppressWarnings("serial")
public class DuckWarsGame extends JFrame implements KeyListener {
	//height and width
	public static final int HEIGHT = 806;
	public static final int WIDTH = 719;
	//Inner Class
	private Play play = new Play();
	//this holds the components
	private Container con;
	//The current level.
	private int currentLevel = 1;
	/*Set the maximum level.
	 * Change this value only, not currentLevel.
	 * The integer must be a value of 2 or more.
	 */
	private int maxLevel = 10;
	//The number of ducks and multiples per level.
	private int numOfDucks = 1;
		
	//this holds the ducks.
	private ArrayList<JLabel> ducks = new ArrayList<JLabel>();
	//this holds the bullets of the enemies
	private ArrayList<JLabel> duckDooDoos = new ArrayList<JLabel>();
	
	//Icon images for the application.
	private ImageIcon icon = new ImageIcon("icon.PNG");
	private ImageIcon tryAgain = new ImageIcon("tryAgain.PNG");
	//Icon images for the dog.
	private ImageIcon dogImg = new ImageIcon("dog.PNG");
	private ImageIcon dogHit = new ImageIcon("dogHit.PNG");
	private ImageIcon dogLaugh = new ImageIcon("dogLaugh.PNG");
	private ImageIcon dogDied = new ImageIcon("deadDog.PNG");
	private ImageIcon dogWon = new ImageIcon("dogWon.PNG");
	private ImageIcon happyDog = new ImageIcon("happyDog.PNG");
	//Icon images for the ducks.
	private ImageIcon duckImg = new ImageIcon("blueDuck.PNG");
	private ImageIcon duckHit = new ImageIcon("blueDuckHit.PNG");
	private ImageIcon duckWon = new ImageIcon("duckWon.PNG");
	//this is the duck doo-doo's image.
	private ImageIcon duckDooImg = new ImageIcon("duckDooDoo.PNG");

	//JLabel's dog player image.
	private JLabel dog = new JLabel(dogImg);
	//JLabel's Background image.
	private JLabel background = new JLabel(new ImageIcon("background.PNG"));
	
	//The Score.
	private static int scoreTotal = 0;
	private JLabel score = new JLabel("Score: " + scoreTotal);
	private DecimalFormat dF = new DecimalFormat("#,###");
	//Dog's Health.
	private static int healthTotal = 500;
	private JLabel health = new JLabel("Health: " + healthTotal);
	//JLabel's Current Level
	private JLabel nextLevel = new JLabel("Level: " + currentLevel);
	
	//Transparent the mouse cursor by 16x16
	private BufferedImage mouseCursor = new BufferedImage(16,16, BufferedImage.TYPE_INT_ARGB);
	//Sound effects.
	private File gameOver = new File("gameOver.wav");
	private File bark = new File("bark.wav");
	private File quack = new File("quack.wav");
	private File roundCleared = new File("roundCleared.wav");
	private File failed = new File("youFailed.wav");
	
	// constructor of DuckWarsGame
	public DuckWarsGame() {
		super("Duck Wars");
		setIconImage(icon.getImage());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(HEIGHT,WIDTH);
		setLocationRelativeTo(null);
		setResizable(false);
		
		con = getContentPane();
		con.setLayout(null);
		setContentPane(con);
		// Creates the invisible cursor
        Cursor hiddenMouse = Toolkit.getDefaultToolkit().createCustomCursor(mouseCursor, new Point(0,0), "blank cursor");
		// Sets the invisible mouse cursor to the JFrame (must getContentPane from JFrame)
        con.setCursor(hiddenMouse);
		
		// Sets up the positions, colors, font type and size.
        // Added into Content Pane
        health.setBounds(10,655,100,30); //10,10,100,30
        health.setForeground(Color.WHITE);
        health.setFont(new Font("Arial",Font.BOLD,18));
        con.add(health);
        score.setBounds(150,655,1000,30);
        score.setForeground(Color.WHITE);
        score.setFont(new Font("Arial",Font.BOLD,18));
        con.add(score);
        con.add(nextLevel);
        nextLevel.setBounds(660,655,1000,30);
        nextLevel.setForeground(Color.WHITE);
        nextLevel.setFont(new Font("Arial",Font.BOLD,18));
		 
		dog.setBounds(10, 580, 50, 60);
		con.add(dog);
		
		addKeyListener(this);
		populateDucks();
		play.start();
		//Keep the background behind all images.
		con.add(background);
		background.setBounds(0,0,800,690);
	}
	
	//this populates ducks.
	protected void populateDucks() {
		for(int i = 0; i <= numOfDucks; i++) {
			JLabel duck = new JLabel(duckImg);
			int randomLocation = (int)(Math.random() * 700);
			ducks.add(duck);
			con.add((JLabel)(ducks.get(i)));
			duck.setBounds(randomLocation, 10, 30, 63);
			con.setComponentZOrder(((JLabel)(ducks.get(i))), 0);
		}
	}
	//this erases the ducks.
	protected void eraseDuck(){
		for(int i = 0; i < ducks.size(); i++) {
			JLabel duck = (JLabel)(ducks.get(i));
			duck.setVisible(false);
		}
    }
	//this removes the ducks.
	protected void removeDucks(){
		for(int i = 0; i < ducks.size(); i++) {
			JLabel duck = (JLabel)(ducks.get(i));
			duck.setVisible(false);
			con.remove(duck);
			ducks.remove(i);
			i--;
		}
    }
	//this removes "all" duck doo-doos.
	protected void removeDooDoo() {
		for(int j = 0; j < duckDooDoos.size(); j++) {
			JLabel duckPoo = (JLabel)(duckDooDoos.get(j));
			con.remove(duckPoo);
			duckDooDoos.remove(j);
			j--;
			}
	}
	//resets the dog's position.
	protected void resetDogPosition(){
		dog.setBounds(10, 580, 50, 60);        
    }
	//resets the game's values back to default.
	protected void resetGame() {
		numOfDucks = 1;
		currentLevel = 1;
		nextLevel.setText("Level: " + currentLevel);
		scoreTotal = 0;
		score.setText("Score: " + dF.format(scoreTotal));
		healthTotal = 500;
		health.setText("Health: " + healthTotal);
		eraseDuck();
		removeDucks();
		removeDooDoo();
		dog.setIcon(dogImg);
		resetDogPosition();
		populateDucks();
		play.start();
	}
	private void playAgain() {
		int clicked = JOptionPane.showConfirmDialog(this, "Do you want to try again pup?", "Play Again?",
					  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, tryAgain);
		if(clicked == JOptionPane.YES_OPTION) {
			resetGame();//resets the values without closing the application
		}
		else {
			System.exit(0);//closes the application completely.
		}		
	}
	//resets score total back to zero if it's a negative number.
	private void resetToZero() {
		if(scoreTotal <= 0) {
			scoreTotal = 0;
		}//ends reseting score to zero if a negative number.
	}
	//When the player dies it's game over.
	private void playerDied() {
		resetToZero();
		dog.setIcon(dogDied);
		Sound.playClip(gameOver);
		JOptionPane.showMessageDialog(this,"Poor pup... you died by sickness! Your Score was " + dF.format(scoreTotal) + ".","GAME OVER ",
		JOptionPane.ERROR_MESSAGE, duckWon);
		Sound.stopClip(gameOver);
		playAgain();
	}
	//When the player doesn't prevent a duck going pass the dog than it's game over.
	private void ducksWin() {
		resetToZero();
		dog.setBounds(10, 570, 100, 80);
		dog.setIcon(dogLaugh);
		Sound.playClip(failed);
		JOptionPane.showMessageDialog(this,"The ducks got passed you pup! Your Score was " + dF.format(scoreTotal) + ".","GAME OVER ",
		JOptionPane.ERROR_MESSAGE, duckWon);
		Sound.stopClip(failed);
		playAgain();
	}
	//When the player wins it pauses and proceeds to the next level.
	private void wonRound() throws InterruptedException {
		Thread.sleep(75);
		Sound.playClip(bark);
		JOptionPane.showMessageDialog(this,"Great work pup! Man's best friend won this round! ","Level " + currentLevel + " Cleared!",
		JOptionPane.ERROR_MESSAGE, dogWon);
		play.interrupt();
	}
	
	//When the player wins, it pauses and proceeds to the next level.
	protected void playerWins() throws InterruptedException {
		dog.setBounds(10, 580, 100, 80);
		dog.setIcon(happyDog);
		Sound.playClip(roundCleared);
		JOptionPane.showMessageDialog(this,"Well done pup! Your Master is proud of you! Your score was " + dF.format(scoreTotal) + ".","Cleared All " + currentLevel + " Levels!",
		JOptionPane.ERROR_MESSAGE, dogWon);
		Sound.stopClip(roundCleared);
		playAgain();   		
	}
	//The inner class.
	public class Play extends Thread {
		public void run() {
			while(true) {
				try { //sets a random distance between each duck
					for(int i = 0; i < ducks.size(); i++) {
						JLabel duck = (JLabel)(ducks.get(i));
						int distance = (int)(Math.random() * 4);
						duck.setBounds(duck.getX(), duck.getY()+ distance, 30, 63);
						
						//if ducks intersects the dog then they are removed.
						if(duck.getBounds().intersects(dog.getBounds())) {
							Sound.playClip(quack);
							scoreTotal += 100;
							score.setText("Score: " + dF.format(scoreTotal));
							duck.setIcon(duckHit);
							Thread.sleep(10);
							ducks.remove(i);
							con.remove(duck);
							numOfDucks--;
						} //ends duck collision from dog.
						
						//if the duck is greater or equal to 590, posY + posX of the screen, player loses and ducks win.
						if(duck.getY() >= 590) {
							duck.setBounds(duck.getX(), 10, 30, 30);
							removeDooDoo();
							eraseDuck();
							resetDogPosition();
							ducksWin();
							} //ends ducks reaching the 590 y-axis and ducks winning.
						
						//they throw their doo-doo while moving down.
						int fire = (int)(Math.random() * 1000);// The speed of fire; increase number when increase fire.
						if(fire <= 1) {// fire per amount.
							JLabel duckPoo = new JLabel(duckDooImg);
							duckPoo.setBounds(duck.getX() + 5, duck.getY() + 30, 30, 30);
							duckDooDoos.add(duckPoo);
							con.add((JLabel)(duckDooDoos.get(duckDooDoos.size()-1)));
							con.setComponentZOrder((JLabel)(duckDooDoos.get(duckDooDoos.size()-1)),0);
						} //ends the duck doo doo "rate of fire" and its range distance.
						
						//if the number of ducks are zero than the player wins a round and the ducks re-populate.
						if(numOfDucks < 0) {
							wonRound();
							eraseDuck();
							removeDooDoo();
							resetDogPosition();
							currentLevel++;
							nextLevel.setText("Level: " + currentLevel);
							numOfDucks = currentLevel * 2; //the value is changeable.
							populateDucks();
						}	
					}//ends the Ducks movements.
						
					//if a duck's doo-doo hits the dog then loses health.
					for(int j = 0; j < duckDooDoos.size(); j++) {
						JLabel duckDooDoo = ((JLabel)(duckDooDoos.get(j)));
						duckDooDoo.setBounds(duckDooDoo.getX(), duckDooDoo.getY() + 2, 30, 30);
							
						//This removes a doo-doo when it reaches a certain point at the bottom.
						if(duckDooDoo.getY() >= 625) {
							con.remove(duckDooDoo);
							duckDooDoos.remove(j);
							j--;
						}//ends doo-doo being removed when reaches 625 y-axis.

						// if the dog intersects the duck's doo-doo than they lose 50 health and 25 points. 
						if(dog.getBounds().intersects(duckDooDoo.getBounds())) {
							dog.setIcon(dogHit);
							Thread.sleep(10);
							dog.setIcon(dogImg);
							scoreTotal -= 25;
							score.setText("Score: " + dF.format(scoreTotal));
							healthTotal -= 50;
							health.setText("Health: " + healthTotal);
							con.remove(duckDooDoo);
							duckDooDoos.remove(j);
							j--;
							} //ends dog collision from duck.
						} //ends if duck doo-doo hits dog player.
					
					//makes a negative number return back to zero until the score increases again.
					if(scoreTotal <= 0) {
						score.setText("Score: " + 0);
					}//ends reseting score to zero if a negative number.
					
					//if dog player's health reaches zero than it's game over.
					if(healthTotal <= 0) {
						health.setText("Health: " + 0);
						removeDooDoo();
						eraseDuck();
						resetDogPosition();
						playerDied();
					}//ends player dying.
					
					//if the player reaches a certain level than they win the game and closes it.
					if(currentLevel > maxLevel)//The max winning level is changeable.
					{
						removeDooDoo();
						eraseDuck();
						currentLevel--;
						nextLevel.setText("Level: " + currentLevel);
						playerWins();
					}//ends player winning.
					con.repaint();//This repaints the images.
					Thread.sleep(15);//This controls the speed of the game. The duck and duck doo-doo.
				}//ends the Try.
				catch(Exception e){;}
			}//ends while true.
		  }//ends Run method.	
		}//ends inner Play class.
	
	//Must have these methods to implement the KeyListener.
	public void keyReleased(KeyEvent e) {;}
	public void keyTyped(KeyEvent e) {;}
	//This is the keyboard control for the dog when pressing specific keys.
	public void keyPressed(KeyEvent e) {
		System.out.println("This is KeyPressed.");		
		System.out.println("getKeyChar: " + e.getKeyChar() + " | getKeyCode: " + e.getKeyCode());
		//Dog moves UP.
		if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP) {
			dog.setBounds(dog.getX(), dog.getY()-30, 50, 60);
			if (dog.getY()<0) {
				dog.setBounds(dog.getX(), dog.getY()+30, 50, 60);
				}
			}//ends move up.
		//Dog moves DOWN.
		if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN) {
			dog.setBounds(dog.getX(), dog.getY()+30, 50, 60);
			if (dog.getY()>590) {
				dog.setBounds(dog.getX(), dog.getY()-30, 50, 60);
				}
			}//ends move down.
		//Dog moves LEFT.
		if (e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT) { 
			dog.setBounds(dog.getX()-30, dog.getY(), 50, 60);
			if (dog.getX()<0) {
				dog.setBounds(dog.getX()+30, dog.getY(), 50, 60);
				}
			}//ends move left.
		//Dog moves RIGHT.
		if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT) { 
			dog.setBounds(dog.getX()+30, dog.getY(), 50, 60);
			if (dog.getX()>759) {
				dog.setBounds(dog.getX()-30, dog.getY(), 50, 60);
				}
			}//ends move right.
		}//ends keyPressed.
	
	//main method that begins the title.
	public static void main(String[] args) {
		new Title();
	}
} //ends the DuckWarsGame Class	.