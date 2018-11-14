/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

/**
 *
 * @author Lord
 */
public class DisciplineException extends Exception {

    /**
     * Creates a new instance of <code>DisciplineAlreadyInUseException</code>
     * without detail message.
     */
    public DisciplineException() {
    }

    /**
     * Constructs an instance of <code>DisciplineAlreadyInUseException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public DisciplineException(String msg) {
        super(msg);
    }
}
