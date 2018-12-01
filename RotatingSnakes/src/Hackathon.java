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
			character1 = ImageIO.read(Hackathon.class.getResource("Char1,jpg"));
			character2 = ImageIO.read(Hackathon.class.getResource("Char2,jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void Action() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				repaint();
			}
		}, 0,20);
	}
	
	public void paint(Graphics g) {
		g.drawString(x+","+y, 50, 50);
	}
	
	int angle1 = 0;
	int angle2 = 0;
	int speed = 7;
	//north = 0; east = 90degree
	int Char1X = 0;int Char2X = 0;
	int Char1Y = 0;int Char2Y = 0;
	public void moving(boolean char1) {
		if(char1==true) {
			if(angle1<=90) {
				Char1X = (int) (speed*Math.sin(angle1));
				Char1Y = (int) (speed*Math.cos(angle1));
				
			}
		}
	}
	
	static int x = 0;
	static int y = 0;
	static boolean forward = true;
	static boolean backward = false;
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
				if(e.getKeyCode()==KeyEvent.VK_D) {
					if(backward==true) {
						forward = true;
						backward = false;
					}else {
						forward = true;
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_F) {
					if(forward==true) {
						backward = true;
						forward = false;
					}else {
						backward = true;
					}
				}
			}
			public void keyReleased(KeyEvent e) {

			}
		});
		ha.Action();
	}
}
