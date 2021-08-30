
import static java.lang.Thread.sleep;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ilker
 */
public class ElevatorMain {
    private static gir gir;
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Asansör1 asThread = new Asansör1();
        Asansör2 as2Thread = new Asansör2();
        Asansör3 as3Thread = new Asansör3();
        Asansör4 as4Thread = new Asansör4();
        Asansör5 as5Thread = new Asansör5();
        gir girThread = new gir();
        çık cıkThread = new çık();
        kontrol kontThread = new kontrol();
          // Integer value = (Integer) queue.take();
        kontThread.start();
        girThread.start();
        cıkThread.start();
        asThread.start();
        as2Thread.start();
        as3Thread.start();
        as4Thread.start();
        as5Thread.start();
          /* while(true){
            Thread.sleep(200);
            
           }*/
      //  cıkThread.run();
      //  asThread.start();
          
       // Thread.sleep(500);
       
    }

   


   
}
