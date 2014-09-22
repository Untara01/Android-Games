package com.jgames.lightspeed.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jgames.lightspeed.LightSpeed;

public class DesktopLauncher 
{
	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Light Speed";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new LightSpeed(), config);
	}
}