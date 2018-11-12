/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redjsparser;

import java.util.Date;
import java.util.List;

/**
 *
 * @author bsati
 */
public abstract class Record {
    
    public List<Record> records;
    public String body;
    public String rawstring;
    public String error;
    public String type;
    public String bid;
    public String parent;
    public int order;
    public String project;
    
    

    
    
    
    public String getBid()
    {
    Date date = new Date();
    return Long.toString(date.getTime());
    }


    
}
