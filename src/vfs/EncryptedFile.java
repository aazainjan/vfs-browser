package vfs;

public class EncryptedFile extends FileDecorator {

    public EncryptedFile(FileItem file) {
        super(file);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- (Encrypted) " + file.getName());
    }

    @Override
    public void open() {
        System.out.println("Decrypting " + file.getName() + "...");
        System.out.println("Opening decrypted file!");
    }
}
