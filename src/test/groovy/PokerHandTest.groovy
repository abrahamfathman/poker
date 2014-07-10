import org.junit.Test


class PokerHandTest {
  
  @Test
  void should_house_player_name(){
    def pokerHand = new PokerHand(["5H","3D","2C","6S","4S"], "Frankie")
    assert pokerHand.playerName == "Frankie"
  }
  
  @Test
  void should_default_player_name(){
    def pokerHand = new PokerHand(["5H","3D","2C","6S","4S"])
    assert pokerHand.playerName == "Player1"
  }
  
  @Test
  void should_have_a_readable_to_string(){
    def pokerHand = new PokerHand(["5H","3D","2C","6S","4S"])
    assert "Player1: [5H, 3D, 2C, 6S, 4S]" == pokerHand.toString()
  }
  
  
  @Test
  void should_create_scoring_hands_for_high_card(){
    assert new PokerHand(["10H","3D","2C","6S","4S"]).scoringHand instanceof HighCard
  }
  
  @Test
  void should_create_scoring_hands_for_pair_and_high_card(){
    assert new PokerHand(["10H","3D","2C","6S","6C"]).scoringHand instanceof Pair
  }
  
  @Test
  void should_create_scoring_hands_for_two_pairs_and_high_card(){
    assert new PokerHand(["10H","10D","2C","6S","6C"]).scoringHand instanceof TwoPairs
  }
  
  @Test
  void should_create_scoring_hands_for_three_of_a_kind_and_high_card(){
    assert new PokerHand(["10H","10D","2C","10S","6C"]).scoringHand instanceof ThreeOfAKind
  }
  
  @Test
  void should_create_scoring_hands_for_four_of_a_kind_and_high_card(){
    assert new PokerHand(["10H","10D","2C","10S","10C"]).scoringHand instanceof FourOfAKind
  }
  
  @Test
  void should_create_scoring_hands_for_straight_and_high_card(){
    assert new PokerHand(["10H","JD","QC","9S","8C"]).scoringHand instanceof Straight
  }
  
  @Test
  void should_create_scoring_hands_for_flush_and_high_card(){
    assert new PokerHand(["10H","JH","2H","9H","8H"]).scoringHand instanceof Flush
  }
  
  @Test
  void should_create_scoring_hands_for_full_house_and_high_card(){
    assert new PokerHand(["10H","10D","10S","9H","9C"]).scoringHand instanceof FullHouse
  }
  
  @Test
  void should_create_scoring_hands_for_straight_flush_and_flush_and_high_card(){
    assert new PokerHand(["10H","JH","7H","9H","8H"]).scoringHand instanceof StraightFlush
  }
  
}
