package models;
import play.db.jpa.Model;
import Utilities.Conversions;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import controllers.StationControl;
import play.db.jpa.Model;

@Entity
public class Station extends Model
{
    public String location;
    public float longitude;
    public float latitude;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String location, float longitude, float latitude) {
        this.location = location;
        this.longitude = longitude;
        this.latitude =  latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    public Reading listLatestReading() {
        if (readings.size()>0) {
            Reading latestReading = readings.get(readings.size() - 1);
            return latestReading;
        }
        else {
            Reading latestReading = new Reading(0, 0, 0, 0, 0);
            return latestReading;
        }
    }

    public double minTemp() {
        if (readings.size() != 0) {
            Reading minTemp = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemp() < minTemp.getTemp()) {
                    minTemp = reading;
                }
            }
            return minTemp.getTemp();
        } else
            return 0;
    }

    public double maxTemp() {
        if (readings.size() != 0) {
            Reading maxTemp = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemp() > maxTemp.getTemp()) {
                    maxTemp = reading;
                }
            }
            return maxTemp.getTemp();
        } else
            return 0;
    }

    public double minWind() {
        if (readings.size() != 0) {
            Reading minWind = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getWindSpeed() < minWind.getWindSpeed()) {
                    minWind = reading;
                }
            }
            return minWind.getWindSpeed();
        } else
            return 0;
    }

    public double maxWind() {
        if (readings.size() != 0) {
            Reading maxWind = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemp() > maxWind.getTemp()) {
                    maxWind = reading;
                }
            }
            return maxWind.getTemp();
        } else
            return 0;
    }

    public int minPressure() {
        if (readings.size() != 0) {
            Reading minPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getPressure() < minPressure.getPressure()) {
                    minPressure = reading;
                }
            }
            return minPressure.getPressure();
        } else
            return 0;
    }

    public int maxPressure() {
        if (readings.size() != 0) {
            Reading maxPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getPressure() > maxPressure.getPressure()) {
                    maxPressure = reading;
                }
            }
            return maxPressure.getPressure();
        } else
            return 0;
    }





}
