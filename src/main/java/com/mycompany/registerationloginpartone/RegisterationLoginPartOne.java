/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registerationloginpartone;
import java.util.Scanner;

/**
 * console-driven registration and login application.
 *  * 
 * @author Karabo Mkhize
 */

public class RegisterationLoginPartOne {
 // Scanner is declared here so it can be reused throughout the application
static Scanner input = new Scanner(System.in);

public static void main(String[] args) {
System.out.println("===== Registration =====");

System.out.print("Enter your first name: ");
String firstName = input.nextLine();

System.out.print("Enter your last name: ");
String lastName = input.nextLine();

Login login = new Login(firstName, lastName);

String username;
String password;
String cellPhoneNumber;
String registrationResult;

do {
System.out.print("Enter a username: ");
username = input.nextLine();

System.out.print("Enter a password: ");
password = input.nextLine();

System.out.print("Enter your South African cell phone number (e.g. +27838968976");
cellPhoneNumber = input.nextLine();

registrationResult = login.registerUser(username, password, cellPhoneNumber);
System.out.println(registrationResult);

} 
while (!registrationResult.startsWith("Username successfully captured"));

System.out.println("\n===== Login =====");

System.out.print("Enter your username: ");
String loginUsername = input.nextLine();

System.out.print("Enter your password: ");
String loginPassword = input.nextLine();

String name ="Karabo";
String surname = "Mkhize";

boolean loginSuccessful = login.loginUser(loginUsername, loginPassword);
System.out.println(login.returnLoginStatus(loginSuccessful));
input.close();
}  
}
    


    

    
       
