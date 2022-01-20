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

public class HtmlLauncher extends GwtApplication {
    @Override
    public void onModuleLoad () {
        super.onModuleLoad();
        Window.addResizeHandler(new ResizeHandler() {
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
                    getRootPanel().setWidth("" + width + "px");
                    getRootPanel().setHeight("" + height + "px");
                    getApplicationListener().resize(width, height);
                    Gdx.graphics.setWindowedMode(width, height);
                    log("ssssss", width + "  " + height);
                }
            }
        });
    }

    @Override
    public GwtApplicationConfiguration getConfig() {
        /*int width = Window.getClientWidth(), height = Window.getClientHeight();
        if (width >= height) {
            width = height * 2;
        } else {
            height = (int) (width * 0.5);
        }
        GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(width, height, true);
        cfg.fullscreenOrientation = GwtGraphics.OrientationLockType.LANDSCAPE;
        return cfg;*/
        return new GwtApplicationConfiguration(true);
    }

    @Override
    public ApplicationListener createApplicationListener() {
        Window.enableScrolling(false);
        this.setLogLevel(LOG_INFO);
        return new JudgeAcnapGame();
    }
}