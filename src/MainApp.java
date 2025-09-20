

import com.garbage.model.User;
import com.garbage.model.Report;
import com.garbage.util.MongoDBUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MainApp {
    public static void main(String[] args) {
        // Connect to DB
        MongoDatabase db = MongoDBUtil.getDatabase();
        MongoCollection<Document> usersCollection = db.getCollection("Users");
        MongoCollection<Document> reportsCollection = db.getCollection("Reports");

        // Create a sample User
        User user = new User("Alice", "9876543210", "alice@example.com", "hashed_password");
        Document userDoc = new Document("_id", user.getId())
                .append("name", user.getName())
                .append("phoneNumber", user.getPhoneNumber())
                .append("email", user.getEmail())
                .append("passwordHash", user.getPasswordHash())
                .append("dateRegistered", user.getDateRegistered());
        usersCollection.insertOne(userDoc);
        System.out.println("Inserted User: " + user.getName());

        // Create a Report linked to the User
        Report report = new Report(user.getId(), "Plastic", 5.5, "Central Park", "Plastic bottles near the lake");
        Document reportDoc = new Document("_id", report.getId())
                .append("userId", report.getUserId())
                .append("wasteType", report.getWasteType())
                .append("quantity", report.getQuantity())
                .append("location", report.getLocation())
                .append("status", report.getStatus())
                .append("dateSubmitted", report.getDateSubmitted())
                .append("description", report.getDescription());
        reportsCollection.insertOne(reportDoc);
        System.out.println("Inserted Report at: " + report.getLocation());
    }
}