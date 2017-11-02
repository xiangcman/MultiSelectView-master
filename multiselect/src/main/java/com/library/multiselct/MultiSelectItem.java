package com.library.multiselct;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.OvershootInterpolator;
import android.widget.Scroller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangcheng on 17/10/27.
 */

public class MultiSelectItem extends View {
    private static final String TAG = "MultiSelectItem";
    private List<SelectBean> selectBeanList = new ArrayList<>();
    private static final int DEFRAULT_DISPLAY_COUNT = 3;
    private int width, height;
    private static final int lineColor = Color.parseColor("#FF3300");
    private Paint linePaint;
    private Paint textPaint;
    //初始的偏移量
    private float offset;
    //每一行间隔的距离
    private float diffY;
    private float maxOffset;
    private Scroller mScroller;
    private float minOffset;

    public int getCurrentIndex() {
        return currentIndex;
    }

    //当前滑动到的位置啊
    private int currentIndex;

    private float minTextSize;
    private float maxTextSize;

    private float minAlpha;
    private float maxAlpha;

    private float currentTextSize;
    private float currentAlpha;

    //速度追踪器
    private VelocityTracker velocityTracker;
    private float lastY;
    private float dy;
    float endY;

    private float otherTextSize;
    private float otherAlpha;

    private float minFlingVelocity;
    //用于区别选中和未选中的item的索引
    private int currentChange;

    public MultiSelectItem(Context context) {
        super(context);
        init();
    }

    public MultiSelectItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MultiSelectItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(lineColor);
        linePaint.setStrokeWidth(1f);
        linePaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.parseColor("#666666"));
        textPaint.setTextAlign(Paint.Align.CENTER);

        mScroller = new Scroller(getContext(), new OvershootInterpolator());

        minFlingVelocity = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();

        minTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 17, getContext().getResources().getDisplayMetrics());
        maxTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 22, getContext().getResources().getDisplayMetrics());

        minAlpha = 0.6f;
        maxAlpha = 1.0f;

        currentTextSize = maxTextSize;
        currentAlpha = maxAlpha;

        otherTextSize = minTextSize;
        otherAlpha = minAlpha;
        currentChange = currentIndex;
    }

    public void resetList(List<? extends SelectBean> selectBeanList) {
        if (selectBeanList != null) {
            this.selectBeanList.clear();
            this.selectBeanList.addAll(selectBeanList);
            offset = diffY;
            currentIndex = 0;
            currentChange = currentIndex;
            maxOffset = -diffY * (this.selectBeanList.size() - 2);
            refreshList();
        } else {
            throw new IllegalArgumentException("selectBeanList is null");
        }
    }

    private void refreshList() {
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawItem(canvas);
        drawLine(canvas);
    }

    private void drawItem(Canvas canvas) {
        for (int i = 0; i < selectBeanList.size(); i++) {
            SelectBean selectBean = selectBeanList.get(i);
            String name = selectBean.name;
            //越界的item就不需要去绘制了
            if (offset + i * diffY > height || (offset + i * diffY) + diffY < 0 || ((offset + i * diffY == height) && (offset + i * diffY) + diffY > height) ||
                    (((offset + i * diffY) + diffY == 0) && offset + i * diffY < 0)) {
                continue;
            } else {
                if (i == currentChange) {
                    textPaint.setTextSize(currentTextSize);
                    textPaint.setAlpha((int) (255 * currentAlpha));
                } else {
                    textPaint.setTextSize(otherTextSize);
                    textPaint.setAlpha((int) (255 * otherAlpha));
                }
                Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                float allHeight = fontMetrics.descent - fontMetrics.ascent;
                canvas.drawText(name, width * 1.0f / 2, offset + i * diffY + diffY / 2 - allHeight / 2 - fontMetrics.ascent, textPaint);
            }

        }
    }

    private void drawLine(Canvas canvas) {
        int lineCount = DEFRAULT_DISPLAY_COUNT - 1;
        for (int i = 0; i < lineCount; i++) {
            canvas.drawLine(0, getHeight() * 1.0f * (i + 1) / DEFRAULT_DISPLAY_COUNT, getWidth(), getHeight() * 1.0f * (i + 1) / DEFRAULT_DISPLAY_COUNT, linePaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (velocityTracker == null) {
            velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker.addMovement(event);
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mScroller.forceFinished(true);
                lastY = y;
                dy = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                dy = y - lastY;
                validateValue();
                break;
            case MotionEvent.ACTION_UP:
                calculateVelocity();
                break;

        }
        lastY = y;
        return true;
    }

    private void calculateVelocity() {
        velocityTracker.computeCurrentVelocity(1000);
        float yVelocity = velocityTracker.getYVelocity();

        //大于这个值才会被认为是fling
        if (Math.abs(yVelocity) > minFlingVelocity) {
            if ((offset == maxOffset && yVelocity < 0) || (offset == minOffset && yVelocity > 0)) {
                return;
            }
            int startY = Math.round(offset);
            endY = Math.round(yVelocity / 10) + startY;
            if (endY <= maxOffset) {
                endY = maxOffset;
            }
            if (endY >= minOffset) {
                endY = minOffset;
            }
            if (endY > 0) {
                currentIndex = Math.round(Math.abs(endY - diffY) * 1.0f / diffY);
            } else {
                currentIndex = Math.round((Math.abs(endY) + diffY) * 1.0f / diffY);
            }

            if (endY - diffY > 0) {
                endY = diffY + currentIndex * diffY;
            } else {
                endY = diffY - currentIndex * diffY;
            }
            mScroller.startScroll(0, startY, 0, (int) (endY - startY));
            invalidate();
        } else {
            releaseMoveTo();
        }
    }

    //松手的时候，移动到最近的一个index上
    private void releaseMoveTo() {
        if (offset > 0) {
            currentIndex = Math.round(Math.abs(offset - diffY) * 1.0f / diffY);
        } else {
            currentIndex = Math.round((Math.abs(offset) + diffY) * 1.0f / diffY);
        }
        int startY = Math.round(offset);
        endY = 0;
        if (offset - diffY > 0) {
            endY = diffY + currentIndex * diffY;
        } else {
            endY = diffY - currentIndex * diffY;
        }
        mScroller.startScroll(0, startY, 0, (int) (endY - startY));
        invalidate();
    }

    private static final float maxDeviation = 5f;

    private void validateValue() {
        offset += dy;
        if (offset <= maxOffset) {
            offset = maxOffset;
        }
        if (offset >= minOffset) {
            offset = minOffset;
        }
        scrollTochangeChilds();
        postInvalidate();
    }

    //滑动的位置到了需要改变childs数据的时候了
    private void scrollTochangeChilds() {
        if (Math.abs(offset) % diffY <= maxDeviation) {
            if (offset > 0) {
                currentIndex = Math.round(Math.abs(offset - diffY) * 1.0f / diffY);
            } else {
                currentIndex = Math.round((Math.abs(offset) + diffY) * 1.0f / diffY);
            }
            currentChange = currentIndex;
            currentTextSize = maxTextSize;
            currentAlpha = maxAlpha;
            if (mScrollListener != null) {
                mScrollListener.end(this, currentIndex);
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height = h;
        width = w;
        offset = (float) (h * 1.0 / DEFRAULT_DISPLAY_COUNT);
        //每一个间隔的y轴距离是y轴的1/3
        diffY = (float) (h * 1.0 / DEFRAULT_DISPLAY_COUNT);
        minOffset = diffY;
        maxOffset = -diffY * (this.selectBeanList.size() - 2);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        //返回true表示滑动还没有结束
        if (mScroller.computeScrollOffset()) {
            offset = mScroller.getCurrY();
            scrollTochangeChilds();
            postInvalidate();
        }
    }

    private ScrollListener mScrollListener;

    public void setScrollListener(ScrollListener mScrollListener) {
        this.mScrollListener = mScrollListener;
    }

    interface ScrollListener {
        void end(MultiSelectItem multiSelectItem, int index);
    }
}
