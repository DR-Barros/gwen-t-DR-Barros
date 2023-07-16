package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.players.UserPlayer

import java.io.ByteArrayInputStream
import scala.io.StdIn

class Player1TurnStateTest extends munit.FunSuite {
  var c: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }
  /**
  test("Al Hacer handle si el jugador no tiene cartas en su mano se pasa el turno"){
    c.p1 = Some(new UserPlayer("P1", new Deck(Array())))
    c.roundInit()
    c.player1Turn()
    assert(c.isPlayer1Turn())
    val in = System.in
    val input = new java.io.ByteArrayInputStream("jugar".getBytes)
    System.setIn(input)
    c.handleState()
    System.setIn(in)
    assert(c.isPlayCardsP2())
  }
  test("Si el jugador tiene cartas y el jugador elige jugar se pasa al estado playCardP1"){
    c.handleState()
    c.player1Turn()
    val in = System.in
    val input = new ByteArrayInputStream("jugar".getBytes)
    System.setIn(input)
    c.handleState()
    assert(c.isPlayCardP1())
    System.setIn(in)
  }
  test("Si el jugador tiene cartas y el jugador elige pasar se pasa al estado player2FinalTurn") {
    c.handleState()
    c.player1Turn()
    val in = System.in
    val input = new ByteArrayInputStream("pasar".getBytes)
    System.setIn(input)
    c.handleState()
    System.setIn(in)
    assert(c.isPlayCardsP2())
  }
  test("Si el jugador tiene cartas y el jugador escribe algo distinto a 'jugar' o 'pasar' tiene que volver a introducir algo hasta que elija uno los 2") {
    c.handleState()
    c.player1Turn()
    val input = new ByteArrayInputStream("sdhjhahd\nsdhjhahd\npasar\n".getBytes)
    System.setIn(input)
    c.handleState()
    assert(c.isPlayCardsP2())
  }
  */
}
