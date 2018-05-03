/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author minhnguyen
 */
public class QuickFind {
    private int[] id;
    
    public QuickFind(int N){
        id = new int[N];
        for(int i=0; i< N; i++){
            id[i] =i;
        }
    }
    
    public boolean connected(int p, int q){
        return id[p] == id[q];
    }
    
    //union quá chậm cho những bài toán lớn, thay vào đó sử dụng quickunion
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        if(p == q) return;
        for(int i =0; i< id.length ; i++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }
}
