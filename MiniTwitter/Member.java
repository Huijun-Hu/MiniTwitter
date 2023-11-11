package MiniTwitter;

import javax.swing.tree.TreeNode;

public abstract class Member implements TreeNode {

    private int id;
    private String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    abstract int getSize();
}
