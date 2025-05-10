package fun.lingzhen.mc;

import fun.lingzhen.mc.init.ModBlockEntityTypes;
import fun.lingzhen.mc.init.ModBlocks;
import fun.lingzhen.mc.init.ModItems;
import fun.lingzhen.mc.init.ModScreens;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UselessRedstone implements ModInitializer {
	public static final String MOD_ID = "useless-redstone";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();

		ModItems.initialize();
		ModBlockEntityTypes.initialize();

		ModScreens.initialize();
	}
}