package cl.uchile.dcc
package gwent.factories

import gwent.cards.DistanceCard

class DistanceCardFactoryTest extends munit.FunSuite {
  var c: DistanceCardFactory = _
  override def beforeEach(context: BeforeEach): Unit = {
    c = new DistanceCardFactory
  }
  test("Crea cartas de distancia"){
    assert(c.create().isInstanceOf[DistanceCard])
    assert(c.create().isInstanceOf[DistanceCard])
    assert(c.create().isInstanceOf[DistanceCard])
    assert(c.create().isInstanceOf[DistanceCard])
    assert(c.create().isInstanceOf[DistanceCard])
    assert(c.create().isInstanceOf[DistanceCard])
    assert(c.create().isInstanceOf[DistanceCard])
  }
}
