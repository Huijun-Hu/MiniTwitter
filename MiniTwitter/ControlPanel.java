package MiniTwitter;

import java.util.*;

import javax.swing.JFrame;

//Singleton pattern
public class ControlPanel {
    protected static ControlPanel instance;
    private HashMap<Integer, User> UserBank;

    private static JFrame frame;
    // private JPanel treePanel;
    // private JPanel addUserPanel;
    // private JPanel openUserViewPanel;
    // private JPanel showInfoPanel;

    protected ControlPanel() {
        initialize();
    }

    public static ControlPanel getInstance() {
        if (instance == null) {
            instance = new ControlPanel();
        }
        return instance;
    }

    public void initialize() {
        frame = new MainFrame();
        UserBank = new HashMap<>();

    }

    // public void addUser

    // public void newUser(id, name){
    // Member u = new User(id,name);
    // }

    // public void newGroups()

    // public int countUsers()
    // public int countGroups()
    // public int countFeed()

    // public String positivity()

    // create users and user groups
    // 1) output the total number of users;
    // 2) output the total number of groups;
    // 3) output the total number of Tweet messages in all the users’ news feed;
    // 4) output the percentage of the positive
    // Tweet messages in all the users’ news feed (the message containing positive
    // words,
    // such as good, great, excellent, etc.) Free free to decide the positive word
}
