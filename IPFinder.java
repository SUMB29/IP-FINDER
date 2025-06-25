import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class IPFinder {
    public static void main(String[] args) {
        JFrame jf = new JFrame("IP FINDER PROGRAM");
        jf.setBounds(30,30,30,30);

        // Create components
        JLabel label = new JLabel("Enter URL:");
        JTextField tf = new JTextField(20);
        JButton button = new JButton("Find IP");

        // Panel for input
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(tf);
        panel.add(button);

        jf.add(panel);
        jf.setVisible(true);

        // Action Listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = tf.getText();
                try {
                    InetAddress ia = InetAddress.getByName(url);
                    String ip = ia.getHostAddress();
                    JOptionPane.showMessageDialog(jf, "IP Address: " + ip);
                } catch (UnknownHostException ex) {
                    JOptionPane.showMessageDialog(jf, "Invalid URL or Host not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
