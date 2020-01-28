/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.linkedlist;

/**
 *
 * @author jun
 */
public class Queue {
    public Queue(){
        LatihanList.insertKeretaAkhir(45);
        LatihanList.insertKeretaAkhir(5);
        LatihanList.insertKeretaAkhir(60);
        LatihanList.insertKeretaAkhir(1);
        LatihanList.insertKeretaAkhir(35);
        LatihanList.insertKeretaAkhir(56);
        LatihanList.cetakKereta();
        LatihanList.deleteKeretaAwal();
        LatihanList.cetakKereta();
    }
    public static void main(String er[]){
        Queue q=new Queue();
    }
}
