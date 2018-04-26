package coopworld.kidsVer.Logs;

import java.util.ArrayList;

/**
 * Created by User on 22/03/2017.
 */
public class GameData {
    private transient User user; // user.
    private String user_id; // user id.
    // will not be sent! gameData is sent to the server only on start, without level logs.
    private transient ArrayList<LevelData> level_data_list; // LevelData for each played level.
    private String tablet_id;
    // apk version from manifest.
    private String apk_version;
    private String start_time; // game start time - TimeStamp as a string.
    private transient Scores cumulativeScores;

    public GameData() {

    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void addLevel_log(LevelData level_data) {
        this.level_data_list.add(level_data);
    }

    public User getUser() {
        return user;
    }

    public void setTablet_id(String tablet_id) {
        this.tablet_id = tablet_id;
    }

    public void setApk_version(String apk_version) {
        this.apk_version = apk_version;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Scores getCumulativeScores() {
        return cumulativeScores;
    }

    public String getApk_version() {
        return apk_version;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getTablet_id() {
        return tablet_id;
    }
}
