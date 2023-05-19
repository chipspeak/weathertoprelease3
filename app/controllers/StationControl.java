package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class StationControl extends Controller {

  //method to render the station view
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);
    render("station.html", station);
  }

  /*
  method to create a new reading which takes the passed in parameters
  finds the station in the database, stores the reading in the station
  and redirects to the stations view
   */
  public static void addReading(long id, int code, double temp, double windSpeed, int windDirection, int pressure, String date) {
    Reading reading = new Reading(code, temp, windSpeed, windDirection, pressure, date);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/stations/" + id);
  }

  /*
  method to delete a reading from the station object by locating
  it in the database and deleting it from the station object
  the station object saves the update and the station view is rendered
   */
  public static void deleteReading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info("Removing reading");
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station);
  }
}



