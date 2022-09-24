package com.example.calculator.operations;

public class Operations {

    public static String doOperation(String operation){

        int nextOperatorPos, operationEndingPos, firstNumber, secondNumber;
        char operator;
        String res = "";
        boolean finished = false;

        while (!finished) {
            res = "";

            nextOperatorPos = getNextOperator(operation, 0);
            operationEndingPos = getNextOperator(operation, nextOperatorPos + 1);
            operator = operation.charAt(nextOperatorPos);

            if (operationEndingPos == -1) {
                secondNumber = Integer.parseInt(operation.substring(nextOperatorPos));
                finished = true;
            } else {
                secondNumber = Integer.parseInt(operation.substring(nextOperatorPos + 1, operationEndingPos));
            }

            firstNumber = Integer.parseInt(operation.substring(0, nextOperatorPos));
            res += operate(firstNumber, secondNumber, operator);
            System.out.println("RES: " + res);


            if (!finished) {
                operation = res + operation.substring(operationEndingPos);
                System.out.println("OPERATION: " + operation);
            }
        }
        return res;
    }

    private static int getNextOperator(String operation, int actualPosition) {
        int nextAddition = operation.indexOf("+", actualPosition);
        int nextSubstraction = operation.indexOf("-", actualPosition);


        if (nextAddition == -1 && nextSubstraction == -1)
            return -1;
        else {
            if (nextAddition == -1) return nextSubstraction;
            if (nextSubstraction == -1) return nextAddition;
            return Math.min(nextAddition, nextSubstraction);
        }
    }

    private static int operate(int firstNumber, int secondNumber, char operator) {
        int res;
        if (operator == '+') {
            res = add(firstNumber, secondNumber);
        } else {
            res = subtract(firstNumber, secondNumber);

        }
        return  res;
    }

    private static int add(int op1, int op2){
        return op1 + op2;
    }

    private static int subtract(int op1, int op2){
        System.out.println("HOLLLLLAA");
        return op1 - op2;
    }
}
 