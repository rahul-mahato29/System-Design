package Observer_Design_Pattern;

import Observer_Design_Pattern.Observable.WeatherStation;
import Observer_Design_Pattern.Observers.Observer;
import Observer_Design_Pattern.Observers.PhoneDisplay;
import Observer_Design_Pattern.Observers.TVDisplay;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();

        //add observer (IMP)
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        //Weather changes (State-Change)
        weatherStation.setWeather("Sunny");

        // Output:
        // Phone Display: Weather updated - Sunny
        // TV Display: Weather updated - Sunny
    }
}
