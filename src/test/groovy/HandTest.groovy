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
  
  @Test
  void should_create_scoring_hands_for_high_card(){
    def hand = new Hand(["10H","3D","2C","6S","4S"])
    //hand.calculateScoringHands()
    def scoringHands = hand.scoringHands
    assert 1 == scoringHands.size()
    assert scoringHands[0] instanceof HighCard
  }
  
  @Test
  void should_create_scoring_hands_for_pair_and_high_card(){
    def hand = new Hand(["10H","3D","2C","6S","6C"])
    //hand.calculateScoringHands()
    def scoringHands = hand.scoringHands
    assert 2 == scoringHands.size()
    assert scoringHands[0] instanceof HighCard
    assert scoringHands[1] instanceof Pair
  }
  
}
