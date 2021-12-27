package DynamicBeat16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlameImage = new ImageIcon(Main.class.getResource("../images/blueFlame.png")).getImage();
	private String judgeString = "Start";
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.difficulty = difficulty;
		this.titleName = titleName;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(!note.isProceded()) {
				noteList.remove(i);
				i--;
			}
			else {
			note.screenDraw(g);
			}
		}
		g.drawString(judgeString, 460, 420);
		g.setColor(Color.white);
		// ±Û¾¾ ±úÁü ¹æÁö graphics2D
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("00000", 565, 702);
		g.drawImage(blueFlameImage, 320, 370, null);
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("SPACE", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);

	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseD() {
		
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("JoakimKarud_MightyLove") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125; 
			beats = new Beat[] {
				new Beat(startTime, "S"),
				new Beat(startTime + gap *5 , "D"),
				new Beat(startTime + gap *6, "F"),
				new Beat(startTime + gap *8 , "Space"),
				new Beat(startTime + gap *10 , "J"),
				new Beat(startTime + gap *12 , "L"),
				new Beat(startTime + gap *14 , "S"),
				new Beat(startTime + gap *18 , "F"),
				new Beat(startTime + gap *20 , "D"),
				new Beat(startTime + gap *24 , "K"),
				new Beat(startTime + gap *26 , "J"),
				new Beat(startTime + gap *28 , "K"),
				new Beat(startTime + gap *29 , "L"),
				new Beat(startTime + gap *33 , "Space"),
				new Beat(startTime + gap *36 , "D"),
				new Beat(startTime + gap *40 , "F"),
				new Beat(startTime + gap *41 , "D"),
				new Beat(startTime + gap *44 , "J"),
				new Beat(startTime + gap *48 , "K"),
				new Beat(startTime + gap *50 , "L"),
				new Beat(startTime + gap *59 , "F"),
				new Beat(startTime + gap *60 , "L"),
				new Beat(startTime + gap *66 , "S"),
				new Beat(startTime + gap *69 , "D"),
				new Beat(startTime + gap *79 , "S"),
				new Beat(startTime + gap *88 , "L"),
				new Beat(startTime + gap *100 , "L"),
				new Beat(startTime + gap *120 , "L"),
				new Beat(startTime + gap *140 , "L"),
			};
		}
		else if(titleName.equals("JoakimKarud_MightyLove") && difficulty.equals("Hard")) {
			beats = new Beat[] {
					new Beat(1000, "S"),
					new Beat(2000, "F"),
					new Beat(3000, "F"),
			};
		}
		else if(titleName.equals("Bensound_Energy")&& difficulty.equals("Easy")) {
			beats = new Beat[] {
					new Beat(1000, "S"),
					new Beat(2000, "D"),
					new Beat(3000, "F"),
			};
		}
		else if(titleName.equals("Bensound_Energy")&& difficulty.equals("Hard")) {
			beats = new Beat[] {
					new Beat(1000, "S"),
					new Beat(2000, "F"),
					new Beat(3000, "F"),
			};
		}
		else if(titleName.equals("WildFlower_JoakimKarud")&& difficulty.equals("Easy")) {
			beats = new Beat[] {
					new Beat(1000, "S"),
					new Beat(2000, "F"),
					new Beat(3000, "F"),
			};
		}
		else if(titleName.equals("WildFlower_JoakimKarud")&& difficulty.equals("Hard")) {
			beats = new Beat[] {
					new Beat(1000, "S"),
					new Beat(2000, "F"),
					new Beat(3000, "F"),
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted() ) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(dropped == false) {
				try {
					Thread.sleep(5); // 0.005ÃÊ ½¬±â
				}catch (Exception e) {
					e.getStackTrace();
				}
			}
		}
		
	}
	public void judge(String input) {
		for (int i = 0;i<noteList.size();i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			judgeString = "None";
		}
		else if(judge.equals("Late")) {
			judgeString = "Late";
		}
		else if(judge.equals("Good")) {
			judgeString = "Good";
		}
		else if(judge.equals("Great")) {
			judgeString = "Great";
		}
		else if(judge.equals("Early")) {
			judgeString = "Early";
		}
		else if(judge.equals("Perfect")) {
			judgeString = "Perfect";
		}
	}
}
