package MiniTwitter;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public abstract class Member extends Object implements MutableTreeNode {

    private int id;
    private String name;
    private long creationTime;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        setCreationTime();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setCreationTime() {
        creationTime =System.currentTimeMillis();
    }

    public long getCreationTime(){
        return creationTime;
    }

    public abstract int accept(Visitor vistor);

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public MutableTreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public void insert(MutableTreeNode child, int index) {
    }

    @Override
    public void remove(int index) {
    }

    @Override
    public void remove(MutableTreeNode node) {
    }

    @Override
    public void setUserObject(Object object) {
    }

    @Override
    public void removeFromParent() {
    }

    @Override
    public void setParent(MutableTreeNode newParent) {
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
