package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.utils.ParallaxBackground;
import com.mygdx.game.utils.ParallaxLayer;
import com.mygdx.game.utils.ParallaxWidget;

/**
 * Created by subramas on 9/29/16.
 */
public class MainScreen implements Screen {
    SpriteBatch batch;
    Texture building,backgroundImage,ground;
    MyGdxGame myGame;
    OrthographicCamera camera;
    int srcXBuilding,srcXGround;
    ParallaxBackground background;
    ParallaxWidget parallaxWidget;

    MainScreen(MyGdxGame myGdxGame) {
        myGame = myGdxGame;
        batch = new SpriteBatch();
        srcXBuilding = 0;
        srcXGround = 0;
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        building = new Texture("buildings.png");
        ground = new Texture("ground.png");
        backgroundImage = new Texture("background.png");
        backgroundImage.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        ground.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        building.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

       /* parallaxWidget = new ParallaxWidget("game-background.jpg",0,"layer2.png",4f);
        ParallaxLayer l1=new ParallaxLayer(img1,0,0);
        ParallaxLayer l2=new ParallaxLayer(img2,4f,0);
        //l2.region.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
        ParallaxLayer[] layers={l1,l2};
        background=new ParallaxBackground(layers, camera,batch);*/
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //camera.update();
        //background.moveX(30*delta);
        //background.render();
        //parallaxWidget.draw(batch,delta);
        batch.begin();
        batch.draw(backgroundImage,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(building,0 ,0,srcXBuilding,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(ground,0 ,0,srcXGround,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        srcXBuilding+=1;
        srcXGround +=2;
        Gdx.app.log("Src X value",""+srcXBuilding);
        if(srcXBuilding >= (int) Gdx.graphics.getWidth()) {
            //srcx = 0;
        }
        batch.end();
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
        building.dispose();
        ground.dispose();
        backgroundImage.dispose();
    }
}
