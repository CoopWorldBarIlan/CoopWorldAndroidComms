package coopworld.kidsVer.Logs;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by User on 14/01/2017.
 */
public class User {
    // apk version from manifest.
    private String apk_version;
    private String tablet_id;
    private String user_id; // Primary Key. Unique!
    private String registration_time;
    private String name;
    private int level;
    private int high_score;

    private transient String age;
    private transient String country;
    private transient int cumulative_score;

    public User() {
        user_id = String.valueOf(new Random().nextInt(1000000));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHigh_score(int high_score) {
        this.high_score = high_score;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHigh_score() {
        return high_score;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegistration_time(String registration_time) {
        this.registration_time = registration_time;
    }

    public int getCumulative_score() {
        return cumulative_score;
    }

    public void setCumulative_score(int cumulative_score) {
        this.cumulative_score = cumulative_score;
    }

    public String getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public void setApk_version(String apk_version) {
        this.apk_version = apk_version;
    }

    public void setTablet_id(String tablet_id) {
        this.tablet_id = tablet_id;
    }
}
