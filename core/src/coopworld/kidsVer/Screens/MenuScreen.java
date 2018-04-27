package coopworld.kidsVer.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import coopworld.kidsVer.CooperativeGame;
import coopworld.kidsVer.Logs.GameData;
import coopworld.kidsVer.Logs.LevelData;
import coopworld.kidsVer.Logs.User;
import coopworld.kidsVer.Networking.Connection;


/*
 * Class Name: MenuScreen
 * implements screen, represents the menu screen with play, setting and about
 * options.
 */
public class MenuScreen implements Screen {
    private Viewport viewport;
    private Stage stage;
    final CooperativeGame game;
    private Texture texture;
    public MenuScreen(CooperativeGame game){
        // background picture to be shown.
        texture = new Texture(Gdx.files.internal("menu/MainMenu.png"));
        this.game = game;
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
                new OrthographicCamera());
        stage = new Stage(viewport, game.getSpriteBatch());

        // establish connection, prepare data, post.
        communication();

    }

    @Override
    public void show() {
        // enable getting input from screen (for pressing buttons etc.).
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getSpriteBatch().begin();
        game.getSpriteBatch().draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getSpriteBatch().end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void hide() {
    }
    @Override
    public void dispose() {
        stage.dispose();
    }

    public void communication(){
        // read configuration file.
        try{
            game.getConnection().readConfig();
        } catch (Exception exception) {
            Gdx.app.log("Config","couldn't read config file.");
        }

        // send gameData... examples.
        Connection connection = game.getConnection();
        connection.connectToServer();

        // create gameData object.
        GameData gameData = new GameData();
        gameData.setUser_id("12341");
        gameData.setTablet_id("-1");
        // send the object to the server.
        connection.sendGameData(gameData);

        // Level Data:
        LevelData levelData = new LevelData();
        levelData.setUser_id("12342");
        levelData.setTablet_id("-1");
        // send the object to the server.
        connection.sendLevelData(levelData);

        User user = new User();
        user.setAge("5");
        user.setApk_version("1.1");
        user.setName("Avi");
        connection.sendUserData(user);
        }
}