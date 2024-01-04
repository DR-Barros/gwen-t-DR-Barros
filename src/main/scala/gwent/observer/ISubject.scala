package cl.uchile.dcc
package gwent.observer

trait ISubject {
  def registerObserver(o: Observer): Unit
  def notifyObservers(response: Any): Unit 
}
