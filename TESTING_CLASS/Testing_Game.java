import java.util.Scanner;

/*public class Testing_Game {
    public static void main(String[] args) {
        Game partida = new Game("Tomás", "Vicente");
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Comienza el juego Conecta 4 ===");

        while (partida.getStatus().equals("IN_PROGRESS")) {
            imprimirTablero(partida.getConnectFour().getGrid());
            System.out.println("Turno de " + (partida.getCurrentPlayerSymbol() == 'X' ? partida.getPlayerNameA() : partida.getPlayerNameB()));
            System.out.print("Ingresa columna (0-6): ");
            int columna = sc.nextInt();

            if (!partida.makeMove(columna)) {
                System.out.println("Movimiento inválido. Intenta otra columna.");
            }
        }

        imprimirTablero(partida.getConnectFour().getGrid());

        // Resultado final
        if (partida.getStatus().equals("WIN")) {
            System.out.println("¡Victoria para " + partida.getWinnerPlayerName() + "!");
        } else if (partida.getStatus().equals("DRAW")) {
            System.out.println("Empate. El tablero está lleno.");
        }

        sc.close();
    }

    // Método auxiliar para imprimir el tablero
    public static void imprimirTablero(char[][] grid) {
        System.out.println("\nTablero actual:");
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("[" + grid[col][row] + "]");
            }
            System.out.println();
        }
        System.out.println(" 0  1  2  3  4  5  6\n");
    }
}
*/

public class Testing_Game {
    public static void main(String[] args) {
        Game partida = new Game("Tomás", "Vicente");
        partida.play(); // toda la lógica ahora está dentro de Game
    }
}