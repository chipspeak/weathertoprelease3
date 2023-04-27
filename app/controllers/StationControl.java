package controllers;
import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class StationControl extends Controller {
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        render("station.html", station);
    }

    public static void addReading(long id, int code, double temp, double windSpeed, int windDirection, int pressure)
    {
        Reading reading = new Reading(code, temp, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }

    public static void deleteReading (Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
//        Logger.info ("Removing" + reading.title);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }
}



