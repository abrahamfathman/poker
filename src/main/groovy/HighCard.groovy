
class HighCard
  extends ScoringHand{
  
  int getHandScore(){1}

  HighCard(hand){super(hand)}

  int compareTo(altObj){
    def super_thought = super.compareTo(altObj)
    if( super_thought != 0 ) return super_thought
    
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
