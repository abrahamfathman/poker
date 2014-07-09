import org.junit.Test;


class FourOfAKindTest {
  @Test
  void should_be_relevant_when_four_of_a_kind_are_present(){
    def hand = new Hand(["6H","6D","AC","6S","6C"])
    def fourOfAKind = new FourOfAKind(hand)
    assert fourOfAKind.relevant
  }
  
  @Test
  void should_have_proper_hand_strength(){
    def hand = new Hand(["2H","6D","AC","6S","6C"])
    def fourOfAKind = new FourOfAKind(hand)
    assert fourOfAKind.handStrength == HandStrength.FOUR_OF_A_KIND
  }

}
