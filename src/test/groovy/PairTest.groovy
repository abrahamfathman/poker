import org.junit.Test


class PairTest {

  @Test
  void should_leave_hand_score_intact_when_pair_is_present(){
    def hand = new Hand(["10H","3D","2C","6S","6C"])
    def pair = new Pair(hand)
    assert pair.handScore == 2
  }

  @Test
  void should_downgrade_hand_score_when_pair_is_not_present(){
    def hand = new Hand(["10H","3D","2C","6S","7C"])
    def pair = new Pair(hand)
    assert pair.handScore == 0
  }
  
  @Test
  void should_downgrade_hand_score_when_three_of_a_kind(){
    def hand = new Hand(["10H","3D","7D","7S","7C"])
    def pair = new Pair(hand)
    assert pair.handScore == 0
  }
  
  @Test
  void should_downgrade_hand_score_when_four_of_a_kind(){
    def hand = new Hand(["10H","7H","7D","7S","7C"])
    def pair = new Pair(hand)
    assert pair.handScore == 0
  }

}
