package fun.lingzhen.mc.init;

import fun.lingzhen.mc.block.entity.CateHopperBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static fun.lingzhen.mc.UselessRedstone.MOD_ID;

public class ModBlockEntityTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<CateHopperBlockEntity> CATE_HOPPER = register(
            "cate_hopper",
            FabricBlockEntityTypeBuilder.create(CateHopperBlockEntity::new, ModBlocks.CATE_HOPPER).build()
    );

    public static void initialize() {
    }

}
