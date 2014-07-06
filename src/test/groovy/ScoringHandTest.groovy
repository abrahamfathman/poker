import org.junit.Test


class ScoringHandTest {

  @Test
  void should_score_pair_above_high_card(){
    assert new Pair(new Hand(["2H","2D"])) > new HighCard(new Hand(["AC"]))
    assert new HighCard(new Hand(["AC"])) < new Pair(new Hand(["2H","2D"])) 
  }

  
}
