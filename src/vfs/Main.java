package vfs;

public class Main {
    public static void main(String[] args) {
        FileSystemFacade fs = new FileSystemFacade();

        // root -> create hello.txt file
        fs.createFile("/", "hello.txt");

        // create Documents folder under root and create notes.txt inside it
        fs.createFolder("/", "Documents");
        fs.createFile("/Documents", "notes.txt");

        // show initial FS
        System.out.println("Initial File System:");
        fs.showFileSystem();

        // move hello.txt into Documents
        fs.move("/hello.txt", "/Documents");

        // show after move
        System.out.println("\nAfter moving hello.txt to Documents:");
        fs.showFileSystem();

        // deleting file demo
        System.out.println("\nDeleting notes.txt from Documents:");
        fs.deleteFile("/Documents/notes.txt");

        // show after delete
        System.out.println("\nAfter deleting notes.txt:");
        fs.showFileSystem();

        // create decorated file (encrypted) and add to root manually then open with
        // facade
        FileItem secret = new FileItem("secret.txt");
        FileDecorator encrypted = new EncryptedFile(secret);
        System.out.println("\nDecorators demo:");
        encrypted.display("");
        encrypted.open();

        // compressed file demo
        FileItem report = new FileItem("report.pdf");
        FileDecorator compressed = new CompressedFile(report);
        System.out.println("\nOpening compressed file:");
        compressed.open();

        // final show
        System.out.println("\nFinal File System:");
        fs.showFileSystem();
    }
}
