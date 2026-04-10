/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  N0.a
 *  N0.b
 */
package miui.systemui.dynamicisland.anim;

import N0.a;
import N0.b;

public final class DynamicIslandAnimationCallbackType
extends Enum<DynamicIslandAnimationCallbackType> {
    private static final a $ENTRIES;
    private static final DynamicIslandAnimationCallbackType[] $VALUES;
    public static final /* enum */ DynamicIslandAnimationCallbackType ANIM_CANCEL;
    public static final /* enum */ DynamicIslandAnimationCallbackType ANIM_FINISH;
    public static final /* enum */ DynamicIslandAnimationCallbackType ANIM_START;

    private static final /* synthetic */ DynamicIslandAnimationCallbackType[] $values() {
        return new DynamicIslandAnimationCallbackType[]{ANIM_START, ANIM_FINISH, ANIM_CANCEL};
    }

    static {
        ANIM_START = new DynamicIslandAnimationCallbackType();
        ANIM_FINISH = new DynamicIslandAnimationCallbackType();
        ANIM_CANCEL = new DynamicIslandAnimationCallbackType();
        Enum[] enumArray = DynamicIslandAnimationCallbackType.$values();
        $VALUES = enumArray;
        $ENTRIES = b.a((Enum[])enumArray);
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static DynamicIslandAnimationCallbackType valueOf(String string) {
        return Enum.valueOf(DynamicIslandAnimationCallbackType.class, string);
    }

    public static DynamicIslandAnimationCallbackType[] values() {
        return (DynamicIslandAnimationCallbackType[])$VALUES.clone();
    }
}
