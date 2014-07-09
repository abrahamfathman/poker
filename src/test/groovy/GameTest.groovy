import org.junit.Test


class GameTest {

  
  
  @Test
  void should_determine_winner_between_two_hands(){
    def pair = new PokerHand(["2C","2H","9C", "10C", "JC"])
    def flush = new PokerHand(["2D","3D","9D", "10D", "JD"])
    def game = new Game([pair, flush])
    assert flush == game.winner
  }
  
  /*
  * Move the hand comparison into the Game class making it implement the Comparator interface.
  * Keep track of the "winning reason"
  * 
  * We will also need high card to keep track of "which rank" won the hand.
  * This sets the trend that "maybe it is ok for compareTo to change the state of the object(s)?
  * If we are ok with compareTo chaging the state them PokerHand could keep the compareTo method....
  * 
  */
}
