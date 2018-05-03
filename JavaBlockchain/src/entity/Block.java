/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author minhnguyen
 */
public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    
    public String calculateHash() {
	String calculatedhash = StringUtil.applySha256( 
			previousHash +
			Long.toString(timeStamp) +
			data 
			);
	return calculatedhash;
    }

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }
    
    
    
}
