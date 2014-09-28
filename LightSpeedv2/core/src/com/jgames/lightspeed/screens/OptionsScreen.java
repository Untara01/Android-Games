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

public class OptionsScreen extends ScreenAdapter
{
	private LightSpeed game;
	private OrthographicCamera camera;
	
	private Button backButton;
	private Button fixedButton;
	
	public OptionsScreen(LightSpeed game)
	{
		this.game = game;
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, LightSpeed.screenWidth, LightSpeed.screenHeight);
		
		this.backButton = new Button(new Vector2(30, 430), 0f, Assets.smallButton, Color.WHITE, 1.7f, 1.4f,
				"Back", Assets.font);
		
		this.fixedButton = new Button(new Vector2(100, 150), 0f, Assets.smallButton, Color.WHITE, 2.5f, 1.4f,
				"Joystick Fixed: " + Settings.GetInstance().JOYSTICK_FIXED, Assets.font);
	}
	
	public void update()
	{
		if(backButton.update())
		{
			this.game.setScreen(new MainMenuScreen(this.game));
			return;
		}
		if(fixedButton.update())
		{
			if(Settings.GetInstance().JOYSTICK_FIXED)
			{
				Settings.GetInstance().SetJoystickFixed(false);
			}
			else
			{
				Settings.GetInstance().SetJoystickFixed(true);
			}
			
			this.fixedButton.text = "Joystick Fixed: " + Settings.GetInstance().JOYSTICK_FIXED;
			return;
		}
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
		this.game.batch.draw(Assets.background, 0, 0);
		this.game.batch.end();

		this.game.batch.enableBlending();
		this.game.batch.begin();
		this.backButton.draw(this.game.batch);
		this.fixedButton.draw(this.game.batch);
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
