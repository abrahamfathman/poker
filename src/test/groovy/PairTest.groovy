import org.junit.Test


class PairTest {

  @Test
  void should_be_relevant_when_pair_is_present(){
    def hand = new Hand(["10H","3D","2C","6S","6C"])
    def pair = new Pair(hand)
    assert pair.relevant
  }

  @Test
  void should_not_be_relevant_when_pair_is_not_present(){
    def hand = new Hand(["10H","3D","2C","6S","7C"])
    def pair = new Pair(hand)
    assert ! pair.relevant
  }
  
  @Test
  void should_not_be_relevant_when_three_of_a_kind(){
    def hand = new Hand(["10H","3D","7D","7S","7C"])
    def pair = new Pair(hand)
    assert ! pair.relevant
  }
  
  @Test
  void should_not_be_relevant_when_four_of_a_kind(){
    def hand = new Hand(["10H","7H","7D","7S","7C"])
    def pair = new Pair(hand)
    assert ! pair.relevant
  }
  
  @Test(expected = ComparisonNotPossibleException)
  void should_not_allow_comparison_when_not_relevant(){
    assert new Pair(new Hand(["9D","9C","9H"])).compareTo( new Pair(new Hand(["2C","2D","AH"])) )
  }
  
  @Test
  void should_default_to_hand_strength_for_score(){
    assert new Pair(new Hand(["7H","7D"])) > new HighCard(new Hand(["9C","8H"])) 
  }
  
  @Test
  void should_compare_two_pairs(){
    def pair1 = new Pair(new Hand(["10H","7H","7D","8S","2C"]))
    def pair2 = new Pair(new Hand(["10H","9H","8D","8S","2C"]))

    assert pair1 < pair2 
    assert pair2 > pair1
  }
  

}
