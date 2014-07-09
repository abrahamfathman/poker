
class FourOfAKind
  extends Pair {
    
     HandStrength handStrength = HandStrength.FOUR_OF_A_KIND
     
     FourOfAKind(hand){
       super(hand)
     }
     
     int getOfAKindMatch(){4}
}
