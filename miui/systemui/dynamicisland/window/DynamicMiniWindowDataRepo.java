/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.j
 *  G0.j$a
 *  G0.s
 *  K0.d
 *  L0.b
 *  L0.c
 *  M0.h
 *  android.os.Handler
 *  android.util.Log
 *  f1.k
 *  f1.l
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.app.MiuiFreeFormManager$MiuiFreeFormStackInfo
 */
package miui.systemui.dynamicisland.window;

import G0.j;
import K0.d;
import L0.b;
import L0.c;
import M0.h;
import android.os.Handler;
import android.util.Log;
import f1.k;
import f1.l;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.app.MiuiFreeFormManager;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.window.DynamicMiniWindowDataRepo;
import miui.systemui.dynamicisland.window.r;
import miui.systemui.dynamicisland.window.s;
import miui.systemui.dynamicisland.window.t;
import miui.systemui.dynamicisland.window.u;

public final class DynamicMiniWindowDataRepo {
    public static final Companion Companion = new Object(null){
        {
            this();
        }

        public final String getTAG() {
            return TAG;
        }
    };
    public static final long MIN_REST_TIME = 1800000L;
    private static final String TAG = "DynamicMiniWindowDataRepo";
    private volatile boolean cancelled;
    private final Runnable clearDataRunnable;
    private final ConcurrentHashMap<String, ConcurrentHashMap.KeySetView<Integer, Boolean>> freeFormByUserPkg;
    private final Handler handler;
    private boolean hasInit;
    private long lastRestTime;
    private boolean support;

    public DynamicMiniWindowDataRepo(Handler handler) {
        o.g((Object)handler, (String)"handler");
        this.handler = handler;
        this.support = true;
        this.freeFormByUserPkg = new ConcurrentHashMap();
        this.clearDataRunnable = new r(this);
    }

    public static /* synthetic */ void a(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo) {
        DynamicMiniWindowDataRepo.resetData$lambda$4(dynamicMiniWindowDataRepo);
    }

    public static final /* synthetic */ void access$updateDataInfo(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo, MiuiFreeFormManager.MiuiFreeFormStackInfo miuiFreeFormStackInfo, boolean bl) {
        dynamicMiniWindowDataRepo.updateDataInfo(miuiFreeFormStackInfo, bl);
    }

    public static /* synthetic */ void b(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo) {
        DynamicMiniWindowDataRepo.start$lambda$2(dynamicMiniWindowDataRepo);
    }

    public static /* synthetic */ void c(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo) {
        DynamicMiniWindowDataRepo.clearDataRunnable$lambda$0(dynamicMiniWindowDataRepo);
    }

    private static final void clearDataRunnable$lambda$0(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo) {
        o.g((Object)dynamicMiniWindowDataRepo, (String)"this$0");
        if (dynamicMiniWindowDataRepo.cancelled && !dynamicMiniWindowDataRepo.freeFormByUserPkg.isEmpty()) {
            dynamicMiniWindowDataRepo.freeFormByUserPkg.clear();
        }
    }

    private final String createKey(int n, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append(":");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static /* synthetic */ ConcurrentHashMap.KeySetView d(Function1 function1, Object object) {
        return DynamicMiniWindowDataRepo.updateDataInfo$lambda$6(function1, object);
    }

    public static /* synthetic */ Object postDataInfo$default(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo, MiuiFreeFormManager.MiuiFreeFormStackInfo miuiFreeFormStackInfo, boolean bl, d d2, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return dynamicMiniWindowDataRepo.postDataInfo(miuiFreeFormStackInfo, bl, d2);
    }

    private static final void resetData$lambda$4(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo) {
        o.g((Object)dynamicMiniWindowDataRepo, (String)"this$0");
        if (!dynamicMiniWindowDataRepo.cancelled && !dynamicMiniWindowDataRepo.freeFormByUserPkg.isEmpty()) {
            List<MiuiFreeFormManager.MiuiFreeFormStackInfo> list = DynamicIslandUtils.INSTANCE.getFreeFormList();
            if (dynamicMiniWindowDataRepo.cancelled) {
                return;
            }
            String string = TAG;
            int n = dynamicMiniWindowDataRepo.freeFormByUserPkg.size();
            Object object = list != null ? Integer.valueOf(list.size()) : null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("resetData: old size = ");
            stringBuilder.append(n);
            stringBuilder.append(" new size = ");
            stringBuilder.append(object);
            Log.d((String)string, (String)stringBuilder.toString());
            dynamicMiniWindowDataRepo.freeFormByUserPkg.clear();
            if (list != null) {
                object = list.iterator();
                while (object.hasNext()) {
                    DynamicMiniWindowDataRepo.updateDataInfo$default(dynamicMiniWindowDataRepo, (MiuiFreeFormManager.MiuiFreeFormStackInfo)object.next(), false, 2, null);
                }
            }
        }
    }

    private static final void start$lambda$2(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo) {
        o.g((Object)dynamicMiniWindowDataRepo, (String)"this$0");
        if (dynamicMiniWindowDataRepo.cancelled) {
            return;
        }
        List<MiuiFreeFormManager.MiuiFreeFormStackInfo> list = DynamicIslandUtils.INSTANCE.getFreeFormList();
        if (list != null && !dynamicMiniWindowDataRepo.cancelled) {
            list = list.iterator();
            while (list.hasNext()) {
                DynamicMiniWindowDataRepo.updateDataInfo$default(dynamicMiniWindowDataRepo, (MiuiFreeFormManager.MiuiFreeFormStackInfo)list.next(), false, 2, null);
            }
        }
    }

    private final void updateDataInfo(MiuiFreeFormManager.MiuiFreeFormStackInfo object, boolean bl) {
        block7: {
            int n;
            int n2;
            String string;
            block9: {
                block10: {
                    boolean bl2;
                    block8: {
                        if (this.cancelled || (string = object != null ? ((MiuiFreeFormManager.MiuiFreeFormStackInfo)object).packageName : null) == null) break block7;
                        n2 = ((MiuiFreeFormManager.MiuiFreeFormStackInfo)object).userId;
                        string = ((MiuiFreeFormManager.MiuiFreeFormStackInfo)object).packageName;
                        o.f((Object)string, (String)"packageName");
                        string = this.createKey(n2, string);
                        n = ((MiuiFreeFormManager.MiuiFreeFormStackInfo)object).stackId;
                        bl2 = false;
                        if (!bl) break block8;
                        bl = bl2;
                        break block9;
                    }
                    if (object.isInFreeFormMode()) break block10;
                    bl = bl2;
                    if (!object.isInMiniFreeFormMode()) break block9;
                }
                bl = true;
            }
            String string2 = TAG;
            n2 = ((MiuiFreeFormManager.MiuiFreeFormStackInfo)object).displayId;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("updateDataInfo: key = ");
            stringBuilder.append(string);
            stringBuilder.append("  shouldAdd ");
            stringBuilder.append(bl);
            stringBuilder.append(" displayId = ");
            stringBuilder.append(n2);
            stringBuilder.append(" ");
            Log.d((String)string2, (String)stringBuilder.toString());
            if (bl && ((MiuiFreeFormManager.MiuiFreeFormStackInfo)object).displayId == 0) {
                object = this.freeFormByUserPkg.computeIfAbsent(string, new u(updateDataInfo.set.1.INSTANCE));
                o.f((Object)object, (String)"computeIfAbsent(...)");
                ((ConcurrentHashMap.KeySetView)object).add(n);
            } else if (!bl && (object = this.freeFormByUserPkg.get(string)) != null) {
                ((ConcurrentHashMap.KeySetView)object).remove(n);
                if (((ConcurrentHashMap.CollectionView)object).isEmpty()) {
                    this.freeFormByUserPkg.remove(string);
                }
            }
        }
    }

    public static /* synthetic */ void updateDataInfo$default(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo, MiuiFreeFormManager.MiuiFreeFormStackInfo miuiFreeFormStackInfo, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        dynamicMiniWindowDataRepo.updateDataInfo(miuiFreeFormStackInfo, bl);
    }

    private static final ConcurrentHashMap.KeySetView updateDataInfo$lambda$6(Function1 function1, Object object) {
        o.g((Object)function1, (String)"$tmp0");
        return (ConcurrentHashMap.KeySetView)function1.invoke(object);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final boolean getSupport() {
        return this.support;
    }

    public final boolean isInMiniWindow(String object, int n) {
        o.g((Object)object, (String)"packageName");
        boolean bl = this.support;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        object = this.createKey(n, (String)object);
        object = this.freeFormByUserPkg.get(object);
        bl = bl2;
        if (object != null) {
            bl = bl2;
            if (!((ConcurrentHashMap.CollectionView)object).isEmpty()) {
                bl = true;
            }
        }
        return bl;
    }

    public final Object postDataInfo(MiuiFreeFormManager.MiuiFreeFormStackInfo object, boolean bl, d d2) {
        l l2 = new l(b.b((d)d2), 1);
        l2.A();
        this.getHandler().post(new Runnable(this, (MiuiFreeFormManager.MiuiFreeFormStackInfo)object, bl, (k)l2){
            final k $co;
            final boolean $forceDelete;
            final MiuiFreeFormManager.MiuiFreeFormStackInfo $stackInfo;
            final DynamicMiniWindowDataRepo this$0;
            {
                this.this$0 = dynamicMiniWindowDataRepo;
                this.$stackInfo = miuiFreeFormStackInfo;
                this.$forceDelete = bl;
                this.$co = k2;
            }

            public final void run() {
                DynamicMiniWindowDataRepo.access$updateDataInfo(this.this$0, this.$stackInfo, this.$forceDelete);
                k k2 = this.$co;
                j.a a2 = j.a;
                k2.resumeWith(j.a((Object)G0.s.a));
            }
        });
        object = l2.x();
        if (object == c.c()) {
            h.c((d)d2);
        }
        if (object == c.c()) {
            return object;
        }
        return G0.s.a;
    }

    public final void resetData() {
        if (!this.cancelled && !this.freeFormByUserPkg.isEmpty() && Math.abs(System.currentTimeMillis() - this.lastRestTime) >= 1800000L) {
            this.lastRestTime = System.currentTimeMillis();
            this.handler.post((Runnable)new t(this));
        }
    }

    public final void setSupport(boolean bl) {
        this.support = bl;
    }

    public final void start() {
        if (this.hasInit) {
            return;
        }
        this.cancelled = false;
        this.hasInit = true;
        this.handler.removeCallbacks(this.clearDataRunnable);
        this.handler.post((Runnable)new s(this));
    }

    public final void stop() {
        this.freeFormByUserPkg.clear();
        this.cancelled = true;
        this.hasInit = false;
        this.handler.removeCallbacks(this.clearDataRunnable);
        this.handler.post(this.clearDataRunnable);
    }
}
