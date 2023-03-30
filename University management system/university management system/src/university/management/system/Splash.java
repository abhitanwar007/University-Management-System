package university.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {

	Thread t;

	Splash() {

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);

		t = new Thread(this);
		t.start();

		setVisible(true);

		for (int i = 0; i <= 300; i += 2) {
			setSize(3 * i, 2 * i);
			setLocation(500 - i, 100 - i / 5);
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void run() {
		try {
			Thread.sleep(5000);
			setVisible(false);

			new Login();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		new Splash();
	}
}
