import org.junit.Test;


class StraightFlushTest {
  @Test
  void should_be_relevant_when_straight_flush_is_present(){
    assert new StraightFlush(new Hand(["QH","JH","KH","9H","10H"])).relevant
    assert new StraightFlush(new Hand(["QC","JC","AC","KC","10C"])).relevant
  }
  
  @Test
  void should_have_proper_hand_strength(){
    assert new StraightFlush(new Hand(["3H","2D","5C","4S","6C"])).handStrength == HandStrength.STRAIGHT_FLUSH
  }
  
  @Test
  void should_name_hand(){
    assert new StraightFlush(new Hand(["QH","8D","8C","9S","10C"])).name == "straight flush"
  }


  @Test
  void should_not_be_relevant_when_flush_is_not_present(){
    assert ! new StraightFlush(new Hand(["QH","8D","8C","9S","10C"])).relevant
  }
  
  @Test
  void should_extract_high_rank(){
    assert new StraightFlush(new Hand(["QH","JH","8H","9H","10H"])).rankHigh == Rank.RQ
    assert new StraightFlush(new Hand(["QC","JC","AC","KC","10C"])).rankHigh == Rank.RA
  }
  
  @Test
  void should_place_high_rank_straight_above_lower_rank_straight(){
    assert new Straight(new Hand(["QH","JH","AH","KH","10H"])) > new StraightFlush(new Hand(["QD","JD","8D","9D","10D"]))
  }
  
  @Test
  void should_not_consider_one_higher_than_the_other(){
    assert new StraightFlush(new Hand(["QH","JH","9H","8H","10H"])).compareTo( new StraightFlush(new Hand(["QH","JH","9H","8H","10H"]))) == 0
  }
  
  @Test(expected = ComparisonNotPossibleException)
  void should_not_allow_comparison_when_not_relevant(){
    assert new StraightFlush(new Hand(["4H","3H","2H","5H","6D"])).compareTo( new StraightFlush(new Hand(["2C","3H","5C","4C","6C"])) )
  }
}
