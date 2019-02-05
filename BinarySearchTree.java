import java.util.*;

public class BinarySearchTree {

     public static void main(String []args){
         
        BST bst = new BST();
        
        Random rand = new Random();
        int index = 0;
        
        while(index < 20){
            bst.add(rand.nextInt(40));
            index++;
        }
        
        TreeNode root = bst.getRoot();
        bst.deleteNode(0);
        
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < list.size()-1; i++){
            sb.append(list.get(i) + ", ");
        }
        sb.append(list.get(list.size()-1));
        
        System.out.println(sb.toString());
        
     }
     
     public static void inOrder(TreeNode curr, List<Integer> result){
         if(curr == null){
             return;
         }
         inOrder(curr.left, result);
         result.add(curr.val);
         inOrder(curr.right, result);
     }
     
     public static void preOrder(TreeNode curr, List<Integer> result){
         if(curr == null){
             return;
         }
         result.add(curr.val);
         preOrder(curr.left, result);
         preOrder(curr.right, result);
     }
     
     public static void postOrder(TreeNode curr, List<Integer> result){
         if(curr == null){
             return;
         }
         postOrder(curr.left, result);
         postOrder(curr.right, result);
         result.add(curr.val);
     }
     
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

class BST {
    
    private TreeNode root;
    private int size;
    
    public BST(){
        root = null;
        size = 0;
    }
    
    public TreeNode getRoot(){
        return root;
    }
    
    public void add(int x){
        if(root == null){
            root = new TreeNode(x);
        }
        else{
            TreeNode curr = root;
            TreeNode prev = null;
            while(curr != null){
                prev = curr;
                if(x == curr.val){
                    return;
                }
                else if(x < curr.val){
                    curr = curr.left;
                }
                else{
                    curr = curr.right;
                }
            }
            if(x < prev.val){
                prev.left = new TreeNode(x);
            }
            else{
                prev.right = new TreeNode(x);
            }
        }
        size++;
    }
    
    public void deleteNode(int tgt){
        root = remove(tgt, root);
        size--;
    }
    
    private TreeNode remove(int tgt, TreeNode curr){
        if(curr == null){
            return null;
        }
        else{
            if(tgt < curr.val){
                curr.left = remove(tgt, curr.left);
            }
            else if(tgt > curr.val){
                curr.right = remove(tgt, curr.right);
            }
            else{
                if(curr.left == null && curr.right == null){
                    return null;
                }
                else if(curr.right == null){
                    return curr.left;
                }
                else{
                    int min = getMin(curr.right);
                    curr.val = min;
                    curr.right = remove(min, curr.right);
                }
            }
            return curr;
        }
    }
    
    private int getMin(TreeNode curr){
        while(curr.left != null){
            curr = curr.left;
        }
        return curr.val;
    }
    
    public int getSize(){
        return size;
    }
    
}