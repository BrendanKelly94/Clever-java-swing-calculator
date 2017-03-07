/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg413problem1a;

import java.util.*;

/**
 *
 * @author brend_000
 */
public abstract class Operator {

    static final HashMap<String, Operator> operators = new HashMap<>();

    static {
        operators.put("+", new AdditionOperator());
        operators.put("-", new SubtractionOperator());
        operators.put("*", new MultiplicationOperator());
        operators.put("/", new DivisionOperator());
        operators.put("^", new PowerOperator());
        operators.put("(", new LeftParOperator());
        operators.put(")", new RightParOperator());
        operators.put("#", new PoundOperator());
        operators.put("!", new ExclamationOperator());

    }

    static boolean check(String tok) {

        if (operators.containsKey(tok)) {
            return true;
        } else {
            return false;
        }
    }

    abstract int getOutPriority();

    abstract int priority();

    abstract Operand execute(Operand opd1, Operand opd2);

}
