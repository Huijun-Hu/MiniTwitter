package MiniTwitter;

public interface Visitor {

    int visit(User u);

    int visit(UserGroup g);

}
