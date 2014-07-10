import groovy.transform.ToString

class Pair 
  implements ScoringHand{
  
  HandStrength handStrength = HandStrength.PAIR
  boolean relevant=false
  String name="pair"
  
  def rank

  Pair(hand){
    def rankMap = new OfAKind(hand).rankMap

    def ranksWithMultiple = rankMap.findAll{ k, v -> v > 1 }
    def ranksAsMatching = rankMap.findAll{ k, v -> v == getOfAKindMatch() }
    
    if (ranksAsMatching.size() == 1 && ranksWithMultiple.size() == 1){
      relevant=true
      rank = ranksAsMatching.keySet()[0]
    }
    
  }
  
  int compareTo(altObj){
    
    if (! relevant) throw new ComparisonNotPossibleException()
    
    this.rank.compareTo(altObj.rank)
  }
  
  int getOfAKindMatch(){2}

}
