public class BST {
    private Node raiz;

    private class Node {
        int key; // Numero de victorias para el Scoreboard
        Strign value; // Nombre del jugador para el Scoreboard
        Node left, right;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    public BST() {
        raiz = null;
    }

    public void insert(int key, String value) {
        raiz = insertRec(raiz, key, value);
    }

    private Node insertRec(Node raiz, int key , String value) {
        if (raiz == null) {
            raiz = new Node(key, value);
            return raiz;
        }
        if (key < raiz.key) {
            raiz.left = insertRec(raiz.left, key, value);
        } else if (key > raiz.key) {
            raiz.right = insertRec(raiz.right, key, value);
        }
        return raiz;
    }

    public void inorder() {
        inorderRec(raiz);
    }

    private void inorderRec(Node raiz) {
        if (raiz != null) {
            inorderRec(raiz.left);
            System.out.print("Ganadas: " + raiz.key + " Jugador: " + raiz.value + "\n");
            inorderRec(raiz.right);
        }
    }
}
