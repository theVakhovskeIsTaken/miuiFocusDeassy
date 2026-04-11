/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.annotation.ColorInt
 *  androidx.annotation.Nullable
 */
package miui.systemui.notification.focus.views;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Objects;
import miui.systemui.notification.focus.views.NotificationProgressDrawable;

public static final class NotificationProgressDrawable.Segment
implements NotificationProgressDrawable.Part {
    @ColorInt
    private final int mColor;
    private final boolean mFaded;
    private final float mFilledProgress;
    private final float mFraction;

    public NotificationProgressDrawable.Segment(float f) {
        this(f, 0);
    }

    public NotificationProgressDrawable.Segment(float f, @ColorInt int n) {
        this(f, n, false, 0.0f);
    }

    public NotificationProgressDrawable.Segment(float f, @ColorInt int n, boolean bl, float f2) {
        this.mFraction = f;
        this.mColor = n;
        this.mFaded = bl;
        this.mFilledProgress = f2;
    }

    public static /* bridge */ /* synthetic */ int a(NotificationProgressDrawable.Segment segment) {
        return segment.mColor;
    }

    public static /* bridge */ /* synthetic */ boolean b(NotificationProgressDrawable.Segment segment) {
        return segment.mFaded;
    }

    public static /* bridge */ /* synthetic */ float c(NotificationProgressDrawable.Segment segment) {
        return segment.mFilledProgress;
    }

    public static /* bridge */ /* synthetic */ float d(NotificationProgressDrawable.Segment segment) {
        return segment.mFraction;
    }

    public boolean equals(@Nullable Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object != null && NotificationProgressDrawable.Segment.class == object.getClass()) {
            object = object;
            if (Float.compare(this.mFraction, (object).mFraction) != 0) {
                return false;
            }
            if (this.mColor != (object).mColor) {
                return false;
            }
            if (this.mFaded != (object).mFaded) {
                bl = false;
            }
            return bl;
        }
        return false;
    }

    public int getColor() {
        return this.mColor;
    }

    public boolean getFaded() {
        return this.mFaded;
    }

    public float getFraction() {
        return this.mFraction;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.mFraction), this.mColor, this.mFaded);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Segment(fraction=");
        stringBuilder.append(this.mFraction);
        stringBuilder.append(", color=");
        stringBuilder.append(this.mColor);
        stringBuilder.append(", faded=");
        stringBuilder.append(this.mFaded);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
