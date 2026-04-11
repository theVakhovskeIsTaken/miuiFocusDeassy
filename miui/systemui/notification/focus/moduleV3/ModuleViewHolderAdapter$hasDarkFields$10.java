/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.o
 *  kotlin.jvm.internal.m
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.o$a
 */
package miui.systemui.notification.focus.moduleV3;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;

public final class ModuleViewHolderAdapter.hasDarkFields.10
extends m
implements U0.o {
    final List<String> $darkValues;

    public ModuleViewHolderAdapter.hasDarkFields.10(List<String> list) {
        this.$darkValues = list;
        super(2, o.a.class, "checkDark", "hasDarkFields$checkDark(Ljava/util/List;Ljava/lang/String;[Ljava/lang/Object;)V", 0);
    }

    public final void invoke(String string, Object[] objectArray) {
        o.g((Object)string, (String)"p0");
        o.g((Object)objectArray, (String)"p1");
        ModuleViewHolderAdapter.hasDarkFields$checkDark(this.$darkValues, string, objectArray);
    }
}
