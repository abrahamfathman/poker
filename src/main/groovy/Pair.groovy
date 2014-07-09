import groovy.transform.ToString

class Pair 
  implements ScoringHand{
  
  def handScore = 2
  HandStrength getHandStrength(){HandStrength.PAIR}
  boolean relevant=false
  
  def hand
  def rankMap = [:]
  def ranksAsPairs

  Pair(hand){
    this.hand=hand
    
    hand.cards.each{ card-> 
      if( ! rankMap."${card.rank}" ) rankMap."${card.rank}" = 0
      rankMap."${card.rank}"++
    }
    ranksAsPairs = rankMap.findAll{ k, v -> v == 2 }
    if (ranksAsPairs.size() == 1 ) relevant=true
  }
  
  int compareTo(altObj){
    
    if (! relevant) throw new ComparisonNotPossibleException()
    
    if( this.class != altObj.class )
      return this.handStrength.value.compareTo(altObj.handStrength.value)
    
    this.ranksAsPairs.keySet()[0].compareTo(altObj.ranksAsPairs.keySet()[0]) 
  }

}
