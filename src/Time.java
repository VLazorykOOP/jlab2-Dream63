public class Time {
    private short hours;
    private short minutes;
    private short seconds;

    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    public Time(short hours, short minutes, short seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public Time(int seconds) {
        int totalMinutes = (int)(seconds / 60);
        int totalHours = (int)(totalMinutes / 60);
        this.hours = (short)(totalHours % 24);
        this.minutes = (short)(totalMinutes % 60);
        this.seconds = (short)(seconds % 60);
    }
    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }
    /** Format: "hh:mm:ss" */
    public Time(String timeString) {
        String[] timeArray = timeString.split(":");
        if(timeArray.length == 3) {
            this.hours = (short)(Integer.parseInt(timeArray[0])% 24);
            this.minutes = (short)(Integer.parseInt(timeArray[1]) % 60);
            this.seconds = (short)(Integer.parseInt(timeArray[2]) % 60);
        } 
        else System.err.println("Wrong string format");
    }

    public int ToSeconds(Time time) {
        return time.hours * 3600 + time.minutes * 60 + time.seconds;
    }
    public int ToMinutes(Time time) {
        return time.hours * 60 + time.minutes;
    }
    public Time ToTime(int seconds) {
        int totalMinutes = (seconds / 60);
        int totalHours = (totalMinutes / 60);
        short hoursR = (short)(totalHours % 24);
        short minutesR = (short)(totalMinutes % 60);
        short secondsR = (short)(seconds % 60);
        return new Time(hoursR, minutesR, secondsR);
    }
    public static Time DifferenceBetweenTimes(Time FirstEvent, Time SecondEvent) {
        Time Difference = new Time();
        Difference.seconds = (short)((SecondEvent.seconds + 60 - FirstEvent.seconds) % 60);
        if (Difference.seconds < 60) 
            FirstEvent.minutes--;

        Difference.minutes = (short)((SecondEvent.minutes + 60 - FirstEvent.minutes) % 60);
        if (Difference.minutes < 60) 
            FirstEvent.hours--;
        Difference.hours = (short)((SecondEvent.hours + 24 - FirstEvent.hours) % 24);

        return Difference;
    }
    public Time AddSecondsToTime(int seconds) {
        return ToTime(ToSeconds(this) + seconds);
    }
    public Time RemoveSecondsFromTime(int seconds) {
        return ToTime(ToSeconds(this) - seconds);
    }
    public String getString() {
        return hours + "h " + minutes + "m " + seconds +"s";
    }
}

class Test {
    public static void main(String[] args) {
        Time time1 = new Time((short)13, (short)5, (short)12), time2 = new Time(18233);
        System.out.println("Time1: " + time1.getString() + " Time2:" + time2.getString());     

        System.out.println("Addition: " + time1.AddSecondsToTime(10).getString());       
        
        Time time3 = Time.DifferenceBetweenTimes(time1, time2);
        System.out.println("Difference: "+ time3.getString());
    }
}
