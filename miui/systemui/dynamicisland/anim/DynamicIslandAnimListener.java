/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 *  kotlin.jvm.internal.o
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import android.os.Trace;
import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public class DynamicIslandAnimListener
extends TransitionListener {
    private final DynamicIslandAnimationDelegate delegate;

    public DynamicIslandAnimListener(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        o.g((Object)dynamicIslandAnimationDelegate, (String)"delegate");
        this.delegate = dynamicIslandAnimationDelegate;
    }

    public void onBegin(Object object) {
        super.onBegin(object);
        String string = DynamicIslandUtils.INSTANCE.getTraceName();
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        Trace.beginAsyncSection((String)string, (int)((String)object).hashCode());
        this.delegate.onBegin(object);
        this.delegate.setAnimating(true);
    }

    public void onCancel(Object object) {
        super.onCancel(object);
        String string = DynamicIslandUtils.INSTANCE.getTraceName();
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        Trace.endAsyncSection((String)string, (int)((String)object).hashCode());
        this.delegate.onCancel(object);
        this.delegate.setAnimating(false);
    }

    public void onComplete(Object object) {
        super.onComplete(object);
        String string = DynamicIslandUtils.INSTANCE.getTraceName();
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        Trace.endAsyncSection((String)string, (int)((String)object).hashCode());
        this.delegate.onComplete(object);
        this.delegate.setAnimating(false);
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        super.onUpdate(object, collection);
        this.delegate.scheduleUpdate();
    }
}
