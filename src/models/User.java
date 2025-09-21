package models;

import org.bson.types.ObjectId;
import utils.UserIdGenerator;

import java.util.Date;

public class User {
    private ObjectId id;
    private String userID;
    private String name;
    private String phoneNumber;
    private String email;
    private String passwordHash;
    private Date dateRegistered;

    // Constructor to initialize all fields
    //this constructor should be used  while creating a newUser
    public User(String name, String phoneNumber, String email, String passwordHash) {
        this.id = new ObjectId();           // Generate a new ObjectId
        this.userID = UserIdGenerator.generateUserId();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.dateRegistered = new Date();   // Set current date
    }

    // Optional: Constructor with custom ObjectId and date
    public User(ObjectId id, String name, String phoneNumber, String email, String passwordHash, Date dateRegistered) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.dateRegistered = dateRegistered;
    }

    // Getters and setters
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Date getDateRegistered() { return dateRegistered; }
    public void setDateRegistered(Date dateRegistered) { this.dateRegistered = dateRegistered; }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }
}
