package cl.uchile.dcc
package gwent.exception

/** Excepcion lanzada cuando la mano esta llena
 * 
 * @param message mensaje descriptivo del error
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0 
 */
class HandIsFull(message:String) extends RuntimeException(message){

}
