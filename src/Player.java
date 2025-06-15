public class Player {
    private String Playername;
    private int wins;
    private int losses;
    private int draws;

// Constructor
    public Player(String Playername) {
        thius.Playername = Playername;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }


// Metodos para obtener los datos del jugador por partida

    public void addWin() {
        wins++;
    }

    public void addDraw() {
        draws++;
    }

    public void addLoss() {
        losses++;
    }

    // Metodo win rate
    public double getWinRate() {
        int totalGames = wins + losses + draws;
        if (totalGames == 0) {
            return 0.0; // el winrate no puede ser calculado si se divide por cero
    }
        return (double) wins / totalGames * 100; // deberia retornar el porcentaje de victorias
    }

    // Getters

    public String getPlayername() {
        return Playername;
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    public int getDraws() {
        return draws;
    }

    // se sobreescribe el metodo equals para poder definir cuando dos objetos Player son iguales
    // en este caso, dos objetos Player son iguales si tienen el mismo nombre de jugador
    @Override
    public boolean equals(Objecto o) {
        if(this == o) return true; // Verifica si son el mismo objeto
        if(!(o instanceof Player))
        return false; // Esto esta viendo si es una instancia o no, No son iguales
        Player other = (Player) o;
        return Playername.equals(other.Playername); // compara los nombres de los jugadores
    }


    //depuracion para la impresion de la informacion del jugador
    @override
    public string toString() {
        return "Player{" +
                "Playername='" + Playername + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", draws=" + draws +
                '}';
    }
}