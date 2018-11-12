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
public class JSVar extends Record{
    
    String name;
    String value;
    
    public JSVar(String n,String v)
    {
        name = n;
        value = v;
        type = "var";
    }
}
