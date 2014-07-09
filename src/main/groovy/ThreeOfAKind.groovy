
class ThreeOfAKind
  extends Pair {
 
  HandStrength handStrength = HandStrength.THREE_OF_A_KIND
  
  ThreeOfAKind(hand){
    super(hand)
  }
  
  int getOfAKindMatch(){3}
}
