public class Time {
  private int minutes;
  public Time (int minutes) {this.minutes = minutes;}
  public Time (int hours, int minutes) {
    this.minutes = hours * 60 + minutes;
  }
  public Time (int hours, int minutes, String ampm) {
    this.minutes = hours * 60 + minutes;
    if (ampm.toLowerCase().equals("pm")) {
        this.minutes += 12*60;
    } 
    
    if (hours == 12)
      this.minutes -= 12*60;
  }
  int minutesUntil (Time other) {
    return other.minutes - this.minutes;
  }
  int getMinutes() {return minutes%60;};
  int getHours() {
    return minutes/60;
  }
  public String toString() {
    return getHours() + ":" + getMinutes();
  }
}