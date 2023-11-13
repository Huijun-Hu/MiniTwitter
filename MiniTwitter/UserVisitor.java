package MiniTwitter;

public class UserVisitor implements Visitor {

    public UserVisitor() {
    };

    @Override
    public int visit(User u) {
        return 1;
    }

    @Override
    public int visit(UserGroup g) {
        int c = 0;
        for (Member m : g.getMembers()) {
            System.out.print("h");
            c += m.accept(this);
        }
        return c;
    }
}
