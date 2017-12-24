
public class Game {
	
	public int gameCount = 0;

	public Game(int i) {
		this.gameCount = i;
	}

	public void start(Hand hand) {
		
	}

	public Hand currentOpponentHand() {
		return new Scissors();
	}

	public GameResult currentGameInfo() {
		return new GameResult(new Rock(), new Scissors(), GameResult.JankenResult.Win);
	}

}
