/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.module.helper;

import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.module.helper.IslandModuleViewLayoutResources;

public final class PhoneIslandModuleViewLayoutResources
implements IslandModuleViewLayoutResources {
    public static final PhoneIslandModuleViewLayoutResources INSTANCE = new PhoneIslandModuleViewLayoutResources();
    private static final int moduleFixedWidthDigit;
    private static final int moduleIconFixedWidthText;
    private static final int moduleImageText1;
    private static final int moduleImageText2;
    private static final int moduleImageText3;
    private static final int modulePic;
    private static final int moduleProgressText;
    private static final int moduleRightText;
    private static final int moduleSameWidthDigit;

    static {
        moduleImageText1 = R.layout.dynamic_island_module_image_text_1;
        moduleImageText2 = R.layout.dynamic_island_module_image_text_2;
        moduleImageText3 = R.layout.dynamic_island_module_image_text_3;
        moduleProgressText = R.layout.dynamic_island_module_progress_text;
        moduleRightText = R.layout.dynamic_island_module_right_text;
        modulePic = R.layout.dynamic_island_module_icon_1;
        moduleFixedWidthDigit = R.layout.dynamic_island_module_fixed_width_digit;
        moduleSameWidthDigit = R.layout.dynamic_island_module_same_width_digit;
        moduleIconFixedWidthText = R.layout.dynamic_island_module_icon_fixed_width_text;
    }

    private PhoneIslandModuleViewLayoutResources() {
    }

    @Override
    public int getModuleFixedWidthDigit() {
        return moduleFixedWidthDigit;
    }

    @Override
    public int getModuleIconFixedWidthText() {
        return moduleIconFixedWidthText;
    }

    @Override
    public int getModuleImageText1() {
        return moduleImageText1;
    }

    @Override
    public int getModuleImageText2() {
        return moduleImageText2;
    }

    @Override
    public int getModuleImageText3() {
        return moduleImageText3;
    }

    @Override
    public int getModulePic() {
        return modulePic;
    }

    @Override
    public int getModuleProgressText() {
        return moduleProgressText;
    }

    @Override
    public int getModuleRightText() {
        return moduleRightText;
    }

    @Override
    public int getModuleSameWidthDigit() {
        return moduleSameWidthDigit;
    }
}
