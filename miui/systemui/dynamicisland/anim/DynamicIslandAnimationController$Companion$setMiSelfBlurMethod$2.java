/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.util.Log
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.anim;

import U0.a;
import android.util.Log;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.p;

public static final class DynamicIslandAnimationController.Companion.setMiSelfBlurMethod.2
extends p
implements a {
    public static final DynamicIslandAnimationController.Companion.setMiSelfBlurMethod.2 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final Method invoke() {
        GenericDeclaration genericDeclaration;
        try {
            genericDeclaration = Class.forName("android.view.View");
            genericDeclaration = genericDeclaration.getMethod("setMiSelfBlur", Integer.TYPE, ArrayList.class);
        }
        catch (Throwable throwable) {
            Log.e((String)"DynamicIslandAnimDebug", (String)"Get setMiSelfBlur method failed.", (Throwable)throwable);
            genericDeclaration = null;
        }
        return genericDeclaration;
    }
}
