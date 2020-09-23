package app.mccall;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener {

    private static final long serialVersionUID = 4976217117618960671L;
    private String lastSender;

    private JFrame window;
    private JLabel titleLabel;
    private JTextArea chatArea;
    private JScrollPane scrollArea;
    private JLabel inputLabel;
    private JTextField inputField;
    private JPanel chatPanel;

    private Thomas thomas;

    public Client() {

        lastSender = "";

        thomas = Thomas.getInstance();

        window = new JFrame();
        window.setTitle("project-thomas");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("project-thomas");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setRows(16);
        chatArea.setWrapStyleWord(true);

        scrollArea = new JScrollPane();
        scrollArea.setViewportView(chatArea);
        scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        inputLabel = new JLabel("Say something:");

        inputField = new JTextField();
        inputField.setColumns(32);
        inputField.addActionListener(this);

        chatPanel = new JPanel();
        chatPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        chatPanel.add(inputLabel, BorderLayout.LINE_START);
        chatPanel.add(inputField, BorderLayout.CENTER);

        window.add(titleLabel, BorderLayout.PAGE_START);
        window.add(scrollArea);
        window.add(chatPanel, BorderLayout.PAGE_END);

        window.pack();

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
        new Client();
    }
}
