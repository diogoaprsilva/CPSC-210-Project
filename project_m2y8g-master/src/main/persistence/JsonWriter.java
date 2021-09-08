package persistence;

import model.Tamagotchi;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes JSON representation of Tamagotchi to file
// Code taken from JsonReader found in JsonSerializationDemo and altered for
// correct Specification
public class JsonWriter {
    private static final int TAB = 1;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens the newly created writer and throws FileNotFoundException
    // if destination file cannot be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: closes the writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of Tamagotchi to file
    public void write(Tamagotchi wr) {
        JSONObject json = wr.toJson();
        saveToFile(json.toString(TAB));

    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

}

