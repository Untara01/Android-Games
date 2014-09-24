package com.jgames.lightspeed;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.jgames.lightspeed.LightSpeed;

public class IOSLauncher extends IOSApplication.Delegate 
{
    @Override
    protected IOSApplication createApplication() 
    {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        return new IOSApplication(new LightSpeed(), config);
    }

    public static void main(String[] argv) 
    {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}