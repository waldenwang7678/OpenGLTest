package walden.com.opengl_es_test;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import walden.com.opengl_es_test.shape.FGLRender;
import walden.com.opengl_es_test.shape.Shape;

public class GraphView extends GLSurfaceView {
    private FGLRender renderer;

    public GraphView(Context context) {
        super(context);
    }

    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setEGLContextClientVersion(2);
        setRenderer(renderer = new FGLRender(this));
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    public void setShape(Class<? extends Shape> clazz) {
        try {
            renderer.setShape(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
