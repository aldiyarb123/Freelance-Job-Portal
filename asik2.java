import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Базовый класс User
class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}

// Класс Freelancer наследует User
class Freelancer extends User {
    private String skills;

    public Freelancer(int freelancerId, String name, String skills) {
        super(freelancerId, name);
        this.skills = skills;
    }

    public String getSkills() { return skills; }

    @Override
    public String toString() {
        return super.toString() + ", Skills: " + skills;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Freelancer that = (Freelancer) obj;
        return getUserId() == that.getUserId();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getUserId());
    }
}

// Класс JobListing
class JobListing {
    private int jobId;
    private String jobTitle;
    private String jobDescription;
    private double payment;

    public JobListing(int jobId, String jobTitle, String jobDescription, double payment) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.payment = payment;
    }

    public int getJobId() { return jobId; }
    public String getJobTitle() { return jobTitle; }
    public String getJobDescription() { return jobDescription; }
    public double getPayment() { return payment; }

    @Override
    public String toString() {
        return "Job ID: " + jobId + ", Title: " + jobTitle + ", Payment: $" + payment +
                "\nDescription: " + jobDescription;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JobListing that = (JobListing) obj;
        return jobId == that.jobId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(jobId);
    }
}

// Основной класс FreelanceJobPortal
public class asik2 {
    private ArrayList<JobListing> jobListings = new ArrayList<>();
    private ArrayList<Freelancer> freelancers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addJob() {
        System.out.println("\nEnter Job Details:");
        System.out.print("Job ID: ");
        int jobId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Job Title: ");
        String title = scanner.nextLine();
        System.out.print("Job Description: ");
        String description = scanner.nextLine();
        System.out.print("Payment: ");
        double payment = scanner.nextDouble();

        jobListings.add(new JobListing(jobId, title, description, payment));
        System.out.println("Job added successfully!\n");
    }

    public void addFreelancer() {
        System.out.println("\nEnter Freelancer Details:");
        System.out.print("Freelancer ID: ");
        int freelancerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Skills: ");
        String skills = scanner.nextLine();

        freelancers.add(new Freelancer(freelancerId, name, skills));
        System.out.println("Freelancer added successfully!\n");
    }

    public void showJobs() {
        System.out.println("\nAvailable Jobs:");
        for (JobListing job : jobListings) {
            System.out.println(job);
        }
    }

    public void showFreelancers() {
        System.out.println("\nFreelancers:");
        for (Freelancer freelancer : freelancers) {
            System.out.println(freelancer);
        }
    }

    // Фильтрация вакансий по минимальной оплате
    public void filterJobsByPayment(double minPayment) {
        System.out.println("\nJobs with payment above $" + minPayment + ":");
        for (JobListing job : jobListings) {
            if (job.getPayment() >= minPayment) {
                System.out.println(job);
            }
        }
    }

    // Сортировка фрилансеров по имени
    public void sortFreelancersByName() {
        freelancers.sort(Comparator.comparing(User::getName));
        System.out.println("\nFreelancers sorted by name:");
        showFreelancers();
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Freelance Job Portal ---");
            System.out.println("1. Add Job");
            System.out.println("2. Add Freelancer");
            System.out.println("3. Show All Jobs");
            System.out.println("4. Show All Freelancers");
            System.out.println("5. Filter Jobs by Payment");
            System.out.println("6. Sort Freelancers by Name");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addJob();
                case 2 -> addFreelancer();
                case 3 -> showJobs();
                case 4 -> showFreelancers();
                case 5 -> {
                    System.out.print("Enter minimum payment: ");
                    double minPayment = scanner.nextDouble();
                    filterJobsByPayment(minPayment);
                }
                case 6 -> sortFreelancersByName();
                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        asik2 portal = new asik2();
        portal.menu();
    }
}