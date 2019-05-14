import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import static java.util.Comparator.*;

public class SearchAlgorythms {

    static Logger logger = Logger.getLogger(SearchAlgorythms.class.getName());


    public int linearSearch(JSONObject json, String cityToSearch){
        int airportIndex = -1;
        ArrayList<Airport> airportsArrayList = Utilities.createAirportEntities(json);
        for (Airport currentAirport : airportsArrayList) {
            if (currentAirport.getCity().equalsIgnoreCase(cityToSearch)) {
                airportIndex = airportsArrayList.indexOf(currentAirport);
                break;
            }

        }
        System.out.println(airportsArrayList.get(airportIndex));
        return airportIndex;
    }

    public int binarySearch(JSONObject json, String cityToSearch){
        ArrayList<Airport> airportsArrayList = Utilities.createAirportEntities(json);
        airportsArrayList.sort(comparing(Airport::getCity));
        int low = 0;
        int high = airportsArrayList.size() - 1;
        int mid = (low + high) / 2;
        int airportIndex = -1;
        while (low <= high) {
            if (airportsArrayList.get(mid).getCity().compareToIgnoreCase(cityToSearch) < 0) {
                low = mid + 1;
            } else if (airportsArrayList.get(mid).getCity().compareToIgnoreCase(cityToSearch) == 0) {
                airportIndex = mid;
                break;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        System.out.println(airportsArrayList.get(airportIndex));
        return airportIndex;
    }



    public static int[] doSelectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {

            int index = i;

            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index])
                    index = j;
            }

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;

        }

        return arr;

    }

    public static int[] doInsertionSort(int[] arr){
        int currInd;
        for (int pos = 1; pos < arr.length; pos++){
            while (currInd > 0 &&
                    arr[currInd] < arr[currInd - 1]){
                int smallerNumber = arr[currInd];
                arr[currInd] = arr[currInd - 1];
                arr[currInd - 1] = smallerNumber;
                currInd = currInd - 1;
            }
        }
        return arr;
    }

    public static void main(String args[]){
        System.out.println("Retrieving data...\n");
        JSONObject json = new JSONObject();
        try {
            json = Utilities.readJsonFromUrl("https://raw.githubusercontent.com/mwgg/Airports/master/airports.json");
        } catch (Exception e) {
            logger.warning("Error retrieving data: " + e);
            json.append("Exception", e);
        }

        if (!json.has("Exception")){
            // Linear Search
            SearchAlgorythms sa = new SearchAlgorythms();
            System.out.println("***Linear Search");
            System.out.println(sa.linearSearch(json, "Amsterdam"));
            // Binary Search
            System.out.println("\n***Binary Search");
            System.out.println(sa.binarySearch(json, "Amsterdam"));
        } else {
            System.out.println("Could not retrieve JSON data, skipping Search Algorythms");
        }

        // Selection Sort
        System.out.println("\n*** Selection Sort");
        int[] unsortedArraySelectionSort = {10,34,2,56,7,67,88,42};
        System.out.println("\nUnsorted Array\n" + Arrays.toString(unsortedArraySelectionSort));
        int[] sortedArraySelectionSort = doSelectionSort(unsortedArraySelectionSort);
        System.out.println("\nSorted Array\n" + Arrays.toString(sortedArraySelectionSort));

        // Insertion Sort
        System.out.println("\n*** Insertion Sort");
        int[] unsortedArrayInsertionSort = {10,34,2,56,7,67,88,42};
        System.out.println("\nUnsorted Array\n" + Arrays.toString(unsortedArrayInsertionSort));
        int[] sortedArrayInsertionSort = doInsertionSort(unsortedArrayInsertionSort);
        System.out.println("\nSorted Array\n" + Arrays.toString(sortedArrayInsertionSort));


    }

}
