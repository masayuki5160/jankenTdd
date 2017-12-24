
public class GameResult {
	public Hand MyHand;
	public Hand OpponentHand;
	public static enum JankenResult{
		Win,
		Lose,
		Draw
	}
	public JankenResult Result;
	
	public GameResult(Hand MyHand, Hand OpponentHand, JankenResult Result) {
		this.MyHand = MyHand;
		this.OpponentHand = OpponentHand;
		this.Result = Result;
	}

}
