/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;

public final class DynamicIslandEmptyContentView
extends View {
    public DynamicIslandEmptyContentView(Context context) {
        o.g((Object)context, (String)"context");
        this(context, null, 0, 0, 14, null);
    }

    public DynamicIslandEmptyContentView(Context context, AttributeSet attributeSet) {
        o.g((Object)context, (String)"context");
        this(context, attributeSet, 0, 0, 12, null);
    }

    public DynamicIslandEmptyContentView(Context context, AttributeSet attributeSet, int n) {
        o.g((Object)context, (String)"context");
        this(context, attributeSet, n, 0, 8, null);
    }

    public DynamicIslandEmptyContentView(Context context, AttributeSet attributeSet, int n, int n2) {
        o.g((Object)context, (String)"context");
        super(context, attributeSet, n, n2);
    }

    public /* synthetic */ DynamicIslandEmptyContentView(Context context, AttributeSet attributeSet, int n, int n2, int n3, h h2) {
        if ((n3 & 2) != 0) {
            attributeSet = null;
        }
        if ((n3 & 4) != 0) {
            n = 0;
        }
        if ((n3 & 8) != 0) {
            n2 = 0;
        }
        this(context, attributeSet, n, n2);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.setWillNotDraw(true);
    }
}
