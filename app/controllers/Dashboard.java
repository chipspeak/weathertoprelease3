package controllers;
import java.util.List;
import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

  public class Dashboard extends Controller {
    public static void index()
    {
      Logger.info("Rendering Dasboard");
      Member member = Accounts.getLoggedInMember();
      List<Station> stations = Station.sortStations(member.stations);
      render ("dashboard.html", stations);
    }

    public static void deleteStation (Long id)
    {
      Logger.info("Deleting a Station");
      Member member = Accounts.getLoggedInMember();
      Station station = Station.findById(id);
      member.stations.remove(station);
      member.save();
      station.delete();
      redirect ("/dashboard");
    }

    public static void addStation (String location, float longitude, float latitude)
    {
      Logger.info("Adding a Station");
      Member member = Accounts.getLoggedInMember();
      Station station = new Station(location, longitude, latitude);
      member.stations.add(station);
      member.save();
      redirect ("/dashboard");
    }
  }



