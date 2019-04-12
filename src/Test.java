import DataStructures.MinStack;
import Permutations.NextPerm;

import java.util.HashMap;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        NextPerm nxt = new NextPerm(nums);
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n =  s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for( int i = 0; i < n; i++){
            if(count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if(stack.size() < 1) return false; // encountering a closed one first
                if(!isPair(stack.pop(), c)) return false;
            }
        }
        if(stack.size() > 0) return false;
        return true;
    }

    public static boolean isPair(char top, char c){
        switch (top){
            case '(':
                return c == ')';
            case '{':
                return c == '}';
            case '[':
                return c == ']';
            default:
                    return false;
        }
    }
}
