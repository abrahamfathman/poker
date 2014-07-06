import org.junit.Test

public class CardTest {
  
  @Test
  void should_create_a_card(){
    def c = new Card("4H")
    assert c.suit == Suit.H
    assert c.rank == Rank.R4
  }

  @Test
  void should_create_a_facecard(){
    def c = new Card("AD")
    assert c.suit == Suit.D
    assert c.rank == Rank.RA
  }

  @Test
  void should_determine_the_higher_ranking_card(){
    
    // Ace of Diamonds over 4 of Hearts
    assert new Card("AD") > new Card("4H")
    
    // Same card
    assert new Card("AD") == new Card("AD")
    
    // Same rank, diff suit
    assert new Card("AD") == new Card("AC")
    
    // 2 < 3
    assert new Card("2C") < new Card("3C")

  }
    
}
