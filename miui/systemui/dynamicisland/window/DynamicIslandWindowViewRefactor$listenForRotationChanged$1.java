/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.content.res.Configuration
 *  f1.E
 *  i1.I
 *  i1.g
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
import android.content.res.Configuration;
import f1.E;
import i1.I;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor;
import miui.systemui.util.CommonUtils;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor$listenForRotationChanged$1", f="DynamicIslandWindowViewRefactor.kt", l={96}, m="invokeSuspend")
public static final class DynamicIslandWindowViewRefactor.listenForRotationChanged.1
extends l
implements U0.o {
    int label;
    final DynamicIslandWindowViewRefactor this$0;

    public DynamicIslandWindowViewRefactor.listenForRotationChanged.1(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor, d d2) {
        this.this$0 = dynamicIslandWindowViewRefactor;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)g2);
        } else {
            k.b((Object)g2);
            I i = this.this$0.configurationRepository.getDefaultDisplayRotation();
            g2 = new g(this.this$0){
                final DynamicIslandWindowViewRefactor this$0;
                {
                    this.this$0 = dynamicIslandWindowViewRefactor;
                }

                public final Object emit(int n, d object) {
                    if (CommonUtils.INSTANCE.getIS_TABLET()) {
                        if (DynamicIslandWindowViewRefactor.access$getLastRotation$p(this.this$0) == 1 && n == 3 || DynamicIslandWindowViewRefactor.access$getLastRotation$p(this.this$0) == 3 && n == 1) {
                            object = DynamicIslandWindowViewRefactor.access$getWindowView$p(this.this$0).getWindowViewController();
                            Configuration configuration = DynamicIslandWindowViewRefactor.access$getContext$p(this.this$0).getResources().getConfiguration();
                            o.f((Object)configuration, (String)"getConfiguration(...)");
                            ((DynamicIslandWindowViewController)object).onConfigChanged(configuration);
                        }
                        DynamicIslandWindowViewRefactor.access$setLastRotation$p(this.this$0, n);
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (i.collect(g2, (d)this) == object) {
                return object;
            }
        }
        throw new G0.c();
    }
}
