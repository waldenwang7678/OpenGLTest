package walden.com.opengl_es_test;

import android.content.Intent;
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
import walden.com.opengl_es_test.shape.Triangle;
import walden.com.opengl_es_test.shape.TriangleColorFull;
import walden.com.opengl_es_test.shape.TriangleWithCamera;

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
                        setShape(Triangle.class);
                        break;
                    case 1:
                        setShape(TriangleWithCamera.class);
                        break;
                    case 2:
                        setShape(TriangleColorFull.class);
                        break;
                    case 3:
                        setShape(Square.class);
                        break;
                    case 4:
                        setShape(Oval.class);
                        break;
                    case 5:
                        setShape(Cube.class);
                        break;
                    case 6:
                        setShape(Cone.class);
                        break;
                    case 7:
                        setShape(Cylinder.class);
                        break;
                    case 8:
                        setShape(Ball.class);
                        break;
                    case 9:
                        setShape(BallWithLight.class);
                        break;
                    case 10:
                        break;

                }
            }
        });
    }

    private void setShape(Class clazz) {
        glView.setShape(clazz);
        startActivity(new Intent(DrawGraphActivity.this, EmptyActivity.class));
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
