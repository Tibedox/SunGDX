package ru.myitschool.sungdx;

import static ru.myitschool.sungdx.MyGdx.SCR_HEIGHT;
import static ru.myitschool.sungdx.MyGdx.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenIntro implements Screen {
    MyGdx c;

    Texture imgBG;

    TextButton btnPlay, btnSettings, btnAbout, btnExit;

    public ScreenIntro(MyGdx context){
        c = context;
        // создание изображений
        imgBG = new Texture("winter1.jpg");
        btnPlay = new TextButton(c.fontLarge, "ИГРАТЬ", 600, 600);
        btnSettings = new TextButton(c.fontLarge, "НАСТРОЙКИ", 600, 500);
        btnAbout = new TextButton(c.fontLarge, "ОБ ИГРЕ", 600, 400);
        btnExit = new TextButton(c.fontLarge, "ВЫХОД", 600, 300);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // обработка касаний экрана
        if(Gdx.input.justTouched()) {
            c.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            c.camera.unproject(c.touch);
            if(btnPlay.hit(c.touch.x, c.touch.y)) {
                c.setScreen(c.screenGame);
            }
            if(btnExit.hit(c.touch.x, c.touch.y)) {
                Gdx.app.exit();
            }
        }
        // отрисовка всей графики
        c.camera.update();
        c.batch.setProjectionMatrix(c.camera.combined);
        c.batch.begin();
        c.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        c.font.draw(c.batch, btnPlay.text, btnPlay.x, btnPlay.y);
        c.font.draw(c.batch, btnSettings.text, btnSettings.x, btnSettings.y);
        c.font.draw(c.batch, btnAbout.text, btnAbout.x, btnAbout.y);
        c.font.draw(c.batch, btnExit.text, btnExit.x, btnExit.y);
        c.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
