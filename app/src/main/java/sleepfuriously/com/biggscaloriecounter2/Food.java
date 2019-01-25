package sleepfuriously.com.biggscaloriecounter2;

import java.util.Date;

/**
 * Simple class to hold the data on something eaten.
 */
public class Food {

    String name;
    int cals;
    Date date;


    public Food() {}


    public Food (String _name, int _cals, Date _date) {
        name = _name;
        cals = _cals;
        date = _date;
    }

}
