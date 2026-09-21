class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c== '('){
                leftStack.push(i);
            }
            else if (c=='*'){
                starStack.push(i);
            } 
            else{
                if (leftStack.size() != 0){
                    leftStack.pop();
                } else if (starStack.size() != 0) {
                    starStack.pop();
                } else{
                    return false;
                }
            } 
        }

        // check if more ( and * cant clear it
        while (leftStack.size() > 0){
            int left = leftStack.pop();
            if (starStack.peek() == null){
                return false;
            } 
            int star = starStack.pop();
            if (star < left){
                return false;
            }
        }
        return true;
    }
}