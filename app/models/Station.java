package models;
import play.db.jpa.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Station extends Model {
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
            Reading latestReading = new Reading(0, 0, 0, 0, 0, null);
            return latestReading;
        }
    }

    public static List<Station> sortStations(List<Station> station) {
        station.sort(Comparator.comparing(Station::getLocation, String.CASE_INSENSITIVE_ORDER));
        return station;
    }

    public String tempTrend() {
        String tempTrendText = "fas fa-2x fa-arrows-h";
        if (readings.size() != 0 && readings.size() > 2) {
            Reading tempTrend1 = readings.get(readings.size() - 1);
            Reading tempTrend2 = readings.get(readings.size() - 2);
            Reading tempTrend3 = readings.get(readings.size() - 3);
            if ((tempTrend1.getTemp() > tempTrend2.getTemp() && (tempTrend2.getTemp() > tempTrend3.getTemp()))) {
                tempTrendText = "fas fa-2x fa-arrow-trend-up fa-beat";
            }
            if ((tempTrend1.getTemp() < tempTrend2.getTemp() && (tempTrend2.getTemp() < tempTrend3.getTemp()))) {
                tempTrendText = "fas fa-2x fa-arrow-trend-down fa-beat";
            }
        }
        else { tempTrendText = "fas fa-2x fa-arrows-h";}
        return tempTrendText;
    }

    public String pressureTrend() {
        String pressureTrendText = "fas fa-2x fa-arrows-h";
        if (readings.size() != 0 && readings.size() > 2) {
            Reading pressureTrend1 = readings.get(readings.size() - 1);
            Reading pressureTrend2 = readings.get(readings.size() - 2);
            Reading pressureTrend3 = readings.get(readings.size() - 3);
            if ((pressureTrend1.getPressure() > pressureTrend2.getPressure() && (pressureTrend2.getPressure() > pressureTrend3.getPressure()))) {
                pressureTrendText = "fas fa-2x fa-arrow-trend-up fa-beat";
            }
            if ((pressureTrend1.getPressure() < pressureTrend2.getPressure() && (pressureTrend2.getPressure() < pressureTrend3.getPressure()))) {
                pressureTrendText = "fas fa-2x fa-arrow-trend-down fa-beat";
            }
        }
        else { pressureTrendText = "fas fa-2x fa-arrows-h";}
        return pressureTrendText;
    }

    public String windTrend() {
        String windTrendText = "fas fa-2x fa-arrows-h";
        if (readings.size() != 0 && readings.size() > 2) {
            Reading windTrend1 = readings.get(readings.size() - 1);
            Reading windTrend2 = readings.get(readings.size() - 2);
            Reading windTrend3 = readings.get(readings.size() - 3);
            if ((windTrend1.getWindSpeed() > windTrend2.getWindSpeed() && (windTrend2.getWindSpeed() > windTrend3.getWindSpeed()))) {
                windTrendText = "fas fa-2x fa-arrow-trend-up fa-beat";
            }
            if ((windTrend1.getWindSpeed() < windTrend2.getWindSpeed() && (windTrend2.getWindSpeed() < windTrend3.getWindSpeed()))) {
                windTrendText = "fas fa-2x fa-arrow-trend-down fa-beat";
            }
        }
        else { windTrendText = "fas fa-2x fa-arrows-h";}
        return windTrendText;
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
                if (reading.getWindSpeed() > maxWind.getWindSpeed()) {
                    maxWind = reading;
                }
            }
            return maxWind.getWindSpeed();
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
