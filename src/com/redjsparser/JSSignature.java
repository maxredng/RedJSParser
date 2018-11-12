/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redjsparser;

/**
 *
 * @author bsati
 */
public class JSSignature extends Record{
    
    public String name;
    public String param;
    
    public JSSignature(String n,String p)
    {
        name = n;
        param = p;
        type = "signature";
    }
    
}
