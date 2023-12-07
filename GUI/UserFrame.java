package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import MiniTwitter.ControlPanel;
import MiniTwitter.User;


public class UserFrame extends JFrame {

    JPanel infoPanel = new JPanel();
    JScrollPane followingPanel = new JScrollPane();
    JScrollPane feedPanel = new JScrollPane();

    JTextField idField = new JTextField();
    JButton followButton = new JButton("Follow User");

    JTextField msgField = new JTextField();
    JButton postButton = new JButton("NEW POST");

    JList<String> follwingJList;
    DefaultListModel<String> followModel;
    JList<String> feedJList;
    DefaultListModel<String> feedModel;

    JLabel id = new JLabel("ID :");

    JLabel idLabel;
    JLabel nameLabel;
    JLabel timeLabel;
    JLabel lastUpdateLabel;

    User user;
    ControlPanel admin;

    public UserFrame(ControlPanel admin, User u) {
        this.admin = admin;
        user = u;

        this.setSize(450, 450);
        this.setResizable(false);
        this.setTitle("Mini Twitter");

        infoPanel.setBounds(50, 20, 400, 40);
        infoPanel.setLayout(null);

        followingPanel.setBackground(new java.awt.Color(90, 88, 88));
        followingPanel.setBounds(30, 80, 150, 250);
        followingPanel.setLayout(null);

        id.setBounds(35, 350, 50, 30);
        idField.setBounds(85, 350, 100, 30);
        followButton.setBounds(30, 380, 150, 30);

        feedPanel.setBackground(new java.awt.Color(90, 88, 88));
        feedPanel.setBounds(230, 80, 190, 230);
        feedPanel.setLayout(null);

        msgField.setBounds(230, 330, 200, 50);
        postButton.setBounds(330, 380, 100, 30);

        idLabel = new JLabel("User id : " + u.getId());
        idLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        idLabel.setBounds(10, 5, 200, 30);

        nameLabel = new JLabel("User Name : " + u.getName());
        nameLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        nameLabel.setBounds(200, 5, 280, 30);

        timeLabel = new JLabel("Creation Time: " + u.getCreationTime());
        timeLabel.setFont(new Font("Monospaced", Font.ITALIC,10));
        timeLabel.setBounds(0, 0, 300, 30);

        lastUpdateLabel = new JLabel("Last Update Time: " + u.getLastUpdateTime());
        lastUpdateLabel.setFont(new Font("Monospaced", Font.ITALIC,10));
        lastUpdateLabel.setBounds(250, 0, 300, 30);

        infoPanel.add(idLabel);
        infoPanel.add(nameLabel);

        follwingJList = new JList<>();
        followModel = new DefaultListModel<String>();
        followModel.addElement("YOUR FOLLWOINGS:");
        for (User x : user.getFollowings()) {
            followModel.addElement(x.getName());
        }
        follwingJList.setModel(followModel);

        feedJList = new JList<>();
        feedModel = new DefaultListModel<String>();
        feedModel.addElement("COMMUNITY");
        for (String s : user.getFeedList()) {
            feedModel.addElement(s);
        }
        feedJList.setModel(feedModel);

        followingPanel.add(follwingJList);
        follwingJList.setBounds(10, 10, 130, 230);
        feedPanel.add(feedJList);
        feedJList.setBounds(10, 10, 170, 210);

        this.add(infoPanel);
        this.add(followingPanel);
        this.add(feedPanel);
        this.add(id);
        this.add(idField);
        this.add(followButton);
        this.add(msgField);
        this.add(postButton);
        this.add(timeLabel);
        this.add(lastUpdateLabel);

        this.setUpButtonListeners();
        this.setLocation(700, 400);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                Frame frame = (Frame) evt.getSource();
                frame.setVisible(false);
            }
        });
    }

    public void updateFeed(User u, String msg) {

        feedModel.addElement(u.getName() + " : " + msg);
        feedJList.setModel(feedModel);
        lastUpdateLabel.setText("Last Update Time: " + user.getLastUpdateTime());

    }

    public JLabel getLastUpdateLabel(){
        return lastUpdateLabel;
    }

    public void setUpButtonListeners() {

        ActionListener feedBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (msgField.getText() != null) {
                    feedJList.setModel(feedModel);
                    user.postFeed(msgField.getText());
                    admin.storePost(msgField.getText());
                    feedModel.addElement(user.getName() + " : " + msgField.getText());
                }

                msgField.setText("");
                lastUpdateLabel.setText("Last Update Time: " + user.getLastUpdateTime());
            }
        };
        postButton.addActionListener(feedBL);

        ActionListener followBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user.follow(admin.getUserBank().get(Integer.parseInt(idField.getText())));
                follwingJList.setModel(followModel);
                followModel.addElement(admin.getUserBank().get(Integer.parseInt(idField.getText())).getName());
                idField.setText("");
            }
        };
        followButton.addActionListener(followBL);
    }
}
