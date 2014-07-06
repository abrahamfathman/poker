
abstract class ScoringHand
  implements Comparable {
    
    abstract int getHandScore()
    
    int compareTo( altObj ){
      this.handScore.compareTo(altObj.handScore) 
    }

}
