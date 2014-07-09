import org.junit.Test


class HandTest {

  @Test
  void should_hold_the_cards(){
    def hand = new Hand(["5H","3D","2C","6S","4S"])
    assert hand.cards.contains( new Card("5H") )
    assert hand.cards.contains( new Card("3D") )
    assert hand.cards.contains( new Card("2C") )
    assert hand.cards.contains( new Card("6S") )
    assert hand.cards.contains( new Card("4S") )
  }
  
  @Test
  void should_have_a_readable_to_string(){
    def hand = new Hand(["5H","3D","2C","6S","4S"])
    assert "[5H, 3D, 2C, 6S, 4S]" == hand.toString()
  }
  
}
