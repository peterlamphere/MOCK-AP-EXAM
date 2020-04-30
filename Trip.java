import java.util.ArrayList;

public class Trip {
  private ArrayList<Flight> flights;

  
  public int getDuration () {
    Time firstDepartureTime = flights.get(0).getDepartureTime();
    Time lastArrivalTime = flights.get(flights.size()-1).getArrivalTime();
    return firstDepartureTime.minutesUntil(lastArrivalTime);
  }

  public int getShortestLayover () {
    if (flights.size() < 2) return -1;
    int shortestLayover = Integer.MAX_VALUE;
    for (int i=0; i < flights.size()-1; i++) {
       Time arrival = flights.get(i).getArrivalTime();
       Time nextDeparture = flights.get(i+1).getDepartureTime();
       int layover = arrival.minutesUntil(nextDeparture);

       System.out.println(i + ":\tarrival: " + arrival + "\tdeparture: " + nextDeparture + "\tlayover:" + layover );

       if (layover < shortestLayover)
          shortestLayover = layover;
    }
    return shortestLayover;
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