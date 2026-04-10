/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.d
 *  G0.e
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.a
 *  U0.o
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.os.Binder
 *  android.os.SystemProperties
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  f1.E
 *  f1.M
 *  f1.f
 *  i1.I
 *  i1.g
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.e;
import G0.s;
import K0.d;
import L0.c;
import U0.a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Binder;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import f1.E;
import f1.M;
import f1.f;
import i1.I;
import i1.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.window.DynamicIslandWindowController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor;
import miui.systemui.dynamicisland.window.k;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class DynamicIslandWindowController
implements DynamicIslandStartable {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final boolean DRAW_WINDOW_SIZE = SystemProperties.getBoolean((String)"debug.sysui.notif.island.window_size", (boolean)false);
    private static final String TAG = "DynamicIslandWindowController";
    private final Context context;
    private final DynamicIslandWindowState dynamicIslandWindowState;
    private final WindowManager.LayoutParams lp;
    private final WindowManager.LayoutParams lpChanged;
    private final G0.d paint$delegate;
    private final E scope;
    private final WindowManager windowManager;
    private final DynamicIslandWindowStateInteractor windowStateInteractor;
    private final DynamicIslandWindowView windowView;

    public DynamicIslandWindowController(@DynamicIsland E object, DynamicIslandWindowView dynamicIslandWindowView, Context context, DynamicIslandWindowState dynamicIslandWindowState, DynamicIslandWindowStateInteractor dynamicIslandWindowStateInteractor) {
        o.g((Object)object, (String)"scope");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)context, (String)"context");
        o.g((Object)dynamicIslandWindowState, (String)"dynamicIslandWindowState");
        o.g((Object)dynamicIslandWindowStateInteractor, (String)"windowStateInteractor");
        this.scope = object;
        this.windowView = dynamicIslandWindowView;
        this.context = context;
        this.dynamicIslandWindowState = dynamicIslandWindowState;
        this.windowStateInteractor = dynamicIslandWindowStateInteractor;
        object = context.getSystemService("window");
        o.e((Object)object, (String)"null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager)object;
        object = new WindowManager.LayoutParams(-1, 0, 2009, -2147483608, -3);
        object.privateFlags |= 0x21000000;
        object.token = new Binder();
        object.gravity = 48;
        object.setFitInsetsTypes(0);
        object.setTitle((CharSequence)"DynamicIslandWindow");
        object.packageName = context.getPackageName();
        object.layoutInDisplayCutoutMode = 3;
        this.lp = object;
        this.lpChanged = new WindowManager.LayoutParams();
        this.paint$delegate = e.b((a)paint.2.INSTANCE);
    }

    public static /* synthetic */ void a(DynamicIslandWindowController dynamicIslandWindowController) {
        DynamicIslandWindowController.apply$lambda$1(dynamicIslandWindowController);
    }

    public static final /* synthetic */ void access$apply(DynamicIslandWindowController dynamicIslandWindowController) {
        dynamicIslandWindowController.apply();
    }

    public static final /* synthetic */ DynamicIslandWindowState access$getDynamicIslandWindowState$p(DynamicIslandWindowController dynamicIslandWindowController) {
        return dynamicIslandWindowController.dynamicIslandWindowState;
    }

    public static final /* synthetic */ WindowManager.LayoutParams access$getLp$p(DynamicIslandWindowController dynamicIslandWindowController) {
        return dynamicIslandWindowController.lp;
    }

    public static final /* synthetic */ WindowManager.LayoutParams access$getLpChanged$p(DynamicIslandWindowController dynamicIslandWindowController) {
        return dynamicIslandWindowController.lpChanged;
    }

    public static final /* synthetic */ Paint access$getPaint(DynamicIslandWindowController dynamicIslandWindowController) {
        return dynamicIslandWindowController.getPaint();
    }

    public static final /* synthetic */ WindowManager access$getWindowManager$p(DynamicIslandWindowController dynamicIslandWindowController) {
        return dynamicIslandWindowController.windowManager;
    }

    public static final /* synthetic */ DynamicIslandWindowStateInteractor access$getWindowStateInteractor$p(DynamicIslandWindowController dynamicIslandWindowController) {
        return dynamicIslandWindowController.windowStateInteractor;
    }

    public static final /* synthetic */ DynamicIslandWindowView access$getWindowView$p(DynamicIslandWindowController dynamicIslandWindowController) {
        return dynamicIslandWindowController.windowView;
    }

    private final void apply() {
        if (this.lp.copyFrom(this.lpChanged) != 0) {
            this.windowView.postOnAnimation(new k(this));
        }
    }

    private static final void apply$lambda$1(DynamicIslandWindowController dynamicIslandWindowController) {
        o.g((Object)dynamicIslandWindowController, (String)"this$0");
        dynamicIslandWindowController.windowManager.updateViewLayout((View)dynamicIslandWindowController.windowView, (ViewGroup.LayoutParams)dynamicIslandWindowController.lp);
    }

    private final void attach() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowController this$0;
            {
                this.this$0 = dynamicIslandWindowController;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    G0.k.b((Object)object);
                } else {
                    G0.k.b((Object)object);
                    DynamicIslandWindowController.access$getWindowManager$p(this.this$0).addView((View)DynamicIslandWindowController.access$getWindowView$p(this.this$0), (ViewGroup.LayoutParams)DynamicIslandWindowController.access$getLp$p(this.this$0));
                    DynamicIslandWindowController.access$getLpChanged$p(this.this$0).copyFrom(DynamicIslandWindowController.access$getLp$p(this.this$0));
                    this.label = 1;
                    if (M.a((d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null).k(new Function1(this){
            final DynamicIslandWindowController this$0;
            {
                this.this$0 = dynamicIslandWindowController;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                DynamicIslandWindowController.access$getWindowManager$p(this.this$0).removeView((View)DynamicIslandWindowController.access$getWindowView$p(this.this$0));
            }
        });
    }

    private final void drawDebugWindowSize() {
        if (DRAW_WINDOW_SIZE) {
            f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
                int label;
                final DynamicIslandWindowController this$0;
                {
                    this.this$0 = dynamicIslandWindowController;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e2, d d2) {
                    return (this.create(e2, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    Object object2 = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        G0.k.b((Object)object);
                    } else {
                        G0.k.b((Object)object);
                        Object object3 = new Rect();
                        object = DynamicIslandWindowController.access$getWindowView$p(this.this$0).getDispatchDrawEvent();
                        object3 = new g(this.this$0, (Rect)object3){
                            final Rect $rect;
                            final DynamicIslandWindowController this$0;
                            {
                                this.this$0 = dynamicIslandWindowController;
                                this.$rect = rect;
                            }

                            public final Object emit(Canvas canvas, d d2) {
                                DynamicIslandWindowController.access$getWindowView$p(this.this$0).getDrawingRect(this.$rect);
                                canvas.drawRect(this.$rect, DynamicIslandWindowController.access$getPaint(this.this$0));
                                return s.a;
                            }
                        };
                        this.label = 1;
                        if (object.collect((g)object3, (d)this) == object2) {
                            return object2;
                        }
                    }
                    throw new G0.c();
                }
            }, (int)3, null);
        }
    }

    private final Paint getPaint() {
        return (Paint)this.paint$delegate.getValue();
    }

    private final void listenForVisibility() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowController this$0;
            {
                this.this$0 = dynamicIslandWindowController;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    G0.k.b((Object)g2);
                } else {
                    G0.k.b((Object)g2);
                    I i = DynamicIslandWindowController.access$getWindowStateInteractor$p(this.this$0).getVisibility();
                    g2 = new g(this.this$0){
                        final DynamicIslandWindowController this$0;
                        {
                            this.this$0 = dynamicIslandWindowController;
                        }

                        public final Object emit(int n, d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("update window Visibility ");
                            ((StringBuilder)object).append(n);
                            Log.d((String)"DynamicIslandWindowController", (String)((StringBuilder)object).toString());
                            if (CommonUtils.INSTANCE.getIS_TABLET() && ((Boolean)DynamicIslandWindowController.access$getDynamicIslandWindowState$p(this.this$0).getNotificationPanelSwipeToAppearance().getValue()).booleanValue() && ((Boolean)DynamicIslandWindowController.access$getDynamicIslandWindowState$p(this.this$0).getControlCenterPanelSwipeToAppearance().getValue()).booleanValue()) {
                                DynamicIslandWindowController.access$getWindowView$p(this.this$0).setVisibility(4);
                            } else {
                                DynamicIslandWindowController.access$getWindowView$p(this.this$0).setVisibility(n);
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
        }, (int)3, null);
    }

    private final void listenForWatchOutsideTouch() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowController this$0;
            {
                this.this$0 = dynamicIslandWindowController;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    G0.k.b((Object)object);
                } else {
                    G0.k.b((Object)object);
                    object = DynamicIslandWindowController.access$getWindowStateInteractor$p(this.this$0).getWatchOutsideTouch();
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowController this$0;
                        {
                            this.this$0 = dynamicIslandWindowController;
                        }

                        public final Object emit(boolean bl, d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("update watch outside touch to ");
                            ((StringBuilder)object).append(bl);
                            Log.d((String)"DynamicIslandWindowController", (String)((StringBuilder)object).toString());
                            object = DynamicIslandWindowController.access$getLpChanged$p(this.this$0);
                            int n = bl ? DynamicIslandWindowController.access$getLp$p((DynamicIslandWindowController)this.this$0).flags | 0x40000 : DynamicIslandWindowController.access$getLp$p((DynamicIslandWindowController)this.this$0).flags & 0xFFFBFFFF;
                            ((WindowManager.LayoutParams)object).flags = n;
                            DynamicIslandWindowController.access$apply(this.this$0);
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

    private final void listenForWindowHeight() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowController this$0;
            {
                this.this$0 = dynamicIslandWindowController;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    G0.k.b((Object)object);
                } else {
                    G0.k.b((Object)object);
                    object = DynamicIslandWindowController.access$getWindowStateInteractor$p(this.this$0).getWindowHeight();
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowController this$0;
                        {
                            this.this$0 = dynamicIslandWindowController;
                        }

                        public final Object emit(int n, d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("update window height ");
                            ((StringBuilder)object).append(n);
                            Log.d((String)"DynamicIslandWindowController", (String)((StringBuilder)object).toString());
                            if (CommonUtils.INSTANCE.getIS_TABLET() && ((Boolean)DynamicIslandWindowController.access$getDynamicIslandWindowState$p(this.this$0).getNotificationPanelSwipeToAppearance().getValue()).booleanValue() && ((Boolean)DynamicIslandWindowController.access$getDynamicIslandWindowState$p(this.this$0).getControlCenterPanelSwipeToAppearance().getValue()).booleanValue()) {
                                DynamicIslandWindowController.access$getLpChanged$p((DynamicIslandWindowController)this.this$0).height = 0;
                            } else {
                                DynamicIslandWindowController.access$getLpChanged$p((DynamicIslandWindowController)this.this$0).height = n;
                                DynamicIslandWindowController.access$apply(this.this$0);
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
        }, (int)3, null);
    }

    @Override
    public void start() {
        this.attach();
        this.listenForVisibility();
        this.listenForWindowHeight();
        this.listenForWatchOutsideTouch();
        this.drawDebugWindowSize();
    }
}
