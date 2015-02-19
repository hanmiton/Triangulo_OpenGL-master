package com.darwin.user.triogl;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import java.util.Random;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by user on 19/02/2015.
 */
public class Pintar implements Renderer{
    Random aleatorio = new Random();
    Triangulo triangulo = new Triangulo();
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        float r = aleatorio.nextFloat();
        float g = aleatorio.nextFloat();
        float b = aleatorio.nextFloat();
        gl.glClearColor(r,g,b,1.0f);
       // gl.glClearColor(0.0f,1.0f,0.0f,0.5f);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -4);
        triangulo.draw(gl);
    }
}
