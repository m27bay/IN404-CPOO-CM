public class ReadDVD implements Play{
  private DVD dvd;
  private int read_time, time_start, time_end, time_now;

  public ReadDVD(DVD dvd) {
    this.dvd        = dvd;
    this.read_time  = -1;
    this.time_start = -1;
    this.time_end   = -1;
    this.time_now   = -1;
  }

  public void playDVD(int time_start) {
    if(read_time  ==  -1) {

      this.read_time  = 1;
      this.time_start = time_start;
      this.time_end   = time_start + this.dvd.get_duration();
      this.time_now   = time_start;
    }

    /*
    else if(this.time_now  <  this.time_end) {
      this.read_time = 1;
    }
    */
  }

  public void breakDVD() {
    this.read_time = 0;
  }

  public void stopDVD() {
    this.read_time  = -1;
    this.time_start = -1;
    this.time_end   = -1;
    this.time_now   = -1;
  }

  public void ejectDVD() {
    this.dvd        = null;
    this.read_time  = -1;
    this.time_start = -1;
    this.time_end   = -1;
    this.time_now   = -1;
  }
}
