/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package miui.systemui.dynamicisland.module;

import android.text.Editable;
import android.text.TextWatcher;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;

public static final class IslandSameWidthDigitViewHolder.textWatcher.1
implements TextWatcher {
    final IslandSameWidthDigitViewHolder this$0;

    public IslandSameWidthDigitViewHolder.textWatcher.1(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        this.this$0 = islandSameWidthDigitViewHolder;
    }

    public void afterTextChanged(Editable editable) {
        int n;
        int n2;
        if (this.this$0.timerInitialized && (n2 = this.this$0.lastLength) != (n = editable != null ? editable.length() : 0)) {
            IslandSameWidthDigitViewHolder.super.getEmitEvent().invoke((Object)this.this$0.lastData, (Object)DynamicIslandEvent.UpdateDynamicIsland.INSTANCE);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder = this.this$0;
        n = charSequence != null ? charSequence.length() : 0;
        islandSameWidthDigitViewHolder.lastLength = n;
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }
}
