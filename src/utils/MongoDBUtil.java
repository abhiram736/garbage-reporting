package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
    private static final String CONNECTION_STRING = "mongodb+srv://grbrpt123:grbrpt019283@cluster0.6btqe57.mongodb.net/?retryWrites=true&w=majority";
    private static final String DB_NAME = "GarbageDB";
    private static MongoClient mongoClient = null;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase(DB_NAME);
    }
}
