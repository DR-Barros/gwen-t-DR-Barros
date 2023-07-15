package cl.uchile.dcc
package gwent.contoller

import gwent.controller.{Controller, GameController}

import cl.uchile.dcc.gwent.exception.StateError

class GameControllerTest extends munit.FunSuite {
  var c: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }

  test("Parte en el estado Start"){
    assert(c.isStart())
  }
  test("No puede estar en mas de un estado"){
    assert(c.isStart())
    assert(!c.isFinishGame())
    assert(!c.isPlayCardP1())
    assert(!c.isPlayCardP2())
    assert(!c.isNextRound())
    assert(!c.isFinishRound())
    assert(!c.isPlayCardsP1())
    assert(!c.isPlayCardsP2())
    assert(!c.isPlayer1Turn())
    assert(!c.isPlayer2Turn())
    assert(!c.isRoundInit())
  }
  test("De el estado start pasa a inicio de ronda y no puede volver"){
    c.roundInit()
    assert(c.isRoundInit())
    intercept[StateError]{c.start()}
    assert(!c.isStart())
  }
  test("Solo se puede pasar a los estados permitidos"){
    intercept[StateError]{c.start()}
    intercept[StateError]{c.finishGame()}
    intercept[StateError]{c.finishRound()}
    intercept[StateError]{c.nextRound()}
    intercept[StateError]{c.playCardP1()}
    intercept[StateError]{c.playCardP2()}
    intercept[StateError]{c.playCardsP1()}
    intercept[StateError]{c.playCardsP2()}
    intercept[StateError]{c.player1Turn()}
    intercept[StateError]{c.player2Turn()}
    assert(c.isStart())
  }
  test("De el estado inicio de ronda puede pasar a turno P1 y no puede volver"){
    c.roundInit()
    c.player1Turn()
    assert(c.isPlayer1Turn())
    intercept[StateError]{c.roundInit()}
    assert(!c.isRoundInit())
  }
  test("De el estado inicio de ronda puede pasar a turno P2"){
    c.roundInit()
    c.player2Turn()
    assert(c.isPlayer2Turn())
  }
  test("Del turno P1 puede pasar a jugar carta P1"){
    c.roundInit()
    c.player1Turn()
    c.playCardP1()
    assert(c.isPlayCardP1())
  }
  test("De jugar carta P1 puede pasar a turno P2"){
    c.roundInit()
    c.player1Turn()
    c.playCardP1()
    c.player2Turn()
    assert(c.isPlayer2Turn())
  }
  test("Del turno P1 puede pasar a Jugar cartas P2"){
    c.roundInit()
    c.player1Turn()
    c.playCardsP2()
    assert(c.isPlayCardsP2())
  }
  test("Del turno P2 puede pasar a jugar carta P2") {
    c.roundInit()
    c.player2Turn()
    c.playCardP2()
    assert(c.isPlayCardP2())
  }
  test("De jugar carta P2 puede pasar a turno P1"){
    c.roundInit()
    c.player2Turn()
    c.playCardP2()
    c.player1Turn()
    assert(c.isPlayer1Turn())
  }
  test("Del turno P2 puede pasar a jugar cartas P1") {
    c.roundInit()
    c.player2Turn()
    c.playCardsP1()
    assert(c.isPlayCardsP1())
  }
  test("De jugar cartas P1 se puede pasar a ronda final") {
    c.roundInit()
    c.player2Turn()
    c.playCardsP1()
    c.finishRound()
    assert(c.isFinishRound())
  }
  test("De jugar cartas P2 se puede pasar a ronda final") {
    c.roundInit()
    c.player1Turn()
    c.playCardsP2()
    c.finishRound()
    assert(c.isFinishRound())
  }
  test("Del final de la ronda se puede pasar al final del juego"){
    c.roundInit()
    c.player1Turn()
    c.playCardsP2()
    c.finishRound()
    c.finishGame()
    assert(c.isFinishGame())
  }
  test("Del fin del juego se puede reiniciar volviendo a start"){
    c.roundInit()
    c.player1Turn()
    c.playCardsP2()
    c.finishRound()
    c.finishGame()
    c.start()
    assert(c.isStart())
  }
  test("Del final de la ronda se puede pasar al proxima ronda") {
    c.roundInit()
    c.player1Turn()
    c.playCardsP2()
    c.finishRound()
    c.nextRound()
    assert(c.isNextRound())
  }
  test("De la proxima ronda se puede pasar a inicio de ronda") {
    c.roundInit()
    c.player1Turn()
    c.playCardsP2()
    c.finishRound()
    c.nextRound()
    c.roundInit()
    assert(c.isRoundInit())
  }
}
