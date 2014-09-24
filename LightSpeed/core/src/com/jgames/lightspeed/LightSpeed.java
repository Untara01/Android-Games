package com.jgames.lightspeed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgames.lightspeed.data.Settings;
import com.jgames.lightspeed.input.TouchHandler;
import com.jgames.lightspeed.screens.*;

public class LightSpeed extends Game 
{
	public SpriteBatch batch;
	public TouchHandler touchHandler;
	
	public static final int screenWidth = 800;
	public static final int screenHeight = 480;
	public static Texture background;
	
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
		this.gameScreen = new GameScreen(this);
		this.optionsScreen = new OptionsScreen(this);
		this.shopScreen = new ShopScreen();
		this.selectScreen = new SelectScreen();
		
		Settings.GetInstance();
		
		this.setScreen(this.optionsScreen);
	}

	public void render() 
	{
		this.touchHandler.SetData();
		super.render();
	}
	
	public static float convertToScreenWidth(float x)
	{
		return (x * LightSpeed.screenWidth) / Gdx.graphics.getWidth();
	}
	
	public static float convertToScreenHeight(float y)
	{
		return (y * LightSpeed.screenHeight) / Gdx.graphics.getHeight();
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
