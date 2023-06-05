package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.Controller

trait State {
  def setController(controller: Controller): Unit
}
