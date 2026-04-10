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
 *  f1.E
 *  i1.g
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import f1.E;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor$listenForOrientationChanged$1", f="DynamicIslandWindowViewRefactor.kt", l={84}, m="invokeSuspend")
public static final class DynamicIslandWindowViewRefactor.listenForOrientationChanged.1
extends l
implements o {
    int label;
    final DynamicIslandWindowViewRefactor this$0;

    public DynamicIslandWindowViewRefactor.listenForOrientationChanged.1(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor, d d2) {
        this.this$0 = dynamicIslandWindowViewRefactor;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)object);
        } else {
            k.b((Object)object);
            object = this.this$0.configurationRepository.getOrientationChanged();
            g g2 = new g(this.this$0){
                final DynamicIslandWindowViewRefactor this$0;
                {
                    this.this$0 = dynamicIslandWindowViewRefactor;
                }

                public final Object emit(s object, d object2) {
                    object = DynamicIslandWindowViewRefactor.access$getWindowView$p(this.this$0).getFakeViews();
                    object2 = object.iterator();
                    while (object2.hasNext()) {
                        object = (DynamicIslandContentFakeView)((Object)object2.next());
                        object.suppressLayout(false);
                    }
                    if (CommonUtils.INSTANCE.getIS_TABLET()) {
                        object = DynamicIslandWindowViewRefactor.access$getWindowView$p(this.this$0).getContentViews();
                        object = object.iterator();
                        while (object.hasNext()) {
                            object2 = (DynamicIslandContentView)((Object)object.next());
                            ((DynamicIslandBaseContentView)((Object)object2)).calculateBigIslandY();
                        }
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) == object2) {
                return object2;
            }
        }
        throw new G0.c();
    }
}
