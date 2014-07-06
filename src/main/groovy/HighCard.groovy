
class HighCard
extends ScoringHand{
  def cards

  int getHandScore(){
    1
  }

  HighCard(List<String> cards){
    this.cards = cards.collect{new Card(it)}
  }

  int compareTo(altObj){
    def super_thought = super.compareTo(altObj)
    if( super_thought != 0 ) return super_thought
    
    this.cards[0].compareTo(altObj.cards[0])
  }
}
