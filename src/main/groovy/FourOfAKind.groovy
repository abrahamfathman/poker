
class FourOfAKind
  extends Pair {
    
     HandStrength handStrength = HandStrength.FOUR_OF_A_KIND
     String name = "four of a kind" 
     
     FourOfAKind(hand){
       super(hand)
     }
     
     int getOfAKindMatch(){4}
}
