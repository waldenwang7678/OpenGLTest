package walden.com.opengl_es_test.shape;

import android.opengl.GLES20;
import android.view.View;

import java.lang.reflect.Constructor;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


/**
 * Description:
 */
public class FGLRender extends Shape {

    private Shape shape;
    private Class<? extends Shape> clazz = Cube.class;  //默认形状

    public FGLRender(View mView) {
        super(mView);
    }

    public void setShape(Class<? extends Shape> shape) {
        this.clazz = shape;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) { //把传入的类对象转换成实例对象
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);  //设置清除颜色
        try {
            Constructor constructor = clazz.getDeclaredConstructor(View.class);
            constructor.setAccessible(true);
            shape = (Shape) constructor.newInstance(mView);
        } catch (Exception e) {
            e.printStackTrace();
            shape = new Cube(mView);
        }
        shape.onSurfaceCreated(gl, config);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);//按照窗口大小制作 OpenGL 的屏幕
        shape.onSurfaceChanged(gl, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //清除点啥
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        shape.onDrawFrame(gl);
    }
}

