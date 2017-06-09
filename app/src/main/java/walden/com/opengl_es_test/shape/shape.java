package walden.com.opengl_es_test.shape;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.View;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public abstract class shape implements GLSurfaceView.Renderer {

    protected View mView;

    public shape(View view) {
        this.mView = view;
    }

    public shape() {

    }

    public int loadShader(int type, String shaderCode) {
        //根据type创建顶点着色器或者片元着色器
        int shader = GLES20.glCreateShader(type);
        //将资源加入到着色器中，并编译
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

}
