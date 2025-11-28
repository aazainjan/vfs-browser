package vfs;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class VFSIterator implements Iterator<VFSNode> {
    private Stack<VFSNode> stack = new Stack<>();

    public VFSIterator(VFSNode root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public VFSNode next() {
        VFSNode current = stack.pop();

        if (current instanceof FolderItem) {
            List<VFSNode> children = ((FolderItem) current).getChildren();
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }

        return current;
    }
}
