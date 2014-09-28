package com.jgames.lightspeed.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.data.Assets;
import com.jgames.lightspeed.data.Settings;
import com.jgames.lightspeed.input.Button;

public class MainMenuScreen extends ScreenAdapter
{
	private LightSpeed game;
	private OrthographicCamera camera;
	
	private Button playButton;
	private Button optionsButton;
	private Button classButton;
	
	public MainMenuScreen(LightSpeed game)
	{
		this.game = game;
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, LightSpeed.screenWidth, LightSpeed.screenHeight);
		
		this.playButton = new Button(new Vector2(100, 200), 0f, Assets.smallButton, Color.WHITE, 1.5f, 1.5f,
				"Play", Assets.font);
	}
	
	public void update()
	{
		if(playButton.update())
		{
			this.game.setScreen(new GameScreen(game));
			return;
		}/*
		if(optionsButton.update())
		{
			//this.game.setScreen(new OptionsScreen(game));
			return;
		}
		if(classButton.update())
		{
			//this.game.setScreen(new ClassScreen(game));
			return;
		}*/
	}
	
	public void draw () 
	{
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.game.batch.setProjectionMatrix(this.camera.combined);

		this.game.batch.disableBlending();
		this.game.batch.begin();
		this.game.batch.draw(Assets.backgroundRegion, 0, 0, LightSpeed.screenWidth, LightSpeed.screenWidth);
		this.game.batch.end();

		this.game.batch.enableBlending();
		this.game.batch.begin();
		this.playButton.draw(this.game.batch);
		this.game.batch.end();	
	}
	
	@Override
	public void render (float delta) 
	{
		this.update();
		this.draw();
	}

	@Override
	public void pause () 
	{
		Settings.GetInstance().preferences.flush();
	}
}
