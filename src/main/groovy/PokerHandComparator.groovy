
class PokerHandComparator
  implements Comparator {
    
  def winningMessage
  def tie = false

  int compare( o1, o2) {
    
    // Compare the hands based on the strength of their scoring hands
    def compare = o1.scoringHand.handStrength.compareTo(o2.scoringHand.handStrength)
    
    if( compare == 0 ){ // The hand strengths are the same (they are both full houses) so compare them against each other
      
      // If we are comparing a HighCard, use a special Comparator so we can extract the "winning card"
      if( o1.scoringHand instanceof HighCard ){
        def hcc = new HighCardComparator()
        compare = hcc.compare(new HighCard(o1), new HighCard(o2))
        if( compare != 0 ) // not a tie
          winningMessage = "high card: "+ hcc.winningCard.rank.display
      }
      else{ // Compare the scoring hands using their default comparator
        compare = o1.scoringHand.compareTo(o2.scoringHand)
      }
    }
    
    // We need a high card tie breaker
    if ( compare == 0 ){ 
      compare = new HighCard(o1).compareTo(new HighCard(o2))
    }
        
    // Document the winner
    if( winningMessage == null ){
      if(compare < 0 )
        winningMessage=o2.scoringHand.name
      else if( compare > 0 )
        winningMessage=o1.scoringHand.name
    }
    
    tie = compare == 0
      
      
    compare
  }

}
