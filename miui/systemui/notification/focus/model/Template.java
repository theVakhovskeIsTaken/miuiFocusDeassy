/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.model;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.AnimTextInfo;
import miui.systemui.notification.focus.model.BaseInfo;
import miui.systemui.notification.focus.model.BgInfo;
import miui.systemui.notification.focus.model.ChatInfo;
import miui.systemui.notification.focus.model.CoverInfo;
import miui.systemui.notification.focus.model.HighlightInfo;
import miui.systemui.notification.focus.model.HighlightInfoV3;
import miui.systemui.notification.focus.model.HintInfo;
import miui.systemui.notification.focus.model.IconTextInfo;
import miui.systemui.notification.focus.model.MultiProgressInfo;
import miui.systemui.notification.focus.model.PicInfo;
import miui.systemui.notification.focus.model.ProgressInfo;

public final class Template {
    private final List<ActionInfo> actions;
    private final AnimTextInfo animTextInfo;
    private final String aodPic;
    private final String aodTitle;
    private final BaseInfo baseInfo;
    private final BgInfo bgInfo;
    private String business;
    private boolean cancel;
    private final ChatInfo chatInfo;
    private final CoverInfo coverInfo;
    private final boolean enableFloat;
    private boolean hideDeco;
    private final HighlightInfo highlightInfo;
    private final HighlightInfoV3 highlightInfoV3;
    private final HintInfo hintInfo;
    private final IconTextInfo iconTextInfo;
    private Boolean isShowNotification;
    private Boolean islandFirstFloat;
    private final MultiProgressInfo multiProgressInfo;
    private String notifyId;
    private String orderId;
    private String outEffectColor;
    private String outEffectSrc;
    private final PicInfo picInfo;
    private ProgressInfo progressInfo;
    private String reopen;
    private long sequence;
    private final boolean showSmallIcon;
    private List<ActionInfo> textButton;
    private final String ticker;
    private final String tickerPic;
    private final String tickerPicDark;
    private final int timeout;
    private final boolean updatable;

    public Template(boolean bl, boolean bl2, String string, String string2, String string3, String string4, String string5, String string6, int n, boolean bl3, BaseInfo baseInfo, ChatInfo chatInfo, PicInfo picInfo, HighlightInfo highlightInfo, HighlightInfoV3 highlightInfoV3, ProgressInfo progressInfo, HintInfo hintInfo, List<ActionInfo> list, BgInfo bgInfo, AnimTextInfo animTextInfo, CoverInfo coverInfo, IconTextInfo iconTextInfo, MultiProgressInfo multiProgressInfo, List<ActionInfo> list2, Boolean bl4, String string7, String string8, Boolean bl5, boolean bl6, boolean bl7, String string9, String string10, String string11, long l) {
        o.g((Object)string2, (String)"aodTitle");
        o.g((Object)string3, (String)"aodPic");
        o.g((Object)string4, (String)"ticker");
        o.g((Object)string5, (String)"tickerPic");
        o.g((Object)string6, (String)"tickerPicDark");
        o.g((Object)string7, (String)"notifyId");
        o.g((Object)string8, (String)"business");
        o.g((Object)string9, (String)"outEffectSrc");
        o.g((Object)string10, (String)"outEffectColor");
        o.g((Object)string11, (String)"orderId");
        this.enableFloat = bl;
        this.updatable = bl2;
        this.reopen = string;
        this.aodTitle = string2;
        this.aodPic = string3;
        this.ticker = string4;
        this.tickerPic = string5;
        this.tickerPicDark = string6;
        this.timeout = n;
        this.showSmallIcon = bl3;
        this.baseInfo = baseInfo;
        this.chatInfo = chatInfo;
        this.picInfo = picInfo;
        this.highlightInfo = highlightInfo;
        this.highlightInfoV3 = highlightInfoV3;
        this.progressInfo = progressInfo;
        this.hintInfo = hintInfo;
        this.actions = list;
        this.bgInfo = bgInfo;
        this.animTextInfo = animTextInfo;
        this.coverInfo = coverInfo;
        this.iconTextInfo = iconTextInfo;
        this.multiProgressInfo = multiProgressInfo;
        this.textButton = list2;
        this.isShowNotification = bl4;
        this.notifyId = string7;
        this.business = string8;
        this.islandFirstFloat = bl5;
        this.cancel = bl6;
        this.hideDeco = bl7;
        this.outEffectSrc = string9;
        this.outEffectColor = string10;
        this.orderId = string11;
        this.sequence = l;
    }

    public /* synthetic */ Template(boolean bl, boolean bl2, String string, String string2, String string3, String string4, String string5, String string6, int n, boolean bl3, BaseInfo baseInfo, ChatInfo chatInfo, PicInfo picInfo, HighlightInfo highlightInfo, HighlightInfoV3 highlightInfoV3, ProgressInfo progressInfo, HintInfo hintInfo, List list, BgInfo bgInfo, AnimTextInfo animTextInfo, CoverInfo coverInfo, IconTextInfo iconTextInfo, MultiProgressInfo multiProgressInfo, List list2, Boolean bl4, String string7, String string8, Boolean bl5, boolean bl6, boolean bl7, String string9, String string10, String string11, long l, int n2, int n3, h h2) {
        if ((n2 & 0x800000) != 0) {
            list2 = null;
        }
        this(bl, bl2, string, string2, string3, string4, string5, string6, n, bl3, baseInfo, chatInfo, picInfo, highlightInfo, highlightInfoV3, progressInfo, hintInfo, list, bgInfo, animTextInfo, coverInfo, iconTextInfo, multiProgressInfo, list2, bl4, string7, string8, bl5, bl6, bl7, string9, string10, string11, l);
    }

    public static /* synthetic */ Template copy$default(Template template, boolean bl, boolean bl2, String string, String string2, String string3, String string4, String string5, String string6, int n, boolean bl3, BaseInfo baseInfo, ChatInfo chatInfo, PicInfo picInfo, HighlightInfo highlightInfo, HighlightInfoV3 highlightInfoV3, ProgressInfo progressInfo, HintInfo hintInfo, List list, BgInfo bgInfo, AnimTextInfo animTextInfo, CoverInfo coverInfo, IconTextInfo iconTextInfo, MultiProgressInfo multiProgressInfo, List list2, Boolean bl4, String string7, String string8, Boolean bl5, boolean bl6, boolean bl7, String string9, String string10, String string11, long l, int n2, int n3, Object object) {
        block33: {
            if ((n2 & 1) != 0) {
                bl = template.enableFloat;
            }
            if ((n2 & 2) != 0) {
                bl2 = template.updatable;
            }
            if ((n2 & 4) != 0) {
                string = template.reopen;
            }
            if ((n2 & 8) != 0) {
                string2 = template.aodTitle;
            }
            if ((n2 & 0x10) != 0) {
                string3 = template.aodPic;
            }
            if ((n2 & 0x20) != 0) {
                string4 = template.ticker;
            }
            if ((n2 & 0x40) != 0) {
                string5 = template.tickerPic;
            }
            if ((n2 & 0x80) != 0) {
                string6 = template.tickerPicDark;
            }
            if ((n2 & 0x100) != 0) {
                n = template.timeout;
            }
            if ((n2 & 0x200) != 0) {
                bl3 = template.showSmallIcon;
            }
            if ((n2 & 0x400) != 0) {
                baseInfo = template.baseInfo;
            }
            if ((n2 & 0x800) != 0) {
                chatInfo = template.chatInfo;
            }
            if ((n2 & 0x1000) != 0) {
                picInfo = template.picInfo;
            }
            if ((n2 & 0x2000) != 0) {
                highlightInfo = template.highlightInfo;
            }
            if ((n2 & 0x4000) != 0) {
                highlightInfoV3 = template.highlightInfoV3;
            }
            if ((n2 & 0x8000) != 0) {
                progressInfo = template.progressInfo;
            }
            if ((n2 & 0x10000) != 0) {
                hintInfo = template.hintInfo;
            }
            if ((n2 & 0x20000) != 0) {
                list = template.actions;
            }
            if ((n2 & 0x40000) != 0) {
                bgInfo = template.bgInfo;
            }
            if ((n2 & 0x80000) != 0) {
                animTextInfo = template.animTextInfo;
            }
            if ((n2 & 0x100000) != 0) {
                coverInfo = template.coverInfo;
            }
            if ((n2 & 0x200000) != 0) {
                iconTextInfo = template.iconTextInfo;
            }
            if ((n2 & 0x400000) != 0) {
                multiProgressInfo = template.multiProgressInfo;
            }
            if ((n2 & 0x800000) != 0) {
                list2 = template.textButton;
            }
            if ((n2 & 0x1000000) != 0) {
                bl4 = template.isShowNotification;
            }
            if ((n2 & 0x2000000) != 0) {
                string7 = template.notifyId;
            }
            if ((n2 & 0x4000000) != 0) {
                string8 = template.business;
            }
            if ((n2 & 0x8000000) != 0) {
                bl5 = template.islandFirstFloat;
            }
            if ((n2 & 0x10000000) != 0) {
                bl6 = template.cancel;
            }
            if ((n2 & 0x20000000) != 0) {
                bl7 = template.hideDeco;
            }
            if ((n2 & 0x40000000) != 0) {
                string9 = template.outEffectSrc;
            }
            if ((n2 & Integer.MIN_VALUE) != 0) {
                string10 = template.outEffectColor;
            }
            if ((n3 & 1) != 0) {
                string11 = template.orderId;
            }
            if ((n3 & 2) == 0) break block33;
            l = template.sequence;
        }
        return template.copy(bl, bl2, string, string2, string3, string4, string5, string6, n, bl3, baseInfo, chatInfo, picInfo, highlightInfo, highlightInfoV3, progressInfo, hintInfo, list, bgInfo, animTextInfo, coverInfo, iconTextInfo, multiProgressInfo, list2, bl4, string7, string8, bl5, bl6, bl7, string9, string10, string11, l);
    }

    public final boolean component1() {
        return this.enableFloat;
    }

    public final boolean component10() {
        return this.showSmallIcon;
    }

    public final BaseInfo component11() {
        return this.baseInfo;
    }

    public final ChatInfo component12() {
        return this.chatInfo;
    }

    public final PicInfo component13() {
        return this.picInfo;
    }

    public final HighlightInfo component14() {
        return this.highlightInfo;
    }

    public final HighlightInfoV3 component15() {
        return this.highlightInfoV3;
    }

    public final ProgressInfo component16() {
        return this.progressInfo;
    }

    public final HintInfo component17() {
        return this.hintInfo;
    }

    public final List<ActionInfo> component18() {
        return this.actions;
    }

    public final BgInfo component19() {
        return this.bgInfo;
    }

    public final boolean component2() {
        return this.updatable;
    }

    public final AnimTextInfo component20() {
        return this.animTextInfo;
    }

    public final CoverInfo component21() {
        return this.coverInfo;
    }

    public final IconTextInfo component22() {
        return this.iconTextInfo;
    }

    public final MultiProgressInfo component23() {
        return this.multiProgressInfo;
    }

    public final List<ActionInfo> component24() {
        return this.textButton;
    }

    public final Boolean component25() {
        return this.isShowNotification;
    }

    public final String component26() {
        return this.notifyId;
    }

    public final String component27() {
        return this.business;
    }

    public final Boolean component28() {
        return this.islandFirstFloat;
    }

    public final boolean component29() {
        return this.cancel;
    }

    public final String component3() {
        return this.reopen;
    }

    public final boolean component30() {
        return this.hideDeco;
    }

    public final String component31() {
        return this.outEffectSrc;
    }

    public final String component32() {
        return this.outEffectColor;
    }

    public final String component33() {
        return this.orderId;
    }

    public final long component34() {
        return this.sequence;
    }

    public final String component4() {
        return this.aodTitle;
    }

    public final String component5() {
        return this.aodPic;
    }

    public final String component6() {
        return this.ticker;
    }

    public final String component7() {
        return this.tickerPic;
    }

    public final String component8() {
        return this.tickerPicDark;
    }

    public final int component9() {
        return this.timeout;
    }

    public final Template copy(boolean bl, boolean bl2, String string, String string2, String string3, String string4, String string5, String string6, int n, boolean bl3, BaseInfo baseInfo, ChatInfo chatInfo, PicInfo picInfo, HighlightInfo highlightInfo, HighlightInfoV3 highlightInfoV3, ProgressInfo progressInfo, HintInfo hintInfo, List<ActionInfo> list, BgInfo bgInfo, AnimTextInfo animTextInfo, CoverInfo coverInfo, IconTextInfo iconTextInfo, MultiProgressInfo multiProgressInfo, List<ActionInfo> list2, Boolean bl4, String string7, String string8, Boolean bl5, boolean bl6, boolean bl7, String string9, String string10, String string11, long l) {
        o.g((Object)string2, (String)"aodTitle");
        o.g((Object)string3, (String)"aodPic");
        o.g((Object)string4, (String)"ticker");
        o.g((Object)string5, (String)"tickerPic");
        o.g((Object)string6, (String)"tickerPicDark");
        o.g((Object)string7, (String)"notifyId");
        o.g((Object)string8, (String)"business");
        o.g((Object)string9, (String)"outEffectSrc");
        o.g((Object)string10, (String)"outEffectColor");
        o.g((Object)string11, (String)"orderId");
        return new Template(bl, bl2, string, string2, string3, string4, string5, string6, n, bl3, baseInfo, chatInfo, picInfo, highlightInfo, highlightInfoV3, progressInfo, hintInfo, list, bgInfo, animTextInfo, coverInfo, iconTextInfo, multiProgressInfo, list2, bl4, string7, string8, bl5, bl6, bl7, string9, string10, string11, l);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Template)) {
            return false;
        }
        object = (Template)object;
        if (this.enableFloat != ((Template)object).enableFloat) {
            return false;
        }
        if (this.updatable != ((Template)object).updatable) {
            return false;
        }
        if (!o.c((Object)this.reopen, (Object)((Template)object).reopen)) {
            return false;
        }
        if (!o.c((Object)this.aodTitle, (Object)((Template)object).aodTitle)) {
            return false;
        }
        if (!o.c((Object)this.aodPic, (Object)((Template)object).aodPic)) {
            return false;
        }
        if (!o.c((Object)this.ticker, (Object)((Template)object).ticker)) {
            return false;
        }
        if (!o.c((Object)this.tickerPic, (Object)((Template)object).tickerPic)) {
            return false;
        }
        if (!o.c((Object)this.tickerPicDark, (Object)((Template)object).tickerPicDark)) {
            return false;
        }
        if (this.timeout != ((Template)object).timeout) {
            return false;
        }
        if (this.showSmallIcon != ((Template)object).showSmallIcon) {
            return false;
        }
        if (!o.c((Object)this.baseInfo, (Object)((Template)object).baseInfo)) {
            return false;
        }
        if (!o.c((Object)this.chatInfo, (Object)((Template)object).chatInfo)) {
            return false;
        }
        if (!o.c((Object)this.picInfo, (Object)((Template)object).picInfo)) {
            return false;
        }
        if (!o.c((Object)this.highlightInfo, (Object)((Template)object).highlightInfo)) {
            return false;
        }
        if (!o.c((Object)this.highlightInfoV3, (Object)((Template)object).highlightInfoV3)) {
            return false;
        }
        if (!o.c((Object)this.progressInfo, (Object)((Template)object).progressInfo)) {
            return false;
        }
        if (!o.c((Object)this.hintInfo, (Object)((Template)object).hintInfo)) {
            return false;
        }
        if (!o.c(this.actions, ((Template)object).actions)) {
            return false;
        }
        if (!o.c((Object)this.bgInfo, (Object)((Template)object).bgInfo)) {
            return false;
        }
        if (!o.c((Object)this.animTextInfo, (Object)((Template)object).animTextInfo)) {
            return false;
        }
        if (!o.c((Object)this.coverInfo, (Object)((Template)object).coverInfo)) {
            return false;
        }
        if (!o.c((Object)this.iconTextInfo, (Object)((Template)object).iconTextInfo)) {
            return false;
        }
        if (!o.c((Object)this.multiProgressInfo, (Object)((Template)object).multiProgressInfo)) {
            return false;
        }
        if (!o.c(this.textButton, ((Template)object).textButton)) {
            return false;
        }
        if (!o.c((Object)this.isShowNotification, (Object)((Template)object).isShowNotification)) {
            return false;
        }
        if (!o.c((Object)this.notifyId, (Object)((Template)object).notifyId)) {
            return false;
        }
        if (!o.c((Object)this.business, (Object)((Template)object).business)) {
            return false;
        }
        if (!o.c((Object)this.islandFirstFloat, (Object)((Template)object).islandFirstFloat)) {
            return false;
        }
        if (this.cancel != ((Template)object).cancel) {
            return false;
        }
        if (this.hideDeco != ((Template)object).hideDeco) {
            return false;
        }
        if (!o.c((Object)this.outEffectSrc, (Object)((Template)object).outEffectSrc)) {
            return false;
        }
        if (!o.c((Object)this.outEffectColor, (Object)((Template)object).outEffectColor)) {
            return false;
        }
        if (!o.c((Object)this.orderId, (Object)((Template)object).orderId)) {
            return false;
        }
        return this.sequence == ((Template)object).sequence;
    }

    public final List<ActionInfo> getActions() {
        return this.actions;
    }

    public final AnimTextInfo getAnimTextInfo() {
        return this.animTextInfo;
    }

    public final String getAodPic() {
        return this.aodPic;
    }

    public final String getAodTitle() {
        return this.aodTitle;
    }

    public final BaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public final BgInfo getBgInfo() {
        return this.bgInfo;
    }

    public final String getBusiness() {
        return this.business;
    }

    public final boolean getCancel() {
        return this.cancel;
    }

    public final ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public final CoverInfo getCoverInfo() {
        return this.coverInfo;
    }

    public final boolean getEnableFloat() {
        return this.enableFloat;
    }

    public final boolean getHideDeco() {
        return this.hideDeco;
    }

    public final HighlightInfo getHighlightInfo() {
        return this.highlightInfo;
    }

    public final HighlightInfoV3 getHighlightInfoV3() {
        return this.highlightInfoV3;
    }

    public final HintInfo getHintInfo() {
        return this.hintInfo;
    }

    public final IconTextInfo getIconTextInfo() {
        return this.iconTextInfo;
    }

    public final Boolean getIslandFirstFloat() {
        return this.islandFirstFloat;
    }

    public final MultiProgressInfo getMultiProgressInfo() {
        return this.multiProgressInfo;
    }

    public final String getNotifyId() {
        return this.notifyId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getOutEffectColor() {
        return this.outEffectColor;
    }

    public final String getOutEffectSrc() {
        return this.outEffectSrc;
    }

    public final PicInfo getPicInfo() {
        return this.picInfo;
    }

    public final ProgressInfo getProgressInfo() {
        return this.progressInfo;
    }

    public final String getReopen() {
        return this.reopen;
    }

    public final long getSequence() {
        return this.sequence;
    }

    public final boolean getShowSmallIcon() {
        return this.showSmallIcon;
    }

    public final List<ActionInfo> getTextButton() {
        return this.textButton;
    }

    public final String getTicker() {
        return this.ticker;
    }

    public final String getTickerPic() {
        return this.tickerPic;
    }

    public final String getTickerPicDark() {
        return this.tickerPicDark;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final boolean getUpdatable() {
        return this.updatable;
    }

    public int hashCode() {
        int n = Boolean.hashCode(this.enableFloat);
        int n2 = Boolean.hashCode(this.updatable);
        Object object = this.reopen;
        int n3 = 0;
        int n4 = object == null ? 0 : ((String)object).hashCode();
        int n5 = this.aodTitle.hashCode();
        int n6 = this.aodPic.hashCode();
        int n7 = this.ticker.hashCode();
        int n8 = this.tickerPic.hashCode();
        int n9 = this.tickerPicDark.hashCode();
        int n10 = Integer.hashCode(this.timeout);
        int n11 = Boolean.hashCode(this.showSmallIcon);
        object = this.baseInfo;
        int n12 = object == null ? 0 : object.hashCode();
        object = this.chatInfo;
        int n13 = object == null ? 0 : object.hashCode();
        object = this.picInfo;
        int n14 = object == null ? 0 : ((PicInfo)object).hashCode();
        object = this.highlightInfo;
        int n15 = object == null ? 0 : object.hashCode();
        object = this.highlightInfoV3;
        int n16 = object == null ? 0 : object.hashCode();
        object = this.progressInfo;
        int n17 = object == null ? 0 : ((ProgressInfo)object).hashCode();
        object = this.hintInfo;
        int n18 = object == null ? 0 : object.hashCode();
        object = this.actions;
        int n19 = object == null ? 0 : object.hashCode();
        object = this.bgInfo;
        int n20 = object == null ? 0 : ((BgInfo)object).hashCode();
        object = this.animTextInfo;
        int n21 = object == null ? 0 : object.hashCode();
        object = this.coverInfo;
        int n22 = object == null ? 0 : object.hashCode();
        object = this.iconTextInfo;
        int n23 = object == null ? 0 : object.hashCode();
        object = this.multiProgressInfo;
        int n24 = object == null ? 0 : ((MultiProgressInfo)object).hashCode();
        object = this.textButton;
        int n25 = object == null ? 0 : object.hashCode();
        object = this.isShowNotification;
        int n26 = object == null ? 0 : object.hashCode();
        int n27 = this.notifyId.hashCode();
        int n28 = this.business.hashCode();
        object = this.islandFirstFloat;
        if (object != null) {
            n3 = object.hashCode();
        }
        return ((((((((((((((((((((((((((((((((n * 31 + n2) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n12) * 31 + n13) * 31 + n14) * 31 + n15) * 31 + n16) * 31 + n17) * 31 + n18) * 31 + n19) * 31 + n20) * 31 + n21) * 31 + n22) * 31 + n23) * 31 + n24) * 31 + n25) * 31 + n26) * 31 + n27) * 31 + n28) * 31 + n3) * 31 + Boolean.hashCode(this.cancel)) * 31 + Boolean.hashCode(this.hideDeco)) * 31 + this.outEffectSrc.hashCode()) * 31 + this.outEffectColor.hashCode()) * 31 + this.orderId.hashCode()) * 31 + Long.hashCode(this.sequence);
    }

    public final Boolean isShowNotification() {
        return this.isShowNotification;
    }

    public final void setBusiness(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.business = string;
    }

    public final void setCancel(boolean bl) {
        this.cancel = bl;
    }

    public final void setHideDeco(boolean bl) {
        this.hideDeco = bl;
    }

    public final void setIslandFirstFloat(Boolean bl) {
        this.islandFirstFloat = bl;
    }

    public final void setNotifyId(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.notifyId = string;
    }

    public final void setOrderId(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.orderId = string;
    }

    public final void setOutEffectColor(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.outEffectColor = string;
    }

    public final void setOutEffectSrc(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.outEffectSrc = string;
    }

    public final void setProgressInfo(ProgressInfo progressInfo) {
        this.progressInfo = progressInfo;
    }

    public final void setReopen(String string) {
        this.reopen = string;
    }

    public final void setSequence(long l) {
        this.sequence = l;
    }

    public final void setShowNotification(Boolean bl) {
        this.isShowNotification = bl;
    }

    public final void setTextButton(List<ActionInfo> list) {
        this.textButton = list;
    }

    public String toString() {
        boolean bl = this.enableFloat;
        boolean bl2 = this.updatable;
        String string = this.reopen;
        String string2 = this.aodTitle;
        String string3 = this.aodPic;
        String string4 = this.ticker;
        String string5 = this.tickerPic;
        String string6 = this.tickerPicDark;
        int n = this.timeout;
        boolean bl3 = this.showSmallIcon;
        BaseInfo baseInfo = this.baseInfo;
        ChatInfo chatInfo = this.chatInfo;
        PicInfo picInfo = this.picInfo;
        HighlightInfo highlightInfo = this.highlightInfo;
        HighlightInfoV3 highlightInfoV3 = this.highlightInfoV3;
        ProgressInfo progressInfo = this.progressInfo;
        HintInfo hintInfo = this.hintInfo;
        List<ActionInfo> list = this.actions;
        BgInfo bgInfo = this.bgInfo;
        AnimTextInfo animTextInfo = this.animTextInfo;
        CoverInfo coverInfo = this.coverInfo;
        IconTextInfo iconTextInfo = this.iconTextInfo;
        MultiProgressInfo multiProgressInfo = this.multiProgressInfo;
        List<ActionInfo> list2 = this.textButton;
        Boolean bl4 = this.isShowNotification;
        String string7 = this.notifyId;
        String string8 = this.business;
        Boolean bl5 = this.islandFirstFloat;
        boolean bl6 = this.cancel;
        boolean bl7 = this.hideDeco;
        String string9 = this.outEffectSrc;
        String string10 = this.outEffectColor;
        String string11 = this.orderId;
        long l = this.sequence;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Template(enableFloat=");
        stringBuilder.append(bl);
        stringBuilder.append(", updatable=");
        stringBuilder.append(bl2);
        stringBuilder.append(", reopen=");
        stringBuilder.append(string);
        stringBuilder.append(", aodTitle=");
        stringBuilder.append(string2);
        stringBuilder.append(", aodPic=");
        stringBuilder.append(string3);
        stringBuilder.append(", ticker=");
        stringBuilder.append(string4);
        stringBuilder.append(", tickerPic=");
        stringBuilder.append(string5);
        stringBuilder.append(", tickerPicDark=");
        stringBuilder.append(string6);
        stringBuilder.append(", timeout=");
        stringBuilder.append(n);
        stringBuilder.append(", showSmallIcon=");
        stringBuilder.append(bl3);
        stringBuilder.append(", baseInfo=");
        stringBuilder.append(baseInfo);
        stringBuilder.append(", chatInfo=");
        stringBuilder.append(chatInfo);
        stringBuilder.append(", picInfo=");
        stringBuilder.append(picInfo);
        stringBuilder.append(", highlightInfo=");
        stringBuilder.append(highlightInfo);
        stringBuilder.append(", highlightInfoV3=");
        stringBuilder.append(highlightInfoV3);
        stringBuilder.append(", progressInfo=");
        stringBuilder.append(progressInfo);
        stringBuilder.append(", hintInfo=");
        stringBuilder.append(hintInfo);
        stringBuilder.append(", actions=");
        stringBuilder.append(list);
        stringBuilder.append(", bgInfo=");
        stringBuilder.append(bgInfo);
        stringBuilder.append(", animTextInfo=");
        stringBuilder.append(animTextInfo);
        stringBuilder.append(", coverInfo=");
        stringBuilder.append(coverInfo);
        stringBuilder.append(", iconTextInfo=");
        stringBuilder.append(iconTextInfo);
        stringBuilder.append(", multiProgressInfo=");
        stringBuilder.append(multiProgressInfo);
        stringBuilder.append(", textButton=");
        stringBuilder.append(list2);
        stringBuilder.append(", isShowNotification=");
        stringBuilder.append(bl4);
        stringBuilder.append(", notifyId=");
        stringBuilder.append(string7);
        stringBuilder.append(", business=");
        stringBuilder.append(string8);
        stringBuilder.append(", islandFirstFloat=");
        stringBuilder.append(bl5);
        stringBuilder.append(", cancel=");
        stringBuilder.append(bl6);
        stringBuilder.append(", hideDeco=");
        stringBuilder.append(bl7);
        stringBuilder.append(", outEffectSrc=");
        stringBuilder.append(string9);
        stringBuilder.append(", outEffectColor=");
        stringBuilder.append(string10);
        stringBuilder.append(", orderId=");
        stringBuilder.append(string11);
        stringBuilder.append(", sequence=");
        stringBuilder.append(l);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
