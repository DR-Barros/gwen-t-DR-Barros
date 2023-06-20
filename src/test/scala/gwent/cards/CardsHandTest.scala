package cl.uchile.dcc
package gwent.cards

import gwent.cards.effects.{ClearEffect, FogEffect, NullEffect}
import gwent.exception.{HandDontHaveCard, HandIsFull}

class CardsHandTest extends munit.FunSuite {
  var U1: CorpCard = _
  var U2: DistanceCard = _
  var W1: WeatherCard = _
  var W2: WeatherCard = _
  var C1: CardsHand = _
  var C2: CardsHand = _

  override def beforeEach(context: BeforeEach): Unit = {
    U1 = new CorpCard("soldado", 15, new NullEffect)
    U2 = new DistanceCard("arquera", 4, new NullEffect)
    W1 = new WeatherCard("Escarcha", new ClearEffect)
    W2 = new WeatherCard("Niebla", new FogEffect)
    C1 = new CardsHand()
    C2 = new CardsHand()
  }

  test("La mano de cartas se inicializa vacia"){
    assertEquals(C1.handSize(), 0)
    assertEquals(C2.handSize(), 0)
  }
  test("A la mano de cartas se le pueden agragr cartas"){
    assertEquals(C1.handSize(), 0)
    C1.addCards(U2)
    assertEquals(C1.handSize(), 1)
  }
  test("Una mano de cartas puede tener como maximo 10 cartas, si se intentan agregar mas cartas se lanza la excepcion HandIsFull"){
    C1.addCards(U2)
    C1.addCards(U1)
    C1.addCards(W2)
    C1.addCards(U2)
    C1.addCards(W1)
    C1.addCards(U1)
    C1.addCards(W2)
    C1.addCards(U2)
    C1.addCards(U2)
    C1.addCards(W1)
    assertEquals(C1.handSize(), 10)
    intercept[HandIsFull]{C1.addCards(W2)}
    intercept[HandIsFull]{C1.addCards(U2)}
    intercept[HandIsFull]{C1.addCards(U1)}
    assertEquals(C1.handSize(), 10)
  }
  test("Una carta puede ser jugada, diminuyendo la cantidad de cartas de la mano"){
    C1.addCards(U2)
    assertEquals(C1.handSize(), 1)
    var card: Card = C1.playCard(0)
    assert(card.isInstanceOf[Card])
    assertEquals(C1.handSize(), 0)
  }
  test("Si una mano no tiene cartas se lanza la excepcion HandDontHaveCard"){
    intercept[HandDontHaveCard]{C1.playCard(0)}
  }
  test("Si se le pide una carta con un indice que no tiene la mano se lanza la excepcion HandDontHaveCard"){
    C1.addCards(U2)
    intercept[HandDontHaveCard]{C1.playCard(-1)}
    intercept[HandDontHaveCard]{C1.playCard(5)}
  }
}
