package persistence;

import model.Tamagotchi;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {

    @Test
    void testWriterWithInvalidFile() {
        try {
            Tamagotchi tr = new Tamagotchi("Test");
            JsonWriter writer = new JsonWriter("/data/\0illegalFile.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
        }
    }

    @Test
    void testWritereGeneralTamagotchi() {
        try {
            Tamagotchi tr = new Tamagotchi("testing123");
            JsonWriter writer = new JsonWriter("./data/testEmptyTamagotchi.json");
            writer.open();
            writer.write(tr);
            writer.close();
            JsonReader reader = new JsonReader("./data/testEmptyTamagotchi.json");
            tr = reader.read();
            assertEquals("testing123", tr.getName());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}


