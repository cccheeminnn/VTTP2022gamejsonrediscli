package vttp2022.jsontoredis;

import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import vttp2022.jsontoredis.Repo.GameRepository;
import vttp2022.jsontoredis.Service.GameService;

@SpringBootApplication
public class JsontoredisApplication implements CommandLineRunner{

	@Autowired
	private GameService gameSvc;

	@Autowired
	private GameRepository gameRepo;
	public static void main(String[] args) {
		SpringApplication.run(JsontoredisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//take in jsonobject file using FileInputStream
		//if no parameter argument inputted
		if (args.length <= 0) {
			System.out.println("Please pass in a JSON object to parse");
			System.exit(-1);
		}

		FileInputStream fis = new FileInputStream(args[0]);
		JsonArray jsonArray = gameSvc.loadGames(fis);

		//iterate through jsonarray and save each object
		jsonArray.stream()
					.map(v -> (JsonObject) v)
					.forEach((JsonObject v) -> {
						gameRepo.saveGames(v);}
					);


		
	}

}
