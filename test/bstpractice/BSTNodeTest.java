/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstpractice;

import java.util.Hashtable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author csc190
 */
public class BSTNodeTest {
    
    public BSTNodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    class BSTTestCase{
        protected int [] inpArr;
        protected int [][] outArr;
        public BSTTestCase(int [] inp, int[][] outA){
            this.inpArr = inp;
            this.outArr = outA;
        }
        protected  boolean treeEq(BSTNode root1, BSTNode root2){
            if(root1==null){
                return root1==root2;
            }else if(root2==null){
                return root1==root2;
            }else{//none of them is null
                return root1.value==root2.value &&
                        treeEq(root1.left, root2.left) &&
                        treeEq(root1.right, root2.right);
            }
        }
        protected BSTNode getOrCreate(int val, Hashtable<Integer,BSTNode> tbl){
            if(val==MIN) return null;
            if(!tbl.containsKey(val)){
                BSTNode node = new BSTNode(val);
                tbl.put(val, node);
            }
            return tbl.get(val);
        }
        protected BSTNode buildFromTriplets(int [][] arr){
            if(arr==null || arr.length==0) return null;
            BSTNode root = null;
            Hashtable<Integer, BSTNode> tbl = new Hashtable<Integer, BSTNode>();
            for(int i=0; i<arr.length; i++){
                int [] triplet = arr[i];
                BSTNode n1 = getOrCreate(triplet[0], tbl);
                BSTNode n2 = getOrCreate(triplet[1], tbl);
                BSTNode n3 = getOrCreate(triplet[2], tbl);
                n1.left = n2;
                n1.right = n3;
                if(i==0) root = n1;
            }
            return root;            
        }
        public void run(){
            BSTNode root1 = BSTNode.buildTree(inpArr);
            BSTNode root2 = buildFromTriplets(outArr);
            if(!treeEq(root1, root2)){
                fail("ERROR ...");
            }
        }
    }
    
    public static final int MIN = Integer.MIN_VALUE;
    /**
     * Test of buildTree method, of class BSTNode.
     */
    @Test
    public void testBuildTree_controlCoverage() {
        BSTTestCase [] arrTestCases = new BSTTestCase [] {
          new BSTTestCase(new int [] {1, 3}, new int [][] {{1, MIN, 3}, {3, MIN, MIN}}) ,
            new BSTTestCase(new int [] {1}, new int [][] {{1, MIN, MIN}})
        };
        for(int i=0; i<arrTestCases.length; i++){
            arrTestCases[i].run();
        }
    }

    @Test
    public void testBuildTree_equivClass() {
        
    }
    @Test
    public void testBuildTree_boundaryValue() {
        
    }
   
    
}
