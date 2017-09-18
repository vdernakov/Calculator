package com.example.vlad.fcalculator;

import org.mariuszgromada.math.mxparser.Expression;

/**
 * Created by vlad on 11/09/17.
 */

public class Calculator {

    private static Boolean isCalculated = false;

    public static String calculate(String expr) {
        Expression expression = new Expression(expr);
        double result = expression.calculate();
        String resultStr;

        // delete ".0$" from the end of result
        if (result - (int) result == 0) {
            resultStr = String.valueOf((int) result);
        } else {
            resultStr = String.valueOf(result);
        }
        if (resultStr.length() >= 12) {
            resultStr = String.format("%.12s", Float.valueOf(resultStr));
        }
        if (resultStr.equals("NaN")) {
            resultStr = "Error";
        }
        isCalculated = true;
        return resultStr;
    }

    public static Boolean isCalculated() {
        return isCalculated;
    }

    public static void resetCalculated() {
        isCalculated = false;
    }

}