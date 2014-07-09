import java.util.List;


class Hand {
  def cards

  Hand(List<String> cards){
    this.cards = cards.collect{new Card(it)}
  }
    
  String toString(){
    cards.toListString()
  }
}
