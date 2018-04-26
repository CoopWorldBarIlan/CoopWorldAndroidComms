package coopworld.kidsVer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import coopworld.kidsVer.Networking.Connection;
import coopworld.kidsVer.Screens.MenuScreen;


/*
 * Class Name: CooperativeGame
 * extends Game class, set default values of the game, and load game assets.
 */
public class CooperativeGame extends Game {
    private SpriteBatch spriteBatch;
    private Connection connection;

    @Override
    public void create() {
        Gdx.input.setCatchBackKey(true);
        spriteBatch = new SpriteBatch();
        connection = new Connection();

        setScreen(new MenuScreen(this));
    }

    // Render method of the super class (Game).
    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        System.out.println("DISPOSE GAME!");
        super.dispose();
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public Connection getConnection() {
        return connection;
    }
}