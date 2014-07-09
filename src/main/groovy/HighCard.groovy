
class HighCard
  implements ScoringHand{
  
  HandStrength getHandStrength(){HandStrength.HIGH_CARD}
  boolean relevant=true
  
  def hand

  HighCard(hand){this.hand=hand}

  int compareTo(altObj){
    
    if( this.class != altObj.class )
      return this.handStrength.value.compareTo(altObj.handStrength.value)
    
    def sortedCards = this.hand.cards.sort().reverse()
    def altSortedCards = altObj.hand.cards.sort().reverse()
    int position = -1
    def comparison = 0
    while(position < sortedCards.size()-1 && comparison == 0 ){
      position++
      comparison = sortedCards[position].compareTo( altSortedCards[position] )
    }
    comparison
    
  }
}
