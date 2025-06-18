import java.util.Scanner;

public class Game {
    private String status; // estado de la partida
    private String winnerPlayerName;
    private String playerNameA;
    private String playerNameB;
    private ConnectFour connectFour;

    // Constructor 
    public Game(String playerNameA, String playerNameB) {
        this.playerNameA = playerNameA;
        this.playerNameB = playerNameB;
        this.connectFour = new ConnectFour();
        this.status = "IN_PROGRESS"; // Comienza el progeso
        this.winnerPlayerName = null;
    }
    public char getCurrentPlayerSymbol() {
        return connectFour.getCurrentSymbol();
    }
     // Intenta hacer una movimiento en la columna 
     public boolean makeMove(int col) {
        boolean movio = connectFour.makeMove(col);
        if (movio) {
            actualizarEstado();
        }
        return movio;
     }

     // verificar si el estado del juego termino o no, Actualiza el estado y el ganador si es necesario
     private void actualizarEstado() {
        char resultado = connectFour.isGameOver();
        if(resultado == 'X') {
            status = "WIN";
            winnerPlayerName = playerNameA;
        } else if (resultado == 'O') {
            status = "WIN";
            winnerPlayerName = playerNameB;
        } else if (resultado == 'D') {
            status = "DRAW";
        } else {
            status = "IN_PROGRESS";
        }
     }
         // Getters
    public String getStatus() {
        return status;
    }

    public String getWinnerPlayerName() {
        return winnerPlayerName;
    }

    public String getPlayerNameA() {
        return playerNameA;
    }

    public String getPlayerNameB() {
        return playerNameB;
    }

    public ConnectFour getConnectFour() {
        return connectFour;
    }

    // Metodo play() el cual funciona para ejecutar el juego completo, Hice un Testing_Class para probarlo, lo voy añadir aqui y el otro lo dejo como comentario pero es lo mismo
    // despues solo para llamar a play() en el main y se ejecute, El otro cambio es el metodo de ImprimirTablero

    public String play() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Comienza el juego Conecta 4 ===");

        while (getStatus().equals("IN_PROGRESS")) {
            imprimirTablero(connectFour.getGrid());
            System.out.println("Turno de " + (getCurrentPlayerSymbol() == 'X' ? playerNameA : playerNameB));
            System.out.print("Ingresa columna (0-6): ");
            
            int columna;
            try {
                columna = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                sc.next(); // limpiar scanner
                continue;
            }

            if (!makeMove(columna)) {
                System.out.println("Movimiento inválido. Intenta otra columna.");
            }
        }

        imprimirTablero(connectFour.getGrid());

        if (getStatus().equals("VICTORY")) {
            System.out.println("¡Victoria para " + winnerPlayerName + "!");
            return winnerPlayerName;
        } else if (getStatus().equals("DRAW")) {
            System.out.println("Empate. El tablero está lleno.");
            return " ";
        }

        return " ";
    }
    private void imprimirTablero(char[][] grid) {
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
