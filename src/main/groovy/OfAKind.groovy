import javax.net.ssl.HandshakeCompletedEvent;


class OfAKind {
  
  def rankMap=[:]
  
  OfAKind(hand){
    def tempRankMap = [:]
    hand.cards.each{ card->
      if( ! tempRankMap."${card.rank}" ) tempRankMap."${card.rank}" = 0
      tempRankMap."${card.rank}"++
    }
    
    tempRankMap.each{ k, v -> 
      rankMap.put( k as Rank, v )  
    }
  }
    
}
