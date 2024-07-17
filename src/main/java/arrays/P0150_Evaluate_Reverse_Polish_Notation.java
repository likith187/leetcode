package arrays;

import java.util.Stack;

public class P0150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens) {
            if (token.equals("*") || token.equals("/") || token.equals("+")||token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                switch(token) {
                    case "*":
                        stack.push(a * b);
                        break;
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
//class Solution {
//    public int evalRPN(String[] tokens) {
//        String validOps = "+-*/";
//        String[] stack = new String[tokens.length];
//        int tos = -1;
//
//        for(int i=0;i<tokens.length; i++){
//            if(validOps.contains(tokens[i])){
//                String op2 = stack[tos--];
//                String op1 = stack[tos--];
//                stack[++tos] =  performArithmatic(Integer.parseInt(op1),Integer.parseInt(op2),tokens[i]) + "";
//            }else {
//                stack[++tos] = tokens[i];
//            }
//        }
//        return Integer.parseInt(stack[tos]);
//    }
//    public int performArithmatic(int op1, int op2, String operation){
//        int result = 0;
//        switch(operation){
//            case "+" : result= op1+op2;break;
//            case "-" : result= op1-op2;break;
//            case "*" : result= op1*op2;break;
//            case "/" : result= op1/op2;break;
//            default : break;
//        }
//        return result;
//    }
//}