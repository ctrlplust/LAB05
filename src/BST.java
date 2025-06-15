public class BST {
    private Node raiz;

    private class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public BST() {
        raiz = null;
    }

    public void insert(int key) {
        raiz = insertRec(raiz, key);
    }

    private Node insertRec(Node raiz, int key) {
        if (raiz == null) {
            raiz = new Node(key);
            return raiz;
        }
        if (key < raiz.key) {
            raiz.left = insertRec(raiz.left, key);
        } else if (key > raiz.key) {
            raiz.right = insertRec(raiz.right, key);
        }
        return raiz;
    }

    public void inorder() {
        inorderRec(raiz);
    }

    private void inorderRec(Node raiz) {
        if (raiz != null) {
            inorderRec(raiz.left);
            System.out.print(raiz.key + " ");
            inorderRec(raiz.right);
        }
    }
}
