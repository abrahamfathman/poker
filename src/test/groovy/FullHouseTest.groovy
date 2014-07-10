import org.junit.Test;


class FullHouseTest {
  @Test
  void should_be_relevant_when_straight_flush_is_present(){
    assert new FullHouse(new Hand(["QH","QC","QH","9H","9C"])).relevant
  }
  
  @Test
  void should_have_proper_hand_strength(){
    assert new FullHouse(new Hand(["QH","QC","QH","9H","9C"])).handStrength == HandStrength.FULL_HOUSE
  }
  
  @Test
  void should_be_named(){
    assert new FullHouse(new Hand(["QH","QC","QH","9H","9C"])).name == "full house"
  }

  @Test
  void should_not_be_relevant_when_flush_is_not_present(){
    assert ! new FullHouse(new Hand(["QH","10C","QH","9H","9C"])).relevant
  }
  
  
  @Test
  void should_rank_the_hand_with_higher_three_of_a_kind_correctly(){
    def fullHouse1 = new FullHouse(new Hand(["10H","10D","7D","7S","10C"]))
    def fullHouse2 = new FullHouse(new Hand(["9H","10S","9D","10S","9C"]))

    assert fullHouse1 > fullHouse2
    assert fullHouse2 < fullHouse1
  }
  
  @Test(expected = ComparisonNotPossibleException)
  void should_not_allow_comparison_when_not_relevant(){
    assert new FullHouse(new Hand(["9D","9C","8H"])).compareTo( new FullHouse(new Hand(["2C","2D","AH"])) )
  }
}
