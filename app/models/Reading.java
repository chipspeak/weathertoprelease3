package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import Utilities.Conversions;


@Entity
public class Reading extends Model {

  //variable declarations
  public int code;
  public double temp;
  public double windSpeed;
  public int pressure;
  public double windChill;
  public double windDirection;
  public String date;

  //reading constructor
  public Reading(int code, double temp, double windSpeed, double windDirection, int pressure, String date) {
    this.code = code;
    this.temp = temp;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
    this.date = date;
  }

  /*
  method to pass the readings temp into the tempConversion method
  and then return the result of the conversion
  this is then called in the listReadings view
   */
  public double fahrenheit() {
    return Conversions.tempConversion(this.temp);
  }


  /*
  method to pass the readings code into the weatherDisplay method
  and then return the result of the switch case
  this is then called in the listreadings view
   */
  public String conditions() {
    return Conversions.weatherDisplay(this.code);
  }


  /*
  method to pass the readings code into the weatherVisual method
  and then return the result of the switch case
  this is then called in the listreadings view
   */
  public String weatherIcon() {
    return Conversions.weatherVisual(this.code);
  }


  /*
  method to pass the readings temp into the tempVisual method,
  return the result and call this method in the listreadings view
  to return the desired thermometer visual
   */
  public String tempIcon() {
    return Conversions.tempVisual(this.temp);
  }


  /*
  method to pass the readings windspeed into the beaufortConversion method
  then return the result to be called in the listreadings view
   */
  public int beauforts() {
    return Conversions.beaufortConversion(this.windSpeed);
  }


  /*
  method to pass in the above beauforts method to the beaufortLabelConversion
  method, returns the result and then this method is called in the listreadings view
   */
  public String beaufortLabel() {
    return Conversions.beaufortLabelConversion(this.beauforts());
  }


  /*
  method to pass temp and windSpeed into the windChillCalculation method and
  return the result of this calculation before this method is called
  in the listreadings view
   */
  public double windChillReading() {
    return Conversions.windChillCalculation(this.temp, this.windSpeed);
  }


  /*
  method to pass in the readings windDirection into the windDirectionCalculation method
  and return the result. This method is then called in the listreadings view.
   */
  public String windDirectionReading() {
    return Conversions.windDirectionCalculation(this.windDirection);
  }

  //getters and setters
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