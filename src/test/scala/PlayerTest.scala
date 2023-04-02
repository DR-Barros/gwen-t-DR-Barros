package cl.uchile.dcc
import gwent.UserPlayer
import munit.FunSuite

class PlayerTest extends munit.FunSuite {
  var player1: UserPlayer = _
  var player2: UserPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new UserPlayer("P1", 1)
    player2 = new UserPlayer("P2", 2)
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
}
