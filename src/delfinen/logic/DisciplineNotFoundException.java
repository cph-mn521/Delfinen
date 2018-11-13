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
public class DisciplineNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>DisciplineNotFound</code> without detail
     * message.
     */
    public DisciplineNotFoundException() {
    }

    /**
     * Constructs an instance of <code>DisciplineNotFound</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DisciplineNotFoundException(String msg) {
        super(msg);
    }
}
