package cl.uchile.dcc
package gwent.cards

import gwent.exception.{DeckIsEmpty, HandDontHaveCard, HandIsFull}

import cl.uchile.dcc.gwent.cards.effects.{ClearEffect, FogEffect, NullEffect}

class CorpCardTest extends munit.FunSuite{
  var C1: CorpCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new CorpCard("vikingo", 18, new NullEffect)
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
  test("Una carta cuerpo a cuerpo se identifica por su nombre y fuerza"){
    assert(C1.equals(new CorpCard("vikingo", 18, new NullEffect)))
    assert(!C1.equals(new CorpCard("soldado", 18, new NullEffect)))
    assert(!C1.equals(new CorpCard("vikingo", 10, new NullEffect)))
  }
  test("Una carta cuerpo a cuerpo solo es igual a otra carta cuerpo a cuerpo con igual nombre y fuerza"){
    assert(C1.equals(new CorpCard("vikingo", 18, new NullEffect)))
    assert(!C1.equals(new CorpCard("vikingos", 18, new NullEffect)))
    assert(!C1.equals(new CorpCard("vikingo", 19, new NullEffect)))
    assert(!C1.equals(new DistanceCard("vikingo", 18, new NullEffect)))
    assert(!C1.equals(new SiegeCard("vikingo", 18, new NullEffect)))
    assert(!C1.equals(new WeatherCard("Soleado", new ClearEffect)))
  }
}

class DistanceCardTest extends munit.FunSuite{
  var C1: DistanceCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new DistanceCard("arquera", 14, new NullEffect)
  }
  test("Una carta a distancia tien nombre"){
    assertEquals(C1.getName(), "arquera")
  }
  test("Una carta a distancia es de a distancia"){
    assertEquals(C1.getCardType(), "Distance")
  }
  test("Una carta a distancia tiene fuerza"){
    assertEquals(C1.getStrength(), 14)
  }
  test("Una carta a distancia se identifica por su nombre y fuerza") {
    assert(C1.equals(new DistanceCard("arquera", 14, new NullEffect)))
    assert(!C1.equals(new DistanceCard("mago", 14, new NullEffect)))
    assert(!C1.equals(new DistanceCard("arquera", 10, new NullEffect)))
  }
  test("Una carta a distancia solo es igual a otra carta a distancia con igual nombre y fuerza") {
    assert(C1.equals(new DistanceCard("arquera", 14, new NullEffect)))
    assert(!C1.equals(new DistanceCard("arqueras", 14, new NullEffect)))
    assert(!C1.equals(new DistanceCard("arquera", 19, new NullEffect)))
    assert(!C1.equals(new CorpCard("arquera", 14, new NullEffect)))
    assert(!C1.equals(new SiegeCard("arquera", 14, new NullEffect)))
    assert(!C1.equals(new WeatherCard("Soleado", new ClearEffect)))
  }

}

class SiegeCardTest extends munit.FunSuite{
  var C1: SiegeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new SiegeCard("catapulta", 25, new NullEffect)
  }
  test("Una carta de asedio tien nombre"){
    assertEquals(C1.getName(), "catapulta")
  }
  test("Una carta de asedio es de tipo asedio"){
    assertEquals(C1.getCardType(), "Siege")
  }
  test("Una carta de asedio tiene fuerza"){
    assertEquals(C1.getStrength(), 25)
  }
  test("Una carta de asedio se identifica por su nombre y fuerza") {
    assert(C1.equals(new SiegeCard("catapulta", 25, new NullEffect)))
    assert(!C1.equals(new SiegeCard("Torre", 25, new NullEffect)))
    assert(!C1.equals(new SiegeCard("catapulta", 20, new NullEffect)))
  }
  test("Una carta de asedio solo es igual a otra carta de asedio con igual nombre y fuerza") {
    assert(C1.equals(new SiegeCard("catapulta", 25, new NullEffect)))
    assert(!C1.equals(new SiegeCard("catapultas", 25, new NullEffect)))
    assert(!C1.equals(new SiegeCard("catapulta", 19, new NullEffect)))
    assert(!C1.equals(new CorpCard("catapulta", 25, new NullEffect)))
    assert(!C1.equals(new DistanceCard("catapulta", 25, new NullEffect)))
    assert(!C1.equals(new WeatherCard("Soleado", new ClearEffect)))
  }
}

class WeatherCardTest extends munit.FunSuite{
  var W1: WeatherCard = _
  var W2: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    W1 = new WeatherCard("soleado", new ClearEffect)
    W2 = new WeatherCard("nublado", new FogEffect)
  }
  test("Una carta de clima tien nombre"){
    assertEquals(W1.getName(), "soleado")
  }
  test("Una carta de clima es de tipo clima y no es igual a una carta de unidad"){
    assertEquals(W1.getCardType(), "Weather")
    assert(!W1.equals(new CorpCard("Soldado", 15, new NullEffect)))
    assert(!W1.equals(new DistanceCard("Arquera", 15, new NullEffect)))
    assert(!W1.equals(new SiegeCard("catapulta", 20, new NullEffect)))
  }
  test("Una carta clima se identifica por su nombre"){
    assert(W1.equals(new WeatherCard("soleado", new ClearEffect)))
    assert(!W1.equals(W2))
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
    U1 = new CorpCard("soldado", 15, new NullEffect)
    U2 = new DistanceCard("arquera", 4, new NullEffect)
    W1 = new WeatherCard("Escarcha", new ClearEffect)
    W2 = new WeatherCard("Niebla", new FogEffect)
    D1 = new Deck(Array(U1, U2, W1))
    D2 = new Deck(Array())
  }

  test("Los mazos pueden tener 0 o mas cartas") {
    assertEquals(D1.deckSize(), 3)
    assertEquals(D2.deckSize(), 0)
  }
  test("Si un mazo tiene cartas se puede sacar una y el mazo queda con una carta menos") {
    assertEquals(D1.deckSize(), 3)
    var card = D1.stealCard()
    assert(card.isInstanceOf[Card])
    assertEquals(D1.deckSize(), 2)
    card = D1.stealCard()
    assert(card.isInstanceOf[Card])

  }
  test("Si un mazo no tiene cartas lanza la excepcion DeckIsEmpty") {
    intercept[DeckIsEmpty]{D2.stealCard()}
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