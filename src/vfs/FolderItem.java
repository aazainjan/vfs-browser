package vfs;

import java.util.ArrayList;
import java.util.List;

public class FolderItem extends FileComponent {

    private ArrayList<FileComponent> children = new ArrayList<>();

    public FolderItem(String name) {
        super(name);
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    public void remove(FileComponent component) {
        children.remove(component);
    }

    public FileComponent get(String name) {
        for (FileComponent child : children) {
            if (child.getName().equals(name))
                return child;
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

    public List<FileComponent> getChildren() {
        return children;
    }
}
