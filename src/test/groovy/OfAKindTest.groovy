import org.junit.Test


class OfAKindTest {

  @Test
  void should_create_a_map_of_ranks(){
    def hand = new Hand(["2H","6D","2C","6S","6C"])
    def ofAKind = new OfAKind(hand)
    def rankMap = ofAKind.getRankMap()
    assert rankMap.size() == 2
    assert rankMap.keySet()[0] == Rank.R2
    assert rankMap.keySet()[1] == Rank.R6
    
    assert rankMap.values()[0] == 2
    assert rankMap.values()[1] == 3
      
  }
  
}
