/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.b
 *  U0.o
 *  U0.p
 *  android.graphics.Rect
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  android.view.View
 *  f1.E
 *  f1.f
 *  i1.f
 *  i1.g
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.dagger.qualifiers.Main
 *  miui.systemui.lifecycle.RepeatWhenAttachedKt
 *  miui.systemui.settings.data.repository.WorkBenchModeRepository
 *  miui.systemui.util.coroutines.flow.ViewUtilsKt
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import U0.p;
import android.graphics.Rect;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.View;
import f1.E;
import f1.f;
import i1.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dagger.qualifiers.Main;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.events.DynamicIslandExposureManager;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.ui.viewbinder.DynamicIslandContentViewBinder;
import miui.systemui.lifecycle.RepeatWhenAttachedKt;
import miui.systemui.settings.data.repository.WorkBenchModeRepository;
import miui.systemui.util.coroutines.flow.ViewUtilsKt;

public final class DynamicIslandContentViewController
extends DynamicIslandBaseContentViewController<DynamicIslandContentView> {
    private final float MIN_ALPHA;
    private long _actualTime;
    private long _hiddenTime;
    private long _revealTime;
    private boolean attached;
    private final DynamicIslandExposureManager expoManager;
    private boolean hasWindowFocus;
    private boolean isExposed;
    private boolean isVisible;
    private final Rect rect;
    private final DynamicIslandTouchInteractor touchInteractor;
    private final K0.g uiContext;
    private final DynamicIslandWindowView windowView;
    private final WorkBenchModeRepository workBenchModeRepository;

    public DynamicIslandContentViewController(DynamicIslandContentView dynamicIslandContentView, @DynamicIsland E e, @Main K0.g g2, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor, IslandTemplateFactory islandTemplateFactory, DynamicIslandTouchInteractor dynamicIslandTouchInteractor, DynamicIslandExposureManager dynamicIslandExposureManager, WorkBenchModeRepository workBenchModeRepository) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        o.g((Object)e, (String)"scope");
        o.g((Object)g2, (String)"uiContext");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)dynamicIslandRegionSamplingInteractor, (String)"regionSamplingInteractor");
        o.g((Object)islandTemplateFactory, (String)"islandTemplateFactory");
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        o.g((Object)dynamicIslandExposureManager, (String)"expoManager");
        o.g((Object)workBenchModeRepository, (String)"workBenchModeRepository");
        super(dynamicIslandContentView, e, dynamicIslandRegionSamplingInteractor, islandTemplateFactory, dynamicIslandTouchInteractor, workBenchModeRepository);
        this.uiContext = g2;
        this.windowView = dynamicIslandWindowView;
        this.touchInteractor = dynamicIslandTouchInteractor;
        this.expoManager = dynamicIslandExposureManager;
        this.workBenchModeRepository = workBenchModeRepository;
        this.getDisposables$miui_dynamicisland_release().plusAssign(RepeatWhenAttachedKt.repeatWhenAttached((View)dynamicIslandContentView, (K0.g)g2, (p)new p(this, dynamicIslandContentView, null){
            final DynamicIslandContentView $view;
            private Object L$0;
            int label;
            final DynamicIslandContentViewController this$0;
            {
                this.this$0 = dynamicIslandContentViewController;
                this.$view = dynamicIslandContentView;
                super(3, d2);
            }

            public final Object invoke(E e, View object, d d2) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.L$0 = e;
                return object.invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    E e = (E)this.L$0;
                    DynamicIslandContentViewController.access$listenForPressed(this.this$0, e);
                    DynamicIslandContentViewBinder dynamicIslandContentViewBinder = DynamicIslandContentViewBinder.INSTANCE;
                    object = this.$view;
                    dynamicIslandContentViewBinder.bind((DynamicIslandContentView)((Object)object), e, ((DynamicIslandBaseContentView)((Object)object)).getViewModel());
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }));
        this.MIN_ALPHA = 0.1f;
        this.rect = new Rect();
    }

    public static final /* synthetic */ DynamicIslandTouchInteractor access$getTouchInteractor$p(DynamicIslandContentViewController dynamicIslandContentViewController) {
        return dynamicIslandContentViewController.touchInteractor;
    }

    public static final /* synthetic */ void access$listenForPressed(DynamicIslandContentViewController dynamicIslandContentViewController, E e) {
        dynamicIslandContentViewController.listenForPressed(e);
    }

    private final boolean currentIslandVisible() {
        float f2;
        Object object = ((DynamicIslandContentView)((Object)this.getView())).getState();
        boolean bl = object instanceof DynamicIslandState.BigIsland;
        float f3 = 0.0f;
        if (bl) {
            object = ((DynamicIslandContentView)((Object)this.getView())).getBigIslandView();
            f2 = f3;
            if (object != null) {
                f2 = object.getAlpha();
            }
        } else if (object instanceof DynamicIslandState.SmallIsland) {
            object = ((DynamicIslandContentView)((Object)this.getView())).getSmallIslandView();
            f2 = f3;
            if (object != null) {
                f2 = object.getAlpha();
            }
        } else {
            f2 = f3;
            if (object instanceof DynamicIslandState.Expanded) {
                object = ((DynamicIslandContentView)((Object)this.getView())).getExpandedView();
                f2 = f3;
                if (object != null) {
                    f2 = object.getAlpha();
                }
            }
        }
        bl = f2 > this.MIN_ALPHA;
        return bl;
    }

    private final void listenForClick(E e) {
        f.b((E)e, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandContentViewController this$0;
            {
                this.this$0 = dynamicIslandContentViewController;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object g2) {
                Object object = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)g2);
                    return s.a;
                } else {
                    k.b((Object)g2);
                    i1.f f2 = ViewUtilsKt.getOnClick(this.this$0.getView());
                    g2 = new g(this.this$0){
                        final DynamicIslandContentViewController this$0;
                        {
                            this.this$0 = dynamicIslandContentViewController;
                        }

                        public final Object emit(s s2, d d2) {
                            DynamicIslandContentViewController.access$getTouchInteractor$p(this.this$0).performClick();
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (f2.collect(g2, (d)this) != object) return s.a;
                    return object;
                }
            }
        }, (int)3, null);
    }

    private final void listenForLongClick(E e) {
        f.b((E)e, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandContentViewController this$0;
            {
                this.this$0 = dynamicIslandContentViewController;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    object = ViewUtilsKt.getOnLongClick(this.this$0.getView());
                    g g2 = new g(this.this$0){
                        final DynamicIslandContentViewController this$0;
                        {
                            this.this$0 = dynamicIslandContentViewController;
                        }

                        public final Object emit(Function1 function1, d d2) {
                            function1.invoke((Object)b.a((boolean)DynamicIslandContentViewController.access$getTouchInteractor$p(this.this$0).performLongClick()));
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
    }

    private final void listenForPressed(E e) {
        f.b((E)e, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandContentViewController this$0;
            {
                this.this$0 = dynamicIslandContentViewController;
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
                    object = ((DynamicIslandContentView)((Object)this.this$0.getView())).isPressed();
                    g g2 = new g(this.this$0){
                        final DynamicIslandContentViewController this$0;
                        {
                            this.this$0 = dynamicIslandContentViewController;
                        }

                        public final Object emit(boolean bl, d d2) {
                            DynamicIslandContentViewController.access$getTouchInteractor$p(this.this$0).performPressed(bl);
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
        }, (int)3, null);
    }

    private final void log(E e) {
        f.b((E)e, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandContentViewController this$0;
            {
                this.this$0 = dynamicIslandContentViewController;
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
                    object = ((DynamicIslandContentView)((Object)this.this$0.getView())).getViewModel().getState();
                    g g2 = new g(this.this$0){
                        final DynamicIslandContentViewController this$0;
                        {
                            this.this$0 = dynamicIslandContentViewController;
                        }

                        public final Object emit(DynamicIslandState dynamicIslandState, d object) {
                            object = ((DynamicIslandContentView)((Object)this.this$0.getView())).getViewModel().getOldState();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("initViewModel state: ");
                            stringBuilder.append(object);
                            stringBuilder.append(" ->");
                            stringBuilder.append(dynamicIslandState);
                            Log.e((String)"DynamicIslandContentView", (String)stringBuilder.toString());
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
        }, (int)3, null);
    }

    private final void startExpose() {
        if (this.attached && this.isVisible && !this.isExposed) {
            this.isExposed = true;
            this._revealTime = System.currentTimeMillis();
            this.expoManager.startExpose(this);
        }
    }

    private final void stopExpose() {
        if (!this.isExposed) {
            return;
        }
        this.isExposed = false;
        this._actualTime = System.currentTimeMillis() - this._revealTime;
        this.expoManager.stopExpose(this);
    }

    public final long getActualTime() {
        return this._actualTime;
    }

    public final String getIslandKey() {
        return ((DynamicIslandContentView)((Object)this.getView())).getIslandKey();
    }

    public final Integer getIslandProp() {
        return ((DynamicIslandContentView)((Object)this.getView())).getIslandProp();
    }

    public final StatusBarNotification getIslandSbn() {
        Object object = ((DynamicIslandContentView)((Object)this.getView())).getCurrentIslandData();
        object = object != null && (object = object.getExtras()) != null ? (StatusBarNotification)object.getParcelable("miui.sbn", StatusBarNotification.class) : null;
        return object;
    }

    public final long getRevealTime() {
        return this._revealTime;
    }

    public final void onPreDraw() {
        if (((DynamicIslandContentView)((Object)this.getView())).getGlobalVisibleRect(this.rect) && ((DynamicIslandContentView)((Object)this.getView())).isShown() && this.rect.width() > 0 && this.rect.height() > 0 && this.currentIslandVisible()) {
            if (!((DynamicIslandContentView)((Object)this.getView())).isAnimating()) {
                this.startExpose();
            }
            return;
        }
        this.stopExpose();
    }

    public final void onStateChange() {
        if (!o.c((Object)((DynamicIslandContentView)((Object)this.getView())).getLastState(), (Object)((DynamicIslandContentView)((Object)this.getView())).getState())) {
            this.stopExpose();
        }
    }

    public final void onViewAttached(boolean bl) {
        this.attached = bl;
        if (!bl) {
            this.stopExpose();
        }
    }

    public final void onVisAggregated(boolean bl) {
        this.isVisible = bl;
        if (!bl) {
            this.stopExpose();
        }
    }

    public final void onWindowFocusChanged(boolean bl) {
        this.hasWindowFocus = bl;
        if (!bl) {
            this.stopExpose();
        }
    }
}
