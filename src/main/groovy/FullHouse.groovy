
class FullHouse
implements ScoringHand {

  HandStrength handStrength = HandStrength.FULL_HOUSE
  boolean relevant=false
  String name = "full house"

  def rankHigh

  FullHouse(hand){
    def rankMap = new OfAKind(hand).rankMap
    
    def ranksAsPairs = rankMap.findAll{ k, v -> v == 2 }
    def ranksAsTrios = rankMap.findAll{ k, v -> v == 3 }
    if (ranksAsPairs.size() == 1 && ranksAsTrios.size() == 1 ){
      relevant=true
      rankHigh = ranksAsTrios.keySet()[0]
    }
  }
  
  int compareTo( altObj ){

    if (! relevant) throw new ComparisonNotPossibleException()
    
    this.rankHigh.compareTo(altObj.rankHigh)
  }
}
