/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  android.util.Log
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.event.handler;

import G0.i;
import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.event.handler.a;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class HiddenStateHandler
extends StateHandler {
    public HiddenStateHandler(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        super(dynamicIslandTouchInteractor);
    }

    public static /* synthetic */ boolean b(Function1 function1, Object object) {
        return HiddenStateHandler.handleReplacedState$lambda$0(function1, object);
    }

    private static final boolean handleReplacedState$lambda$0(Function1 function1, Object object) {
        o.g((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    @Override
    public DynamicIslandContentView handleFillInState(ArrayList<DynamicIslandContentView> arrayList) {
        Integer n = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        Object object = new StringBuilder();
        object.append("handleFillInState ");
        object.append(n);
        Log.d((String)"DynamicIslandEventDebug", (String)object.toString());
        if (this.isTempHidden(this.getCurrent())) {
            object = this.getCurrent();
            n = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
            o.d((Object)n);
            if (n > 0) {
                this.setCurrent(arrayList.get(0));
            } else {
                this.setCurrent(null);
            }
            return object;
        }
        n = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        o.d((Object)n);
        if (n > 0) {
            this.setCurrent(arrayList.get(0));
        } else {
            this.setCurrent(null);
        }
        return this.getCurrent();
    }

    @Override
    public void handleReplacedState(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> arrayList, Boolean object2) {
        int n;
        Object object3;
        Object var8_4 = null;
        object3 = object != null && (object3 = object.getCurrentIslandData()) != null ? object3.getTickerData() : null;
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        Object object4 = this.getCurrent();
        object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getTickerData() : null;
        Integer n2 = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        StateHandler stateHandler = this.getNext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HiddenStateHandler handleReplacedState: originState: ");
        stringBuilder.append(object);
        stringBuilder.append("  ---- ");
        stringBuilder.append((String)object3);
        stringBuilder.append(", current: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append("----");
        stringBuilder.append((String)object4);
        stringBuilder.append(", hiddenList: ");
        stringBuilder.append(n2);
        stringBuilder.append("}, userSwipe: ");
        stringBuilder.append(object2);
        stringBuilder.append(" , next: ");
        stringBuilder.append(stateHandler);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        this.setCurrent((DynamicIslandContentView)((Object)object));
        object2 = object != null && (object2 = object.getState()) != null ? ((DynamicIslandState)object2).changeToState(new DynamicIslandState(){}) : null;
        if (arrayList != null) {
            arrayList.removeIf(new a(new Function1(this){
                final HiddenStateHandler this$0;
                {
                    this.this$0 = hiddenStateHandler;
                    super(1);
                }

                public final Boolean invoke(DynamicIslandContentView object) {
                    o.g((Object)object, (String)"it");
                    object = object.getCurrentIslandData();
                    String string = null;
                    object = object != null ? object.getKey() : null;
                    DynamicIslandContentView dynamicIslandContentView = this.this$0.getCurrent();
                    String string2 = string;
                    if (dynamicIslandContentView != null) {
                        dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData();
                        string2 = string;
                        if (dynamicIslandContentView != null) {
                            string2 = dynamicIslandContentView.getKey();
                        }
                    }
                    return o.c((Object)object, string2);
                }
            }));
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && (n = object != null && (object = object.getCurrentIslandData()) != null && (object = object.getPriority()) != null ? (Integer)object : 1) == 2) {
            if (arrayList != null) {
                n = arrayList.size();
                object = this.getCurrent();
                o.d((Object)object);
                arrayList.add(n - 1, (DynamicIslandContentView)((Object)object));
            }
            this.addState(this.getCurrent(), (DynamicIslandState)object2);
            object = var8_4;
            if (arrayList != null) {
                object = arrayList.get(0);
            }
            this.setCurrent((DynamicIslandContentView)((Object)object));
            return;
        }
        if (arrayList != null) {
            object = this.getCurrent();
            o.d((Object)object);
            arrayList.add(0, (DynamicIslandContentView)((Object)object));
        }
        this.addState(this.getCurrent(), (DynamicIslandState)object2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void onSwipe(float var1_1, float var2_2, DynamicIslandContentView var3_3, DynamicIslandContentView var4_4, DynamicIslandContentView var5_5, ArrayList<DynamicIslandContentView> var6_6) {
        block5: {
            block6: {
                block4: {
                    block7: {
                        block12: {
                            block8: {
                                block11: {
                                    block9: {
                                        block10: {
                                            if (var6_6 == null || var6_6.size() < 1) break block5;
                                            var7_7 = this.gatherStates(var3_3 /* !! */ , var4_4, (DynamicIslandContentView)var5_5, var6_6);
                                            var8_8 = this.checkStates(var7_7);
                                            ((Number)((i)this.getTouchInteractor().getSwipeInfo().getValue()).d()).floatValue();
                                            if (!this.swipeHorizontal(var6_6.get(0))) {
                                                return;
                                            }
                                            if (!var8_8) break block6;
                                            if (!this.isSwipeTowardsSmallIsland(var1_1, var6_6.get(0).getContext())) {
                                                var3_3 /* !! */  = var6_6.get(0);
lbl11:
                                                // 2 sources

                                                while (true) {
                                                    continue;
                                                    break;
                                                }
                                            }
                                            var3_3 /* !! */  = var6_6.get(var6_6.size() - 1);
                                            ** while (true)
                                            var4_4 = var3_3 /* !! */ ;
                                            o.d((Object)var4_4);
                                            var5_5 = var4_4.getState();
                                            if (var7_7 == 8) break block7;
                                            if (var7_7 == 9) break block8;
                                            if (var7_7 == 11) break block9;
                                            if (var5_5 == null) break block10;
                                            var3_3 /* !! */  = var5_5.changeToState(new DynamicIslandState(){});
                                            break block4;
                                        }
lbl25:
                                        // 6 sources

                                        while (true) {
                                            var3_3 /* !! */  = null;
                                            break block4;
                                            break;
                                        }
                                    }
                                    if (this.isSwipeTowardsSmallIsland(var1_1, var4_4.getContext())) break block11;
                                    if (var5_5 == null) ** GOTO lbl25
                                    var3_3 /* !! */  = var5_5.changeToState(new DynamicIslandState(){});
                                    break block4;
                                }
                                if (var5_5 == null) ** GOTO lbl25
                                var3_3 /* !! */  = var5_5.changeToState(new /* invalid duplicate definition of identical inner class */);
                                break block4;
                            }
                            if (this.isSwipeTowardsSmallIsland(var1_1, var4_4.getContext())) break block12;
                            if (var5_5 == null) ** GOTO lbl25
                            var3_3 /* !! */  = var5_5.changeToState(new /* invalid duplicate definition of identical inner class */);
                            break block4;
                        }
                        if (var5_5 == null) ** GOTO lbl25
                        var3_3 /* !! */  = var5_5.changeToState(new /* invalid duplicate definition of identical inner class */);
                        break block4;
                    }
                    ** while (var5_5 == null)
lbl48:
                    // 1 sources

                    var3_3 /* !! */  = var5_5.changeToState(new DynamicIslandState(){});
                }
                var4_4.onSwipe(var1_1, var2_2, var4_4, (DynamicIslandState)var5_5, (DynamicIslandState)var3_3 /* !! */ );
            }
            return;
        }
        Log.e((String)"DynamicIslandSwipeDebug", (String)"HiddenStateHandler handles empty list");
    }
}
