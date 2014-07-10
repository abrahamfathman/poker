
class HighCardComparator {

  def winningCard
  
  int compare( o1, o2 ){
    def sortedCards = []
    sortedCards.addAll o1.hand.cards
    sortedCards = sortedCards.sort().reverse()
    
    
    def altSortedCards = []
    altSortedCards.addAll(o2.hand.cards)
    altSortedCards = altSortedCards.sort().reverse()
    
    int position = -1
    def comparison = 0
    while(position < sortedCards.size()-1 && comparison == 0 ){
      position++
      def card = sortedCards[position]
      def altCard = altSortedCards[position]
      comparison = card.compareTo( altCard )
    }
    
    if(comparison != 0){
      if( comparison > 0 )
        winningCard = sortedCards[position]
      else
        winningCard = altSortedCards[position]
    }
    
    comparison
    
  }
}
