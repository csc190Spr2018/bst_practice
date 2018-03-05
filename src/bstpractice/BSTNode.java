/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstpractice;

/**
 *
 * @author csc190
 */
public class BSTNode {
    protected int value;
    protected BSTNode left, right;
    
    public BSTNode(int v){
        this.value = v;
        this.left = null;
        this.right = null;
    }
    
    public static BSTNode buildTree(int [] arr){
        if(arr==null || arr.length ==0){
            return null;
        }
        BSTNode root = new BSTNode(arr[0]);
        for(int i=1; i<arr.length; i++){
            root.insert(arr[i]);
        }
        return root;
    }
    
    public void insert(int v){
        if (this.value == v) return;
        else if (v < this.value) {
            if (this.left == null)
                this.left = new BSTNode(v);
            else
                this.left.insert(v);
        }else{
            if (this.right == null)
                this.right = new BSTNode(v);
            else
                this.right.insert(v);
        }
        
    }
    
}
