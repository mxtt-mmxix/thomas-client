package app.mccall.thomasclient;

import app.mccall.thomas.ThomasCore;
import app.mccall.thomas.ThomasDB;
import app.mccall.thomas.ThomasParser;

public class Client {

    private ThomasCore thomas;
    private ThomasDB thomasDB;
    private ThomasParser thomasParser;
    private SplashScreen splashScreen;
    private ClientWindow window;

    public Client() {

        splashScreen = new SplashScreen();
        splashScreen.setOpacity(0);
        splashScreen.setVisible(true);

        splashScreen.fadeIn();
        ;

        thomasDB = new ThomasDB();
        thomasParser = new ThomasParser("models/en-parser-chunking.bin");
        thomas = new ThomasCore(thomasDB, thomasParser);

        window = new ClientWindow();

        window.addCallback(new Callback() {
            @Override
            public void call(String arg) {
                window.sendMessage("THOMAS", "Check console");
                thomas.send(arg);
            }
        });

        splashScreen.fadeOut();
        window.setVisible(true);

        splashScreen.dispose();

    }

    public static void main(String[] args) {
        new Client();
    }
}
