package persistence;

import model.Tamagotchi;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Representing a reader that reads a Tamagotchi from JSON data stored in file
// Code taken from JsonReader found in JsonSerializationDemo and altered for
// correct Specification
public class JsonReader {
    private String source;

    // EFFECTS: constructs the reader that will be used to read from the source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads Tamagotchi from file and returns it;
    // throws IOException if an error occurs while attempting to read data from file
    public Tamagotchi read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return tamagotchiToJson(jsonObject);
    }

    //reads source file as a String and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: gets Tamagotchi object from JSON object and return it
    private Tamagotchi tamagotchiToJson(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Tamagotchi tr = new Tamagotchi(name);
        return tr;
    }

}



