// MOCK AP Exam Answers
/* Question 1: 
https://kyap2020.com/wp-content/uploads/2020/04/AP-CSA-FRQ1.pdf

Both answers in the Trip.java file

Question 2: https://kyap2020.com/wp-content/uploads/2020/04/AP-CSA-FRQ2.pdf

Answer below in the isSelfDivisor method
*/

class Main {
  public static void main(String[] args) {
    
    // Client test code to print the numbers less than 200
    // that are self divisors
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

  // **** Question 2 solution ****

  public static boolean isSelfDivisor (int number) {
    // Create a holding variable to store the number
    int current_number = number;

    // Check to make sure the current number is bigger than zero
    // This make sure we go through all the digits
    while (current_number > 0) { // 1pt

      // Get the last digit by taking the modulo of ten e.g. 128 % 10 = 8
      int lastDigit = current_number % 10;  // 1 pt

      // If the digit is zero, or the original number is not divisible by the digit
      // we're done and return false 
      if (lastDigit == 0 || (number % lastDigit != 0)) { // 1pt
        return false;
      }

      // Truncate the number by eliminating the last digit: e.g. 128 /10 = 12
      // Once we get to a single digit number then it becomes zero: e.g. 1/10 = 0
      // Faster notation: current_number /= 10;
      current_number = current_number / 10; // 1pt
    }
    
    // If we have made it through the whole loop without returning, then we 
    // know it must be a self-divisor
    return true; // 1pt
  }

}