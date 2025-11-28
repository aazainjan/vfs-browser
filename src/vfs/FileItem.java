package vfs;

public class FileItem implements VFSNode {
    private String name;

    public FileItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- " + name);
    }
}
