import java.util.ArrayList;
import java.util.Scanner;

//class dlya opisaniya raboti
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
}

// class dlya opisaniya 
class Freelancer {
    private int freelancerId;
    private String name;
    private String skills;

    public Freelancer(int freelancerId, String name, String skills) {
        this.freelancerId = freelancerId;
        this.name = name;
        this.skills = skills;
    }

    public int getFreelancerId() { return freelancerId; }
    public String getName() { return name; }
    public String getSkills() { return skills; }

    @Override
    public String toString() {
        return "Freelancer ID: " + freelancerId + ", Name: " + name + ", Skills: " + skills;
    }
}

// main class dlya upravleniya
public class FreelanceJobPortal {
    private ArrayList<JobListing> jobListings = new ArrayList<>();
    private ArrayList<Freelancer> freelancers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // add new vakansiya 
    public void addJob() {
        System.out.println("\nEnter Job Details:");
        System.out.print("Job ID: ");
        int jobId = scanner.nextInt();
        scanner.nextLine(); // Очистка 
        System.out.print("Job Title: ");
        String title = scanner.nextLine();
        System.out.print("Job Description: ");
        String description = scanner.nextLine();
        System.out.print("Payment: ");
        double payment = scanner.nextDouble();

        jobListings.add(new JobListing(jobId, title, description, payment));
        System.out.println("Job added successfully!\n");
    }

    // add new frilancer
    public void addFreelancer() {
        System.out.println("\nEnter Freelancer Details:");
        System.out.print("Freelancer ID: ");
        int freelancerId = scanner.nextInt();
        scanner.nextLine(); // Очистка
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Skills: ");
        String skills = scanner.nextLine();

        freelancers.add(new Freelancer(freelancerId, name, skills));
        System.out.println("Freelancer added successfully!\n");
    }

    // show all vakansii
    public void showJobs() {
        System.out.println("\nAvailable Jobs:");
        for (JobListing job : jobListings) {
            System.out.println(job);
        }
    }

    // show all frilanceserov
    public void showFreelancers() {
        System.out.println("\nFreelancers:");
        for (Freelancer freelancer : freelancers) {
            System.out.println(freelancer);
        }
    }

    // menu
    public void menu() {
        while (true) {
            System.out.println("\n--- Freelance Job Portal ---");
            System.out.println("1. Add Job");
            System.out.println("2. Add Freelancer");
            System.out.println("3. Show All Jobs");
            System.out.println("4. Show All Freelancers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addJob();
                case 2 -> addFreelancer();
                case 3 -> showJobs();
                case 4 -> showFreelancers();
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    
    public static void main(String[] args) {
        FreelanceJobPortal portal = new FreelanceJobPortal();
        portal.menu();
    }
}