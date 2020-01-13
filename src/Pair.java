/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author piyus
 */
public class Pair <Z,Y> implements Comparable<Pair <Z,Y>> {
    Z a;
    Y b;
   

    @Override
    public int compareTo(Pair<Z, Y> O) {
        String s1=(String)a;
         String s2=(String)O.a;
        return (s1.compareTo(s2));
        
    }
    public String toString()
    {
        String s1=(String)a;
         String s2=(String)b;
         String s=s1+s2;
         return s;
    }
    
    
}
