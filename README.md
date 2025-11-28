# Virtual File System (VFS) Simulation in Java 📁

> A Java-based project that simulates a hierarchical file system, demonstrating core Software Design Patterns to manage file and folder operations, including dynamic features like encryption and compression.

---

## 🚀 Technical Highlights & Design Patterns

This project is structured around key object-oriented design patterns to ensure modularity, flexibility, and maintainability:

### Structural Patterns

- **Composite Pattern:** Files (`FileItem`) and folders (`FolderItem`) are treated uniformly through the `FileComponent` abstract class, allowing the creation of a tree-like hierarchy.
- **Decorator Pattern:** The system dynamically adds responsibilities (e.g., encryption, compression) to files at runtime using `EncryptedFile` and `CompressedFile` decorators, without modifying the core file classes.

### Behavioral Patterns

- **Iterator Pattern:** Implements the `VFSIterator` for traversing the entire file system hierarchy using a Depth-First Search (DFS) algorithm.

### Simplification

- **Facade Pattern:** The `FileSystemFacade` simplifies complex system interactions (like moving files or creating deep structures) for the client code (`Main.java`).

---

## 📂 Project Structure

SCD Lab Project/
│
├── src/vfs/
│ ├── Main.java # Application Entry Point and Client Demo
│ ├── FileSystemFacade.java # Facade: Simplifies high-level FS operations
│ ├── FileComponent.java # Composite: Base abstract class (Component)
│ ├── FileItem.java # Composite: Concrete Leaf (Regular File)
│ ├── FolderItem.java # Composite: Concrete Composite (Directory)
│ ├── FileDecorator.java # Decorator: Base abstract class
│ ├── EncryptedFile.java # Decorator: Adds (Encrypted) functionality
│ ├── CompressedFile.java # Decorator: Adds (Compressed) functionality
│ ├── VFSNode.java # Interface for display/traversal
│ └── VFSIterator.java # Iterator: Custom DFS Traversal
└── README.md

yaml
Copy code

---

## 🛠️ Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Compilation and Execution

Compile the source files into a `bin` directory:

```bash
javac -d bin src/vfs/*.java
Run the compiled application:

bash
Copy code
java -cp bin vfs.Main
The program will output the initial structure, demonstrate file movement, and show the effects of the decorators.

🖥️ Demonstration Output
markdown
Copy code
Initial File System:
+ root
   - hello.txt
   + Documents
      - notes.txt

After moving hello.txt to Documents:
+ root
   + Documents
      - notes.txt
      - hello.txt

Decorators Demo:
- (Encrypted) secret.txt
Decrypting secret.txt...
Opening decrypted file!

Opening compressed file:
Decompressing report.pdf...
Opening decompressed file!

Final File System:
+ root
   + Documents
      - notes.txt
      - hello.txt
💡 How to Extend This Project
Want to add more cool features? Here are a few ideas:

Add a new file type or decorator

Create a new class that extends FileDecorator (like EncryptedFile or CompressedFile).

Implement display() and open() methods for your new behavior.

Add the new decorator to files in Main.java to test it.

Add more file system operations

For example, deleteFile(), renameFile(), or copyFile() in FileSystemFacade.java.

These can use the existing FolderItem and FileComponent structure to stay consistent.

Enhance the iterator

Add other traversal options like BFS or filtering by file type.

Modify VFSIterator or create a new iterator class.

Improve output formatting

Use colors, indentation, or icons to make the FS display look nicer.

For example, show [FOLDER] or [FILE] tags in the tree output.

🧑‍💻 Author
Aazain Jan

Project created as part of the Software Construction & Development (SCD) coursework.