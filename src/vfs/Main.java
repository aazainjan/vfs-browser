package vfs;

public class Main {
    public static void main(String[] args) {

        FileItem normalFile = new FileItem("report.pdf");

        FileItem encryptedFile = new EncryptedFile(normalFile);
        FileItem compressedFile = new CompressedFile(normalFile);

        System.out.println("Normal:");
        normalFile.display("");

        System.out.println("\nEncrypted:");
        encryptedFile.display("");

        System.out.println("\nCompressed:");
        compressedFile.display("");

        System.out.println("\nOpening encrypted file:");
        ((EncryptedFile) encryptedFile).open();

        System.out.println("\nOpening compressed file:");
        ((CompressedFile) compressedFile).open();
    }
}
