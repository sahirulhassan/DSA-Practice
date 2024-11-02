package stack;

public class InfixToPostfix {
    private static Stack stack;
    private static String output;

    public static String translate(String infix) {
        output = "";
        stack = new Stack(infix.length());
        for (int i = 0; i < infix.length(); i++) { //scanning from left to right
            char ch = infix.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '^':
                    gotOperator(ch, 3);
                    break;
                case '(':
                    stack.push((int)ch); //if the symbol is a left bracket, push.
                    break;
                case ')':
                    gotParenthesis(); /* if the symbol is a right bracket, pop all operators and append them in
                    output, till a left bracket is found */
                    break;
                case ' ': //Clearing whitespaces.
                    break;
                default:
                    output = output + ch; //if the symbol is an operand, then append and display.
                    break;
            }
        }

        while (!stack.isEmpty()) {
            output += (char) stack.pop(); //after scanning, pop all symbols from the stack and append them.
        }

        return output;
    }

    private static void gotOperator(char operator, int precedence) {
        while (!stack.isEmpty()) {
            char prevOperator = (char) stack.peek(); //peeking the top value of stack to compare precedence.
            if (prevOperator == '(') {
                break;
            }
            int prevPrecedence;
            if (prevOperator == '+' || prevOperator == '-') {
                prevPrecedence = 1;
            } else if (prevOperator == '*' || prevOperator == '/') {
                prevPrecedence = 2;
            } else { // for exponents
                prevPrecedence = 3;
            }

            if (prevPrecedence < precedence) { /*if the precedence of the previous element is lesser, leave it as is and push the current operator in.*/
                break;
            } else { //precedence of previous element greater or equal, so pop and append in output.
                output += stack.pop();
            }
        }
        stack.push((int)operator); //after precedence is completely compared, push the current operator.
    }

    private static void gotParenthesis() { //handles right parentheses.
        while (!stack.isEmpty()) {
            char ch = (char) stack.pop();
            if (ch == '(') { /* pop all operators and append them in output, till a left bracket is found */
                break;
            } else {
                output += ch;
            }
        }
    }
}