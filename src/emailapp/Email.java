package emailapp;

import java.util.Map;
import java.util.Scanner;


public class Email {
    private Map<Integer, String> departments = Map.of(
            0, "",
            1, "sales",
            2, "development",
            3, "accounting"
    );
    private String firstName;
    private String lastName;
    private String password;
    private String dept;
    private String email;
    private int capacity = 777;
    private int passwordLength = 7;
    private String alternateEmail;
    private String companySuffix = "meta.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Call a method asking for the department
        this.dept = setDepartment();
        // Call a method to generate a random password
        this.password = setPassword(passwordLength);
        // Combine elements to generate email
        this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+((this.dept.isEmpty() || this.dept.isBlank()) ? this.companySuffix : this.dept+"."+this.companySuffix);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n");
        Scanner in = new Scanner(System.in);
        return departments.get(in.nextInt());
    }
    // Generate a random password
    private String setPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return String.copyValueOf(password);
    }
    // Set the mailbox capacity
    public void setMailboxSize(int capacity) {
        this.capacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxSize() {
        return this.capacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void getInfo() {
        System.out.println("Department: " + this.dept);
        System.out.println("Password: " + this.password);
        System.out.println("Email Address: " + this.email);
    }
}
