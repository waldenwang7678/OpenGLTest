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
import walden.com.opengl_es_test.shape.Cube;
import walden.com.opengl_es_test.shape.Triangle;

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
        mData.add("intent");
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
        glView.setShape(Cube.class);  //默认图形
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        setShape(Triangle.class);
                        break;
                    case 1:
                        setShape(Triangle.class);
                        break;
                    case 2:
                        setShape(Triangle.class);
                        break;
                    case 3:
                        setShape(Cube.class);
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
