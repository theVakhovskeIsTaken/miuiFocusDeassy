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
public final class DynamicIslandSummaryExpose
implements DynamicIslandEvent {
    @EventKey(key="app_name")
    private final String appName;
    @EventKey(key="channel_type")
    private final String channelType;
    @EventKey(key="disappear_type")
    private final String disappearType;
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

    public DynamicIslandSummaryExpose(String string, String string2, String string3, String string4, String string5, String string6, String string7, int n, String string8, String string9, String string10, String string11, String string12, String string13, String string14) {
        o.g((Object)string, (String)"appName");
        o.g((Object)string2, (String)"pkg");
        o.g((Object)string3, (String)"targetPkg");
        o.g((Object)string4, (String)"sbnId");
        o.g((Object)string5, (String)"notifTag");
        o.g((Object)string6, (String)"notifType");
        o.g((Object)string7, (String)"scene");
        o.g((Object)string8, (String)"disappearType");
        o.g((Object)string9, (String)"islandForm");
        o.g((Object)string10, (String)"channelType");
        o.g((Object)string11, (String)"extraItem");
        o.g((Object)string12, (String)"tip");
        o.g((Object)string13, (String)"phoneType");
        o.g((Object)string14, (String)"screenType");
        this.appName = string;
        this.pkg = string2;
        this.targetPkg = string3;
        this.sbnId = string4;
        this.notifTag = string5;
        this.notifType = string6;
        this.scene = string7;
        this.duration = n;
        this.disappearType = string8;
        this.islandForm = string9;
        this.channelType = string10;
        this.extraItem = string11;
        this.tip = string12;
        this.phoneType = string13;
        this.screenType = string14;
    }

    public /* synthetic */ DynamicIslandSummaryExpose(String string, String string2, String string3, String string4, String string5, String string6, String string7, int n, String string8, String string9, String string10, String string11, String string12, String string13, String string14, int n2, h h2) {
        if ((n2 & 0x1000) != 0) {
            string12 = "1868.1.1.1.45215";
        }
        this(string, string2, string3, string4, string5, string6, string7, n, string8, string9, string10, string11, string12, string13, string14);
    }

    public static /* synthetic */ DynamicIslandSummaryExpose copy$default(DynamicIslandSummaryExpose dynamicIslandSummaryExpose, String string, String string2, String string3, String string4, String string5, String string6, String string7, int n, String string8, String string9, String string10, String string11, String string12, String string13, String string14, int n2, Object object) {
        block14: {
            if ((n2 & 1) != 0) {
                string = dynamicIslandSummaryExpose.appName;
            }
            if ((n2 & 2) != 0) {
                string2 = dynamicIslandSummaryExpose.pkg;
            }
            if ((n2 & 4) != 0) {
                string3 = dynamicIslandSummaryExpose.targetPkg;
            }
            if ((n2 & 8) != 0) {
                string4 = dynamicIslandSummaryExpose.sbnId;
            }
            if ((n2 & 0x10) != 0) {
                string5 = dynamicIslandSummaryExpose.notifTag;
            }
            if ((n2 & 0x20) != 0) {
                string6 = dynamicIslandSummaryExpose.notifType;
            }
            if ((n2 & 0x40) != 0) {
                string7 = dynamicIslandSummaryExpose.scene;
            }
            if ((n2 & 0x80) != 0) {
                n = dynamicIslandSummaryExpose.duration;
            }
            if ((n2 & 0x100) != 0) {
                string8 = dynamicIslandSummaryExpose.disappearType;
            }
            if ((n2 & 0x200) != 0) {
                string9 = dynamicIslandSummaryExpose.islandForm;
            }
            if ((n2 & 0x400) != 0) {
                string10 = dynamicIslandSummaryExpose.channelType;
            }
            if ((n2 & 0x800) != 0) {
                string11 = dynamicIslandSummaryExpose.extraItem;
            }
            if ((n2 & 0x1000) != 0) {
                string12 = dynamicIslandSummaryExpose.tip;
            }
            if ((n2 & 0x2000) != 0) {
                string13 = dynamicIslandSummaryExpose.phoneType;
            }
            if ((n2 & 0x4000) == 0) break block14;
            string14 = dynamicIslandSummaryExpose.screenType;
        }
        return dynamicIslandSummaryExpose.copy(string, string2, string3, string4, string5, string6, string7, n, string8, string9, string10, string11, string12, string13, string14);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component10() {
        return this.islandForm;
    }

    public final String component11() {
        return this.channelType;
    }

    public final String component12() {
        return this.extraItem;
    }

    public final String component13() {
        return this.tip;
    }

    public final String component14() {
        return this.phoneType;
    }

    public final String component15() {
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
        return this.disappearType;
    }

    public final DynamicIslandSummaryExpose copy(String string, String string2, String string3, String string4, String string5, String string6, String string7, int n, String string8, String string9, String string10, String string11, String string12, String string13, String string14) {
        o.g((Object)string, (String)"appName");
        o.g((Object)string2, (String)"pkg");
        o.g((Object)string3, (String)"targetPkg");
        o.g((Object)string4, (String)"sbnId");
        o.g((Object)string5, (String)"notifTag");
        o.g((Object)string6, (String)"notifType");
        o.g((Object)string7, (String)"scene");
        o.g((Object)string8, (String)"disappearType");
        o.g((Object)string9, (String)"islandForm");
        o.g((Object)string10, (String)"channelType");
        o.g((Object)string11, (String)"extraItem");
        o.g((Object)string12, (String)"tip");
        o.g((Object)string13, (String)"phoneType");
        o.g((Object)string14, (String)"screenType");
        return new DynamicIslandSummaryExpose(string, string2, string3, string4, string5, string6, string7, n, string8, string9, string10, string11, string12, string13, string14);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DynamicIslandSummaryExpose)) {
            return false;
        }
        object = (DynamicIslandSummaryExpose)object;
        if (!o.c((Object)this.appName, (Object)((DynamicIslandSummaryExpose)object).appName)) {
            return false;
        }
        if (!o.c((Object)this.pkg, (Object)((DynamicIslandSummaryExpose)object).pkg)) {
            return false;
        }
        if (!o.c((Object)this.targetPkg, (Object)((DynamicIslandSummaryExpose)object).targetPkg)) {
            return false;
        }
        if (!o.c((Object)this.sbnId, (Object)((DynamicIslandSummaryExpose)object).sbnId)) {
            return false;
        }
        if (!o.c((Object)this.notifTag, (Object)((DynamicIslandSummaryExpose)object).notifTag)) {
            return false;
        }
        if (!o.c((Object)this.notifType, (Object)((DynamicIslandSummaryExpose)object).notifType)) {
            return false;
        }
        if (!o.c((Object)this.scene, (Object)((DynamicIslandSummaryExpose)object).scene)) {
            return false;
        }
        if (this.duration != ((DynamicIslandSummaryExpose)object).duration) {
            return false;
        }
        if (!o.c((Object)this.disappearType, (Object)((DynamicIslandSummaryExpose)object).disappearType)) {
            return false;
        }
        if (!o.c((Object)this.islandForm, (Object)((DynamicIslandSummaryExpose)object).islandForm)) {
            return false;
        }
        if (!o.c((Object)this.channelType, (Object)((DynamicIslandSummaryExpose)object).channelType)) {
            return false;
        }
        if (!o.c((Object)this.extraItem, (Object)((DynamicIslandSummaryExpose)object).extraItem)) {
            return false;
        }
        if (!o.c((Object)this.tip, (Object)((DynamicIslandSummaryExpose)object).tip)) {
            return false;
        }
        if (!o.c((Object)this.phoneType, (Object)((DynamicIslandSummaryExpose)object).phoneType)) {
            return false;
        }
        return o.c((Object)this.screenType, (Object)((DynamicIslandSummaryExpose)object).screenType);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final String getDisappearType() {
        return this.disappearType;
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
        return (((((((((((((this.appName.hashCode() * 31 + this.pkg.hashCode()) * 31 + this.targetPkg.hashCode()) * 31 + this.sbnId.hashCode()) * 31 + this.notifTag.hashCode()) * 31 + this.notifType.hashCode()) * 31 + this.scene.hashCode()) * 31 + Integer.hashCode(this.duration)) * 31 + this.disappearType.hashCode()) * 31 + this.islandForm.hashCode()) * 31 + this.channelType.hashCode()) * 31 + this.extraItem.hashCode()) * 31 + this.tip.hashCode()) * 31 + this.phoneType.hashCode()) * 31 + this.screenType.hashCode();
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
        String string8 = this.disappearType;
        String string9 = this.islandForm;
        String string10 = this.channelType;
        String string11 = this.extraItem;
        String string12 = this.tip;
        String string13 = this.phoneType;
        String string14 = this.screenType;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DynamicIslandSummaryExpose(appName=");
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
        stringBuilder.append(", disappearType=");
        stringBuilder.append(string8);
        stringBuilder.append(", islandForm=");
        stringBuilder.append(string9);
        stringBuilder.append(", channelType=");
        stringBuilder.append(string10);
        stringBuilder.append(", extraItem=");
        stringBuilder.append(string11);
        stringBuilder.append(", tip=");
        stringBuilder.append(string12);
        stringBuilder.append(", phoneType=");
        stringBuilder.append(string13);
        stringBuilder.append(", screenType=");
        stringBuilder.append(string14);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
