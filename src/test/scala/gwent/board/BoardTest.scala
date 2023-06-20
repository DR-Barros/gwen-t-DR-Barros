package cl.uchile.dcc
package gwent.board
import gwent.cards.{Card, CorpCard, Deck, DistanceCard, SiegeCard, WeatherCard}
import gwent.players.{Player, UserPlayer}

import cl.uchile.dcc.gwent.cards.effects.{ClearEffect, FogEffect, FrostEffect, NullEffect, RainEffect}

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

  test("El tablero comienza en estado despejado"){
    assert(board.isClear())
    assert(!board.isFrost())
    assert(!board.isFog())
    assert(!board.isRain())
  }

  test("Al jugar una carta con efecto frost se cambia al estado frost y si se juega otra con el mismo efecto se mantiene en el estado"){
    val playerFrost: Player = new UserPlayer("P1", new Deck(Array(new WeatherCard("Frost", new FrostEffect), new WeatherCard("Frost", new FrostEffect))))
    playerFrost.stealCard()
    playerFrost.stealCard()
    board.playCardSec1(playerFrost, 1)
    assert(board.isFrost())
    assert(!board.isFog())
    assert(!board.isClear())
    assert(!board.isRain())
    board.playCardSec1(playerFrost, 1)
    assert(board.isFrost())
    assert(!board.isFog())
    assert(!board.isClear())
    assert(!board.isRain())
  }

  test("Al jugar una carta con efecto fog se cambia al estado fog y si se juega otra con el mismo efecto se mantiene en el estado") {
    val playerFog: Player = new UserPlayer("P1", new Deck(Array(new WeatherCard("Fog", new FogEffect), new WeatherCard("Frost", new FogEffect))))
    playerFog.stealCard()
    playerFog.stealCard()
    board.playCardSec1(playerFog, 1)
    assert(board.isFog())
    assert(!board.isFrost())
    assert(!board.isClear())
    assert(!board.isRain())
    board.playCardSec1(playerFog, 1)
    assert(board.isFog())
    assert(!board.isFrost())
    assert(!board.isClear())
    assert(!board.isRain())
  }
  test("Al jugar una carta con efecto rain se cambia al estado rain y si se juega otra con el mismo efecto se mantiene en el estado") {
    val playerRain: Player = new UserPlayer("P1", new Deck(Array(new WeatherCard("Rain", new RainEffect), new WeatherCard("Rain", new RainEffect))))
    playerRain.stealCard()
    playerRain.stealCard()
    board.playCardSec1(playerRain, 1)
    assert(board.isRain())
    assert(!board.isClear())
    assert(!board.isFrost())
    assert(!board.isFog())
    board.playCardSec1(playerRain, 1)
    assert(board.isRain())
    assert(!board.isClear())
    assert(!board.isFrost())
    assert(!board.isFog())
  }
  test("Cuando se esta en un estado distinto de despejado con una carta de efecto despejado se cambia al estado despejado"){
    val playerRain: Player = new UserPlayer("P1", new Deck(Array(new WeatherCard("Rain", new RainEffect))))
    val playerClear: Player = new UserPlayer("P1", new Deck(Array(new WeatherCard("Clear", new ClearEffect))))
    playerRain.stealCard()
    playerClear.stealCard()
    board.playCardSec1(playerRain, 1)
    assert(board.isRain())
    assert(!board.isClear())
    assert(!board.isFrost())
    assert(!board.isFog())
    board.playCardSec1(playerClear, 1)
    assert(board.isClear())
    assert(!board.isFrost())
    assert(!board.isFog())
    assert(!board.isRain())
  }
}