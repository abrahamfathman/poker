import java.util.List;


class Pair 
  extends ScoringHand{
  
  def cards
  int getHandScore(){2}
  
  Pair(List<String> cards){
    this.cards = cards.collect{new Card(it)}
  }
  
//  int compareTo(altObj){
//    def super_thought = super.compareTo(altObj)
//    if( super_thought != 0 ) return super_thought    
//    
//  }

}
