package stack;

public class PostfixParser {
    private static IntStack stack;
    private static StringBuilder number;

    public static int evaluate(String postfix) {
        stack = new IntStack(postfix.length());
        number = new StringBuilder();
        char ch;
        int firstOperand, secondOperand, tempResult;

        for (int i = 0; i < postfix.length(); i++) { //scan symbols from left to right.
            ch = postfix.charAt(i);
            if (Character.isDigit(ch)) { //if the symbol is an operand, accumulate till a whitespace or operator.
                number.append(ch);
            } else if (ch == ' ') {
                flushNumber(); //whitespace found, push number and flush.
            } else {
                flushNumber(); //operator found, push number and flush.
                secondOperand = stack.pop(); //note how second operand is popped first.
                firstOperand = stack.pop();
                switch (ch) { //if symbol is an operator, pop two symbols and evaluate them.
                    case '+':
                        tempResult = firstOperand + secondOperand;
                        break;
                    case '-':
                        tempResult = firstOperand - secondOperand;
                        break;
                    case '*':
                        tempResult = firstOperand * secondOperand;
                        break;
                    case '/':
                        tempResult = firstOperand / secondOperand;
                        break;
                    case '^':
                        tempResult = (int) Math.pow(firstOperand, secondOperand);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported operator: " + ch);
                }
                stack.push(tempResult); //Push the result.
            }
        }
        return stack.pop(); //Final result retrieval.
    }

    private static void flushNumber() {
        if (!number.isEmpty()) {
            stack.push(Integer.parseInt(number.toString()));
            number = new StringBuilder();
        }
    }
}
