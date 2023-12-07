package GUI;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import MiniTwitter.ControlPanel;
import MiniTwitter.GroupVisitor;
import MiniTwitter.Member;
import MiniTwitter.User;
import MiniTwitter.UserGroup;
import MiniTwitter.UserVisitor;
import MiniTwitter.Visitor;
import java.awt.*;

public class MainFrame extends JFrame {

    private final ControlPanel ADMIN = ControlPanel.getInstance();

    JPanel TreeViewPanel;
    JTree tree;
    DefaultMutableTreeNode rootNode;
    UserGroup root;
    DefaultTreeModel treeModel;

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

    JButton valiButton;
    JButton lastPostButton;

    DefaultMutableTreeNode selection;

    public MainFrame() {
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
        addUserButton.setText("ADD USER");
        addUserButton.setFocusable(false);

        addGroupButton = new JButton();
        addGroupButton.setBounds(600, 270, 150, 50);
        addGroupButton.setText("ADD GROUP");
        addGroupButton.setFocusable(false);

        userDetailButton = new JButton();
        userDetailButton.setBounds(350, 340, 350, 50);
        userDetailButton.setText("View User Detail");
        userDetailButton.setFocusable(false);
        // userDetailButton.setHorizontalTextPosition(JButton.CENTER);
        // userDetailButton.setFont();

        totalUserButton = new JButton();
        totalUserButton.setBounds(300, 410, 200, 50);
        totalUserButton.setText("Show User Total");
        totalUserButton.setFocusable(false);

        totalGroupButton = new JButton();
        totalGroupButton.setBounds(550, 410, 200, 50);
        totalGroupButton.setText("Show Group Total");
        totalGroupButton.setFocusable(false);

        totalMsgButton = new JButton();
        totalMsgButton.setBounds(300, 480, 200, 50);
        totalMsgButton.setText("Show Message Total");
        totalMsgButton.setFocusable(false);

        positivityButton = new JButton();
        positivityButton.setBounds(550, 480, 200, 50);
        positivityButton.setText("Show Message Positivity");
        positivityButton.setFocusable(false);

        valiButton = new JButton();
        valiButton.setBounds(300, 530, 200, 30);
        valiButton.setText("Validate IDs");
        valiButton.setFocusable(false);

        lastPostButton = new JButton();
        lastPostButton.setBounds(550, 530, 200, 30);
        lastPostButton.setText("Last Update");
        lastPostButton.setFocusable(false);

        root = new UserGroup(000, "Root");
        rootNode = new DefaultMutableTreeNode(root);
        tree = new JTree(rootNode);
        tree.setBounds(10, 10, 180, 480);
        tree.setCellRenderer(new MyTreeCellRenderer());
        treeModel = (DefaultTreeModel) tree.getModel();

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                /* if nothing is selected */
                if (node == null)
                    return;

                /* retrieve the node that was selected */
                selection = node;
            }

        });
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
        this.add(valiButton);
        this.add(lastPostButton);

        setUpButtonListeners();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(600, 300);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
    }

    public void setUpButtonListeners() {

        ActionListener addUserBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (UserId.getText() != null && UserName.getText() != null) {
                    ADMIN.addUser(Integer.parseInt(UserId.getText()), UserName.getText(), selection);
                    if(UserId.getText().contains(" ")){
                        ADMIN.setIDContainsSpace(true);
                    }
                    UserId.setText("");
                    UserName.setText("");
                    treeModel.reload();
                }
            }
        };
        addUserButton.addActionListener(addUserBL);

        ActionListener addGroupBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ADMIN.addGroup(Integer.parseInt(GroupId.getText()), GroupName.getText(), selection);
                GroupId.setText("");
                GroupName.setText("");
                treeModel.reload();
            }

        };
        addGroupButton.addActionListener(addGroupBL);

        ActionListener detailBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User u = (User) selection.getUserObject();
                if (u.getWindow() == null) {
                    UserFrame userWindow = new UserFrame(ADMIN, u);
                    u.setWindow(userWindow);

                } else {
                    u.getWindow().setVisible(true);
                }

            }
        };
        userDetailButton.addActionListener(detailBL);

        ActionListener userCountlBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Visitor visitor = new UserVisitor();
                int sum = 0;
                for (Member m : root.getMembers()) {
                    sum += m.accept(visitor);
                }
                JDialog d = new JDialog();
                d.add(new JLabel(sum + " Total User", SwingConstants.CENTER));
                d.setSize(200, 100);
                d.setLocation(500, 500);
                d.setVisible(true);

            }
        };
        totalUserButton.addActionListener(userCountlBL);

        ActionListener groupCountlBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visitor visitor = new GroupVisitor();
                int sum = 0;
                for (Member m : root.getMembers()) {
                    sum += m.accept(visitor);
                }
                JDialog d = new JDialog();
                d.add(new JLabel(sum + " Total Group", SwingConstants.CENTER));
                d.setSize(200, 100);
                d.setLocation(500, 500);
                d.setVisible(true);
            }
        };
        totalGroupButton.addActionListener(groupCountlBL);

        ActionListener totalMsgBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog d = new JDialog();
                d.add(new JLabel(ADMIN.countFeed() + " Total Posts", SwingConstants.CENTER));
                d.setLocation(500, 500);
                d.setSize(200, 100);
                d.setVisible(true);
            }
        };
        totalMsgButton.addActionListener(totalMsgBL);

        ActionListener posBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.add(new JLabel(ADMIN.positivity(), SwingConstants.CENTER));
                d.setLocation(500, 500);
                d.setSize(200, 100);
                d.setVisible(true);
            }
        };
        positivityButton.addActionListener(posBL);

        ActionListener valBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.add(new JLabel(ADMIN.validation(), SwingConstants.CENTER));
                d.setLocation(500, 500);
                d.setSize(200, 100);
                d.setVisible(true);
            }
        };
        valiButton.addActionListener(valBL);

       ActionListener lastBL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.add(new JLabel(ADMIN.lastUpdate(), SwingConstants.CENTER));
                d.setLocation(500, 500);
                d.setSize(200, 100);
                d.setVisible(true);
            }
        };
        lastPostButton.addActionListener(lastBL);

    }

}
