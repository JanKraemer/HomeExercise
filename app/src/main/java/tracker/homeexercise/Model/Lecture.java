package tracker.homeexercise.Model;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Jan on 07.04.2017.
 */

public class Lecture extends Event {

    private String room;
    private Date time;
    private String courseName;

    public Lecture(String room, Date time, String courseName)
    {
        this.courseName = courseName;
        this.time = time;
        this.room = room;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getRoom() {
        return room;
    }

    public Date getTime() {
        return time;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int getType() {
        return 42;
    }
}
