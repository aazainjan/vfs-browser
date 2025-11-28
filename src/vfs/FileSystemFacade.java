package vfs;

public class FileSystemFacade {

    private FolderItem root;

    public FileSystemFacade() {
        root = new FolderItem("root");
    }

    // Create a file in a folder
    public void createFile(String path, String name) {
        FolderItem folder = navigateToFolder(path);
        if (folder != null) {
            folder.add(new FileItem(name));
        } else {
            System.out.println("Invalid path: " + path);
        }
    }

    // Create a folder inside a folder
    public void createFolder(String path, String name) {
        FolderItem folder = navigateToFolder(path);
        if (folder != null) {
            folder.add(new FolderItem(name));
        } else {
            System.out.println("Invalid path: " + path);
        }
    }

    // Move a file or folder from source to destination
    public void move(String sourcePath, String destPath) {
        if (sourcePath.equals("/") || destPath.equals("/")) {
            System.out.println("Cannot move root folder.");
            return;
        }

        String[] sourceParts = sourcePath.split("/");
        String itemName = sourceParts[sourceParts.length - 1];
        String srcFolderPath = sourcePath.substring(0, sourcePath.lastIndexOf("/"));

        FolderItem srcFolder = navigateToFolder(srcFolderPath);
        FolderItem destFolder = navigateToFolder(destPath);

        if (srcFolder != null && destFolder != null) {
            FileComponent item = srcFolder.get(itemName);
            if (item != null) {
                srcFolder.remove(item);
                destFolder.add(item);
            } else {
                System.out.println("Item not found: " + itemName);
            }
        } else {
            System.out.println("Invalid source or destination folder.");
        }
    }

    // Show the entire file system
    public void showFileSystem() {
        root.display("");
    }

    // Navigate to a folder by path
    public FolderItem navigateToFolder(String path) {
        if (path.equals("/")) return root;

        String[] parts = path.split("/");
        FolderItem current = root;
        for (String part : parts) {
            if (part.isEmpty()) continue;
            FileComponent child = current.get(part);
            if (child instanceof FolderItem) {
                current = (FolderItem) child;
            } else {
                System.out.println("Folder not found: " + path);
                return null;
            }
        }
        return current;
    }
}
