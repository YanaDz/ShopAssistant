package pl.dziadkouskaya.graphql.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvLoader {
    private static Dotenv dotenv = Dotenv.configure().load();

    public static String getEnv(String key) {
        return dotenv.get(key);
    }
}
