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
public class Test {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        Parallel par = new Parallel();
        Thread t1 = new Thread(par);
        Thread t2 = new Thread(par);
        Thread t3 = new Thread(par);
        Thread t4 = new Thread(par);
        sw.start();
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            t4.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sw.stop();
        System.out.println("Parallel Method used ---" + sw.getTime() + "msec");

        Sequential s = new Sequential();
        s.run();
    }
}
