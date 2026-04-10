/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.util.CommonUtils;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$onUserChanged$1", f="DynamicIslandWindowView.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowView.onUserChanged.1
extends l
implements U0.o {
    final int $newUser;
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.onUserChanged.1(DynamicIslandWindowView dynamicIslandWindowView, int n, d d2) {
        this.this$0 = dynamicIslandWindowView;
        this.$newUser = n;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            Object object22 = new ArrayList(this.this$0.dynamicIslandDataList);
            object = this.this$0;
            object22 = object22.iterator();
            while (object22.hasNext()) {
                ((DynamicIslandWindowView)((Object)object)).removeDynamicIslandData((DynamicIslandData)object22.next(), CommonUtils.INSTANCE.getIS_TABLET(), false);
            }
            this.this$0.setCurrentUserId(this.$newUser);
            object = this.this$0.dynamicIslandDataList.iterator();
            while (object.hasNext()) {
                object22 = ((DynamicIslandData)object.next()).getProperties();
                if (object22 == null || object22.intValue() != 0) continue;
                object.remove();
            }
            object22 = new ArrayList(this.this$0.dynamicIslandDataList);
            object = this.this$0;
            for (Object object22 : object22) {
                o.d((Object)object22);
                ((DynamicIslandWindowView)((Object)object)).addDynamicIslandData((DynamicIslandData)object22, false, ((DynamicIslandWindowView)((Object)object)).getWindowViewController().getIslandMaxWidth(), ((DynamicIslandWindowView)((Object)object)).getWindowViewController().getCutoutY(), false);
            }
            object = this.this$0;
            ((DynamicIslandWindowView)((Object)object)).onDeviceNotificationChanged(((DynamicIslandWindowView)((Object)object)).hasDeviceNotification());
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
