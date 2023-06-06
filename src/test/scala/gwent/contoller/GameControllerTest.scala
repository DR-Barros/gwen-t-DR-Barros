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
    assert(!c.isPlayer1FinalTurn())
    assert(!c.isPlayer2FinalTurn())
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
    intercept[StateError]{c.player2FinalTurn()}
    intercept[StateError]{c.player1FinalTurn()}
    assert(c.isStart())
  }
  test("De el estado inicio de ronda puede pasar a turno P1 y no puede volver"){
    c.roundInit()
    c.player1Turn()
    assert(c.isPlayer1Turn())
    intercept[StateError]{c.roundInit()}
    assert(!c.isRoundInit())
  }
  test("De el estado inicio de ronda puede pasar a turno P1"){
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
  test("Del turno P1 puede pasar a Turno final P2"){
    c.roundInit()
    c.player1Turn()
    c.player2FinalTurn()
    assert(c.isPlayer2FinalTurn())
  }
  test("Del turno P2 puede pasar a jugar carta P2") {
    c.roundInit()
    c.player2Turn()
    c.playCardP2()
    assert(c.isPlayCardP2())
  }
  test("Del turno P2 puede pasar a Turno final P1") {
    c.roundInit()
    c.player2Turn()
    c.player1FinalTurn()
    assert(c.isPlayer1FinalTurn())
  }
}
