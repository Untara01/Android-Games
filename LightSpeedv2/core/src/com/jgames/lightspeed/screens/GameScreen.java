package com.jgames.lightspeed.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.data.Assets;
import com.jgames.lightspeed.data.Settings;
import com.jgames.lightspeed.game.Ship;
import com.jgames.lightspeed.input.Joystick;

public class GameScreen extends ScreenAdapter
{
	private LightSpeed game;
	
	private static enum GameState
	{
		GAME_PREP,
		GAME_RUNNING,
		GAME_PAUSED,
		GAME_OVER
	}
	
	private GameState state;
	private OrthographicCamera camera;
	
	Ship shipOne;
	
	private Joystick joystick;
	
	//private Ship shipOne;
	
	public GameScreen(LightSpeed game)
	{
		this.game = game;
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, LightSpeed.screenWidth, LightSpeed.screenHeight);
		
		this.state = GameState.GAME_RUNNING;
		
		this.shipOne = new Ship(new Sprite(Assets.shipYellow), Assets.laserYellow, this);
		this.shipOne.setPosition(LightSpeed.screenWidth / 2 - 16, LightSpeed.screenHeight / 2 - 16);
		this.joystick = new Joystick(Assets.joystickKnob, Assets.joystickPoint);
	}
	
	@Override
	public void render(float delta) 
	{
		this.draw();
		this.update();
	}
	
	public void draw()
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
		this.joystick.draw(this.game.batch);
		this.shipOne.DrawShip(this.game.batch);
		this.game.batch.end();	
	}
	
	public void update()
	{	
		switch(this.state)
		{
			case GAME_PREP:
				this.updatePrep();
				break;
				
			case GAME_RUNNING:
				this.updateRunning();
				break;
				
			case GAME_PAUSED:
				this.updatePaused();
				break;
				
			case GAME_OVER:
				this.updateOver();
				break;
		}
	}
	
	private void updatePrep()
	{
		
	}
	
	private void updateRunning()
	{
		this.joystick.update();
		
		this.shipOne.UpdateShip(Gdx.graphics.getDeltaTime(), this.shipOne.GetInputs(this.joystick));
	}
	
	private void updatePaused()
	{
		
	}
	
	private void updateOver()
	{
		
	}

	@Override
	public void pause() 
	{
		Settings.GetInstance().preferences.flush();
	}
}
