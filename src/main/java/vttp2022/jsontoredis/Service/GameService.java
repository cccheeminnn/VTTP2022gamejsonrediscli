package vttp2022.jsontoredis.Service;

import java.io.FileInputStream;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;

@Service
public class GameService {
    
    public JsonArray loadGames(FileInputStream fis) {
        JsonReader reader = Json.createReader(fis);
        JsonArray jsonArray = reader.readArray();
        return jsonArray;
    }
}
