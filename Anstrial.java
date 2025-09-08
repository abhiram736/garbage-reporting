import java.util.*;

// ACCOUNT CLASS
class Account {
    String accountId;
    String name;
    int phoneNumber;
    String email;
    String address;
    Date dateCreated;

    public void register() {
        System.out.println("Account registered: " + name);
    }

    public void updateDetails(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getAccountInfo() {
        return "ID: " + accountId + ", Name: " + name + ", Email: " + email;
    }
}

// USER CLASS
class User extends Account {
    String userId;
    String password;
    List<Report> wasteEntries = new ArrayList<>();

    public boolean login(String userId, String password) {
        return this.userId.equals(userId) && this.password.equals(password);
    }

    public void logout() {
        System.out.println("User logged out: " + userId);
    }

    public List<Report> viewReports() {
        return wasteEntries;
    }

    public Report submitReport(Report report) {
        wasteEntries.add(report);
        System.out.println("Report submitted by user: " + userId);
        return report;
    }
}

// ADMIN CLASS
class Admin extends Account {
    String adminId;
    String password;
    List<Report> managedReports = new ArrayList<>();

    public boolean login(String adminId, String password) {
        return this.adminId.equals(adminId) && this.password.equals(password);
    }

    public void logout() {
        System.out.println("Admin logged out: " + adminId);
    }

    public List<Report> viewAllReports() {
        return managedReports;
    }

    public void approveReport(Report report) {
        report.status = "Approved";
        System.out.println("Report approved: " + report.reportId);
    }

    public void deleteReport(Report report) {
        managedReports.remove(report);
        System.out.println("Report deleted: " + report.reportId);
    }
}

// REPORT CLASS
class Report {
    String reportId;
    String userId;
    WasteType wasteType;
    int quantity;
    String location;
    String status;
    Date dateSubmitted;

    public void createReport(String reportId, String userId, WasteType type, int quantity, String location) {
        this.reportId = reportId;
        this.userId = userId;
        this.wasteType = type;
        this.quantity = quantity;
        this.location = location;
        this.status = "Pending";
        this.dateSubmitted = new Date();
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getReportDetails() {
        return "ReportID: " + reportId + ", User: " + userId + ", Waste: " + wasteType.typeName +
                ", Quantity: " + quantity + ", Location: " + location + ", Status: " + status;
    }
}

// WASTETYPE CLASS
class WasteType {
    int typeId;
    String typeName;
    String description;

    public void updateWasteType(String typeName, String description) {
        this.typeName = typeName;
        this.description = description;
    }

    public void addWasteType(int typeId, String typeName, String description) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.description = description;
    }

    public String getWasteTypeInfo() {
        return "WasteType ID: " + typeId + ", Name: " + typeName + ", Desc: " + description;
    }
}

// MAIN CLASS (Test System)
public class WasteManagementSystem {
    public static void main(String[] args) {
        // Example usage
        WasteType plastic = new WasteType();
        plastic.addWasteType(1, "Plastic", "Plastic waste materials");

        User user = new User();
        user.userId = "u101";
        user.password = "pass123";
        user.name = "John Doe";
        user.accountId = "A101";

        Report report = new Report();
        report.createReport("R001", user.userId, plastic, 5, "Downtown");

        user.submitReport(report);

        Admin admin = new Admin();
        admin.adminId = "admin01";
        admin.password = "adminpass";
        admin.managedReports.add(report);

        admin.approveReport(report);

        System.out.println(report.getReportDetails());
    }
}
