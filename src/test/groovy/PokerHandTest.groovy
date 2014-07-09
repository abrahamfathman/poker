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
  
  @Test
  void should_create_scoring_hands_for_three_of_a_kind_and_high_card(){
    def pokerHand = new PokerHand(["10H","10D","2C","10S","6C"])
    def scoringHands = pokerHand.scoringHands
    assert 2 == scoringHands.size()
    assert scoringHands[0] instanceof ThreeOfAKind
    assert scoringHands[1] instanceof HighCard
  }
  
  @Test
  void should_create_scoring_hands_for_four_of_a_kind_and_high_card(){
    def pokerHand = new PokerHand(["10H","10D","2C","10S","10C"])
    def scoringHands = pokerHand.scoringHands
    assert 2 == scoringHands.size()
    assert scoringHands[0] instanceof FourOfAKind
    assert scoringHands[1] instanceof HighCard
  }
  
  @Test
  void should_create_scoring_hands_for_straight_and_high_card(){
    def pokerHand = new PokerHand(["10H","JD","QC","9S","8C"])
    def scoringHands = pokerHand.scoringHands
    assert 2 == scoringHands.size()
    assert scoringHands[0] instanceof Straight
    assert scoringHands[1] instanceof HighCard
  }
  
  @Test
  void should_create_scoring_hands_for_flush_and_high_card(){
    def pokerHand = new PokerHand(["10H","JH","2H","9H","8H"])
    def scoringHands = pokerHand.scoringHands
    assert 2 == scoringHands.size()
    assert scoringHands[0] instanceof Flush
    assert scoringHands[1] instanceof HighCard
  }
  
  @Test
  void should_create_scoring_hands_for_full_house_and_high_card(){
    def pokerHand = new PokerHand(["10H","10D","10S","9H","9C"])
    def scoringHands = pokerHand.scoringHands
    assert 2 == scoringHands.size()
    assert scoringHands[0] instanceof FullHouse
    assert scoringHands[1] instanceof HighCard
  }
  
  @Test
  void should_create_scoring_hands_for_straight_flush_and_flush_and_high_card(){
    def pokerHand = new PokerHand(["10H","JH","7H","9H","8H"])
    def scoringHands = pokerHand.scoringHands
    assert 4 == scoringHands.size()
    assert scoringHands[0] instanceof StraightFlush
    assert scoringHands[1] instanceof Flush
    assert scoringHands[2] instanceof Straight
    assert scoringHands[3] instanceof HighCard
  }

  @Test
  void should_rank_appropriate_hands_higher(){
    def highcard       = ["AC","9D","2H","6C","7D"]
    def pair           = ["9C","9D","2H","6C","7D"]
    def twopairs       = ["9C","9D","2H","6C","6D"]
    def threeOfAKind   = ["9C","9D","9H","5C","6D"]
    def straight       = ["9C","10D","8H","7C","6D"]
    def flush          = ["9C","AC","2C","7C","6C"]
    def fullHouse      = ["9C","9D","9S","7C","7D"]
    def fourOfAKind    = ["9C","9D","9H","5C","9S"]
    def straightFlush  = ["9C","10C","8C","7C","JC"]
    assert new PokerHand(pair) > new PokerHand(highcard)
    assert new PokerHand(twopairs) > new PokerHand(pair)
    assert new PokerHand(threeOfAKind) > new PokerHand(twopairs)
    assert new PokerHand(straight) > new PokerHand(threeOfAKind)
    assert new PokerHand(flush) > new PokerHand(straight)
    assert new PokerHand(fullHouse) > new PokerHand(flush)
    assert new PokerHand(fourOfAKind) > new PokerHand(fullHouse)
    assert new PokerHand(straightFlush) > new PokerHand(fourOfAKind)
  }
  
  @Test
  void should_rank_traverse_scoring_methods_high_card_if_a_tie_on_pair(){
    def pairLowCard   = ["9C","9D","2H","6C","7D"]
    def pairHighCard  = ["9C","9D","QH","5C","2D"]
    assert new PokerHand(pairHighCard) > new PokerHand(pairLowCard)
  }
  
  @Test
  void should_rank_traverse_scoring_methods_high_card_if_a_tie_on_two_pairs(){
    def twoPairLowCard   = ["9C","9D","2H","5D","5S"]
    def twoPairHighCard  = ["9C","9D","QH","5C","5H"]
    assert new PokerHand(twoPairHighCard) > new PokerHand(twoPairLowCard)
  }
  
  @Test
  void should_rank_traverse_scoring_methods_high_card_if_a_tie_on_flush(){
    def flushLowCard   = ["KS","9S","2S","3S","5S"]
    def flushHighCard  = ["AC","9C","QC","5C","6C"]
    assert new PokerHand(flushHighCard) > new PokerHand(flushLowCard)
  }
  
  
}
