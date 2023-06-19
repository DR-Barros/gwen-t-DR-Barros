package cl.uchile.dcc
package gwent.board.states
import gwent.board.Board

abstract class AbstractBoardState extends BoardState {
  private var b: option[Board] = None
  def setBoard(board: Board): Unit = {
    b = Some(board)
  }

  protected def changeState(state: BoardState): Unit = {
    if(b.isDefined){
      b.get.setState(state)
    }
  }
  def clear(): Unit = changeState(new ClearState())

  def fog(): Unit = changeState(new FogState())

  def frost(): Unit = changeState(new frostState())

  def rain(): Unit = changeState(new RainState())

  def isClear(): Boolean = false

  def isFog(): Boolean = false

  def isFrost(): Boolean = false

  def isRain(): Boolean = false
}
