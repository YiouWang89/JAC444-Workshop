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

public class Test {
    public static void main(String[] args) {
        ReverseThread rt = new ReverseThread();
        Thread t = new Thread(rt);
        t.setName(rt.getCount()+"");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
