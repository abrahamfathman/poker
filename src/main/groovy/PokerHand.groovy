

class PokerHand 
  extends Hand
  implements Comparable{
  def scoringHands = []
  def playerName

  PokerHand(List<String> cards, playerName="Player1"){
    super(cards)
    this.playerName = playerName
    calculateScoringHands()
  }
  
  void calculateScoringHands(){
    scoringHands << new StraightFlush(this)
    scoringHands << new FourOfAKind(this)
    scoringHands << new FullHouse(this)
    scoringHands << new Flush(this)
    scoringHands << new Straight(this)
    scoringHands << new ThreeOfAKind(this)
    scoringHands << new TwoPairs(this)
    scoringHands << new Pair(this)
    scoringHands << new HighCard(this)
    scoringHands = scoringHands.grep{ it-> it.relevant }
  }
  
  int compareTo( altObj ){
    def handStrengthCompare = this.scoringHands[0].handStrength.compareTo(altObj.scoringHands[0].handStrength)
    if( handStrengthCompare != 0 ) return handStrengthCompare
    
    for( int x = 0; x < scoringHands.size(); x++ ){
       def compare = scoringHands[x].compareTo(altObj.scoringHands[x])
       if (compare != 0) return compare 
    }
      
  }
  
}
