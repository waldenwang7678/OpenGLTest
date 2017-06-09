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

public class MainActivity extends AppCompatActivity {


    private ListView list_main;
    ArrayList<MenuBean> mData = new ArrayList<>();

    /**
     * openGLES 2.0
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        add("图形绘制", DrawGraphActivity.class);
        add("图形绘制", DrawGraphActivity.class);

    }

    private void initView() {
        list_main = (ListView) findViewById(R.id.list_main);
        CommenListAdapter<MenuBean> adapter = new CommenListAdapter<>(mData);
        adapter.setmCallback(new CommenListAdapter.AdapterCallback() {
            @Override
            public View getView(int position) {
                View view = View.inflate(MainActivity.this, R.layout.gl_type_item, null);
                TextView text = (TextView) view.findViewById(R.id.gl_item);
                text.setText(mData.get(position).name);
                return view;
            }
        });
        list_main.setAdapter(adapter);
        list_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, mData.get(position).clazz);
                startActivity(intent);
            }
        });
    }

    private void add(String name, Class clazz) {
        MenuBean bean = new MenuBean();
        bean.name = name;
        bean.clazz = clazz;
        mData.add(bean);
    }
}
