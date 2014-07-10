import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor

import org.junit.Ignore
import org.junit.Test


class GameTest {

  @Test
  void should_determine_winner_between_two_hands_flush_beats_pair(){
    def pair = new PokerHand(["2C", "2H", "9C", "10C", "JC"], "Frank")
    def flush = new PokerHand(["2D", "3D", "9D", "10D", "JD"], "John")
    assert new Game([pair, flush]).output() == "John wins - flush"
    assert new Game([pair, flush]).output() == "John wins - flush"
  }

  @Test
  void should_determine_a_tie(){
    def pair = new PokerHand(["2C", "2H", "9C", "10C", "JC"], "Frank")
    def flush = new PokerHand(["2C", "2H", "9C", "10C", "JC"], "John")
    assert new Game([pair, flush]).output() == "Tie"
    assert new Game([pair, flush]).output() == "Tie"
  }
  
  @Test
  void should_turn_a_line_of_input_into_a_set_of_poker_hands(){
    def line = "Albert: AC 4D 5H 2D KH Susan: 2S 6C AD KS 8C"
    def pokerHands = Game.lineToPokerHands(line)
    assert pokerHands[0].playerName == "Albert"
    assert pokerHands[0].cards[0] == new Card("AC")
    assert pokerHands[0].cards[1] == new Card("4D")
    assert pokerHands[0].cards[2] == new Card("5H")
    assert pokerHands[0].cards[3] == new Card("2D")
    assert pokerHands[0].cards[4] == new Card("KH")
    assert pokerHands[1].playerName == "Susan"
    assert pokerHands[1].cards[0] == new Card("2S")
    assert pokerHands[1].cards[1] == new Card("6C")
    assert pokerHands[1].cards[2] == new Card("AD")
    assert pokerHands[1].cards[3] == new Card("KS")
    assert pokerHands[1].cards[4] == new Card("8C")

  }
}
