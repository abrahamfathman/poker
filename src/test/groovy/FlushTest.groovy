import org.junit.Test


class FlushTest {
  @Test
  void should_be_relevant_when_flush_is_present(){
    assert new Flush(new Hand(["QH","JH","2H","9H","10H"])).relevant
    assert new Flush(new Hand(["QC","JC","2C","KC","10C"])).relevant
  }
  
  @Test
  void should_have_proper_hand_strength(){
    assert new Flush(new Hand(["3H","2D","5C","4S","6C"])).handStrength == HandStrength.FLUSH
  }
  
  @Test
  void should_name_hand(){
    assert new Flush(new Hand([])).name == "flush"
  }

  @Test
  void should_not_be_relevant_when_flush_is_not_present(){
    assert ! new Flush(new Hand(["QH","8D","8C","9S","10C"])).relevant
  }
  
  @Test
  void should_not_consider_one_higher_than_the_other(){
    assert new Flush(new Hand(["QH","JH","9H","8H","10H"])).compareTo( new Flush(new Hand(["2C","3C","AC","8C","9C"]))) == 0
  }
  
  @Test(expected = ComparisonNotPossibleException)
  void should_not_allow_comparison_when_not_relevant(){
    assert new Flush(new Hand(["QH","3C","2H","8H","10H"])).compareTo( new Flush(new Hand(["2C","3H","AC","8C","9C"])) )
  }

}
