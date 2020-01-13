/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author piyus
 */
public class Student implements Student_ {
    
    String fname,lname,hostel,department,cg;
    public Student (String f , String l , String h, String d, String c)
    {
        fname=f;
        lname=l;
        hostel=h;
        department=d;
        cg=c;
    }

    @Override
    public String fname() {
    return fname;   
    }

    @Override
    public String lname() {
    return lname;    
    }

    @Override
    public String hostel() {
    return hostel;
    }

    @Override
    public String department() {
    return department;
    }

    @Override
    public String cgpa() {
    return cg; 
    }
    
    
    
}
