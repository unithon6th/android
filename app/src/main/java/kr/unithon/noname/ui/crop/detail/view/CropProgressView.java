package kr.unithon.noname.ui.crop.detail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

import kr.unithon.noname.R;
import kr.unithon.noname.util.Utils;

public class CropProgressView extends View {

    private Paint progressBackgroundPaint;
    private Paint progressPaint;
    private float currentProgress;
    private float progress;
    private Bitmap[] stepImages;
    private Bitmap[] stepGreenImages;
    private float[] stepScales;

    public CropProgressView(Context context) {
        super(context);

        init();
    }

    public CropProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        initResource();

        invalidate();
    }

    private void initResource() {
        progressBackgroundPaint = new Paint();
        progressBackgroundPaint.setColor(
                Color.argb(
                        76,
                        0,
                        0,
                        0
                )
        );

        progressPaint = new Paint();
        progressPaint.setColor(
                ContextCompat.getColor(
                        getContext(),
                        R.color.aqua_marine
                )
        );

        stepImages = decodeResources(
                R.drawable.icon_step_1,
                R.drawable.icon_step_2,
                R.drawable.icon_step_3,
                R.drawable.icon_step_4,
                R.drawable.icon_step_5
        );
        stepGreenImages = decodeResources(
                R.drawable.icon_step_g_1,
                R.drawable.icon_step_g_2,
                R.drawable.icon_step_g_3,
                R.drawable.icon_step_g_4,
                R.drawable.icon_step_g_5
        );

        stepScales = new float[]{0, 0, 0, 0, 0};
    }

    private Bitmap[] decodeResources(int... ids) {
        Bitmap[] bitmaps = new Bitmap[ids.length];
        for (int i = 0; i < ids.length; i++) {
            bitmaps[i] = BitmapFactory.decodeResource(
                    getResources(),
                    ids[i]
            );
        }
        return bitmaps;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        post(
                () -> startAnimator(progress)
        );
    }

    private void startAnimator(float percent) {
        float viewWidth = getMeasuredWidth();

        ValueAnimator animator = ValueAnimator.ofFloat(
                0f,
                viewWidth * percent
        );
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setStartDelay(1000);
        animator.setDuration(2000);
        animator.addUpdateListener(valueAnimator -> {
            float value = (float) valueAnimator.getAnimatedValue();
            currentProgress = value;
            invalidate();
        });
        animator.start();

        startStepScaleAnimator();
    }

    private void startStepScaleAnimator() {
        for (int i = 0; i < stepImages.length; i++) {
            ValueAnimator animator = ValueAnimator.ofFloat(
                    0f,
                    1f
            );
            animator.setInterpolator(new BounceInterpolator());
            animator.setDuration(200);
            animator.setStartDelay(420 * i + 1000);
            int finalI = i;
            animator.addUpdateListener(valueAnimator -> {
                float value = (float) valueAnimator.getAnimatedValue();
                stepScales[finalI] = value;
            });
            animator.start();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawStep(canvas);
        drawProgressBackground(canvas);
        drawProgress(canvas);
        drawProgressPoint(canvas);
    }

    private void drawStep(Canvas canvas) {
        int viewWidth = getMeasuredWidth();

        for (int i = 0; i < stepImages.length; i++) {
            Bitmap stepImage;
            if(progress > 0.2f * i){
                stepImage = stepGreenImages[i];
            }
            else {
                stepImage = stepImages[i];
            }

            int centerX = viewWidth / (stepImages.length * 2) * (i * 2 + 1);
            int centerY = Utils.dpToPx(getContext(), 44);

            int imageWidth = (int) (stepImage.getWidth() * stepScales[i]);
            int imageHeight = (int) (stepImage.getHeight()* stepScales[i]);

            canvas.drawBitmap(
                    stepImage,
                    null,
                    new Rect(
                            centerX - imageWidth / 2,
                            centerY - imageHeight,
                            centerX + imageWidth / 2,
                            centerY
                    ),
                    null
            );
        }
    }

    private void drawProgressBackground(Canvas canvas) {
        canvas.drawRoundRect(
                new RectF(
                        Utils.dpToPx(getContext(), 0),
                        Utils.dpToPx(getContext(), 52),
                        getMeasuredWidth(),
                        Utils.dpToPx(getContext(), 60)
                ),
                Utils.dpToPx(getContext(), 4),
                Utils.dpToPx(getContext(), 4),
                progressBackgroundPaint
        );
    }

    private void drawProgress(Canvas canvas) {
        canvas.drawRoundRect(
                new RectF(
                        Utils.dpToPx(getContext(), 0),
                        Utils.dpToPx(getContext(), 52),
                        currentProgress,
                        Utils.dpToPx(getContext(), 60)
                ),
                Utils.dpToPx(getContext(), 4),
                Utils.dpToPx(getContext(), 4),
                progressPaint
        );
    }

    private void drawProgressPoint(Canvas canvas) {
        if (currentProgress == 0) return;
        canvas.drawCircle(
                currentProgress,
                Utils.dpToPx(getContext(), 68),
                Utils.dpToPx(getContext(), 4),
                progressPaint
        );
    }

}
