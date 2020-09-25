package app.mccall.thomasclient;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SplashScreen extends JFrame {

    private static final long serialVersionUID = -8539523818094681138L;

    private ImageIcon splashImage;
    private JLabel splashLabel;

    public void fadeIn() {
        for (float opacity = 0; opacity < 1; opacity += 0.01)
            setOpacity(opacity);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fadeOut() {
        for (float opacity = 1; opacity > 0; opacity -= 0.01)
            setOpacity(opacity);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SplashScreen() {

        splashImage = new ImageIcon("./splash.jpg");
        splashLabel = new JLabel(splashImage);

        add(splashLabel);

        setResizable(false);
        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);

    }
}
