/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.d
 *  android.util.Log
 *  i1.I
 *  i1.K
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.u
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import G0.i;
import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import android.util.Log;
import i1.I;
import i1.K;
import i1.f;
import i1.g;
import i1.h;
import i1.u;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.DynamicIslandViewModel$special$;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public final class DynamicIslandViewModel {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final i DYNAMIC_ISLAND_INIT_SWIPE_INFO;
    private final u _state = K.a(null);
    private final u _stateName = K.a(null);
    private DynamicIslandViewStateChangeCallback dynamicIslandViewStateChangeCallback;
    private final f isExpanded = h.n((f)new f((f)this.getState()){
        final f $this_unsafeTransform$inlined;
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
                    if (!(var2_2 /* !! */  instanceof special$$inlined$map$1$2$1)) ** GOTO lbl-1000
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
                            final special$$inlined$map$1$2 this$0;
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
                    var4_3 /* !! */  = c.c();
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
                        var1_1 = b.a((boolean)((DynamicIslandState)var1_1 instanceof DynamicIslandState.Expanded));
                        var2_2 /* !! */ .label = 1;
                        if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                            return var4_3 /* !! */ ;
                        }
                    }
                    return s.a;
                }
            }, d2)) == c.c()) {
                return object;
            }
            return s.a;
        }
    });
    private DynamicIslandState oldState = (DynamicIslandState)this.getState().getValue();

    static {
        Float f2 = Float.valueOf(0.0f);
        DYNAMIC_ISLAND_INIT_SWIPE_INFO = new i((Object)f2, (Object)f2);
    }

    public final DynamicIslandState getOldState() {
        return this.oldState;
    }

    public final I getState() {
        return h.b((u)this._state);
    }

    public final I getStateName() {
        return h.b((u)this._stateName);
    }

    public final f isExpanded() {
        return this.isExpanded;
    }

    public final void registerDynamicIslandViewStateChangeCallback(DynamicIslandViewStateChangeCallback dynamicIslandViewStateChangeCallback) {
        o.g((Object)dynamicIslandViewStateChangeCallback, (String)"callback");
        this.dynamicIslandViewStateChangeCallback = dynamicIslandViewStateChangeCallback;
    }

    public final void setOldState(DynamicIslandState dynamicIslandState) {
        this.oldState = dynamicIslandState;
    }

    public final void setState(DynamicIslandState object, DynamicIslandState dynamicIslandState) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("setState: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" -> ");
        ((StringBuilder)object2).append(dynamicIslandState);
        Log.d((String)"addState", (String)((StringBuilder)object2).toString());
        object2 = this.dynamicIslandViewStateChangeCallback;
        if (object2 != null) {
            object2.onStateChanged((DynamicIslandState)object, dynamicIslandState);
        }
        this.oldState = object;
        this._state.setValue((Object)dynamicIslandState);
        object2 = this._stateName;
        object = dynamicIslandState != null ? dynamicIslandState.getClass().getSimpleName() : null;
        object2.setValue(object);
    }

    public final void updateState(DynamicIslandContentView object) {
        Object object2;
        Object var5_2 = null;
        object2 = object != null && (object2 = ((DynamicIslandBaseContentView)((Object)object)).getBigIslandView()) != null ? object2.getContentDescription() : null;
        DynamicIslandState dynamicIslandState = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getLastState() : null;
        DynamicIslandState dynamicIslandState2 = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view ");
        stringBuilder.append(object2);
        stringBuilder.append(" updateState: ");
        stringBuilder.append(dynamicIslandState);
        stringBuilder.append(" -> ");
        stringBuilder.append(dynamicIslandState2);
        Log.d((String)"updateState", (String)stringBuilder.toString());
        object2 = this.dynamicIslandViewStateChangeCallback;
        if (object2 != null) {
            object2.onStateChanged((DynamicIslandContentView)((Object)object));
        }
        dynamicIslandState = this._state;
        object2 = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
        dynamicIslandState.setValue(object2);
        dynamicIslandState = this._stateName;
        object2 = var5_2;
        if (object != null) {
            object = ((DynamicIslandBaseContentView)((Object)object)).getState();
            object2 = var5_2;
            if (object != null) {
                object2 = object.getClass().getSimpleName();
            }
        }
        dynamicIslandState.setValue(object2);
    }
}
