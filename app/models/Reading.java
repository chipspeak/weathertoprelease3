package models;
import javax.persistence.Entity;
import play.db.jpa.Model;
import Utilities.Conversions;


@Entity
public class Reading extends Model
{
    public int code;
    public double temp;
    public double windSpeed;
    public int pressure;
    public double windChill;
    public double windDirection;
    public String date;


    public Reading(int code, double temp, double windSpeed, double windDirection, int pressure, String date) {
        this.code = code;
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.date = date;
    }

    public double fahrenheit() {
        return Conversions.tempConversion(this.temp);
    }

    public String conditions() {
        return Conversions.weatherDisplay(this.code);
    }

    public String weatherIcon() { return Conversions.weatherVisual(this.code);}

    public String tempIcon() { return Conversions.tempVisual(this.temp);}

    public int beauforts() {
        return Conversions.beaufortConversion(this.windSpeed);
    }

    public String beaufortLabel() {
        return Conversions.beaufortLabelConversion(this.beauforts());
    }

    public double windChillReading() {
        return Conversions.windChillCalculation(this.temp, this.windSpeed);
    }

    public String windDirectionReading() {
        return Conversions.windDirectionCalculation(this.windDirection);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}