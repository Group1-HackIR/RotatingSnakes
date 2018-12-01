import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hackathon extends JPanel {
	static BufferedImage character1;
	static BufferedImage character2;
	static {
		try {
			character1 = ImageIO.read(Hackathon.class.getResource("Char1.jpg"));
			character2 = ImageIO.read(Hackathon.class.getResource("Char2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Action() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				repaint();
			}
		}, 0, 20);
	}

	public void paint(Graphics g) {
		g.drawString(x + "," + y, 50, 50);
	}

	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		JFrame f = new JFrame("rotating snakes");
		Hackathon ha = new Hackathon();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(730, 700);
		f.add(ha);
		ha.Action();
	}
}
