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
public class PoundOperator extends Operator {

    private int inPriority = 0;
    private int outPriority = 0;

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
        int div = opd1.getValue() / opd2.getValue();
        Operand opd3 = new Operand(div);
        return opd3;
    }
}
