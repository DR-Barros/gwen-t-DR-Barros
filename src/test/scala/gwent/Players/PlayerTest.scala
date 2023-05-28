package cl.uchile.dcc
package Players
package Cards

import gwent.Cards.{Card, CorpCard, Deck, DistanceCard, SiegeCard}
import gwent.Players.UserPlayer

import cl.uchile.dcc.gwent.Exception.HandDontHaveCard
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends munit.FunSuite {
  var player1: UserPlayer = _
  var player2: UserPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new UserPlayer("P1", 1, new Deck(Array(
      new CorpCard("Darth Vader", 19), new CorpCard("Luke Skywalker", 16), new CorpCard("Yoda", 20),
      new DistanceCard("Han Solo", 10), new SiegeCard("C3PO", 1), new DistanceCard("Chewbacca", 12),
      new CorpCard("Darth Maul", 13), new CorpCard("Obi Wan Kenobi", 17), new CorpCard("Ahsoka Tano", 12),
      new CorpCard("Palpatine", 20), new SiegeCard("R2-D2", 9), new CorpCard("Mace Windu", 17),
      new DistanceCard("Din Djarin", 13), new CorpCard("General Grievous", 14), new DistanceCard("Leia Organa", 16)
    )))
    player2 = new UserPlayer("P2", 2, new Deck(Array(
      new CorpCard("Darth Vader", 19), new CorpCard("Luke Skywalker", 16), new CorpCard("Yoda", 20),
      new DistanceCard("Han Solo", 10), new SiegeCard("C3PO", 1), new DistanceCard("Chewbacca", 12),
      new CorpCard("Darth Maul", 13), new CorpCard("Obi Wan Kenobi", 17), new CorpCard("Ahsoka Tano", 12),
      new CorpCard("Palpatine", 20), new SiegeCard("R2-D2", 9), new CorpCard("Mace Windu", 17),
      new DistanceCard("Din Djarin", 13), new CorpCard("General Grievous", 14), new DistanceCard("Leia Organa", 16)
    )))
  }

  test("Un jugador debe tener un nombre"){
    assertEquals(player1.getName(), "P1")
    assertEquals(player2.getName(), "P2")
  }
  test("Un jugador debe tener una zona"){
    assertEquals(player1.getZone(), 1)
    assertEquals(player2.getZone(), 2)
  }
  test("Un jugador debe ser de clase UserPlayer"){
    assert(!player1.equals(new CorpCard("P1", 1)))
  }
  test("Un jugador se identifica por su nombre y zona"){
    assert(!player1.equals(player2))
    assert(player1.equals(new UserPlayer("P1", 1, new Deck(Array()))))
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
  test("Los jugadores pueden robar cartas del mazo y agregarla a la mano"){
    player1.stealCard()
    assertEquals(player1.handSize(), 1)
    player1.stealCard()
    player1.stealCard()
    player1.stealCard()
    assertEquals(player1.handSize(), 4)
  }

  test("El jugador puede jugar cartas y estas se eliminan de la mano"){
    assertEquals(player2.handSize(), 0)
    player2.stealCard()
    player2.stealCard()
    assertEquals(player2.handSize(), 2)
    var card = player2.playCard(1)
    assert(card.isInstanceOf[Card])
    assertEquals(player2.handSize(), 1)
    card = player2.playCard(1)
    assert(card.isInstanceOf[Card])
    assertEquals(player2.handSize(), 0)
  }
  test("Si un jugador intenta jugar una carta sin tener cartas en la mano se lanza la excepcion HandDontHaveCard"){
    assertEquals(player2.handSize(), 0)
    intercept[HandDontHaveCard]{player2.playCard(0)}
  }
}
