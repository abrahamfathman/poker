import org.junit.Test;


class ThreeOfAKindTest {
  @Test
  void should_be_relevant_when_three_of_a_kind_are_present(){
    def hand = new Hand(["2H","6D","AC","6S","6C"])
    def threeOfAKind = new ThreeOfAKind(hand)
    assert threeOfAKind.relevant
  }
  
  @Test
  void should_have_proper_hand_strength(){
    def hand = new Hand(["2H","6D","AC","6S","6C"])
    def threeOfAKind = new ThreeOfAKind(hand)
    assert threeOfAKind.handStrength == HandStrength.THREE_OF_A_KIND
  }
  
  @Test
  void should_extract_rank_of_three_of_a_kind(){
    def hand = new Hand(["10H","6D","2C","6S","6C"])
    def threeOfAKind = new ThreeOfAKind(hand)
    assert Rank.R6 == threeOfAKind.rank
  }
  
  @Test
  void should_name_hand(){
    assert new ThreeOfAKind(new Hand(["9C","8H", "9S", "9D", "3C"])).name == "three of a kind" 
  }
  
  @Test
  void should_not_be_relevant_when_three_of_a_kind_is_not_present(){
    def hand = new Hand(["10H","3D","2C","6S","7C"])
    def threeOfAKind = new ThreeOfAKind(hand)
    assert ! threeOfAKind.relevant
  }
  
  @Test
  void should_not_be_relevant_when_four_of_a_kind(){
    def hand = new Hand(["10H","7H","7D","7S","7C"])
    def threeOfAKind = new ThreeOfAKind(hand)
    assert ! threeOfAKind.relevant
  }
  
  @Test
  void should_not_be_relevant_when_full_house(){
    def hand = new Hand(["8C","8H","8D","7S","7C"])
    def threeOfAKind = new ThreeOfAKind(hand)
    assert ! threeOfAKind.relevant
  }
  
  @Test(expected = ComparisonNotPossibleException)
  void should_not_allow_comparison_when_not_relevant(){
    assert new ThreeOfAKind(new Hand(["9D","9C","8H"])).compareTo( new ThreeOfAKind(new Hand(["2C","2D","AH"])) )
  }
  
  @Test
  void should_compare_two_three_of_a_kinds(){
    def threeOfAKind1 = new ThreeOfAKind(new Hand(["10H","7H","7D","7S","2C"]))
    def threeOfAKind2 = new ThreeOfAKind(new Hand(["10H","8H","8D","8S","2C"]))

    assert threeOfAKind1 < threeOfAKind2
    assert threeOfAKind2 > threeOfAKind1
  }
  
  @Test
  void should_not_consider_one_higher_than_the_other(){ // This is actually impossible if you are playing with 52 cards ;-)
    assert new ThreeOfAKind(new Hand(["7H","7D","7S"])).compareTo( new ThreeOfAKind(new Hand(["7C","7H","7D"]))) == 0
  }

}
