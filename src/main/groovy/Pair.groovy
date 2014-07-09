import groovy.transform.ToString

class Pair 
  implements ScoringHand{
  
  HandStrength handStrength = HandStrength.PAIR
  boolean relevant=false
  
  def rank

  Pair(hand){
    def rankMap = new OfAKind(hand).rankMap
    
    def ranksWithMultiple = rankMap.findAll{ k, v -> v > 1 }
    def ranksAsPairs = rankMap.findAll{ k, v -> v == 2 }
    
    if (ranksAsPairs.size() == 1 && ranksWithMultiple.size() == 1){
      relevant=true
      rank = ranksAsPairs.keySet()[0]
    }
    
  }
  
  int compareTo(altObj){
    
    if (! relevant) throw new ComparisonNotPossibleException()
    
    this.rank.compareTo(altObj.rank) 
  }

}
