
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ilker
 */
public class gir extends Thread {

   public static BlockingQueue<Integer> kuyrukgir= new ArrayBlockingQueue<>(500);
   // gir(){} 
    int gidilecekKat(){
    Random rand = new Random();
    int x= rand.nextInt(4)+1;
       
    return x;
    }
    int girenKisi(){
    Random rand = new Random();
    int x= rand.nextInt(10)+1;
  
    return x;
    }
    void KuyruğaEkle() throws InterruptedException{
        int x=girenKisi();
        int a=gidilecekKat();
        for(int i=0;i<x;i++){
        kuyrukgir.put(a);
        
        }
        
    
    }

    public void run()  
    {    while(true)
        try {   
        Thread.sleep(500);
            KuyruğaEkle(); 
            System.out.println("kuyruğa eklendi, Kuyruktaki kişi sayısı: "+kuyrukgir.size());
        } catch (InterruptedException e) {
            System.out.println ("Exception is caught");
        }
    }    

    }



