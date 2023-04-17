package cl.uchile.dcc
package Cards

import gwent.Cards.*

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class CorpCardTest extends munit.FunSuite{
  var C1: CorpCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new CorpCard("vikingo", 18)
  }
  test("Una carta cuerpo a cuerpo tien nombre"){
    assertEquals(C1.getName(), "vikingo")
  }
  test("Una carta de cuerpo a cuerpo es de tipo cuerpo a cuerpo"){
    assertEquals(C1.getCardType(), "Corp")
  }
  test("Una carta de cuerpo a cuerpo tiene fuerza"){
    assertEquals(C1.getStrength(), 18)
  }
}

class DistanceCardTest extends munit.FunSuite{
  var C1: DistanceCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new DistanceCard("arquera", 14)
  }
  test("Una carta cuerpo a cuerpo tien nombre"){
    assertEquals(C1.getName(), "arquera")
  }
  test("Una carta de cuerpo a cuerpo es de tipo cuerpo a cuerpo"){
    assertEquals(C1.getCardType(), "Distance")
  }
  test("Una carta de cuerpo a cuerpo tiene fuerza"){
    assertEquals(C1.getStrength(), 14)
  }
}

class SiegeCardTest extends munit.FunSuite{
  var C1: SiegeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new SiegeCard("catapulta", 25)
  }
  test("Una carta cuerpo a cuerpo tien nombre"){
    assertEquals(C1.getName(), "catapulta")
  }
  test("Una carta de cuerpo a cuerpo es de tipo cuerpo a cuerpo"){
    assertEquals(C1.getCardType(), "Siege")
  }
  test("Una carta de cuerpo a cuerpo tiene fuerza"){
    assertEquals(C1.getStrength(), 25)
  }
}

class WeatherCardTest extends munit.FunSuite{
  var W1: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    W1 = new WeatherCard("soleado")
  }
  test("Una carta cuerpo a cuerpo tien nombre"){
    assertEquals(W1.getName(), "soleado")
  }
  test("Una carta de cuerpo a cuerpo es de tipo cuerpo a cuerpo"){
    assertEquals(W1.getCardType(), "Weather")
  }
}

class DeckTest extends munit.FunSuite{
  var U1: CorpCard = _
  var U2: DistanceCard = _
  var W1: WeatherCard = _
  var W2: WeatherCard = _
  var D1: Deck = _
  var D2: Deck = _

  override def beforeEach(context: BeforeEach): Unit = {
    U1 = new CorpCard("soldado", 15)
    U2 = new DistanceCard("arquera", 4)
    W1 = new WeatherCard("Escarcha")
    W2 = new WeatherCard("Niebla")
    D1 = new Deck(ListBuffer(U1, U2, W1))
    D2 = new Deck(ListBuffer())
  }

  test("Los mazos pueden tener 0 o mas cartas") {
    assertEquals(D1.deckSize(), 3)
    assertEquals(D2.deckSize(), 0)
  }
  test("Si un mazo tiene cartas se puede sacar una y el mazo queda con una carta menos") {
    assertEquals(D1.deckSize(), 3)
    D1.stealCard()
    assertEquals(D1.deckSize(), 2)
    D1.stealCard()

  }
  test("Si un mazo no tiene cartas devuelve una carta vacia") {
    assertEquals(D2.stealCard().getName(), "empty")
    assertEquals(D2.stealCard().getCardType(), "empty")
  }
}

class CardsHandTest extends munit.FunSuite {
  var U1: CorpCard = _
  var U2: DistanceCard = _
  var W1: WeatherCard = _
  var W2: WeatherCard = _
  var C1: CardsHand = _
  var C2: CardsHand = _

  override def beforeEach(context: BeforeEach): Unit = {
    U1 = new CorpCard("soldado", 15)
    U2 = new DistanceCard("arquera", 4)
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