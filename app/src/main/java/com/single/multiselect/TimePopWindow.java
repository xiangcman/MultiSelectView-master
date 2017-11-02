package com.single.multiselect;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.library.multiselct.MultiSelectView;

/**
 * Created by xiangcheng on 17/10/31.
 */

public class TimePopWindow extends PopupWindow {
    private View conentView;
    private Context context;

    public TimePopWindow(final Activity context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.layout_pop, null);
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        this.setContentView(conentView);
        this.setWidth(w);
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();
        this.setAnimationStyle(R.style.mypopwindow_anim_style);
        final MultiSelectView multiSelectView = (MultiSelectView) conentView.findViewById(R.id.select_view);
        multiSelectView.setOnAllSelect(new MultiSelectView.OnAllSelect() {
            @Override
            public void select(String text) {
                ((MainActivity) context).setAddress(text);
            }
        });
        multiSelectView.validateList(Constant.initData());
    }

//    @Override
//    public void select(String text) {
//        ((MainActivity) context).setAddress(text);
//    }
}
