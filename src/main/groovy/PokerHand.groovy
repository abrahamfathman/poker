

class PokerHand 
  extends Hand{
  def scoringHands = []

  PokerHand(List<String> cards){
    super(cards)
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
  
  
}
