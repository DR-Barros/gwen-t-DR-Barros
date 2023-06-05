package cl.uchile.dcc
package gwent.exception

/** Excepcion lanzada cuando se llama la transicion al que no se puede transicionar
 *
 * @param message mensaje descriptivo del error
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0 
 */
class StateError(message:String) extends RuntimeException(message) {

}
