
class Game {

  def pokerHands
  
  Game(pokerHands){
    this.pokerHands = pokerHands
  }
  
  def winner(){
    pokerHands.sort()[-1]
  }
  
}
