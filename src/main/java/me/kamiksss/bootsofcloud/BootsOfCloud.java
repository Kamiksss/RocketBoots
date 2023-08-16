package me.kamiksss.bootsofcloud;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class BootsOfCloud extends JavaPlugin {


    @Override
    public void onEnable() {
        registerGoldenFeather();
    }

    public static ItemStack GOLDEN_FEATHER;
    public static void registerGoldenFeather() {
        ItemStack goldenFeather = new ItemStack(Material.FEATHER, 1);
        ItemMeta goldenFeatherMeta = goldenFeather.getItemMeta();
        goldenFeatherMeta.setDisplayName("§6§lGolden Feather");
        goldenFeatherMeta.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
        goldenFeather.setItemMeta(goldenFeatherMeta);
        GOLDEN_FEATHER = goldenFeather;

        ShapedRecipe goldenFeatherRecipe = new ShapedRecipe(NamespacedKey.minecraft("goldenfeather"),goldenFeather);
        goldenFeatherRecipe.shape(" F ", "FGF"," F ");
        goldenFeatherRecipe.setIngredient('F', Material.FEATHER);
        goldenFeatherRecipe.setIngredient('G',Material.GOLD_INGOT);

        Bukkit.addRecipe(goldenFeatherRecipe);
    }
}