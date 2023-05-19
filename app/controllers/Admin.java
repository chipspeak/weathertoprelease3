package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import models.Member;
import play.mvc.Controller;

public class Admin extends Controller {
  /*
  method to display all of the objects stored in the session
  and then render the admin view to display the object lists
   */
  public static void index() {
    List<Reading> readings = Reading.findAll();
    List<Station> stations = Station.findAll();
    List<Member> members = Member.findAll();
    render("admin.html", readings, stations, members);
  }
}
