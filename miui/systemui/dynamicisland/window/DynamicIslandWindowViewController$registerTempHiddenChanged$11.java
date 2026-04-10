/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.util.Log
 *  f1.E
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.o;
import android.util.Log;
import f1.E;
import i1.g;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$registerTempHiddenChanged$11", f="DynamicIslandWindowViewController.kt", l={508}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.registerTempHiddenChanged.11
extends l
implements o {
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.registerTempHiddenChanged.11(DynamicIslandWindowViewController dynamicIslandWindowViewController, d d2) {
        this.this$0 = dynamicIslandWindowViewController;
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
            object = this.this$0.fullScreenPkg;
            g g2 = new g(this.this$0){
                final DynamicIslandWindowViewController this$0;
                {
                    this.this$0 = dynamicIslandWindowViewController;
                }

                public final Object emit(String string, d object) {
                    DynamicIslandEventCoordinator dynamicIslandEventCoordinator = DynamicIslandWindowViewController.access$getView(this.this$0).getEventCoordinator();
                    if (dynamicIslandEventCoordinator == null) {
                        return s.a;
                    }
                    object = this.this$0;
                    Object object2 = dynamicIslandEventCoordinator.getLastFullScreenActivityPkg();
                    if (((DynamicIslandWindowViewController)object).isInMiniWindow((String)object2, b.c((int)DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).getCurrentUserId()))) {
                        Object object3 = new StringBuilder();
                        object3.append("fullscreen_to_mini_freeform state: ");
                        object3.append((String)object2);
                        Log.d((String)"DynamicIslandAnimDebug", (String)object3.toString());
                        DynamicIslandWindowViewController.access$cancelDelayOperate((DynamicIslandWindowViewController)object, (String)object2);
                        object2 = DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).requestHasIsland((String)object2);
                        if (object2 != null) {
                            object2 = object2.iterator();
                            while (object2.hasNext()) {
                                object3 = (DynamicIslandContentView)((Object)object2.next());
                                DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object), (DynamicIslandContentView)((Object)object3), true, null, 4, null);
                                DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).enterMiniWindow((DynamicIslandContentView)((Object)object3));
                                DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).onWindowAnimExtendLifetimeEnd((DynamicIslandContentView)((Object)object3));
                            }
                        }
                    }
                    dynamicIslandEventCoordinator.setLastFullScreenActivityPkg(string);
                    object = dynamicIslandEventCoordinator.getExpandedStateHandler().getCurrent();
                    if (object != null) {
                        if (!((DynamicIslandBaseContentView)((Object)object)).getHideByFullScreenPkg()) {
                            object = null;
                        }
                        if (object != null) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("refresh miniBar by fullScreen pkg = ");
                            ((StringBuilder)object2).append(string);
                            Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object2).toString());
                            dynamicIslandEventCoordinator.updateMiniBar((DynamicIslandContentView)((Object)object));
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
