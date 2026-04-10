/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  H0.e
 *  X0.b
 *  android.view.View
 *  android.view.ViewGroup
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.display;

import H0.e;
import X0.b;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.o;

public final class AntiBurnInManagerKt {
    public static final List<View> findAllViewsById(ViewGroup viewGroup, int n) {
        o.g((Object)viewGroup, (String)"<this>");
        ArrayList<View> arrayList = new ArrayList<View>();
        e e2 = new e();
        e2.add((Object)viewGroup);
        while (!e2.isEmpty()) {
            viewGroup = (View)e2.removeFirst();
            if (viewGroup.getId() == n) {
                arrayList.add((View)viewGroup);
            }
            if (!(viewGroup instanceof ViewGroup)) continue;
            int n2 = viewGroup.getChildCount();
            for (int i = 0; i < n2; ++i) {
                View view = viewGroup.getChildAt(i);
                o.f((Object)view, (String)"getChildAt(...)");
                e2.add((Object)view);
            }
        }
        return arrayList;
    }

    public static final int toExposedUnit(long l) {
        return b.a((double)((double)l / 1000.0));
    }
}
