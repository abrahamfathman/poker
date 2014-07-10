
class Flush {

  HandStrength handStrength = HandStrength.FLUSH
  boolean relevant=false
  String name="flush"

  Flush(hand){
    def isFlush = true
    for( int x = 0; x < hand.cards.size()-1; x++ ){
      isFlush = isFlush && (hand.cards[x].suit == hand.cards[x+1].suit)
    }
    relevant = isFlush
  }

  int compareTo( altObj ){

   if (! relevant) throw new ComparisonNotPossibleException()

   0 // Flushes can not be compared
  }
}
