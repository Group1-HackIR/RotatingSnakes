package Hackathon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
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
				if(angle1A) {
					char1.angle++;
				}
				if(angle1B) {
					char1.angle--;
				}
				if(angle2A) {
					char2.angle++;
				}
				if(angle2B) {
					char2.angle--;
				}
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
		g.drawLine(0, char1.y, char1.x, char1.y);
		g.drawLine(char1.x, 0, char1.x, char1.y);
			AffineTransform at = AffineTransform.getTranslateInstance(char1.x, char1.y);
			at.rotate(Math.toRadians(char1.angle), );
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(char1.i, at,null);
			AffineTransform at1 = AffineTransform.getTranslateInstance(char2.x, char2.y);
			at1.rotate(Math.toRadians(char2.angle));
			Graphics2D g2d1 = (Graphics2D)g;
			g2d1.drawImage(char2.i, at1,null);
	}
	
	public int[] AL(Character chara) {
		int[] a = new int[2];
		a[0] = (int) Math.cos(chara.angle);
		a[1] = (int) Math.sin(chara.angle);
		return a;
	}
	
	
	public void moving(boolean ch1) {
		if(ch1==true) {
			if(char1.angle<=90) {
				char1.Charx= (int) (char1.speed*Math.sin(char1.angle));
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
	static boolean angle1A = false;
	static boolean angle1B = false;
	static boolean angle2A = false;
	static boolean angle2B = false;
	public static void main(String[] args) {
		JFrame f = new JFrame("rotating snakes");
		Hackathon ha = new Hackathon();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(730,700);
		ha.setBackground(Color.WHITE);
		f.add(ha);
		
		f.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				
			}
			public void keyPressed(KeyEvent e) {
				System.out.println(angle1A+", "+angle1B+", "+angle2A+", "+angle2B);
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
					angle1A = true;
				break;
				case KeyEvent.VK_S :
					angle1B = true;
				break;
				case KeyEvent.VK_N :
					angle2A = true;
				break;
				case KeyEvent.VK_M :
					angle2B = true;
				}
			}
			public void keyReleased(KeyEvent e) {
				forward1 = false; backward1 = false;
				forward2 = false; backward2 = false;
				angle1A = false; angle2A = false;
				angle2B = false; angle1B = false;
			}
		});
		ha.Action();
	}
}
