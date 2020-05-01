import java.util.ArrayList;

public class Trip {
  private ArrayList<Flight> flights;

// **** Answer to Question 1A ****

  public int getDuration () {
    
    // Check the size of the Arraylist
    if (flights.size() == 0) return 0; // 1pt

    // Make a time object to get departure of the first element of the array
    Time firstDepartureTime = flights.get(0).getDepartureTime();  // 1pt


    // Make a time object to get arrival of the last element of the array
    Time lastArrivalTime = flights.get(flights.size()-1) .getArrivalTime(); // 1pt

    // Find the time between the two Time objects
    return firstDepartureTime.minutesUntil(lastArrivalTime); // 1pt;
  }

// **** Answer to Question 1B ****

  public int getShortestLayover () {

    // Check the size of the ArrayList
    if (flights.size() < 2) return -1; // 1pt

    // Initialize the shortest layover to be as long as possible
    int shortestLayover = Integer.MAX_VALUE;

    // Loop to go through each flight in the Arraylist except the last
    for (int i=0; i < flights.size()-1; i++) {  // 1pt

       // Make a time object to get arrival of the current element of the array
       Time arrival = flights.get(i).getArrivalTime();

       // Make a time object to get departure of the next element of the array
       Time nextDeparture = flights.get(i+1).getDepartureTime(); 

       // Find the layover length
       int layover = arrival.minutesUntil(nextDeparture); // 1pt

       // print out as an error check
       System.out.println(i + ":\tarrival: " + arrival + "\tdeparture: " + nextDeparture + "\tlayover:" + layover );

        // Compare the layover to the shortest one
       if (layover < shortestLayover)  // 1/2 print
          // If its shorter, set the shortest to be equal to the current layover
          shortestLayover = layover; // 1 pt
    }
    return shortestLayover; // 1/2 pt
  }

  // Constructors
  public Trip (int[][] flightinfo) {
    flights = new ArrayList<Flight>();
    for (int[] flight : flightinfo) {
      if (flight.length != 2) { throw new IllegalArgumentException("Bad array size");}
      flights.add(new Flight(new Time(flight[0]), new Time(flight[1])));
    }
  }

  public Trip (Time[][] flightinfo) {
    flights = new ArrayList<Flight>();
    for (Time[] flight : flightinfo) {
      if (flight.length != 2) { throw new IllegalArgumentException("Bad array size");}
      flights.add(new Flight(flight[0],flight[1]));
    }
  }
}