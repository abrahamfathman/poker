
class HighCard
  implements ScoringHand{
  
  HandStrength handStrength = HandStrength.HIGH_CARD
  boolean relevant=true
  String name
  
  def hand

  HighCard(hand){
    this.hand=hand
    def sortedCards = []
    sortedCards.addAll this.hand.cards
    sortedCards = sortedCards.sort().reverse()
    name = "high card: " + sortedCards[0].rank.display 
  }

  int compareTo(altObj){
    new HighCardComparator().compare(this,altObj)
  }
}
