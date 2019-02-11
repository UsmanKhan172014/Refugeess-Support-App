package application;

import java.util.Random;

public class StartApp {
public static void main(String[] args) throws InterruptedException {
	Random random = new Random(100);
	SplashScreen ss = new SplashScreen();
	MainWindows mw = new MainWindows();
	ss.setVisible(true);
	for (int i = 0; i <= 100; i++) {
		Thread.sleep(random.nextInt(100));
		ss.progressBar.setValue(i);
		ss.label.setText(i+"%");
		if (i==100) {
			ss.setVisible(false);
			ss.dispose();
			mw.setVisible(true);
		}	
	}
}
}
