package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import MiniTwitter.User;

public class UserFrame extends JFrame implements ActionListener {

    JPanel infoPanel = new JPanel();
    JPanel followingPanel = new JPanel();
    JPanel feedPanel = new JPanel();
    JButton postButton = new JButton("NEW POST");

    UserFrame(User u) {
        this.setSize(450, 450);
        this.setResizable(false);
        this.setTitle("Mini Twitter");

        infoPanel.setBackground(Color.DARK_GRAY);
        infoPanel.setBounds(50, 20, 350, 50);

        followingPanel.setBackground(Color.red);
        followingPanel.setBounds(30, 100, 150, 280);

        feedPanel.setBackground(Color.blue);
        feedPanel.setBounds(230, 100, 190, 230);

        // postButton.setBackground(Color.red);
        postButton.setBounds(310, 340, 100, 50);
        postButton.addActionListener(this);

        this.add(infoPanel);
        this.add(followingPanel);
        this.add(feedPanel);
        this.add(postButton);

        // Frame configuration
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == postButton) {
            // post new feed
        }
    }
}
