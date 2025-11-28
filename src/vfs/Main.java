package vfs;

public class Main {
    public static void main(String[] args) {
        FileSystemFacade fs = new FileSystemFacade();

        fs.createFile("/", "hello.txt");
        fs.createFolder("/", "Documents");
        fs.createFile("/Documents", "notes.txt");

        System.out.println("Initial File System:");
        fs.showFileSystem();

        fs.move("/hello.txt", "/Documents");

        System.out.println("\nAfter moving hello.txt to Documents:");
        fs.showFileSystem();

        System.out.println("\nDecorators demo:");
        FileItem secret = new FileItem("secret.txt");
        FileDecorator encrypted = new EncryptedFile(secret);

        FolderItem root = fs.navigateToFolder("/");
        root.add(encrypted);

        fs.showFileSystem();

        System.out.println("\nOpening encrypted file:");
        encrypted.open();
    }
}
