package leetcode;
import java.util.Stack;
class S20 {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        stack.push('0');
       for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
           switch(c){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                    if(stack.pop() != ')')
                        return false;
                    break;
                case ']':
                    if(stack.pop() != ']')
                        return false;
                    break;
                case '}':
                    if(stack.pop() != '}')
                        return false;
                   
                    break;
                
           }
        }
        
       if(stack.pop() == '0'){
           return true;
       }else{
           return false;
       }

    }
}
