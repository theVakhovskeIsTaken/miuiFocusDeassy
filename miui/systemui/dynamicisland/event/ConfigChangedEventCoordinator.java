/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.FoldUtils
 */
package miui.systemui.dynamicisland.event;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.FoldUtils;

@DynamicIslandScope
public final class ConfigChangedEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "ConfigChangedEventCoordinator";
    private boolean currentFoldScreenLayoutLarge;
    private boolean isFirst;
    private boolean lastFoldScreenLayoutLarge;

    public ConfigChangedEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
        this.isFirst = true;
    }

    private final void updateHidden(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> object22) {
        if (object != null) {
            StateHandler.addState$default(this.getHiddenStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
        }
        if (object22 != null) {
            object = object22.iterator();
            while (object.hasNext()) {
                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)object.next());
                StateHandler.addState$default(this.getHiddenStateHandler(), dynamicIslandContentView, null, 2, null);
            }
        }
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> arrayList) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.ConfigChanged) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("event: ");
            ((StringBuilder)object2).append(object);
            Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            DynamicIslandContentView dynamicIslandContentView = this.getExpandedStateHandler().getCurrent();
            DynamicIslandContentView dynamicIslandContentView2 = this.getBigIslandStateHandler().getCurrent();
            DynamicIslandContentView dynamicIslandContentView3 = this.getShowOnceIslandHandler().getCurrent();
            DynamicIslandContentView dynamicIslandContentView4 = this.getSmallIslandStateHandler().getCurrent();
            DynamicIslandContentView dynamicIslandContentView5 = this.getHiddenStateHandler().getCurrent();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("ConfigChangedEventCoordinator handleEvent: expandedState=");
            ((StringBuilder)object2).append((Object)dynamicIslandContentView);
            ((StringBuilder)object2).append(" bigState=");
            ((StringBuilder)object2).append((Object)dynamicIslandContentView2);
            ((StringBuilder)object2).append(" smallState=");
            ((StringBuilder)object2).append((Object)dynamicIslandContentView4);
            ((StringBuilder)object2).append(" showOnceState=");
            ((StringBuilder)object2).append((Object)dynamicIslandContentView3);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            boolean bl = this.isFirst;
            boolean bl2 = false;
            if (bl) {
                FoldUtils foldUtils = FoldUtils.INSTANCE;
                object2 = this.getStateHandler().getCurrent();
                object2 = object2 != null ? object2.getContext() : null;
                this.lastFoldScreenLayoutLarge = foldUtils.isFoldScreenLayoutLarge((Context)object2);
                this.isFirst = false;
            }
            if (((DynamicIslandWindowState)(object2 = this.getWindowState())).isTinyScreen() != ((DynamicIslandWindowState)object2).getLastTinyScreenStatus()) {
                if (((DynamicIslandWindowState)object2).isTinyScreen()) {
                    bl2 = true;
                }
                this.setTempHide(bl2, (DynamicIslandEvent)object, arrayList);
                bl2 = ((DynamicIslandWindowState)object2).isTinyScreen();
                object = new StringBuilder();
                ((StringBuilder)object).append("handle tiny changed : isTiny= ");
                ((StringBuilder)object).append(bl2);
                ((StringBuilder)object).append(" hiddenList: ");
                ((StringBuilder)object).append(arrayList);
                Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
                this.getStateHandler().stop();
                return;
            }
            if (dynamicIslandContentView != null) {
                this.getExpandedStateHandler().setCurrent(null);
                dynamicIslandContentView.setAlpha(0.0f);
                EventCoordinator.collapse$default(this, dynamicIslandContentView, arrayList, false, 4, null);
                this.updateHidden(dynamicIslandContentView5, arrayList);
                if (dynamicIslandContentView2 != null) {
                    dynamicIslandContentView2.setAlpha(0.0f);
                }
            } else {
                if (dynamicIslandContentView2 != null) {
                    dynamicIslandContentView2.setAlpha(0.0f);
                    StateHandler.addState$default(this.getBigIslandStateHandler(), dynamicIslandContentView2, null, 2, null);
                }
                if (dynamicIslandContentView4 != null) {
                    dynamicIslandContentView4.setAlpha(0.0f);
                    StateHandler.addState$default(this.getSmallIslandStateHandler(), dynamicIslandContentView4, null, 2, null);
                }
                if (dynamicIslandContentView3 != null) {
                    dynamicIslandContentView3.setAlpha(0.0f);
                    StateHandler.addState$default(this.getShowOnceIslandHandler(), dynamicIslandContentView3, null, 2, null);
                }
                this.updateHidden(dynamicIslandContentView5, arrayList);
            }
            this.getStateHandler().stop();
        }
    }
}
