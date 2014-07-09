import org.junit.Test;


class HandStrengthTest {
  
  @Test
  void should_have_the_hand_strengths(){
    def handStrengths = HandStrength.values()
    testHandStrength "HIGH_CARD", "high card", 1, handStrengths
    testHandStrength "PAIR", "pair", 2, handStrengths
    testHandStrength "TWO_PAIRS", "two pairs", 3, handStrengths
    testHandStrength "THREE_OF_A_KIND", "three of a kind", 4, handStrengths
    testHandStrength "STRAIGHT", "straight", 5, handStrengths
    testHandStrength "FLUSH", "flush", 6, handStrengths
    testHandStrength "FULL_HOUSE", "full house", 7, handStrengths
    testHandStrength "FOUR_OF_A_KIND", "four of a kind", 8, handStrengths
    testHandStrength "STRAIGHT_FLUSH", "straight flush", 9, handStrengths
    
    assert handStrengths.size() == 9
  }
  
  void testHandStrength( key, display, value, handStrengths ){
    def handStrength = "${key}" as HandStrength
    assert true == handStrengths.contains( handStrength )
    assert handStrength.value == value
    assert handStrength.display == display
  }

}
