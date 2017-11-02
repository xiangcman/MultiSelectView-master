package com.library.multiselct;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xiangcheng on 17/10/27.
 */

public class MultiSelectView extends ViewGroup implements MultiSelectItem.ScrollListener {

    public MultiSelectView(Context context) {
        super(context);
        initItem();
    }

    public MultiSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initItem();
    }

    public MultiSelectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initItem();
    }

    private void initItem() {
        for (int i = 0; i < 3; i++) {
            MultiSelectItem multiSelectItem = new MultiSelectItem(getContext());
            multiSelectItem.setScrollListener(this);
            addView(multiSelectItem);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int childWidth = (int) (width * 1.0f / getChildCount());
        for (int i = 0; i < getChildCount(); i++) {
            measureChild(getChildAt(i), MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY), heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View item = getChildAt(i);
            item.layout((int) (getWidth() * i * 1.0f / getChildCount()), 0, (int) (getWidth() * i * 1.0f / getChildCount()) + item.getMeasuredWidth(), item.getMeasuredHeight());
        }
    }

    private List<? extends SelectBean> selectBeanList1;
    private List<SelectBean> selectBeanList2;
    private List<SelectBean> selectBeanList3;

    public void validateList(List<? extends SelectBean> selectBeanList) {
        if (selectBeanList == null || selectBeanList.size() == 0) {
            return;
        }
        this.selectBeanList1 = selectBeanList;
        ((MultiSelectItem) getChildAt(0)).resetList(this.selectBeanList1);
        this.selectBeanList2 = selectBeanList.get(0).childs;
        ((MultiSelectItem) getChildAt(1)).resetList(this.selectBeanList2);
        this.selectBeanList3 = this.selectBeanList2.get(0).childs;
        ((MultiSelectItem) getChildAt(2)).resetList(this.selectBeanList3);
        if (onAllSelect != null) {
            onAllSelect.select(this.selectBeanList1.get(0).name + " " + this.selectBeanList2.get(0).name + " " + this.selectBeanList3.get(0).name);
        }
    }

    @Override
    public void end(MultiSelectItem multiSelectItem, int index) {
        if (multiSelectItem == getChildAt(0)) {
            Log.d("MultiSelectView", "end:" + index);
            this.selectBeanList2 = this.selectBeanList1.get(index).childs;
            this.selectBeanList3 = this.selectBeanList2.get(0).childs;
            ((MultiSelectItem) getChildAt(1)).resetList(this.selectBeanList2);
            ((MultiSelectItem) getChildAt(2)).resetList(this.selectBeanList3);
            if (onAllSelect != null) {
                onAllSelect.select(this.selectBeanList1.get(index).name + " " + this.selectBeanList2.get(0).name + " " + this.selectBeanList3.get(0).name);
            }
        } else if (multiSelectItem == getChildAt(1)) {
            this.selectBeanList3 = this.selectBeanList2.get(index).childs;
            ((MultiSelectItem) getChildAt(2)).resetList(this.selectBeanList3);
            if (onAllSelect != null) {
                onAllSelect.select(this.selectBeanList1.get(((MultiSelectItem) getChildAt(0)).getCurrentIndex()).name + " " + this.selectBeanList2.get(index).name + " " + this.selectBeanList3.get(0).name);
            }
        } else {
            if (onAllSelect != null) {
                onAllSelect.select(this.selectBeanList1.get(((MultiSelectItem) getChildAt(0)).getCurrentIndex()).name + " " + this.selectBeanList2.get(((MultiSelectItem) getChildAt(1)).getCurrentIndex()).name + " " + this.selectBeanList3.get(index).name);
            }
        }
    }

    private OnAllSelect onAllSelect;

    public void setOnAllSelect(OnAllSelect onAllSelect) {
        this.onAllSelect = onAllSelect;
    }

    //选中内容回调
    public interface OnAllSelect {
        void select(String text);
    }

}
