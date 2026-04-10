/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Icon
 *  android.net.Uri
 *  androidx.core.graphics.drawable.RoundedBitmapDrawable
 *  androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.o;

public final class DynamicIslandShareUtils {
    public static final DynamicIslandShareUtils INSTANCE = new DynamicIslandShareUtils();

    private DynamicIslandShareUtils() {
    }

    public static /* synthetic */ RoundedBitmapDrawable drawableAddRounded$default(DynamicIslandShareUtils dynamicIslandShareUtils, Context context, Drawable drawable, int n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 0;
        }
        return dynamicIslandShareUtils.drawableAddRounded(context, drawable, n);
    }

    public final byte[] bitmapToByteArray(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final byte[] compressImageUnder32KB(Bitmap bitmap) {
        byte[] byArray;
        int n;
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = 100;
        do {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, n2, (OutputStream)byteArrayOutputStream);
            byArray = byteArrayOutputStream.toByteArray();
            o.f((Object)byArray, (String)"toByteArray(...)");
            n = n2 - 10;
            if (byArray.length <= 32768) break;
            n2 = n;
        } while (n > 10);
        return byArray;
    }

    public final RoundedBitmapDrawable drawableAddRounded(Context context, Drawable drawable, int n) {
        o.g((Object)context, (String)"context");
        if (drawable == null) {
            return null;
        }
        drawable = this.drawableToBitmap(drawable);
        context = RoundedBitmapDrawableFactory.create((Resources)context.getResources(), (Bitmap)drawable);
        context.setCornerRadius((float)(n * 2));
        context.setAntiAlias(true);
        return context;
    }

    public final Bitmap drawableToBitmap(Drawable drawable) {
        BitmapDrawable bitmapDrawable;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable && (bitmapDrawable = (BitmapDrawable)drawable).getBitmap() != null) {
            return bitmapDrawable.getBitmap();
        }
        bitmapDrawable = drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0 ? Bitmap.createBitmap((int)drawable.getIntrinsicWidth(), (int)drawable.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888) : Bitmap.createBitmap((int)1, (int)1, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas((Bitmap)bitmapDrawable);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapDrawable;
    }

    public final byte[] iconToByteArrayAndCompress(Icon icon, Context context) {
        o.g((Object)context, (String)"context");
        if (icon == null) {
            return null;
        }
        return this.compressImageUnder32KB(this.drawableToBitmap(icon.loadDrawable(context)));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isProviderAccessible(Context context, Uri object) {
        String string;
        boolean bl;
        block4: {
            o.g((Object)context, (String)"context");
            o.g((Object)object, (String)"uri");
            bl = false;
            try {
                string = object.getAuthority();
                if (string != null) break block4;
                return false;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return bl;
            }
        }
        context = context.getPackageManager().resolveContentProvider(string, 0);
        if (context == null) return bl;
        return true;
    }
}
