package Hackathon;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Character {
	int angle = 0;
	int speed = 7;
	int Charx = 0;
	int CHary = 0;
	int x;
	int y;
	BufferedImage i;
	public Character(BufferedImage ik, int xx, int yy) {
		i = ik;
		x = xx;
		y = yy;
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				if(angle>=360) {
					angle = angle-360;
				}
				if(angle<0) {
					angle = 360+angle;
				}
			}
		}, 0,20);
	}
}
