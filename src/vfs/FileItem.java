package vfs;

public class FileItem extends FileComponent {

    public FileItem(String name) {
        super(name);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- " + name);
    }
}
