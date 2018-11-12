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
public class JSExpression extends Record{
    
    String raw;
    
    public JSExpression(String r)
    {
        raw = r;
        populate();
    }

    private void populate() {

        body = trim(raw);
    }
    
    
    public String trim(String ex)
    {
        String result = "";
        String temp = "";
        boolean started = false;
        boolean gap = false;
        
        char[] ch = ex.toCharArray();
        
        for(char one:ch)
        {
            if(!started)
            {
                if(!Character.isWhitespace(one))
                {
                    started = true;
                    result = result + one;
                }
            }else
            {
                if(!gap)
                {
                    if(Character.isWhitespace(one))
                    {
                        gap = true;
                        temp = temp + one;
                    }else
                    {
                        result = result + one;
                    }
                }else
                {
                     if(!Character.isWhitespace(one))
                    {
                        gap = false;
                        result = result + temp;
                        result = result + one;
                        temp = "";
                    }
                
                }
                
            
            }
        }
        
        return result;
    }
}
