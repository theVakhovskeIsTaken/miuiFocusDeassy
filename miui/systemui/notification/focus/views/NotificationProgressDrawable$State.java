/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 */
package miui.systemui.notification.focus.views;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import miui.systemui.notification.focus.views.NotificationProgressDrawable;

public static final class NotificationProgressDrawable.State
extends Drawable.ConstantState {
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

    public NotificationProgressDrawable.State() {
    }

    public NotificationProgressDrawable.State(@NonNull NotificationProgressDrawable.State state, @Nullable Resources resources) {
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
        NotificationProgressDrawable.State state = this;
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
}
