package cl.uchile.dcc
package gwent.observer

trait Observer {
  def update(o:ISsubject, arg:Any): Unit
}
