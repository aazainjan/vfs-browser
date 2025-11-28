package vfs;

public class CompressedFile extends FileDecorator {

    public CompressedFile(FileItem file) {
        super(file);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- (Compressed) " + file.getName());
    }

    @Override
    public void open() {
        System.out.println("Decompressing " + file.getName() + "...");
        System.out.println("Opening decompressed file!");
    }
}
