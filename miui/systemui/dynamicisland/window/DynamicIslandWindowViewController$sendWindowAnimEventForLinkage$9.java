/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  miui.systemui.settings.data.repository.WorkBenchModeRepository
 *  miui.systemui.util.CommonUtils
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
import java.util.Iterator;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.WindowAnimState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.settings.data.repository.WorkBenchModeRepository;
import miui.systemui.util.CommonUtils;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForLinkage$9", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.9
extends l
implements o {
    final boolean $isFreeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.9(DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl, String string, d d2) {
        this.this$0 = dynamicIslandWindowViewController;
        this.$isFreeform = bl;
        this.$pkg = string;
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
            DynamicIslandWindowViewController.setPositionValue$default(this.this$0, false, false, 2, null);
            if (this.$isFreeform) {
                this.this$0.get_isFreeformAnimRunning().setValue((Object)b.a((boolean)false));
            } else {
                this.this$0.get_isAppAnimRunning().setValue((Object)b.a((boolean)false));
            }
            object = this.$pkg;
            object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object) : null;
            if (object == null || object.isEmpty()) {
                DynamicIslandWindowViewController.access$getView(this.this$0).hideAllElementSurface();
            }
            WindowAnimState.Closed closed = new WindowAnimState.Closed(this.$isFreeform, false, false, 4, null);
            if (object != null) {
                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                String string = this.$pkg;
                boolean bl = this.$isFreeform;
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                    object = new StringBuilder();
                    ((StringBuilder)object).append("close_app_no_anim state = ");
                    ((StringBuilder)object).append((Object)dynamicIslandContentView);
                    Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                    if (dynamicIslandContentView != null) {
                        dynamicIslandContentView.setWindowAnimState(closed);
                    }
                    dynamicIslandWindowViewController.getAppCloseRealIslandRect(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).calculateCollapse(dynamicIslandContentView), dynamicIslandContentView, string, bl);
                    if (dynamicIslandContentView != null) {
                        dynamicIslandContentView.setVisibility(0);
                    }
                    object = dynamicIslandContentView != null ? dynamicIslandContentView.getBackgroundView() : null;
                    if (object != null) {
                        ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
                    }
                    DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).updateIslandWindowAnimRunningState(false, dynamicIslandContentView, bl);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                    if (CommonUtils.INSTANCE.getIS_TABLET() && ((Boolean)((WorkBenchModeRepository)dynamicIslandWindowViewController.workBenchModeRepository.get()).isWorkbenchModeEnabled().getValue()).booleanValue()) {
                        object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                        if (object instanceof DynamicIslandState.MiniWindowExpanded) {
                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).updateFreeformFakeView(dynamicIslandContentView);
                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).exitMiniWindow(dynamicIslandContentView);
                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindowEnd();
                            continue;
                        }
                        if (!(object instanceof DynamicIslandState.AppExpanded)) continue;
                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appExit(dynamicIslandContentView);
                        object = dynamicIslandContentView.getFakeView();
                        if (object != null) {
                            object.setAlpha(1.0f);
                        }
                        object = dynamicIslandContentView.getFakeView();
                        if (object != null) {
                            object.setVisibility(0);
                        }
                        dynamicIslandContentView.setOpenAppFromIsland(false);
                        continue;
                    }
                    if (bl) {
                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).exitMiniWindow(dynamicIslandContentView);
                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindowEnd();
                        continue;
                    }
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appExit(dynamicIslandContentView);
                    if (dynamicIslandContentView == null) continue;
                    dynamicIslandContentView.setOpenAppFromIsland(false);
                }
            }
            DynamicIslandWindowViewController.access$getView(this.this$0).setAnimRunning(false, this.$isFreeform);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
