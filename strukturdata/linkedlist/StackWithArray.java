/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.linkedlist;

/**
 *
 * @author jun
 */
public class StackWithArray {
    int data[];
    int banyakData;
    public StackWithArray(){
        data=new int[7];
        this.banyakData=0;
    }
    public void insertStackArray(int angka){
        if(this.banyakData+1>data.length){
            System.out.println("Maaf data sudah penuh");
        }else{
            this.banyakData++;
            data[this.banyakData-1]=angka;
        }
    }
    
    public void tampilData(){
        for(int i=banyakData-1;i>=0;i--){
            System.out.println(data[i]);
        }
    }
    public static void main(String arg[]){
        StackWithArray a=new StackWithArray();
        a.insertStackArray(32);
        a.insertStackArray(2);
        a.insertStackArray(3);
        a.insertStackArray(22);
        a.insertStackArray(34);
        a.tampilData();
    }
    
}
