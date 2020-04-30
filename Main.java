class Main {
  public static void main(String[] args) {
    
    for (int i = 0; i < 200; i++) 
      System.out.println("Is "+ i + " a self divisor?" + isSelfDivisor(i));
      
    Time [][] flights = {
        {new Time(11,30,"AM"), new Time (12,15,"PM")},
        {new Time(1,15,"PM"), new Time (3,45,"PM")},
        {new Time(4,00,"PM"), new Time (6,45,"PM")},
        {new Time(10,15,"PM"), new Time (11,00,"PM")},
    };

    Trip mytrip = new Trip (flights);
    System.out.println ("Duration of my trip: " + mytrip.getDuration());
    System.out.println ("Shortest Layover " + mytrip.getShortestLayover() + " minutes");

  }

  public static boolean isSelfDivisor (int number) {
    int current_number = number;
    while (current_number > 0) { 
      int lastDigit = current_number % 10;
      if (lastDigit == 0 || (number % lastDigit != 0)) {
        return false;
      }
      // Faster: current_number /= 10;
      current_number = current_number / 10;
    }
    return true;
  }
/*

  */
}