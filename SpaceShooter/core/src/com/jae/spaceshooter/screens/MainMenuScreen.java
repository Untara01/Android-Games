package com.jae.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jae.spaceshooter.SpaceShooter;

public class MainMenuScreen implements Screen
{
	final SpaceShooter game;
	
	private OrthographicCamera camera;
	
	public MainMenuScreen(SpaceShooter game)
	{
		this.game = game;
		
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, 800, 480);
	}
	
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.camera.update();
        this.game.batch.setProjectionMatrix(camera.combined);

        this.game.batch.begin();
        this.game.font.draw(game.batch, "Welcome to Space Shooter v0.1 ", 100, 150);
        this.game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        this.game.batch.end();

        if (Gdx.input.isTouched()) 
        {
        	this.game.setScreen(new GameScreen(this.game));
        	this.dispose();
        }
	}

	@Override
	public void resize(int width, int height) 
	{ 
		
	}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() 
	{
		
	}
}
