package app.mccall;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App extends JFrame implements ActionListener {

    private static final long serialVersionUID = 4976217117618960671L;
    private String lastSender;

    private JFrame window;
    private JTextArea chatArea;
    private JScrollPane scrollArea;
    private JTextField inputField;

    private Thomas thomas;

    public App() {

        lastSender = "";

        thomas = Thomas.getInstance();

        window = new JFrame();
        window.setTitle("Project Thomas");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        scrollArea = new JScrollPane();
        scrollArea.setViewportView(chatArea);
        scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        inputField = new JTextField();
        inputField.setColumns(256);
        inputField.addActionListener(this);

        window.add(scrollArea);
        window.add(inputField, BorderLayout.PAGE_END);

        window.setVisible(true);

    }

    private void sendMessage(String sender, String messsage) {

        if (lastSender.equals(sender) || lastSender.equals(""))
            chatArea.append(String.format("[%s] %s\n", sender, messsage));
        else {
            lastSender = sender;
            chatArea.append(String.format("[%s] %s\n\n", sender, messsage));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendMessage("USER", inputField.getText());
        thomas.log(inputField.getText());
        inputField.setText("");
    }

    public static void main(String[] args) {
        new App();
    }
}
