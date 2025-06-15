import java.util.*;

public class HashST<Key, Value> {
    private static final int INIT_CAPACITY = 16;
    private LinkedList<Node<Key, Value>>[] tabla;
    
@SuppressWarnings("unchecked")
    public HashST() {
        tabla = new LinkedList[INIT_CAPACITY]; // aquí se genera la advertencia
        for (int i = 0; i < INIT_CAPACITY; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % tabla.length;
    }
    public void put(Key key, Value value) {
        int index = hash(key);
        for (Node<Key, Value> node : tabla[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        tabla[index].add(new Node<>(key, value));
    }
    public Value get(Key key) {
        int index = hash(key);
        for (Node<Key, Value> node : tabla[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }
    private static class Node<Key, Value> {
        Key key;
        Value value;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
