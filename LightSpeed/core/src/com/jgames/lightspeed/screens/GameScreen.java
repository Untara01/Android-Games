package com.jgames.lightspeed.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.graphics.Sprite;
import com.jgames.lightspeed.graphics.game.Ship;
import com.jgames.lightspeed.input.Joystick;

public class GameScreen implements Screen
{
	private LightSpeed game;
	
	public OrthographicCamera camera;
	public StretchViewport viewport;
	
	public Joystick joystick;
	
	public Ship shipOne;
	
	public Texture shipYellow = new Texture(Gdx.files.internal("TeamYellow/ship.png"));
	public Texture laserYellow = new Texture(Gdx.files.internal("TeamYellow/laser.png"));
	
	public Texture joystickPoint = new Texture(Gdx.files.internal("UI/Joystick/centerPoint.png"));
	public Texture joystickKnob = new Texture(Gdx.files.internal("UI/Joystick/centerKnob.png"));
	
	public GameScreen(LightSpeed game)
	{
		this.game = game;
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, LightSpeed.screenWidth, LightSpeed.screenHeight);
		this.viewport = new StretchViewport(LightSpeed.screenWidth, LightSpeed.screenHeight, this.camera);
		
		this.shipOne = new Ship(new Sprite(new Vector2(400, 240), 0f, this.shipYellow), this.laserYellow, this);
		this.joystick = new Joystick(joystickKnob, joystickPoint);
	}
	
	@Override
	public void render(float delta) 
	{
		this.draw();
		this.update();
	}
	
	public void draw()
	{
        this.camera.update();
        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();
        this.game.batch.draw(LightSpeed.background, 0, 0);
        
        this.joystick.Draw(this.game.batch);
        
        this.shipOne.DrawShip(this.game.batch);
        this.game.batch.end();
	}
	
	public void update()
	{
		this.joystick.Update();
		
		this.shipOne.UpdateShip(Gdx.graphics.getDeltaTime(), this.shipOne.GetInputs(this.joystick));
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
