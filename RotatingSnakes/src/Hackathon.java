package Hackathon;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hackathon extends JPanel{
	static BufferedImage character1;
	static BufferedImage character2;
	static {
		try {
			character1 = ImageIO.read(Hackathon.class.getResource("char1.jpg"));
			character2 = ImageIO.read(Hackathon.class.getResource("char2.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	static Character char1;
	static Character char2;
	public void Action() {
		char1 = new Character(character1, 300, 300);
		char2 = new Character(character2, 200, 500);
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				if(forward1||backward1) {
					moving(true);
				}
				if(forward2||backward2) {
					moving(false);
				}
				repaint();
			}
		}, 0,20);
	}
	
	public void paint(Graphics g) {
		g.drawImage(character1, char1.x, char1.y,null);
		g.drawImage(character2, char2.x, char2.y,null);
	}
	
	public void moving(boolean ch1) {
		if(ch1==true) {
			if(char1.angle<=90) {
				char1.Charx= (int) (char1.speed*Math.sin(char1.angle));
				System.out.println(Math.sin(char1.angle));
				System.out.println(char1.Charx);
				char1.CHary = (int) (char1.speed*Math.cos(char1.angle));
			}else {
				if(char1.angle>90&&char1.angle<=180) {
					char1.CHary= (int) (char1.speed*Math.sin(char1.angle-90));
					char1.Charx = (int) (char1.speed*Math.cos(char1.angle-90));
				}else {
					if(char1.angle>1800&&char1.angle<=270) {
						char1.Charx= (int) (char1.speed*Math.sin(char1.angle-180));
						char1.CHary = (int) (char1.speed*Math.cos(char1.angle-180));
					}else {
						char1.CHary= (int) (char1.speed*Math.sin(char1.angle-270));
						char1.Charx = (int) (char1.speed*Math.cos(char1.angle-270));
					}
				}
			}
			if(forward1==true) {
				char1.x+=char1.Charx; char1.y+=char1.CHary;
			}
			if(backward1==true) {
				char1.x-=char1.Charx; char1.y-=char1.CHary;
			}
		}else {
			if(char2.angle<=90) {
				char2.Charx= (int) (char2.speed*Math.sin(char2.angle));
				char2.CHary = (int) (char2.speed*Math.cos(char2.angle));
			}else {
				if(char2.angle>90&&char2.angle<=180) {
					char2.CHary= (int) (char2.speed*Math.sin(char2.angle-90));
					char2.Charx = (int) (char2.speed*Math.cos(char2.angle-90));
				}else {
					if(char2.angle>1800&&char2.angle<=270) {
						char2.Charx= (int) (char2.speed*Math.sin(char2.angle-180));
						char2.CHary = (int) (char2.speed*Math.cos(char2.angle-180));
					}else {
						char2.CHary= (int) (char2.speed*Math.sin(char2.angle-270));
						char2.Charx = (int) (char2.speed*Math.cos(char2.angle-270));
					}
				}
			}
			if(forward2==true) {
				char2.x+=char2.Charx; char2.y+=char2.CHary;
			}
			if(backward2==true) {
				char2.x-=char2.Charx; char2.y-=char2.CHary;
			}
		}
	}
	
	static int x = 0;
	static int y = 0;
	static boolean forward1 = false;
	static boolean backward1 = false;
	static boolean forward2 = false;
	static boolean backward2 = false;
	public static void main(String[] args) {
		JFrame f = new JFrame("rotating snakes");
		Hackathon ha = new Hackathon();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(730,700);
		f.add(ha);
		f.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				
			}
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_D :
					if(backward1==true) {
						forward1 = true;
						backward1 = false;
					}else {
						forward1 = true;
					}
				break;
				case KeyEvent.VK_F :
					if(forward1==true) {
						backward1 = true;
						forward1 = false;
					}else {
						backward1 = true;
					}
				break;
				case KeyEvent.VK_COMMA :
					if(backward2==true) {
						forward2 = true;
						backward2 = false;
					}else {
						forward2 = true;
					}
				break;
				case KeyEvent.VK_PERIOD :
					if(forward2==true) {
						backward2 = true;
						forward2 = false;
					}else {
						backward2 = true;
					}
				break;
				case KeyEvent.VK_A :
					char1.angle+=5;
				break;
				case KeyEvent.VK_S :
					char1.angle-=5;
				break;
				case KeyEvent.VK_N :
					char2.angle+=5;
				break;
				case KeyEvent.VK_M :
					char2.angle-=5;
				}
			}
			public void keyReleased(KeyEvent e) {
				forward1 = false; backward1 = false;
				forward2 = false; backward2 = false;
			}
		});
		ha.Action();
	}
}
