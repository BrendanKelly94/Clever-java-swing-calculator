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
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Evaluator anEvaluator = new Evaluator();
        for (String arg : args) {
            System.out.println(arg + " = " + anEvaluator.eval(arg));
        }
    }

}
