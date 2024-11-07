package stack;

public class InfixToPostfix {
    private static CharStack stack;
    private static StringBuilder output;
    private static StringBuilder number;

    public static String translate(String infix) {
        infix = infix.replace(" ", "");
        int len = infix.length();
        number = new StringBuilder(); //for multi-digit numbers
        output = new StringBuilder();
        stack = new CharStack(len);
        for (int i = 0; i < len; i++) {
            char current = infix.charAt(i);
            if (Character.isDigit(current)) {
                number.append(current); /*if current char is a digit append in number to wait and see if the next number is also a number. In that case, append it too. */
            } else if (Character.isLetter(current)) {
                flushNumber(); //appends the accumulated number in output.
                output.append(current).append(" "); //append the letter/variable in output.
            } else { // if anything other than letters or digit is found.
                flushNumber(); //appends the accumulated number in output.
                switch (current) { //handling any other characters that may show up.
                    case '(': // in case of left bracket, push.
                        stack.push(current);
                        break;
                    case ')': //in case of right bracket, pop and append in output till left bracket is found.
                        gotRightParentheses(current);
                        break;
                    default: // operator handling.
                        gotOperator(current);
                        break;
                }
            }
        }
        flushNumber(); //appends the accumulated number in output.
        while (!stack.isEmpty()) { //after scanning, pop and append everything.
            output.append(stack.pop()).append(" ");
        }
        return output.toString().trim(); /*trim to remove trailing whitespaces. toString to convert StringBuilder to String. */
    }

    private static void gotRightParentheses(char current) {
        while (!stack.isEmpty()) {
            char previousOperator = stack.pop();
            if (previousOperator == '(') {
                break;
            } else {
                output.append(previousOperator).append(" ");
            }
        }
    }

    private static void gotOperator(char currentOperator) {
        int currentPrec = getPrecedence(currentOperator);
        while (!stack.isEmpty()) {
            char prevOperator = stack.peek();
            int prevPrec = getPrecedence(prevOperator);
            if (prevPrec >= currentPrec) {
                output.append(stack.pop()).append(" ");
            } else {
                break;
            }
        }
        stack.push(currentOperator);
    }

    private static int getPrecedence(char ch) {
        int precedence = 0;
        switch (ch) {
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            case '^':
                precedence = 3;
                break;
        }
        return precedence;
    }

    private static void flushNumber() {
        if (!number.isEmpty()) {
            output.append(number).append(" ");
            number = new StringBuilder();
        }
    }
}