package vfs;

public abstract class FileComponent implements VFSNode {
    protected String name;

    public FileComponent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract void display(String indent);
}
