import org.junit.Test


class HighCardComparatorTest {
  @Test
  void should_score_correct_high_card_above_the_other(){
    assert new HighCardComparator().compare( new HighCard(new Hand(["2C"])) , new HighCard(new Hand(["3C"]))) < 0
    assert new HighCardComparator().compare( new HighCard(new Hand(["6C"])), new HighCard(new Hand(["4D"]))) > 0
    assert new HighCardComparator().compare( new HighCard(new Hand(["JH"])), new HighCard(new Hand(["JD"]))) == 0 
  }
  
  @Test
  void should_score_correct_high_card_hand_above_the_other(){
    assert new HighCardComparator().compare( new HighCard(new Hand(["2C","9C"])) , new HighCard(new Hand(["3C","2D"])) ) > 0
    assert new HighCardComparator().compare( new HighCard(new Hand(["2C","9C"])) , new HighCard(new Hand(["2D", "4D"])) ) > 0
    assert new HighCardComparator().compare( new HighCard(new Hand(["2S","5C","9S","7C","8H"])) , new HighCard(new Hand(["2D","5D","9D","7D","8D"])) ) == 0
    assert new HighCardComparator().compare( new HighCard(new Hand(["AC","9C","QC","5C","6C"])) , new HighCard(new Hand(["KS","9S","2S","3S","5S"])) ) > 0
    assert new HighCardComparator().compare( new HighCard(new Hand(["9C","9D","QH","5C","2D"])) , new HighCard(new Hand(["9C","9D","2H","6C","7D"])) ) > 0
  }

  @Test
  void should_score_correct_high_card_when_there_are_matches(){
    assert new HighCardComparator().compare( new HighCard(new Hand(["2C","9C"])) , new HighCard(new Hand(["9D","3D"])) ) < 0
    assert new HighCardComparator().compare( new HighCard(new Hand(["9C","9C","3H"])) , new HighCard(new Hand(["9D","9D","4H"])) ) < 0
  }

  @Test
  void should_score_correct_high_card_ignoring_the_pair_since_this_is_high_card(){
    assert new HighCardComparator().compare( new HighCard(new Hand(["2C","2D","AH"])) , new HighCard(new Hand(["9D","9C","2H"])) ) > 0
  }
  
  @Test
  void should_determine_winning_card(){
    def hcc = new HighCardComparator()
    assert hcc.compare( new HighCard(new Hand(["2C","2D","AH"])) , new HighCard(new Hand(["9D","9C","2H"])) )
    assert hcc.winningCard.rank == Rank.RA
  }
  
  @Test
  void should_determine_winning_card_in_second_hand(){
    def hcc = new HighCardComparator()
    assert hcc.compare( new HighCard(new Hand(["2C","2D","4H"])) , new HighCard(new Hand(["9D","9C","AH"])) )
    assert hcc.winningCard.rank == Rank.RA
  }
  
}
