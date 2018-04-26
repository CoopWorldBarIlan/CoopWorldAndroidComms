package coopworld.kidsVer.Logs;

import java.util.ArrayList;

/**
 * Created by User on 03/01/2017.
 */
public class LevelData {
    // apk version from manifest.
    private String apk_version;
    // tablet unique identifier.
    private String tablet_id;
    // user unique identifier.
    private String user_id;
    // level number.
    private int level_num;
    // level start time - TimeStamp as a string.
    private String start_time;
    // level end time - TimeStamp as a string.
    private String end_time;
    // human and virtual players scores.
    private Scores scores;
    // number of stars at   the end of the level.
    private int num_of_stars;
    // number of screenshots taken turing the level.
    private int screenshots_num;
    // textual output about the level.
    private String textual_output;

    public void setLevel_num(int level_num) {
        this.level_num = level_num;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setNum_of_stars(int num_of_stars) {
        this.num_of_stars = num_of_stars;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    public int getLevel_num() {
        return level_num;
    }

    public void incScreenShotsNum(){
        this.screenshots_num += 1;
    }

    public String getApk_version() {
        return apk_version;
    }

    public String getTablet_id() {
        return tablet_id;
    }

    public int getHumanScore(){
        return scores.getHuman_player_score();
    }

    public String getStart_time() {
        return start_time;
    }

    public void setTextual_output(String textual_output) {
        this.textual_output = textual_output;
    }

    public String getTextual_output() {
        return textual_output;
    }

    public void setTablet_id(String tablet_id) {
        this.tablet_id = tablet_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
