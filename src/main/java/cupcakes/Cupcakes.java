package cupcakes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cupcakes {
    public static List<Integer> maximumCupcakes(List<String> inputData) {
        TripBuilder tripBuilder = new TripBuilder();
        List<Trip> trips = new ArrayList<>();

        int numberOfTrips = inputData.size();

        for (int tripNumber = 0; tripNumber < numberOfTrips; tripNumber++) {
            trips.add(
                    tripBuilder.buildTrip(inputData.get(tripNumber))
            );
        }

        return trips.stream()
                .map(Trip::determineMaxCupcakes)
                .collect(Collectors.toList());
    }

    public static class TripBuilder {
        public Trip buildTrip(String values) {
            List<Integer> extractedValues = extractValues(values);

            return new Trip(
                    extractedValues.get(0),
                    extractedValues.get(1),
                    extractedValues.get(2)
            );
        }

        private static List<Integer> extractValues(String values) {
            return Arrays.stream(values.split(" "))
                    .map((String value) -> Integer.parseInt(value))
                    .collect(Collectors.toList());
        }
    }

    public static class Trip {
        private int budget;

        private int unitsPerCupcake;

        private int wrappersPerCupcake;

        public Trip(
                int budget,
                int unitsPerCupcake,
                int wrappersPerCupcake
        ) {
            this.budget = budget;
            this.unitsPerCupcake = unitsPerCupcake;
            this.wrappersPerCupcake = wrappersPerCupcake;
        }

        public int determineMaxCupcakes() {
            int count = budget / unitsPerCupcake;
            int wrappers = count;

            while (wrappers >= wrappersPerCupcake) {
                int additionalCupCakes = wrappers / wrappersPerCupcake;
                count += additionalCupCakes;
                wrappers -= additionalCupCakes * wrappersPerCupcake;
                wrappers += additionalCupCakes;
            }

            return count;
        }
    }
}
