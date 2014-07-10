


class Game {

  
  def pokerHandComparator = new PokerHandComparator()
  def winner
  
  Game(pokerHands){
    Collections.sort(pokerHands,pokerHandComparator)
    winner = pokerHands[-1]
  }
  
  def output(){
    pokerHandComparator.tie ? "Tie" : "${winner.playerName} wins - ${pokerHandComparator.winningMessage}"
  }
  
  static void main( String[] args ){
    new File("input.txt").eachLine { line ->
      println "Input: $line"
      println "Output: ${new Game(lineToPokerHands(line)).output()}"
      println ""
    }
  }
  
  static lineToPokerHands( line ){
    def pokerHands = []
    def input = line.tokenize()    
    pokerHands << new PokerHand( input[1..5], input[0][0..-2])
    pokerHands << new PokerHand( input[7..11], input[6][0..-2])
    pokerHands
  }
  
  
}
