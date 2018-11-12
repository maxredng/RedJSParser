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
public class Borders {
    
    public int openIndex;
    public int closeIndex;
    public String inside;
    public int index;

    String line;
    public Borders(String r)
    {
        line = r;
   
        populate();
    }

    private void populate() {

        openIndex = line.indexOf("{");
        int opens = 1;
        int close = 0;
        while(close<opens)
        {
            close ++;
            closeIndex = numberedIndex(line,"}",close);
            try {
                opens = line.substring(openIndex, closeIndex).split("\\{").length - 1;
            } catch (Exception e) {
            }
        }
        
        
    }
    
    
    public static int numberedIndex(String line,String ar,int ind)
    {
        int result = -1;
        int current = 0;
        int count = 0;
        
        while(count<ind)
        {
            String sline = line.substring(current+1);
            result = current + sline.indexOf(ar)+1;
            current = current + sline.indexOf(ar)+1;
            count ++;
        }
        
        
        return result;
    }
}
