package models;

import org.bson.types.ObjectId;
import java.util.Date;

public class Report {
    private ObjectId id;
    private ObjectId userId;   // Foreign key-like reference to User._id
    private String wasteType;
    private double quantity;
    private String location;
    private String status;
    private Date dateSubmitted;
    private String description;

    // Constructor to initialize a new report
    public Report(ObjectId userId, String wasteType, double quantity, String location, String description) {
        this.id = new ObjectId();          // Generate new ObjectId
        this.userId = userId;
        this.wasteType = wasteType;
        this.quantity = quantity;
        this.location = location;
        this.status = "Pending";           // Default status
        this.dateSubmitted = new Date();   // Current date
        this.description = description;
    }

    // Optional: Constructor with all fields explicitly
    public Report(ObjectId id, ObjectId userId, String wasteType, double quantity,
                  String location, String status, Date dateSubmitted, String description) {
        this.id = id;
        this.userId = userId;
        this.wasteType = wasteType;
        this.quantity = quantity;
        this.location = location;
        this.status = status;
        this.dateSubmitted = dateSubmitted;
        this.description = description;
    }

    // Getters and setters
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public ObjectId getUserId() { return userId; }
    public void setUserId(ObjectId userId) { this.userId = userId; }

    public String getWasteType() { return wasteType; }
    public void setWasteType(String wasteType) { this.wasteType = wasteType; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getDateSubmitted() { return dateSubmitted; }
    public void setDateSubmitted(Date dateSubmitted) { this.dateSubmitted = dateSubmitted; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
