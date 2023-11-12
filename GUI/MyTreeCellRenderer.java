package MiniTwitter;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        // decide what icons you want by examining the node
        if (value instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            if (node.getUserObject() instanceof UserGroup) {
                // your root node, since you just put a String as a user obj
                setIcon(UIManager.getIcon("FileChooser.homeFolderIcon"));
            }
            // } else if (node.getUserObject() instanceof UserGroup) {

            // setIcon(UIManager.getIcon("FileChooser.homeFolderIcon"));

            // }
        }

        return this;
    }

}
