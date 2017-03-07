/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg413problem1a;

/**
 *
 * @author brend_000
 */
public class Operand {

    private int val;

    Operand(String tok) {

        this(Integer.parseInt(tok));
    }

    Operand(int value) {
        val = value;
    }

    static boolean check(String tok) {
        boolean isOp = true;
        try {
            Integer.parseInt(tok);
        } catch (NumberFormatException e) {
            isOp = false;
        }
        return isOp;
    }

    int getValue() {
        return val;
    }

}
