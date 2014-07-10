import org.junit.Test


class HighCardTest {

  @Test
  void should_be_relevant_all_of_the_time(){
    assert new HighCard(new Hand(["9C","8H"])).relevant
  }
  
  @Test
  void should_have_proper_hand_strength(){
    assert (new HighCard(new Hand(["9C","8H"]))).handStrength == HandStrength.HIGH_CARD
  }

  @Test
  void should_be_relevant_all_of_the_time2(){
    assert new HighCard(new Hand(["9C","8H"])).relevant
  }
  
  @Test
  void should_name_hand(){
    assert new HighCard(new Hand(["9C","8H"])).name == "high card: 9"
    assert new HighCard(new Hand(["9C","AH"])).name == "high card: Ace"
  }
    
  @Test
  void should_score_correct_high_card_above_the_other(){
    assert new HighCard(new Hand(["2C"])) < new HighCard(new Hand(["3C"]))
    assert new HighCard(new Hand(["6C"])) > new HighCard(new Hand(["4D"]))
    assert new HighCard(new Hand(["JH"])) == new HighCard(new Hand(["JD"]))
  }
  
  @Test
  void should_score_correct_high_card_hand_above_the_other(){
    assert new HighCard(new Hand(["2C","9C"])) > new HighCard(new Hand(["3C","2D"]))
    assert new HighCard(new Hand(["2C","9C"])) > new HighCard(new Hand(["2D", "4D"]))
    assert new HighCard(new Hand(["2S","5C","9S","7C","8H"])) == new HighCard(new Hand(["2D","5D","9D","7D","8D"]))
    assert new HighCard(new Hand(["AC","9C","QC","5C","6C"])) > new HighCard(new Hand(["KS","9S","2S","3S","5S"]))
    assert new HighCard(new Hand(["9C","9D","QH","5C","2D"])) > new HighCard(new Hand(["9C","9D","2H","6C","7D"]))
  }

  @Test
  void should_score_correct_high_card_when_there_are_matches(){
    assert new HighCard(new Hand(["2C","9C"])) < new HighCard(new Hand(["9D","3D"]))
    assert new HighCard(new Hand(["9C","9C","3H"])) < new HighCard(new Hand(["9D","9D","4H"]))
  }

  @Test
  void should_score_correct_high_card_ignoring_the_pair_since_this_is_high_card(){
    assert new HighCard(new Hand(["2C","2D","AH"])) > new HighCard(new Hand(["9D","9C","2H"]))
  }
  
}
