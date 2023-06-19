package cl.uchile.dcc
package gwent.board.states
import gwent.board.Board

trait BoardState {
  def setBoard(board: Board): Unit
  protected  def changeState(state: BoardState): Unit
  def clear(): Unit
  def fog(): Unit
  def frost(): Unit
  def rain(): Unit
  def isClear(): Boolean
  def isFog(): Boolean
  def isFrost(): Boolean
  def isRain(): Boolean
}
