package com.jgames.lightspeed.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.input.TouchHandler;

public class MainMenuScreen implements Screen
{
	private LightSpeed game;
	
	public OrthographicCamera camera;
	public StretchViewport viewport;
	
	public MainMenuScreen(LightSpeed game)
	{
		this.game = game;
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, LightSpeed.screenWidth, LightSpeed.screenHeight);
		this.viewport = new StretchViewport(LightSpeed.screenWidth, LightSpeed.screenHeight, this.camera);
	}
	
	@Override
	public void render(float delta) 
	{
		this.draw();
		this.update();
	}
	
	public void draw()
	{
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.camera.update();
        this.game.batch.setProjectionMatrix(this.camera.combined);

        this.game.batch.begin();
        this.game.normalFont.draw(this.game.batch, "Welcome to Light Speed!", 100, 150);
        this.game.normalFont.draw(this.game.batch, "Tap anywhere to begin!", 100, 100);
        this.game.batch.end();
	}
	
	public void update()
	{
		for(int i = 0; i < TouchHandler.Data.size(); i++)
		{
			if(TouchHandler.Data.get(i).isDownBefore)
			{
				this.game.setScreen(this.game.gameScreen);
				this.dispose();
			}
		}
	}

	@Override
	public void resize(int width, int height) 
	{
		
	}

	@Override
	public void show() 
	{
		
	}

	@Override
	public void hide() 
	{
		
	}

	@Override
	public void pause() 
	{
		
	}

	@Override
	public void resume() 
	{
		
	}

	@Override
	public void dispose() 
	{
		
	}
}
