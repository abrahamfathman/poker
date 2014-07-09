
class TwoPairs
  implements ScoringHand {
 
  HandStrength handStrength = HandStrength.TWO_PAIRS
  boolean relevant=false
  
  def rankHigh
  def rankLow
  
  TwoPairs(hand){
    def rankMap = new OfAKind(hand).rankMap
    
    def ranksAsPairs = rankMap.findAll{ k, v -> v == 2 }
    if (ranksAsPairs.size() == 2 ){
      relevant=true
      def ranks = new TreeSet([ranksAsPairs.keySet()[0], ranksAsPairs.keySet()[1]]) // Sort the ranks using a TreeSet
      rankLow = ranks[0]
      rankHigh = ranks[1]
    }
    
  }
  
  int compareTo(altObj){
    
    if (! relevant) throw new ComparisonNotPossibleException()

    def rankHighCompare = this.rankHigh.compareTo(altObj.rankHigh)
    if( rankHighCompare != 0 )
      return rankHighCompare
      
    this.rankLow.compareTo(altObj.rankLow)
    
  }
}
