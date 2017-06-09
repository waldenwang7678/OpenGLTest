package walden.com.opengl_es_test;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TriangleActivity extends AppCompatActivity {


    private GLSurfaceView gl_trangle1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        initView();
    }

    private void initView() {
        gl_trangle1 = (GLSurfaceView) findViewById(R.id.gl_trangle1);

        //gl_trangle1.setRenderer(this);

    }
}
