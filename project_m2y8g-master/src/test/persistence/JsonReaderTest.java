package persistence;

import model.Tamagotchi;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noFile.json");
        try {
            Tamagotchi tr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderTamagotchi() {
        JsonReader reader = new JsonReader("./data/testEmpty.json");
        try {
            Tamagotchi tr = reader.read();
            assertEquals("Test", tr.getName());
        } catch (IOException e) {
            fail("Couldn't read the file");
        }
    }

}
