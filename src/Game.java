import java.util.Random;

public class Game {
	
	// ジャンケンの実施回数を管理(2回勝負、3回勝負など)
	public int gameCount = 0;
	private Hand myHand;
	private Hand opponentHand;
	private GameResult currentGameResult; 
	
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
		
		// ジャンケンの実施と結果の格納
		this.currentGameResult = new GameResult(this.myHand, this.opponentHand, judge(this.myHand, this.opponentHand));
	}
	
	/**
	 * 判定処理の動作テスト用のメソッド
	 * @param myHand 自分の手
	 * @param opponentHand 相手の手
	 */
	public void start(Hand myHand, Hand opponentHand) {
		this.myHand = myHand;
		this.opponentHand = opponentHand;
		
		// ジャンケンの実施と結果の格納
		this.currentGameResult = new GameResult(this.myHand, this.opponentHand, judge(this.myHand, this.opponentHand));		
	}

	public GameResult currentGameInfo() {
		return this.currentGameResult;
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
