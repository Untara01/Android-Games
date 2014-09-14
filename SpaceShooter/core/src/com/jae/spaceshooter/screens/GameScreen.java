package com.jae.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jae.spaceshooter.SpaceShooter;
import com.jae.spaceshooter.core.Ship;
import com.jae.spaceshooter.core.jJoystick;
import com.jae.spaceshooter.core.jSprite;

public class GameScreen implements Screen
{
	final SpaceShooter game;
	
	//----------Assets----------\\
	
	//-----Team Yellow-----\\
	private Texture shipYellow = new Texture(Gdx.files.internal("TeamYellow/ship.png"));
	private Texture laserYellow = new Texture(Gdx.files.internal("TeamYellow/laser.png"));
	//---End Team Yellow---\\
	
	//-------Team Red------\\
	private Texture shipRed = new Texture(Gdx.files.internal("TeamRed/ship.png"));
	private Texture laserRed = new Texture(Gdx.files.internal("TeamRed/laser.png"));
	//-----End Team Red----\\

	//------Team Blue------\\
	private Texture shipBlue = new Texture(Gdx.files.internal("TeamBlue/ship.png"));
	private Texture laserBlue = new Texture(Gdx.files.internal("TeamBlue/laser.png"));
	//----End Team Blue----\\

	//------Team Green-----\\
	private Texture shipGreen = new Texture(Gdx.files.internal("TeamGreen/ship.png"));
	private Texture laserGreen = new Texture(Gdx.files.internal("TeamGreen/laser.png"));
	//----End Team Green---\\
	
	//-------Joystick------\\
	private Texture centerPoint = new Texture(Gdx.files.internal("UI/Joystick/centerPoint.png"));
	private Texture centerKnob = new Texture(Gdx.files.internal("UI/Joystick/centerKnob.png"));
	
	//-----End Joystick----\\
	
	//--------End Assets--------\\
	
	//---------Sprites----------\\
	private Ship Ship1;
	//-------End Sprites--------\\
	
	public OrthographicCamera camera;
	public jJoystick joystick;
	public StretchViewport viewport;
	
	public GameScreen(SpaceShooter game)
	{
		this.game = game;
		
		this.Ship1 = new Ship(new jSprite(this.shipYellow), this.laserYellow, this);
		this.Ship1.Position = new Vector2(400, 240);
		
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, SpaceShooter.width, SpaceShooter.height);
		this.viewport = new StretchViewport(SpaceShooter.width, SpaceShooter.height, camera);
        
        this.joystick = new jJoystick(this.centerKnob, this.centerPoint);
	}
	
	@Override
	public void render(float delta) 
	{
		this.Draw();
		this.Update();
	}
	
	public void Update()
	{
		float deltaTime = Gdx.graphics.getDeltaTime();
		
		this.Ship1.UpdateShip(deltaTime, this.joystick);
		this.joystick.UpdateJoystick();
	}
	
	public void Draw()
	{
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        this.camera.update();
        this.game.batch.setProjectionMatrix(this.camera.combined);
        
        this.game.batch.begin();
        this.Ship1.DrawShip(this.game.batch);
        this.joystick.DrawJoystick(this.game.batch);
        this.game.batch.end();
	}

	@Override
	public void resize(int width, int height) 
	{
		this.viewport.update(width, height);
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