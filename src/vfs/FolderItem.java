package vfs;

import java.util.ArrayList;
import java.util.List;

public class FolderItem extends FileComponent {

    private ArrayList<FileComponent> children = new ArrayList<>();

    public FolderItem(String name) {
        super(name);
    }

    // Add a file or folder
    public void add(FileComponent component) {
        children.add(component);
    }

    // Remove a file or folder
    public void remove(FileComponent component) {
        children.remove(component);
    }

    // Get child by name
    public FileComponent get(String name) {
        for (FileComponent child : children) {
            if (child.getName().equals(name)) {
                return child;
            }
        }
        return null;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ " + name);
        for (FileComponent child : children) {
            child.display(indent + "   ");
        }
    }

    // Return children as VFSNode list (needed for iterator)
    public List<VFSNode> getChildren() {
        return new ArrayList<>(children);
    }
}
