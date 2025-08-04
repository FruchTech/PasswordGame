package model.rules;

import java.util.Random;

public class MathRule implements IRule {

    private final String expression;
    private final int expectedResult;

    public MathRule() {
        Object[] task = generateRandomExpressionWithIntegerResult();
        this.expression = (String) task[0];
        this.expectedResult = (Integer) task[1];
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss das Ergebnis der Rechnung enthalten: " + expression + " = ? ";
    }

    @Override
    public String shortRequirement() {
        return "Lösung von " + expression;
    }

    @Override
    public boolean validate(String password) {
        return password.contains(String.valueOf(expectedResult));
    }

    private static Object[] generateRandomExpressionWithIntegerResult() {
        Random random = new Random();
        String[] operators = {"+", "-", "*", "/"};

        while (true) {
            int base = randInt(1, 6, random);
            int exponent = randInt(2, 4, random);
            int powResult = (int) Math.pow(base, exponent);

            int c = randInt(1, 10, random);
            int d = randInt(1, 10, random);
            String op = operators[random.nextInt(operators.length)];

            int rhs = computeSafe(c, d, op);
            if (rhs == Integer.MIN_VALUE) continue;

            int resultAdd = powResult + rhs;
            if (resultAdd >= 1) {
                String expression = base + "^" + exponent + " + " + c + " " + op + " " + d;
                return new Object[]{expression, resultAdd};
            }

            if (powResult >= rhs && (powResult - rhs) >= 0) {
                int resultSub = powResult - rhs;
                String expression = base + "^" + exponent + " - " + c + " " + op + " " + d;
                return new Object[]{expression, resultSub};
            }

            int resultMul = powResult * rhs;
            if (resultMul >= 0) {
                String expression = base + "^" + exponent + " * " + c + " " + op + " " + d;
                return new Object[]{expression, resultMul};
            }

            if (rhs != 0 && powResult % rhs == 0) {
                int resultDiv = powResult / rhs;
                if (resultDiv >= 0) {
                    String expression = base + "^" + exponent + " / " + c + " " + op + " " + d;
                    return new Object[]{expression, resultDiv};
                }
            }
        }
    }

    private static int computeSafe(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0 && a % b == 0) return a / b;
                else return Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private static int randInt(int min, int max, Random r) {
        return r.nextInt(max - min + 1) + min;
    }
}
