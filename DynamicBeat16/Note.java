package DynamicBeat16;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 -( 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;// 1초에 저지먼트 라인 도달
	private String noteType;
	private boolean proceded = true;
	public String getNoteType() {
		return noteType;
	}
	public boolean isProceded() {
		return proceded;
	}
	public void close() {
		proceded = false;
	}//노트가 눌리면 움직이지 않게 함
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x= 228;
		}
		else if(noteType.equals("D")) {
			x= 332;
		}
		else if(noteType.equals("F")) {
			x = 436;
		}
		else if(noteType.equals("Space")) {
			x = 540;
		}
		else if(noteType.equals("J")) {
			x = 744;
		}
		else if(noteType.equals("K")) {
			x = 848;
		}
		else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}

	public void screenDraw(Graphics2D g) {
		if (noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		} else {
			g.drawImage(noteBasicImage, x, y, null);
		}

	}

	public void drop() {
		y += Main.NOTE_SPEED;
		if( y > 620) {
			System.out.println("Miss");
			close();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if(proceded) {//진행 중이면 쉬면서 내려오게 함
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
	}
	public String judge() {
		if(y >= 613) {
			System.out.println("Late");
			close();
			return "Late";
		}
		else if(y >= 600) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y >= 580) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y >= 573) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if(y >= 510) {
			System.out.println("Early");
			close();
			return "Early";
		}
		return "None";
	}

}
