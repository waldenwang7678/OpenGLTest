package walden.com.opengl_es_test.shape;

import android.graphics.drawable.shapes.Shape;
import android.view.View;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class FGLRender extends shape {

    private Shape shape;
    //private Class<? extends Shape> clazz = Cube.class;
    private Class<? extends Shape> clazz;

    public FGLRender(View mView) {
        super(mView);
    }

    public void setShape(Class<? extends Shape> shape) {
        this.clazz = shape;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {

    }
}
