import groovy.transform.ToString

class Pair 
  extends ScoringHand{
  
  def handScore = 2
  int getHandScore(){handScore}
  
  def rankMap = [:]
  def ranksAsPairs

  Pair(hand){
    super(hand)
    
    hand.cards.each{ card-> 
      if( rankMap."${card.rank}" == null ){
        rankMap."${card.rank}" = 0
      }
      rankMap."${card.rank}"++
    }
    ranksAsPairs = rankMap.findAll{ k, v -> v == 2 }
    if (ranksAsPairs.size() != 1 )
      handScore = 0
  }
  
  int compareTo(altObj){
    def super_thought = super.compareTo(altObj)
    if( super_thought != 0 ) return super_thought
    
    // Compare the pairs ranks
    this.ranksAsPairs.keySet()[0].compareTo(altObj.ranksAsPairs.keySet()[0]) 
  }

}
