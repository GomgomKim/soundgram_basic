package test.dahun.mobileplay.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import test.dahun.mobileplay.tab.SubCoverView;
import test.dahun.mobileplay.ui.PagerAdapter;

public class CoverCustomPagerAdapter extends PagerAdapter {
    Context context;

    public CoverCustomPagerAdapter(Context context) {
        this.context=context;
    }

    // 기연추가
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      View v = new SubCoverView(this.context, position);
      container.addView(v);
      return v;
    }

    @Override
    public void destroyItem(ViewGroup container, final int position, Object object) {
      container.removeView((View) object);
    }

    @Override
    public int getCount() {
      return 2;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
      return arg0 == arg1;
    }
}