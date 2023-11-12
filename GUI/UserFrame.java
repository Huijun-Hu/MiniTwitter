package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import MiniTwitter.ControlPanel;
import MiniTwitter.User;

public class UserFrame extends JFrame {

    JPanel infoPanel = new JPanel();
    JScrollPane followingPanel = new JScrollPane();
    JScrollPane feedPanel = new JScrollPane();

    JTextField idField = new JTextField();
    JButton followButton = new JButton("Follow User");

    JList<String> follwingJList;
    DefaultListModel<String> model;
    // JList feedJList;

    JTextField msgField = new JTextField();
    JButton postButton = new JButton("NEW POST");

    JLabel id = new JLabel("ID :");

    JLabel idLabel;
    JLabel nameLabel;

    User user;
    ControlPanel admin;

    public UserFrame(ControlPanel admin, User u) {
        this.admin = admin;
        user = u;

        this.setSize(450, 450);
        this.setResizable(false);
        this.setTitle("Mini Twitter");

        // infoPanel.setBorder();
        infoPanel.setBounds(50, 20, 350, 40);
        infoPanel.setLayout(null);

        // followingPanel.setBackground(Color.blue);
        followingPanel.setBounds(30, 80, 150, 250);
        followingPanel.setLayout(null);

        id.setBounds(35, 350, 50, 30);
        idField.setBounds(85, 350, 100, 30);
        followButton.setBounds(30, 380, 150, 30);

        feedPanel.setBackground(Color.blue);
        feedPanel.setBounds(230, 80, 190, 230);

        msgField.setBounds(230, 330, 200, 50);
        postButton.setBounds(330, 380, 100, 30);

        idLabel = new JLabel("User id : " + u.getId());
        idLabel.setBounds(10, 5, 100, 30);

        nameLabel = new JLabel("User Name : " + u.getName());
        nameLabel.setBounds(200, 5, 120, 30);

        infoPanel.add(idLabel);
        infoPanel.add(nameLabel);

        follwingJList = new JList<>();
        model = new DefaultListModel<String>();
        for (User x : user.getFollowings()) {
            model.addElement(x.getName());
        }
        follwingJList.setModel(model);

        followingPanel.add(follwingJList);
        follwingJList.setBounds(10, 10, 120, 200);
        // reloadFollowing();
        // reloadFeed();

        this.add(infoPanel);
        this.add(followingPanel);
        this.add(feedPanel);
        this.add(id);
        this.add(idField);
        this.add(followButton);
        this.add(msgField);
        this.add(postButton);

        this.setUpButtonListeners();
        // Frame configuration
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ImageIcon logo = new ImageIcon("logo.png");
        // this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
    }

    public void reloadFollowing() {

        model = new DefaultListModel<String>();

        for (User x : user.getFollowings()) {
            model.addElement(x.getName());
        }

    }

    public void setUpButtonListeners() {

        ActionListener followBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user.follow(admin.getUserBank().get(Integer.parseInt(idField.getText())));
                follwingJList.setModel(model);
                model.addElement(admin.getUserBank().get(Integer.parseInt(idField.getText())).getName());
                idField.setText("");
            }
        };
        followButton.addActionListener(followBL);
    }

}
