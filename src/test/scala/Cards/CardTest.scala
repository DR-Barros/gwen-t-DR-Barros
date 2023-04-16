package cl.uchile.dcc
package Cards

import gwent.Cards.*

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class CardTest extends munit.FunSuite {
  var U1: UnitCard = _
  var U2: UnitCard = _
  var W1: WeatherCard = _
  var W2: WeatherCard = _
  var D1: Deck = _
  var D2: Deck = _

  override def beforeEach(context: BeforeEach): Unit = {
    U1 = new UnitCard("soldado", 15)
    U2 = new UnitCard("arquera", 4)
    W1 = new WeatherCard("Escarcha")
    W2 = new WeatherCard("Niebla")
    D1 = new Deck(ListBuffer(U1, U2, W1))
    D2 = new Deck(ListBuffer())
  }
 
  test("Las Cartas tienen nombre"){
    assertEquals(U1.getName(), "soldado")
    assertEquals(U2.getName(), "arquera")
    assertEquals(W1.getName(), "Escarcha")
    assertEquals(W2.getName(), "Niebla")
  }
  test("Las Cartas tienen un tipo"){
    assertEquals(U1.getCardType(), "Unit")
    assertEquals(U1.getCardType(), U2.getCardType())
    assertEquals(W1.getCardType(), "Weather")
    assertEquals(W1.getCardType(), W2.getCardType())
  }
  test("Las Cartas de Unidad tienen Fuerza"){
    assertEquals(U1.getStrength(), 15)
    assertEquals(U2.getStrength(), 4)
  }
  test("Los mazos pueden tener 0 o mas cartas"){
    assertEquals(D1.deckSize(), 3)
    assertEquals(D2.deckSize(), 0)
  }
  test("Si un mazo tiene cartas se puede sacar una y el mazo queda con una carta menos"){
    assertEquals(D1.deckSize(), 3)
    D1.stealCard()
    assertEquals(D1.deckSize(), 2)
    D1.stealCard()

  }
  test("Si un mazo no tiene cartas devuelve una carta vacia"){
    assertEquals(D2.stealCard().getName(), "empty")
    assertEquals(D2.stealCard().getCardType(), "empty")
  }
}

class CardsHandTest extends munit.FunSuite {
  var U1: UnitCard = _
  var U2: UnitCard = _
  var W1: WeatherCard = _
  var W2: WeatherCard = _
  var C1: CardsHand = _
  var C2: CardsHand = _

  override def beforeEach(context: BeforeEach): Unit = {
    U1 = new UnitCard("soldado", 15)
    U2 = new UnitCard("arquera", 4)
    W1 = new WeatherCard("Escarcha")
    W2 = new WeatherCard("Niebla")
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
  test("Una mano de cartas puede tener como maximo 10 cartas"){
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
    C1.addCards(W2)
    C1.addCards(U2)
    C1.addCards(W1)
    C1.addCards(U1)
    C1.addCards(W2)
    assertEquals(C1.handSize(), 10)
  }
  test("Una carta puede ser jugada, diminuyendo la cantidad de cartas de la mano"){
    C1.addCards(U2)
    assertEquals(C1.handSize(), 1)
    C1.playCard()
    assertEquals(C1.handSize(), 0)
  }
}