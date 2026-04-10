/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.event;

import miui.systemui.dynamicisland.event.DynamicIslandState;

public static final class DynamicIslandState.Deleted
extends DynamicIslandState {
    private boolean deleteByAddNew;

    public DynamicIslandState.Deleted() {
        super(null);
    }

    public final boolean getDeleteByAddNew() {
        return this.deleteByAddNew;
    }

    public final void setDeleteByAddNew(boolean bl) {
        this.deleteByAddNew = bl;
    }
}
