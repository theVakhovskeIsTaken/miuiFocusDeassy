/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.ShareProviderData;

public final class DynamicIslandShareData {
    public static final DynamicIslandShareData INSTANCE = new DynamicIslandShareData();
    private static ShareProviderData shareProviderData = new ShareProviderData();

    private DynamicIslandShareData() {
    }

    public final ShareProviderData getShareProviderData() {
        return shareProviderData;
    }

    public final void setShareProviderData(ShareProviderData shareProviderData) {
        o.g((Object)shareProviderData, (String)"<set-?>");
        DynamicIslandShareData.shareProviderData = shareProviderData;
    }
}
