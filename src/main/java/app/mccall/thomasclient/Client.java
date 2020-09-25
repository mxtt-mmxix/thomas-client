package app.mccall.thomasclient;

import javax.swing.JFrame;

import app.mccall.thomas.ThomasCore;
import app.mccall.thomas.ThomasDB;
import app.mccall.thomas.ThomasParser;

public class Client {

    private ThomasCore thomas;
    private ThomasDB thomasDB;
    private ThomasParser thomasParser;
    private SplashScreen splashScreen;
    private ClientWindow window;

    private void fadeWindowIn(JFrame window) {
        for (float opacity = 0; opacity < 1; opacity += 0.01)
            window.setOpacity(opacity);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fadeWindowOut(JFrame window) {
        for (float opacity = 1; opacity > 0; opacity -= 0.01)
            window.setOpacity(opacity);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Client() {

        splashScreen = new SplashScreen();
        splashScreen.setOpacity(0);
        splashScreen.setVisible(true);

        fadeWindowIn(splashScreen);

        thomasDB = new ThomasDB();
        thomasParser = new ThomasParser("models/en-parser-chunking.bin");
        thomas = new ThomasCore(thomasDB, thomasParser);

        window = new ClientWindow();

        fadeWindowOut(splashScreen);
        window.setVisible(true);

        splashScreen.dispose();

    }

    public static void main(String[] args) {
        new Client();
    }
}
