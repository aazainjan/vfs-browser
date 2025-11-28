package vfs;

public class Main {
    public static void main(String[] args) {
        FolderItem root = new FolderItem("root");
        FolderItem docs = new FolderItem("docs");
        FileItem f1 = new FileItem("readme.md");
        FileItem f2 = new FileItem("notes.txt");

        docs.add(f2);
        root.add(f1);
        root.add(docs);

        System.out.println("Display tree:");
        root.display("");

        System.out.println("\nIterating with VFSIterator:");
        VFSIterator it = new VFSIterator(root);
        while (it.hasNext()) {
            VFSNode node = it.next();
            System.out.println("Found: " + node.getName());
        }
    }
}
