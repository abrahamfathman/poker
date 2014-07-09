import org.junit.Test


class PokerHandTest {
  
  @Test
  void should_have_a_readable_to_string(){
    def pokerHand = new PokerHand(["5H","3D","2C","6S","4S"])
    assert "[5H, 3D, 2C, 6S, 4S]" == pokerHand.toString()
  }
  
  
  @Test
  void should_create_scoring_hands_for_high_card(){
    def pokerHand = new PokerHand(["10H","3D","2C","6S","4S"])
    def scoringHands = pokerHand.scoringHands
    assert 1 == scoringHands.size()
    assert scoringHands[0] instanceof HighCard
  }
  
  @Test
  void should_create_scoring_hands_for_pair_and_high_card(){
    def pokerHand = new PokerHand(["10H","3D","2C","6S","6C"])
    def scoringHands = pokerHand.scoringHands
    assert 2 == scoringHands.size()
    assert scoringHands[0] instanceof Pair
    assert scoringHands[1] instanceof HighCard

  }
  
  @Test
  void should_create_scoring_hands_for_two_pairs_and_high_card(){
    def pokerHand = new PokerHand(["10H","10D","2C","6S","6C"])
    def scoringHands = pokerHand.scoringHands
    assert 2 == scoringHands.size()
    assert scoringHands[0] instanceof TwoPairs
    assert scoringHands[1] instanceof HighCard

  }
  
}
