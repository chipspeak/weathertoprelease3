package Utilities;

public class Conversions {

    public static String weatherDisplay(int code) {
        String weatherCondition = null;
        switch (code) {
            case 100:
                weatherCondition = "Clear";
                break;
            case 200:
                weatherCondition = "Partial Clouds";
                break;
            case 300:
                weatherCondition = "Cloudy";
                break;
            case 400:
                weatherCondition = "Light Showers";
                break;
            case 500:
                weatherCondition = "Heavy Showers";
                break;
            case 600:
                weatherCondition = "Rain";
                break;
            case 700:
                weatherCondition = "Snow";
                break;
            case 800:
                weatherCondition = "Thunder";
                break;
        }
        return  weatherCondition;
    }

    public static String weatherVisual(int code) {
            String weatherIcon = "/public/images/white/whitesunshine.png";
            switch (code) {
                case 100:
                    weatherIcon = "/public/images/white/whitesunshine.png";
                    break;
                case 200:
                    weatherIcon = "/public/images/white/whitepartialcloudy.png";
                    break;
                case 300:
                    weatherIcon = "/public/images/white/whitecloud.png";
                    break;
                case 400:
                    weatherIcon = "/public/images/white/whiterain.png";
                    break;
                case 500:
                    weatherIcon = "/public/images/white/whiteheavyshowers.png";
                    break;
                case 600:
                    weatherIcon = "/public/images/white/whiterain.png";
                    break;
                case 700:
                    weatherIcon = "/public/images/white/whitesnowfall.png";
                    break;
                case 800:
                    weatherIcon = "/public/images/white/whitethunder.png";
                    break;
            }
            return  weatherIcon;
        }


    public static double tempConversion (double temp) {
        return temp*9/5 + 32;
    }

    public static int beaufortConversion (double windSpeed) {
        int beaufortScale = 0;
        if (windSpeed == 1) {
            beaufortScale = 0;
        }
        if ((windSpeed > 1) && (windSpeed < 6)) {
            beaufortScale = 1;
        }
        if ((windSpeed > 5) && (windSpeed < 12)) {
            beaufortScale = 2;
        }
        if ((windSpeed > 11) && (windSpeed < 20)) {
            beaufortScale = 3;
        }
        if ((windSpeed > 19) && (windSpeed < 29)) {
            beaufortScale = 4;
        }
        if ((windSpeed > 28) && (windSpeed < 39)) {
            beaufortScale = 5;
        }
        if ((windSpeed > 38) && (windSpeed < 50)) {
            beaufortScale = 6;
        }
        if ((windSpeed > 49) && (windSpeed < 62)) {
            beaufortScale = 7;
        }
        if ((windSpeed > 61) && (windSpeed < 75)) {
            beaufortScale = 8;
        }
        if ((windSpeed > 74) && (windSpeed < 89)) {
            beaufortScale = 9;
        }
        if ((windSpeed > 88) && (windSpeed < 103)) {
            beaufortScale = 10;
        }
        if ((windSpeed > 102) && (windSpeed < 118)) {
            beaufortScale = 11;
        }
        return beaufortScale;
    }

    public static String beaufortLabelConversion(int beaufortScale) {
        String label = null;
        switch (beaufortScale) {
            case 0:
                label = "Calm";
                break;
            case 1:
                label = "Light Air";
                break;
            case 2:
                label = "Light Breeze";
                break;
            case 3:
                label = "Gentle Breeze";
                break;
            case 4:
                label = "Moderate Breeze";
                break;
            case 5:
                label = "Fresh Breeze";
                break;
            case 6:
                label = "Strong Breeze";
                break;
            case 7:
                label = "Near Gale";
                break;
            case 8:
                label = "Gale";
                break;
            case 9:
                label = "Severe Gale";
                break;
            case 10:
                label = "Strong Storm";
                break;
            case 11:
                label = "Violent Storm";
                break;
        }
        return  label;
    }

    public static double windChillCalculation(double temp, double windSpeed) {
        double chill = 0;
        if ((temp < 10.0 && windSpeed > 4.8)) {
            chill = 13.12 + 0.6215 * temp - 11.37 * (Math.pow(windSpeed, 0.16)) + 0.3965 * temp * (Math.pow(windSpeed, 0.16));
            double windChill = Math.round(chill*10.0)/10.0;
            return windChill;
        }
        else {
            return temp;
        }
    }

    public static String windDirectionCalculation(double windDirection) {
        if ((windDirection > 348.75 && windDirection < 11.25)) {
            return "North";
        }
        if ((windDirection > 11.24 && windDirection < 33.76)) {
            return "North North-East";
        }
        if ((windDirection > 33.75 && windDirection < 56.26)) {
            return "North-East";
        }
        if ((windDirection > 56.25 && windDirection < 78.76)) {
            return "East North-East";
        }
        if ((windDirection > 78.75 && windDirection < 101.26)) {
            return "East";
        }
        if ((windDirection > 101.25 && windDirection < 123.76)) {
            return "East South-East";
        }
        if ((windDirection > 123.75 && windDirection < 146.26)) {
            return "South-East";
        }
        if ((windDirection > 146.25 && windDirection < 168.76)) {
            return "South South-East";
        }
        if ((windDirection > 168.75 && windDirection < 191.26)) {
            return "South";
        }
        if ((windDirection > 191.25 && windDirection < 213.76)) {
            return "South South-West";
        }
        if ((windDirection > 213.75 && windDirection < 236.36)) {
            return "South-West";
        }
        if ((windDirection > 236.35 && windDirection < 258.76)) {
            return "West South-West";
        }
        if ((windDirection > 258.75 && windDirection < 281.26)) {
            return "West";
        }
        if ((windDirection > 281.25 && windDirection < 303.76)) {
            return "West North-West";
        }
        if ((windDirection > 303.75 && windDirection < 326.26)) {
            return "North-West";
        }
        if ((windDirection > 326.75 && windDirection < 348.76)) {
            return "North North-West";
        }
        else return " ";
    }



//    public static void tempReadingsHelper() { //method containing a simple loop for use in the addReading view
//        for(int i = 0; i < 40; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.println("<option value=" + i +"." + j +">" + i +"." + j + "° Celsius</option>");
//            }
//        }
//    }
//
//    public static void windDirectionHelper() {
//        for (int i = 0; i < 360; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.println("<option value=" + i + "." + j + ">" + i + "." + j + "° Celsius</option>");
//            }
//        }
//    }
}
