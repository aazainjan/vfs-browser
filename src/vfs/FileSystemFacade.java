package vfs;

public class FileSystemFacade {

    private FolderItem root;

    public FileSystemFacade() {
        root = new FolderItem("root");
    }

    public void createFile(String path, String name) {
        FolderItem folder = navigateToFolder(path);
        if (folder != null) {
            folder.add(new FileItem(name));
        } else {
            System.out.println("Invalid path: " + path);
        }
    }

    public void createFolder(String path, String name) {
        FolderItem folder = navigateToFolder(path);
        if (folder != null) {
            folder.add(new FolderItem(name));
        } else {
            System.out.println("Invalid path: " + path);
        }
    }

    public void move(String sourcePath, String destPath) {
        if (sourcePath.equals("/") || destPath.equals("/"))
            return;

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

    public void showFileSystem() {
        root.display("");
    }

    public FolderItem navigateToFolder(String path) {
        if (path.equals("/"))
            return root;

        String[] parts = path.split("/");
        FolderItem current = root;
        for (String part : parts) {
            if (part.isEmpty())
                continue;
            FileComponent child = current.get(part);
            if (child instanceof FolderItem) {
                current = (FolderItem) child;
            } else {
                return null;
            }
        }
        return current;
    }

    // Deletes a file at the given path -> param filePath the full path to the file
    // (e.g., "/Documents/notes.txt")
    public void deleteFile(String filePath) {
        if (filePath == null || filePath.equals("/") || !filePath.contains("/")) {
            System.out.println("Invalid file path: " + filePath);
            return;
        }

        // Extract parent folder path and file name
        int lastSlashIndex = filePath.lastIndexOf("/");
        String parentPath = filePath.substring(0, lastSlashIndex);
        String fileName = filePath.substring(lastSlashIndex + 1);

        // Navigate to the folder
        FolderItem parentFolder = navigateToFolder(parentPath);
        if (parentFolder == null) {
            System.out.println("Invalid path: " + parentPath);
            return;
        }

        // Get the item
        FileComponent item = parentFolder.get(fileName);
        if (item == null) {
            System.out.println("File not found: " + fileName);
            return;
        }

        // Check if it's a file
        if (!(item instanceof FileItem)) {
            System.out.println("Not a file: " + fileName);
            return;
        }

        // Remove the file
        parentFolder.remove(item);
        System.out.println("Deleted file: " + filePath);
    }

}