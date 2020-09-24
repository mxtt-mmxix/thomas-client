package app.mccall.thomasclient;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SplashScreen extends JFrame {

    private static final long serialVersionUID = -8539523818094681138L;

    private ImageIcon splashImage;
    private JLabel splashLabel;

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
