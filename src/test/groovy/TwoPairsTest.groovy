import org.junit.Test


class TwoPairsTest {

  @Test
  void should_be_relevant_when_two_pairs_are_present(){
    def hand = new Hand(["2H","3D","2C","6S","6C"])
    def twoPairs = new TwoPairs(hand)
    assert twoPairs.relevant
  }
  
  @Test
  void should_have_proper_hand_strength(){
    def hand = new Hand(["2H","3D","2C","6S","6C"])
    def twoPairs = new TwoPairs(hand)
    assert twoPairs.handStrength == HandStrength.TWO_PAIRS
  }
  
  @Test
  void should_name_hand(){
    assert new TwoPairs(new Hand(["9C","8H"])).name == "two pairs"
  }
  
  @Test
  void should_extract_the_high_and_the_low_rank_high_second(){
    def hand = new Hand(["2H","3D","2C","6S","6C"])
    def twoPairs = new TwoPairs(hand)
    assert twoPairs.rankLow == Rank.R2
    assert twoPairs.rankHigh == Rank.R6
  }
  
  @Test
  void should_extract_the_high_and_the_low_rank_high_first(){
    def hand = new Hand(["AH","3D","AC","6S","6C"])
    def twoPairs = new TwoPairs(hand)
    assert twoPairs.rankLow == Rank.R6
    assert twoPairs.rankHigh == Rank.RA
  }
  
  @Test
  void should_not_be_relevant_when_two_pairs_is_not_present(){
    def hand = new Hand(["10H","3D","2C","2S","7C"])
    def twoPairs = new TwoPairs(hand)
    assert ! twoPairs.relevant
  }
  
  @Test
  void should_not_be_relevant_when_three_of_a_kind(){
    def hand = new Hand(["10H","3D","7D","7S","7C"])
    def twoPairs = new TwoPairs(hand)
    assert ! twoPairs.relevant
  }
  
  @Test
  void should_not_be_relevant_when_four_of_a_kind(){
    def hand = new Hand(["10H","7H","7D","7S","7C"])
    def twoPairs = new TwoPairs(hand)
    assert ! twoPairs.relevant
  }
  
  @Test
  void should_not_be_relevant_when_full_house(){
    def hand = new Hand(["8C","8H","8D","7S","7C"])
    def twoPairs = new TwoPairs(hand)
    assert ! twoPairs.relevant
  }
  
  @Test(expected = ComparisonNotPossibleException)
  void should_not_allow_comparison_when_not_relevant(){
    assert new TwoPairs(new Hand(["9D","9C","8H"])).compareTo( new TwoPairs(new Hand(["2C","2D","AH"])) )
  }
  
  @Test
  void should_rank_the_hand_with_higher_high_pair_correctly(){
    def twoPairs1 = new TwoPairs(new Hand(["10H","7H","7D","10S","2C"]))
    def twoPairs2 = new TwoPairs(new Hand(["10H","9H","8D","8S","9C"]))

    assert twoPairs1 > twoPairs2
    assert twoPairs2 < twoPairs1
  }
  
  @Test
  void should_rank_the_hand_with_higher_low_pair_correctly(){
    def twoPairs1 = new TwoPairs(new Hand(["10H","10H","7D","7S","2C"]))
    def twoPairs2 = new TwoPairs(new Hand(["10H","10H","8D","8S","9C"]))

    assert twoPairs1 < twoPairs2
    assert twoPairs2 > twoPairs1
  }
  
  @Test
  void should_not_consider_one_higher_than_the_other(){
    assert new TwoPairs(new Hand(["7H","7D","9D","9D"])).compareTo( new TwoPairs(new Hand(["7C","7H","9D","9D"]))) == 0
  }
  
}
