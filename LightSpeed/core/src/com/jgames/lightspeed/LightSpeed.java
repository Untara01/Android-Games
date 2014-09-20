package com.jgames.lightspeed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgames.lightspeed.input.TouchHandler;
import com.jgames.lightspeed.screens.*;

public class LightSpeed extends Game 
{
	public SpriteBatch batch;
	public TouchHandler touchHandler;
	
	public static final int screenWidth = 800;
	public static final int screenHeight = 480;
	
	public BitmapFont headingOneFont;
	public BitmapFont headingTwoFont;
	public BitmapFont headingThreeFont;
	public BitmapFont normalFont;
	
	public SplashScreen splashScreen;
	public MainMenuScreen mainMenuScreen;
	public GameScreen gameScreen;
	public OptionsScreen optionsScreen;
	public ShopScreen shopScreen;
	public SelectScreen selectScreen;
	
	public void create () 
	{
		this.batch = new SpriteBatch();
		this.touchHandler = new TouchHandler();
		
		this.headingOneFont = new BitmapFont();
		this.headingTwoFont = new BitmapFont();
		this.headingThreeFont = new BitmapFont();
		this.normalFont = new BitmapFont();
		
		this.splashScreen = new SplashScreen();
		this.mainMenuScreen = new MainMenuScreen(this);
		this.gameScreen = new GameScreen();
		this.optionsScreen = new OptionsScreen(this);
		this.shopScreen = new ShopScreen();
		this.selectScreen = new SelectScreen();
		
		this.setScreen(this.mainMenuScreen);
	}

	public void render () 
	{
		this.touchHandler.SetData();
		super.render();
	}
	
	public void dispose()
	{
		this.batch.dispose();
		this.headingOneFont.dispose();
		this.headingTwoFont.dispose();
		this.headingThreeFont.dispose();
		this.normalFont.dispose();
		this.splashScreen.dispose();
		this.mainMenuScreen.dispose();
		this.gameScreen.dispose();
		this.optionsScreen.dispose();
		this.shopScreen.dispose();
		this.selectScreen.dispose();
	}
}
