public class 1614. Maximum Nesting Depth of the Parentheses {
    public int maxDepth(String s) {
        int maxdepth = 0, currentdepth = 0;
        //char[] arr = s.toCharArray();
        for( char c : s.toCharArray()){
            if(c == '('){
                currentdepth++;
                maxdepth = Math.max(maxdepth,currentdepth);
            }else if(c == ')'){
                currentdepth--;
            }
        }

        return maxdepth;
    }
}
