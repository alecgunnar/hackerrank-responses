import java.util.ArrayList;
import java.util.List;

public class Playlist {
    public static int playlist(
            List<String> songs,
            int currentSong,
            String desiredSong
    ) {
        List<Integer> locations = findLocationsOfDesiredSong(songs, desiredSong);
        int shortest = Integer.MAX_VALUE;
        int numberOfSongs = songs.size();

        for (int locationOfMatchedSong : locations) {
            int closestDistance = calculateClosestDistance(
                    currentSong,
                    numberOfSongs,
                    locationOfMatchedSong
            );

            if (closestDistance < shortest)
                shortest = closestDistance;
        }

        return shortest;
    }

    private static int calculateClosestDistance(
            int currentSong,
            int numberOfSongs,
            int locationOfMatchedSong
    ) {
        int distanceGoingDown = Math.abs(locationOfMatchedSong - currentSong);
        int distanceGoingUp = numberOfSongs - distanceGoingDown;
        return distanceGoingDown < distanceGoingUp ? distanceGoingDown : distanceGoingUp;
    }

    private static List<Integer> findLocationsOfDesiredSong(
            List<String> songs,
            String desiredSong
    ) {
        List<Integer> locations = new ArrayList<>();
        int location = 0;

        for (String song : songs) {
            if (song.equals(desiredSong))
                locations.add(location);

            location++;
        }

        return locations;
    }
}
