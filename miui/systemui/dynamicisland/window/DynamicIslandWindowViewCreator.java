/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  android.content.Context
 *  android.util.Log
 *  android.view.LayoutInflater
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent
 *  kotlin.jvm.internal.o
 *  miui.systemui.dagger.qualifiers.Plugin
 *  miui.systemui.util.ThemeUtils
 */
package miui.systemui.dynamicisland.window;

import D0.a;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent;
import kotlin.jvm.internal.o;
import miui.systemui.dagger.qualifiers.Plugin;
import miui.systemui.dynamicisland.DynamicFeatureConfig;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.dagger.DynamicIslandViewComponent;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.util.ThemeUtils;

public final class DynamicIslandWindowViewCreator
implements LifecycleOwner {
    private final a context;
    private final LifecycleRegistry lifecycle;
    private final DynamicIslandViewComponent.Factory viewComponentFactory;
    private DynamicIslandWindowView windowView;

    public DynamicIslandWindowViewCreator(@Plugin a a2, DynamicIslandViewComponent.Factory factory) {
        o.g((Object)a2, (String)"context");
        o.g((Object)factory, (String)"viewComponentFactory");
        this.context = a2;
        this.viewComponentFactory = factory;
        this.lifecycle = new LifecycleRegistry((LifecycleOwner)this);
    }

    public final DynamicIslandContent createView() {
        DynamicIslandWindowView dynamicIslandWindowView;
        if (!DynamicFeatureConfig.INSTANCE.getFEATURE_DYNAMIC_ISLAND()) {
            Log.w((String)"DynamicIslandWindowViewCreator", (String)"feature dynamic island is not enabled.");
            DynamicIslandWindowView dynamicIslandWindowView2 = this.windowView;
            if (dynamicIslandWindowView2 != null) {
                dynamicIslandWindowView2.destroy();
            }
            return null;
        }
        Object object = ThemeUtils.INSTANCE;
        Object object2 = this.context.get();
        o.f((Object)object2, (String)"get(...)");
        object.fixResourcesPackage((Context)object2);
        object = this.windowView;
        if (object != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("destroy window view ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" caused by new instance created.");
            Log.w((String)"DynamicIslandWindowViewCreator", (String)((StringBuilder)object2).toString());
            ((DynamicIslandWindowView)((Object)object)).destroy();
        }
        object2 = LayoutInflater.from((Context)((Context)this.context.get())).inflate(R.layout.dynamic_island_window_view, null);
        o.e((Object)object2, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.window.DynamicIslandWindowView");
        this.windowView = dynamicIslandWindowView = (DynamicIslandWindowView)((Object)object2);
        object2 = this.viewComponentFactory.create(dynamicIslandWindowView);
        object = object2.getStartables().values().iterator();
        while (object.hasNext()) {
            ((DynamicIslandStartable)object.next()).start();
        }
        dynamicIslandWindowView.setViewComponent((DynamicIslandViewComponent)object2);
        return dynamicIslandWindowView.getWindowViewController();
    }

    public LifecycleRegistry getLifecycle() {
        return this.lifecycle;
    }

    public final DynamicIslandWindowView getWindowView() {
        return this.windowView;
    }

    public final void onPluginDestroy() {
        DynamicIslandWindowView dynamicIslandWindowView = this.windowView;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("destroy window view ");
        stringBuilder.append((Object)dynamicIslandWindowView);
        stringBuilder.append(" caused by plugin destroyed.");
        Log.w((String)"DynamicIslandWindowViewCreator", (String)stringBuilder.toString());
        dynamicIslandWindowView = this.windowView;
        if (dynamicIslandWindowView != null) {
            dynamicIslandWindowView.destroy();
        }
        this.windowView = null;
    }

    public final void setWindowView(DynamicIslandWindowView dynamicIslandWindowView) {
        this.windowView = dynamicIslandWindowView;
    }
}
