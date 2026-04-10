/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 *  systemui.plugin.eventtracking.EventID
 *  systemui.plugin.eventtracking.EventKey
 *  systemui.plugin.eventtracking.events.DynamicIslandEvent
 */
package miui.systemui.dynamicisland.events;

import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import systemui.plugin.eventtracking.EventID;
import systemui.plugin.eventtracking.EventKey;
import systemui.plugin.eventtracking.events.DynamicIslandEvent;

@EventID(id="expose")
public final class DynamicIslandExpandedExpose
implements DynamicIslandEvent {
    @EventKey(key="app_name")
    private final String appName;
    @EventKey(key="channel_type")
    private final String channelType;
    @EventKey(key="expose_duration")
    private final int duration;
    @EventKey(key="item")
    private final String extraItem;
    @EventKey(key="island_form")
    private final String islandForm;
    @EventKey(key="notification_tag")
    private final String notifTag;
    @EventKey(key="notification_type")
    private final String notifType;
    @EventKey(key="phone_type")
    private final String phoneType;
    @EventKey(key="send_pkg")
    private final String pkg;
    @EventKey(key="sbn_id")
    private final String sbnId;
    @EventKey(key="service_scene")
    private final String scene;
    @EventKey(key="screen_type")
    private final String screenType;
    @EventKey(key="target_pkg")
    private final String targetPkg;
    @EventKey(key="tip")
    private final String tip;

    public DynamicIslandExpandedExpose(String string, String string2, String string3, String string4, String string5, String string6, String string7, int n, String string8, String string9, String string10, String string11, String string12, String string13) {
        o.g((Object)string, (String)"appName");
        o.g((Object)string2, (String)"pkg");
        o.g((Object)string3, (String)"targetPkg");
        o.g((Object)string4, (String)"sbnId");
        o.g((Object)string5, (String)"notifTag");
        o.g((Object)string6, (String)"notifType");
        o.g((Object)string7, (String)"scene");
        o.g((Object)string8, (String)"islandForm");
        o.g((Object)string9, (String)"channelType");
        o.g((Object)string10, (String)"extraItem");
        o.g((Object)string11, (String)"tip");
        o.g((Object)string12, (String)"phoneType");
        o.g((Object)string13, (String)"screenType");
        this.appName = string;
        this.pkg = string2;
        this.targetPkg = string3;
        this.sbnId = string4;
        this.notifTag = string5;
        this.notifType = string6;
        this.scene = string7;
        this.duration = n;
        this.islandForm = string8;
        this.channelType = string9;
        this.extraItem = string10;
        this.tip = string11;
        this.phoneType = string12;
        this.screenType = string13;
    }

    public /* synthetic */ DynamicIslandExpandedExpose(String string, String string2, String string3, String string4, String string5, String string6, String string7, int n, String string8, String string9, String string10, String string11, String string12, String string13, int n2, h h2) {
        if ((n2 & 0x800) != 0) {
            string11 = "1868.1.2.1.45219";
        }
        this(string, string2, string3, string4, string5, string6, string7, n, string8, string9, string10, string11, string12, string13);
    }

    public static /* synthetic */ DynamicIslandExpandedExpose copy$default(DynamicIslandExpandedExpose dynamicIslandExpandedExpose, String string, String string2, String string3, String string4, String string5, String string6, String string7, int n, String string8, String string9, String string10, String string11, String string12, String string13, int n2, Object object) {
        block13: {
            if ((n2 & 1) != 0) {
                string = dynamicIslandExpandedExpose.appName;
            }
            if ((n2 & 2) != 0) {
                string2 = dynamicIslandExpandedExpose.pkg;
            }
            if ((n2 & 4) != 0) {
                string3 = dynamicIslandExpandedExpose.targetPkg;
            }
            if ((n2 & 8) != 0) {
                string4 = dynamicIslandExpandedExpose.sbnId;
            }
            if ((n2 & 0x10) != 0) {
                string5 = dynamicIslandExpandedExpose.notifTag;
            }
            if ((n2 & 0x20) != 0) {
                string6 = dynamicIslandExpandedExpose.notifType;
            }
            if ((n2 & 0x40) != 0) {
                string7 = dynamicIslandExpandedExpose.scene;
            }
            if ((n2 & 0x80) != 0) {
                n = dynamicIslandExpandedExpose.duration;
            }
            if ((n2 & 0x100) != 0) {
                string8 = dynamicIslandExpandedExpose.islandForm;
            }
            if ((n2 & 0x200) != 0) {
                string9 = dynamicIslandExpandedExpose.channelType;
            }
            if ((n2 & 0x400) != 0) {
                string10 = dynamicIslandExpandedExpose.extraItem;
            }
            if ((n2 & 0x800) != 0) {
                string11 = dynamicIslandExpandedExpose.tip;
            }
            if ((n2 & 0x1000) != 0) {
                string12 = dynamicIslandExpandedExpose.phoneType;
            }
            if ((n2 & 0x2000) == 0) break block13;
            string13 = dynamicIslandExpandedExpose.screenType;
        }
        return dynamicIslandExpandedExpose.copy(string, string2, string3, string4, string5, string6, string7, n, string8, string9, string10, string11, string12, string13);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component10() {
        return this.channelType;
    }

    public final String component11() {
        return this.extraItem;
    }

    public final String component12() {
        return this.tip;
    }

    public final String component13() {
        return this.phoneType;
    }

    public final String component14() {
        return this.screenType;
    }

    public final String component2() {
        return this.pkg;
    }

    public final String component3() {
        return this.targetPkg;
    }

    public final String component4() {
        return this.sbnId;
    }

    public final String component5() {
        return this.notifTag;
    }

    public final String component6() {
        return this.notifType;
    }

    public final String component7() {
        return this.scene;
    }

    public final int component8() {
        return this.duration;
    }

    public final String component9() {
        return this.islandForm;
    }

    public final DynamicIslandExpandedExpose copy(String string, String string2, String string3, String string4, String string5, String string6, String string7, int n, String string8, String string9, String string10, String string11, String string12, String string13) {
        o.g((Object)string, (String)"appName");
        o.g((Object)string2, (String)"pkg");
        o.g((Object)string3, (String)"targetPkg");
        o.g((Object)string4, (String)"sbnId");
        o.g((Object)string5, (String)"notifTag");
        o.g((Object)string6, (String)"notifType");
        o.g((Object)string7, (String)"scene");
        o.g((Object)string8, (String)"islandForm");
        o.g((Object)string9, (String)"channelType");
        o.g((Object)string10, (String)"extraItem");
        o.g((Object)string11, (String)"tip");
        o.g((Object)string12, (String)"phoneType");
        o.g((Object)string13, (String)"screenType");
        return new DynamicIslandExpandedExpose(string, string2, string3, string4, string5, string6, string7, n, string8, string9, string10, string11, string12, string13);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DynamicIslandExpandedExpose)) {
            return false;
        }
        object = (DynamicIslandExpandedExpose)object;
        if (!o.c((Object)this.appName, (Object)((DynamicIslandExpandedExpose)object).appName)) {
            return false;
        }
        if (!o.c((Object)this.pkg, (Object)((DynamicIslandExpandedExpose)object).pkg)) {
            return false;
        }
        if (!o.c((Object)this.targetPkg, (Object)((DynamicIslandExpandedExpose)object).targetPkg)) {
            return false;
        }
        if (!o.c((Object)this.sbnId, (Object)((DynamicIslandExpandedExpose)object).sbnId)) {
            return false;
        }
        if (!o.c((Object)this.notifTag, (Object)((DynamicIslandExpandedExpose)object).notifTag)) {
            return false;
        }
        if (!o.c((Object)this.notifType, (Object)((DynamicIslandExpandedExpose)object).notifType)) {
            return false;
        }
        if (!o.c((Object)this.scene, (Object)((DynamicIslandExpandedExpose)object).scene)) {
            return false;
        }
        if (this.duration != ((DynamicIslandExpandedExpose)object).duration) {
            return false;
        }
        if (!o.c((Object)this.islandForm, (Object)((DynamicIslandExpandedExpose)object).islandForm)) {
            return false;
        }
        if (!o.c((Object)this.channelType, (Object)((DynamicIslandExpandedExpose)object).channelType)) {
            return false;
        }
        if (!o.c((Object)this.extraItem, (Object)((DynamicIslandExpandedExpose)object).extraItem)) {
            return false;
        }
        if (!o.c((Object)this.tip, (Object)((DynamicIslandExpandedExpose)object).tip)) {
            return false;
        }
        if (!o.c((Object)this.phoneType, (Object)((DynamicIslandExpandedExpose)object).phoneType)) {
            return false;
        }
        return o.c((Object)this.screenType, (Object)((DynamicIslandExpandedExpose)object).screenType);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getExtraItem() {
        return this.extraItem;
    }

    public final String getIslandForm() {
        return this.islandForm;
    }

    public final String getNotifTag() {
        return this.notifTag;
    }

    public final String getNotifType() {
        return this.notifType;
    }

    public final String getPhoneType() {
        return this.phoneType;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final String getSbnId() {
        return this.sbnId;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getScreenType() {
        return this.screenType;
    }

    public final String getTargetPkg() {
        return this.targetPkg;
    }

    public final String getTip() {
        return this.tip;
    }

    public int hashCode() {
        return ((((((((((((this.appName.hashCode() * 31 + this.pkg.hashCode()) * 31 + this.targetPkg.hashCode()) * 31 + this.sbnId.hashCode()) * 31 + this.notifTag.hashCode()) * 31 + this.notifType.hashCode()) * 31 + this.scene.hashCode()) * 31 + Integer.hashCode(this.duration)) * 31 + this.islandForm.hashCode()) * 31 + this.channelType.hashCode()) * 31 + this.extraItem.hashCode()) * 31 + this.tip.hashCode()) * 31 + this.phoneType.hashCode()) * 31 + this.screenType.hashCode();
    }

    public String toString() {
        String string = this.appName;
        String string2 = this.pkg;
        String string3 = this.targetPkg;
        String string4 = this.sbnId;
        String string5 = this.notifTag;
        String string6 = this.notifType;
        String string7 = this.scene;
        int n = this.duration;
        String string8 = this.islandForm;
        String string9 = this.channelType;
        String string10 = this.extraItem;
        String string11 = this.tip;
        String string12 = this.phoneType;
        String string13 = this.screenType;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DynamicIslandExpandedExpose(appName=");
        stringBuilder.append(string);
        stringBuilder.append(", pkg=");
        stringBuilder.append(string2);
        stringBuilder.append(", targetPkg=");
        stringBuilder.append(string3);
        stringBuilder.append(", sbnId=");
        stringBuilder.append(string4);
        stringBuilder.append(", notifTag=");
        stringBuilder.append(string5);
        stringBuilder.append(", notifType=");
        stringBuilder.append(string6);
        stringBuilder.append(", scene=");
        stringBuilder.append(string7);
        stringBuilder.append(", duration=");
        stringBuilder.append(n);
        stringBuilder.append(", islandForm=");
        stringBuilder.append(string8);
        stringBuilder.append(", channelType=");
        stringBuilder.append(string9);
        stringBuilder.append(", extraItem=");
        stringBuilder.append(string10);
        stringBuilder.append(", tip=");
        stringBuilder.append(string11);
        stringBuilder.append(", phoneType=");
        stringBuilder.append(string12);
        stringBuilder.append(", screenType=");
        stringBuilder.append(string13);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
