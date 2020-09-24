package app.mccall;

import javax.swing.JFrame;

public class Client {

    private Thomas thomas;
    private SplashScreen splashScreen;
    private ClientWindow window;

    private void fadeWindowIn(JFrame window) {
        for (float opacity = 0; opacity < 1; opacity += 0.01)
            window.setOpacity(opacity);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fadeWindowOut(JFrame window) {
        for (float opacity = 1; opacity > 0; opacity -= 0.01)
            window.setOpacity(opacity);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Client() {

        splashScreen = new SplashScreen();
        splashScreen.setOpacity(0);
        splashScreen.setVisible(true);

        fadeWindowIn(splashScreen);

        thomas = new Thomas();
        thomas.initDB();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        window = new ClientWindow();

        fadeWindowOut(splashScreen);
        window.setVisible(true);

        splashScreen.dispose();

    }

    public static void main(String[] args) {
        new Client();
    }
}
