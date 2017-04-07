package tracker.homeexercise.Model;

import android.provider.ContactsContract;

import java.util.Date;


/**
 * Created by Jan on 07.04.2017.
 */

public class LeasureActivity extends Event {

    private Date time;
    private String name;

    public LeasureActivity(String name, Date time)
    {
        this.name = name;
        this.time = time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getType() {
        return 1337;
    }
}
