package cl.uchile.dcc
package gwent.board
import gwent.cards.{Card, CorpCard, DistanceCard, SiegeCard, UnitCard, WeatherCard}
import gwent.players.{Player, UserPlayer}

import cl.uchile.dcc.gwent.cards.effects.{ClearEffect, FogEffect, FrostEffect, NullEffect, RainEffect}
import cl.uchile.dcc.gwent.cards.structures.Deck

import scala.collection.mutable.ArrayBuffer

class BoardTest extends munit.FunSuite {
  var board: Board = _
  var player: Player = _
  var cardC : CorpCard =_
  var cardD : DistanceCard =_
  var cardS : SiegeCard =_
  var cardW : WeatherCard =_

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    cardC = new CorpCard("Darth Vader", 19, new NullEffect)
    cardD = new DistanceCard("Han Solo", 10, new NullEffect)
    cardS = new SiegeCard("C3PO", 1, new NullEffect)
    cardW = new WeatherCard("Templado", new ClearEffect)
    player = new UserPlayer("P1", new Deck(Array(cardC, cardD, cardS, cardW)))
    player.stealCard()
    player.stealCard()
    player.stealCard()
    player.stealCard()
  }

  test("Las cartas se asignan en su correspondiente seccion"){
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    //falta mostrar las cartas y ver que son las que corresponden
    assert(cardC.equals(board.getSec1C()(0)))
    assert(cardD.equals(board.getSec1D()(0)))
    assert(cardS.equals(board.getSec1S()(0)))
    assert(cardW.equals(board.getSecW()(0)))
  }

  test("Si las cartas se juegan en la seccion 2, van a quedar en la seccion 2") {
    board.playCardSec2(player, 1)
    board.playCardSec2(player, 1)
    board.playCardSec2(player, 1)
    board.playCardSec2(player, 1)
    //mostrar que estan en 2 pero no en 1
    assert(cardC.equals(board.getSec2C()(0)))
    assert(cardD.equals(board.getSec2D()(0)))
    assert(cardS.equals(board.getSec2S()(0)))
    assert(cardW.equals(board.getSecW()(0)))
  }
  test("Al usar frost se actualizan las cartas cuerpo cuerpo a el estado frost"){
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.frost()
    assert(cardC.isFrost())
  }
  test("Al usar fog se actualizan las cartas cuerpo cuerpo a el estado frost") {
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.fog()
    assert(cardD.isFog())
  }
  test("Al usar rain se actualizan las cartas cuerpo cuerpo a el estado frost") {
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.rain()
    assert(cardS.isRain())
  }
  test("Se puede limiar las cartas del tablero"){
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.playCardSec1(player, 1)
    board.clean()
    assertEquals(board.getSec1S(), new ArrayBuffer[UnitCard](0))
    assertEquals(board.getSec1C(), new ArrayBuffer[UnitCard](0))
    assertEquals(board.getSec1D(), new ArrayBuffer[UnitCard](0))
    assertEquals(board.getSecW()(0), null)
  }
  test("Se puede obtener la fuerza de cada sección"){
    board.playCardSec2(player, 1)
    board.playCardSec2(player, 1)
    board.playCardSec2(player, 1)
    board.playCardSec2(player, 1)
    assertEquals(board.getSec1Strength(), 0)
    assertEquals(board.getSec2Strength(), 30)
  }
}