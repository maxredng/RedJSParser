/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redjsparser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bsati
 */
public class JSBlock extends Record{
   
    public int close;
    
    public JSSignature signature;
    
    public JSBlock(String r)
    {
        rawstring = r;
        populate();
    }


    private void populate() 
    {
      type = "block";
      records = new ArrayList<>();
      String curline = rawstring;
      if(!curline.contains("{"))
      {
      populateExpressions(curline);
      
      }
      
      while(curline.contains("{"))
      {
       Borders borders = new Borders(curline);
       
          try {
              JSSignature sign = null;
              String bo = curline.substring(borders.openIndex + 1, borders.closeIndex);
              sign = populateExpressions(curline.substring(0,borders.openIndex));
              JSBlock block = new JSBlock(bo);
              block.signature = sign;
              records.add(block);
              curline = curline.substring(borders.closeIndex+1);              
          } catch (Exception e) {
          }
      
      }
      
      
        
        
    }
    
    public static void testRegex()
    {
     String varmex = "if\\s*?\\((.*?)\\)\\s*?$";
       Pattern empat = Pattern.compile(varmex);
        Matcher emat = empat.matcher(" if(ba>u(s)) ");
    while(emat.find())
    {
        String m = emat.group(1);
//        String b = emat.group(5);
        System.out.println(m);
    }
    }
    
    public JSSignature getSignature(String s)
    {
        JSSignature result = null;
        String regex = "signature\\s*?\\((.*?)\\)\\s*?$";
        String fex = "\\s+function\\s*?(.*?)\\s*?\\((.*?)\\)";
        
            Pattern funcpattern = Pattern.compile(fex);
            Matcher funcmatcher = funcpattern.matcher(s);

            while(funcmatcher.find())
            {
                result = new JSSignature(funcmatcher.group(1),funcmatcher.group(2));
            }
            
            if(result == null)
            {
        String[] reg = {"for","if","while"};
        
        for(String tp:reg)
        {
            String rex = regex.replace("signature", tp);

            Pattern pa = Pattern.compile(rex);
            Matcher ma = pa.matcher(s);

            while(ma.find())
            {
                result = new JSSignature(null,ma.group(1));
            }
            
            if(result!=null)
                break;
            
        }            
            
            }
        

    
        
        
        return result;
    }
    
    public JSSignature populateExpressions(String raw)
    {
        JSSignature result = null;
        String vargex = "var(\\s*)(.*?)(\\s*)=(\\s*)(.*?)(\\s*?)$";
        String varmex = "var\\s*(\\w*)\\s*?$";
        String singex = "\\s+function\\s*?(.*?)\\s*?\\((.*?)\\)";
        String expgex = "";
        

        Pattern spattern = Pattern.compile(singex);
        Matcher smatcher = spattern.matcher(raw);
        
        signature = getSignature(raw);
        
        while(smatcher.find())
        {
            signature = new JSSignature(smatcher.group(1),smatcher.group(2));
            result = signature;
         //   records.add(new JSSignature(smatcher.group(1),smatcher.group(2)));
            
        }        
        
        String[] exps = raw.substring(0,indexOfSignature(raw)).split(";");
        
        for(String ex:exps)
        {
        Pattern pattern = Pattern.compile(vargex);
        Matcher matcher = pattern.matcher(ex);
        
        Pattern empat = Pattern.compile(varmex);
        Matcher emat = empat.matcher(ex);
        
        if(worthy(ex))
        {
        if(!matcher.find()&!emat.find())
        {
            JSExpression expression = new JSExpression(ex);
            records.add(expression);
        }
        
        Pattern fullpat = Pattern.compile(vargex);
        Matcher fullmat = fullpat.matcher(ex);
        Pattern parpat = Pattern.compile(varmex);
        Matcher parmat = parpat.matcher(ex);        
        while(fullmat.find())
        {
            
            records.add(new JSVar(matcher.group(2),matcher.group(5)));
        }      
        while(parmat.find())
        {
            
            records.add(new JSVar(parmat.group(1),null));
        }              
        
        
        }
        }
        


        return result;
    }
 
    boolean worthy(String s)
    {
        boolean result = false;
        char[] ch = s.toCharArray();
        
        for(char one:ch)
        {
            if(!Character.isWhitespace(one))
            {
                result = true;
                break;
            }
        }
        return result;
    }
    
    int indexOfSignature(String r)
    {
        int result = r.length();
        String[] reg = {"function","for","if","while"};
        
        for(String tp:reg)
        {
            Pattern pa = Pattern.compile("\\s"+tp+"\\s(.*?)\\(");
            Matcher ma = pa.matcher(r);
            if(ma.find())
            {
            result = ma.start() + 1;
            }
            if(result>-1)
                break;
        }
    
        return result;
    }
}
