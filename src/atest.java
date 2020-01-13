/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author piyus
 */
public class atest {
    public static void main (String argv[])
    {
        Aclass avar=new Bclass();
        avar.a();
        avar.b();
    }
}
class Aclass
{
    int x=10;
    void a()
    {
        System.out.println("A1"+x);
        
    }
    void b()
    {
        System.out.println("A2"+x);
        a();
    }
}
class Bclass extends Aclass
{
    int x=33;
    void a()
    {
        System.out.println("A3"+x);
    }
}