# Virtual File System (VFS) Simulation in Java 📁

> A 100% Java-based project that simulates a hierarchical file system, demonstrating core Software Design Patterns to manage file and folder operations, including dynamic features like encryption and compression.

---

## 🚀 Technical Highlights & Design Patterns

This project is structured relative to key object-oriented design patterns to ensure modularity, flexibility, and maintainability:

### Structural Patterns

- **Composite Pattern:** Files (`FileItem`) and folders (`FolderItem`) are treated uniformly through the `FileComponent` abstract class, allowing the creation of a tree-like hierarchy.
- **Decorator Pattern:** The system dynamically adds responsibilities (e.g., encryption, compression) to files at runtime using `EncryptedFile` and `CompressedFile` decorators, without modifying the core file classes.

### Behavioral Patterns

- **Iterator Pattern:** Implements the `VFSIterator` for traversing the entire file system hierarchy using a Depth-First Search (DFS) algorithm.

### Simplification

- **Facade Pattern:** The `FileSystemFacade` simplifies complex system interactions (like moving files or creating deep structures) for the client code (`Main.java`).

---

## 📂 Project Structure

```
SCD Lab Project/
│
├── src/vfs/
│   ├── Main.java                 # Application entry point and client demo
│   ├── FileSystemFacade.java     # Facade: simplifies high-level FS operations
│   ├── FileComponent.java        # Composite: base abstract class
│   ├── FileItem.java             # Composite: concrete leaf (regular file)
│   ├── FolderItem.java           # Composite: concrete composite (directory)
│   ├── FileDecorator.java        # Decorator: base abstract class
│   ├── EncryptedFile.java        # Decorator: adds encryption functionality
│   ├── CompressedFile.java       # Decorator: adds compression functionality
│   ├── VFSNode.java              # Interface for display/traversal
│   └── VFSIterator.java          # Iterator: custom DFS traversal
│
└── README.md
```

---
## 🛠️ Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Compilation and Execution

Compile the source files into a `bin` directory:

```bash
javac -d bin src/vfs/*.java
```

Run the compiled application:

```bash
java -cp bin vfs.Main
```

The program outputs the initial structure, demonstrates file movement, and shows the effects of decorators.

---

## 🖥️ Demonstration Output

```
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
```

---

## 💡 How to Extend This Project

* Add a new file type or decorator
* Create a new class extending `FileDecorator` (similar to `EncryptedFile` or `CompressedFile`)
* Implement `display()` and `open()` methods for the new behavior
* Apply the decorator to files in `Main.java`

### Additional Enhancements

* Add more file system operations such as `deleteFile()`, `renameFile()`, or `copyFile()` in `FileSystemFacade`
* Enhance the iterator with BFS or file-type filtering
* Improve output formatting using icons or tags like `[FOLDER]` and `[FILE]`

---

## 💻 Author

**Aazain Jan**

This project was created as part of Software Construction & Development (SCD) coursework
*Fall 2025*

---
