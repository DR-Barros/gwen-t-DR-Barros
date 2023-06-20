package cl.uchile.dcc
package gwent.board
import gwent.cards.{Card, CorpCard, Deck, DistanceCard, SiegeCard, WeatherCard}
import gwent.players.UserPlayer

import cl.uchile.dcc.gwent.cards.effects.{ClearEffect, NullEffect}

class BoardTest extends munit.FunSuite {
  var board: Board = _
  var player: UserPlayer = _
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
}

class BoardSectionTest extends munit.FunSuite{
  var Sec1: BoardSection = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sec1 = new BoardSection()
  }
  test("Las secciones del tablero comienzan vacias"){
    assertEquals(Sec1.getZoneC().toSeq, new Array[Card](6).toSeq)
    assertEquals(Sec1.getZoneS().toSeq, new Array[Card](6).toSeq)
    assertEquals(Sec1.getZoneD().toSeq, new Array[Card](6).toSeq)
  }
  test("Las cartas pueden ser asignadas a alguna zona de la seccion"){
    val card: Card = new CorpCard("nombre", 14, new NullEffect)
    Sec1.assignZoneC(card)
    assert(card.equals(Sec1.getZoneC()(0)))
    Sec1.assignZoneD(card)
    assert(card.equals(Sec1.getZoneD()(0)))
    Sec1.assignZoneS(card)
    assert(card.equals(Sec1.getZoneS()(0)))
  }
}
