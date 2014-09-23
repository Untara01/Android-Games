package com.jgames.lightspeed.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.data.Settings;
import com.jgames.lightspeed.input.Button;

public class OptionsScreen implements Screen
{
	private LightSpeed game;
	
	public OrthographicCamera camera;
	public StretchViewport viewport;
	
	public Texture mainTexture = new Texture(Gdx.files.internal("UI/Buttons/MainButton.png"));
	public Button buttonReturn;
	public Button joystickFixed;
	
	public OptionsScreen(LightSpeed game)
	{
		this.game = game;
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, LightSpeed.screenWidth, LightSpeed.screenHeight);
		this.viewport = new StretchViewport(LightSpeed.screenWidth, LightSpeed.screenHeight, this.camera);
		
		this.buttonReturn = new Button(new Vector2(80, 460), 0, mainTexture, Color.WHITE, new Vector2(0.8f, 0.7f),
				"Back", this.game.headingTwoFont);
		this.joystickFixed = new Button(new Vector2(200, 100), 0, mainTexture, Color.WHITE, new Vector2(1.2f, 0.7f),
				"Joystick Fixed: " + Settings.GetInstance().JOYSTICK_FIXED, this.game.headingTwoFont);
	}
	
	@Override
	public void render(float delta) 
	{
		this.draw();
		this.update();
	}
	
	public void update()
	{
		if(this.buttonReturn.update())
		{
			this.game.setScreen(this.game.mainMenuScreen);
		}
		
		if(this.joystickFixed.update())
		{
			if(Settings.GetInstance().JOYSTICK_FIXED)
			{
				Settings.GetInstance().SetJoystickFixed(false);
			}
			else
			{
				Settings.GetInstance().SetJoystickFixed(true);
			}
			
			this.joystickFixed.text = "Joystick Fixed: " + Settings.GetInstance().JOYSTICK_FIXED;
		}
	}
	
	public void draw()
	{
		this.camera.update();
		this.game.batch.setProjectionMatrix(this.camera.combined);
		
		this.game.batch.begin();
        this.game.batch.draw(LightSpeed.background, 0, 0);
        
        this.buttonReturn.Draw(this.game.batch);
		this.joystickFixed.Draw(this.game.batch);
		this.game.batch.end();
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
