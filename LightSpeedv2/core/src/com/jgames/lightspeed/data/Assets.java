package com.jgames.lightspeed.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jgames.lightspeed.graphics.Animation;

public class Assets 
{
	public static Texture background;
	public static TextureRegion backgroundRegion;

	public static Texture items;
	public static TextureRegion mainMenu;
	public static TextureRegion pauseMenu;
	public static TextureRegion ready;
	public static TextureRegion gameOver;
	public static TextureRegion highScoresRegion;
	public static TextureRegion logo;
	public static TextureRegion soundOn;
	public static TextureRegion soundOff;
	public static TextureRegion arrow;
	public static TextureRegion pause;
	public static TextureRegion spring;
	public static TextureRegion castle;
	public static Animation coinAnim;
	public static Animation bobJump;
	public static Animation bobFall;
	public static TextureRegion bobHit;
	public static Animation squirrelFly;
	public static TextureRegion platform;
	public static Animation brakingPlatform;
	public static BitmapFont font;

	public static Music music;
	public static Sound jumpSound;
	public static Sound highJumpSound;
	public static Sound hitSound;
	public static Sound coinSound;
	public static Sound clickSound;

	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () 
	{
		Assets.background = loadTexture("data/background.png");
		Assets.backgroundRegion = new TextureRegion(background, 0, 0, 320, 480);
/*
		Assets.items = loadTexture("data/items.png");
		Assets.mainMenu = new TextureRegion(items, 0, 224, 300, 110);
		Assets.pauseMenu = new TextureRegion(items, 224, 128, 192, 96);
		Assets.ready = new TextureRegion(items, 320, 224, 192, 32);
		Assets.gameOver = new TextureRegion(items, 352, 256, 160, 96);
		Assets.highScoresRegion = new TextureRegion(Assets.items, 0, 257, 300, 110 / 3);
		Assets.logo = new TextureRegion(items, 0, 352, 274, 142);
		Assets.soundOff = new TextureRegion(items, 0, 0, 64, 64);
		Assets.soundOn = new TextureRegion(items, 64, 0, 64, 64);
		Assets.arrow = new TextureRegion(items, 0, 64, 64, 64);
		Assets.pause = new TextureRegion(items, 64, 64, 64, 64);

		Assets.spring = new TextureRegion(items, 128, 0, 32, 32);
		Assets.castle = new TextureRegion(items, 128, 64, 64, 64);
		Assets.coinAnim = new Animation(0.2f, new TextureRegion(items, 128, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32),
			new TextureRegion(items, 192, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32));
		Assets.bobJump = new Animation(0.2f, new TextureRegion(items, 0, 128, 32, 32), new TextureRegion(items, 32, 128, 32, 32));
		Assets.bobFall = new Animation(0.2f, new TextureRegion(items, 64, 128, 32, 32), new TextureRegion(items, 96, 128, 32, 32));
		Assets.bobHit = new TextureRegion(items, 128, 128, 32, 32);
		Assets.squirrelFly = new Animation(0.2f, new TextureRegion(items, 0, 160, 32, 32), new TextureRegion(items, 32, 160, 32, 32));
		Assets.platform = new TextureRegion(items, 64, 160, 64, 16);
		Assets.brakingPlatform = new Animation(0.2f, new TextureRegion(items, 64, 160, 64, 16), new TextureRegion(items, 64, 176, 64, 16),
			new TextureRegion(items, 64, 192, 64, 16), new TextureRegion(items, 64, 208, 64, 16));
*/
		Assets.font = new BitmapFont();
/*
		Assets.music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
		Assets.music.setLooping(true);
		Assets.music.setVolume(Settings.GetInstance().MUSIC_VOLUME);
		
		if(Settings.GetInstance().MUSIC_VOLUME > 0)
		{
			Assets.music.play();
		}*/
	}

	public static void playSound (Sound sound) 
	{
		if(Settings.GetInstance().SFX_VOLUME > 0)
		{
			sound.play(Settings.GetInstance().SFX_VOLUME);
		}
	}
}
