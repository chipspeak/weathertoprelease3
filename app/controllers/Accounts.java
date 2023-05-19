package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class Accounts extends Controller {

  //method to render the signup page
  public static void signup() {
    render("signup.html");
  }

  //method to render the login page
  public static void login() {
    render("login.html");
  }

  //method to redit the profile page to allow user to edit personal details
  public static void editProfile() {
    render("profile.html");
  }

  /*
  method which takes in the parameters passed into the signup page via the post route
  parameters are then passed into a new member object and that member is saved
   */
  public static void register(String firstname, String lastname, String email, String password) {
    Logger.info("Registering new user " + email);
    Member member = new Member(firstname, lastname, email, password);
    member.save();
    redirect("/login");
  }

  /*
  method to edit existing member. This checks for the current member and then
  allows a user to change their details using the member setters
   */
  public void edit(String firstname, String lastname, String password) {
    Logger.info("Updating user info");
    getLoggedInMember().setFirstname(firstname);
    getLoggedInMember().setLastname(lastname);
    getLoggedInMember().setPassword(password);
    getLoggedInMember().save();
    redirect("/dashboard");
  }

  //method which deletes the current users account.
  public void deleteProfile() {
    getLoggedInMember().delete();
    redirect("/signup");
  }

  /*
  method to check if the user has successfully entered the password
  if the password is correct as detected by the checkPassword() method
  the dashboard is rendered
   */
  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with " + email + ":" + password);
    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else {
      Logger.info("Authentication failed");
      redirect("/login");
    }
  }

  //method to clear the current session and log out the user as a result
  public static void logout() {
    session.clear();
    redirect("/");
  }

  /*
  method to check for currently logged in member. Searches the session object for
  the member id, locate the member in the database and then returns the member
  otherwise it calls the login method to render the login view.

   */
  public static Member getLoggedInMember() {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }
}
