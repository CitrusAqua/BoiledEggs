package citrusaqua.boiledeggs;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.block.ComposterBlock;

public class BoiledEggsMod implements ModInitializer {
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "boiled_egg"), BOILED_EGG);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(BOILED_EGG));

        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "eggshell"), EGGSHELL);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> itemGroup.add(EGGSHELL));
    }

    public static final String MOD_ID = "boiled_eggs";

    public static final Eggshell EGGSHELL = new Eggshell(new Item.Settings());

    public static final FoodComponent BOILED_EGG_COMPONENT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.6F)
            .usingConvertsTo(EGGSHELL)
            .build();

    public static final BoiledEgg BOILED_EGG = new BoiledEgg(new Item.Settings().food(BOILED_EGG_COMPONENT));

}