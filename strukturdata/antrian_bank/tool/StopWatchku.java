/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.antrian_bank.tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**
 *
 * @author junaidy
 */
public class StopWatchku {
    Timer timer;
    int jam=0;
    int menit=0;
    int detik=0;
    Waktuku waktuku;
    public StopWatchku(Waktuku waktuku){
        this.waktuku=waktuku;
        this.jam=waktuku.getJam();
        this.menit=waktuku.getMenit();
        this.detik=waktuku.getDetik();
        ActionListener aksi=new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                //waktuku.getDetik()+=1;
                detik+=1;
                if(detik>59){
                    detik=0;
                    menit+=1;
                    if(menit>59){
                        jam+=1;
                        menit=0;
                    }
                    
                }
                //System.out.println("timer : "+jam+" "+menit+" "+detik);
            }
        };
        this.timer=new Timer(1000, aksi);
        this.timer.start();
    }

    public Waktuku getWaktuku() {
        waktuku.setJam(this.jam);
        waktuku.setMenit(this.menit);
        waktuku.setDetik(this.detik);
        return waktuku;
    }

    public int getDetik() {
        return detik;
    }

    public void setDetik(int detik) {
        this.detik = detik;
    }

    public int getJam() {
        return jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public int getMenit() {
        return menit;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
   public static void main(String[] args){
       new StopWatchku(new Waktuku(0, 0, 0));
   }
    
}
