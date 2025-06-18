public class Testing_ConnectFour {
    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();

        int[] jugadas = {0, 1, 0, 1, 0, 1, 0}; // Jugadas para que 'X' gane verticalmente en la columna 0

        for (int i = 0; i < jugadas.length; i++) {
            boolean hecho = game.makeMove(jugadas[i]);
            System.out.println("Turno " + (i+1) + " -> Columna: " + jugadas[i] + " -> " + (hecho ? "OK" : "Inválido"));
            mostrarTablero(game.getGrid());
            
            char resultado = game.isGameOver();
            if (resultado == 'X' || resultado == 'O') {
                System.out.println("¡Jugador '" + resultado + "' ha ganado!");
                return;
            } else if (resultado == 'D') {
                System.out.println("El juego terminó en empate.");
                return;
            }
        }

        System.out.println("El juego aún no termina.");
    }

    public static void mostrarTablero(char[][] grid) {
        System.out.println("Estado actual del tablero:");
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("|" + grid[col][row]);
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
    }
}