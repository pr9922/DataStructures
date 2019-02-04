public class HashTables {
    
    public static void main(String[] args){
        
        HashSet set = new HashSet();
        HashMap map = new HashMap();

        // test structures out here
    }
    
}

class HashSet {
    
    // ListNode for "buckets" that stores key
    class ListNode {
        int key;
        ListNode next;
        public ListNode(int key){
            this.key = key;
        }
    }
    
    ListNode[] nodes;
    
    public HashSet(){
        nodes = new ListNode[10000];
    }
    
    // Get the index for the bucket
    private int getIndex(int key){
        return Math.abs(Integer.hashCode(key)) % nodes.length;
    }
    
    // Find either the last element in the chain, or the element just before the target key
    private ListNode find(ListNode node, int key){
        ListNode curr = node;
        ListNode prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    // Add an item to the hashset. Return false if it already exists.
    public boolean add(int key){
        int index = getIndex(key);
        if(nodes[index] == null){
            nodes[index] = new ListNode(Integer.MIN_VALUE);
        }
        ListNode prev = find(nodes[index], key);
        if(prev.next != null){
            return false;
        }
        else{
            prev.next = new ListNode(key);
            return true;
        }
    }
    
    // Remove item from hashset (if it exists)
    public void remove(int key){
        int index = getIndex(key);
        if(nodes[index] == null){
            return;
        }
        ListNode prev = find(nodes[index], key);
        if(prev.next == null){
            return;
        }
        else{
            prev.next = prev.next.next;
        }
    }
    
    // Check if key exists in hash set
    public boolean contains(int key){
        int index = getIndex(key);
        if(nodes[index] == null){
            return false;
        }
        ListNode prev = find(nodes[index], key);
        if(prev.next == null){
            return false;
        }
        else{
            return true;
        }
    }
    
}

class HashMap {
    
    // ListNode bucket object that stores key/value pairs
    class ListNode {
        int key;
        int val;
        ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
        }
    }
    
    ListNode[] nodes;
    
    public HashMap(){
        nodes = new ListNode[10000];
    }
    
    // Put key value pair into hashmap
    public void put(int key, int val){
        int index = getIndex(key);
        if(nodes[index] == null){
            nodes[index] = new ListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        ListNode prev = find(nodes[index], key);
        if(prev.next == null){
            prev.next = new ListNode(key, val);
        }
        else{
            prev.next.val = val;
        }
    }
    
    // Retrieve value from hashmap
    public int get(int key){
        int index = getIndex(key);
        if(nodes[index] == null){ //Throw null pointer exception if key does not exist
            throw new NullPointerException("Key does not exist");
        }
        ListNode prev = find(nodes[index], key);
        if(prev.next == null){
            throw new NullPointerException("Key does not exist");
        }
        else{
            return prev.next.val;
        }
    }
    
    // Remove given key/value pair from hashmap
    public void remove(int key){
        int index = getIndex(key);
        if(nodes[index] == null){
            throw new NullPointerException("Key does not exist");
        }
        ListNode prev = find(nodes[index], key);
        if(prev.next == null){
            throw new NullPointerException("Key does not exist");
        }
        else{
            prev.next = prev.next.next;
        }
    }
    
    //Check if key exists in hashmap
    public boolean containsKey(int key){
        int index = getIndex(key);
        if(nodes[index] == null){
            return false;
        }
        ListNode prev = find(nodes[index], key);
        if(prev.next == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    private int getIndex(int key){
        return Math.abs(Integer.hashCode(key)) % nodes.length;
    }
    
    private ListNode find(ListNode node, int key){
        ListNode curr = node;
        ListNode prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
}