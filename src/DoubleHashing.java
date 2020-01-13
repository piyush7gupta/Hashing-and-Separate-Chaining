/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author piyus
 */
   import java.lang.Math; 
public class DoubleHashing<K,T> implements MyHashTable_<K,T> {
    
    public int size;
    T arr[];
    K arr1[];
    public DoubleHashing (int capacity)
    {
         arr = (T[])(new Object[capacity]);
         arr1 = (K[])(new Object[capacity]);
        size=capacity;
    }
   
    public static long sdbm(String str, int hashtableSize) { 
    long hash = 0; 
    for (int i = 0; i < str.length(); i++) { 
        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
    } 
    return Math.abs(hash) % (hashtableSize - 1) + 1; 
}
    public static long djb2(String str, int hashtableSize) { 
    long hash = 5381; 
    for (int i = 0; i < str.length(); i++) { 
        hash = ((hash << 5) + hash) + str.charAt(i); 
    } 
    return Math.abs(hash) % hashtableSize; 
}

    public int insert (K key ,T obj)
    {
        
            String s=key.toString();
            //System.out.println(s);
        long value= djb2(s , size);
        int count =1;
        while(arr[(int)value]!=null)
        {
           count++;
          value +=sdbm(s , size);
           value=value%size;
        }
        
        arr[(int)value]=obj;
        arr1[(int)value]=key;
        return count;
        
                
    }
     public int delete(K key)
     {
         if(contains(key))
         {
             String s=key.toString();
            
             long value= djb2(s , size);
            long value1=value;
            int count =1;    
            
              String S1="",S2="",S="";
        if(arr1[(int)value]!=null)
        {
        
      
          S=arr1[(int)value].toString();
        
        }
                while(!S.equals(s)) 
                {
                  count++;
                  value +=sdbm(s , size);
                  
                  value=value%size;
                  
       if(arr1[(int)value]!=null)
            {
               S=arr1[(int)value].toString();
            }
                }

            arr1[(int)value]=null;
            arr[(int)value]=null;
            
            return count;
         }
         else
         {
             return -1;
         }
     }
      public boolean contains(K key)
     {
        String s=key.toString();
        long value= djb2(s , size);
        long value1=value;
        int count =1;
        boolean b=true;
        String S1="",S2="",S="";
        if(arr1[(int)value]!=null)
        {
         S=arr1[(int)value].toString();
        
      
         
        }
        if(!S.equals(s))
        {
            count++;
            value +=sdbm(s , size);
            value=value%size;
            
            if(arr1[(int)value]!=null)
            {
                S=arr1[(int)value].toString();;
            }
   
            while(!S.equals(s) && value1!=value)
            {
               count++;
              value +=sdbm(s , size);
              value=value%size;
              if(arr1[(int)value]!=null)
            {
               S=arr1[(int)value].toString();
            }
               
            }
            
            //System.out.println(value+" "+S+" "+s+" "+count);
        }
        if(value1==value  && count!=1)
          b=false;
        
        return b;
     }
    public int update (K key ,T obj)
    {
        
        if(contains (key))
        {
           String s=key.toString();
            long value= djb2(s, size);
            long value1=value;
            int count =1;    
            String S="";
           if(arr1[(int)value]!=null)
            {
                 S=arr1[(int)value].toString();
            }
                while(!S.equals(s) )
                {
                   count++;
                  value +=sdbm(s , size);
                  value=value%size;
                  if(arr1[(int)value]!=null)
            {
                 S=arr1[(int)value].toString();
            }
                }

            arr[(int)value]=obj;
        
            return count;
        }
        else
        {     
            return -1;
        }
                   
    }
    public T get(K key) throws NotFoundException
    {
     if(contains (key))
        {
            int value=Integer.parseInt(address( key));
              return arr[(int)value];
        }
        else
        {     
            throw new NotFoundException();
        }
   
    }
     public String address(K key) throws NotFoundException
     {
          
         if(contains (key))
        {
            
            String s=key.toString();
            long value= djb2(s , size);
            long value1=value;
            int count =1;     
            String S1="",S2="",S="";
        if(arr1[(int)value]!=null)
        {
          S=arr1[(int)value].toString();
        
        }
                while(!s.equals(S) )
                {
                   count++;
                  value +=sdbm(s , size);
                  value=value%size;
                    //System.out.println(value+" "+S+" "+s+" "+count);
                if(arr1[(int)value]!=null)
            {
               S=arr1[(int)value].toString();
            }
                  
                }

            return Integer.toString((int)value);
        }
        else
        {     
            throw new NotFoundException();
        }
     }
    
}
