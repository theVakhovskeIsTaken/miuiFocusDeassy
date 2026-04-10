/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.d
 *  G0.e
 *  G0.s
 *  U0.a
 *  android.content.Context
 *  android.util.Log
 *  android.view.View
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.ConvenienceExtensionsKt
 */
package miui.systemui.dynamicisland.anim;

import D0.a;
import G0.d;
import G0.e;
import G0.s;
import android.content.Context;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.HashSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.view.DynamicGlowEffectView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.ConvenienceExtensionsKt;

@DynamicIslandScope
public final class DynamicIslandAnimationController {
    public static final Companion Companion = new Object(null){
        {
            this();
        }

        private final Method getSetMiSelfBlurMethod() {
            return (Method)setMiSelfBlurMethod$delegate.getValue();
        }

        public final void setMiSelfBlurCompat(View view, int n) {
            block3: {
                o.g((Object)view, (String)"<this>");
                Method method = this.getSetMiSelfBlurMethod();
                if (method == null) break block3;
                try {
                    method.invoke((Object)view, n, null);
                }
                catch (Throwable throwable) {
                    Log.e((String)"DynamicIslandAnimDebug", (String)"Invoke setMiSelfBlurMethod failed.", (Throwable)throwable);
                }
            }
        }
    };
    public static final String TAG = "DynamicIslandAnim";
    private static final d setMiSelfBlurMethod$delegate = e.b((U0.a)setMiSelfBlurMethod.2.INSTANCE);
    private final DynamicIslandAnimationCallback animationCallback;
    private final DynamicIslandAnimationDelegate.Factory animationDelegateFactory;
    private boolean animatorRunning;
    private final HashSet<String> animatorSet;
    private final d callback$delegate;
    private DynamicIslandState currentBigIsland;
    private DynamicIslandState currentExpanded;
    private final DynamicIslandWindowState dynamicIslandWindowState;
    private final DynamicIslandExternalStateRepository externalStateRepository;
    private boolean isRecover;
    private DynamicIslandState lastExpanded;

    public DynamicIslandAnimationController(a object, DynamicIslandWindowState object2, DynamicIslandAnimationDelegate.Factory factory, DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        o.g((Object)object, (String)"eventCoordinator");
        o.g((Object)object2, (String)"dynamicIslandWindowState");
        o.g((Object)factory, (String)"animationDelegateFactory");
        o.g((Object)dynamicIslandExternalStateRepository, (String)"externalStateRepository");
        this.dynamicIslandWindowState = object2;
        this.animationDelegateFactory = factory;
        this.externalStateRepository = dynamicIslandExternalStateRepository;
        this.callback$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)object);
        this.animatorSet = new HashSet();
        this.isRecover = true;
        object = new DynamicIslandAnimationCallback();
        object2 = DynamicIslandAnimationType.ALL;
        ((DynamicIslandAnimationCallback)object).addAnimationCallback((DynamicIslandAnimationType)((Object)object2), DynamicIslandAnimationCallbackType.ANIM_START, new Function1(this){
            final DynamicIslandAnimationController this$0;
            {
                this.this$0 = dynamicIslandAnimationController;
                super(1);
            }

            public final void invoke(String string) {
                o.g((Object)string, (String)"it");
                DynamicIslandAnimationController.access$setAnimatorRunning(this.this$0, true);
                DynamicIslandAnimationController.access$getAnimatorSet$p(this.this$0).add(string);
            }
        });
        ((DynamicIslandAnimationCallback)object).addAnimationCallback((DynamicIslandAnimationType)((Object)object2), DynamicIslandAnimationCallbackType.ANIM_FINISH, new Function1(this){
            final DynamicIslandAnimationController this$0;
            {
                this.this$0 = dynamicIslandAnimationController;
                super(1);
            }

            public final void invoke(String string) {
                o.g((Object)string, (String)"it");
                DynamicIslandAnimationController.access$getAnimatorSet$p(this.this$0).remove(string);
                if (DynamicIslandAnimationController.access$getAnimatorSet$p(this.this$0).isEmpty()) {
                    DynamicIslandAnimationController.access$setAnimatorRunning(this.this$0, false);
                }
            }
        });
        ((DynamicIslandAnimationCallback)object).addAnimationCallback((DynamicIslandAnimationType)((Object)object2), DynamicIslandAnimationCallbackType.ANIM_CANCEL, new Function1(this){
            final DynamicIslandAnimationController this$0;
            {
                this.this$0 = dynamicIslandAnimationController;
                super(1);
            }

            public final void invoke(String string) {
                o.g((Object)string, (String)"it");
                DynamicIslandAnimationController.access$getAnimatorSet$p(this.this$0).remove(string);
                DynamicIslandAnimationController.access$getCallback(this.this$0).onAnimationCancel();
            }
        });
        this.animationCallback = object;
    }

    public static final /* synthetic */ HashSet access$getAnimatorSet$p(DynamicIslandAnimationController dynamicIslandAnimationController) {
        return dynamicIslandAnimationController.animatorSet;
    }

    public static final /* synthetic */ DynamicIslandEventCoordinator access$getCallback(DynamicIslandAnimationController dynamicIslandAnimationController) {
        return dynamicIslandAnimationController.getCallback();
    }

    public static final /* synthetic */ void access$setAnimatorRunning(DynamicIslandAnimationController dynamicIslandAnimationController, boolean bl) {
        dynamicIslandAnimationController.setAnimatorRunning(bl);
    }

    private final void appExpandedToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"appExpandedToAppExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.appExpandedToAppExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void appExpandedToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate;
        Log.d((String)"DynamicIslandAnimDebug", (String)"appExpandedToBigIslandAnimation");
        if (this.islandAppAnimating(dynamicIslandContentView) && (dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView)) != null) {
            dynamicIslandAnimationDelegate.setAppClose(true);
        }
        if ((dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView)) != null) {
            dynamicIslandAnimationDelegate.appExpandedToBigIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void appExpandedToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"appExpandedToHiddenAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.appExpandedToHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void appExpandedToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"appExpandedToMiniWindowExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.appExpandedToMiniWindowExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void appExpandedToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate;
        Log.d((String)"DynamicIslandAnimDebug", (String)"appExpandedToSmallIslandAnimation");
        if (this.islandAppAnimating(dynamicIslandContentView) && (dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView)) != null) {
            dynamicIslandAnimationDelegate.setAppClose(true);
        }
        if ((dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView)) != null) {
            dynamicIslandAnimationDelegate.appExpandedToSmallIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void appExpandedToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"appExpandedToTempHiddenAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.appExpandedToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void beforeBigIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("beforeBigIslandToTempHiddenAnimation: ");
        ((StringBuilder)object).append((Object)dynamicIslandContentView);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).beforeBigIslandToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void beforeSmallIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("smallIslandToTempHiddenNoAnimation: ");
        ((StringBuilder)object).append((Object)dynamicIslandContentView);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).beforeSmallIslandToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandChangedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.i((String)"DynamicIslandAnimDebug", (String)"bigIslandChangedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.bigIslandChangedAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandChangedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.i((String)"DynamicIslandAnimDebug", (String)"bigIslandChangedNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.bigIslandChangedNoAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"bigIslandToAppExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.bigIslandToAppExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandToDeletedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = dynamicIslandContentView.getState();
        if (object != null && ((State)object).getDeleteNoAnimation() || (object = dynamicIslandContentView.getWindowState()) != null && ((DynamicIslandWindowState)object).isToScreenLockNoAnimation()) {
            Log.d((String)"DynamicIslandAnimDebug", (String)"bigIslandToDeletedNoAnimation");
            object = this.getAnimator(dynamicIslandContentView);
            if (object != null) {
                ((DynamicIslandAnimationDelegate)object).bigIslandToDeletedNoAnimation(dynamicIslandContentView);
            }
        } else {
            Log.d((String)"DynamicIslandAnimDebug", (String)"bigIslandToDeletedAnimation");
            object = this.getAnimator(dynamicIslandContentView);
            if (object != null) {
                ((DynamicIslandAnimationDelegate)object).bigIslandToDeletedAnimation(dynamicIslandContentView);
            }
        }
    }

    private final void bigIslandToExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"bigIslandToExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.bigIslandToExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("bigIslandToHiddenAnimation: ");
        ((StringBuilder)object).append((Object)dynamicIslandContentView);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).bigIslandToHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"bigIslandToMiniWindowExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.bigIslandToMiniWindowExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"bigIslandToSmallIslandAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.bigIslandToSmallIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandToSmallIslandNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"bigIslandToSmallIslandNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.bigIslandToSmallIslandNoAnimation(dynamicIslandContentView);
        }
    }

    private final void bigIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = dynamicIslandContentView.getWindowState();
        object = object != null ? ((DynamicIslandWindowState)object).getScreenLocked() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bigIslandToTempHiddenAnimation: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append(" view.windowState.screenLocked: ");
        stringBuilder.append(object);
        Log.e((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).bigIslandToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedChangedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedChangedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedChangedAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToAppExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToAppExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToBigIslandAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToBigIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToBigIslandNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToBigIslandNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToBigIslandNoAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToDeletedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToDeletedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToDeletedAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToDeletedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToDeletedNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToDeletedNoAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToHiddenAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToHiddenAnimation(dynamicIslandContentView, false);
        }
    }

    private final void expandedToHiddenNoAnim(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToHiddenNoAnim");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToHiddenNoAnim(dynamicIslandContentView);
        }
    }

    private final void expandedToMiniWindowAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToMiniWindowAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToMiniWindowAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToSmallIslandAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToSmallIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToSmallIslandNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToSmallIslandNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToSmallIslandNoAnimation(dynamicIslandContentView);
        }
    }

    private final void expandedToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToTempHiddenAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            DynamicIslandAnimationDelegate.expandedToTempHiddenAnimation$default(dynamicIslandAnimationDelegate, dynamicIslandContentView, false, 2, null);
        }
    }

    private final void expandedToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"expandedToTempHiddenNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.expandedToTempHiddenNoAnimation(dynamicIslandContentView);
        }
    }

    private final DynamicIslandAnimationDelegate getAnimator(DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        return dynamicIslandBaseContentView.getAnimator(this.animationDelegateFactory);
    }

    private final DynamicIslandEventCoordinator getCallback() {
        return (DynamicIslandEventCoordinator)this.callback$delegate.getValue();
    }

    private final void hiddenChangedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenChangedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.hiddenChangedAnimation(dynamicIslandContentView);
        }
    }

    private final void hiddenChangedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenChangedNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.hiddenChangedNoAnimation(dynamicIslandContentView);
        }
    }

    private final void hiddenToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenToAppExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.hiddenToAppExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void hiddenToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object;
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenToBigIslandAnimation");
        boolean bl = CommonUtils.INSTANCE.getIS_TABLET() && (object = dynamicIslandContentView.getExpandedView()) != null && object.getVisibility() == 0 && !o.b((Float)(object = (object = dynamicIslandContentView.getExpandedView()) != null ? Float.valueOf(object.getAlpha()) : null), (float)0.0f);
        this.showBigIsland(dynamicIslandContentView, bl);
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).hiddenToBigIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void hiddenToDeletedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenToDeletedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.hiddenToDeletedAnimation(dynamicIslandContentView);
        }
    }

    private final void hiddenToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenToMiniWindowExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.hiddenToMiniWindowExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void hiddenToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenToSmallIslandAnimation");
        this.showSmallIsland(dynamicIslandContentView);
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.hiddenToSmallIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void hiddenToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenToTempHiddenAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.hiddenToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void hiddenToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"hiddenToTempHiddenNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.hiddenToTempHiddenNoAnimation(dynamicIslandContentView);
        }
    }

    private final void immersiveAlphaAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = dynamicIslandContentView.getWindowState();
        object = object != null ? ((DynamicIslandWindowState)object).getScreenLocked() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("immersiveAlphaAnimation: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append(" view.windowState.screenLocked: ");
        stringBuilder.append(object);
        Log.e((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).immersiveAlphaAnimation(dynamicIslandContentView);
        }
    }

    private final void initToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"initToAppExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.initToAppExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void initToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.i((String)"DynamicIslandAnimDebug", (String)"initToBigIslandAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.initToBigIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void initToExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate;
        Log.i((String)"DynamicIslandAnimDebug", (String)"initToExpandedAnimation");
        if (dynamicIslandContentView != null && (dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView)) != null) {
            dynamicIslandAnimationDelegate.initToExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void initToHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"initToHiddenNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.initToHiddenNoAnimation(dynamicIslandContentView);
        }
    }

    private final void initToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"initToMiniWindowExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.initToMiniWindowExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void initToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.i((String)"DynamicIslandAnimDebug", (String)"initToSmallIslandAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.initToSmallIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void initToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.i((String)"DynamicIslandAnimDebug", (String)"initToTempHiddenAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.initToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void miniWindowToAppExpanded(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"miniWindowToAppExpanded");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.miniWindowToAppExpanded(dynamicIslandContentView);
        }
    }

    private final void miniWindowToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"miniWindowToBigIslandAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.miniWindowToBigIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void miniWindowToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"miniWindowToSmallIslandAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.miniWindowToSmallIslandAnimation(dynamicIslandContentView);
        }
    }

    private final void miniWindowToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"miniWindowToTempHiddenAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.miniWindowToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void miniWindowToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"miniWindowToTempHiddenNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.miniWindowToTempHiddenNoAnimation(dynamicIslandContentView);
        }
    }

    private final void moveDownAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = dynamicIslandContentView.getWindowState();
        object = object != null ? ((DynamicIslandWindowState)object).getScreenLocked() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("moveDownAnimation: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append(" view.windowState.screenLocked: ");
        stringBuilder.append(object);
        Log.e((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).moveDownAnimation(dynamicIslandContentView);
        }
    }

    private final void moveUpAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = dynamicIslandContentView.getWindowState();
        object = object != null ? ((DynamicIslandWindowState)object).getScreenLocked() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("moveUpAnimation: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append(" view.windowState.screenLocked: ");
        stringBuilder.append(object);
        Log.e((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).moveUpAnimation(dynamicIslandContentView);
        }
    }

    private final boolean needUpdateWindowHeight(DynamicIslandContentView dynamicIslandContentView) {
        boolean bl = dynamicIslandContentView.getLastState() instanceof DynamicIslandState.Expanded || dynamicIslandContentView.getState() instanceof DynamicIslandState.Expanded;
        return bl;
    }

    private final void setAnimatorRunning(boolean bl) {
        if (this.animatorRunning != bl) {
            if (bl) {
                Log.e((String)"DynamicIslandAnimDebug", (String)"animatorRunning is true");
            } else {
                Log.e((String)"DynamicIslandAnimDebug", (String)"animatorRunning is false");
            }
            this.animatorRunning = bl;
            if (!bl) {
                this.getCallback().onAnimationFinished();
            }
        }
    }

    public static final void setMiSelfBlurCompat(View view, int n) {
        Companion.setMiSelfBlurCompat(view, n);
    }

    private final void smallIslandChangedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.i((String)"DynamicIslandAnimDebug", (String)"smallIslandChangedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.smallIslandChangedAnimation(dynamicIslandContentView);
        }
    }

    private final void smallIslandChangedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.i((String)"DynamicIslandAnimDebug", (String)"smallIslandChangedNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.smallIslandChangedNoAnimation(dynamicIslandContentView);
        }
    }

    private final void smallIslandScaleAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.i((String)"DynamicIslandAnimDebug", (String)"smallIslandScaleAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.smallIslandScaleAnimation(dynamicIslandContentView);
        }
    }

    private final void smallIslandToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"smallIslandToAppExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.smallIslandToAppExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void smallIslandToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = this.getAnimator(dynamicIslandContentView);
        object = object != null ? Boolean.valueOf(((DynamicIslandAnimationDelegate)object).getAppClose()) : null;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("smallIslandToBigIslandAnimation ");
        ((StringBuilder)object2).append(object);
        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object2).toString());
        object2 = this.getAnimator(dynamicIslandContentView);
        if (object2 != null) {
            boolean bl;
            object = this.getAnimator(dynamicIslandContentView);
            boolean bl2 = bl = false;
            if (object != null) {
                bl2 = bl;
                if (((DynamicIslandAnimationDelegate)object).getAppClose()) {
                    bl2 = true;
                }
            }
            ((DynamicIslandAnimationDelegate)object2).smallIslandToBigIslandAnimation(dynamicIslandContentView, bl2);
        }
    }

    private final void smallIslandToDeletedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = dynamicIslandContentView.getState();
        if (object != null && ((State)object).getDeleteNoAnimation() || (object = dynamicIslandContentView.getWindowState()) != null && ((DynamicIslandWindowState)object).isToScreenLockNoAnimation()) {
            Log.d((String)"DynamicIslandAnimDebug", (String)"smallIslandToDeletedNoAnimation");
            object = this.getAnimator(dynamicIslandContentView);
            if (object != null) {
                ((DynamicIslandAnimationDelegate)object).smallIslandToDeletedNoAnimation(dynamicIslandContentView);
            }
        } else {
            Log.d((String)"DynamicIslandAnimDebug", (String)"smallIslandToDeletedAnimation");
            object = this.getAnimator(dynamicIslandContentView);
            if (object != null) {
                ((DynamicIslandAnimationDelegate)object).smallIslandToDeletedAnimation(dynamicIslandContentView);
            }
        }
    }

    private final void smallIslandToExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"smallIslandToExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.smallIslandToExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void smallIslandToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = this.getAnimator(dynamicIslandContentView);
        object = object != null ? Boolean.valueOf(((DynamicIslandAnimationDelegate)object).getAppClose()) : null;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("smallIslandToHiddenAnimation, appClose: ");
        ((StringBuilder)object2).append(object);
        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object2).toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            boolean bl;
            object2 = this.getAnimator(dynamicIslandContentView);
            boolean bl2 = bl = false;
            if (object2 != null) {
                bl2 = bl;
                if (((DynamicIslandAnimationDelegate)object2).getAppClose()) {
                    bl2 = true;
                }
            }
            ((DynamicIslandAnimationDelegate)object).smallIslandToHiddenAnimation(dynamicIslandContentView, bl2);
        }
    }

    private final void smallIslandToHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"smallIslandToHiddenNoAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.smallIslandToHiddenNoAnimation(dynamicIslandContentView);
        }
    }

    private final void smallIslandToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Log.d((String)"DynamicIslandAnimDebug", (String)"smallIslandToMiniWindowExpandedAnimation");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.smallIslandToMiniWindowExpandedAnimation(dynamicIslandContentView);
        }
    }

    private final void smallIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = dynamicIslandContentView.getWindowState();
        object = object != null ? ((DynamicIslandWindowState)object).getScreenLocked() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("smallIslandToTempHiddenAnimation: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append(" view.windowState.screenLocked: ");
        stringBuilder.append(object);
        Log.e((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).smallIslandToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    private final void tempHiddenToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("tempHiddenToBigIslandAnimation: ");
        ((StringBuilder)object).append((Object)dynamicIslandContentView);
        ((StringBuilder)object).append(" noAnim=");
        ((StringBuilder)object).append(bl);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).tempHiddenToBigIslandAnimation(dynamicIslandContentView, bl);
        }
    }

    private final void tempHiddenToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("tempHiddenToSmallIslandAnimation: ");
        ((StringBuilder)object).append((Object)dynamicIslandContentView);
        ((StringBuilder)object).append(" noAnim=");
        ((StringBuilder)object).append(bl);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).tempHiddenToSmallIslandAnimation(dynamicIslandContentView, bl);
        }
    }

    private final void updateOrientationBigIslandToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("updateOrientationBigIslandToTempHiddenNoAnimation: ");
        ((StringBuilder)object).append((Object)dynamicIslandContentView);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).updateOrientationBigIslandToTempHiddenNoAnimation(dynamicIslandContentView);
        }
    }

    private final void updateOrientationSmallIslandToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("updateOrientationSmallIslandToTempHiddenNoAnimation: ");
        ((StringBuilder)object).append((Object)dynamicIslandContentView);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        object = this.getAnimator(dynamicIslandContentView);
        if (object != null) {
            ((DynamicIslandAnimationDelegate)object).updateOrientationSmallIslandToTempHiddenAnimation(dynamicIslandContentView);
        }
    }

    public final boolean canExpandedViewTrack(DynamicIslandContentView object) {
        Object object2;
        object2 = object != null && (object2 = this.getAnimator((DynamicIslandBaseContentView)((Object)object))) != null ? Float.valueOf(((DynamicIslandAnimationDelegate)object2).getExpandedViewAnimatingProgress()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("canExpandedViewTrack: ");
        stringBuilder.append(object2);
        Log.d((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        float f = object != null && (object = this.getAnimator((DynamicIslandBaseContentView)((Object)object))) != null ? ((DynamicIslandAnimationDelegate)object).getExpandedViewAnimatingProgress() : 1.0f;
        boolean bl = f > 0.8f;
        return bl;
    }

    public final DynamicIslandAnimationCallback getAnimationCallback$miui_dynamicisland_release() {
        return this.animationCallback;
    }

    public final DynamicIslandState getCurrentBigIsland() {
        return this.currentBigIsland;
    }

    public final DynamicIslandState getCurrentExpanded() {
        return this.currentExpanded;
    }

    public final DynamicIslandWindowState getDynamicIslandWindowState() {
        return this.dynamicIslandWindowState;
    }

    public final DynamicIslandState getLastExpanded() {
        return this.lastExpanded;
    }

    public final int getSmallIslandX() {
        Context context;
        DynamicIslandContentView dynamicIslandContentView = this.getCallback().getBigIslandStateHandler().getCurrent();
        if (dynamicIslandContentView != null && (context = dynamicIslandContentView.getContext()) != null && CommonUtils.isLayoutRtl((Context)context)) {
            int n = DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null);
            int n2 = dynamicIslandContentView.getSmallIslandViewWidth();
            return n - dynamicIslandContentView.getSpace() - n2;
        }
        int n = 0;
        int n3 = dynamicIslandContentView != null ? DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null) : 0;
        int n4 = dynamicIslandContentView != null ? DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(dynamicIslandContentView, null, 1, null) : 0;
        if (dynamicIslandContentView != null) {
            n = dynamicIslandContentView.getSpace();
        }
        return n3 + n4 + n;
    }

    public final boolean isWindowAnimating(DynamicIslandContentView object) {
        boolean bl = object != null && (object = this.getAnimator((DynamicIslandBaseContentView)((Object)object))) != null ? ((DynamicIslandAnimationDelegate)object).getIslandWindowAnimRunning() : false;
        return bl;
    }

    public final boolean islandAppAnimating(DynamicIslandContentView object) {
        boolean bl = object != null && (object = this.getAnimator((DynamicIslandBaseContentView)((Object)object))) != null ? ((DynamicIslandAnimationDelegate)object).getIslandAppAnimRunning() : false;
        return bl;
    }

    public final boolean islandFreeformAnimating(DynamicIslandContentView object) {
        boolean bl = object != null && (object = this.getAnimator((DynamicIslandBaseContentView)((Object)object))) != null ? ((DynamicIslandAnimationDelegate)object).getIslandFreeformAnimRunning() : false;
        return bl;
    }

    public final void onPress(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate;
        if (dynamicIslandContentView != null && (dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView)) != null) {
            dynamicIslandAnimationDelegate.onPress(dynamicIslandContentView);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void onStateChange(DynamicIslandContentView var1_1) {
        block297: {
            block298: {
                block296: {
                    block236: {
                        block293: {
                            block294: {
                                block295: {
                                    block292: {
                                        block289: {
                                            block290: {
                                                block291: {
                                                    block278: {
                                                        block288: {
                                                            block287: {
                                                                block286: {
                                                                    block285: {
                                                                        block284: {
                                                                            block283: {
                                                                                block282: {
                                                                                    block281: {
                                                                                        block280: {
                                                                                            block279: {
                                                                                                block265: {
                                                                                                    block268: {
                                                                                                        block277: {
                                                                                                            block276: {
                                                                                                                block269: {
                                                                                                                    block270: {
                                                                                                                        block272: {
                                                                                                                            block275: {
                                                                                                                                block274: {
                                                                                                                                    block273: {
                                                                                                                                        block271: {
                                                                                                                                            block266: {
                                                                                                                                                block267: {
                                                                                                                                                    block251: {
                                                                                                                                                        block264: {
                                                                                                                                                            block263: {
                                                                                                                                                                block262: {
                                                                                                                                                                    block261: {
                                                                                                                                                                        block260: {
                                                                                                                                                                            block254: {
                                                                                                                                                                                block259: {
                                                                                                                                                                                    block255: {
                                                                                                                                                                                        block258: {
                                                                                                                                                                                            block256: {
                                                                                                                                                                                                block257: {
                                                                                                                                                                                                    block253: {
                                                                                                                                                                                                        block252: {
                                                                                                                                                                                                            block241: {
                                                                                                                                                                                                                block250: {
                                                                                                                                                                                                                    block249: {
                                                                                                                                                                                                                        block248: {
                                                                                                                                                                                                                            block246: {
                                                                                                                                                                                                                                block247: {
                                                                                                                                                                                                                                    block244: {
                                                                                                                                                                                                                                        block245: {
                                                                                                                                                                                                                                            block242: {
                                                                                                                                                                                                                                                block243: {
                                                                                                                                                                                                                                                    block237: {
                                                                                                                                                                                                                                                        block239: {
                                                                                                                                                                                                                                                            block240: {
                                                                                                                                                                                                                                                                block238: {
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = new StringBuilder();
                                                                                                                                                                                                                                                                    var13_2 /* !! */ .append("view: ");
                                                                                                                                                                                                                                                                    var13_2 /* !! */ .append((Object)var1_1);
                                                                                                                                                                                                                                                                    Log.e((String)"DynamicIslandAnimDebug", (String)var13_2 /* !! */ .toString());
                                                                                                                                                                                                                                                                    if (var1_1 == null) {
                                                                                                                                                                                                                                                                        return;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    if (var1_1.getBigIslandViewWidth() == 0) {
                                                                                                                                                                                                                                                                        Log.e((String)"DynamicIslandAnimDebug", (String)"view?.bigIslandViewWidth == 0");
                                                                                                                                                                                                                                                                        var1_1.calculateBigIslandWidth();
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    if ((var15_3 = CommonUtils.INSTANCE).getIS_TABLET() && ((var13_2 /* !! */  = var1_1.getCurrentIslandData()) == null || (var13_2 /* !! */  = var13_2 /* !! */ .getProperties()) == null || var13_2 /* !! */ .intValue() != 0) && var1_1.getState() instanceof DynamicIslandState.BigIsland && (var13_2 /* !! */  = this.getAnimator(var1_1)) != null) {
                                                                                                                                                                                                                                                                        var13_2 /* !! */ .updateBigIslandWidth(var1_1);
                                                                                                                                                                                                                                                                        var13_2 /* !! */  = s.a;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    if (var1_1.getVisibility() == 8) {
                                                                                                                                                                                                                                                                        var1_1.setVisibility(0);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    this.getCallback().onShowOnceStateChange();
                                                                                                                                                                                                                                                                    this.getCallback().onAnimationStart(this.needUpdateWindowHeight(var1_1), var1_1);
                                                                                                                                                                                                                                                                    if (!(!(var1_1.getLastState() instanceof DynamicIslandState.Expanded) && !(var1_1.getState() instanceof DynamicIslandState.Expanded) || var1_1.getLastState() instanceof DynamicIslandState.Expanded && var1_1.getState() instanceof DynamicIslandState.Expanded)) {
                                                                                                                                                                                                                                                                        this.updateExpandedViewMiniBar(var1_1);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    var14_4 = this.dynamicIslandWindowState;
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = var1_1.getCurrentIslandData();
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = var13_2 /* !! */  != null ? var13_2 /* !! */ .getProperties() : null;
                                                                                                                                                                                                                                                                    var9_5 = var14_4.isTempHidden((Integer)var13_2 /* !! */ );
                                                                                                                                                                                                                                                                    var10_6 = this.dynamicIslandWindowState.isShowOnceIsland();
                                                                                                                                                                                                                                                                    var11_7 = this.dynamicIslandWindowState.getPanelHeightChanging();
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = var1_1.getFakeView();
                                                                                                                                                                                                                                                                    if (var13_2 /* !! */  != null) {
                                                                                                                                                                                                                                                                        var13_2 /* !! */ .onStateChanged(var1_1);
                                                                                                                                                                                                                                                                        var13_2 /* !! */  = s.a;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    var14_4 = this.dynamicIslandWindowState.getTempHiddenChange();
                                                                                                                                                                                                                                                                    var16_8 = this.dynamicIslandWindowState.getConfigChange();
                                                                                                                                                                                                                                                                    var8_9 = this.dynamicIslandWindowState.isToScreenLockNoAnimation();
                                                                                                                                                                                                                                                                    var5_10 = (Boolean)this.dynamicIslandWindowState.getScreenLocked().getValue();
                                                                                                                                                                                                                                                                    var12_11 = (Boolean)this.dynamicIslandWindowState.getBouncerShowing().getValue();
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = this.getAnimator(var1_1);
                                                                                                                                                                                                                                                                    var6_12 = true;
                                                                                                                                                                                                                                                                    var7_13 = true;
                                                                                                                                                                                                                                                                    if (var13_2 /* !! */  != null) {
                                                                                                                                                                                                                                                                        var13_2 /* !! */ .setIslandStateChanged(o.c((Object)var1_1.getLastState(), (Object)var1_1.getState()) ^ true);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    if (!(var1_1.getState() instanceof DynamicIslandState.Hidden) && (var13_2 /* !! */  = this.getAnimator(var1_1)) != null) {
                                                                                                                                                                                                                                                                        var13_2 /* !! */ .setHiddenStateFrom(null);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = this.getAnimator(var1_1);
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = var13_2 /* !! */  != null ? Boolean.valueOf(var13_2 /* !! */ .getIslandStateChanged()) : null;
                                                                                                                                                                                                                                                                    var17_14 = new StringBuilder();
                                                                                                                                                                                                                                                                    var17_14.append("tempHiddenChange=");
                                                                                                                                                                                                                                                                    var17_14.append(var14_4);
                                                                                                                                                                                                                                                                    var17_14.append(" isTempHidden=");
                                                                                                                                                                                                                                                                    var17_14.append(var9_5);
                                                                                                                                                                                                                                                                    var17_14.append(" panelHeightChanging=");
                                                                                                                                                                                                                                                                    var17_14.append(var11_7);
                                                                                                                                                                                                                                                                    var17_14.append(" isToScreenLockNoAnimation=");
                                                                                                                                                                                                                                                                    var17_14.append(var8_9);
                                                                                                                                                                                                                                                                    var17_14.append(" configChange=");
                                                                                                                                                                                                                                                                    var17_14.append(var16_8);
                                                                                                                                                                                                                                                                    var17_14.append(" isShowOnceIsland: ");
                                                                                                                                                                                                                                                                    var17_14.append(var10_6);
                                                                                                                                                                                                                                                                    var17_14.append("islandStateChanged=");
                                                                                                                                                                                                                                                                    var17_14.append(var13_2 /* !! */ );
                                                                                                                                                                                                                                                                    Log.e((String)"DynamicIslandAnimDebug", (String)var17_14.toString());
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = var1_1.getLastState();
                                                                                                                                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.ShowOnceBigIsland)) break block237;
                                                                                                                                                                                                                                                                    var13_2 /* !! */  = var1_1.getState();
                                                                                                                                                                                                                                                                    if (var13_2 /* !! */  instanceof DynamicIslandState.Deleted) {
                                                                                                                                                                                                                                                                        this.bigIslandToDeletedAnimation(var1_1);
lbl83:
                                                                                                                                                                                                                                                                        // 40 sources

                                                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                                                            var2_15 = false;
                                                                                                                                                                                                                                                                            break block236;
                                                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.Expanded)) break block238;
                                                                                                                                                                                                                                                                    this.bigIslandToExpandedAnimation(var1_1);
                                                                                                                                                                                                                                                                    ** GOTO lbl83
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                if (!(var13_2 /* !! */  instanceof DynamicIslandState.ShowOnceBigIsland)) ** GOTO lbl83
                                                                                                                                                                                                                                                                if (!var15_3.getIS_TABLET()) break block239;
                                                                                                                                                                                                                                                                if (!var12_11) break block240;
                                                                                                                                                                                                                                                                this.updateOrientationBigIslandToTempHiddenNoAnimation(var1_1);
                                                                                                                                                                                                                                                                ** GOTO lbl83
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            if (o.c((Object)var14_4, (Object)Boolean.TRUE) && !var9_5) {
                                                                                                                                                                                                                                                                this.tempHiddenToBigIslandAnimation(var1_1, false);
lbl98:
                                                                                                                                                                                                                                                                // 3 sources

                                                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                                                    var2_15 = false;
                                                                                                                                                                                                                                                                    break block236;
                                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            this.bigIslandChangedAnimation(var1_1);
                                                                                                                                                                                                                                                            ** GOTO lbl83
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        this.bigIslandChangedAnimation(var1_1);
                                                                                                                                                                                                                                                        ** GOTO lbl83
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.Init)) break block241;
                                                                                                                                                                                                                                                    var13_2 /* !! */  = var1_1.getState();
                                                                                                                                                                                                                                                    if (var13_2 /* !! */  instanceof DynamicIslandState.Expanded) {
                                                                                                                                                                                                                                                        this.initToExpandedAnimation(var1_1);
lbl111:
                                                                                                                                                                                                                                                        // 4 sources

                                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                                            var2_15 = true;
                                                                                                                                                                                                                                                            break block236;
                                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland)) break block242;
                                                                                                                                                                                                                                                    if (!var9_5) break block243;
                                                                                                                                                                                                                                                    this.updateOrientationSmallIslandToTempHiddenNoAnimation(var1_1);
                                                                                                                                                                                                                                                    ** GOTO lbl83
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                this.initToSmallIslandAnimation(var1_1);
                                                                                                                                                                                                                                                if (!var10_6 || var15_3.getIS_TABLET()) ** GOTO lbl83
                                                                                                                                                                                                                                                this.smallIslandToTempHiddenAnimation(var1_1);
                                                                                                                                                                                                                                                ** GOTO lbl83
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.BigIsland)) break block244;
                                                                                                                                                                                                                                            if (!var9_5) break block245;
                                                                                                                                                                                                                                            this.updateOrientationBigIslandToTempHiddenNoAnimation(var1_1);
                                                                                                                                                                                                                                            ** GOTO lbl83
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        this.initToBigIslandAnimation(var1_1);
                                                                                                                                                                                                                                        if (!var10_6 || var15_3.getIS_TABLET()) ** GOTO lbl83
                                                                                                                                                                                                                                        this.bigIslandToTempHiddenAnimation(var1_1);
                                                                                                                                                                                                                                        ** GOTO lbl83
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.ShowOnceBigIsland)) break block246;
                                                                                                                                                                                                                                    if (!var10_6 || var9_5) break block247;
                                                                                                                                                                                                                                    this.initToBigIslandAnimation(var1_1);
                                                                                                                                                                                                                                    ** GOTO lbl83
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                this.initToTempHiddenAnimation(var1_1);
                                                                                                                                                                                                                                ** GOTO lbl83
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            var5_10 = var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded;
                                                                                                                                                                                                                            if (!var5_10) break block248;
                                                                                                                                                                                                                            this.initToAppExpandedAnimation(var1_1);
                                                                                                                                                                                                                            ** GOTO lbl83
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        var5_10 = var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded;
                                                                                                                                                                                                                        if (!var5_10) break block249;
                                                                                                                                                                                                                        this.initToMiniWindowExpandedAnimation(var1_1);
                                                                                                                                                                                                                        ** GOTO lbl83
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.Hidden)) break block250;
                                                                                                                                                                                                                    this.initToHiddenNoAnimation(var1_1);
                                                                                                                                                                                                                    ** GOTO lbl83
                                                                                                                                                                                                                }
                                                                                                                                                                                                                if (!(var13_2 /* !! */  instanceof DynamicIslandState.Deleted)) ** GOTO lbl83
                                                                                                                                                                                                                this.hiddenToDeletedAnimation(var1_1);
                                                                                                                                                                                                                ** GOTO lbl83
                                                                                                                                                                                                            }
                                                                                                                                                                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland)) break block251;
                                                                                                                                                                                                            var13_2 /* !! */  = var1_1.getState();
                                                                                                                                                                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.Expanded)) break block252;
                                                                                                                                                                                                            this.smallIslandToExpandedAnimation(var1_1);
                                                                                                                                                                                                            ** GOTO lbl83
                                                                                                                                                                                                        }
                                                                                                                                                                                                        if (!(var13_2 /* !! */  instanceof DynamicIslandState.BigIsland)) break block253;
                                                                                                                                                                                                        this.smallIslandToBigIslandAnimation(var1_1);
                                                                                                                                                                                                        if (var9_5) {
                                                                                                                                                                                                            if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                                                                                                                                                                this.updateOrientationBigIslandToTempHiddenNoAnimation(var1_1);
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                this.bigIslandToTempHiddenAnimation(var1_1);
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                        if (var10_6) {
                                                                                                                                                                                                            this.bigIslandToTempHiddenAnimation(var1_1);
                                                                                                                                                                                                        }
                                                                                                                                                                                                        ** GOTO lbl83
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland)) break block254;
                                                                                                                                                                                                    if (var8_9) {
                                                                                                                                                                                                        this.beforeSmallIslandToTempHiddenAnimation(var1_1);
                                                                                                                                                                                                    }
                                                                                                                                                                                                    if (var9_5 || var10_6) break block255;
                                                                                                                                                                                                    var13_2 /* !! */  = Boolean.TRUE;
                                                                                                                                                                                                    if (!o.c((Object)var14_4, (Object)var13_2 /* !! */ )) break block256;
                                                                                                                                                                                                    if (!o.c((Object)var16_8, (Object)var13_2 /* !! */ )) break block257;
                                                                                                                                                                                                    this.tempHiddenToSmallIslandAnimation(var1_1, true);
                                                                                                                                                                                                    ** GOTO lbl83
                                                                                                                                                                                                }
                                                                                                                                                                                                this.tempHiddenToSmallIslandAnimation(var1_1, false);
                                                                                                                                                                                                ** GOTO lbl98
                                                                                                                                                                                            }
                                                                                                                                                                                            if (!o.c((Object)var16_8, (Object)var13_2 /* !! */ )) break block258;
                                                                                                                                                                                            this.smallIslandChangedNoAnimation(var1_1);
                                                                                                                                                                                            ** GOTO lbl83
                                                                                                                                                                                        }
                                                                                                                                                                                        if (var8_9) ** GOTO lbl83
                                                                                                                                                                                        this.smallIslandChangedAnimation(var1_1);
                                                                                                                                                                                        ** GOTO lbl83
                                                                                                                                                                                    }
                                                                                                                                                                                    if (o.c((Object)var16_8, (Object)Boolean.TRUE) || var8_9) break block259;
                                                                                                                                                                                    this.smallIslandToTempHiddenAnimation(var1_1);
                                                                                                                                                                                    ** GOTO lbl83
                                                                                                                                                                                }
                                                                                                                                                                                this.updateOrientationSmallIslandToTempHiddenNoAnimation(var1_1);
                                                                                                                                                                                ** GOTO lbl83
                                                                                                                                                                            }
                                                                                                                                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.Hidden)) break block260;
                                                                                                                                                                            if (!o.c((Object)var16_8, (Object)Boolean.TRUE) && !var8_9) {
                                                                                                                                                                                if (var10_6) {
                                                                                                                                                                                    this.smallIslandToTempHiddenAnimation(var1_1);
                                                                                                                                                                                } else {
                                                                                                                                                                                    this.smallIslandToHiddenAnimation(var1_1);
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                this.smallIslandToHiddenNoAnimation(var1_1);
                                                                                                                                                                            }
                                                                                                                                                                            this.getCallback().onStateChange("small_to_hidden", var1_1);
                                                                                                                                                                            ** GOTO lbl83
                                                                                                                                                                        }
                                                                                                                                                                        if (!(var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded)) break block261;
                                                                                                                                                                        this.smallIslandToHiddenAnimation(var1_1);
                                                                                                                                                                        ** GOTO lbl83
                                                                                                                                                                    }
                                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded)) break block262;
                                                                                                                                                                    this.smallIslandToAppExpandedAnimation(var1_1);
                                                                                                                                                                    ** GOTO lbl83
                                                                                                                                                                }
                                                                                                                                                                if (!(var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded)) break block263;
                                                                                                                                                                this.smallIslandToHiddenAnimation(var1_1);
                                                                                                                                                                ** GOTO lbl83
                                                                                                                                                            }
                                                                                                                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded)) break block264;
                                                                                                                                                            this.smallIslandToMiniWindowExpandedAnimation(var1_1);
                                                                                                                                                            ** GOTO lbl83
                                                                                                                                                        }
                                                                                                                                                        if (!(var13_2 /* !! */  instanceof DynamicIslandState.Deleted)) ** GOTO lbl83
                                                                                                                                                        this.smallIslandToDeletedAnimation(var1_1);
                                                                                                                                                        ** GOTO lbl83
                                                                                                                                                    }
                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.BigIsland)) break block265;
                                                                                                                                                    var13_2 /* !! */  = var1_1.getState();
                                                                                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.Expanded)) break block266;
                                                                                                                                                    if (!var15_3.getIS_TABLET() || !var9_5) break block267;
                                                                                                                                                    this.initToExpandedAnimation(var1_1);
                                                                                                                                                    ** GOTO lbl83
                                                                                                                                                }
                                                                                                                                                this.bigIslandToExpandedAnimation(var1_1);
                                                                                                                                                ** GOTO lbl83
                                                                                                                                            }
                                                                                                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.BigIsland)) break block268;
                                                                                                                                            if (var8_9) {
                                                                                                                                                this.beforeBigIslandToTempHiddenAnimation(var1_1);
                                                                                                                                            }
                                                                                                                                            if (var9_5 || var10_6 && !var15_3.getIS_TABLET()) break block269;
                                                                                                                                            var13_2 /* !! */  = Boolean.TRUE;
                                                                                                                                            if (!o.c((Object)var14_4, (Object)var13_2 /* !! */ )) break block270;
                                                                                                                                            if (!o.c((Object)var16_8, (Object)var13_2 /* !! */ )) break block271;
                                                                                                                                            this.tempHiddenToBigIslandAnimation(var1_1, true);
                                                                                                                                            ** GOTO lbl83
                                                                                                                                        }
                                                                                                                                        if (!var15_3.getIS_TABLET()) break block272;
                                                                                                                                        var10_6 = (Boolean)this.dynamicIslandWindowState.getStatusBarDisappearance().getValue();
                                                                                                                                        var12_11 = (Boolean)this.dynamicIslandWindowState.getStatusBarisTransientShowing().getValue();
                                                                                                                                        var13_2 /* !! */  = var1_1.getCurrentIslandData();
                                                                                                                                        var2_15 = var13_2 /* !! */  != null && (var13_2 /* !! */  = var13_2 /* !! */ .getProperties()) != null && var13_2 /* !! */ .intValue() == 0;
                                                                                                                                        if (!var11_7 || var10_6) break block273;
                                                                                                                                        var2_15 = false;
                                                                                                                                        this.tempHiddenToBigIslandAnimation(var1_1, false);
                                                                                                                                        break block236;
                                                                                                                                    }
                                                                                                                                    if (!var10_6 || var2_15) break block274;
                                                                                                                                    this.moveUpAnimation(var1_1);
                                                                                                                                    this.isRecover = true;
                                                                                                                                    ** GOTO lbl83
                                                                                                                                }
                                                                                                                                if (var12_11 && this.isRecover && !var2_15) {
                                                                                                                                    this.moveDownAnimation(var1_1);
                                                                                                                                    this.isRecover = false;
                                                                                                                                    ** continue;
                                                                                                                                }
                                                                                                                                if (!var5_10 || var2_15) break block275;
                                                                                                                                this.bigIslandToTempHiddenAnimation(var1_1);
                                                                                                                                ** GOTO lbl83
                                                                                                                            }
                                                                                                                            this.immersiveAlphaAnimation(var1_1);
                                                                                                                            ** while (true)
                                                                                                                        }
                                                                                                                        var2_15 = false;
                                                                                                                        this.tempHiddenToBigIslandAnimation(var1_1, false);
                                                                                                                        break block236;
                                                                                                                    }
                                                                                                                    var4_17 = false;
                                                                                                                    var3_19 = !var15_3.getIS_TABLET() || ((Boolean)this.dynamicIslandWindowState.getStatusBarWindowsInsetsShow().getValue()).booleanValue() || (var2_15 = (var15_3 = var1_1.getCurrentIslandData()) != null && (var15_3 = var15_3.getProperties()) != null && var15_3.intValue() == 0);
                                                                                                                    if (o.c((Object)var16_8, (Object)var13_2 /* !! */ ) && var3_19) {
                                                                                                                        this.bigIslandChangedNoAnimation(var1_1);
                                                                                                                        var2_15 = var4_17;
                                                                                                                    } else {
                                                                                                                        var2_15 = var4_17;
                                                                                                                        if (o.c((Object)var16_8, (Object)Boolean.FALSE)) {
                                                                                                                            var2_15 = var4_17;
                                                                                                                            if (!var8_9) {
                                                                                                                                var2_15 = var4_17;
                                                                                                                                if (var3_19) {
                                                                                                                                    this.bigIslandChangedAnimation(var1_1);
                                                                                                                                    var2_15 = var4_17;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                    break block236;
                                                                                                                }
                                                                                                                var4_16 = false;
                                                                                                                var10_6 = var15_3.getIS_TABLET();
                                                                                                                var13_2 /* !! */  = var1_1.getCurrentIslandData();
                                                                                                                var2_15 = var13_2 /* !! */  != null && (var13_2 /* !! */  = var13_2 /* !! */ .getProperties()) != null && var13_2 /* !! */ .intValue() == 0;
                                                                                                                var3_20 = o.c((Object)var16_8, (Object)Boolean.TRUE) || var8_9 || var15_3.getIS_TABLET() && var5_10 && !var2_15;
                                                                                                                if (!var3_20 || var10_6) break block276;
                                                                                                                this.updateOrientationBigIslandToTempHiddenNoAnimation(var1_1);
                                                                                                                var2_15 = var4_16;
                                                                                                                break block236;
                                                                                                            }
                                                                                                            if (!var10_6 || !var2_15) break block277;
                                                                                                            var2_15 = var4_16;
                                                                                                            if (!var12_11) break block236;
                                                                                                        }
                                                                                                        this.bigIslandToTempHiddenAnimation(var1_1);
                                                                                                        var2_15 = var4_16;
                                                                                                        break block236;
                                                                                                    }
                                                                                                    var3_21 = false;
                                                                                                    if (var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland) {
                                                                                                        if (var8_9) {
                                                                                                            this.beforeSmallIslandToTempHiddenAnimation(var1_1);
                                                                                                        }
                                                                                                        if (var9_5) {
                                                                                                            if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                                                                this.updateOrientationSmallIslandToTempHiddenNoAnimation(var1_1);
                                                                                                                var2_15 = var3_21;
                                                                                                            } else {
                                                                                                                this.smallIslandToTempHiddenAnimation(var1_1);
                                                                                                                var2_15 = var3_21;
                                                                                                            }
                                                                                                        } else if (var10_6) {
                                                                                                            this.smallIslandToTempHiddenAnimation(var1_1);
                                                                                                            var2_15 = var3_21;
                                                                                                        } else if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                                                            this.bigIslandToSmallIslandNoAnimation(var1_1);
                                                                                                            var2_15 = var3_21;
                                                                                                        } else {
                                                                                                            this.bigIslandToSmallIslandAnimation(var1_1);
                                                                                                            var2_15 = var3_21;
                                                                                                        }
                                                                                                    } else if (var13_2 /* !! */  instanceof DynamicIslandState.Hidden) {
                                                                                                        this.bigIslandToHiddenAnimation(var1_1);
                                                                                                        this.getCallback().onStateChange("big_to_hidden", var1_1);
                                                                                                        var2_15 = var3_21;
                                                                                                    } else if (var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded) {
                                                                                                        this.bigIslandToHiddenAnimation(var1_1);
                                                                                                        var2_15 = var3_21;
                                                                                                    } else if (var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded) {
                                                                                                        if (var15_3.getIS_TABLET() && !((Boolean)this.externalStateRepository.getNotificationAppearance().getValue()).booleanValue()) {
                                                                                                            var13_2 /* !! */  = this.getAnimator(var1_1);
                                                                                                            var2_15 = var3_21;
                                                                                                            if (var13_2 /* !! */  != null) {
                                                                                                                var13_2 /* !! */ .bigIslandToAppExpandedNoAnimation(var1_1);
                                                                                                                var13_2 /* !! */  = s.a;
                                                                                                                var2_15 = var3_21;
                                                                                                            }
                                                                                                        } else {
                                                                                                            this.bigIslandToAppExpandedAnimation(var1_1);
                                                                                                            var2_15 = var3_21;
                                                                                                        }
                                                                                                    } else if (var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded) {
                                                                                                        this.bigIslandToHiddenAnimation(var1_1);
                                                                                                        var2_15 = var3_21;
                                                                                                    } else if (var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded) {
                                                                                                        this.bigIslandToMiniWindowExpandedAnimation(var1_1);
                                                                                                        var2_15 = var3_21;
                                                                                                    } else {
                                                                                                        var2_15 = var3_21;
                                                                                                        if (var13_2 /* !! */  instanceof DynamicIslandState.Deleted) {
                                                                                                            if (var15_3.getIS_TABLET() && var9_5) {
                                                                                                                this.hiddenToDeletedAnimation(var1_1);
                                                                                                                var2_15 = var3_21;
                                                                                                            } else {
                                                                                                                this.bigIslandToDeletedAnimation(var1_1);
                                                                                                                var2_15 = var3_21;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    break block236;
                                                                                                }
                                                                                                var4_18 = false;
                                                                                                var3_22 = false;
                                                                                                var5_10 = var13_2 /* !! */  instanceof DynamicIslandState.Expanded != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.Deleted;
                                                                                                if (!var5_10) break block278;
                                                                                                var13_2 /* !! */  = var1_1.getState();
                                                                                                if (!(var13_2 /* !! */  instanceof DynamicIslandState.ShowOnceBigIsland)) break block279;
                                                                                                if (var8_9) {
                                                                                                    this.expandedToBigIslandNoAnimation(var1_1);
                                                                                                } else if (var9_5) {
                                                                                                    this.expandedToTempHiddenAnimation(var1_1);
                                                                                                } else {
                                                                                                    this.expandedToBigIslandAnimation(var1_1);
                                                                                                }
                                                                                                this.getCallback().onStateChange("expanded_to_big", var1_1);
                                                                                                var2_15 = var4_18;
                                                                                                break block236;
                                                                                            }
                                                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.BigIsland)) break block280;
                                                                                            if (var8_9) {
                                                                                                this.expandedToTempHiddenNoAnimation(var1_1);
                                                                                            }
                                                                                            if (var9_5) {
                                                                                                if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                                                    this.expandedToTempHiddenNoAnimation(var1_1);
                                                                                                } else {
                                                                                                    this.expandedToTempHiddenAnimation(var1_1);
                                                                                                }
                                                                                            } else if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                                                this.expandedToBigIslandNoAnimation(var1_1);
                                                                                            } else if (var10_6 && !var15_3.getIS_TABLET()) {
                                                                                                this.expandedToTempHiddenAnimation(var1_1);
                                                                                            } else if (var15_3.getIS_TABLET() && !((Boolean)this.dynamicIslandWindowState.getStatusBarWindowsInsetsShow().getValue()).booleanValue()) {
                                                                                                this.expandedToTempHiddenAnimation(var1_1);
                                                                                            } else {
                                                                                                this.expandedToBigIslandAnimation(var1_1);
                                                                                            }
                                                                                            this.getCallback().onStateChange("expanded_to_big", var1_1);
                                                                                            var2_15 = var4_18;
                                                                                            break block236;
                                                                                        }
                                                                                        if (!(var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland)) break block281;
                                                                                        if (var8_9) {
                                                                                            this.expandedToTempHiddenNoAnimation(var1_1);
                                                                                        }
                                                                                        if (var9_5) {
                                                                                            if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                                                this.expandedToTempHiddenNoAnimation(var1_1);
                                                                                                var2_15 = var4_18;
                                                                                            } else {
                                                                                                this.expandedToTempHiddenAnimation(var1_1);
                                                                                                var2_15 = var4_18;
                                                                                            }
                                                                                        } else if (var10_6) {
                                                                                            this.expandedToTempHiddenAnimation(var1_1);
                                                                                            var2_15 = var4_18;
                                                                                        } else if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                                            this.expandedToSmallIslandNoAnimation(var1_1);
                                                                                            var2_15 = var4_18;
                                                                                        } else {
                                                                                            this.expandedToSmallIslandAnimation(var1_1);
                                                                                            var2_15 = var4_18;
                                                                                        }
                                                                                        break block236;
                                                                                    }
                                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.Expanded)) break block282;
                                                                                    this.expandedChangedAnimation(var1_1);
                                                                                    ** GOTO lbl111
                                                                                }
                                                                                if (!(var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded)) break block283;
                                                                                this.expandedToAppExpandedAnimation(var1_1);
                                                                                var2_15 = var4_18;
                                                                                break block236;
                                                                            }
                                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded)) break block284;
                                                                            this.expandedToTempHiddenAnimation(var1_1);
                                                                            var2_15 = var4_18;
                                                                            break block236;
                                                                        }
                                                                        if (!(var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded)) break block285;
                                                                        this.expandedToMiniWindowAnimation(var1_1);
                                                                        var2_15 = var4_18;
                                                                        break block236;
                                                                    }
                                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded)) break block286;
                                                                    this.expandedToTempHiddenAnimation(var1_1);
                                                                    var2_15 = var4_18;
                                                                    break block236;
                                                                }
                                                                if (!(var13_2 /* !! */  instanceof DynamicIslandState.Hidden)) break block287;
                                                                if (var8_9) {
                                                                    this.expandedToTempHiddenNoAnimation(var1_1);
                                                                }
                                                                if (var9_5) {
                                                                    if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                        this.expandedToTempHiddenNoAnimation(var1_1);
                                                                    } else {
                                                                        this.expandedToTempHiddenAnimation(var1_1);
                                                                    }
                                                                } else if (var10_6) {
                                                                    this.expandedToTempHiddenAnimation(var1_1);
                                                                } else if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                                    this.expandedToHiddenNoAnim(var1_1);
                                                                } else {
                                                                    if (var15_3.getIS_TABLET() && !((Boolean)this.dynamicIslandWindowState.getStatusBarWindowsInsetsShow().getValue()).booleanValue()) {
                                                                        this.expandedToTempHiddenAnimation(var1_1);
                                                                    } else {
                                                                        this.expandedToHiddenAnimation(var1_1);
                                                                    }
                                                                    if (var15_3.getIS_TABLET()) {
                                                                        if (!this.dynamicIslandWindowState.isSplitScreenMode() && (var13_2 /* !! */  = var1_1.getDynamicIslandEventCoordinator()) != null && (var13_2 /* !! */  = var13_2 /* !! */ .getBigIslandStateHandler()) != null && (var13_2 /* !! */  = var13_2 /* !! */ .getCurrent()) != null && (var15_3 = this.getAnimator((DynamicIslandBaseContentView)var13_2 /* !! */ )) != null) {
                                                                            var15_3.bigIslandScaleAnimation((DynamicIslandContentView)var13_2 /* !! */ , 100L);
                                                                            var13_2 /* !! */  = s.a;
                                                                        }
                                                                    } else {
                                                                        var13_2 /* !! */  = var1_1.getDynamicIslandEventCoordinator();
                                                                        if (var13_2 /* !! */  != null && (var13_2 /* !! */  = var13_2 /* !! */ .getSmallIslandStateHandler()) != null && (var13_2 /* !! */  = var13_2 /* !! */ .getCurrent()) != null) {
                                                                            this.smallIslandScaleAnimation((DynamicIslandContentView)var13_2 /* !! */ );
                                                                            var13_2 /* !! */  = s.a;
                                                                        }
                                                                    }
                                                                }
                                                                this.getCallback().onStateChange("expanded_to_hidden", var1_1);
                                                                var2_15 = var4_18;
                                                                break block236;
                                                            }
                                                            var2_15 = var4_18;
                                                            if (!(var13_2 /* !! */  instanceof DynamicIslandState.Deleted)) break block236;
                                                            if (var8_9) {
                                                                this.expandedToDeletedNoAnimation(var1_1);
                                                            }
                                                            var13_2 /* !! */  = var1_1.getState();
                                                            var2_15 = var3_22;
                                                            if (var13_2 /* !! */  != null) {
                                                                var2_15 = var3_22;
                                                                if (var13_2 /* !! */ .getDeleteNoAnimation()) {
                                                                    var2_15 = true;
                                                                }
                                                            }
                                                            if (!var2_15) break block288;
                                                            this.expandedToDeletedNoAnimation(var1_1);
                                                            ** GOTO lbl111
                                                        }
                                                        this.expandedToDeletedAnimation(var1_1);
                                                        ** while (true)
                                                    }
                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded)) break block289;
                                                    var13_2 /* !! */  = var1_1.getState();
                                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.BigIsland)) break block290;
                                                    var2_15 = var4_18;
                                                    if (var9_5) break block236;
                                                    if (!var10_6) break block291;
                                                    var2_15 = var4_18;
                                                    if (!var15_3.getIS_TABLET()) break block236;
                                                }
                                                this.hiddenToBigIslandAnimation(var1_1);
                                                var2_15 = var4_18;
                                                break block236;
                                            }
                                            if (var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland) {
                                                if (var9_5) {
                                                    if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                        this.updateOrientationSmallIslandToTempHiddenNoAnimation(var1_1);
                                                        var2_15 = var4_18;
                                                    } else {
                                                        this.smallIslandToTempHiddenAnimation(var1_1);
                                                        var2_15 = var4_18;
                                                    }
                                                } else {
                                                    var2_15 = var4_18;
                                                    if (!var10_6) {
                                                        this.hiddenToSmallIslandAnimation(var1_1);
                                                        var2_15 = var4_18;
                                                    }
                                                }
                                            } else if (var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded) {
                                                if (var8_9) {
                                                    this.hiddenToTempHiddenNoAnimation(var1_1);
                                                }
                                                if (var9_5) {
                                                    if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                        this.hiddenChangedNoAnimation(var1_1);
                                                        var2_15 = var4_18;
                                                    } else {
                                                        this.hiddenToTempHiddenAnimation(var1_1);
                                                        var2_15 = var4_18;
                                                    }
                                                } else if (var10_6) {
                                                    this.hiddenToTempHiddenAnimation(var1_1);
                                                    var2_15 = var4_18;
                                                } else {
                                                    this.hiddenChangedAnimation(var1_1);
                                                    var2_15 = var4_18;
                                                }
                                            } else if (var13_2 /* !! */  instanceof DynamicIslandState.Hidden) {
                                                this.expandedToHiddenAnimation(var1_1);
                                                this.getCallback().onStateChange("sub_app_to_hidden", var1_1);
                                                var2_15 = var4_18;
                                            } else {
                                                var2_15 = var4_18;
                                                if (var13_2 /* !! */  instanceof DynamicIslandState.Deleted) {
                                                    this.hiddenToDeletedAnimation(var1_1);
                                                    var2_15 = var4_18;
                                                }
                                            }
                                            break block236;
                                        }
                                        if (!(var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded)) break block292;
                                        var13_2 /* !! */  = var1_1.getState();
                                        if (var13_2 /* !! */  instanceof DynamicIslandState.BigIsland) {
                                            this.appExpandedToBigIslandAnimation(var1_1);
                                            if (var9_5) {
                                                if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                    this.updateOrientationBigIslandToTempHiddenNoAnimation(var1_1);
                                                    var2_15 = var4_18;
                                                } else {
                                                    this.bigIslandToTempHiddenAnimation(var1_1);
                                                    var2_15 = var4_18;
                                                }
                                            } else {
                                                var2_15 = var4_18;
                                                if (var10_6) {
                                                    var2_15 = var4_18;
                                                    if (!var15_3.getIS_TABLET()) {
                                                        this.bigIslandToTempHiddenAnimation(var1_1);
                                                        var2_15 = var4_18;
                                                    }
                                                }
                                            }
                                        } else if (var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland) {
                                            if (var9_5) {
                                                if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                    this.updateOrientationSmallIslandToTempHiddenNoAnimation(var1_1);
                                                    var2_15 = var4_18;
                                                } else {
                                                    this.smallIslandToTempHiddenAnimation(var1_1);
                                                    var2_15 = var4_18;
                                                }
                                            } else if (var10_6) {
                                                this.smallIslandToTempHiddenAnimation(var1_1);
                                                var2_15 = var4_18;
                                            } else {
                                                this.appExpandedToSmallIslandAnimation(var1_1);
                                                var2_15 = var4_18;
                                            }
                                        } else if (var13_2 /* !! */  instanceof DynamicIslandState.Hidden) {
                                            if (var10_6 && !var15_3.getIS_TABLET()) {
                                                this.appExpandedToTempHiddenAnimation(var1_1);
                                            } else {
                                                this.appExpandedToHiddenAnimation(var1_1);
                                            }
                                            this.getCallback().onStateChange("app_to_hidden", var1_1);
                                            var2_15 = var4_18;
                                            if (var15_3.getIS_TABLET()) {
                                                var2_15 = var4_18;
                                                if (!this.dynamicIslandWindowState.isSplitScreenMode()) {
                                                    var13_2 /* !! */  = var1_1.getDynamicIslandEventCoordinator();
                                                    var2_15 = var4_18;
                                                    if (var13_2 /* !! */  != null) {
                                                        var13_2 /* !! */  = var13_2 /* !! */ .getBigIslandStateHandler();
                                                        var2_15 = var4_18;
                                                        if (var13_2 /* !! */  != null) {
                                                            var13_2 /* !! */  = var13_2 /* !! */ .getCurrent();
                                                            var2_15 = var4_18;
                                                            if (var13_2 /* !! */  != null) {
                                                                var15_3 = this.getAnimator((DynamicIslandBaseContentView)var13_2 /* !! */ );
                                                                var2_15 = var4_18;
                                                                if (var15_3 != null) {
                                                                    var15_3.bigIslandScaleAnimation((DynamicIslandContentView)var13_2 /* !! */ , 150L);
                                                                    var13_2 /* !! */  = s.a;
                                                                    var2_15 = var4_18;
                                                                    ** GOTO lbl830
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (var13_2 /* !! */  instanceof DynamicIslandState.Deleted) {
                                            this.hiddenToDeletedAnimation(var1_1);
                                            var2_15 = var4_18;
                                        } else if (var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded) {
                                            this.appExpandedToMiniWindowExpandedAnimation(var1_1);
                                            var2_15 = var4_18;
                                        } else {
                                            var2_15 = var4_18;
                                            if (var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded) {
                                                this.appExpandedToAppExpandedAnimation(var1_1);
                                                if (var9_5) {
                                                    if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                                        this.hiddenChangedNoAnimation(var1_1);
                                                        var2_15 = var4_18;
                                                    } else {
                                                        this.hiddenToTempHiddenAnimation(var1_1);
                                                        var2_15 = var4_18;
                                                    }
                                                } else {
                                                    this.hiddenChangedAnimation(var1_1);
                                                    var2_15 = var4_18;
                                                }
                                            }
                                        }
                                        break block236;
                                    }
                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded)) break block293;
                                    var13_2 /* !! */  = var1_1.getState();
                                    if (!(var13_2 /* !! */  instanceof DynamicIslandState.BigIsland)) break block294;
                                    var2_15 = var4_18;
                                    if (var9_5) break block236;
                                    if (var15_3.getIS_TABLET()) break block295;
                                    var2_15 = var4_18;
                                    if (var10_6) break block236;
                                }
                                this.hiddenToBigIslandAnimation(var1_1);
                                var2_15 = var4_18;
                                break block236;
                            }
                            if (var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland) {
                                if (!var9_5 && !var10_6) {
                                    this.hiddenToSmallIslandAnimation(var1_1);
                                    var2_15 = var4_18;
                                } else {
                                    this.miniWindowToTempHiddenAnimation(var1_1);
                                    var2_15 = var4_18;
                                }
                            } else if (var13_2 /* !! */  instanceof DynamicIslandState.Hidden) {
                                if (!var9_5 && !var10_6) {
                                    this.hiddenToTempHiddenAnimation(var1_1);
                                } else {
                                    this.miniWindowToTempHiddenAnimation(var1_1);
                                }
                                this.getCallback().onStateChange("sub_mini_window_to_hidden", var1_1);
                                var2_15 = var4_18;
                            } else if (var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded) {
                                if (var8_9) {
                                    this.hiddenToTempHiddenNoAnimation(var1_1);
                                }
                                if (var9_5) {
                                    if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                        this.hiddenChangedNoAnimation(var1_1);
                                        var2_15 = var4_18;
                                    } else {
                                        this.hiddenToTempHiddenAnimation(var1_1);
                                        var2_15 = var4_18;
                                    }
                                } else if (var10_6) {
                                    this.hiddenToTempHiddenAnimation(var1_1);
                                    var2_15 = var4_18;
                                } else {
                                    this.hiddenChangedAnimation(var1_1);
                                    var2_15 = var4_18;
                                }
                            } else {
                                var2_15 = var4_18;
                                if (var13_2 /* !! */  instanceof DynamicIslandState.Deleted) {
                                    this.hiddenToDeletedAnimation(var1_1);
                                    var2_15 = var4_18;
                                }
                            }
                            break block236;
                        }
                        if (var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded) {
                            var13_2 /* !! */  = var1_1.getState();
                            if (var13_2 /* !! */  instanceof DynamicIslandState.BigIsland) {
                                if (!(var9_5 || var10_6 && !var15_3.getIS_TABLET())) {
                                    this.miniWindowToBigIslandAnimation(var1_1);
                                    var2_15 = var4_18;
                                } else {
                                    this.miniWindowToTempHiddenAnimation(var1_1);
                                    var2_15 = var4_18;
                                }
                            } else if (var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland) {
                                if (!var9_5 && !var10_6) {
                                    this.miniWindowToSmallIslandAnimation(var1_1);
                                    var2_15 = var4_18;
                                } else {
                                    this.miniWindowToTempHiddenAnimation(var1_1);
                                    var2_15 = var4_18;
                                }
                            } else if (var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded) {
                                if (var8_9) {
                                    this.miniWindowToTempHiddenNoAnimation(var1_1);
                                }
                                if (!var9_5 && !var10_6) {
                                    this.hiddenChangedAnimation(var1_1);
                                    var2_15 = var4_18;
                                } else if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                    this.hiddenChangedNoAnimation(var1_1);
                                    var2_15 = var4_18;
                                } else {
                                    this.hiddenToTempHiddenAnimation(var1_1);
                                    var2_15 = var4_18;
                                }
                            } else if (var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded) {
                                this.miniWindowToAppExpanded(var1_1);
                                var2_15 = var4_18;
                            } else if (var13_2 /* !! */  instanceof DynamicIslandState.Hidden) {
                                if (var10_6) {
                                    this.miniWindowToTempHiddenAnimation(var1_1);
                                } else {
                                    this.expandedToHiddenAnimation(var1_1);
                                }
                                this.getCallback().onStateChange("mini_window_to_hidden", var1_1);
                                var2_15 = var4_18;
                            } else {
                                var2_15 = var4_18;
                                if (var13_2 /* !! */  instanceof DynamicIslandState.Deleted) {
                                    this.hiddenToDeletedAnimation(var1_1);
                                    var2_15 = var4_18;
                                }
                            }
                        } else {
                            var2_15 = var4_18;
                            if (var13_2 /* !! */  instanceof DynamicIslandState.Hidden) {
                                var13_2 /* !! */  = var1_1.getState();
                                if (var13_2 /* !! */  instanceof DynamicIslandState.BigIsland) {
                                    if (!(var9_5 || var10_6 && !var15_3.getIS_TABLET())) {
                                        this.hiddenToBigIslandAnimation(var1_1);
                                    }
                                    this.getCallback().onStateChange("hidden_to_big", var1_1);
                                    var2_15 = var4_18;
                                } else if (var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland) {
                                    if (var9_5) {
                                        if (o.c((Object)var16_8, (Object)Boolean.TRUE)) {
                                            this.updateOrientationSmallIslandToTempHiddenNoAnimation(var1_1);
                                        } else {
                                            this.smallIslandToTempHiddenAnimation(var1_1);
                                        }
                                    } else if (var10_6) {
                                        this.smallIslandToTempHiddenAnimation(var1_1);
                                    } else {
                                        this.hiddenToSmallIslandAnimation(var1_1);
                                    }
                                    this.getCallback().onStateChange("hidden_to_small", var1_1);
                                    var2_15 = var4_18;
                                } else if (var13_2 /* !! */  instanceof DynamicIslandState.Expanded) {
                                    this.initToExpandedAnimation(var1_1);
                                    this.getCallback().onStateChange("hidden_to_expanded", var1_1);
                                    var2_15 = var4_18;
                                } else if (var13_2 /* !! */  instanceof DynamicIslandState.Hidden) {
                                    if (var8_9) {
                                        this.hiddenToTempHiddenNoAnimation(var1_1);
                                    }
                                    if (var9_5) {
                                        if (!o.c((Object)var16_8, (Object)Boolean.TRUE) && !var15_3.getIS_TABLET()) {
                                            this.hiddenToTempHiddenAnimation(var1_1);
                                            var2_15 = var4_18;
                                        } else {
                                            this.hiddenChangedNoAnimation(var1_1);
                                            var2_15 = var4_18;
                                        }
                                    } else {
                                        this.hiddenChangedAnimation(var1_1);
                                        var2_15 = var4_18;
                                    }
                                } else if (var13_2 /* !! */  instanceof DynamicIslandState.Deleted) {
                                    this.hiddenToDeletedAnimation(var1_1);
                                    var2_15 = var4_18;
                                } else if (var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded) {
                                    this.hiddenToTempHiddenAnimation(var1_1);
                                    this.getCallback().onStateChange("hidden_to_sub_mini_window", var1_1);
                                    var2_15 = var4_18;
                                } else if (var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded) {
                                    this.hiddenToMiniWindowExpandedAnimation(var1_1);
                                    this.getCallback().onStateChange("hidden_to_mini_window", var1_1);
                                    var2_15 = var4_18;
                                } else if (var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded) {
                                    this.hiddenToTempHiddenAnimation(var1_1);
                                    this.getCallback().onStateChange("hidden_to_sub_app", var1_1);
                                    var2_15 = var4_18;
                                } else {
                                    var2_15 = var4_18;
                                    if (var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded) {
                                        this.hiddenToAppExpandedAnimation(var1_1);
                                        this.getCallback().onStateChange("hidden_to_app", var1_1);
                                        var2_15 = var4_18;
                                    }
                                }
                            }
                        }
                    }
                    var13_2 /* !! */  = var1_1.getLastState();
                    var5_10 = var13_2 /* !! */  instanceof DynamicIslandState.Init != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland;
                    var5_10 = var5_10 != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.BigIsland;
                    var5_10 = var5_10 != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.Expanded;
                    if (!var5_10) break block296;
                    var13_2 /* !! */  = var1_1.getState();
                    var5_10 = var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded;
                    var5_10 = var5_10 != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded;
                    if (!(var5_10 = var5_10 != false ? var7_13 : var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded)) ** GOTO lbl-1000
                    var13_2 /* !! */  = Boolean.TRUE;
                    break block297;
                }
                var5_10 = var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded;
                var5_10 = var5_10 != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded;
                if (!(var5_10 = var5_10 != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded)) ** GOTO lbl-1000
                var13_2 /* !! */  = var1_1.getState();
                var5_10 = var13_2 /* !! */  instanceof DynamicIslandState.BigIsland != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.SmallIsland;
                if (!var5_10) break block298;
                if (var9_5) ** GOTO lbl-1000
                var13_2 /* !! */  = Boolean.FALSE;
                break block297;
            }
            var5_10 = var13_2 /* !! */  instanceof DynamicIslandState.AppExpanded != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.SubAppExpanded;
            var5_10 = var5_10 != false ? true : var13_2 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded;
            if (var5_10 = var5_10 != false ? var6_12 : var13_2 /* !! */  instanceof DynamicIslandState.SubMiniWindowExpanded) {
                var13_2 /* !! */  = Boolean.TRUE;
            } else lbl-1000:
            // 4 sources

            {
                var13_2 /* !! */  = null;
            }
        }
        if (!(var9_5 && !var2_15 || var8_9 || o.c((Object)var13_2 /* !! */ , (Object)(var15_3 = Boolean.TRUE)))) {
            if (o.c((Object)var14_4, (Object)var15_3) || o.c((Object)var13_2 /* !! */ , (Object)Boolean.FALSE)) {
                this.getCallback().onStateChange("temp_hidden_to_show", var1_1);
            }
        } else {
            this.getCallback().onStateChange("show_to_temp_hidden", var1_1);
        }
    }

    public final void resetContainerAlpha(DynamicIslandContentView object) {
        if (object != null && (object = this.getAnimator((DynamicIslandBaseContentView)((Object)object))) != null) {
            ((DynamicIslandAnimationDelegate)object).resetContainerAlpha();
        }
    }

    public final void resetFakeViewAnimState(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("resetFakeViewAnimState: ");
        ((StringBuilder)object).append(bl);
        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        if (dynamicIslandContentView != null && (object = this.getAnimator(dynamicIslandContentView)) != null) {
            ((DynamicIslandAnimationDelegate)object).resetFakeViewAnimState(dynamicIslandContentView, bl);
        }
    }

    public final void resetPress(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate;
        if (dynamicIslandContentView != null && (dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView)) != null) {
            dynamicIslandAnimationDelegate.resetPress(dynamicIslandContentView);
        }
    }

    public final void setCurrentBigIsland(DynamicIslandState dynamicIslandState) {
        this.currentBigIsland = dynamicIslandState;
    }

    public final void setCurrentExpanded(DynamicIslandState dynamicIslandState) {
        this.currentExpanded = dynamicIslandState;
    }

    public final void setLastExpanded(DynamicIslandState dynamicIslandState) {
        this.lastExpanded = dynamicIslandState;
    }

    public final void showBigIsland(DynamicIslandContentView frameLayout, boolean bl) {
        DynamicGlowEffectView dynamicGlowEffectView;
        o.g((Object)frameLayout, (String)"view");
        if (!bl && (dynamicGlowEffectView = frameLayout.getExpandedView()) != null) {
            dynamicGlowEffectView.setVisibility(4);
        }
        if ((dynamicGlowEffectView = frameLayout.getBigIslandView()) != null) {
            dynamicGlowEffectView.setVisibility(0);
        }
        dynamicGlowEffectView = frameLayout.getSmallIslandView();
        if (dynamicGlowEffectView != null) {
            dynamicGlowEffectView.setVisibility(8);
        }
        frameLayout = frameLayout.getBigIslandView();
        if (frameLayout != null) {
            frameLayout.setAlpha(1.0f);
        }
    }

    public final void showSmallIsland(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        DynamicGlowEffectView dynamicGlowEffectView = dynamicIslandContentView.getExpandedView();
        if (dynamicGlowEffectView != null) {
            dynamicGlowEffectView.setVisibility(4);
        }
        dynamicGlowEffectView = dynamicIslandContentView.getBigIslandView();
        if (dynamicGlowEffectView != null) {
            dynamicGlowEffectView.setVisibility(8);
        }
        dynamicGlowEffectView = dynamicIslandContentView.getSmallIslandView();
        if (dynamicGlowEffectView != null) {
            dynamicGlowEffectView.setVisibility(0);
        }
        dynamicIslandContentView = dynamicIslandContentView.getSmallIslandView();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setAlpha(1.0f);
        }
    }

    public final void updateAppExpandedStateWhenAnimStart(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate;
        if (dynamicIslandContentView != null && (dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView)) != null) {
            dynamicIslandAnimationDelegate.expandedToHiddenNoAnim(dynamicIslandContentView);
        }
    }

    public final void updateExpandedViewMiniBar(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandContentFakeView dynamicIslandContentFakeView;
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.updateMiniBar(dynamicIslandContentView);
        }
        if (dynamicIslandContentView != null && (dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView()) != null) {
            dynamicIslandContentFakeView.updateMiniBar(dynamicIslandContentView);
        }
    }

    public final void updateIslandWindowAnimRunning(boolean bl, DynamicIslandContentView dynamicIslandContentView, boolean bl2) {
        Object var5_4 = null;
        Object var6_5 = null;
        if (bl2) {
            Object object = dynamicIslandContentView != null ? dynamicIslandContentView.get_islandFreeformAnimRunning() : null;
            if (object != null) {
                object.setValue((Object)bl);
            }
            object = var6_5;
            if (dynamicIslandContentView != null) {
                object = this.getAnimator(dynamicIslandContentView);
            }
            if (object != null) {
                object.setIslandFreeformAnimRunning(bl);
            }
        } else {
            DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = dynamicIslandContentView != null ? this.getAnimator(dynamicIslandContentView) : null;
            if (dynamicIslandAnimationDelegate != null) {
                dynamicIslandAnimationDelegate.setAppClose(false);
            }
            dynamicIslandAnimationDelegate = dynamicIslandContentView != null ? dynamicIslandContentView.get_islandAppAnimRunning() : null;
            if (dynamicIslandAnimationDelegate != null) {
                dynamicIslandAnimationDelegate.setValue(bl);
            }
            dynamicIslandAnimationDelegate = var5_4;
            if (dynamicIslandContentView != null) {
                dynamicIslandAnimationDelegate = this.getAnimator(dynamicIslandContentView);
            }
            if (dynamicIslandAnimationDelegate != null) {
                dynamicIslandAnimationDelegate.setIslandAppAnimRunning(bl);
            }
        }
    }
}
