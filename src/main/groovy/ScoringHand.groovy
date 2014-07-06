import java.util.List;


abstract class ScoringHand
  implements Comparable {
    
    abstract int getHandScore()
    def hand
    
    ScoringHand(hand){
      this.hand = hand
    }
    
    int compareTo( altObj ){
      this.handScore.compareTo(altObj.handScore) 
    }

}
