import java.util.Random;

public class Game {
	
	// ジャンケンの実施回数を管理(2回勝負、3回勝負など)
	public int gameCount = 0;
	public Hand myHand;
	public Hand opponentHand;
	
	public enum Hands {
		Rock(1),
		Paper(2),
		Scissors(3);
		
		private int id;

	    private Hands(final int id) {
	        this.id = id;
	    }
	    
	    public int getInt() {
	        return this.id;
	    }
	}	

	public Game(int gameCount) {
		// TODO 回数を管理しているけど、1回勝負までしか実装していない。。
		this.gameCount = gameCount;
	}

	public void start(Hand myHand) {
		this.myHand = myHand;
	}

	public Hand currentOpponentHand() {
		return new Scissors();
	}

	public GameResult currentGameInfo() {
		// 相手の手の抽選処理
		Random rnd = new Random();
		int rndOpponetHandInt = rnd.nextInt(3) + 1;
		if(rndOpponetHandInt == Hands.Rock.getInt()) {
			this.opponentHand = new Rock();
		}else if(rndOpponetHandInt == Hands.Paper.getInt()) {
			this.opponentHand = new Paper();
		}else if(rndOpponetHandInt == Hands.Scissors.getInt()){
			this.opponentHand = new Scissors();
		}else {
			// TODO 例外処理
		}
		
		return new GameResult(this.myHand, this.opponentHand, judge(this.myHand, this.opponentHand));
	}
	
	// 指定された相手の手を用いることができる判定処理動作テスト用メソッド
	public GameResult currentGameInfo(Hand opponentHand) {
		return new GameResult(this.myHand, this.opponentHand, judge(this.myHand, opponentHand));
	}
	
	// ジャンケンの勝敗を判定する
	private GameResult.JankenResult judge(Hand myHand, Hand opponentHand) {
		GameResult.JankenResult result = GameResult.JankenResult.Draw;
		
		if(myHand.getClass() == new Rock().getClass() && opponentHand.getClass() == new Scissors().getClass()) {
			result = GameResult.JankenResult.Win;
		}else if(myHand.getClass() == new Rock().getClass() && opponentHand.getClass() == new Paper().getClass()) {
			result = GameResult.JankenResult.Lose;
		}else if(myHand.getClass() == new Paper().getClass() && opponentHand.getClass() == new Rock().getClass()) {
			result = GameResult.JankenResult.Win;
		}else if(myHand.getClass() == new Paper().getClass() && opponentHand.getClass() == new Scissors().getClass()) {
			result = GameResult.JankenResult.Lose;
		}else if(myHand.getClass() == new Scissors().getClass() && opponentHand.getClass() == new Paper().getClass()) {
			result = GameResult.JankenResult.Win;
		}else if(myHand.getClass() == new Scissors().getClass() && opponentHand.getClass() == new Rock().getClass()) {
			result = GameResult.JankenResult.Lose;
		}
		
		return result;
	}

}
