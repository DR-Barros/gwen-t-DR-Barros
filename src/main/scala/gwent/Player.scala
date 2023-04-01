package cl.uchile.dcc
package gwent

trait Player {
  def getName(): String
  def getZone(): Int
  def getGems(): Int
  def playCard(): Card
  def stealCard(): Card
}
