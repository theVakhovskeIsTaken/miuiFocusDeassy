/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  H0.m
 *  android.util.Log
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.anim;

import H0.m;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.anim.a;

public final class DynamicIslandAnimationCallback {
    private final Map<DynamicIslandAnimationType, List<AnimCallback>> mAnimCallbacks = new LinkedHashMap<DynamicIslandAnimationType, List<AnimCallback>>();

    public static /* synthetic */ boolean a(Function1 function1, Object object) {
        return DynamicIslandAnimationCallback.removeCallback$lambda$7(function1, object);
    }

    private static final boolean removeCallback$lambda$7(Function1 function1, Object object) {
        o.g((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    public final void addAnimationCallback(DynamicIslandAnimationType object, DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, Function1 object2) {
        o.g((Object)object, (String)"animType");
        o.g((Object)((Object)dynamicIslandAnimationCallbackType), (String)"callbackType");
        o.g((Object)object2, (String)"callback");
        if (!this.mAnimCallbacks.containsKey(object)) {
            this.mAnimCallbacks.put((DynamicIslandAnimationType)((Object)object), new ArrayList());
        }
        Iterator iterator = new StringBuilder();
        ((StringBuilder)((Object)iterator)).append("addAnimationCallback animType=");
        ((StringBuilder)((Object)iterator)).append(object);
        ((StringBuilder)((Object)iterator)).append(", callbackType=");
        ((StringBuilder)((Object)iterator)).append((Object)dynamicIslandAnimationCallbackType);
        ((StringBuilder)((Object)iterator)).append(", callback=");
        ((StringBuilder)((Object)iterator)).append(object2);
        Log.d((String)"DynamicIslandAnimationCallback", (String)((StringBuilder)((Object)iterator)).toString());
        iterator = this.mAnimCallbacks.get(object);
        if (iterator != null) {
            object = (List)((Object)iterator);
            if (!object.isEmpty()) {
                iterator = object.iterator();
                while (iterator.hasNext()) {
                    AnimCallback animCallback = iterator.next();
                    if (dynamicIslandAnimationCallbackType != animCallback.getType() || !o.c((Object)object2, (Object)animCallback.getCallback())) continue;
                    return;
                }
            }
            object.add(new Object(dynamicIslandAnimationCallbackType, (Function1)object2){
                private final Function1 callback;
                private final DynamicIslandAnimationCallbackType type;
                {
                    o.g((Object)((Object)dynamicIslandAnimationCallbackType), (String)"type");
                    o.g((Object)function1, (String)"callback");
                    this.type = dynamicIslandAnimationCallbackType;
                    this.callback = function1;
                }

                public static /* synthetic */ AnimCallback copy$default(AnimCallback animCallback, DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, Function1 function1, int n, Object object) {
                    if ((n & 1) != 0) {
                        dynamicIslandAnimationCallbackType = animCallback.type;
                    }
                    if ((n & 2) != 0) {
                        function1 = animCallback.callback;
                    }
                    return animCallback.copy(dynamicIslandAnimationCallbackType, function1);
                }

                public final DynamicIslandAnimationCallbackType component1() {
                    return this.type;
                }

                public final Function1 component2() {
                    return this.callback;
                }

                public final AnimCallback copy(DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, Function1 function1) {
                    o.g((Object)((Object)dynamicIslandAnimationCallbackType), (String)"type");
                    o.g((Object)function1, (String)"callback");
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public boolean equals(Object object) {
                    if (this == object) {
                        return true;
                    }
                    if (!(object instanceof AnimCallback)) {
                        return false;
                    }
                    object = object;
                    if (this.type != object.type) {
                        return false;
                    }
                    return o.c((Object)this.callback, (Object)object.callback);
                }

                public final Function1 getCallback() {
                    return this.callback;
                }

                public final DynamicIslandAnimationCallbackType getType() {
                    return this.type;
                }

                public int hashCode() {
                    return ((Object)((Object)this.type)).hashCode() * 31 + this.callback.hashCode();
                }

                public String toString() {
                    DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = this.type;
                    Function1 function1 = this.callback;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("AnimCallback(type=");
                    stringBuilder.append((Object)dynamicIslandAnimationCallbackType);
                    stringBuilder.append(", callback=");
                    stringBuilder.append(function1);
                    stringBuilder.append(")");
                    return stringBuilder.toString();
                }
            });
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("addStartCallback animType=");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(", callbackType=");
        ((StringBuilder)object2).append((Object)dynamicIslandAnimationCallbackType);
        ((StringBuilder)object2).append(" in empty collections.");
        throw new IllegalStateException(((StringBuilder)object2).toString().toString());
    }

    /*
     * WARNING - void declaration
     */
    public final void executeCallback(DynamicIslandAnimationType object, DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, String string) {
        void var7_9;
        o.g((Object)object, (String)"animType");
        o.g((Object)((Object)dynamicIslandAnimationCallbackType), (String)"callbackType");
        o.g((Object)string, (String)"tag");
        List<AnimCallback> list2 = this.mAnimCallbacks.get(object);
        if (list2 != null) {
            boolean bl = list2.isEmpty();
            int n = 0;
            int n2 = 0;
            if (!bl) {
                Iterator iterator = list2.iterator();
                while (true) {
                    n = n2;
                    if (!iterator.hasNext()) break;
                    if ((iterator.next()).getType() != dynamicIslandAnimationCallbackType) continue;
                    n2 = n = n2 + 1;
                    if (n >= 0) continue;
                    m.m();
                    n2 = n;
                }
            }
            Integer n3 = n;
        } else {
            Object var7_8 = null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("executeCallback animType=");
        stringBuilder.append(object);
        stringBuilder.append(", callbackType=");
        stringBuilder.append((Object)dynamicIslandAnimationCallbackType);
        stringBuilder.append(", tag=");
        stringBuilder.append(string);
        stringBuilder.append(", callbackNum=");
        stringBuilder.append(var7_9);
        Log.d((String)"DynamicIslandAnimationCallback", (String)stringBuilder.toString());
        List<AnimCallback> list = this.mAnimCallbacks.get(object);
        if (list != null) {
            object = new ArrayList();
            for (Object e : list) {
                if ((e).getType() != dynamicIslandAnimationCallbackType) continue;
                object.add(e);
            }
            object = object.iterator();
            while (object.hasNext()) {
                (object.next()).getCallback().invoke((Object)string);
            }
        }
    }

    public final void removeCallback(DynamicIslandAnimationType dynamicIslandAnimationType, DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, Function1 object) {
        o.g((Object)((Object)dynamicIslandAnimationType), (String)"animType");
        o.g((Object)((Object)dynamicIslandAnimationCallbackType), (String)"callbackType");
        o.g((Object)object, (String)"callback");
        if (!this.mAnimCallbacks.containsKey((Object)dynamicIslandAnimationType)) {
            return;
        }
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("removeCallback animType=");
        ((StringBuilder)object2).append((Object)dynamicIslandAnimationType);
        ((StringBuilder)object2).append(", callbackType=");
        ((StringBuilder)object2).append((Object)dynamicIslandAnimationCallbackType);
        ((StringBuilder)object2).append(", callback=");
        ((StringBuilder)object2).append(object);
        Log.d((String)"DynamicIslandAnimationCallback", (String)((StringBuilder)object2).toString());
        object2 = this.mAnimCallbacks.get((Object)dynamicIslandAnimationType);
        if (object2 != null) {
            ((List)object2).removeIf(new a(new Function1(dynamicIslandAnimationCallbackType, (Function1)object){
                final Function1 $callback;
                final DynamicIslandAnimationCallbackType $callbackType;
                {
                    this.$callbackType = dynamicIslandAnimationCallbackType;
                    this.$callback = function1;
                    super(1);
                }

                public final Boolean invoke(AnimCallback animCallback) {
                    o.g((Object)animCallback, (String)"it");
                    boolean bl = animCallback.getType() == this.$callbackType && o.c((Object)animCallback.getCallback(), (Object)this.$callback);
                    return bl;
                }
            }));
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("removeCallback animType=");
        ((StringBuilder)object).append((Object)dynamicIslandAnimationType);
        ((StringBuilder)object).append(", callbackType=");
        ((StringBuilder)object).append((Object)dynamicIslandAnimationCallbackType);
        ((StringBuilder)object).append(" in empty collections.");
        throw new IllegalStateException(((StringBuilder)object).toString().toString());
    }
}
