
import java.util.logging.Level;
import java.util.logging.Logger;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ilker
 */
public class kontrol extends Thread{
  
 public static void kontrolet() throws InterruptedException{
     if(gir.kuyrukgir.size()>20 || çık.Kat1.size()>20 || çık.Kat2.size()>20 || çık.Kat3.size()>20 || çık.Kat4.size()>20 || Asansör2.kuyrukas2.size()>0){
        Asansör2.setKontrol(1);
     }else
         Asansör2.setKontrol(0);
                 Thread.sleep(200);
     if(gir.kuyrukgir.size()>20 || çık.Kat1.size()>20 || çık.Kat2.size()>20 || çık.Kat3.size()>20 || çık.Kat4.size()>20 || Asansör3.kuyrukas3.size()>0){
        Asansör3.setKontrol(1);
     }else
         Asansör3.setKontrol(0);
     if(gir.kuyrukgir.size()>20 || çık.Kat1.size()>20 || çık.Kat2.size()>20 || çık.Kat3.size()>20 || çık.Kat4.size()>20 || Asansör4.kuyrukas4.size()>0){
        Asansör4.setKontrol(1);
     }else
         Asansör4.setKontrol(0);
     if(gir.kuyrukgir.size()>20 || çık.Kat1.size()>20 || çık.Kat2.size()>20 || çık.Kat3.size()>20 || çık.Kat4.size()>20 || Asansör5.kuyrukas5.size()>0){
        Asansör5.setKontrol(1);
     }else
         Asansör5.setKontrol(0);
   //  Thread.sleep(200);

}
 public void run() {
        while(true){
            try {kontrolet();
                Thread.sleep(200);
               
             
            
            } catch (InterruptedException e) {
                System.out.println ("Exception is caught");
            }
        }
         
    
    }
}


