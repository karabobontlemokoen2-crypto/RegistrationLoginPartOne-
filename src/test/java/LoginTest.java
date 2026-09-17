/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import com.mycompany.registerationloginpartone.Login;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Student
 */
public class LoginTest {
    Login login;
public void setUp() {
login = new Login("Karabo", "Mkhize");
}
// ----- assertEquals tests -----
@Test
public void testRegisterUser_UsernameIncorrectlyFormatted() {
String result = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
assertEquals("Username is not correctly formatted; please ensure that your "
+ "username contains an underscore and is no more than five "
+ "characters in length.", result);
}
@Test
public void testRegisterUser_PasswordDoesNotMeetComplexity() {
String result = login.registerUser("kyl_1", "password", "+27838968976");
assertEquals("Password is not correctly formatted; please ensure that the "
+ "password contains at least eight characters, a capital "
+ "letter, a number, and a special character.", result);
}
@Test
public void testRegisterUser_CellPhoneIncorrectlyFormatted() {
String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553");
assertEquals("Cell number is incorrectly formatted or does not contain an "
+ "international code; please correct the number and try again.", result);
}
@Test
public void testReturnLoginStatus_LoginSuccessful() {
login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
boolean successful = login.loginUser("kyl_1", "Ch&&sec@ke99!");
String result = login.returnLoginStatus(successful);
assertEquals("Welcome Karabo, Mkhize it is great to see you again.", result);
}
@Test
public void testReturnLoginStatus_LoginFailed() {
login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
boolean successful = login.loginUser("kyl_1", "wrongPassword1!");
String result = login.returnLoginStatus(successful);
assertEquals("Username or password incorrect, please try again.", result);
}
// ----- assertTrue / assertFalse tests -----
@Test
public void testCheckUserName_CorrectlyFormatted() {
assertTrue(login.checkUserName("kyl_1"));
}
@Test
public void testCheckUserName_IncorrectlyFormatted() {
assertFalse(login.checkUserName("kyle!!!!!!!"));
}
@Test
public void testCheckPasswordComplexity_MeetsRequirements() {
assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
}
@Test
public void testCheckPasswordComplexity_DoesNotMeetRequirements() {
assertFalse(login.checkPasswordComplexity("password"));
}
@Test
public void testCheckCellPhoneNumber_CorrectlyFormatted() {
assertTrue(login.checkCellPhoneNumber("+27838968976"));
}
@Test
public void testCheckCellPhoneNumber_IncorrectlyFormatted() {
assertFalse(login.checkCellPhoneNumber("08966553"));
}
@Test
public void testLoginUser_Successful() {
login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
}
@Test
public void testLoginUser_Failed() {
login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
assertFalse(login.loginUser("kyl_1", "wrongPassword1!"));
}
}