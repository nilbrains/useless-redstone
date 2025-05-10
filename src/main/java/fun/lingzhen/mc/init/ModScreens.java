package fun.lingzhen.mc.init;

import fun.lingzhen.mc.UselessRedstone;
import fun.lingzhen.mc.gui.screen.CateHopperScreen;
import fun.lingzhen.mc.screen.CateHopperScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreens {

    public static final ScreenHandlerType<CateHopperScreenHandler> CATE_HOPPER_SCREEN_HANDLER;

    static {
        CATE_HOPPER_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(UselessRedstone.MOD_ID, "cate_hopper"), new ScreenHandlerType<>(
                CateHopperScreenHandler::new,
                null
        ));
    }

    public static void initialize() {
        HandledScreens.register(CATE_HOPPER_SCREEN_HANDLER, CateHopperScreen::new);
    }



}
