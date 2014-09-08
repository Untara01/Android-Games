package com.jae.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jae.spaceshooter.SpaceShooter;
import com.jae.spaceshooter.core.Ship;

public class GameScreen implements Screen
{
	final SpaceShooter game;
	
	//----------Assets----------\\
	
	//-----Team Yellow-----\\
	private Texture shipYellow = new Texture(Gdx.files.internal("teamYellow/ship.png"));
	//---End Team Yellow---\\
	
	//-------Team Red------\\
	private Texture shipRed = new Texture(Gdx.files.internal("teamRed/ship.png"));
	//-----End Team Red----\\

	//------Team Blue------\\
	private Texture shipBlue = new Texture(Gdx.files.internal("teamBlue/ship.png"));
	//----End Team Blue----\\

	//------Team Green-----\\
	private Texture shipGreen = new Texture(Gdx.files.internal("teamGreen/ship.png"));
	//----End Team Green---\\
	
	//--------End Assets--------\\
	
	//---------Sprites----------\\
	private Ship Ship1;
	//-------End Sprites--------\\
	
	private OrthographicCamera camera;
	
	public GameScreen(SpaceShooter game)
	{
		this.game = game;
		
		this.Ship1 = new Ship(new Sprite(this.shipYellow));
		this.Ship1.setPosition(400, 240);
		this.Ship1.setOrigin(32, 32);
		
		this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 800, 480);
	}
	
	@Override
	public void render(float delta) 
	{
		this.Draw();
		this.Update();
	}
	
	public void Update()
	{
		
	}
	
	public void Draw()
	{
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        this.camera.update();
        this.game.batch.setProjectionMatrix(this.camera.combined);
        
        this.game.batch.begin();
        this.Ship1.draw(this.game.batch);
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
