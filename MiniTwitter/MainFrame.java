package MiniTwitter;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {

    JPanel TreeViewPanel;
    JTree tree;
    DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");

    JTextField UserId;
    JTextField UserName;
    JTextField GroupId;
    JTextField GroupName;

    JLabel UserIDLabel;
    JLabel UserNameLabel;
    JLabel GroupIDLabel;
    JLabel GroupNameLabel;

    JButton addUserButton;
    JButton addGroupButton;
    JButton userDetailButton;
    JButton totalUserButton;
    JButton totalGroupButton;
    JButton totalMsgButton;
    JButton positivityButton;

    MainFrame() {
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("Mini Twitter");

        TreeViewPanel = new JPanel();
        UserId = new JTextField();
        UserName = new JTextField();
        GroupId = new JTextField();
        GroupName = new JTextField();

        TreeViewPanel.setBackground(Color.white);
        TreeViewPanel.setBounds(50, 50, 200, 500);
        TreeViewPanel.setLayout(null);

        UserId = new JTextField();
        UserId.setBounds(370, 50, 100, 50);

        UserName = new JTextField();
        UserName.setBounds(600, 50, 100, 50);

        GroupId = new JTextField();
        GroupId.setBounds(370, 200, 100, 50);

        GroupName = new JTextField();
        GroupName.setBounds(600, 200, 100, 50);

        UserIDLabel = new JLabel("User ID:");
        UserIDLabel.setBounds(300, 50, 70, 50);

        UserNameLabel = new JLabel("User Name:");
        UserNameLabel.setBounds(500, 50, 100, 50);

        GroupIDLabel = new JLabel("Group ID:");
        GroupIDLabel.setBounds(300, 200, 70, 50);

        GroupNameLabel = new JLabel("Group Name:");
        GroupNameLabel.setBounds(500, 200, 100, 50);

        addUserButton = new JButton();
        addUserButton.setBounds(600, 120, 150, 50);
        addUserButton.addActionListener(this);
        addUserButton.setText("ADD USER");
        addUserButton.setFocusable(false);

        addGroupButton = new JButton();
        addGroupButton.setBounds(600, 270, 150, 50);
        addGroupButton.addActionListener(this);
        addGroupButton.setText("ADD GROUP");
        addGroupButton.setFocusable(false);

        userDetailButton = new JButton();
        userDetailButton.setBounds(350, 340, 350, 50);
        userDetailButton.addActionListener(this);
        userDetailButton.setText("View User Detail");
        userDetailButton.setFocusable(false);
        // userDetailButton.setHorizontalTextPosition(JButton.CENTER);
        // userDetailButton.setFont();

        totalUserButton = new JButton();
        totalUserButton.setBounds(300, 410, 200, 50);
        totalUserButton.addActionListener(this);
        totalUserButton.setText("Show User Total");
        totalUserButton.setFocusable(false);

        totalGroupButton = new JButton();
        totalGroupButton.setBounds(550, 410, 200, 50);
        totalGroupButton.addActionListener(this);
        totalGroupButton.setText("Show Group Total");
        totalGroupButton.setFocusable(false);

        totalMsgButton = new JButton();
        totalMsgButton.setBounds(300, 480, 200, 50);
        totalMsgButton.addActionListener(this);
        totalMsgButton.setText("Show Message Total");
        totalMsgButton.setFocusable(false);

        positivityButton = new JButton();
        positivityButton.setBounds(550, 480, 200, 50);
        positivityButton.addActionListener(this);
        positivityButton.setText("Show Message Positivity");
        positivityButton.setFocusable(false);

        tree = new JTree(rootNode);
        tree.setBounds(10, 10, 180, 480);

        DefaultMutableTreeNode a = new DefaultMutableTreeNode("a");
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("b");
        DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("a1");

        rootNode.add(a);
        rootNode.add(b);
        a.add(a1);

        TreeViewPanel.add(tree);
        this.add(TreeViewPanel);
        this.add(UserId);
        this.add(UserName);
        this.add(GroupId);
        this.add(GroupName);
        this.add(UserIDLabel);
        this.add(UserNameLabel);
        this.add(GroupIDLabel);
        this.add(GroupNameLabel);
        this.add(addUserButton);
        this.add(addGroupButton);
        this.add(userDetailButton);
        this.add(totalUserButton);
        this.add(totalGroupButton);
        this.add(totalMsgButton);
        this.add(positivityButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
    }

    public void addMember(Integer id, String name, DefaultMutableTreeNode parent) {

        parent.add(new DefaultMutableTreeNode(new User(id, name)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userDetailButton) {
            UserFrame userWindow = new UserFrame();
        }

        if (e.getSource() == addUserButton) {
            if (UserId.getText() != null && UserName.getText() != null) {
                // add to only root node
                addMember(Integer.parseInt(UserId.getText()), UserName.getText(), rootNode);
            }
        }
    }
}
