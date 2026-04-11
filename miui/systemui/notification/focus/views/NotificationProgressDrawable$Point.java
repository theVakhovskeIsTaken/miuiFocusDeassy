/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  androidx.annotation.ColorInt
 *  androidx.annotation.Nullable
 */
package miui.systemui.notification.focus.views;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Objects;
import miui.systemui.notification.focus.views.NotificationProgressDrawable;

public static final class NotificationProgressDrawable.Point
implements NotificationProgressDrawable.Part {
    @ColorInt
    private final int mColor;
    private final boolean mFaded;
    @Nullable
    private final Drawable mIcon;
    private final int mPhase;

    public NotificationProgressDrawable.Point(@Nullable Drawable drawable) {
        this(drawable, 0, false, 1);
    }

    public NotificationProgressDrawable.Point(@Nullable Drawable drawable, @ColorInt int n, int n2) {
        this(drawable, n, false, n2);
    }

    public NotificationProgressDrawable.Point(@Nullable Drawable drawable, @ColorInt int n, boolean bl, int n2) {
        this.mIcon = drawable;
        this.mColor = n;
        this.mFaded = bl;
        this.mPhase = n2;
    }

    public static /* bridge */ /* synthetic */ int a(NotificationProgressDrawable.Point point) {
        return point.mColor;
    }

    public static /* bridge */ /* synthetic */ boolean b(NotificationProgressDrawable.Point point) {
        return point.mFaded;
    }

    public static /* bridge */ /* synthetic */ Drawable c(NotificationProgressDrawable.Point point) {
        return point.mIcon;
    }

    public static /* bridge */ /* synthetic */ int d(NotificationProgressDrawable.Point point) {
        return point.mPhase;
    }

    public boolean equals(@Nullable Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object != null && NotificationProgressDrawable.Point.class == object.getClass()) {
            object = object;
            if (!Objects.equals(this.mIcon, (object).mIcon)) {
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

    @Nullable
    public Drawable getIcon() {
        return this.mIcon;
    }

    public int hashCode() {
        return Objects.hash(this.mIcon, this.mColor, this.mFaded);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Point(icon=");
        stringBuilder.append(this.mIcon);
        stringBuilder.append(", color=");
        stringBuilder.append(this.mColor);
        stringBuilder.append(", faded=");
        stringBuilder.append(this.mFaded);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
