import java.util.List;
import java.util.ArrayList;
public class BST {
    private Node raiz;

    private class Node {
        int key; // Numero de victorias para el Scoreboard
        List<String> names; // Nombre del jugador para el Scoreboard
        Node left, right;

        Node(int key, String name) {
            this.key = key;
            this.names = new ArrayList<>();
            this.names.add(name);
            this.left = this.right = null;
        }
    }

    public BST() {
        raiz = null;
    }

    public void insert(int key, String names) {
        raiz = insertRec(raiz, key, names);
    }

    private Node insertRec(Node raiz, int key , String names) {
        if (raiz == null) {
            raiz = new Node(key, names);
            return raiz;
        }
        if (key < raiz.key) {
            raiz.left = insertRec(raiz.left, key, names);
        } else if (key > raiz.key) {
            raiz.right = insertRec(raiz.right, key, names);
        } else {
            if(!raiz.names.contains(names)) {
                raiz.names.add(names);
            }
        }
        return raiz;
    }

    // Para agregar el metodo "WINRANGE" se debe modificar la clase BST y incluir un metodo llamado "getkeysInRange(Conseguir llaves en rango)"
    public List<String> getKeysInRange(int lo, int hi) {
        List<String> result = new ArrayList<>();
        getKeysInRangeRec(raiz, lo, hi, result);
        return result;
    }

    private void getKeysInRangeRec(Node raiz, int lo, int hi, List<String> result) {
        if (raiz == null) {
            return;
        }
        if (lo < raiz.key) {
            getKeysInRangeRec(raiz.left, lo, hi, result);
        }
        if (lo <= raiz.key && hi >= raiz.key) {
            result.addAll(raiz.names);
        }
        if (hi > raiz.key) {
            getKeysInRangeRec(raiz.right, lo, hi, result);
        }
    }

    // Para agregar "Winsuccessor" se debe modificar la clase BST e incluir un metodo llamado "getSuccessor(Conseguir sucesor)"
    public Integer getSuccessorKey(int key) {
        Node current = raiz;
        Node successor = null;
        while (current != null) {
            if (key < current.key) {
                successor = current; // posible sucesor
                current = current.left;
            } else {
                current = current.right;
            }
        }
        // retorna la key del sucesor si existe, de lo contrario retorna null
        return (successor != null) ? successor.key : null;
    }

    // getValuesbykey (conseguir valores por llave)
    public List<String> getValuesByKey(int key) {
        Node current = raiz;
        while (current != null) {
            if (key == current.key) {
                return current.names;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return new ArrayList<>(); // Retorna una lista vacia si no se encuentra la llave
    }

    public void inorder() {
        inorderRec(raiz);
    }

    private void inorderRec(Node raiz) {
        if (raiz != null) {
            inorderRec(raiz.left);
            System.out.print("Ganadas: " + raiz.key + " Jugador: " + raiz.names + "\n");
            inorderRec(raiz.right);
        }
    }
}
