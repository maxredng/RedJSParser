/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redjsparser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author bsati
 */
public class JSFile {
    public List<Record> globalvars;
    private String rawstring;
    public String error;
    public JSBlock functions;
    boolean started = false;
   public JSFile(String s)
   {
       rawstring = s;
       populate();
   }

   public JSFile(File f)
   {
       try {
           rawstring = FileUtils.readFileToString(f);
           populate();
       } catch (IOException iOException) {
           error = iOException.getMessage();
       }
   }
   
    private void populate() {

    rawstring = rawstring.replaceAll(""+'\r'," ").replaceAll(""+'\n'," ");
    
    functions = new JSBlock(rawstring);

    }

    private void getGlobalVars() {

    }
    
}
