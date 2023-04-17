package cl.uchile.dcc
package Players
package Cards

import gwent.Cards.{Deck, CorpCard, DistanceCard, SiegeCard}
import gwent.Players.UserPlayer

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends munit.FunSuite {
  var player1: UserPlayer = _
  var player2: UserPlayer = _
  var deck1: Deck = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new UserPlayer("P1", 1)
    player2 = new UserPlayer("P2", 2)
    deck1 = new Deck(ListBuffer(
      new CorpCard("Darth Vader", 19), new CorpCard("Luke Skywalker", 16), new CorpCard("Yoda", 20),
      new DistanceCard("Han Solo", 10), new SiegeCard("C3PO", 1), new DistanceCard("Chewbacca", 12),
      new CorpCard("Darth Maul", 13), new CorpCard("Obi Wan Kenobi", 17), new CorpCard("Ahsoka Tano", 12),
      new CorpCard("Palpatine", 20), new SiegeCard("R2-D2", 9), new CorpCard("Mace Windu", 17),
      new DistanceCard("Din Djarin", 13), new CorpCard("General Grievous", 14), new DistanceCard("Leia Organa", 16)
    ))
  }

  test("Un jugador debe tener un nombre"){
    assertEquals(player1.getName(), "P1")
    assertEquals(player2.getName(), "P2")
  }
  test("Un jugador debe tener una zona"){
    assertEquals(player1.getZone(), 1)
    assertEquals(player2.getZone(), 2)
  }
  test("manejo de gemas de un jugador"){
    assertEquals(player1.getGems(), 2)
    player1.loseGems()
    assertEquals(player1.getGems(), 1)
    player1.loseGems()
    player1.loseGems()
    assertEquals(player1.getGems(), 0)
  }
  test("Un jugador comienza con 0 cartas en su mano"){
    assertEquals(player1.handSize(), 0)
  }
  test("Los jugadores al robar cartas de un mazo aumentan la cantidad de cartas de su mano"){
    player1.stealCard(deck1)
    assertEquals(player1.handSize(), 1)
    player1.stealCard(deck1)
    player1.stealCard(deck1)
    player1.stealCard(deck1)
    assertEquals(player1.handSize(), 4)
  }
  test("La maxima cantidad de cartas en la mano es 10"){
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    assertEquals(player2.handSize(), 10)
    player2.stealCard(deck1)
    assertEquals(player2.handSize(), 10)
  }
  test("Al jugar una carta disminuye la cantidad de cartas en la mano del jugador"){
    assertEquals(player2.handSize(), 0)
    player2.stealCard(deck1)
    player2.stealCard(deck1)
    assertEquals(player2.handSize(), 2)
    player2.playCard(1)
    assertEquals(player2.handSize(), 1)
    player2.playCard(4)
    assertEquals(player2.handSize(), 0)
  }
  test("Si el jugador no tiene cartas en la mano juega la carta vacia"){
    assertEquals(player2.handSize(), 0)
    assertEquals(player2.playCard(1).getName(), "empty")
  }
}
