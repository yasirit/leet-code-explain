package com.yasir.project.leetcode.explain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 功能说明
 *
 * @author 沈益鑫
 * @version 1.0.0
 * @date 2022/1/12
 */
public class ValidParentheses {

    private static Map<String, String> map = new HashMap(3);
    static {
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");
    }

    public static void main(String[] args) {
        System.out.println(validParentheses("{[]}"));
    }

    private static Boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character c : s.toCharArray()) {
            if(Objects.equals('{', c)) {
                stack.push('}');
            } else if(Objects.equals('(', c)) {
                stack.push(')');
            } else if(Objects.equals('[', c)) {
                stack.push(']');
            } else if(!Objects.equals(c, stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    private static Boolean validParentheses2(String s) {
        int halfSize = s.length() / 2;
        for(int i = 0 ; i < halfSize; i++) {
            s = s.replace("()","").replace("[]","").replace("{}","");
            if(s.length() == 0) {
                return true;
            }
        }
        return s.length() == 0;
    }
}
