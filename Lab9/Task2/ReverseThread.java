/**********************************************
 *  Workshop 9
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-04-10>
 * **********************************************/
package Task2;

public class ReverseThread implements Runnable{
    private static int count = 0;

    public ReverseThread(){
        count++;
    }

    @Override
    public void run() {
        while(count < 51){
            System.out.println("Hello from thread " + Thread.currentThread().getName());
            Thread t = new Thread(new ReverseThread());
            t.start();
            t.setName(count + "");
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getCount() {
        return count;
    }
}
