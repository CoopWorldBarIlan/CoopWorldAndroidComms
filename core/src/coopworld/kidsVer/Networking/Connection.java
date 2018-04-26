package coopworld.kidsVer.Networking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.net.HttpStatus;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.io.IOException;


import coopworld.kidsVer.Logs.GameData;
import coopworld.kidsVer.Logs.LevelData;

import static com.badlogic.gdx.net.HttpRequestHeader.ContentType;


/**
 * Connection with a server.
 */
public class Connection {
    protected String ip;
    protected String port;
    protected String urlLevelData;
    protected String urlGameData;
    protected Socket client;
    protected SocketHints hints;
    protected boolean socketConnected;

    /*
    read configuration file to get ip, port and urls.
    */
    public void readConfig() throws IOException {
        FileHandle file = Gdx.files.internal("config.txt");
        String text = file.readString();
        String lines[] = text.split("\\r?\\n");
        this.socketConnected = false;
        this.ip = lines[0];
        this.port = lines[1];
        this.urlLevelData = lines[2];
        this.urlGameData = lines[3];
    }

    /*
    create Tcp connection to the server.
    */
    public void connectToServer() {
        // new socket
        this.hints = new SocketHints();
        try {
            this.client = Gdx.net.newClientSocket(Net.Protocol.TCP, this.ip,
                    Integer.parseInt(this.port), this.hints);
            this.socketConnected = true;
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /*
    make a legal string to send to the server.
    */
    public String makeString(Object before){
        Json json = new Json();
        // serialize all fields, including default values.
        // for example, it makes sure that an int which is 0 will not be ignored in the json string.
        json.setUsePrototypes(false);
        // important for valid json!
        json.setOutputType(JsonWriter.OutputType.json);
        // the string jsonStr represents the GameData object in a json format.
        String jsonStr = json.toJson(before);
        return jsonStr;
    }


    public void sendGameData(GameData gameData){
        sendPostRequest(makeString(gameData), this.urlGameData);
    }

    public void sendLevelData(LevelData levelData){
        sendPostRequest(makeString(levelData), this.urlLevelData);
    }

    public void sendPostRequest(final String jsonStr, String url) {
        if(socketConnected){
            try {
                Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.POST);
                httpPost.setUrl(url);
                httpPost.setContent(jsonStr);
                httpPost.setHeader(ContentType, "application/json; charset=utf-8");
                Gdx.net.sendHttpRequest(httpPost, new Net.HttpResponseListener() {
                    public void handleHttpResponse(Net.HttpResponse httpResponse) {
                        HttpStatus status = httpResponse.getStatus();
                        if (status.getStatusCode() == HttpStatus.SC_OK
                                || status.getStatusCode() == HttpStatus.SC_NO_CONTENT) {
                            Gdx.app.log("PutUserService",
                                    " successful with code:" + status.getStatusCode());
                            System.out.println("SERVER_RES: " + httpResponse.getResultAsString());

                        } else {
                            Gdx.app.log("PutUserService",
                                    "update user name services return code: "
                                            + String.valueOf(status.getStatusCode()));
                        }
                    }

                    public void failed(Throwable t) {
                        String status = "failed";
                    }

                    @Override
                    public void cancelled() {
                        String status = "failed";
                    }
                });
            } catch (final Exception e) {
                String status = "failed";
            }
        }
    }

    public boolean isSocketConnected() {
        return socketConnected;
    }
}