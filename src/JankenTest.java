import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class JankenTest {

	public static class ジャンケンゲームの環境周りを確認{
		@Test
		public void 設定したルールが指定したようにセットされている() {
			Game game = new Game(1);
			game.start(new Rock());
			assertEquals(1, game.gameCount);
		}
	}
	
	
	public static class パターンテスト{
		
		Game game;
		
		@Before
		public void setUp() {
			game = new Game(1);
		}
	
		@Test
		public void グーの時はチョキに勝つ() {
			game.start(new Rock());
			GameResult currentGameResult = game.currentGameInfo(new Scissors());
			
			assertEquals(GameResult.JankenResult.Win, currentGameResult.Result);
		}
		
		@Test
		public void グーの時はパーに負ける() {
			game.start(new Rock());
			GameResult currentGameResult = game.currentGameInfo(new Paper());
			
			assertEquals(GameResult.JankenResult.Lose, currentGameResult.Result);
		}
		
		@Test
		public void グーの時はグーとあいこになる() {
			game.start(new Rock());
			GameResult currentGameResult = game.currentGameInfo(new Rock());
			
			assertEquals(GameResult.JankenResult.Draw, currentGameResult.Result);
		}
		
		@Test
		public void パーの時はチョキに負ける() {
			game.start(new Paper());
			GameResult currentGameResult = game.currentGameInfo(new Scissors());
			
			assertEquals(GameResult.JankenResult.Lose, currentGameResult.Result);
		}
		
		@Test
		public void パーの時はグーに勝つ() {
			game.start(new Paper());
			GameResult currentGameResult = game.currentGameInfo(new Scissors());
			
			assertEquals(GameResult.JankenResult.Lose, currentGameResult.Result);
		}
	
	}

}
