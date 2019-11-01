package com.reggi.grafisimage;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Segitiga implements GLSurfaceView.Renderer {
    private FloatBuffer triangle;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.9f, 1.0f);
        initShapes();
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glColor4f(0.0f , 1.0f, 0.0f, 0.0f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangle);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0 ,5);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }
    public void initShapes(){
        float vertices[] = {
                -0.4f, -0.2f, 0.0f, //left-bottom
                0.4f, -0.2f, 0.0f, //right-bottom
                -0.6f, 0.2f, 0.0f, //left-top
                0.6f, 0.2f, 0.0f, //right-top
                0f, 0.5f, 0.0f, //top

        };
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        triangle = vbb.asFloatBuffer();
        triangle.put(vertices);
        triangle.position(0);
    }
}
