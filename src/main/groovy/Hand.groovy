import java.util.List;


class Hand {
  def cards
  def scoringHands = []

  Hand(List<String> cards){
    this.cards = cards.collect{new Card(it)}
    calculateScoringHands()
  }
  
  void calculateScoringHands(){
    scoringHands << new HighCard(this)
    scoringHands << new Pair(this)
    scoringHands = scoringHands.grep{ it-> it.relevant }
  }
  
  String toString(){
    cards.toListString()
  }
}
