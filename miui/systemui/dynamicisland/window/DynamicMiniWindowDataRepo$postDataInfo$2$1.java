/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.j
 *  G0.j$a
 *  G0.s
 *  f1.k
 *  miui.app.MiuiFreeFormManager$MiuiFreeFormStackInfo
 */
package miui.systemui.dynamicisland.window;

import G0.j;
import G0.s;
import f1.k;
import miui.app.MiuiFreeFormManager;
import miui.systemui.dynamicisland.window.DynamicMiniWindowDataRepo;

public static final class DynamicMiniWindowDataRepo.postDataInfo.2.1
implements Runnable {
    final k $co;
    final boolean $forceDelete;
    final MiuiFreeFormManager.MiuiFreeFormStackInfo $stackInfo;
    final DynamicMiniWindowDataRepo this$0;

    public DynamicMiniWindowDataRepo.postDataInfo.2.1(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo, MiuiFreeFormManager.MiuiFreeFormStackInfo miuiFreeFormStackInfo, boolean bl, k k2) {
        this.this$0 = dynamicMiniWindowDataRepo;
        this.$stackInfo = miuiFreeFormStackInfo;
        this.$forceDelete = bl;
        this.$co = k2;
    }

    @Override
    public final void run() {
        this.this$0.updateDataInfo(this.$stackInfo, this.$forceDelete);
        k k2 = this.$co;
        j.a a2 = j.a;
        k2.resumeWith(j.a((Object)s.a));
    }
}
