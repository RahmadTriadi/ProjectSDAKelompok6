package strukturdata.antrian_bank.tool;
public class Antrian {
    int no_urut;//no urut antrian teller
    int status;//status antrian teller(biasa/vip)    
    int waktu;//lama pelayanan dalam menit
    int point=0;//untuk prioritas pengurutan
    
    public Antrian(int no, int status, int waktu) {
        this.no_urut=no;this.status=status;
        
        this.waktu=waktu;
        if(status==2){
            point=point+4+no;//biasa
        }else{
            point=point+8+no;//VIP
        }
        if(waktu>=10){
            point=point+13;
        }
        
    }
    public Antrian(){
        
    }

    public int getPoint() {
        return point;
    }
    
    public int getNo_urut() {
        return no_urut;
    }

    public void setNo_urut(int no_urut) {
        this.no_urut = no_urut;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        
        this.status = status;
    }

   
    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        if(waktu>60){
            waktu=60;
        }
        if(waktu<5){
            waktu=5;
        }
        if(status==1){//VIP
            waktu=5;
            System.out.println("dikerjakan waktu");
        }
        this.waktu = waktu;
    }
    
}
