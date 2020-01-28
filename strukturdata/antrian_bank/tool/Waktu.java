/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.antrian_bank.tool;

import javax.swing.JLabel;

/**
 *
 * @author jun
 */
public class Waktu implements Runnable{
    StopWatchku stop;
    Thread tt;
    JLabel labelWaktu;
    public static boolean kendali=true;
    public Waktu(StopWatchku stopWatch, JLabel labelWaktu){        
        this.stop=stopWatch;
        tt=new Thread(this);
        tt.start();   
        this.labelWaktu=labelWaktu;
    }
    
    public void destroy(){
        tt.stop();
        stop.getTimer().stop();        
    }
    public void paused(){
        kendali=false;
    }
    public void resume(){
        
        kendali=true;
    }
    @Override
    public void run() {
        while(kendali){
            try { 
                labelWaktu.setText(""+stop.getJam()+":"+stop.getMenit()+":"+stop.getDetik());                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
