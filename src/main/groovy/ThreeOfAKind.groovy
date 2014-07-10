
class ThreeOfAKind
  extends Pair {
 
  HandStrength handStrength = HandStrength.THREE_OF_A_KIND
  String name = "three of a kind"
  
  ThreeOfAKind(hand){
    super(hand)
  }
  
  int getOfAKindMatch(){3}
}
