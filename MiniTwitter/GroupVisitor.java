package MiniTwitter;

public class GroupVisitor implements Visitor {
    public GroupVisitor() {
    };

    @Override
    public int visit(User u) {
        return 0;
    }

    @Override
    public int visit(UserGroup g) {
        int c = 1;
        for (Member m : g.getMembers()) {
            System.out.print("h");
            c += m.accept(this);
        }
        return c;
    }
}
