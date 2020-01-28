/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata;

import javax.swing.JOptionPane;

/**
 *
 * @author junaidy
 */
public class StrukturData {
    public StrukturData(){
        Simpedes[] sim=new Simpedes[3];
        for(int i=0;i<3;i++){
            sim[i]=new Simpedes();
            sim[i].setNamaPenabung(JOptionPane.showInputDialog("Masukkan nama penabung ke "+ i));
            sim[i].setTabungan(Double.parseDouble(JOptionPane.showInputDialog("Jumlah tabungan penabung ke "+ i)));
            sim[i].addBunga(2);
            sim[i].potongAdministrasi(3);
            
        }
        for(int i=0;i<3;i++){            
            System.out.println("Nama penabung: "+sim[i].getNamaPenabung()                    
                    +" dengan jumlah tabungan : "+sim[i].getTabungan());
            
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StrukturData s=new StrukturData();
        
    }
}
