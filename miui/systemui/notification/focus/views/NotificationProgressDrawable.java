/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.util.AttributeSet
 *  android.util.Log
 *  androidx.annotation.ColorInt
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  com.android.systemui.miui.notification.R$styleable
 *  org.xmlpull.v1.XmlPullParser
 */
package miui.systemui.notification.focus.views;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.systemui.miui.notification.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import miui.systemui.notification.focus.views.a;
import org.xmlpull.v1.XmlPullParser;

public final class NotificationProgressDrawable
extends Drawable {
    private static final String TAG = "NotifProgressDrawable";
    private int mAlpha;
    private final Paint mFillPaint;
    private boolean mMutated;
    private final ArrayList<Part> mParts = new ArrayList();
    private final Rect mPointRect;
    private final RectF mPointRectF;
    private final RectF mSegmentRectF = new RectF();
    private State mState;
    private final Paint mStrokePaint;

    public NotificationProgressDrawable() {
        this(new Drawable.ConstantState(){
            int mChangingConfigurations;
            int mDensity = 160;
            int mFadedPointRectColor;
            int mFadedSegmentColor;
            float mFadedSegmentHeight;
            float mPointInnerRadius;
            float mPointNormalRadius;
            float mPointOuterRadius;
            float mPointRadius;
            int mPointRectColor;
            float mPointRectCornerRadius;
            float mPointRectInset;
            float mPointStrokeWidth;
            float mSegPointGap = 0.0f;
            float mSegSegGap = 0.0f;
            int mSegmentColor;
            float mSegmentCornerRadius;
            float mSegmentHeight;
            float mSegmentMinWidth = 0.0f;
            int[] mThemeAttrs;
            int[] mThemeAttrsPoints;
            int[] mThemeAttrsSegments;
            {
                int n;
                this.mChangingConfigurations = state.mChangingConfigurations;
                this.mSegSegGap = state.mSegSegGap;
                this.mSegPointGap = state.mSegPointGap;
                this.mSegmentMinWidth = state.mSegmentMinWidth;
                this.mSegmentHeight = state.mSegmentHeight;
                this.mFadedSegmentHeight = state.mFadedSegmentHeight;
                this.mSegmentCornerRadius = state.mSegmentCornerRadius;
                this.mSegmentColor = state.mSegmentColor;
                this.mFadedSegmentColor = state.mFadedSegmentColor;
                this.mPointRadius = state.mPointRadius;
                this.mPointRectInset = state.mPointRectInset;
                this.mPointRectCornerRadius = state.mPointRectCornerRadius;
                this.mPointRectColor = state.mPointRectColor;
                this.mFadedPointRectColor = state.mFadedPointRectColor;
                this.mThemeAttrs = state.mThemeAttrs;
                this.mThemeAttrsSegments = state.mThemeAttrsSegments;
                this.mThemeAttrsPoints = state.mThemeAttrsPoints;
                this.mDensity = n = NotificationProgressDrawable.resolveDensity(resources, state.mDensity);
                int n2 = state.mDensity;
                if (n2 != n) {
                    this.applyDensityScaling(n2, n);
                }
            }

            private void applyDensityScaling(int n, int n2) {
                float f = this.mSegSegGap;
                if (f > 0.0f) {
                    this.mSegSegGap = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
                if ((f = this.mSegPointGap) > 0.0f) {
                    this.mSegPointGap = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
                if ((f = this.mSegmentMinWidth) > 0.0f) {
                    this.mSegmentMinWidth = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
                if ((f = this.mSegmentHeight) > 0.0f) {
                    this.mSegmentHeight = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
                if ((f = this.mFadedSegmentHeight) > 0.0f) {
                    this.mFadedSegmentHeight = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
                if ((f = this.mSegmentCornerRadius) > 0.0f) {
                    this.mSegmentCornerRadius = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
                if ((f = this.mPointRadius) > 0.0f) {
                    this.mPointRadius = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
                if ((f = this.mPointRectInset) > 0.0f) {
                    this.mPointRectInset = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
                if ((f = this.mPointRectCornerRadius) > 0.0f) {
                    this.mPointRectCornerRadius = NotificationProgressDrawable.scaleFromDensity(f, n, n2);
                }
            }

            public boolean canApplyTheme() {
                boolean bl = this.mThemeAttrs != null || this.mThemeAttrsSegments != null || this.mThemeAttrsPoints != null || super.canApplyTheme();
                return bl;
            }

            public int getChangingConfigurations() {
                return this.mChangingConfigurations;
            }

            @NonNull
            public Drawable newDrawable() {
                return new NotificationProgressDrawable(this, null, null);
            }

            public Drawable newDrawable(@Nullable Resources resources) {
                int n = NotificationProgressDrawable.resolveDensity(resources, this.mDensity);
                State state = this;
                if (n != this.mDensity) {
                    state = new /* invalid duplicate definition of identical inner class */;
                }
                return new NotificationProgressDrawable(state, resources, null);
            }

            public void setDensity(int n) {
                int n2 = this.mDensity;
                if (n2 != n) {
                    this.mDensity = n;
                    this.applyDensityScaling(n2, n);
                }
            }

            public void setPointRectColor(int n, int n2) {
                this.mPointRectColor = n;
                this.mFadedPointRectColor = n2;
            }

            public void setSegmentColor(int n, int n2) {
                this.mSegmentColor = n;
                this.mFadedSegmentColor = n2;
            }

            @NonNull
            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("NotificationProgressDrawable.State{mSegSegGap=");
                stringBuilder.append(this.mSegSegGap);
                stringBuilder.append(", mSegPointGap=");
                stringBuilder.append(this.mSegPointGap);
                stringBuilder.append(", mSegmentMinWidth=");
                stringBuilder.append(this.mSegmentMinWidth);
                stringBuilder.append(", mSegmentHeight=");
                stringBuilder.append(this.mSegmentHeight);
                stringBuilder.append(", mFadedSegmentHeight=");
                stringBuilder.append(this.mFadedSegmentHeight);
                stringBuilder.append(", mSegmentCornerRadius=");
                stringBuilder.append(this.mSegmentCornerRadius);
                stringBuilder.append(", mPointRadius=");
                stringBuilder.append(this.mPointRadius);
                stringBuilder.append(", mPointRectInset=");
                stringBuilder.append(this.mPointRectInset);
                stringBuilder.append(", mPointRectCornerRadius=");
                stringBuilder.append(this.mPointRectCornerRadius);
                stringBuilder.append(", mThemeAttrs=");
                stringBuilder.append(Arrays.toString(this.mThemeAttrs));
                stringBuilder.append(", mThemeAttrsSegments=");
                stringBuilder.append(Arrays.toString(this.mThemeAttrsSegments));
                stringBuilder.append(", mThemeAttrsPoints=");
                stringBuilder.append(Arrays.toString(this.mThemeAttrsPoints));
                stringBuilder.append(", mDensity=");
                stringBuilder.append(this.mDensity);
                stringBuilder.append(", mSegmentColor=");
                stringBuilder.append(this.mSegmentColor);
                stringBuilder.append(", mFadedSegmentColor=");
                stringBuilder.append(this.mFadedSegmentColor);
                stringBuilder.append(", mPointRectColor=");
                stringBuilder.append(this.mPointRectColor);
                stringBuilder.append(", mFadedPointRectColor=");
                stringBuilder.append(this.mFadedPointRectColor);
                stringBuilder.append(", mPointOuterRadius=");
                stringBuilder.append(this.mPointOuterRadius);
                stringBuilder.append(", mPointNormalRadius=");
                stringBuilder.append(this.mPointNormalRadius);
                stringBuilder.append(", mPointInnerRadius=");
                stringBuilder.append(this.mPointInnerRadius);
                stringBuilder.append(", mPointStrokeWidth=");
                stringBuilder.append(this.mPointStrokeWidth);
                stringBuilder.append("}");
                return stringBuilder.toString();
            }
        }, null);
    }

    private NotificationProgressDrawable(@NonNull State state, @Nullable Resources resources) {
        Paint paint;
        this.mPointRect = new Rect();
        this.mPointRectF = new RectF();
        this.mFillPaint = paint = new Paint();
        resources = new Paint();
        this.mStrokePaint = resources;
        paint.setStyle(Paint.Style.FILL);
        resources.setStyle(Paint.Style.STROKE);
        this.mState = state;
        this.updateLocalState();
    }

    public /* synthetic */ NotificationProgressDrawable(State state, Resources resources, a a2) {
        this(state, resources);
    }

    private void applyThemeChildElements(Resources.Theme theme) {
    }

    private void debugLog(String string, String string2) {
    }

    @ColorInt
    public static int getFadedColor(@ColorInt int n) {
        return Color.argb((int)(Color.alpha((int)n) / 2), (int)Color.red((int)n), (int)Color.green((int)n), (int)Color.blue((int)n));
    }

    private static float getSegEndOffset(Part part, float f, float f2, float f3) {
        if (part == null) {
            return 0.0f;
        }
        if (!(part instanceof Point)) {
            f2 = f3;
        }
        return f2;
    }

    private static float getSegStartOffset(Part part, float f, float f2) {
        if (!(part instanceof Point)) {
            f2 = 0.0f;
        }
        return f2;
    }

    private void inflateChildElements(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n;
        int n2;
        int n3 = xmlPullParser.getDepth() + 1;
        while ((n2 = xmlPullParser.next()) != 1 && ((n = xmlPullParser.getDepth()) >= n3 || n2 != 3)) {
            if (n2 != 2 || n > n3) continue;
            String string = xmlPullParser.getName();
            if (string.equals("segments")) {
                string = Drawable.obtainAttributes((Resources)object, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.NotificationProgressDrawableSegments);
                this.updateSegmentsFromTypedArray((TypedArray)string);
                string.recycle();
                continue;
            }
            if (string.equals("points")) {
                string = Drawable.obtainAttributes((Resources)object, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.NotificationProgressDrawablePoints);
                this.updatePointsFromTypedArray((TypedArray)string);
                string.recycle();
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad element under NotificationProgressDrawable: ");
            stringBuilder.append(string);
            Log.w((String)TAG, (String)stringBuilder.toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("inflated child elements state=");
        ((StringBuilder)object).append((Object)this.mState);
        this.debugLog(TAG, ((StringBuilder)object).toString());
    }

    public static int resolveDensity(@Nullable Resources resources, int n) {
        if (resources != null) {
            n = resources.getDisplayMetrics().densityDpi;
        }
        int n2 = n;
        if (n == 0) {
            n2 = 160;
        }
        return n2;
    }

    private static float scaleFromDensity(float f, int n, int n2) {
        return f * (float)n2 / (float)n;
    }

    private static int scaleFromDensity(int n, int n2, int n3, boolean bl) {
        int n4 = n;
        if (n != 0) {
            if (n2 == n3) {
                n4 = n;
            } else {
                float f = (float)(n3 * n) / (float)n2;
                if (!bl) {
                    return (int)f;
                }
                n2 = Math.round(f);
                if (n2 != 0) {
                    return n2;
                }
                if (n > 0) {
                    return 1;
                }
                n4 = -1;
            }
        }
        return n4;
    }

    private void updateLocalState() {
    }

    private void updatePointsFromTypedArray(TypedArray typedArray) {
        State state = this.mState;
        state.mChangingConfigurations |= typedArray.getChangingConfigurations();
        state.mPointRadius = typedArray.getDimension(R.styleable.NotificationProgressDrawablePoints_radius, state.mPointRadius);
        state.mPointRectInset = typedArray.getDimension(R.styleable.NotificationProgressDrawablePoints_inset, state.mPointRectInset);
        state.mPointRectCornerRadius = typedArray.getDimension(R.styleable.NotificationProgressDrawablePoints_cornerRadius, state.mPointRectCornerRadius);
        state.mPointOuterRadius = typedArray.getDimension(R.styleable.NotificationProgressDrawablePoints_outerRadius, state.mPointOuterRadius);
        state.mPointNormalRadius = typedArray.getDimension(R.styleable.NotificationProgressDrawablePoints_normalRadius, state.mPointNormalRadius);
        state.mPointInnerRadius = typedArray.getDimension(R.styleable.NotificationProgressDrawablePoints_innerRadius, state.mPointInnerRadius);
        state.mPointStrokeWidth = typedArray.getDimension(R.styleable.NotificationProgressDrawablePoints_strokeWidth, state.mPointStrokeWidth);
        this.setPointRectDefaultColor(typedArray.getColor(R.styleable.NotificationProgressDrawablePoints_color, state.mPointRectColor), typedArray.getColor(R.styleable.NotificationProgressDrawablePoints_fadedColor, state.mFadedPointRectColor));
    }

    private void updateSegmentsFromTypedArray(TypedArray typedArray) {
        State state = this.mState;
        state.mChangingConfigurations |= typedArray.getChangingConfigurations();
        state.mSegmentMinWidth = typedArray.getDimension(R.styleable.NotificationProgressDrawableSegments_minWidth, state.mSegmentMinWidth);
        state.mSegmentHeight = typedArray.getDimension(R.styleable.NotificationProgressDrawableSegments_height, state.mSegmentHeight);
        state.mFadedSegmentHeight = typedArray.getDimension(R.styleable.NotificationProgressDrawableSegments_fadedHeight, state.mFadedSegmentHeight);
        state.mSegmentCornerRadius = typedArray.getDimension(R.styleable.NotificationProgressDrawableSegments_cornerRadius, state.mSegmentCornerRadius);
        this.setSegmentDefaultColor(typedArray.getColor(R.styleable.NotificationProgressDrawableSegments_color, state.mSegmentColor), typedArray.getColor(R.styleable.NotificationProgressDrawableSegments_fadedColor, state.mFadedSegmentColor));
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        State state = this.mState;
        state.mChangingConfigurations |= typedArray.getChangingConfigurations();
        state.mSegSegGap = typedArray.getDimension(R.styleable.NotificationProgressDrawable_segSegGap, state.mSegSegGap);
        state.mSegPointGap = typedArray.getDimension(R.styleable.NotificationProgressDrawable_segPointGap, state.mSegPointGap);
    }

    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        State state = this.mState;
        if (state == null) {
            return;
        }
        state.setDensity(NotificationProgressDrawable.resolveDensity(theme.getResources(), 0));
        this.applyThemeChildElements(theme);
        this.updateLocalState();
    }

    public boolean canApplyTheme() {
        boolean bl = this.mState.canApplyTheme() || super.canApplyTheme();
        return bl;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public void draw(@NonNull Canvas canvas) {
        Object object = this.mState;
        float f = object.mPointRadius;
        float f2 = object.mPointOuterRadius;
        float f3 = object.mPointNormalRadius;
        float f4 = object.mPointInnerRadius;
        float f5 = this.getBounds().left;
        float f6 = this.getBounds().centerY();
        float f7 = this.getBounds().width();
        int n = this.mParts.size();
        float f8 = f7 - f * 2.0f * (float)(n >> 1);
        object = new StringBuilder();
        ((StringBuilder)object).append("draw: x=");
        ((StringBuilder)object).append(f5);
        ((StringBuilder)object).append(" totalWidth=");
        ((StringBuilder)object).append(f7);
        ((StringBuilder)object).append(" numParts=");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" segmentTotalWidth=");
        ((StringBuilder)object).append(f8);
        ((StringBuilder)object).append(" segmentColor=");
        ((StringBuilder)object).append(this.mState.mSegmentColor);
        Object object2 = ((StringBuilder)object).toString();
        object = TAG;
        this.debugLog(TAG, (String)object2);
        int n2 = 0;
        while (n2 < n) {
            float f9;
            Part part = this.mParts.get(n2);
            object2 = n2 == 0 ? null : this.mParts.get(n2 - 1);
            int n3 = n2 + 1;
            if (n3 == n) {
                Object var23_24 = null;
            } else {
                Part part2 = this.mParts.get(n3);
            }
            if (part instanceof Segment) {
                void var23_26;
                part = part;
                f7 = (part).mFraction * f8;
                f9 = (part).mFilledProgress * f8;
                float f10 = NotificationProgressDrawable.getSegStartOffset(object2, f, this.mState.mSegPointGap) + f5;
                object2 = this.mState;
                float f11 = NotificationProgressDrawable.getSegEndOffset(var23_26, f, object2.mSegPointGap, object2.mSegSegGap);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(" draw seg=");
                ((StringBuilder)object2).append(part);
                ((StringBuilder)object2).append(" cal: start=");
                ((StringBuilder)object2).append(f10);
                ((StringBuilder)object2).append(" segWidth=");
                ((StringBuilder)object2).append(f7);
                ((StringBuilder)object2).append(" endOffset=");
                ((StringBuilder)object2).append(f11);
                ((StringBuilder)object2).append(" segFilledWidth=");
                ((StringBuilder)object2).append(f9);
                this.debugLog((String)object, ((StringBuilder)object2).toString());
                float f12 = (f7 += f5) - f11;
                if (!(f10 > f12)) {
                    f5 = (part).mFaded ? this.mState.mFadedSegmentHeight : this.mState.mSegmentHeight;
                    float f13 = f5 / 2.0f;
                    float f14 = this.mState.mSegmentCornerRadius;
                    f5 = f6 - f13;
                    this.mSegmentRectF.set(f10, f5, f12, f13 += f6);
                    n2 = (part).mColor != 0 ? (part).mColor : this.mState.mSegmentColor;
                    object2 = this.mFillPaint;
                    if ((part).mFaded) {
                        n2 = this.mState.mFadedSegmentColor;
                    }
                    object2.setColor(n2);
                    canvas.drawRoundRect(this.mSegmentRectF, f14, f14, this.mFillPaint);
                    if (f9 > 0.0f) {
                        this.mSegmentRectF.set(f10, f5, f9 + f10 - f11, f13);
                        object2 = this.mFillPaint;
                        n2 = (part).mColor != 0 ? (part).mColor : this.mState.mSegmentColor;
                        object2.setColor(n2);
                        canvas.drawRoundRect(this.mSegmentRectF, f14, f14, this.mFillPaint);
                    }
                    f5 = f7;
                }
            } else if (part instanceof Point) {
                f7 = f5 + f;
                object2 = part;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" draw Point Rect=");
                stringBuilder.append(this.mPointRect);
                stringBuilder.append(" point=");
                stringBuilder.append(object2);
                stringBuilder.append("");
                this.debugLog((String)object, stringBuilder.toString());
                if ((object2).mIcon != null) {
                    this.mPointRect.set((int)(f7 - f), (int)(f6 - f), (int)(f7 + f), (int)(f6 + f));
                    (object2).mIcon.setBounds(this.mPointRect);
                    (object2).mIcon.draw(canvas);
                } else {
                    int n4 = (object2).mPhase;
                    f5 = n4 == 0 ? f2 : f3;
                    this.mPointRect.set((int)(f7 - f5), (int)(f6 - f5), (int)(f7 + f5), (int)(f5 + f6));
                    this.mPointRectF.set(this.mPointRect);
                    State state = this.mState;
                    f5 = state.mPointRectInset;
                    f9 = state.mPointRectCornerRadius;
                    this.mPointRectF.inset(f5, f5);
                    n2 = (object2).mColor != 0 ? (object2).mColor : this.mState.mPointRectColor;
                    Paint paint = this.mFillPaint;
                    int n5 = (object2).mFaded ? this.mState.mFadedPointRectColor : n2;
                    paint.setColor(n5);
                    Paint paint2 = this.mStrokePaint;
                    if ((object2).mFaded) {
                        n2 = this.mState.mFadedPointRectColor;
                    }
                    paint2.setColor(n2);
                    this.mStrokePaint.setStrokeWidth(this.mState.mPointStrokeWidth);
                    if (n4 < 0) {
                        canvas.drawCircle(f7, f6, f3, this.mFillPaint);
                    } else if (n4 == 0) {
                        canvas.drawArc(this.mPointRectF, 0.0f, 360.0f, true, this.mStrokePaint);
                        canvas.drawCircle(f7, f6, f4, this.mFillPaint);
                    } else {
                        canvas.drawArc(this.mPointRectF, 0.0f, 360.0f, true, this.mStrokePaint);
                    }
                }
                f5 = f7 + f;
            }
            n2 = n3;
        }
        return;
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getChangingConfigurations() {
        int n = super.getChangingConfigurations();
        return this.mState.getChangingConfigurations() | n;
    }

    public Drawable.ConstantState getConstantState() {
        this.mState.mChangingConfigurations = this.getChangingConfigurations();
        return this.mState;
    }

    public int getOpacity() {
        return 0;
    }

    public void inflate(@NonNull Resources object, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        super.inflate((Resources)object, xmlPullParser, attributeSet, theme);
        this.mState.setDensity(NotificationProgressDrawable.resolveDensity((Resources)object, 0));
        TypedArray typedArray = Drawable.obtainAttributes((Resources)object, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.NotificationProgressDrawable);
        this.updateStateFromTypedArray(typedArray);
        typedArray.recycle();
        this.inflateChildElements((Resources)object, xmlPullParser, attributeSet, theme);
        this.updateLocalState();
        object = new StringBuilder();
        ((StringBuilder)object).append("inflated state=");
        ((StringBuilder)object).append((Object)this.mState);
        this.debugLog(TAG, ((StringBuilder)object).toString());
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState = new /* invalid duplicate definition of identical inner class */;
            this.updateLocalState();
            this.mMutated = true;
        }
        return this;
    }

    public void setAlpha(int n) {
        if (this.mAlpha != n) {
            this.mAlpha = n;
            this.invalidateSelf();
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void setParts(List<Part> list) {
        this.mParts.clear();
        this.mParts.addAll(list);
        this.invalidateSelf();
    }

    public void setParts(Part ... partArray) {
        this.setParts(Arrays.asList(partArray));
    }

    public void setPointRectDefaultColor(@ColorInt int n, @ColorInt int n2) {
        this.mState.setPointRectColor(n, n2);
    }

    public void setSegmentDefaultColor(@ColorInt int n, @ColorInt int n2) {
        this.mState.setSegmentColor(n, n2);
    }
}
