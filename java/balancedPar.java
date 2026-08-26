import java.util.*;

public class balancedPar{

    public boolean balancedPar(String str){
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']'){

                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();

                if((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

class Main{

    public static void main(String[] args){
        String test1 = "[()]{}{[()()]}";
        String test2 = "[()";

        balancedPar obj = new balancedPar();

        System.out.println(obj.balancedPar(test1)); 
        System.out.println(obj.balancedPar(test2)); 
    }
}
