

class PokerHand 
  extends Hand{
  def scoringHands = []

  PokerHand(List<String> cards){
    super(cards)
    calculateScoringHands()
  }
  
  void calculateScoringHands(){
    scoringHands << new ThreeOfAKind(this)
    scoringHands << new TwoPairs(this)
    scoringHands << new Pair(this)
    scoringHands << new HighCard(this)
    scoringHands = scoringHands.grep{ it-> it.relevant }
  }
  
  
}
