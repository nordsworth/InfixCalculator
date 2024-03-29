package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

import java.util.HashMap;
import java.util.Objects;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.
    // ALL subclasses of operator MUST be in their own file.
    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );

    static HashMap<String, Operator> operators = new HashMap<>();

    static {
        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
        operators.put("^", new PowerOperator());
        operators.put("(", new openOperator());
        operators.put(")", new closeOperator());
    }

    public Operator() {
        System.out.println("kobe");
    }

    public Operator(String token) {
        if (check(token) == true) {

        }
    }

    public int priority;

    public abstract int priority();

    public Operand execute(Operand op1, Operand op2) {
        return op1;
    }


    /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     * for example token.equals("+") and so on.
     * Think about what happens if we add more operators.
     */

    public static boolean check(String token) {
        try {
            int x = Integer.parseInt(token);
        } catch (NumberFormatException nfc) {
            return true;
        }
        return false;
    }


    public static Operator getOperator(String token) {
        return operators.get(token);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return priority == operator.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority);
    }
}
