import java.util.List;
import java.util.ArrayList;

public class TestingScoreboard {
    public static void main(String[] args) {
        // Crear Scoreboard
        Scoreboard scoreboard = new Scoreboard();

        // Registrar jugadores
        scoreboard.registerPlayer("Tomás");
        scoreboard.registerPlayer("Samira");
        scoreboard.registerPlayer("Vicente");
        scoreboard.registerPlayer("Javiera");

        // Registrar resultados de partidas
        scoreboard.addGameResult("Tomás", "Vicente", false);   // Tomás gana
        scoreboard.addGameResult("Samira", "Javiera", true);   // Empate
        scoreboard.addGameResult("Tomás", "Javiera", false);   // Tomás gana
        scoreboard.addGameResult("Vicente", "Samira", false);  // Vicente gana

        // Verificar winRate
        Player tomas = scoreboard.getPlayer("Tomás");
        System.out.println("Tomás win rate: " + tomas.getWinRate());

        // Buscar jugadores con entre 1 y 2 victorias
        System.out.println("\nJugadores con entre 1 y 2 victorias:");
        Player[] rango = scoreboard.winRange(1, 2);
        for (Player p : rango) {
            System.out.println(p);
        }

        // Probar el sucesor de 1 victoria
        System.out.println("\nJugadores con la siguiente cantidad de victorias después de 1:");
        Player[] sucesores = scoreboard.winSuccessor(1);
        for (Player p : sucesores) {
            System.out.println(p);
        }
    }
}
