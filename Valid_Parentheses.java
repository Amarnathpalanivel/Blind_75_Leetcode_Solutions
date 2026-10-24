class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
                continue;
            }
            if (st.isEmpty()) {
                return false;
            }
            char topBracket = st.peek();
            if (ch == ')' && topBracket != '(') {
                return false;
            }
            if (ch == '}' && topBracket != '{') {
                return false;
            }
            if (ch == ']' && topBracket != '[') {
                return false;
            }
            st.pop();
        }
        return st.isEmpty();
    }
}