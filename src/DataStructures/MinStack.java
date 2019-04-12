package DataStructures;

public class MinStack {

    private int min;
    private int size;
    private Node top;
    /** initialize your data structure here. */


    public MinStack() {
        size = 0;
    }

    public void push(int x) {
        if(size > 0){
            Node incoming = new Node(x);
            incoming.next = top;
            top = incoming;
            if(x <= min){
                min = x;
            }
        } else {
            min = x;
            top = new Node(x);
        }
        size ++;
    }

    public void pop() {
        // remove top element
        size--;
        if(size < 1){
            min = 0;
        } else if(top.val == min){
            Node nxt = top.next;
            min = nxt.getValue();
            do {
                if(min > nxt.getValue()){
                    min = nxt.getValue();
                }
                nxt = nxt.next;
            }
            while(nxt != null);
        }
        top = top.next;

    }

    public int top() {
        return top.getValue();
    }

    public int getMin() {
        return min;
    }

    class Node {
        public Node next;
        private int val;

        public Node(int val){
            this.val = val;
        }

        public int getValue(){
            return val;
        }

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */