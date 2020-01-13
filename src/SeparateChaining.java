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
public class SeparateChaining<K extends Comparable<K>,T> implements MyHashTable_<K,T> {
    
     public static long djb2(String str, int hashtableSize) { 
    long hash = 5381; 
    for (int i = 0; i < str.length(); i++) { 
        hash = ((hash << 5) + hash) + str.charAt(i); 
    } 
    return Math.abs(hash) % hashtableSize; 
}
     
   
   Object arr[];
   int size;
   public SeparateChaining ( int capacity )
   {
         arr=  (new Object [capacity]);
       size=capacity;
   }
   
    Node<K,T> root =null;
    
public int insert(K key, T obj)
{
     
            String S=key.toString();
           
    long value= djb2(S , size);
    int count=1;

    /*Node<K,T> Root;
         Root = (Node <K,T>)arr[(int)value];
    while(Root!=null)
    {
        count++;
        String s1= ((Pair)root.key).fname;
        String s2=  ((Pair)key).fname;
        System.out.println("Gupta1");
        if(s1.compareTo(s2)<0)
            Root=Root.right;
        else
            Root=Root.left;
    }
    Root =new Node <K,T>() ;
        Root.key=key;
        Root.obj=obj;
        Root.left=null;
        Root.right=null;
        */
     
       // System.out.println(value+" yo");
        if((Node <K,T>)arr[(int)value]==null)
        {
                arr[(int)value]=new Node <K,T>();
                ((Node <K,T>)arr[(int)value]).key=key;
                ((Node <K,T>)arr[(int)value]).obj=obj;
                ((Node <K,T>)arr[(int)value]).left=null;
                ((Node <K,T>)arr[(int)value]).right=null;
        }
        else
        {
           
            count++;
              Node <K,T> prev;Node<K,T> new1 ;
              
            prev =(Node <K,T>)arr[(int)value];
           
            new1 = (Node <K,T>)arr[(int)value];
            
            /*if(prev.left!=null)
             System.out.println(((Pair)prev.left.key).fname+" "+"yeh left");
             if(prev.right!=null)
            System.out.println(((Pair)prev.right.key).fname+" yeh right");*/
             
             
            
            if((new1.key).compareTo(key)<0)
                
            new1=new1.right;
            else
            new1=new1.left;
            
            while(new1!=null)
            {
                 count++;
                prev=new1;
            
              if((new1.key).compareTo(key)<0)
            new1=new1.right;
            else
            new1=new1.left;
            
            
            }
            
            new1 =new Node<K,T>();
            new1.key=key;
            new1.obj=obj;
            
           
            
              if((new1.key).compareTo(prev.key)<0)
            {
                prev.left=new1;    
            }
            else
            {
                prev.right=new1;
            }
            
            
         
         
         
        }
        
        return count;
    
     
    
}
/*public int insert1 (K Key ,T obj, Node<K,T> Root , int count1)
{
    count1++;
    if(Root==null)
    {
        Root =new Node <K,T>() ;
        Root.key=Key;
        Root.obj=obj;
        Root.left=null;
        Root.right=null;
        System.out.println("Piyush1");
        return count1;
        
    }
    else 
    {    
        String S1= ((Pair)root.key).fname;
        String S2=  ((Pair)Key).fname;
        System.out.println("Gupta1");
        if(S1.compareTo(S2)<0)
        {         System.out.println(S1);
            return insert1 (Key,obj,root.right , count1);}

         else 
            {
                        System.out.println(S2);
               return insert1 (Key,obj,root.left , count1);
            }
    }  
}
*/
public boolean contains (K key)
{
    String S=key.toString();
    long value= djb2(S , size);
   
    Node<K,T> Root=(Node <K,T>)arr[(int)value];
    

   
        
        while(Root!=null)
        {
            String s1="",s2="",s="";
            if(Root.key!=null)
            {
              
            s=Root.key.toString();
            }
              //System.out.println(S+" "+s);
            
            if(S.equals(s))
                return true;
            else
                {
                    
                    
                    //System.out.println(S2);
                    //System.out.println(S1);
                    if(key.compareTo(Root.key)>0)
                    {
                        Root=Root.right;
                    }
                    else
                    {
                        Root=Root.left;
                    }
                }       
            

        }
     //System.out.println("yaha aa gya");
    return false;
    
}
public int update (K key ,T obj)
{
    if(contains(key))
    {
        String S=key.toString();
       long value= djb2(S , size);
       int count=0;
        Node <K,T> Root=(Node <K,T>)arr[(int)value];
         while(Root!=null)
       {
           count++;
           String S1= key.toString();
            
            String S2= Root.key.toString();
            // System.out.println(S1+" "+S2);
           if(   S1.equals(S2)  )
           {
               Root.obj=obj;
               break;
           }
           else
               {
                    //S1= ((Pair)key).fname;
                   //S2= ((Pair)Root.key).fname;
                   if(Root.key.compareTo(key)<0)
                    {
                        Root=Root.right;
                    }
                    else
                    {
                        Root=Root.left;
                    }
               }       

       }
         return count;
    }
     else
     {
         return -1;
      }
         
}

 public T get(K key) throws NotFoundException
 {
     if(contains(key))
     {
         String S=key.toString();
       long value= djb2(S , size);
       int count=0;
        Node <K,T> Root=(Node <K,T>)arr[(int)value];
         while(Root!=null)
       {
            String S1= key.toString();
            
            String S2= Root.key.toString();
            // System.out.println(S1+" "+S2);
           if(   S1.equals(S2)  )
           {
               break;
           }
           else
               {
                   //S1= ((Pair)key).fname;
                   //S2= ((Pair)Root.key).fname;
                    if(Root.key.compareTo(key)<0)
                    {
                        Root=Root.right;
                    }
                    else
                    {
                        Root=Root.left;
                    }
               }  
            

       }
        
         return Root.obj;
    
     }
     else
         throw new NotFoundException() ;
 }
public int delete (K key)
{
    if (contains(key))
    {
        String S=key.toString();
       long value= djb2(S , size);
       int count=0;
             Node <K,T> Root=(Node <K,T>)arr[(int)value];    Node<K,T> Root2 =Root;
        while(Root!=null)
       {
           count++;
           
            String S1= key.toString();
            
            String S2= Root.key.toString();
             //System.out.println(S1+" "+S2+" delete");
      
        
           if(   S1.equals(S2)  )
           {
               break;
           }
           
           else
               {
                   Root2=Root;
                    //S1= ((Pair)key).fname;
                   //S2= ((Pair)Root.key).fname;
                    if(Root.key.compareTo(key)<0)
                    {
                        
                        Root=Root.right;
                    }
                    else
                    {
                        Root=Root.left;
                    }
               }
       }
        
        Node<K,T> Root1=Root;
        
        if(Root1.left==null && Root1.right==null) 
        {
            //System.out.println("piyush2");
            //S1= ((Pair)Root1.key).fname;
            //S2= ((Pair)Root2.key).fname;
            if(Root2.key.compareTo(Root1.key)<0)
                    {
                        Root2.right=null;
                    }
                    else
                    {
                        Root2.left=null;
                    }
            if(Root==(Node <K,T>)arr[(int)value])
            {
                arr[(int)value] = null;
            }
           
            Root.key=null;
            Root.obj=null; Root=null;
        }
        else if(Root1.right!=null )
        {
              //System.out.println("piyush3");
                Root2=Root1;
                Root1=Root1.right;

                count++;
                int count2=count;
                 //System.out.println (count+"piyush1");
                while(Root1.left!=null && Root1.right !=null)
             {
                 
                 count++;
                 //System.out.println (count+"piyush");
                 Root2=Root1;
                 Root1=Root1.left;
                 
               
             }
             if( Root1.right==null && Root1.left==null)
             {
                 //System.out.println("piyush7");
                 Root.key=Root1.key;
                 Root.obj=Root1.obj;
                 Root1.key=null;
                 Root1.obj=null;
                 Root2.left=null; 
             }
             else if (Root1.right==null)
             {
                 //System.out.println("piyush6");
                 count++;
                 Root.key=Root1.left.key;
                 Root.obj=Root1.left.obj;
                 Root1.left=null;
             }
             else
                     {
                         //System.out.println("piyush4");
                         
                         count++;
                         Root.key=Root1.key;
                         Root.obj=Root1.obj;
                         if(count==count2+1)
                         {
                            // System.out.println("piyush8");
                             Root2.right=Root1.right;
                            
                         }
                         else
                         Root2.left=Root1.right;
                         
                     }
         
            
        }
        else if(Root1.right==null) 
                {
                     //System.out.println("piyush4");
             //          S1= ((Pair)Root1.key).fname;
           // S2= ((Pair)Root2.key).fname;
            count++;
                    if(Root2.key.compareTo(Root1.key)<0)
                    {
                        Root2.right=Root1.left;
                    }
                    else
                    {
                        Root2.left=Root1.left;
                    }
                    if(Root==(Node <K,T>)arr[(int)value])
            {
                arr[(int)value] = Root1.left;
            }
                    Root.key=null;
                    Root.obj=null;
                }
        else
        {
            
        }
        
        return count;
                
    }
    else
        return -1;
    /*if (contains(key))
            {
               String S1= ((Pair)key).fname;
               String S2= ((Pair)key).lname;
               String S=S1+S2;
       long value= djb2(S , size);
       int count=0;
        Node <K,T> Root=(Node <K,T>)arr[(int)value];    Node<K,T> Root2 =Root;
        
         while(Root!=null)
       {
           count++;
           
             S1= ((Pair)key).fname +((Pair)key).lname;
            
            S2= ((Pair)Root.key).fname+ ((Pair)Root.key).lname;
            // System.out.println(S1+" "+S2);
            
           if(   S1.equals(S2)  )
           {
               break;
           }
           else
               {
                   Root2=Root;
                    S1= ((Pair)key).fname;
                   S2= ((Pair)Root.key).fname;
                    if(S2.compareTo(S1)<0)
                    {
                        
                        Root=Root.right;
                    }
                    else
                    {
                        Root=Root.left;
                    }
               }       

       }
         Node<K,T> Root1=Root;
         
          if( Root1.right==null )
          {
               S1= ((Pair)Root2.key).fname;
                   S2= ((Pair)Root1.key).fname;
                    if(S2.compareTo(S1)<0)
                    {
                        
                        Root2.right=null;
                    }
                    else
                    {
                        Root2.left=null;
                    }
                   
          }
     
         while(Root1.left!=null || Root1.right !=null)
         {
             Root2=Root1;
             Root1=Root1.left;
         }
         if( Root1.right==null && Root1.left==null)
         {
             Root.key=Root1.key;
             Root.obj=Root1.obj;
             Root1.key=null;
             Root1.obj=null;
             Root2.left=null; 
         }
         else if (Root.right==null)
         {
             Root.key=Root1.left.key;
             Root.obj=Root1.left.obj;
             Root1.left=null;
         }
         else
                 {
                     Root.key=Root1.key;
                     Root.obj=Root1.obj;
                     Root2.left=Root1.right;
                 }
         
         return count; 
               
            }
    else
        return -1;
*/
}
public String address(K key) throws NotFoundException
     {
         String s="";
         if(contains(key))
     {
         String S=key.toString();
            long value= djb2(S , size);
            String s1=Integer.toString((int)value);
            s1+="-";
            s+=s1;
    
            Node <K,T> Root=(Node <K,T>)arr[(int)value];
            while(Root!=null)
       {
           
            String S1= key.toString();
            
            String S2= Root.key.toString();
            // System.out.println(S1+" "+S2);
           if(   S1.equals(S2)  )
           {   
               //System.out.println("true");
               break;
           }
           else
               {
                    //S1= ((Pair)key).fname;
                   //S2= ((Pair)Root.key).fname;
                    // System.out.println(S1+" "+S2+" firse" );
                    if(key.compareTo(Root.key)>0)
                    {
                        s+="R";
                    
                        Root=Root.right;
                    }
                    else
                    {
                            s+="L";
                        Root=Root.left;
                    }
               }       

       }
         return s;
     }
        else
        {     
            throw new NotFoundException();
        }
     }
}
