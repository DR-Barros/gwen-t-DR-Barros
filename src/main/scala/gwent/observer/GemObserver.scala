package cl.uchile.dcc
package gwent.observer

import gwent.controller.GameController

/** Observador de gemas
 * 
 * Observa a los jugadores, si es que alguno se queda sin gemas
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class GemObserver extends Observer {
  /** Guarda el controlador del juego */
  private var gameController: Option[GameController] = None
  /** Avisa al game controller cuando un jugador se queda sin gemas */
  def update(o:ISubject, arg:Any) = {
    if (arg.asInstanceOf[String] == "Perdio"){
      gameController.get.loose(o)
    }
  }

  /** setea el game controller
   * 
   * @param g el game controller a setear
   */
  def setGameController(g:GameController): Unit = {
    gameController = Some(g)
  }
}
