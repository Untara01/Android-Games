package com.jgames.lightspeed.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.data.Assets;
import com.jgames.lightspeed.data.Settings;
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
	
	private Joystick joystick;
	
	//private Ship shipOne;
	
	public GameScreen(LightSpeed game)
	{
		this.game = game;
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, LightSpeed.screenWidth, LightSpeed.screenHeight);
		
		this.state = GameState.GAME_RUNNING;
		
		//this.shipOne = new Ship(new Sprite(new Vector2(400, 240), 0f, this.shipYellow), this.laserYellow, this);
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
		this.game.batch.draw(Assets.backgroundRegion, 0, 0, LightSpeed.screenWidth, LightSpeed.screenWidth);
		this.game.batch.end();

		this.game.batch.enableBlending();
		this.game.batch.begin();
		this.joystick.Draw(this.game.batch);
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
		this.joystick.Update();
		
		//this.shipOne.UpdateShip(Gdx.graphics.getDeltaTime(), this.shipOne.GetInputs(this.joystick));
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
