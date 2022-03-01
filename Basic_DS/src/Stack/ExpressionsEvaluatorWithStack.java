package Stack;

public class ExpressionsEvaluatorWithStack {

    public boolean isOperand(char ch) {
        return ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57) || (ch == ' '));
    }

    public int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;

        }
        return -1;
    }

    public String infixToPostfix(String infix) {
        DynamicStack<Character> stack = new DynamicStack<>();
        StringBuilder postfix = new StringBuilder();
        StringBuilder num = new StringBuilder();
        // boolean flag = true;
        for (int i = 0; i < infix.length(); i++) {
            char cur_ele = infix.charAt(i);
            if (isOperand(cur_ele)) {

                if (cur_ele == ' ' || i == (infix.length() - 1)) {

                    if (i == (infix.length() - 1))
                        num.append(cur_ele);
                    if (num != null)
                        postfix.append(num);
                    num.setLength(0);
                } else {
                    num.append(cur_ele);

                }
            } else {
                while (!stack.isStackEmpty() && priority(stack.peek()) >= priority(cur_ele)) { // priority is greater or
                                                                                               // equal to top operator
                    postfix.append(stack.pop()); // then pop

                }
                stack.push(cur_ele); // push cur elem to stack
            }

        }
        while (!stack.isStackEmpty()) {
            postfix.append(stack.pop());// at end pop all operators from stack
        }

        return postfix.toString();

    }

    public String infixToPrefix(String infix) {
        DynamicStack<Character> stack = new DynamicStack<>();
        StringBuilder prefix = new StringBuilder();
        StringBuilder num = new StringBuilder();
        // boolean flag = true;
        StringBuilder pre = new StringBuilder(infix);
        infix = (pre.reverse()).toString();
        for (int i = 0; i < infix.length(); i++) {
            char cur_ele = infix.charAt(i);
            if (isOperand(cur_ele)) {

                if (cur_ele == ' ' || i == (infix.length() - 1)) {
                    // num.append(cur_ele);
                    if (i == (infix.length() - 1))
                        num.append(cur_ele);
                    if (num != null)
                        prefix.append(num);
                    num.setLength(0);
                } else {
                    num.append(cur_ele);
                }
            } else {
                while (!stack.isStackEmpty() && priority(stack.peek()) > priority(cur_ele)) { // priority is greater
                                                                                              // than top operator
                    prefix.append(stack.pop());// then pop

                }
                stack.push(cur_ele);// push cur elem to stack
            }

        }
        while (!stack.isStackEmpty()) {
            prefix.append(stack.pop()); // at end pop all operators from stack
        }

        return prefix.reverse().toString();
    }

    public double evaluatePostfix(String postfix) {
        double result;
        DynamicStack<Double> stack = new DynamicStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char cur_ele = postfix.charAt(i);
            if (isOperand(cur_ele)) {
                StringBuilder num = new StringBuilder();
                // traverse from left to right 
                // push operand to stack
                // if operator found pop two operands from stack and evaluate and push again
                if (cur_ele == ' ') {
                    if (num != null)

                        num.setLength(0);
                } else {
                    // num.append(cur_ele);
                    stack.push(Double.valueOf(cur_ele));
                }

            } else {

                double op2 = stack.pop();// first popped is 2nd operand
                double op1 = stack.pop();
                result = calculate(op1, op2, cur_ele);
                stack.push(result);

            }
        }

        return stack.pop();
    }

    private double calculate(double op1, double op2, char cur_ele) {
        switch (cur_ele) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            case '%':
                return op1 % op2;

        }

        return -1;
    }

    public double evaluatePrefix(String prefix) {
        double result;
        DynamicStack<Double> stack = new DynamicStack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char cur_ele = prefix.charAt(i);
            if (isOperand(cur_ele)) {
                // traverse from right to left
                // push operand to stack
                // if operator found pop two operands from stack and evaluate and push again
                StringBuilder num = new StringBuilder();
                if (cur_ele == ' ') {
                    if (num != null)
                        stack.push(Double.valueOf(num.toString()));
                    num.setLength(0);
                } else {
                    stack.push(Double.valueOf(cur_ele));
                }
            } else {
                double op1 = stack.pop(); // 1st popped is 1st operand
                double op2 = stack.pop();
                result = calculate(op1, op2, cur_ele);

                stack.push(result);
            }
        }

        return stack.pop();

    }

    public static void main(String[] args) {
        ExpressionsEvaluatorWithStack evaluator = new ExpressionsEvaluatorWithStack();
        String infix = "4 * 5 + 6 / 8 * 9 + 7 - 2";
        System.out.println("infix expression is  : " + infix);
        String postfix = evaluator.infixToPostfix(infix);
        System.out.println("postfix expression is  : " + postfix);
        String prefix = evaluator.infixToPrefix(infix);
        System.out.println("prefix expression is  : " + prefix);

        System.out.println("result of postfix is : " + evaluator.evaluatePostfix(postfix));
        System.out.println("result of prefix is : " + evaluator.evaluatePrefix(prefix));
    }

}
