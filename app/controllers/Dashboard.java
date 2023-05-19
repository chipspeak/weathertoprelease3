package controllers;

import java.util.List;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller {
  /*
  method to check for the logged in member and then lists all stations in their session.
  This method also uses the sortStations method in order to list them alphabetically.
  The method then renders the dashboard view with the stations list adjusted by the sort method.
  */
  public static void index() {
    Logger.info("Rendering Dasboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.sortStations(member.stations);
    render("dashboard.html", stations);
  }

  /*
  method to check for the current member, check for the station object by id
  then remove that station from the member's list of stations
  it then saves the new iteration of the member object and deletes the removed station
  */
  public static void deleteStation(Long id) {
    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect("/dashboard");
  }

  /*
  method to add a new station to the member session and the list of stations
  it passes in the location, longitude and latitude parameters
  Checks for the currently logged in member, creates a new station object which takes in
  the parameters passed in above. The station is then saved and the dashboard view rendered
   */
  public static void addStation(String location, float longitude, float latitude) {
    Logger.info("Adding a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(location, longitude, latitude);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }
}



