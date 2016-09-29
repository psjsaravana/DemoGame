package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by subramas on 9/29/16.
 */
public class SplashScreen implements Screen {

    private final MyGdxGame myGame;
    private long startTime;
    private SpriteBatch batch;
    Texture img;

    public SplashScreen(MyGdxGame myGdxGame) {
        myGame = myGdxGame;
        startTime = TimeUtils.millis();
        batch = new SpriteBatch();
        img = new Texture("splash.jpg");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(TimeUtils.millis() - startTime <= 3000) {
            batch.begin();
            batch.draw(img, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
            batch.end();
        } else {
            myGame.setScreen(new MainScreen(myGame));
        }
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
        batch.dispose();
        img.dispose();
    }
}
