/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.linkedlist;

/**
 *
 * @author jun
 */
public class Stack {
    public Stack(){
        LatihanList.insertKeretaAwal(20);
        LatihanList.insertKeretaAwal(40);
        LatihanList.insertKeretaAwal(50);
        LatihanList.cetakKereta();
        LatihanList.deleteKeretaAwal();
        LatihanList.cetakKereta();
        System.out.println(LatihanList.kereta.data);
    }
    public static void main (String arg[]){
        Stack stack=new Stack();
    }
}
