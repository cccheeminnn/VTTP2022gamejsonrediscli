package vttp2022.jsontoredis.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonObject;

@Repository
public class GameRepository {

    @Autowired
    @Qualifier("beans")
    private RedisTemplate<String, String> redisTemplate;

    public void saveGames(JsonObject obj) {
        Integer gid = obj.getInt("gid");

        redisTemplate.opsForHash().put(gid.toString(), "boardgame", obj.toString());

    }
}
