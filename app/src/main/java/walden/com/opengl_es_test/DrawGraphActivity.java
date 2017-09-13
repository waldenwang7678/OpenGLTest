package walden.com.opengl_es_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import walden.com.opengl_es_test.adapter.CommenListAdapter;
import walden.com.opengl_es_test.shape.Ball;
import walden.com.opengl_es_test.shape.BallWithLight;
import walden.com.opengl_es_test.shape.Cone;
import walden.com.opengl_es_test.shape.Cube;
import walden.com.opengl_es_test.shape.Cylinder;
import walden.com.opengl_es_test.shape.Oval;
import walden.com.opengl_es_test.shape.Square;
import walden.com.opengl_es_test.shape.triangle.Triangle;
import walden.com.opengl_es_test.shape.triangle.TriangleColorFull;
import walden.com.opengl_es_test.shape.triangle.TriangleWithCamera;

public class DrawGraphActivity extends AppCompatActivity {

    private ArrayList<String> mData = new ArrayList<>();
    private ListView list;
    private GraphView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_graph);
        initData();
        initView();
    }

    private void initData() {
        mData.add("三角形");
        mData.add("正三角形");
        mData.add("彩色三角形");
        mData.add("正方形");
        mData.add("圆形");
        mData.add("正方体");
        mData.add("圆锥");
        mData.add("圆柱");
        mData.add("球体");
        mData.add("带光源的球体");
    }

    private void initView() {
        glView = (GraphView) findViewById(R.id.glView);
        list = (ListView) findViewById(R.id.graph_item);
        CommenListAdapter adapter = new CommenListAdapter<String>(mData);
        adapter.setmCallback(new CommenListAdapter.AdapterCallback() {
            @Override
            public View getView(int position) {
                View view = View.inflate(DrawGraphActivity.this, R.layout.graph_item, null);
                TextView tv = (TextView) view.findViewById(R.id.graph_item_tv);
                tv.setText(mData.get(position));
                return view;
            }
        });
        list.setAdapter(adapter);
        glView.setShape(Triangle.class);  //默认图形
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        setShape(Triangle.class);  //三角形
                        break;
                    case 1:
                        setShape(TriangleWithCamera.class); //正三角形
                        break;
                    case 2:
                        setShape(TriangleColorFull.class);  //带颜色三角形
                        break;
                    case 3:
                        setShape(Square.class);   //正方形
                        break;
                    case 4:
                        setShape(Oval.class);   //圆形
                        break;
                    case 5:
                        setShape(Cube.class);//正方体
                        break;
                    case 6:
                        setShape(Cone.class);//圆锥
                        break;
                    case 7:
                        setShape(Cylinder.class);//圆柱
                        break;
                    case 8:
                        setShape(Ball.class);//球
                        break;
                    case 9:
                        setShape(BallWithLight.class);//光源球
                        break;
                    case 10:
                        break;

                }
            }
        });
    }

    private void setShape(Class clazz) {
        glView.setShape(clazz);

        //改变生命周期，GlSerfavceView 会重新绘制更新
        glView.onPause();  //停止
        glView.onResume();  //开始
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }
}
