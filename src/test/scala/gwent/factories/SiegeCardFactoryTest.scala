package cl.uchile.dcc
package gwent.factories

import gwent.cards.SiegeCard

class SiegeCardFactoryTest extends munit.FunSuite {
  var c: SiegeCardFactory = _
  override def beforeEach(context: BeforeEach): Unit = {
    c = new SiegeCardFactory
  }
  test("Crea cartas de asedio"){
    assert(c.create().isInstanceOf[SiegeCard])
    assert(c.create().isInstanceOf[SiegeCard])
    assert(c.create().isInstanceOf[SiegeCard])
    assert(c.create().isInstanceOf[SiegeCard])
    assert(c.create().isInstanceOf[SiegeCard])
    assert(c.create().isInstanceOf[SiegeCard])
    assert(c.create().isInstanceOf[SiegeCard])
  }
}
