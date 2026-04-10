/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.jvm.internal.o
 *  miuix.mipalette.MiPalette
 */
package miui.systemui.dynamicisland.module.utils;

import android.util.Log;
import kotlin.jvm.internal.o;
import miuix.mipalette.MiPalette;

public final class MiPaletteUtils {
    public static final MiPaletteUtils INSTANCE = new MiPaletteUtils();
    private static final String TAG = "MiPaletteUtils";

    private MiPaletteUtils() {
    }

    public final int getPaletteColorSafe(int n, String string, int n2) {
        o.g((Object)string, (String)"scheme");
        try {
            int n3;
            n = n3 = MiPalette.getPaletteColor((int)n, (String)string, (int)n2);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getPaletteColor failed: scheme=");
            stringBuilder.append(string);
            stringBuilder.append(", toneIndex=");
            stringBuilder.append(n2);
            Log.w((String)TAG, (String)stringBuilder.toString(), (Throwable)exception);
        }
        catch (NullPointerException nullPointerException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getPaletteColor NPE: scheme=");
            stringBuilder.append(string);
            stringBuilder.append(", toneIndex=");
            stringBuilder.append(n2);
            Log.w((String)TAG, (String)stringBuilder.toString(), (Throwable)nullPointerException);
        }
        return n;
    }
}
