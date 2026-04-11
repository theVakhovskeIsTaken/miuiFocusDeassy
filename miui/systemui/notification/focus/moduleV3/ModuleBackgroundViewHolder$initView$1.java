/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.graphics.drawable.Icon
 *  android.service.notification.StatusBarNotification
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus.moduleV3;

import U0.a;
import android.graphics.drawable.Icon;
import android.service.notification.StatusBarNotification;
import kotlin.jvm.internal.p;
import miui.systemui.notification.focus.model.BgInfo;
import miui.systemui.notification.focus.moduleV3.ModuleBackgroundViewHolder;

public static final class ModuleBackgroundViewHolder.initView.1
extends p
implements a {
    final ModuleBackgroundViewHolder this$0;

    public ModuleBackgroundViewHolder.initView.1(ModuleBackgroundViewHolder moduleBackgroundViewHolder) {
        this.this$0 = moduleBackgroundViewHolder;
        super(0);
    }

    public final void invoke() {
        Object object = this.this$0.bgInfo;
        if (object != null && ((BgInfo)object).getType() == 2) {
            StatusBarNotification statusBarNotification = this.this$0.getSbn();
            object = null;
            StatusBarNotification statusBarNotification2 = null;
            if (statusBarNotification != null) {
                ModuleBackgroundViewHolder moduleBackgroundViewHolder = this.this$0;
                BgInfo bgInfo = moduleBackgroundViewHolder.bgInfo;
                object = statusBarNotification2;
                if (bgInfo != null) {
                    object = bgInfo.getPicBg();
                }
                object = moduleBackgroundViewHolder.getIcon((String)object, statusBarNotification);
            }
            if ((statusBarNotification2 = this.this$0.getSbn()) != null) {
                this.this$0.createPartBg((Icon)object, statusBarNotification2);
            }
        }
    }
}
