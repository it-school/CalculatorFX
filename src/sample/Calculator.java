package sample;

/**
 * Calculator base class
 */
public class Calculator
{
    /**
     * First number
     */
    private double number1;
    private double number2;
    private Operation operation;
    private String result;
    private boolean firstCalculation;
    private double memory;

    public Calculator() {
        number1 = 0;
        number2 = 0;
        operation = Operation.UNASSIGNED;
        result = "0";
        firstCalculation = true;
    }

    /**
     * Gets first number
     *
     * @return double number
     */
    public final double getNumber1() {
        return number1;
    }

    /**
     * @param number1 first number
     */
    public final void setNumber1(final double number1) {
        this.number1 = number1;
    }

    public final double getNumber2() {
        return number2;
    }

    public void setNumber2(final double number2) {
        this.number2 = number2;
    }

    public final Operation getOperation() {
        return operation;
    }

    public final void setOperation(final Operation operation) {
        this.operation = operation;
    }

    public final String getResult() {
        return result;
    }

    public final void setResult(final String result) {
        this.result = result;
    }

    public final boolean isFirstCalculation() {
        return this.firstCalculation;
    }

    public final void setFirstCalculation(final boolean isFirstCalculation) {
        this.firstCalculation = isFirstCalculation;
    }

    /**
     * Main calculator method. Calculates the value for
     */
    public final void calculate() {
        switch (operation) {
            case PLUS:  // +
                result = String.valueOf(number1 + number2); // number1 + number 2 + "";
                break;
            case MINUS:  // -
                result = String.valueOf(number1 - number2);
                break;
            case MULTIPLY:  // *
                result = String.valueOf(number1 * number2);
                break;
            case DIVIDE:   // /
                result = number2 == 0? "Division by zero" : String.valueOf(number1 / number2);
                break;
            case POWER:   // x^y
                result = String.valueOf(Math.pow(number1,  number2));
                break;
            case SQRT:  // √
                result = number1 < 0? "No SQRT from negative" : String.valueOf(Math.sqrt(number1));
                break;
            default:
                result = "Unknown operation";
                break;
        }
        result = result.endsWith(".0") ? result.substring(0, result.length() - 2) : result;
    }

    public final double getMemory() {
        return memory;
    }

    public final void setMemory(final double memory) {
        this.memory = memory;
    }
}
