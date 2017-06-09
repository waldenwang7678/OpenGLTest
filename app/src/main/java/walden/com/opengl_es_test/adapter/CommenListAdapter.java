package walden.com.opengl_es_test.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public class CommenListAdapter<T> extends BaseAdapter {

    private ArrayList<T> mData;
    AdapterCallback mCallback;

    public CommenListAdapter(ArrayList<T> data) {
        mData = data;
    }

    public CommenListAdapter(ArrayList<T> data, AdapterCallback callback) {
        mData = data;
        mCallback = callback;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return mCallback.getView(position);
    }

    public interface AdapterCallback {
        View getView(int position);
    }

    public void setmCallback(AdapterCallback callback) {
        mCallback = callback;
    }
}
