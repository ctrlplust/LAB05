public class Player {
    private String Playername;
    private int wins;
    private int losses;
    private int draws;

// Constructor
    public Player(String Playername) {
        this.Playername = Playername;
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
    
// Dejo esto como comentario ya que no es necesario dejarlo implementado en el codigo, Es solo para un futuro si se quiere cambiar el diseño del codigo
// como ejemplo cuando vas a comparar jugadores  con con contains(new Player("Nombre")) ,  para tambien sobre escribir el Hash Code.
// y el toString es para la depuracion, para las pruebas y mostrar informacion del objeto mas legible, Se pueden agregar por que se como se ocupan los override y estos toString, se descartan para no tener problemas con la evaluacion
    
    // se sobreescribe el metodo equals para poder definir cuando dos objetos Player son iguales
    // en este caso, dos objetos Player son iguales si tienen el mismo nombre de jugador
  //  @Override
  //  public boolean equals(Object o) {
      //  if(this == o) return true; // Verifica si son el mismo objeto
       // if(!(o instanceof Player))
      //  return false; // Esto esta viendo si es una instancia o no, No son iguales
      //  Player other = (Player) o;
      //  return Playername.equals(other.Playername); // compara los nombres de los jugadores
 //   }


    //depuracion para la impresion de la informacion del jugador
  //  @Override
  //  public String toString() {
  //     return "Player{" +
//             "Playername='" + Playername + '\'' +
               // ", wins=" + wins +
              //  ", losses=" + losses +
              //  ", draws=" + draws +
              //  '}';
  //  }
}
