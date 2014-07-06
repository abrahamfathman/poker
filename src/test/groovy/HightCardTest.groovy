import org.junit.Test;


class HightCardTest {
  
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
