import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaylistTest {
    private static List<String> songs = new ArrayList<>();

    static {
        songs.add("Focus ST");
        songs.add("Focus RS");
        songs.add("Fiesta ST");
        songs.add("Edge ST");
        songs.add("Explorer ST");
        songs.add("Mustang GT");
        songs.add("Focus RS");
        songs.add("GT");
        songs.add("Mustang GT350");
        songs.add("Edge ST");
        songs.add("Mustang GT500");
    }

    @Test
    public void can_find_neighboring_song() throws Exception {
        assertThat(
                Playlist.playlist(songs, 0, "Focus RS")
        ).isEqualTo(1);
    }

    @Test
    public void can_find_song_further_down_list() throws Exception {
        assertThat(
                Playlist.playlist(songs, 0, "Explorer ST")
        ).isEqualTo(4);
    }

    @Test
    public void can_find_neighboring_song_at_end_of_list() throws Exception {
        assertThat(
                Playlist.playlist(songs, 0, "Mustang GT500")
        ).isEqualTo(1);
    }

    @Test
    public void can_find_in_reverse_given_multiple() throws Exception {
        assertThat(
                Playlist.playlist(songs, 0, "GT")
        ).isEqualTo(4);
    }

    @Test
    public void can_find_song_further_down_list_given_multiple() throws Exception {
        assertThat(
                Playlist.playlist(songs, 0, "Edge ST")
        ).isEqualTo(2);
    }

    @Test
    public void at_the_bottom_can_find_at_top() throws Exception {
        assertThat(
                Playlist.playlist(songs, 10, "Focus ST")
        ).isEqualTo(1);
    }
}