package vfs;

public abstract class FileDecorator extends FileItem {
    protected FileItem file;

    public FileDecorator(FileItem file) {
        super(file.getName());
        this.file = file;
    }

    @Override
    public void display(String indent) {
        file.display(indent);
    }

    public abstract void open();

}
