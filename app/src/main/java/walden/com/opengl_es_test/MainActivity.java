package walden.com.opengl_es_test;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
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
    private TextView text2;

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

    }

    private void initView() {
        text2 = (TextView) findViewById(R.id.text2);
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        final ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x2000;
        if (supportsEs2) {
            text2.setText("支持");
        } else {
            text2.setText("不支持");
        }
    }
}
