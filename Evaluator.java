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
public class Evaluator {

    private Stack<Operand> opdStack;
    private Stack<Operator> oprStack;

    public Evaluator() {
        opdStack = new Stack<Operand>();
        oprStack = new Stack<Operator>();
    }

    public int eval(String expr) {
        String tok;
        expr = expr.concat("!");
// init stack - necessary with operator priority schema;
// the priority of any operator in the operator stack other then
// the usual operators - "+-*/" - should be less than the priority
// of the usual operators
// When is good time to add “!” operator?

        //oprStack.push(new Operator("#"));
        oprStack.push(Operator.operators.get("#"));
        String delimiters = "+-*/^#!() ";
        StringTokenizer st = new StringTokenizer(expr, delimiters, true);
// the 3rd arg is true to indicate to use the delimiters as tokens, too
// but we'll filter out spaces
        while (st.hasMoreTokens()) {
            if (!(tok = st.nextToken()).equals(" ")) { // filter out spaces
                if (Operand.check(tok)) { // check if tok is an operand
                    opdStack.push(new Operand(tok));
                } else {
                    if (!Operator.check(tok)) {
                        System.out.println("*****invalid token******");
                        System.exit(1);
                    }
                    // Operator newOpr = new Operator(tok); // POINT 1
                    Operator newOpr = Operator.operators.get(tok);

                    //only for right associated 
                    while (((Operator) oprStack.peek()).priority() >= newOpr.priority() && ((Operator) oprStack.peek()).getOutPriority() >= newOpr.getOutPriority()) {
                        // note that when we eval the expression 1 - 2 we will
                        // push the 1 then the 2 and then do the subtraction operation
                        // This means that the first number to be popped is the
                        // second operand, not the first operand - see the following code

                        //taking care of right associativity
                        if ((oprStack.peek().priority() == 4 && newOpr.priority() == 4) || !(operable(oprStack.peek()))) {
                            break;
                        } else {
                            //popping all parantheses
                            if (newOpr == Operator.operators.get("!")) {
                                while (!(operable(oprStack.peek()))) {
                                    oprStack.pop();
                                }
                            }

                            Operator oldOpr = ((Operator) oprStack.pop());
                            //check if oldOpr is a parentheses, if so it cannot operate on operands

                            Operand op2 = (Operand) opdStack.pop();
                            Operand op1 = (Operand) opdStack.pop();
                            opdStack.push(oldOpr.execute(op1, op2));

                        }

                    }

                    oprStack.push(newOpr);

                }
            }
// Control gets here when we've picked up all of the tokens; you must add
// code to complete the evaluation - consider how the code given here
// will evaluate the expression 1+2*3
// When we have no more tokens to scan, the operand stack will contain 1 2
// and the operator stack will have + * with 2 and * on the top;
// In order to complete the evaluation we must empty the stacks (except
// the init operator on the operator stack); that is, we should keep
// evaluating the operator stack until it only contains the init operator;
// Suggestion: create a method that takes an operator as argument and
// then executes the while loop; also, move the stacks out of the main
// method
        }
        return opdStack.pop().getValue();
    }

    public boolean operable(Operator op) {
        boolean isOpr = true;
        if (op == Operator.operators.get(")") || op == Operator.operators.get("(") || op == Operator.operators.get("#")) {
            isOpr = false;
        }
        return isOpr;
    }

}
