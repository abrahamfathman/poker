import org.junit.Test;


class StraightTest {
  
  @Test
  void should_be_relevant_when_straight_is_present(){
    assert new Straight(new Hand(["QH","JD","8C","9S","10C"])).relevant
    assert new Straight(new Hand(["QH","JD","AC","KS","10C"])).relevant
    assert new Straight(new Hand(["3H","2D","5C","4S","6C"])).relevant
  }
  
  @Test
  void should_have_proper_hand_strength(){
    def hand = new Hand(["6H","7D","8C","9S","10C"])
    def straight = new Straight(hand)
    assert straight.handStrength == HandStrength.STRAIGHT
  }
  
  @Test
  void should_name_hand(){
    assert new Straight(new Hand(["9C","8H","7C","10D","JC"])).name == "straight"
  }

  @Test
  void should_not_be_relevant_when_straight_is_not_present(){
    assert ! new Straight(new Hand(["QH","8D","8C","9S","10C"])).relevant
  }
  
  @Test
  void should_extract_high_rank(){
    assert new Straight(new Hand(["QH","JD","8C","9S","10C"])).rankHigh == Rank.RQ
    assert new Straight(new Hand(["QH","JD","AC","KS","10C"])).rankHigh == Rank.RA
    assert new Straight(new Hand(["3H","2D","5C","4S","6C"])).rankHigh == Rank.R6
  }
  
  @Test
  void should_place_high_rank_straight_above_lower_rank_straight(){
    assert new Straight(new Hand(["QH","JD","AC","KS","10C"])) > new Straight(new Hand(["QH","JD","8C","9S","10C"]))
  }
  
  
  @Test
  void should_not_consider_one_higher_than_the_other(){
    assert new Straight(new Hand(["QH","JD","9C","8S","10C"])).compareTo(new Straight(new Hand(["QH","JD","8C","9S","10C"]))) == 0
  }
  
  @Test(expected = ComparisonNotPossibleException)
  void should_not_allow_comparison_when_not_relevant(){
    assert new Straight(new Hand(["QH","JD","2C","8S","10C"])).compareTo( new Straight(new Hand(["2C","2D","AH"])) )
  }

  
}
