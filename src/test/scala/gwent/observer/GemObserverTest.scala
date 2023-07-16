package cl.uchile.dcc
package gwent.observer

import gwent.controller.GameController

import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.players.UserPlayer

class GemObserverTest extends munit.FunSuite {
  var gObserver: GemObserver = _

  override def beforeEach(context: BeforeEach): Unit = {
    gObserver = new GemObserver()
  }
  test("Avisa al gamecontroller subscrito que se actualice si el arg es Perdio"){
    var g: GameController = new GameController()
    var p: UserPlayer = new UserPlayer("Player", new Deck(new Array[Card](0)))
    gObserver.setGameController(g)
    gObserver.update(p, "Perdio")
  }
}
