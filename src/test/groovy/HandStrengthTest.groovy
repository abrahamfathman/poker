import org.junit.Test


class HandStrengthTest {
  
  @Test
  void should_have_the_hand_strengths(){
    def handStrengths = HandStrength.values()
    testHandStrength "HIGH_CARD", "high card", handStrengths
    testHandStrength "PAIR", "pair", handStrengths
    testHandStrength "TWO_PAIRS", "two pairs",  handStrengths
    testHandStrength "THREE_OF_A_KIND", "three of a kind",  handStrengths
    testHandStrength "STRAIGHT", "straight",  handStrengths
    testHandStrength "FLUSH", "flush", handStrengths
    testHandStrength "FULL_HOUSE", "full house",  handStrengths
    testHandStrength "FOUR_OF_A_KIND", "four of a kind", handStrengths
    testHandStrength "STRAIGHT_FLUSH", "straight flush", handStrengths
    
    assert handStrengths.size() == 9
  }
  
  void testHandStrength( key, display, handStrengths ){
    def handStrength = "${key}" as HandStrength
    assert true == handStrengths.contains( handStrength )
    assert handStrength.display == display
  }
  
  @Test
  void should_sort_by_value(){
    def handStrengths = []
    handStrengths << HandStrength.STRAIGHT_FLUSH
    handStrengths << HandStrength.PAIR
    handStrengths << HandStrength.TWO_PAIRS
    assert handStrengths[2] == HandStrength.TWO_PAIRS
    
    Collections.sort(handStrengths)
    assert handStrengths[0] == HandStrength.PAIR
    assert handStrengths[1] == HandStrength.TWO_PAIRS
    assert handStrengths[2] == HandStrength.STRAIGHT_FLUSH
  }

}
