/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.antrian_bank.tool;

/**
 *
 * @author kantor-linux
 */
public class GenerateAntrian {
    Antrian antrian;
    public GenerateAntrian(int no_urut, String status, int waktunya){
        int sta=1;
        if(status.equalsIgnoreCase("Biasa")){
            sta=1;
        }else{
            sta=2;
        }
        antrian=new Antrian(no_urut, sta, waktunya);
    }

    public Antrian getAntrian() {
        return antrian;
    }

    public void setAntrian(Antrian antrian) {
        this.antrian = antrian;
    }
    
}
