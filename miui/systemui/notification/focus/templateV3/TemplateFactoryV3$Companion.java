/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Icon
 *  android.os.Bundle
 *  android.service.notification.StatusBarNotification
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.templateV3;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.FocusIconCache;
import miui.systemui.notification.focus.model.BgInfo;
import miui.systemui.notification.focus.model.Template;

public static final class TemplateFactoryV3.Companion {
    private TemplateFactoryV3.Companion() {
    }

    public /* synthetic */ TemplateFactoryV3.Companion(h h2) {
        this();
    }

    public final boolean isBgPicDownloadFailStatic(Template object, StatusBarNotification object2) {
        boolean bl;
        block10: {
            block9: {
                Object var7_5;
                BgInfo bgInfo;
                Bundle bundle;
                block8: {
                    String string;
                    block7: {
                        o.g((Object)object, (String)"template");
                        o.g((Object)object2, (String)"sbn");
                        bundle = object2.getNotification().extras.getBundle("miui.focus.pics");
                        bgInfo = ((Template)object).getBgInfo();
                        var7_5 = null;
                        string = bgInfo != null ? bgInfo.getPicBg() : null;
                        if (bundle == null) break block7;
                        Icon icon = (Icon)bundle.getParcelable(string);
                        bgInfo = icon;
                        if (icon != null) break block8;
                    }
                    bgInfo = (object2 = object2.getKey()) != null ? FocusIconCache.INSTANCE.get((String)object2, string) : null;
                }
                if (bundle == null) break block9;
                object2 = ((Template)object).getBgInfo();
                object = var7_5;
                if (object2 != null) {
                    object = ((BgInfo)object2).getPicBg();
                }
                boolean bl2 = bundle.containsKey((String)object);
                bl = true;
                if (bl2 && bgInfo == null) break block10;
            }
            bl = false;
        }
        return bl;
    }
}
