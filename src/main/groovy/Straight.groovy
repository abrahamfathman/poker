
class Straight
implements ScoringHand {

  HandStrength handStrength = HandStrength.STRAIGHT
  boolean relevant=false

  def rankHigh

  Straight(hand){
    def ranks = hand.cards.collect{ card -> card.rank }
    Collections.sort(ranks)
    int begin = ranks[0].value
    def isStraight = true
    for( int x = begin; x < begin+4; x++ ){
      isStraight = isStraight && (ranks[x-begin].value + 1 == ranks[x-begin +1].value)
    }
    relevant = isStraight

    rankHigh = ranks[-1]
  }

  int compareTo( altObj ){

    if (! relevant) throw new ComparisonNotPossibleException()

    this.rankHigh.compareTo(altObj.rankHigh)
  }
}

