package MiniTwitter;

import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class ControlPanel {
    protected static ControlPanel instance;
    private HashMap<Integer, User> userBank = new HashMap<>();
    private List<Integer> idBank = new ArrayList<>();
    private List<String> feedBank = new ArrayList<>();
    private Boolean idContainsSpace = false;

    protected ControlPanel() {

    }

    public static ControlPanel getInstance() {
        if (instance == null) {
            instance = new ControlPanel();
        }
        return instance;
    }

    public HashMap<Integer,User> getUserBank() {
        return this.userBank;
    }

    public void addUser(Integer id, String name, DefaultMutableTreeNode parent) {

        UserGroup obj = (UserGroup) parent.getUserObject();
        User u = new User(id, name);
        obj.addMember(u);
        userBank.put(id,u);
        idBank.add(id);
        parent.add(new DefaultMutableTreeNode(u));
    }

    public void addGroup(Integer id, String name, DefaultMutableTreeNode parent) {

        UserGroup obj = (UserGroup) parent.getUserObject();
        UserGroup m = new UserGroup(id, name);
        obj.addMember(m);
        idBank.add(id);
        parent.add(new DefaultMutableTreeNode(m, true));

    }

    public void storePost(String s) {
        feedBank.add(s);
    }

    

    public int countGroups() {
        return 0;
    }

    public int countFeed() {
        return feedBank.size();
    }

    public String positivity() {
        int pos = 0;
        for (String s : feedBank) {
            if (s.contains("happy") || s.contains("good") || s.contains("nice") || s.contains("excellent")
                    || s.contains("great")) {
                pos += 1;
            }
        }
        return "Post Positivity: " + pos * 100 / countFeed() + "%";
    }

    public String validation(){
        Set <Integer> set = new HashSet<>(idBank);
        if(set.size()==idBank.size()&&!idContainsSpace){
            return "IDs are Valid";
        }
        else{
            return "IDs are Not Valid";

        }
        
    }
    public void setIDContainsSpace(Boolean b){
        idContainsSpace = b;
    }
    public Boolean getIDContainsSpace(){
        return idContainsSpace;
    }
    public String lastUpdate(){
        String prompt =  "User IDs who got lateset update: ";

        long l = 0;
        Iterator<User> i = userBank.values().iterator();
        while(i.hasNext()){
            User u = i.next();
            if(u.getLastUpdateTime()>l){
                l = u.getLastUpdateTime();
            }
        }
        Iterator<User> ii = userBank.values().iterator();
        while(ii.hasNext()){
            User u = ii.next();
            if(u.getLastUpdateTime() == l){
                prompt = prompt + u.getName() +"("+u.getId()+") ";
            }
        }
        return prompt;
    }
}
