/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window.content;

public final class ShareProviderData {
    private String packageName;
    private byte[] shareIconByteArray;
    private String shareMessage;
    private String shareUrl;
    private String title;
    private int value = -1;

    public final String getPackageName() {
        return this.packageName;
    }

    public final byte[] getShareIconByteArray() {
        return this.shareIconByteArray;
    }

    public final String getShareMessage() {
        return this.shareMessage;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setPackageName(String string) {
        this.packageName = string;
    }

    public final void setShareIconByteArray(byte[] byArray) {
        this.shareIconByteArray = byArray;
    }

    public final void setShareMessage(String string) {
        this.shareMessage = string;
    }

    public final void setShareUrl(String string) {
        this.shareUrl = string;
    }

    public final void setTitle(String string) {
        this.title = string;
    }

    public final void setValue(int n) {
        this.value = n;
    }
}
