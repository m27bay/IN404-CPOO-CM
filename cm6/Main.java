import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
    System.out.println("Compile success\n");

    Document doc1 = new DVD("Saving Private Ryan",
      "Steven Spielberg", 1998, convert_duration(2, 50, 0));

    System.out.println(doc1.to_String());

    int[] time = convert_time();
    ReadDVD read1 = new ReadDVD((DVD)doc1);

    int sec_time = convert_duration(time[0], time[1], time[2]);
    System.out.print(sec_time + "sec  =  ");
    System.out.println(time[0] + "h" + time[1] + "min" + time[2] + "sec");

    read1.playDVD(sec_time);
  }









  public static int[] convert_time() {
    SimpleDateFormat format_hour, format_min, format_sec;
    Date today = new Date();

    // Take time of the computer
    format_hour = new SimpleDateFormat("hh");
    format_min = new SimpleDateFormat("mm");
    format_sec = new SimpleDateFormat("ss");

    int[] time = new int[3];

    // Convert format (string) to int
    time[0] = Integer.parseInt(format_hour.format(today));
    time[1] = Integer.parseInt(format_min.format(today));
    time[2] = Integer.parseInt(format_sec.format(today));

    return time;
  }

  public static int convert_duration(int hours, int minutes, int seconds) {
    int duration = 0;
    if(hours  !=  0)
      duration += hours*3600;
    if(minutes  !=  0)
      duration += minutes*60;
    if(seconds  !=  0)
      duration  +=  seconds;

    return duration;
  }
}
