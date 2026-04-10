/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.value.b
 *  com.airbnb.lottie.value.c
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.module;

import com.airbnb.lottie.value.b;
import com.airbnb.lottie.value.c;
import kotlin.jvm.internal.o;

public static final class IslandIconViewHolder.GradientLottieValueCallback
extends c {
    public static final IslandIconViewHolder.GradientLottieValueCallback INSTANCE = new IslandIconViewHolder.GradientLottieValueCallback();

    private IslandIconViewHolder.GradientLottieValueCallback() {
    }

    public Integer[] getValue(b object) {
        o.g((Object)object, (String)"frameInfo");
        object = Companion;
        return new Integer[]{object.getGradientTopColor(), object.getGradientBottomColor()};
    }
}
