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
public class AdditionOperator extends Operator {

    private int inPriority = 2;
    private int outPriority = 2;

    @Override
    public int getOutPriority() {
        return outPriority;
    }

    @Override
    public int priority() {
        return inPriority;
    }

    @Override
    public Operand execute(Operand opd1, Operand opd2) {
        int sum = opd1.getValue() + opd2.getValue();
        Operand opd3 = new Operand(sum);
        return opd3;
    }
}
