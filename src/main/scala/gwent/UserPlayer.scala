package cl.uchile.dcc
package gwent
import gwent.Player

class UserPlayer (private  val name: String, private val zone: Int) extends Player {
  private var gems: Int = 2;

  def getName(): String = {
    return name
  }

  def getZone(): Int = {
    return zone
  }

  def getGems(): Int = {
    return gems
  }

  def loseGems(): Unit = {
    if (gems >0){
      gems -= 1
    }
  }
}
