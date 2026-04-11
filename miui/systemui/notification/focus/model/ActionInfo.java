/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.g
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.model;

import G0.g;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ProgressInfo;

public final class ActionInfo {
    private final String action;
    private final String actionBgColor;
    private final String actionBgColorDark;
    private final String actionBgPressColor;
    private final String actionBgPressColorDark;
    private final String actionIcon;
    private final String actionIconDark;
    private final String actionIntent;
    private final Integer actionIntentType;
    private final String actionTitle;
    private final String actionTitleColor;
    private final String actionTitleColorDark;
    private final boolean clickWithCollapse;
    private final ProgressInfo progressInfo;
    private final Integer type;

    public ActionInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, Short.MAX_VALUE, null);
    }

    public ActionInfo(String string, Integer n, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, Integer n2, String string11, boolean bl, ProgressInfo progressInfo) {
        this.action = string;
        this.type = n;
        this.actionIcon = string2;
        this.actionIconDark = string3;
        this.actionTitle = string4;
        this.actionTitleColor = string5;
        this.actionTitleColorDark = string6;
        this.actionBgColor = string7;
        this.actionBgColorDark = string8;
        this.actionBgPressColor = string9;
        this.actionBgPressColorDark = string10;
        this.actionIntentType = n2;
        this.actionIntent = string11;
        this.clickWithCollapse = bl;
        this.progressInfo = progressInfo;
    }

    public /* synthetic */ ActionInfo(String string, Integer n, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, Integer n2, String string11, boolean bl, ProgressInfo progressInfo, int n3, h h2) {
        h2 = null;
        if ((n3 & 1) != 0) {
            string = null;
        }
        if ((n3 & 2) != 0) {
            n = null;
        }
        if ((n3 & 4) != 0) {
            string2 = null;
        }
        if ((n3 & 8) != 0) {
            string3 = null;
        }
        if ((n3 & 0x10) != 0) {
            string4 = null;
        }
        if ((n3 & 0x20) != 0) {
            string5 = null;
        }
        if ((n3 & 0x40) != 0) {
            string6 = null;
        }
        if ((n3 & 0x80) != 0) {
            string7 = null;
        }
        if ((n3 & 0x100) != 0) {
            string8 = null;
        }
        if ((n3 & 0x200) != 0) {
            string9 = null;
        }
        if ((n3 & 0x400) != 0) {
            string10 = null;
        }
        if ((n3 & 0x800) != 0) {
            n2 = null;
        }
        if ((n3 & 0x1000) != 0) {
            string11 = null;
        }
        if ((n3 & 0x2000) != 0) {
            bl = false;
        }
        if ((n3 & 0x4000) != 0) {
            progressInfo = h2;
        }
        this(string, n, string2, string3, string4, string5, string6, string7, string8, string9, string10, n2, string11, bl, progressInfo);
    }

    public static /* synthetic */ ActionInfo copy$default(ActionInfo actionInfo, String string, Integer n, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, Integer n2, String string11, boolean bl, ProgressInfo progressInfo, int n3, Object object) {
        block14: {
            if ((n3 & 1) != 0) {
                string = actionInfo.action;
            }
            if ((n3 & 2) != 0) {
                n = actionInfo.type;
            }
            if ((n3 & 4) != 0) {
                string2 = actionInfo.actionIcon;
            }
            if ((n3 & 8) != 0) {
                string3 = actionInfo.actionIconDark;
            }
            if ((n3 & 0x10) != 0) {
                string4 = actionInfo.actionTitle;
            }
            if ((n3 & 0x20) != 0) {
                string5 = actionInfo.actionTitleColor;
            }
            if ((n3 & 0x40) != 0) {
                string6 = actionInfo.actionTitleColorDark;
            }
            if ((n3 & 0x80) != 0) {
                string7 = actionInfo.actionBgColor;
            }
            if ((n3 & 0x100) != 0) {
                string8 = actionInfo.actionBgColorDark;
            }
            if ((n3 & 0x200) != 0) {
                string9 = actionInfo.actionBgPressColor;
            }
            if ((n3 & 0x400) != 0) {
                string10 = actionInfo.actionBgPressColorDark;
            }
            if ((n3 & 0x800) != 0) {
                n2 = actionInfo.actionIntentType;
            }
            if ((n3 & 0x1000) != 0) {
                string11 = actionInfo.actionIntent;
            }
            if ((n3 & 0x2000) != 0) {
                bl = actionInfo.clickWithCollapse;
            }
            if ((n3 & 0x4000) == 0) break block14;
            progressInfo = actionInfo.progressInfo;
        }
        return actionInfo.copy(string, n, string2, string3, string4, string5, string6, string7, string8, string9, string10, n2, string11, bl, progressInfo);
    }

    public final String component1() {
        return this.action;
    }

    public final String component10() {
        return this.actionBgPressColor;
    }

    public final String component11() {
        return this.actionBgPressColorDark;
    }

    public final Integer component12() {
        return this.actionIntentType;
    }

    public final String component13() {
        return this.actionIntent;
    }

    public final boolean component14() {
        return this.clickWithCollapse;
    }

    public final ProgressInfo component15() {
        return this.progressInfo;
    }

    public final Integer component2() {
        return this.type;
    }

    public final String component3() {
        return this.actionIcon;
    }

    public final String component4() {
        return this.actionIconDark;
    }

    public final String component5() {
        return this.actionTitle;
    }

    public final String component6() {
        return this.actionTitleColor;
    }

    public final String component7() {
        return this.actionTitleColorDark;
    }

    public final String component8() {
        return this.actionBgColor;
    }

    public final String component9() {
        return this.actionBgColorDark;
    }

    public final ActionInfo copy(String string, Integer n, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, Integer n2, String string11, boolean bl, ProgressInfo progressInfo) {
        return new ActionInfo(string, n, string2, string3, string4, string5, string6, string7, string8, string9, string10, n2, string11, bl, progressInfo);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ActionInfo)) {
            return false;
        }
        object = (ActionInfo)object;
        if (!o.c((Object)this.action, (Object)((ActionInfo)object).action)) {
            return false;
        }
        if (!o.c((Object)this.type, (Object)((ActionInfo)object).type)) {
            return false;
        }
        if (!o.c((Object)this.actionIcon, (Object)((ActionInfo)object).actionIcon)) {
            return false;
        }
        if (!o.c((Object)this.actionIconDark, (Object)((ActionInfo)object).actionIconDark)) {
            return false;
        }
        if (!o.c((Object)this.actionTitle, (Object)((ActionInfo)object).actionTitle)) {
            return false;
        }
        if (!o.c((Object)this.actionTitleColor, (Object)((ActionInfo)object).actionTitleColor)) {
            return false;
        }
        if (!o.c((Object)this.actionTitleColorDark, (Object)((ActionInfo)object).actionTitleColorDark)) {
            return false;
        }
        if (!o.c((Object)this.actionBgColor, (Object)((ActionInfo)object).actionBgColor)) {
            return false;
        }
        if (!o.c((Object)this.actionBgColorDark, (Object)((ActionInfo)object).actionBgColorDark)) {
            return false;
        }
        if (!o.c((Object)this.actionBgPressColor, (Object)((ActionInfo)object).actionBgPressColor)) {
            return false;
        }
        if (!o.c((Object)this.actionBgPressColorDark, (Object)((ActionInfo)object).actionBgPressColorDark)) {
            return false;
        }
        if (!o.c((Object)this.actionIntentType, (Object)((ActionInfo)object).actionIntentType)) {
            return false;
        }
        if (!o.c((Object)this.actionIntent, (Object)((ActionInfo)object).actionIntent)) {
            return false;
        }
        if (this.clickWithCollapse != ((ActionInfo)object).clickWithCollapse) {
            return false;
        }
        return o.c((Object)this.progressInfo, (Object)((ActionInfo)object).progressInfo);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getActionBgColor() {
        return this.actionBgColor;
    }

    public final String getActionBgColor(boolean bl) {
        block4: {
            String string;
            block3: {
                block2: {
                    if (!bl) break block2;
                    string = this.actionBgColorDark;
                    break block3;
                }
                if (bl) break block4;
                string = this.actionBgColor;
            }
            return string;
        }
        throw new g();
    }

    public final String getActionBgColorDark() {
        return this.actionBgColorDark;
    }

    public final String getActionBgPressColor() {
        return this.actionBgPressColor;
    }

    public final String getActionBgPressColor(boolean bl) {
        block4: {
            String string;
            block3: {
                block2: {
                    if (!bl) break block2;
                    string = this.actionBgPressColorDark;
                    break block3;
                }
                if (bl) break block4;
                string = this.actionBgPressColor;
            }
            return string;
        }
        throw new g();
    }

    public final String getActionBgPressColorDark() {
        return this.actionBgPressColorDark;
    }

    public final String getActionIcon() {
        return this.actionIcon;
    }

    public final String getActionIcon(boolean bl) {
        block4: {
            String string;
            block3: {
                block2: {
                    if (!bl) break block2;
                    string = this.actionIconDark;
                    break block3;
                }
                if (bl) break block4;
                string = this.actionIcon;
            }
            return string;
        }
        throw new g();
    }

    public final String getActionIconDark() {
        return this.actionIconDark;
    }

    public final String getActionIntent() {
        return this.actionIntent;
    }

    public final Integer getActionIntentType() {
        return this.actionIntentType;
    }

    public final String getActionTitle() {
        return this.actionTitle;
    }

    public final String getActionTitleColor() {
        return this.actionTitleColor;
    }

    public final String getActionTitleColor(boolean bl) {
        block4: {
            String string;
            block3: {
                block2: {
                    if (!bl) break block2;
                    string = this.actionTitleColorDark;
                    break block3;
                }
                if (bl) break block4;
                string = this.actionTitleColor;
            }
            return string;
        }
        throw new g();
    }

    public final String getActionTitleColorDark() {
        return this.actionTitleColorDark;
    }

    public final boolean getClickWithCollapse() {
        return this.clickWithCollapse;
    }

    public final ProgressInfo getProgressInfo() {
        return this.progressInfo;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Object object = this.action;
        int n = 0;
        int n2 = object == null ? 0 : ((String)object).hashCode();
        object = this.type;
        int n3 = object == null ? 0 : object.hashCode();
        object = this.actionIcon;
        int n4 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionIconDark;
        int n5 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionTitle;
        int n6 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionTitleColor;
        int n7 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionTitleColorDark;
        int n8 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionBgColor;
        int n9 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionBgColorDark;
        int n10 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionBgPressColor;
        int n11 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionBgPressColorDark;
        int n12 = object == null ? 0 : ((String)object).hashCode();
        object = this.actionIntentType;
        int n13 = object == null ? 0 : object.hashCode();
        object = this.actionIntent;
        int n14 = object == null ? 0 : ((String)object).hashCode();
        int n15 = Boolean.hashCode(this.clickWithCollapse);
        object = this.progressInfo;
        if (object != null) {
            n = ((ProgressInfo)object).hashCode();
        }
        return (((((((((((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n12) * 31 + n13) * 31 + n14) * 31 + n15) * 31 + n;
    }

    public String toString() {
        String string = this.action;
        Integer n = this.type;
        String string2 = this.actionIcon;
        String string3 = this.actionIconDark;
        String string4 = this.actionTitle;
        String string5 = this.actionTitleColor;
        String string6 = this.actionTitleColorDark;
        String string7 = this.actionBgColor;
        String string8 = this.actionBgColorDark;
        String string9 = this.actionBgPressColor;
        String string10 = this.actionBgPressColorDark;
        Integer n2 = this.actionIntentType;
        String string11 = this.actionIntent;
        boolean bl = this.clickWithCollapse;
        ProgressInfo progressInfo = this.progressInfo;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionInfo(action=");
        stringBuilder.append(string);
        stringBuilder.append(", type=");
        stringBuilder.append(n);
        stringBuilder.append(", actionIcon=");
        stringBuilder.append(string2);
        stringBuilder.append(", actionIconDark=");
        stringBuilder.append(string3);
        stringBuilder.append(", actionTitle=");
        stringBuilder.append(string4);
        stringBuilder.append(", actionTitleColor=");
        stringBuilder.append(string5);
        stringBuilder.append(", actionTitleColorDark=");
        stringBuilder.append(string6);
        stringBuilder.append(", actionBgColor=");
        stringBuilder.append(string7);
        stringBuilder.append(", actionBgColorDark=");
        stringBuilder.append(string8);
        stringBuilder.append(", actionBgPressColor=");
        stringBuilder.append(string9);
        stringBuilder.append(", actionBgPressColorDark=");
        stringBuilder.append(string10);
        stringBuilder.append(", actionIntentType=");
        stringBuilder.append(n2);
        stringBuilder.append(", actionIntent=");
        stringBuilder.append(string11);
        stringBuilder.append(", clickWithCollapse=");
        stringBuilder.append(bl);
        stringBuilder.append(", progressInfo=");
        stringBuilder.append(progressInfo);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
