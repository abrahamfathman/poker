import org.junit.Test


class GameTest {

  
  
  @Test
  void should_determine_winner_between_two_hands(){
    def pair = new PokerHand(["2C","2H","9C", "10C", "JC"])
    def flush = new PokerHand(["2D","3D","9D", "10D", "JD"])
    def game = new Game([pair, flush])
    assert flush == game.winner()
  }
}
