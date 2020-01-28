/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.reference;

/**
 *
 * @author junaidy
 */
public class Reference {
    public Reference(){
        
        
    }
    public static void main(String [] p){
        int [] a=new int[1];
        int [] b=new int [1];
        
        a[0]=5;
        System.out.println("Cetak data a[0] = "+a[0]);
        
        b=a;
        b[0]=2;
        System.out.println("Cetak data a[0] = "+a[0]);
    }
}
