public class Card
  implements Comparable{

  Rank rank
  Suit suit
  
  Card(card){
    this.rank = "R${card[0]}" as Rank
    this.suit = card[1] as Suit
  }
  
  int compareTo( altObj ){
    this.rank.value.compareTo(altObj.rank.value)
  }
    
}
