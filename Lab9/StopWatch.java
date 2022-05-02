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

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long start(){
        return startTime = System.currentTimeMillis();
    }

    public long stop(){
        return endTime = System.currentTimeMillis();
    }

    public long getTime(){
        return endTime - startTime;
    }
}
