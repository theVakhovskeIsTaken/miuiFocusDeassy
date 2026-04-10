/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  U0.o
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.res.Configuration
 *  android.util.Log
 *  com.android.systemui.settings.UserTracker
 *  com.android.systemui.settings.UserTracker$Callback
 *  f1.E
 *  f1.M
 *  f1.f
 *  i1.I
 *  i1.f
 *  i1.g
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.Prefs
 *  miui.systemui.dagger.qualifiers.Main
 *  miui.systemui.dagger.qualifiers.SystemUI
 *  miui.systemui.ui.data.repository.ConfigurationRepository
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.c;
import G0.k;
import G0.s;
import K0.d;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;
import com.android.systemui.settings.UserTracker;
import f1.E;
import f1.M;
import f1.f;
import i1.I;
import i1.g;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.Prefs;
import miui.systemui.dagger.qualifiers.Main;
import miui.systemui.dagger.qualifiers.SystemUI;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor$listenForExpandedState$1$invokeSuspend$;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.ui.data.repository.ConfigurationRepository;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class DynamicIslandWindowViewRefactor
implements DynamicIslandStartable {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "DynamicIslandWindowViewRefactor";
    private final ConfigurationRepository configurationRepository;
    private final Context context;
    private final DynamicIslandEventCoordinator eventCoordinator;
    private int lastRotation;
    private final E scope;
    private final Context sysUIContext;
    private final Executor uiExecutor;
    private final UserTracker userTracker;
    private final DynamicIslandWindowView windowView;

    public DynamicIslandWindowViewRefactor(@SystemUI Context context, Context context2, @DynamicIsland E e, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandEventCoordinator dynamicIslandEventCoordinator, UserTracker userTracker, @Main Executor executor, ConfigurationRepository configurationRepository) {
        o.g((Object)context, (String)"sysUIContext");
        o.g((Object)context2, (String)"context");
        o.g((Object)e, (String)"scope");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)dynamicIslandEventCoordinator, (String)"eventCoordinator");
        o.g((Object)userTracker, (String)"userTracker");
        o.g((Object)executor, (String)"uiExecutor");
        o.g((Object)configurationRepository, (String)"configurationRepository");
        this.sysUIContext = context;
        this.context = context2;
        this.scope = e;
        this.windowView = dynamicIslandWindowView;
        this.eventCoordinator = dynamicIslandEventCoordinator;
        this.userTracker = userTracker;
        this.uiExecutor = executor;
        this.configurationRepository = configurationRepository;
        this.lastRotation = -1;
    }

    public static final /* synthetic */ ConfigurationRepository access$getConfigurationRepository$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        return dynamicIslandWindowViewRefactor.configurationRepository;
    }

    public static final /* synthetic */ Context access$getContext$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        return dynamicIslandWindowViewRefactor.context;
    }

    public static final /* synthetic */ DynamicIslandEventCoordinator access$getEventCoordinator$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        return dynamicIslandWindowViewRefactor.eventCoordinator;
    }

    public static final /* synthetic */ int access$getLastRotation$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        return dynamicIslandWindowViewRefactor.lastRotation;
    }

    public static final /* synthetic */ Context access$getSysUIContext$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        return dynamicIslandWindowViewRefactor.sysUIContext;
    }

    public static final /* synthetic */ Executor access$getUiExecutor$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        return dynamicIslandWindowViewRefactor.uiExecutor;
    }

    public static final /* synthetic */ UserTracker access$getUserTracker$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        return dynamicIslandWindowViewRefactor.userTracker;
    }

    public static final /* synthetic */ DynamicIslandWindowView access$getWindowView$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        return dynamicIslandWindowViewRefactor.windowView;
    }

    public static final /* synthetic */ void access$setLastRotation$p(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor, int n) {
        dynamicIslandWindowViewRefactor.lastRotation = n;
    }

    private final void listenForExpandedState() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewRefactor this$0;
            {
                this.this$0 = dynamicIslandWindowViewRefactor;
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
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    object = new i1.f((i1.f)DynamicIslandWindowViewRefactor.access$getEventCoordinator$p(this.this$0).getExpandedState()){
                        final i1.f $this_unsafeTransform$inlined;
                        {
                            this.$this_unsafeTransform$inlined = f2;
                        }

                        public Object collect(g object, d d2) {
                            if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object){
                                final g $this_unsafeFlow;
                                {
                                    this.$this_unsafeFlow = g2;
                                }

                                /*
                                 * Unable to fully structure code
                                 * Could not resolve type clashes
                                 */
                                public final Object emit(Object var1_1, d var2_2) {
                                    if (!(var2_2 /* !! */  instanceof listenForExpandedState$1$invokeSuspend$$inlined$mapNotNull$1$2$1)) ** GOTO lbl-1000
                                    var4_3 /* !! */  = var2_2 /* !! */ ;
                                    var3_4 = var4_3 /* !! */ .label;
                                    if ((var3_4 & -2147483648) != 0) {
                                        var4_3 /* !! */ .label = var3_4 + -2147483648;
                                        var2_2 /* !! */  = var4_3 /* !! */ ;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                            Object L$0;
                                            int label;
                                            Object result;
                                            final listenForExpandedState$1$invokeSuspend$$inlined$mapNotNull$1$2 this$0;
                                            {
                                                this.this$0 = var1_1;
                                                super(d2);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                this.result = object;
                                                this.label |= Integer.MIN_VALUE;
                                                return this.this$0.emit(null, (d)this);
                                            }
                                        };
                                    }
                                    var5_5 = var2_2 /* !! */ .result;
                                    var4_3 /* !! */  = L0.c.c();
                                    var3_4 = var2_2 /* !! */ .label;
                                    if (var3_4 == 0) ** GOTO lbl17
                                    if (var3_4 == 1) {
                                        k.b((Object)var5_5);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                                        // 1 sources

                                        k.b((Object)var5_5);
                                        var5_5 = this.$this_unsafeFlow;
                                        var1_1 = (Boolean)var1_1;
                                        if (var1_1 != null) {
                                            var2_2 /* !! */ .label = 1;
                                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                                return var4_3 /* !! */ ;
                                            }
                                        }
                                    }
                                    return s.a;
                                }
                            }, d2)) == L0.c.c()) {
                                return object;
                            }
                            return s.a;
                        }
                    };
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowViewRefactor this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewRefactor;
                        }

                        public final Object emit(boolean bl, d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("expandedState ");
                            ((StringBuilder)object).append(bl);
                            Log.e((String)"DynamicIslandWindowViewRefactor", (String)((StringBuilder)object).toString());
                            object = new Intent("com.miui.action.ACTION_EXPANDED_STATE_CHANGED");
                            object.putExtra("islandExpanded", bl);
                            SharedPreferences sharedPreferences = Prefs.getNotif((Context)DynamicIslandWindowViewRefactor.access$getSysUIContext$p(this.this$0));
                            o.f((Object)sharedPreferences, (String)"getNotif(...)");
                            sharedPreferences = sharedPreferences.edit();
                            sharedPreferences.putBoolean("islandExpanded", bl);
                            sharedPreferences.apply();
                            DynamicIslandWindowViewRefactor.access$getContext$p(this.this$0).sendBroadcast((Intent)object);
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

    private final void listenForOrientationChanged() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewRefactor this$0;
            {
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
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)object);
                } else {
                    k.b((Object)object);
                    object = DynamicIslandWindowViewRefactor.access$getConfigurationRepository$p(this.this$0).getOrientationChanged();
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
                throw new c();
            }
        }, (int)3, null);
    }

    private final void listenForRotationChanged() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewRefactor this$0;
            {
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
                Object object = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    I i2 = DynamicIslandWindowViewRefactor.access$getConfigurationRepository$p(this.this$0).getDefaultDisplayRotation();
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
                    if (i2.collect(g2, (d)this) == object) {
                        return object;
                    }
                }
                throw new c();
            }
        }, (int)3, null);
    }

    private final void listenForUserChanged() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewRefactor this$0;
            {
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
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)object);
                } else {
                    k.b((Object)object);
                    DynamicIslandWindowViewRefactor.access$getUserTracker$p(this.this$0).addCallback((UserTracker.Callback)DynamicIslandWindowViewRefactor.access$getWindowView$p(this.this$0), DynamicIslandWindowViewRefactor.access$getUiExecutor$p(this.this$0));
                    this.label = 1;
                    if (M.a((d)this) == object2) {
                        return object2;
                    }
                }
                throw new c();
            }
        }, (int)3, null).k(new Function1(this){
            final DynamicIslandWindowViewRefactor this$0;
            {
                this.this$0 = dynamicIslandWindowViewRefactor;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                DynamicIslandWindowViewRefactor.access$getUserTracker$p(this.this$0).removeCallback((UserTracker.Callback)DynamicIslandWindowViewRefactor.access$getWindowView$p(this.this$0));
            }
        });
    }

    @Override
    public void start() {
        this.listenForExpandedState();
        this.listenForUserChanged();
        this.listenForOrientationChanged();
        this.listenForRotationChanged();
    }
}
