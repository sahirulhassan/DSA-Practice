package stack;

public class PostfixParser {
    private static Stack stack;

    public static int evaluate(String postfix) {
        stack = new Stack(postfix.length());
        char ch;
        int firstOperand;
        int secondOperand;
        int tempResult;

        for (int i = 0; i < postfix.length(); i++) { //scan symbols from left to right.
            ch = postfix.charAt(i);

            if (ch >= '0' && ch <= '9') { //if the symbol is an operand, push.
                stack.push(Character.getNumericValue(ch));
            } else {
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
}
