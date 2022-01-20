package io.github.judgeacnap.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.badlogic.gdx.backends.gwt.GwtGraphics;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import io.github.judgeacnap.JudgeAcnapGame;

import java.util.logging.Level;
import java.util.logging.Logger;

class MyResizeHandler implements ResizeHandler{
    GwtApplication GwtApplication;

    public MyResizeHandler(GwtApplication gwtApp){
        GwtApplication = gwtApp;
    }

    @Override
    public void onResize(ResizeEvent ev) {
        if (Gdx.graphics.isFullscreen()) {
            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        } else {
            int width = ev.getWidth(), height = ev.getHeight();
            if (ev.getWidth() >= ev.getHeight()) {
                width = height * 2;
            } else {
                height = (int)(ev.getWidth() * 0.5);
            }
            GwtApplication.getRootPanel().setWidth("" + width + "px");
            GwtApplication.getRootPanel().setHeight("" + height + "px");
            GwtApplication.getApplicationListener().resize(width, height);
            Gdx.graphics.setWindowedMode(width, height);
            //GwtApplication.log("ssssss: ", width + "  " + height);
        }
    }
}

public class HtmlLauncher extends GwtApplication {
    private MyResizeHandler MyResizeHandler = new MyResizeHandler(this);
    @Override
    public void onModuleLoad () {
        super.onModuleLoad();
        Window.addResizeHandler(MyResizeHandler);
    }

    @Override
    public GwtApplicationConfiguration getConfig() {
        int width = Window.getClientWidth(), height = Window.getClientHeight();
        if (width >= height) {
            width = height * 2;
        } else {
            height = (int) (width * 0.5);
        }
        GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(width, height, true);
        cfg.fullscreenOrientation = GwtGraphics.OrientationLockType.LANDSCAPE;
        return cfg;
    }

    @Override
    public ApplicationListener createApplicationListener() {
        Window.enableScrolling(false);
        //this.setLogLevel(LOG_INFO);
        return new JudgeAcnapGame();
    }
}