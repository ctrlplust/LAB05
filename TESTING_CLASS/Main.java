// ==============Testing BST,HASH ===============================================
public class Main {
    public static void main(String[] args) {
        // === Test de HashST ===
        System.out.println("=== Test HashST ===");
        HashST<String, Integer> hashST = new HashST<>();
        hashST.put("A", 1);
        hashST.put("B", 2);
        hashST.put("C", 3);

        System.out.println("FUNCA? A: " + hashST.get("A")); // Esperado: 1
        System.out.println("FUNCA? B: " + hashST.get("B")); // Esperado: 2
        System.out.println("FUNCA? Z: " + hashST.get("Z")); // Esperado: null

        // === Test de BST ===
        System.out.println("\n=== Test BST ===");
        BST bst = new BST();
        bst.insert(15);
        bst.insert(10);
        bst.insert(5);
        bst.insert(4);

        System.out.print("En orden (BST): ");
        bst.inorder(); // Esperado: 4 5 10 15
        System.out.println();
    }
}