class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(String token: tokens){
            switch(token){

                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;

                case "-":
                    int n=stack.pop();
                    int m=stack.pop();
                    stack.push(m-n);
                    break;

                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;

                case "/":
                    n=stack.pop();
                    m=stack.pop();
                    stack.push(m/n);
                    break;

                default:
                stack.push(Integer.parseInt(token));               
            }
        }
        return stack.pop();
    }
}
