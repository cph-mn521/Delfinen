/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

/**
 *
 * @author Niels Bang
 */
public class CoachNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>CoachNotFoundException</code> without
     * detail message.
     */
    public CoachNotFoundException() {
    }

    /**
     * Constructs an instance of <code>CoachNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CoachNotFoundException(String msg) {
        super(msg);
    }
}
