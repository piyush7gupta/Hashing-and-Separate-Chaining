
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author piyus
 */
public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FileReader fr; 
        try {
          
            fr = new FileReader(args[2]);
            BufferedReader rd=new BufferedReader(fr);
            String line=rd.readLine();
            String []words=line.split(" ");
            
                         SeparateChaining SC= new SeparateChaining (Integer.parseInt(args[0]));
                     
            
                DoubleHashing DH = new DoubleHashing(Integer.parseInt(args[0]));
           
            
            while(line!=null)
             {
                 if(args[1].equals("SCBST")) 
                 {
                     if(words[0].equals("insert"))
                     {
                         Pair<String ,String>  P =new Pair<String ,String> ();
                         P.a=words[1];
                         P.b=words[2];
    
                         Student S =new Student (words[1], words[2], words[3], words[4] ,words[5]);
                         
                        int val=SC.insert(P,S);
                        System.out.println(val);
                        //System.out.println("piyush");
                        
                         
                     }
                      if(words[0].equals("update"))
                     {
                         Pair<String ,String> P  =new Pair<String ,String> ();
                         P.a=words[1];
                         P.b=words[2];
    
                         Student S =new Student (words[1], words[2], words[3], words[4] ,words[5]);
                         
                        int val=SC.update(P,S);
                        if(val==-1)
                            System.out.println("E");
                        else
                        System.out.println(val);
                        
                         
                     }
                      if(words[0].equals("delete"))
                     {
                         Pair<String ,String>  P =new Pair<String ,String> ();
                         P.a=words[1];
                         P.b=words[2];
    
                        
                         
                        int val=SC.delete(P);
                        if(val==-1)
                            System.out.println("E");
                        else
                        System.out.println(val);
                        
                         
                     }
                      if(words[0].equals("contains"))
                     {
                         Pair<String ,String>  P =new Pair<String ,String> ();
                        P.a=words[1];
                         P.b=words[2];
    
                        
                         
                        boolean val=SC.contains(P);
                        if(val)
                            System.out.println("T");
                        else
                        System.out.println("F");
                        
                         
                     }
                      if(words[0].equals("get"))
                     {
                         Pair<String ,String>  P =new Pair<String ,String> ();
                        P.a=words[1];
                         P.b=words[2];
    
                        
                       try{
                        Student val=(Student)(SC.get(P));
                        System.out.println(val.fname+" "+val.lname+" "+val.hostel+" "+val.department+" "+val.cg);
                       }
                       catch (NotFoundException ex)
                               {
                                   System.out.println("E");
                               }
                        
                         
                     }
                       if(words[0].equals("address"))
                     {
                         Pair<String ,String>  P =new Pair<String ,String> ();
                         P.a=words[1];
                         P.b=words[2];
    
                        
                       try{
                        String val=(SC.address(P));
                        System.out.println(val);
                       }
                       catch (NotFoundException ex)
                               {
                                   System.out.println("E");
                               }
                        
                         
                     }
                      
                      
                     
                 }
                 else
                 {
                     if(words[0].equals("insert"))
                     {
                          Pair<String ,String>  P =new Pair<String ,String> ();
                         P.a=words[1];
                         P.b=words[2];
    
                         Student S =new Student (words[1], words[2], words[3], words[4] ,words[5]);
                         
                        int val=DH.insert(P,S);
                        System.out.println(val);
                        
                         
                     }
                     if(words[0].equals("update"))
                     {
                          Pair<String ,String>  P =new Pair<String ,String> ();
                         P.a=words[1];
                         P.b=words[2];
    
                         Student S =new Student (words[1], words[2], words[3], words[4] ,words[5]);
                         
                        int val=DH.update(P,S);
                        if(val==-1)
                        System.out.println("E");
                        else
                        System.out.println(val);
                        
                         
                     }
                      if(words[0].equals("delete"))
                     {
                          Pair<String ,String>  P =new Pair<String ,String> ();
                         P.a=words[1];
                         P.b=words[2];

                        int val=DH.delete(P);
                        if(val==-1)
                            System.out.println("E");
                        else
                        System.out.println(val);
                        
                         
                     }
                      if(words[0].equals("contains"))
                     {
                        Pair<String ,String>  P =new Pair<String ,String> ();
                        P.a=words[1];
                         P.b=words[2];
    
                        
                         
                        boolean val=DH.contains(P);
                        if(val)
                            System.out.println("T");
                        else
                        System.out.println("F");
                        
                         
                     }
                      if(words[0].equals("get"))
                     {
                         Pair<String ,String>  P =new Pair<String ,String> ();
                        P.a=words[1];
                         P.b=words[2];
    
                        
                       try{
                        Student val=(Student)(DH.get(P));
                        System.out.println(val.fname+" "+val.lname+" "+val.hostel+" "+val.department+" "+val.cg);
                       }
                       catch (NotFoundException ex)
                               {
                                   System.out.println("E");
                               }
                        
                         
                     }
                      if(words[0].equals("address"))
                     {
                          Pair<String ,String>  P =new Pair<String ,String> ();
                       P.a=words[1];
                         P.b=words[2];
    
                        
                       try{
                        String val=(DH.address(P));
                        System.out.println(val);
                       }
                       catch (NotFoundException ex)
                               {
                                   System.out.println("E");
                               }
                        
                         
                     }
                 }
                 
                 line=rd.readLine();
                
            if(line!=null)
            words=line.split(" ");
             }
        }
       catch (FileNotFoundException ex) {
            System.out.println("File Not Found!!!");
        } catch (IOException ex) {
            System.out.println("Invalid Line Encountered!!!");
        }

        
        // TODO code application logic here
    }
    
}
