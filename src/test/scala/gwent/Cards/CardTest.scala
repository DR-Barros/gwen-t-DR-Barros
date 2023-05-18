package cl.uchile.dcc
package gwent.Cards

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
  test("Una carta cuerpo a cuerpo se identifica por su nombre y fuerza"){
    assert(C1.equals(new CorpCard("vikingo", 18)))
    assert(!C1.equals(new CorpCard("soldado", 18)))
    assert(!C1.equals(new CorpCard("vikingo", 10)))
  }
  test("Una carta cuerpo a cuerpo solo es igual a otra carta cuerpo a cuerpo con igual nombre y fuerza"){
    assert(C1.equals(new CorpCard("vikingo", 18)))
    assert(!C1.equals(new CorpCard("vikingos", 18)))
    assert(!C1.equals(new CorpCard("vikingo", 19)))
    assert(!C1.equals(new DistanceCard("vikingo", 18)))
    assert(!C1.equals(new SiegeCard("vikingo", 18)))
    assert(!C1.equals(new WeatherCard("Soleado")))
  }
}

class DistanceCardTest extends munit.FunSuite{
  var C1: DistanceCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new DistanceCard("arquera", 14)
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
    assert(C1.equals(new DistanceCard("arquera", 14)))
    assert(!C1.equals(new DistanceCard("mago", 14)))
    assert(!C1.equals(new DistanceCard("arquera", 10)))
  }
  test("Una carta a distancia solo es igual a otra carta a distancia con igual nombre y fuerza") {
    assert(C1.equals(new DistanceCard("arquera", 14)))
    assert(!C1.equals(new DistanceCard("arqueras", 14)))
    assert(!C1.equals(new DistanceCard("arquera", 19)))
    assert(!C1.equals(new CorpCard("arquera", 14)))
    assert(!C1.equals(new SiegeCard("arquera", 14)))
    assert(!C1.equals(new WeatherCard("Soleado")))
  }

}

class SiegeCardTest extends munit.FunSuite{
  var C1: SiegeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    C1 = new SiegeCard("catapulta", 25)
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
    assert(C1.equals(new SiegeCard("catapulta", 25)))
    assert(!C1.equals(new SiegeCard("Torre", 25)))
    assert(!C1.equals(new SiegeCard("catapulta", 20)))
  }
  test("Una carta de asedio solo es igual a otra carta de asedio con igual nombre y fuerza") {
    assert(C1.equals(new SiegeCard("catapulta", 25)))
    assert(!C1.equals(new SiegeCard("catapultas", 25)))
    assert(!C1.equals(new SiegeCard("catapulta", 19)))
    assert(!C1.equals(new CorpCard("catapulta", 25)))
    assert(!C1.equals(new DistanceCard("catapulta", 25)))
    assert(!C1.equals(new WeatherCard("Soleado")))
  }
}

class WeatherCardTest extends munit.FunSuite{
  var W1: WeatherCard = _
  var W2: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    W1 = new WeatherCard("soleado")
    W2 = new WeatherCard("nublado")
  }
  test("Una carta de clima tien nombre"){
    assertEquals(W1.getName(), "soleado")
  }
  test("Una carta de clima es de tipo clima y no es igual a una carta de unidad"){
    assertEquals(W1.getCardType(), "Weather")
    assert(!W1.equals(new CorpCard("Soldado", 15)))
    assert(!W1.equals(new DistanceCard("Arquera", 15)))
    assert(!W1.equals(new SiegeCard("catapulta", 20)))
  }
  test("Una carta clima se identifica por su nombre"){
    assert(W1.equals(new WeatherCard("soleado")))
    assert(!W1.equals(W2))
  }
}

class EmptyCardTest extends munit.FunSuite{
  var e:emptyCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    e = new  emptyCard()
  }
  test("Una carta vacia se llama empty"){
    assertEquals(e.getName(), "empty")
  }
  test("Una carta vacia es de tipo empty"){
    assertEquals(e.getCardType(), "empty")
  }
  test("Una carta vacia solo es igual a una carta vacia"){
    assert(e.equals(new emptyCard))
    assert(!e.equals(new WeatherCard("soleado")))
    assert(!e.equals(new CorpCard("Soldado", 15)))
    assert(!e.equals(new DistanceCard("Arquera", 15)))
    assert(!e.equals(new SiegeCard("catapulta", 20)))
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
    var card: Card = C1.playCard(0)
    assert(card.isInstanceOf[Card])
    assertEquals(C1.handSize(), 0)
  }
  test("Si una mano no tiene cartas, devuelve una carta vacia que señala que esta vacia la mano"){
    assert(C1.playCard(0).equals(new emptyCard))
  }
  test("Si se le pide una carta con un indice que no tiene la mano esta devuelve una carta vacia"){
    C1.addCards(U2)
    assert(C1.playCard(-1).equals(new emptyCard))
    assert(C1.playCard(5).equals(new emptyCard))
  }
}