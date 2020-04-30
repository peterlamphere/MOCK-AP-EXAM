public class Flight {
  Time depart, arrive;
  public Flight (Time depart, Time arrive) {
    this.depart = depart;
    this.arrive = arrive;
  }
  public Time getDepartureTime () {
    return depart;
  }

  public Time getArrivalTime () {
    return arrive;
  }
}