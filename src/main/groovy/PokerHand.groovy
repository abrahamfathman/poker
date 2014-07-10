

class PokerHand 
  extends Hand {
    
  def scoringHand
  def playerName

  PokerHand(List<String> cards, playerName="Player1"){
    super(cards)
    this.playerName = playerName
    calculateScoringHand()
  }
  
  void calculateScoringHand(){
    def potentialScoringHands = []
    potentialScoringHands << new StraightFlush(this)
    potentialScoringHands << new FourOfAKind(this)
    potentialScoringHands << new FullHouse(this)
    potentialScoringHands << new Flush(this)
    potentialScoringHands << new Straight(this)
    potentialScoringHands << new ThreeOfAKind(this)
    potentialScoringHands << new TwoPairs(this)
    potentialScoringHands << new Pair(this)
    potentialScoringHands << new HighCard(this)
    scoringHand = potentialScoringHands.find{ it-> it.relevant }
  }
  
  String toString(){
    "${playerName}: ${super.toString()}" 
  }
  
}
