package vfs;

import java.util.ArrayList;
import java.util.List;

public class FolderItem implements VFSNode {
    private String name;
    private List<VFSNode> children = new ArrayList<>();

    public FolderItem(String name) {
        this.name = name;
    }

    public void add(VFSNode node) {
        children.add(node);
    }

    public List<VFSNode> getChildren() {
    return children;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ " + name);
        for (VFSNode child : children) {
            child.display(indent + "  ");
        }
    }
}
