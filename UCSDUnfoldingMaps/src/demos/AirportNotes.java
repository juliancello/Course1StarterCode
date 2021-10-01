package demos;

public class AirportNotes {
    public static String findAirportCode(String toFind, Airport[] airports) {
        // for every airport in airports, compare toFind to airport.getCity(). If they are not the same, compare
        // the next airport in airports. If they are the same, return the airport.getCode()
        for (Airport ap: airports){
            if (ap.getCity().equals(toFind)){return ap.getCode3();}
        }
        return null;
    }

    public static String findAirportCodeBS(String toFind, Airport[] airports) {
        int low = 0;
        int high = airports.length;
        int mid;
        while (low <= high) {
            // mid = (low + high)/2; // possible integer overflow
            mid = low + ((high-low)/2);
            int compare = toFind.compareTo(airports[mid].getCity());
            if (compare < 0) {
                high = mid -1; // don't equate to mid because we already checked mid
            }
            else if (compare > 0) {
                low = mid + 1; // don't equate to mid because we already checked mid
            }
            else {return airports[mid].getCode3();}
        }
        return null;
    }
}
