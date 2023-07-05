package cl.uchile.dcc
package gwent.observer

trait Observer {
  def update(o:ISubject, arg:Any): Unit
}
