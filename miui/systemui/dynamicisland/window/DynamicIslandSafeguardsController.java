/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.c
 *  G0.d
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.o
 *  android.util.Log
 *  f1.E
 *  f1.f
 *  i1.I
 *  i1.g
 *  kotlin.jvm.internal.E
 *  kotlin.jvm.internal.o
 *  miui.systemui.dagger.qualifiers.Main
 *  miui.systemui.util.ConvenienceExtensionsKt
 *  miui.systemui.util.concurrency.DelayableExecutor
 */
package miui.systemui.dynamicisland.window;

import D0.a;
import G0.c;
import G0.k;
import G0.s;
import android.util.Log;
import i1.I;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.o;
import miui.systemui.dagger.qualifiers.Main;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.WindowAnimState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.d;
import miui.systemui.dynamicisland.window.e;
import miui.systemui.dynamicisland.window.f;
import miui.systemui.dynamicisland.window.g;
import miui.systemui.dynamicisland.window.h;
import miui.systemui.dynamicisland.window.i;
import miui.systemui.dynamicisland.window.j;
import miui.systemui.util.ConvenienceExtensionsKt;
import miui.systemui.util.concurrency.DelayableExecutor;

@DynamicIslandScope
public final class DynamicIslandSafeguardsController
implements DynamicIslandStartable {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final long DELAY_TIME = 150L;
    private static final long DELAY_TIME_WHEN_WINDOW_ANIMATION = 1000L;
    private static final String TAG = "DynamicIslandSafeguardsController";
    private String currentDelayEnterAppPkg;
    private String currentDelayEnterMiniWindowPkg;
    private String currentDelayExitAppPkg;
    private String currentDelayExitMiniWindowPkg;
    private String fullScreenPkg;
    private HashMap<String, Runnable> onDelayCancelMap;
    private Runnable onDelayCollapsed;
    private Runnable onDelayEnterApp;
    private Runnable onDelayEnterMiniWindow;
    private Runnable onDelayExitApp;
    private Runnable onDelayExitMiniWindow;
    private Runnable onResetWindowAnimationState;
    private final f1.E scope;
    private DelayableExecutor uiExecutor;
    private final DynamicIslandWindowView windowView;
    private final G0.d windowViewController$delegate;

    public DynamicIslandSafeguardsController(DynamicIslandWindowView dynamicIslandWindowView, @Main DelayableExecutor delayableExecutor, @DynamicIsland f1.E e, a a2) {
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)delayableExecutor, (String)"uiExecutor");
        o.g((Object)e, (String)"scope");
        o.g((Object)a2, (String)"windowViewControllerLazy");
        this.windowView = dynamicIslandWindowView;
        this.uiExecutor = delayableExecutor;
        this.scope = e;
        this.windowViewController$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a2);
        this.onDelayCancelMap = new HashMap();
        this.fullScreenPkg = "";
    }

    public static /* synthetic */ void a(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        DynamicIslandSafeguardsController.delayCollapsed$lambda$3(dynamicIslandSafeguardsController);
    }

    public static final /* synthetic */ DynamicIslandWindowViewController access$getWindowViewController(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        return dynamicIslandSafeguardsController.getWindowViewController();
    }

    public static /* synthetic */ void b(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, String string) {
        DynamicIslandSafeguardsController.delayExitApp$lambda$14(dynamicIslandSafeguardsController, string);
    }

    public static /* synthetic */ void c(String string, DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        DynamicIslandSafeguardsController.delayEnterApp$lambda$17(string, dynamicIslandSafeguardsController);
    }

    private final void cancelDelayDeleted(String string) {
        Log.d((String)TAG, (String)"cancelDelayDeleted");
        Runnable runnable = (Runnable)this.onDelayCancelMap.get(string);
        if (runnable != null) {
            runnable.run();
        }
        E.d(this.onDelayCancelMap).remove(string);
    }

    public static /* synthetic */ void d(String string, DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        DynamicIslandSafeguardsController.delayDeleted$lambda$1(string, dynamicIslandSafeguardsController);
    }

    private static final void delayCollapsed$lambda$3(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        o.g((Object)dynamicIslandSafeguardsController, (String)"this$0");
        boolean bl = dynamicIslandSafeguardsController.windowView.isUserExpanded();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDelayCollapsed");
        stringBuilder.append(bl);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (!dynamicIslandSafeguardsController.windowView.isUserExpanded()) {
            dynamicIslandSafeguardsController.windowView.collapse("delay");
        }
    }

    private static final void delayDeleted$lambda$1(String string, DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        o.g((Object)dynamicIslandSafeguardsController, (String)"this$0");
        if (string != null) {
            DynamicIslandWindowViewController.DynamicIslandCallback dynamicIslandCallback = dynamicIslandSafeguardsController.getWindowViewController().getDynamicIslandCallback();
            if (dynamicIslandCallback != null) {
                dynamicIslandCallback.onDynamicIslandTimeoutRemoved(string);
            }
            dynamicIslandSafeguardsController.getWindowViewController().removeDynamicIslandView(string);
        }
    }

    public static /* synthetic */ void delayEnterApp$default(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, DynamicIslandContentView dynamicIslandContentView, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        dynamicIslandSafeguardsController.delayEnterApp(dynamicIslandContentView, bl);
    }

    private static final void delayEnterApp$lambda$17(String object, DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        o.g((Object)dynamicIslandSafeguardsController, (String)"this$0");
        Object object2 = dynamicIslandSafeguardsController.currentDelayEnterAppPkg;
        Object object3 = new StringBuilder();
        object3.append("onDelayEnterApp ");
        object3.append((String)object);
        object3.append(" ");
        object3.append((String)object2);
        Log.d((String)TAG, (String)object3.toString());
        if (dynamicIslandSafeguardsController.getWindowViewController().windowAnimating()) {
            Log.d((String)TAG, (String)"onDelayEnterApp windowAnimating");
            return;
        }
        object = dynamicIslandSafeguardsController.currentDelayEnterAppPkg;
        object = object != null ? dynamicIslandSafeguardsController.windowView.requestHasIsland((String)object) : null;
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                object3 = (DynamicIslandContentView)((Object)object.next());
                if (object3 == null || ((DynamicIslandBaseContentView)((Object)object3)).getState() instanceof DynamicIslandState.AppExpanded || ((DynamicIslandBaseContentView)((Object)object3)).getWindowAnimState() instanceof WindowAnimState.Closing) continue;
                if (((DynamicIslandBaseContentView)((Object)object3)).getState() instanceof DynamicIslandState.MiniWindowExpanded && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getFakeView()) != null) {
                    DynamicIslandContentFakeView.updateViewStateWhenCloseEnd$default((DynamicIslandContentFakeView)((Object)object2), true, null, 2, null);
                }
                ((DynamicIslandBaseContentView)((Object)object3)).setWindowAnimState(new WindowAnimState.Opened(false, false, false));
                Log.d((String)TAG, (String)"onDelayEnterApp success");
                dynamicIslandSafeguardsController.windowView.appEnter((DynamicIslandContentView)((Object)object3));
            }
        }
    }

    private static final void delayEnterMiniWidow$lambda$20(String object, DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        o.g((Object)object, (String)"$pkg");
        o.g((Object)dynamicIslandSafeguardsController, (String)"this$0");
        Object object2 = dynamicIslandSafeguardsController.currentDelayEnterMiniWindowPkg;
        Object object3 = new StringBuilder();
        object3.append("onDelayEnterMiniWidow ");
        object3.append((String)object);
        object3.append(" ");
        object3.append((String)object2);
        Log.d((String)TAG, (String)object3.toString());
        if (dynamicIslandSafeguardsController.getWindowViewController().windowAnimating()) {
            Log.d((String)TAG, (String)"onDelayEnterMiniWidow windowAnimating");
            return;
        }
        object = dynamicIslandSafeguardsController.currentDelayEnterMiniWindowPkg;
        object = object != null ? dynamicIslandSafeguardsController.windowView.requestHasIsland((String)object) : null;
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                object3 = (DynamicIslandContentView)((Object)object.next());
                if (object3 == null || ((DynamicIslandBaseContentView)((Object)object3)).getWindowAnimState() instanceof WindowAnimState.Closing || ((DynamicIslandBaseContentView)((Object)object3)).getState() instanceof DynamicIslandState.MiniWindowExpanded) continue;
                if (((DynamicIslandBaseContentView)((Object)object3)).getState() instanceof DynamicIslandState.AppExpanded && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getFakeView()) != null) {
                    DynamicIslandContentFakeView.updateViewStateWhenCloseEnd$default((DynamicIslandContentFakeView)((Object)object2), false, null, 2, null);
                }
                WindowAnimState windowAnimState = ((DynamicIslandBaseContentView)((Object)object3)).getWindowAnimState();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("onDelayEnterMiniWidow success animState = ");
                ((StringBuilder)object2).append(windowAnimState);
                Log.d((String)TAG, (String)((StringBuilder)object2).toString());
                ((DynamicIslandBaseContentView)((Object)object3)).setWindowAnimState(new WindowAnimState(true, false, false){
                    private final boolean byAnimEvent;
                    private final boolean freeform;
                    private final boolean hasAnimate;
                    {
                        this.freeform = bl;
                        this.hasAnimate = bl2;
                        this.byAnimEvent = bl3;
                    }
                    {
                        if ((n & 4) != 0) {
                            bl3 = true;
                        }
                        this(bl, bl2, bl3);
                    }

                    public static /* synthetic */ WindowAnimState.Opened copy$default(WindowAnimState.Opened opened, boolean bl, boolean bl2, boolean bl3, int n, Object object) {
                        if ((n & 1) != 0) {
                            bl = opened.freeform;
                        }
                        if ((n & 2) != 0) {
                            bl2 = opened.hasAnimate;
                        }
                        if ((n & 4) != 0) {
                            bl3 = opened.byAnimEvent;
                        }
                        return opened.copy(bl, bl2, bl3);
                    }

                    public final boolean component1() {
                        return this.freeform;
                    }

                    public final boolean component2() {
                        return this.hasAnimate;
                    }

                    public final boolean component3() {
                        return this.byAnimEvent;
                    }

                    public final WindowAnimState.Opened copy(boolean bl, boolean bl2, boolean bl3) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public boolean equals(Object object) {
                        if (this == object) {
                            return true;
                        }
                        if (!(object instanceof WindowAnimState.Opened)) {
                            return false;
                        }
                        object = object;
                        if (this.freeform != object.freeform) {
                            return false;
                        }
                        if (this.hasAnimate != object.hasAnimate) {
                            return false;
                        }
                        return this.byAnimEvent == object.byAnimEvent;
                    }

                    public final boolean getByAnimEvent() {
                        return this.byAnimEvent;
                    }

                    public final boolean getFreeform() {
                        return this.freeform;
                    }

                    public final boolean getHasAnimate() {
                        return this.hasAnimate;
                    }

                    public int hashCode() {
                        return (Boolean.hashCode(this.freeform) * 31 + Boolean.hashCode(this.hasAnimate)) * 31 + Boolean.hashCode(this.byAnimEvent);
                    }

                    public String toString() {
                        boolean bl = this.freeform;
                        boolean bl2 = this.hasAnimate;
                        boolean bl3 = this.byAnimEvent;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Opened(freeform=");
                        stringBuilder.append(bl);
                        stringBuilder.append(", hasAnimate=");
                        stringBuilder.append(bl2);
                        stringBuilder.append(", byAnimEvent=");
                        stringBuilder.append(bl3);
                        stringBuilder.append(")");
                        return stringBuilder.toString();
                    }
                });
                dynamicIslandSafeguardsController.windowView.enterMiniWindow((DynamicIslandContentView)((Object)object3));
            }
        }
    }

    public static /* synthetic */ void delayExitApp$default(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        dynamicIslandSafeguardsController.delayExitApp(string, bl);
    }

    private static final void delayExitApp$lambda$14(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, String object) {
        DynamicIslandContentView dynamicIslandContentView;
        o.g((Object)dynamicIslandSafeguardsController, (String)"this$0");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = dynamicIslandSafeguardsController.windowView.getMainAppExpanded();
        Object object32 = null;
        if (object2 != null) {
            if (o.c((Object)((DynamicIslandBaseContentView)((Object)object2)).getPkgName(), (Object)dynamicIslandSafeguardsController.fullScreenPkg) || o.c((Object)((DynamicIslandBaseContentView)((Object)object2)).getPkgName(), (Object)dynamicIslandSafeguardsController.currentDelayExitAppPkg)) {
                object2 = null;
            }
            if (object2 != null) {
                arrayList.add(object2);
            }
        }
        if ((dynamicIslandContentView = dynamicIslandSafeguardsController.windowView.getSubAppExpanded()) != null) {
            object2 = object32;
            if (!o.c((Object)dynamicIslandContentView.getPkgName(), (Object)dynamicIslandSafeguardsController.fullScreenPkg)) {
                object2 = object32;
                if (!o.c((Object)dynamicIslandContentView.getPkgName(), (Object)dynamicIslandSafeguardsController.currentDelayExitAppPkg)) {
                    object2 = dynamicIslandContentView;
                }
            }
            if (object2 != null) {
                arrayList.add(object2);
            }
        }
        object32 = dynamicIslandSafeguardsController.fullScreenPkg;
        int n = arrayList.size();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("delayExitApp: ");
        ((StringBuilder)object2).append((String)object32);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(" count = ");
        ((StringBuilder)object2).append(n);
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        if (arrayList.isEmpty()) {
            return;
        }
        dynamicIslandSafeguardsController.getWindowViewController().calculateAppClosePosition(((DynamicIslandContentView)((Object)arrayList.get(0))).getPkgName(), false);
        for (Object object32 : arrayList) {
            object32.setVisibility(0);
            object = ((DynamicIslandBaseContentView)((Object)object32)).getBackgroundView();
            if (object != null) {
                ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
            }
            ((DynamicIslandBaseContentView)((Object)object32)).setWindowAnimState(new WindowAnimState(false, false, false){
                private final boolean byAnimEvent;
                private final boolean freeform;
                private final boolean hasAnimate;
                {
                    this.freeform = bl;
                    this.hasAnimate = bl2;
                    this.byAnimEvent = bl3;
                }
                {
                    if ((n & 4) != 0) {
                        bl3 = true;
                    }
                    this(bl, bl2, bl3);
                }

                public static /* synthetic */ WindowAnimState.Closed copy$default(WindowAnimState.Closed closed, boolean bl, boolean bl2, boolean bl3, int n, Object object) {
                    if ((n & 1) != 0) {
                        bl = closed.freeform;
                    }
                    if ((n & 2) != 0) {
                        bl2 = closed.hasAnimate;
                    }
                    if ((n & 4) != 0) {
                        bl3 = closed.byAnimEvent;
                    }
                    return closed.copy(bl, bl2, bl3);
                }

                public final boolean component1() {
                    return this.freeform;
                }

                public final boolean component2() {
                    return this.hasAnimate;
                }

                public final boolean component3() {
                    return this.byAnimEvent;
                }

                public final WindowAnimState.Closed copy(boolean bl, boolean bl2, boolean bl3) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public boolean equals(Object object) {
                    if (this == object) {
                        return true;
                    }
                    if (!(object instanceof WindowAnimState.Closed)) {
                        return false;
                    }
                    object = object;
                    if (this.freeform != object.freeform) {
                        return false;
                    }
                    if (this.hasAnimate != object.hasAnimate) {
                        return false;
                    }
                    return this.byAnimEvent == object.byAnimEvent;
                }

                public final boolean getByAnimEvent() {
                    return this.byAnimEvent;
                }

                public final boolean getFreeform() {
                    return this.freeform;
                }

                public final boolean getHasAnimate() {
                    return this.hasAnimate;
                }

                public int hashCode() {
                    return (Boolean.hashCode(this.freeform) * 31 + Boolean.hashCode(this.hasAnimate)) * 31 + Boolean.hashCode(this.byAnimEvent);
                }

                public String toString() {
                    boolean bl = this.freeform;
                    boolean bl2 = this.hasAnimate;
                    boolean bl3 = this.byAnimEvent;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Closed(freeform=");
                    stringBuilder.append(bl);
                    stringBuilder.append(", hasAnimate=");
                    stringBuilder.append(bl2);
                    stringBuilder.append(", byAnimEvent=");
                    stringBuilder.append(bl3);
                    stringBuilder.append(")");
                    return stringBuilder.toString();
                }
            });
            DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(dynamicIslandSafeguardsController.windowView, (DynamicIslandContentView)((Object)object32), false, null, 4, null);
            dynamicIslandSafeguardsController.windowView.updateIslandWindowAnimRunningState(false, (DynamicIslandContentView)((Object)object32), false);
            dynamicIslandSafeguardsController.windowView.appExit((DynamicIslandContentView)((Object)object32));
        }
        dynamicIslandSafeguardsController.windowView.setAnimRunning(false, false);
        object = dynamicIslandSafeguardsController.getWindowViewController().get_isFreeformAnimRunning();
        object2 = Boolean.FALSE;
        object.setValue(object2);
        dynamicIslandSafeguardsController.getWindowViewController().get_isAppAnimRunning().setValue(object2);
    }

    public static /* synthetic */ void delayExitMiniWindow$default(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        dynamicIslandSafeguardsController.delayExitMiniWindow(string, bl);
    }

    private static final void delayExitMiniWindow$lambda$8(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, String object) {
        o.g((Object)dynamicIslandSafeguardsController, (String)"this$0");
        o.g((Object)object, (String)"$pkg");
        Object object2 = new ArrayList<DynamicIslandContentView>();
        Object object3 = dynamicIslandSafeguardsController.windowView.getMainMiniWindow((String)object);
        if (object3 != null) {
            object2.add(object3);
        }
        if ((object3 = dynamicIslandSafeguardsController.windowView.getSubMiniWindow((String)object)) != null) {
            object2.add(object3);
        }
        int n = object2.size();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("delayExitMiniWindow: ");
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append(" count = ");
        ((StringBuilder)object3).append(n);
        Log.d((String)TAG, (String)((StringBuilder)object3).toString());
        if (object2.isEmpty()) {
            return;
        }
        object3 = object2.iterator();
        while (object3.hasNext()) {
            object2 = (DynamicIslandContentView)((Object)object3.next());
            object2.setVisibility(0);
            object = ((DynamicIslandBaseContentView)((Object)object2)).getBackgroundView();
            if (object != null) {
                ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
            }
            ((DynamicIslandBaseContentView)((Object)object2)).setWindowAnimState(new /* invalid duplicate definition of identical inner class */);
            DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(dynamicIslandSafeguardsController.windowView, (DynamicIslandContentView)((Object)object2), true, null, 4, null);
            dynamicIslandSafeguardsController.windowView.updateIslandWindowAnimRunningState(false, (DynamicIslandContentView)((Object)object2), true);
            dynamicIslandSafeguardsController.windowView.exitMiniWindow((DynamicIslandContentView)((Object)object2));
        }
        dynamicIslandSafeguardsController.windowView.setAnimRunning(false, true);
        object = dynamicIslandSafeguardsController.getWindowViewController().get_isFreeformAnimRunning();
        object2 = Boolean.FALSE;
        object.setValue(object2);
        dynamicIslandSafeguardsController.getWindowViewController().get_isAppAnimRunning().setValue(object2);
    }

    private static final void delayResetWindowAnimation$lambda$4(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        o.g((Object)dynamicIslandSafeguardsController, (String)"this$0");
        Log.d((String)TAG, (String)"onDelayResetWindowAnimation");
        dynamicIslandSafeguardsController.getWindowViewController().resetWindowAnimationState();
    }

    public static /* synthetic */ void e(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, String string) {
        DynamicIslandSafeguardsController.delayExitMiniWindow$lambda$8(dynamicIslandSafeguardsController, string);
    }

    public static /* synthetic */ void f(String string, DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        DynamicIslandSafeguardsController.delayEnterMiniWidow$lambda$20(string, dynamicIslandSafeguardsController);
    }

    public static /* synthetic */ void g(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        DynamicIslandSafeguardsController.delayResetWindowAnimation$lambda$4(dynamicIslandSafeguardsController);
    }

    private final DynamicIslandWindowViewController getWindowViewController() {
        return (DynamicIslandWindowViewController)this.windowViewController$delegate.getValue();
    }

    public final void cancelDelayCollapsed() {
        Runnable runnable = this.onDelayCollapsed;
        if (runnable != null) {
            runnable.run();
        }
        this.onDelayCollapsed = null;
    }

    public final void cancelDelayEnterApp(String object) {
        String string = this.currentDelayEnterAppPkg;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cancelDelayEnterApp ");
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        object = this.onDelayEnterApp;
        if (object != null) {
            object.run();
        }
        this.onDelayEnterApp = null;
    }

    public final void cancelDelayEnterMiniWindow(String object) {
        String string = this.getWindowViewController().getTopActivityPkg();
        String string2 = this.currentDelayEnterMiniWindowPkg;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cancelDelayEnterMiniWindow ");
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        object = this.onDelayEnterMiniWindow;
        if (object != null) {
            object.run();
        }
        this.onDelayEnterMiniWindow = null;
    }

    public final void cancelDelayExitApp(String object) {
        String string = this.currentDelayExitAppPkg;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cancelDelayExitApp ");
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (!o.c((Object)object, (Object)this.currentDelayExitAppPkg)) {
            return;
        }
        object = this.onDelayExitApp;
        if (object != null) {
            object.run();
        }
        this.onDelayExitApp = null;
    }

    public final void cancelDelayExitMiniWindow(String object) {
        String string = this.currentDelayExitMiniWindowPkg;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cancelDelayExitMiniWindow ");
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (!o.c((Object)object, (Object)this.currentDelayExitMiniWindowPkg)) {
            return;
        }
        object = this.onDelayExitMiniWindow;
        if (object != null) {
            object.run();
        }
        this.onDelayExitMiniWindow = null;
    }

    public final void cancelDelayResetWindowAnimation() {
        Log.d((String)TAG, (String)"cancelDelayResetWindowAnimation");
        Runnable runnable = this.onResetWindowAnimationState;
        if (runnable != null) {
            runnable.run();
        }
        this.onResetWindowAnimationState = null;
    }

    public final void delayCollapsed(long l) {
        Log.d((String)TAG, (String)"delayCollapsed");
        this.onDelayCollapsed = this.uiExecutor.executeDelayed((Runnable)new f(this), l, TimeUnit.SECONDS);
    }

    public final void delayDeleted(String object, long l) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("delayDeleted ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(", time:");
        ((StringBuilder)object2).append(l);
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        this.cancelDelayDeleted((String)object);
        object2 = this.uiExecutor.executeDelayed((Runnable)new e((String)object, this), l, TimeUnit.SECONDS);
        if (object != null) {
            object = this.onDelayCancelMap.put((String)object, (Runnable)object2);
        }
    }

    public final void delayEnterApp(DynamicIslandContentView object, boolean bl) {
        object = object != null && (object = object.getCurrentIslandData()) != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
        this.currentDelayEnterAppPkg = object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delayEnterApp ");
        stringBuilder.append((String)object);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.cancelDelayEnterApp(this.currentDelayEnterAppPkg);
        stringBuilder = this.uiExecutor;
        object = new j((String)object, this);
        long l = bl ? 0L : (this.getWindowViewController().windowAnimating() ? 1000L : 150L);
        this.onDelayEnterApp = stringBuilder.executeDelayed((Runnable)object, l, TimeUnit.MILLISECONDS);
    }

    public final void delayEnterMiniWidow(String string) {
        o.g((Object)string, (String)"pkg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delayEnterMiniWidow ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.currentDelayEnterMiniWindowPkg = string;
        this.cancelDelayEnterMiniWindow(string);
        this.onDelayEnterMiniWindow = this.uiExecutor.executeDelayed((Runnable)new g(string, this), 150L, TimeUnit.MILLISECONDS);
    }

    public final void delayExitApp(String object, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delayExitApp ");
        stringBuilder.append((String)object);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.currentDelayExitAppPkg = object;
        this.cancelDelayExitApp((String)object);
        stringBuilder = this.uiExecutor;
        object = new d(this, (String)object);
        long l = bl ? 0L : 150L;
        this.onDelayExitApp = stringBuilder.executeDelayed((Runnable)object, l, TimeUnit.MILLISECONDS);
    }

    public final void delayExitMiniWindow(String object, boolean bl) {
        o.g((Object)object, (String)"pkg");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delayExitMiniWindow ");
        stringBuilder.append((String)object);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.cancelDelayExitMiniWindow((String)object);
        this.currentDelayExitMiniWindowPkg = object;
        stringBuilder = this.uiExecutor;
        object = new i(this, (String)object);
        long l = bl ? 0L : 150L;
        this.onDelayExitMiniWindow = stringBuilder.executeDelayed((Runnable)object, l, TimeUnit.MILLISECONDS);
    }

    public final void delayResetWindowAnimation(long l) {
        Log.d((String)TAG, (String)"delayResetWindowAnimation");
        this.cancelDelayResetWindowAnimation();
        this.onResetWindowAnimationState = this.uiExecutor.executeDelayed((Runnable)new h(this), l, TimeUnit.SECONDS);
    }

    public final String getFullScreenPkg() {
        return this.fullScreenPkg;
    }

    public final DelayableExecutor getUiExecutor() {
        return this.uiExecutor;
    }

    public final void removeEnterMiniWindow(String object) {
        String string = this.currentDelayEnterMiniWindowPkg;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeEnterMiniWindow: ");
        stringBuilder.append((String)object);
        stringBuilder.append("  ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (object != null && o.c((Object)object, (Object)this.currentDelayEnterMiniWindowPkg)) {
            object = this.onDelayEnterMiniWindow;
            if (object != null) {
                object.run();
            }
            this.onDelayEnterMiniWindow = null;
        }
    }

    public final void setFullScreenPkg(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.fullScreenPkg = string;
    }

    public final void setUiExecutor(DelayableExecutor delayableExecutor) {
        o.g((Object)delayableExecutor, (String)"<set-?>");
        this.uiExecutor = delayableExecutor;
    }

    @Override
    public void start() {
        f1.f.b((f1.E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandSafeguardsController this$0;
            {
                this.this$0 = dynamicIslandSafeguardsController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    I i2 = DynamicIslandSafeguardsController.access$getWindowViewController(this.this$0).isFreeformAnimRunning();
                    g2 = new i1.g(this.this$0){
                        final DynamicIslandSafeguardsController this$0;
                        {
                            this.this$0 = dynamicIslandSafeguardsController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("isFreeformAnimRunning ");
                            ((StringBuilder)object).append(bl);
                            Log.d((String)"DynamicIslandSafeguardsController", (String)((StringBuilder)object).toString());
                            if (bl) {
                                this.this$0.delayResetWindowAnimation(5L);
                            } else {
                                this.this$0.cancelDelayResetWindowAnimation();
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (i2.collect(g2, (K0.d)this) == object) {
                        return object;
                    }
                }
                throw new c();
            }
        }, (int)3, null);
        f1.f.b((f1.E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandSafeguardsController this$0;
            {
                this.this$0 = dynamicIslandSafeguardsController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)object);
                } else {
                    k.b((Object)object);
                    object = DynamicIslandSafeguardsController.access$getWindowViewController(this.this$0).isAppAnimRunning();
                    i1.g g2 = new i1.g(this.this$0){
                        final DynamicIslandSafeguardsController this$0;
                        {
                            this.this$0 = dynamicIslandSafeguardsController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("isAppAnimating ");
                            ((StringBuilder)object).append(bl);
                            Log.d((String)"DynamicIslandSafeguardsController", (String)((StringBuilder)object).toString());
                            if (bl) {
                                this.this$0.delayResetWindowAnimation(5L);
                            } else {
                                this.this$0.cancelDelayResetWindowAnimation();
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (K0.d)this) == object2) {
                        return object2;
                    }
                }
                throw new c();
            }
        }, (int)3, null);
    }
}
