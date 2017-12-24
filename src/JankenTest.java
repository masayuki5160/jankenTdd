import static org.junit.Assert.*;

import org.junit.Test;

public class JankenTest {

	@Test
	public void 設定したルールが指定したようにセットされている() {
		Game game = new Game(1);
		game.start(new Rock());
		assertEquals(1, game.gameCount);
	}
	
	@Test
	public void グーの時はチョキに勝つ() {
		Game game = new Game(1);
		game.start(new Rock());
		GameResult currentGameResult = game.currentGameInfo();
		
		assertEquals(GameResult.JankenResult.Win, currentGameResult.Result);
	}

}
