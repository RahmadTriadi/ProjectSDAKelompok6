/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package strukturdata.antrian_bank.tool;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.GraphicsEnvironment;
/**
 *
 * @author junaidy
 */
public class CenterLocation {
    
    JDialog dialog;
    JFrame frame;
    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    
    public CenterLocation(javax.swing.JDialog Dialog){
        dialog=Dialog;
        dialog.setLocation(center.x-dialog.getWidth()/2,center.y-dialog.getHeight()/2);
    }
    public CenterLocation(javax.swing.JFrame Frame){
        frame=Frame;
        frame.setBounds(center.x-400,center.y-300,800,600);
    }
    
    public JDialog getCenterLocationDialog(){
        return dialog;
    }
    public JFrame getCenterLocationFrame(){
        return frame;
    }
}
