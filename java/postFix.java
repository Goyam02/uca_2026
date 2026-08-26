import java.util.*;

public class postFix{

    public int postfix(String str){

        Stack<Integer> stack = new Stack<>();

        String[] tokens = str.split(" ");

        for(String token : tokens){

            if(token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")){

                int second = stack.pop();
                int first = stack.pop();

                if(token.equals("+")){
                    stack.push(first + second);
                }

                else if(token.equals("-")){
                    stack.push(first - second);
                }

                else if(token.equals("*")){
                    stack.push(first * second);
                }

                else if(token.equals("/")){
                    stack.push(first / second);
                }

            }

            else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

class Main{

    public static void main(String[] args){

        String test1 = "2 3 1 * + 9 -";

        postFix obj = new postFix();

        System.out.println(obj.postfix(test1));
    }
}