/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerationloginpartone;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Student
 */
public class Login {
   private String username;
private String password;
private String cellPhoneNumber;
private String firstName;
private String lastName;
public Login(String firstName, String lastName) {
this.firstName = firstName;
this.lastName = lastName;
}
//Checks that the username contains an underscore and is no more than
//five characters long
public boolean checkUserName(String username) {
return username != null && username.contains("_") && username.length() <= 5;
}
//Checks that the password meets the complexity rules:
//at least eight characters long, a capital letter, a number,
//and a special character
public boolean checkPasswordComplexity(String password) {
if (password == null || password.length() < 8) {
return false;
}
boolean hasCapital = false;
boolean hasNumber = false;
boolean hasSpecial = false;
for (char c : password.toCharArray()) {
if (Character.isUpperCase(c)) {
hasCapital = true;
} else if (Character.isDigit(c)) {
hasNumber = true;
} else if (!Character.isLetterOrDigit(c)) {
hasSpecial = true;
}
}
return hasCapital && hasNumber && hasSpecial;
}
//Checks that the cell phone number contains the South African
//international country code (+27) followed by a number that is
//no more than ten characters long
public boolean checkCellPhoneNumber(String cellPhoneNumber) {
if (cellPhoneNumber == null || !cellPhoneNumber.startsWith("+27")) {
return false;
}
String numberPortion = cellPhoneNumber.substring(3); //everything after +27
return Pattern.matches("\\d+", numberPortion) && numberPortion.length() <= 10;
}
//Validates the username, password, and cell phone number (in that
//order) and returns the appropriate registration message. If all
//three checks pass, the details are stored on this object.
public String registerUser(String username, String password, String cellPhoneNumber) {
if (!checkUserName(username)) {
return "Username is not correctly formatted; please ensure that your "
+ "username contains an underscore and is no more than five "
+ "characters in length.";
}
if (!checkPasswordComplexity(password)) {
return "Password is not correctly formatted; please ensure that the "
+ "password contains at least eight characters, a capital "
+ "letter, a number, and a special character.";
}
if (!checkCellPhoneNumber(cellPhoneNumber)) {
return "Cell number is incorrectly formatted or does not contain an "
+ "international code; please correct the number and try again.";
}
//All checks passed - store the details for later login
this.username = username;
this.password = password;
this.cellPhoneNumber = cellPhoneNumber;
return "Username successfully captured.\nPassword successfully captured."
+ "\nCell number successfully captured.";
}
//Verifies that the entered username and password match the details
//stored when the user registered
public boolean loginUser(String enteredUsername, String enteredPassword) {
return enteredUsername != null && enteredUsername.equals(this.username)
&& enteredPassword != null && enteredPassword.equals(this.password);
}
//Returns the appropriate login status message
public String returnLoginStatus(boolean loginSuccessful) {
if (loginSuccessful) {
return "Welcome " + firstName + ", " + lastName + " it is great to see you again";
}
return "Username or password incorrect, please try again.";
} 
    
    
}
