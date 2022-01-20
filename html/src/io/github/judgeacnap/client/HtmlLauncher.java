package io.github.judgeacnap.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.badlogic.gdx.backends.gwt.GwtGraphics;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import io.github.judgeacnap.JudgeAcnapGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                // Resizable application, uses available space in browser
                //return new GwtApplicationConfiguration(true);
                // Fixed size application:
                return new GwtApplicationConfiguration(Window.getClientWidth()/2, 320, false);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new JudgeAcnapGame();
        }
}