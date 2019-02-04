public class StackAndQueue {

     public static void main(String []args) throws Exception {
         
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();

        // Use data structures here
        
     }
     
}

class MyQueue {
    
    // Use doubly linked list to hold values
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int val){
            this.val = val;
            next = null;
            prev = null;
        }
    }
    
    ListNode head;
    ListNode tail;
    int size;
    
    public MyQueue(){
        head = new ListNode(Integer.MIN_VALUE);
        tail = new ListNode(Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    
    // Add element to end of queue
    public void offer(int x){
        ListNode curr = new ListNode(x);
        ListNode temp = tail.prev;
        temp.next = curr;
        curr.prev = temp;
        curr.next = tail;
        tail.prev = curr;
        size++;
    }
    
    // Remove from front of queue
    public int poll() throws Exception {
        if(size == 0){
            throw new Exception("Queue is empty");
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next.prev = head;
        temp.next = null;
        temp.prev = null;
        size--;
        return temp.val;
    }
    
    // Return front element
    public int peek() throws Exception {
        if(size == 0){
            throw new Exception("Queue is empty");
        }   
        return head.next.val;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    
    public int getSize(){
        return size;
    }
    
}

class MyStack {
    
    Integer[] stack;
    int size;
    int index;
    
    public MyStack(){
        stack = new Integer[10000];
        size = 0;
        index = -1;
    }
    
    public void push(int x){
        stack[++index] = x;
        size++;
    }
    
    public int pop() throws Exception {
        if(size == 0){
            throw new Exception("Stack is empty");
        }
        int result = stack[index--];
        size--;
        return result;
    }
    
    public int peek() throws Exception {
        if(size == 0){
            throw new Exception("Stack is empty");
        }
        return stack[index];
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int getSize(){
        return size;
    }
    
}