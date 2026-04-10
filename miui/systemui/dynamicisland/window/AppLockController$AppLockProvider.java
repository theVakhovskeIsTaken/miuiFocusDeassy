/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.d
 *  G0.e
 *  G0.j
 *  G0.j$a
 *  G0.k
 *  H0.I
 *  H0.u
 *  U0.a
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.os.Handler
 *  android.util.Log
 *  com.android.systemui.settings.UserTracker
 *  kotlin.jvm.internal.o
 *  miui.security.SecurityManager
 */
package miui.systemui.dynamicisland.window;

import G0.d;
import G0.e;
import G0.j;
import G0.k;
import H0.I;
import H0.u;
import U0.a;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import com.android.systemui.settings.UserTracker;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.o;
import miui.security.SecurityManager;
import miui.systemui.dynamicisland.window.AppLockController;
import miui.systemui.dynamicisland.window.b;

public final class AppLockController.AppLockProvider {
    private final Handler bgHandler;
    private final Context context;
    private final Runnable fetchMaskListRunnable;
    private final ConcurrentHashMap<Integer, Set<String>> maskMap;
    private final maskStateObserver.1 maskStateObserver;
    private final d method$delegate;
    private final SecurityManager securityManager;
    final AppLockController this$0;
    private final UserTracker userTracker;

    public AppLockController.AppLockProvider(AppLockController appLockController, SecurityManager securityManager, Context context, Handler handler, UserTracker userTracker) {
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
        this.method$delegate = e.b((a)new a(this){
            final AppLockController.AppLockProvider this$0;
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
            final AppLockController.AppLockProvider this$0;
            final AppLockController this$1;
            {
                this.this$0 = appLockProvider;
                this.this$1 = appLockController;
                super(handler);
            }

            public void onChange(boolean bl) {
                if (AppLockController.AppLockProvider.access$getMethod(this.this$0) != null && AppLockController.access$getLockEnable$p(this.this$1)) {
                    AppLockController.AppLockProvider.refreshMaskMap$default(this.this$0, false, 1, null);
                }
            }
        };
        this.fetchMaskListRunnable = new b(this);
    }

    public static /* synthetic */ void a(AppLockController.AppLockProvider appLockProvider) {
        AppLockController.AppLockProvider.fetchMaskListRunnable$lambda$2(appLockProvider);
    }

    public static final /* synthetic */ Method access$getMethod(AppLockController.AppLockProvider appLockProvider) {
        return appLockProvider.getMethod();
    }

    private static final void fetchMaskListRunnable$lambda$2(AppLockController.AppLockProvider set) {
        Object object;
        o.g((Object)set, (String)"this$0");
        int n = ((Object)set).userTracker.getUserId();
        Set<String> set2 = ((Object)set).getMaskList(n);
        if (set2 != null) {
            object = ((Object)set).maskMap.put(n, set2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("refresh mask value = ");
        ((StringBuilder)object).append(set2);
        ((StringBuilder)object).append("  id = ");
        ((StringBuilder)object).append(n);
        Log.d((String)AppLockController.TAG, (String)((StringBuilder)object).toString());
        if (n == 0) {
            set2 = ((Object)set).getMaskList(999);
            if (set2 != null) {
                set = ((Object)set).maskMap.put(999, set2);
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

    public static /* synthetic */ void refreshMaskMap$default(AppLockController.AppLockProvider appLockProvider, boolean bl, int n, Object object) {
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
}
