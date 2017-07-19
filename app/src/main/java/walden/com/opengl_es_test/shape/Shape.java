package walden.com.opengl_es_test.shape;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.View;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public abstract class Shape implements GLSurfaceView.Renderer {

    protected View mView;

    public Shape(View view) {
        this.mView = view;
    }

    public Shape() {

    }

    /**
     * @param type       类型： 顶点 / 片元 着色器
     * @param shaderCode 着色器代码
     * @return
     */
    public int loadShader(int type, String shaderCode) {  // 加载着色器
        //根据type创建顶点着色器或者片元着色器
        int shader = GLES20.glCreateShader(type);
        //将资源加入到着色器中，并编译
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

}
