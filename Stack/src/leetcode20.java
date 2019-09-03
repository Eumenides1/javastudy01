import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

import java.util.Stack;
public class leetcode20 {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //
    //    左括号必须用相同类型的右括号闭合。
    //    左括号必须以正确的顺序闭合。
    //
    //注意空字符串可被认为是有效字符串。


    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character> ();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('||c=='{'||c=='['){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c==')' && topChar != '('){
                    return false;
                }
                if (c == ']'&& topChar!='['){
                    return false;
                }
                if(c == '}' && topChar!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        boolean a = new leetcode20().isValid("(){}[]");
        System.out.println(a);
    }
}
