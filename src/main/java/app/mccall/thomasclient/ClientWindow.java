package app.mccall.thomasclient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = -3762211696079735607L;

    private JLabel titleLabel;
    private JTextArea chatArea;
    private JScrollPane scrollArea;
    private JLabel inputLabel;
    private JTextField inputField;
    private JButton speakButton;
    private JCheckBox ttsBox;
    private JPanel chatPanel;
    private boolean isListening;
    private Callback callback = null;

    public ClientWindow() {

        setTitle("project-thomas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        speakButton = new JButton();
        speakButton.setText("Listen");
        speakButton.addActionListener(this);

        ttsBox = new JCheckBox();
        ttsBox.setText("Speak");

        chatPanel = new JPanel();
        chatPanel.setLayout(new FlowLayout());
        chatPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        chatPanel.add(inputLabel);
        chatPanel.add(inputField);
        chatPanel.add(speakButton);
        chatPanel.add(ttsBox);

        add(titleLabel, BorderLayout.PAGE_START);
        add(scrollArea);
        add(chatPanel, BorderLayout.PAGE_END);

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);

    }

    public void sendMessage(final String sender, final String messsage) {
        chatArea.append(String.format("<%s> %s\n\n", sender, messsage));
    }

    public void addCallback(final Callback callback) {
        this.callback = callback;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputField) {
            inputField.setEnabled(false);
            sendMessage("USER", inputField.getText());
            callback.call(inputField.getText());
            inputField.setText("");
            inputField.setEnabled(true);
        } else if (e.getSource() == speakButton) {
            if (!isListening) {
                speakButton.setText("Stop Listening");
            } else {
                isListening = false;
                speakButton.setText("Start Listening");
            }
        }
    }
}
