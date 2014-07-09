
class StraightFlush {
  HandStrength handStrength = HandStrength.STRAIGHT_FLUSH
  boolean relevant=false

  def straight
  def rankHigh
  
  StraightFlush(hand){
    def flush = new Flush(hand)
    if(flush.relevant){
      straight = new Straight(hand)
      rankHigh = straight.rankHigh
      relevant = straight.relevant
    }
  }

  int compareTo( altObj ){

   if (! relevant) throw new ComparisonNotPossibleException()
   
   straight.compareTo(altObj.straight)
  }

}
