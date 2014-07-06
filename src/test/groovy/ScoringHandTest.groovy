import org.junit.Test


class ScoringHandTest {

  @Test
  void should_score_pair_above_high_card(){
    assert new Pair(["2H","2D"]) > new HighCard(["AC"])
    assert new HighCard(["AC"]) < new Pair(["2H","2D"]) 
  }
  
  @Test
  void should_score_correct_high_card_above_the_other(){
    assert new HighCard(["2C"]) < new HighCard(["3C"])
    assert new HighCard(["6C"]) > new HighCard(["4D"])
    assert new HighCard(["JH"]) == new HighCard(["JD"])
  }
}
