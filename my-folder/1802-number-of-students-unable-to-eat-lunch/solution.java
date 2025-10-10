class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> dq= new ArrayDeque<>();
        Stack<Integer> stack=new Stack<>();
        int n=students.length;
        for(int i=0;i<n;i++){
            dq.addLast(students[i]);
            stack.add(sandwiches[n-1-i]);
        }
        int not_eaten=0;
        while(!stack.isEmpty() && not_eaten<stack.size()){
            if(stack.peek()==dq.peekFirst()){
                stack.pop();
                dq.pollFirst();
                not_eaten=0;
            }
            else{
                dq.addLast(dq.pollFirst());
                not_eaten++;
            }
        }
        return stack.size();
    }
}
