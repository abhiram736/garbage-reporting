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
