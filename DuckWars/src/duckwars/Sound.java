package duckwars;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
public class Sound {
private static Clip clip;
//Plays the audio clip.
public static void playClip(File Sound) {
	try{
		clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(Sound));
		clip.start();
		Thread.sleep(clip.getMicrosecondLength()/1000000);
		}
	catch (Exception e) {;}
	}
//Stops playing the audio clip.
public static void stopClip(File Sound) {
	clip.stop();
	}
}