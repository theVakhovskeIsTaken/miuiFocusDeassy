/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.g
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event;

import G0.g;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.event.State;

public abstract class DynamicIslandState
extends State {
    private DynamicIslandState() {
    }

    public /* synthetic */ DynamicIslandState(h h2) {
        this();
    }

    public final DynamicIslandState changeToState(DynamicIslandState dynamicIslandState) {
        o.g((Object)dynamicIslandState, (String)"newState");
        dynamicIslandState.setTime(this.getTime());
        dynamicIslandState.setPostTime(this.getPostTime());
        return dynamicIslandState;
    }

    public final DynamicIslandState copy() {
        block14: {
            DynamicIslandState dynamicIslandState;
            block3: {
                block13: {
                    block12: {
                        block11: {
                            block10: {
                                block9: {
                                    block8: {
                                        block7: {
                                            block6: {
                                                block5: {
                                                    block4: {
                                                        block2: {
                                                            if (!(this instanceof Init)) break block2;
                                                            dynamicIslandState = new DynamicIslandState(){};
                                                            break block3;
                                                        }
                                                        if (!(this instanceof Hidden)) break block4;
                                                        dynamicIslandState = new DynamicIslandState(){};
                                                        break block3;
                                                    }
                                                    if (!(this instanceof BigIsland)) break block5;
                                                    dynamicIslandState = new DynamicIslandState(){};
                                                    break block3;
                                                }
                                                if (!(this instanceof ShowOnceBigIsland)) break block6;
                                                dynamicIslandState = new DynamicIslandState(){};
                                                break block3;
                                            }
                                            if (!(this instanceof SmallIsland)) break block7;
                                            dynamicIslandState = new DynamicIslandState(){};
                                            break block3;
                                        }
                                        if (!(this instanceof Expanded)) break block8;
                                        dynamicIslandState = new DynamicIslandState(){};
                                        break block3;
                                    }
                                    if (!(this instanceof MiniWindowExpanded)) break block9;
                                    dynamicIslandState = new DynamicIslandState(){};
                                    break block3;
                                }
                                if (!(this instanceof AppExpanded)) break block10;
                                dynamicIslandState = new DynamicIslandState(){};
                                break block3;
                            }
                            if (!(this instanceof Deleted)) break block11;
                            dynamicIslandState = new DynamicIslandState(){
                                private boolean deleteByAddNew;

                                public final boolean getDeleteByAddNew() {
                                    return this.deleteByAddNew;
                                }

                                public final void setDeleteByAddNew(boolean bl) {
                                    this.deleteByAddNew = bl;
                                }
                            };
                            break block3;
                        }
                        if (!(this instanceof Empty)) break block12;
                        dynamicIslandState = new DynamicIslandState(){};
                        break block3;
                    }
                    if (!(this instanceof SubAppExpanded)) break block13;
                    dynamicIslandState = new DynamicIslandState(){};
                    break block3;
                }
                if (!(this instanceof SubMiniWindowExpanded)) break block14;
                dynamicIslandState = new DynamicIslandState(){};
            }
            return dynamicIslandState;
        }
        throw new g();
    }
}
