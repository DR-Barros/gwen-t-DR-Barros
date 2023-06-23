package cl.uchile.dcc
package Players
package Cards

import gwent.cards.{Card, CorpCard, Deck, DistanceCard, SiegeCard}
import gwent.players.UserPlayer

import cl.uchile.dcc.gwent.cards.effects.NullEffect
import cl.uchile.dcc.gwent.exception.HandDontHaveCard
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends munit.FunSuite {
  var player1: UserPlayer = _
  var player2: UserPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new UserPlayer("P1", new Deck(Array(
      new CorpCard("Darth Vader", 19, new NullEffect), new CorpCard("Luke Skywalker", 16, new NullEffect), new CorpCard("Yoda", 20, new NullEffect),
      new DistanceCard("Han Solo", 10, new NullEffect), new SiegeCard("C3PO", 1, new NullEffect), new DistanceCard("Chewbacca", 12, new NullEffect),
      new CorpCard("Darth Maul", 13, new NullEffect), new CorpCard("Obi Wan Kenobi", 17, new NullEffect), new CorpCard("Ahsoka Tano", 12, new NullEffect),
      new CorpCard("Palpatine", 20, new NullEffect), new SiegeCard("R2-D2", 9, new NullEffect), new CorpCard("Mace Windu", 17, new NullEffect),
      new DistanceCard("Din Djarin", 13, new NullEffect), new CorpCard("General Grievous", 14, new NullEffect), new DistanceCard("Leia Organa", 16, new NullEffect)
    )))
    player2 = new UserPlayer("P2", new Deck(Array(
      new CorpCard("Darth Vader", 19, new NullEffect), new CorpCard("Luke Skywalker", 16, new NullEffect), new CorpCard("Yoda", 20, new NullEffect),
      new DistanceCard("Han Solo", 10, new NullEffect), new SiegeCard("C3PO", 1, new NullEffect), new DistanceCard("Chewbacca", 12, new NullEffect),
      new CorpCard("Darth Maul", 13, new NullEffect), new CorpCard("Obi Wan Kenobi", 17, new NullEffect), new CorpCard("Ahsoka Tano", 12, new NullEffect),
      new CorpCard("Palpatine", 20, new NullEffect), new SiegeCard("R2-D2", 9, new NullEffect), new CorpCard("Mace Windu", 17, new NullEffect),
      new DistanceCard("Din Djarin", 13, new NullEffect), new CorpCard("General Grievous", 14, new NullEffect), new DistanceCard("Leia Organa", 16, new NullEffect)
    )))
  }
  test("Un jugador debe tener un nombre"){
    assertEquals(player1.getName(), "P1")
    assertEquals(player2.getName(), "P2")
  }
  test("Un jugador debe ser de clase UserPlayer"){
    assert(!player1.equals(new CorpCard("P1", 1, new NullEffect)))
  }
  test("Un jugador se identifica por su nombre y zona"){
    assert(!player1.equals(player2))
    assert(player1.equals(new UserPlayer("P1", new Deck(Array()))))
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