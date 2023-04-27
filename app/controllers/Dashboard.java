package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

  public class Dashboard extends Controller {
    public static void index()
    {
      Logger.info("Rendering Dasboard");
      Member member = Accounts.getLoggedInMember();
      List<Station> stations = member.stations;
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
      Logger.info("Adding a Playlist");
      Member member = Accounts.getLoggedInMember();
      Station station = new Station(location, longitude, latitude);
      member.stations.add(station);
      member.save();
      redirect ("/dashboard");
    }
  }


//  public static void index() {
//    Logger.info("Rendering dashboard");
//    List<Station> stations = Station.findAll();
//    render ("dashboard.html", stations);
//  }
//
//  public static void addStation(String location, float longitude, float latitude) {
//    Station station = new Station(location, longitude, latitude);
//    station.save();
//    Logger.info("Adding new Station for" + location);
//    redirect("/dashboard");
//  }
//
//  public static void deleteStation(Long id) {
//    Station station = Station.findById(id);
//    Logger.info("Removing" + station.location);
//    station.delete();
//    redirect("/dashboard");
//  }



