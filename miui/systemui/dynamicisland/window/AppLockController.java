/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.d
 *  G0.e
 *  G0.j
 *  G0.j$a
 *  G0.k
 *  G0.s
 *  H0.I
 *  H0.u
 *  K0.d
 *  L0.c
 *  U0.a
 *  U0.o
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Handler
 *  android.provider.Settings$Secure
 *  android.util.Log
 *  com.android.systemui.settings.UserTracker
 *  com.android.systemui.settings.UserTracker$Callback
 *  f1.E
 *  f1.M
 *  f1.f
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.security.SecurityManager
 *  miui.systemui.dagger.qualifiers.Background
 */
package miui.systemui.dynamicisland.window;

import G0.c;
import G0.e;
import G0.j;
import G0.k;
import G0.s;
import H0.I;
import H0.u;
import K0.d;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.android.systemui.settings.UserTracker;
import f1.E;
import f1.M;
import f1.f;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.security.SecurityManager;
import miui.systemui.dagger.qualifiers.Background;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.window.AppLockController;
import miui.systemui.dynamicisland.window.a;
import miui.systemui.dynamicisland.window.b;

@DynamicIslandScope
public final class AppLockController {
    private static final Uri ACCESS_CONTROL_LOCK_ENABLED;
    private static final Uri ACCESS_CONTROL_LOCK_MASK;
    public static final Companion Companion;
    public static final long DELAY = 1000L;
    public static final String TAG = "AppLockController";
    private final Executor bgExecutor;
    private final Handler bgHandler;
    private final Context context;
    private volatile boolean lockEnable;
    private final lockStateObserver.1 lockStateObserver;
    private final AppLockProvider provider;
    private final E scope;
    private final SecurityManager securityManager;
    private final userCallback.1 userCallback;
    private final UserTracker userTracker;

    static {
        Companion = new Object(null){
            {
                this();
            }

            public final Uri getACCESS_CONTROL_LOCK_ENABLED() {
                return ACCESS_CONTROL_LOCK_ENABLED;
            }

            public final Uri getACCESS_CONTROL_LOCK_MASK() {
                return ACCESS_CONTROL_LOCK_MASK;
            }
        };
        Uri uri = Settings.Secure.getUriFor((String)"access_control_lock_enabled");
        o.f((Object)uri, (String)"getUriFor(...)");
        ACCESS_CONTROL_LOCK_ENABLED = uri;
        uri = Settings.Secure.getUriFor((String)"applock_mask_notify");
        o.f((Object)uri, (String)"getUriFor(...)");
        ACCESS_CONTROL_LOCK_MASK = uri;
    }

    public AppLockController(@DynamicIsland E object, Context context, UserTracker userTracker, @Background Executor executor, @Background Handler handler) {
        o.g((Object)object, (String)"scope");
        o.g((Object)context, (String)"context");
        o.g((Object)userTracker, (String)"userTracker");
        o.g((Object)executor, (String)"bgExecutor");
        o.g((Object)handler, (String)"bgHandler");
        this.scope = object;
        this.context = context;
        this.userTracker = userTracker;
        this.bgExecutor = executor;
        this.bgHandler = handler;
        object = context.getSystemService("security");
        o.e((Object)object, (String)"null cannot be cast to non-null type miui.security.SecurityManager");
        object = (SecurityManager)object;
        this.securityManager = object;
        this.lockStateObserver = new ContentObserver(this, handler){
            final AppLockController this$0;
            {
                this.this$0 = appLockController;
                super(handler);
            }

            public void onChange(boolean bl) {
                Object object;
                AppLockController appLockController = this.this$0;
                try {
                    object = j.a;
                    object = j.a((Object)Settings.Secure.getIntForUser((ContentResolver)AppLockController.access$getContext$p(appLockController).getContentResolver(), (String)"access_control_lock_enabled", (int)-1, (int)AppLockController.access$getUserTracker$p(appLockController).getUserId()));
                }
                catch (Throwable throwable) {
                    object = j.a;
                    object = j.a((Object)k.a((Throwable)throwable));
                }
                if (j.b((Object)object) != null) {
                    object = -1;
                }
                int n = ((Number)object).intValue();
                object = this.this$0;
                bl = true;
                if (n != 1) {
                    bl = false;
                }
                AppLockController.access$setLockEnable$p((AppLockController)object, bl);
                if (AppLockController.access$getLockEnable$p(this.this$0)) {
                    AppLockController.access$getProvider$p(this.this$0).updateUser();
                } else {
                    AppLockController.access$getProvider$p(this.this$0).clearCache();
                }
                int n2 = AppLockController.access$getUserTracker$p(this.this$0).getUserId();
                object = new StringBuilder();
                ((StringBuilder)object).append("onChange: ");
                ((StringBuilder)object).append(n);
                ((StringBuilder)object).append(" user = ");
                ((StringBuilder)object).append(n2);
                Log.d((String)"AppLockController", (String)((StringBuilder)object).toString());
            }
        };
        this.userCallback = new UserTracker.Callback(this){
            final AppLockController this$0;
            {
                this.this$0 = appLockController;
            }

            public void onUserChanged(int n, Context context) {
                o.g((Object)context, (String)"userContext");
                AppLockController.access$getLockStateObserver$p(this.this$0).onChange(false);
            }
        };
        this.provider = new Object(this, (SecurityManager)object, context, handler, userTracker){
            private final Handler bgHandler;
            private final Context context;
            private final Runnable fetchMaskListRunnable;
            private final ConcurrentHashMap<Integer, Set<String>> maskMap;
            private final maskStateObserver.1 maskStateObserver;
            private final G0.d method$delegate;
            private final SecurityManager securityManager;
            final AppLockController this$0;
            private final UserTracker userTracker;
            {
                o.g((Object)securityManager, (String)"securityManager");
                o.g((Object)context, (String)"context");
                o.g((Object)handler, (String)"bgHandler");
                o.g((Object)userTracker, (String)"userTracker");
                this.this$0 = appLockController;
                this.securityManager = securityManager;
                this.context = context;
                this.bgHandler = handler;
                this.userTracker = userTracker;
                this.maskMap = new ConcurrentHashMap();
                this.method$delegate = e.b((U0.a)new U0.a(this){
                    final AppLockProvider this$0;
                    {
                        this.this$0 = appLockProvider;
                        super(0);
                    }

                    public final Method invoke() {
                        Object object;
                        try {
                            object = j.a;
                            object = Integer.TYPE;
                            object = SecurityManager.class.getDeclaredMethod("getAllApplicationsAccessControlNotPass", new Class[]{object});
                            object = j.a((Object)object);
                        }
                        catch (Throwable throwable) {
                            j.a a2 = j.a;
                            object = j.a((Object)k.a((Throwable)throwable));
                        }
                        if (j.b((Object)object) != null) {
                            object = null;
                        }
                        return (Method)object;
                    }
                });
                this.maskStateObserver = new ContentObserver(this, appLockController, handler){
                    final AppLockProvider this$0;
                    final AppLockController this$1;
                    {
                        this.this$0 = appLockProvider;
                        this.this$1 = appLockController;
                        super(handler);
                    }

                    public void onChange(boolean bl) {
                        if (AppLockProvider.access$getMethod(this.this$0) != null && AppLockController.access$getLockEnable$p(this.this$1)) {
                            AppLockProvider.refreshMaskMap$default(this.this$0, false, 1, null);
                        }
                    }
                };
                this.fetchMaskListRunnable = new b(this);
            }

            public static /* synthetic */ void a(AppLockProvider appLockProvider) {
                AppLockProvider.fetchMaskListRunnable$lambda$2(appLockProvider);
            }

            public static final /* synthetic */ Method access$getMethod(AppLockProvider appLockProvider) {
                return appLockProvider.getMethod();
            }

            private static final void fetchMaskListRunnable$lambda$2(AppLockProvider set) {
                Object object;
                o.g((Object)set, (String)"this$0");
                int n = set.userTracker.getUserId();
                Set<String> set2 = set.getMaskList(n);
                if (set2 != null) {
                    object = set.maskMap.put(n, set2);
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("refresh mask value = ");
                ((StringBuilder)object).append(set2);
                ((StringBuilder)object).append("  id = ");
                ((StringBuilder)object).append(n);
                Log.d((String)AppLockController.TAG, (String)((StringBuilder)object).toString());
                if (n == 0) {
                    set2 = set.getMaskList(999);
                    if (set2 != null) {
                        set = set.maskMap.put(999, set2);
                    }
                    set = new StringBuilder();
                    ((StringBuilder)((Object)set)).append("refresh mask value = ");
                    ((StringBuilder)((Object)set)).append(set2);
                    ((StringBuilder)((Object)set)).append(" id = 999");
                    Log.d((String)AppLockController.TAG, (String)((StringBuilder)((Object)set)).toString());
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            private final Set<String> getMaskList(int n) {
                Object object;
                Object object2;
                block9: {
                    Throwable throwable2;
                    block6: {
                        block8: {
                            block7: {
                                object2 = null;
                                try {
                                    object = j.a;
                                    object = this.getMethod();
                                    object = object != null ? object.invoke((Object)this.securityManager, n) : null;
                                }
                                catch (Throwable throwable2) {
                                    break block6;
                                }
                                object = object instanceof List ? (List)object : null;
                                if (object == null) break block7;
                                Set set = u.o0((Iterable)object);
                                object = set;
                                if (set != null) break block8;
                            }
                            object = I.b();
                        }
                        object = j.a((Object)object);
                        break block9;
                    }
                    object = j.a;
                    object = j.a((Object)k.a((Throwable)throwable2));
                }
                if (j.b((Object)object) == null) {
                    object2 = object;
                }
                return (Set)object2;
            }

            private final Method getMethod() {
                return (Method)this.method$delegate.getValue();
            }

            private final boolean isInLockV1(String object, int n) {
                try {
                    j.a a2 = j.a;
                    this.securityManager.getApplicationAccessControlEnabledAsUser((String)object, n);
                    object = j.a((Object)(this.securityManager.checkAccessControlPassAsUser((String)object, n) ^ true));
                }
                catch (Throwable throwable) {
                    j.a a3 = j.a;
                    object = j.a((Object)k.a((Throwable)throwable));
                }
                if (j.b((Object)object) != null) {
                    object = Boolean.FALSE;
                }
                return (Boolean)object;
            }

            private final boolean isInLockedV2(String string, int n) {
                Set<String> set = this.maskMap.get(n);
                boolean bl = set != null ? set.contains(string) : this.isInLockV1(string, n);
                return bl;
            }

            private final void refreshMaskMap(boolean bl) {
                if (this.getMethod() == null) {
                    return;
                }
                if (this.bgHandler.hasCallbacks(this.fetchMaskListRunnable)) {
                    return;
                }
                this.maskMap.clear();
                Handler handler = this.bgHandler;
                Runnable runnable = this.fetchMaskListRunnable;
                long l = bl ? 0L : 1000L;
                handler.postDelayed(runnable, l);
            }

            public static /* synthetic */ void refreshMaskMap$default(AppLockProvider appLockProvider, boolean bl, int n, Object object) {
                if ((n & 1) != 0) {
                    bl = false;
                }
                appLockProvider.refreshMaskMap(bl);
            }

            public final void clearCache() {
                this.maskMap.clear();
            }

            public final void close() {
                if (this.getMethod() == null) {
                    Log.d((String)AppLockController.TAG, (String)"start: method is null block close");
                    return;
                }
                this.context.getContentResolver().unregisterContentObserver((ContentObserver)this.maskStateObserver);
            }

            public final Handler getBgHandler() {
                return this.bgHandler;
            }

            public final Context getContext() {
                return this.context;
            }

            public final SecurityManager getSecurityManager() {
                return this.securityManager;
            }

            public final UserTracker getUserTracker() {
                return this.userTracker;
            }

            public final boolean isInLocked(String string, int n) {
                o.g((Object)string, (String)"packName");
                if (this.getMethod() == null) {
                    return this.isInLockV1(string, n);
                }
                return this.isInLockedV2(string, n);
            }

            public final void start() {
                if (this.getMethod() == null) {
                    Log.d((String)AppLockController.TAG, (String)"start: method is null block start");
                    return;
                }
                this.context.getContentResolver().registerContentObserver(Companion.getACCESS_CONTROL_LOCK_MASK(), false, (ContentObserver)this.maskStateObserver, -1);
                Log.d((String)AppLockController.TAG, (String)"start: method not null ");
            }

            public final void updateUser() {
                this.refreshMaskMap(true);
            }
        };
    }

    public static /* synthetic */ void a(AppLockController appLockController) {
        AppLockController.start$lambda$0(appLockController);
    }

    public static final /* synthetic */ void access$close(AppLockController appLockController) {
        appLockController.close();
    }

    public static final /* synthetic */ Context access$getContext$p(AppLockController appLockController) {
        return appLockController.context;
    }

    public static final /* synthetic */ boolean access$getLockEnable$p(AppLockController appLockController) {
        return appLockController.lockEnable;
    }

    public static final /* synthetic */ lockStateObserver.1 access$getLockStateObserver$p(AppLockController appLockController) {
        return appLockController.lockStateObserver;
    }

    public static final /* synthetic */ AppLockProvider access$getProvider$p(AppLockController appLockController) {
        return appLockController.provider;
    }

    public static final /* synthetic */ UserTracker access$getUserTracker$p(AppLockController appLockController) {
        return appLockController.userTracker;
    }

    public static final /* synthetic */ void access$setLockEnable$p(AppLockController appLockController, boolean bl) {
        appLockController.lockEnable = bl;
    }

    public static final /* synthetic */ void access$start(AppLockController appLockController) {
        appLockController.start();
    }

    private final void close() {
        this.context.getContentResolver().unregisterContentObserver((ContentObserver)this.lockStateObserver);
        this.userTracker.removeCallback((UserTracker.Callback)this.userCallback);
    }

    private final void registerLockStatus() {
        this.context.getContentResolver().registerContentObserver(ACCESS_CONTROL_LOCK_ENABLED, false, (ContentObserver)this.lockStateObserver, -1);
    }

    private final void start() {
        this.userTracker.addCallback((UserTracker.Callback)this.userCallback, this.bgExecutor);
        this.registerLockStatus();
        this.bgHandler.post((Runnable)new a(this));
    }

    private static final void start$lambda$0(AppLockController appLockController) {
        o.g((Object)appLockController, (String)"this$0");
        appLockController.lockStateObserver.onChange(false);
    }

    public final void init() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final AppLockController this$0;
            {
                this.this$0 = appLockController;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, d d2) {
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
                    AppLockController.access$start(this.this$0);
                    AppLockController.access$getProvider$p(this.this$0).start();
                    this.label = 1;
                    if (M.a((d)this) == object2) {
                        return object2;
                    }
                }
                throw new c();
            }
        }, (int)3, null).k(new Function1(this){
            final AppLockController this$0;
            {
                this.this$0 = appLockController;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                AppLockController.access$close(this.this$0);
                AppLockController.access$getProvider$p(this.this$0).close();
            }
        });
    }

    public final boolean isInLockState(String string, int n) {
        o.g((Object)string, (String)"packName");
        if (!this.lockEnable) {
            return false;
        }
        return this.provider.isInLocked(string, n);
    }
}
