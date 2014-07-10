import org.junit.Ignore
import org.junit.Test


class PokerHandComparatorTest {
  
  
  @Test
  void should_rank_appropriate_hands_higher(){
    def highcard       = ["AC","9D","2H","6C","7D"]
    def pair           = ["9C","9D","2H","6C","7D"]
    def twopairs       = ["9C","9D","2H","6C","6D"]
    def threeOfAKind   = ["9C","9D","9H","5C","6D"]
    def straight       = ["9C","10D","8H","7C","6D"]
    def flush          = ["9C","AC","2C","7C","6C"]
    def fullHouse      = ["9C","9D","9S","7C","7D"]
    def fourOfAKind    = ["9C","9D","9H","5C","9S"]
    def straightFlush  = ["9C","10C","8C","7C","JC"]
    
    def pokerHandComparator = new PokerHandComparator()
    
    assert pokerHandComparator.compare(new PokerHand(pair), new PokerHand(highcard) ) == 1
    assert pokerHandComparator.compare(new PokerHand(twopairs), new PokerHand(pair) ) == 1
    assert pokerHandComparator.compare(new PokerHand(threeOfAKind), new PokerHand(twopairs) ) == 1
    assert pokerHandComparator.compare(new PokerHand(straight), new PokerHand(threeOfAKind) ) == 1
    assert pokerHandComparator.compare(new PokerHand(flush), new PokerHand(straight) ) == 1
    assert pokerHandComparator.compare(new PokerHand(fullHouse), new PokerHand(flush) ) == 1
    assert pokerHandComparator.compare(new PokerHand(fourOfAKind), new PokerHand(fullHouse) ) == 1
    assert pokerHandComparator.compare(new PokerHand(straightFlush), new PokerHand(fourOfAKind) ) == 1
    
    assert pokerHandComparator.compare(new PokerHand(fourOfAKind), new PokerHand(straightFlush) ) == -1
  }

  @Test
  void should_determine_winning_message_different_hand_strength(){
    def pair   = ["3C","3D","2H","6C","7D"]
    def high  = ["QC","9D","KH","5C","2D"]
    def pkh = new PokerHandComparator()
    
    assert pkh.compare(new PokerHand(high), new PokerHand(pair) ) == -1
    assert pkh.winningMessage == "pair"
    
    // Test both -1 and 1 scenarios
    assert pkh.compare(new PokerHand(pair), new PokerHand(high) ) == 1
    assert pkh.winningMessage == "pair"

  }
  
  @Test
  void should_determine_winning_message_same_hand_strength(){
    def low   = ["9C","3D","2H","6C","7D"]
    def high  = ["QC","9D","KH","5C","2D"]
    def pkh = new PokerHandComparator()
    
    assert pkh.compare(new PokerHand(high), new PokerHand(low) ) > 0
    assert pkh.winningMessage == "high card: King"
    
    assert pkh.compare(new PokerHand(low), new PokerHand(high) ) < 0
    assert pkh.winningMessage == "high card: King"
  }
  
  @Test
  void should_determine_winning_message_high_card_second_card_same_hand_strength(){
    def low   = ["9C","3D","KH","6C","7D"]
    def high  = ["QC","9D","KH","5C","2D"]
    def pkh = new PokerHandComparator()
    
    assert pkh.compare(new PokerHand(high), new PokerHand(low) ) > 0
    assert pkh.winningMessage == "high card: Queen"
    
    assert pkh.compare(new PokerHand(low), new PokerHand(high) ) < 0
    assert pkh.winningMessage == "high card: Queen"
  }

  
  @Test
  void should_determine_winning_message_high_card_tie_break_required(){
    def twoPairLowCard   = ["9C","9D","2H","5D","5S"]
    def twoPairHighCard  = ["9C","9D","QH","5C","5H"]
    
    def pkh = new PokerHandComparator()
    
    assert pkh.compare(new PokerHand(twoPairHighCard), new PokerHand(twoPairLowCard) ) > 0
    assert pkh.winningMessage == "two pairs"
    
    assert pkh.compare(new PokerHand(twoPairLowCard), new PokerHand(twoPairHighCard) ) < 0
    assert pkh.winningMessage == "two pairs"
    assert !pkh.tie
    
  }
  

  
  @Test
  void should_determine_it_is_a_tie(){
    def cards   = ["9C","3D","KH","6C","7D"]
    def pkh = new PokerHandComparator()
    
    
    assert pkh.compare(new PokerHand(cards), new PokerHand(cards) ) == 0
    assert pkh.winningMessage == null
    assert pkh.tie
    
    assert pkh.compare(new PokerHand(cards), new PokerHand(cards) ) == 0
    assert pkh.winningMessage == null
    assert pkh.tie
  }


  @Test
  void should_rank_using_scoring_method_if_hand_strengths_are_the_same(){
    def pairLow   = ["9C","9D","2H","6C","7D"]
    def pairHigh  = ["QC","9D","QH","5C","2D"]
    assert new PokerHandComparator().compare(new PokerHand(pairHigh), new PokerHand(pairLow) ) > 0
  }

  
  @Test
  void should_high_card_tie_break_if_a_tie_on_pair(){
    def pairLowCard   = ["9C","9D","2H","6C","7D"]
    def pairHighCard  = ["9C","9D","QH","5C","2D"]
    assert new PokerHandComparator().compare(new PokerHand(pairHighCard), new PokerHand(pairLowCard) ) > 0
  }

  @Test
  void should_high_card_tie_break_if_a_tie_on_two_pairs(){
    def twoPairLowCard   = ["9C","9D","2H","5D","5S"]
    def twoPairHighCard  = ["9C","9D","QH","5C","5H"]
    assert new PokerHandComparator().compare(new PokerHand(twoPairHighCard), new PokerHand(twoPairLowCard) ) > 0
  }

  @Test
  void should_high_card_tie_break_if_a_tie_on_flush(){
    def flushLowCard   = ["KS","9S","2S","3S","5S"]
    def flushHighCard  = ["AC","9C","QC","5C","6C"]
    assert new PokerHandComparator().compare(new PokerHand(flushHighCard), new PokerHand(flushLowCard) ) > 0
  }
  
}
