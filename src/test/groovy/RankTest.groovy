import org.junit.Test;


class RankTest {
  
  @Test
  void should_have_the_thirteen_ranks(){
    def ranks = Rank.values()
    testRank "2", "2", ranks
    testRank "3", "3", ranks
    testRank "4", "4", ranks
    testRank "5", "5", ranks
    testRank "6", "6", ranks
    testRank "7", "7", ranks
    testRank "8", "8", ranks
    testRank "9", "9", ranks
    testRank "10", "10", ranks
    testRank "J", "Jack", ranks
    testRank "Q", "Queen", ranks
    testRank "K", "King", ranks
    testRank "A", "Ace", ranks
    
    assert ranks.size() == 13
  }
  
  void testRank( shortCode, display, ranks ){
    def rank = "R${shortCode}" as Rank
    assert true == ranks.contains( rank )
    assert rank.shortCode == shortCode
    assert rank.display == display
  }

  @Test
  void should_equal(){
    assert Rank.R3 == Rank.R3 
  }
  
  @Test
  void should_sort_by_order_they_are_declared(){
    def ranks = []
    ranks << Rank.RA
    ranks << Rank.RJ
    ranks << Rank.R3
    assert ranks[2] == Rank.R3
    
    Collections.sort(ranks)
    assert ranks[0] == Rank.R3
    assert ranks[1] == Rank.RJ
    assert ranks[2] == Rank.RA
  }
}
