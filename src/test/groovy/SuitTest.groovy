import org.junit.Test


class SuitTest {

  @Test
  void should_have_the_four_suits(){
    def suits = Suit.values()
    
    assert true == suits.contains(Suit.H)
    assert true == suits.contains(Suit.S)
    assert true == suits.contains(Suit.D)
    assert true == suits.contains(Suit.C)
    
    assert suits.size() == 4
  }
  
}
