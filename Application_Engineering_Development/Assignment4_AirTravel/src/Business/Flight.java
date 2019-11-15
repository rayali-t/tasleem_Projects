/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author shailly
 */
public class Flight implements Comparable<Flight> {

    private String FlightID;
    private String Flightname;
    private String Source;
    private String Destination;
    private String Departure;
    private String Arrival;
    private int Flightcharges;
    private String date;
    private int Halts;
    static private int totalseats = 150;
    private Airliner airliner;

    private String allocatedSeat;
    private int[] seatRowList = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private String[] seatWindowList = {"A", "F"};
    private String[] seatAisleList = {"C", "D"};
    private String[] seatMiddleList = {"B", "E"};

   public Flight() {
        airliner = new Airliner();
    }

    public String getFlightID() {
        return FlightID;
    }

    public void setFlightID(String FlightID) {
        this.FlightID = FlightID;
    }

    public String getFlightname() {
        return Flightname;
    }

    public void setFlightname(String Flightname) {
        this.Flightname = Flightname;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String Departure) {
        this.Departure = Departure;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String Arrival) {
        this.Arrival = Arrival;
    }

    public int getFlightcharges() {
        return Flightcharges;
    }

    public void setFlightcharges(int Flightcharges) {
        this.Flightcharges = Flightcharges;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHalts() {
        return Halts;
    }

    public void setHalts(int Halts) {
        this.Halts = Halts;
    }

    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(String airliner) {
        this.airliner.setAirLinerName(airliner);
    }

    public String getAllocatedSeat() {
        return allocatedSeat;
    }

    public void setAllocatedSeat(String allocatedSeat) {
        this.allocatedSeat = allocatedSeat;
    }

    public int[] getSeatRowList() {
        return seatRowList;
    }

    public void setSeatRowList(int[] seatRowList) {
        this.seatRowList = seatRowList;
    }

    public String[] getSeatWindowList() {
        return seatWindowList;
    }

    public void setSeatWindowList(String[] seatWindowList) {
        this.seatWindowList = seatWindowList;
    }

    public String[] getSeatAisleList() {
        return seatAisleList;
    }

    public void setSeatAisleList(String[] seatAisleList) {
        this.seatAisleList = seatAisleList;
    }

    public String[] getSeatMiddleList() {
        return seatMiddleList;
    }

    public void setSeatMiddleList(String[] seatMiddleList) {
        this.seatMiddleList = seatMiddleList;
    }

    @Override
    public String toString() {
        return this.airliner.getAirLinerName();
    }

    @Override
    public int compareTo(Flight o) {
        Integer price = this.Flightcharges;
        return price.compareTo(o.getFlightcharges());
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;

    }

}
