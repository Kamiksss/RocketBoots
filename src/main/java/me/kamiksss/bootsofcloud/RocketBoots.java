package me.kamiksss.bootsofcloud;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;

public final class RocketBoots extends JavaPlugin {

    @Override
    public void onEnable() {
        registerGoldenFeather();
        getServer().getPluginManager().registerEvents(new PlayerEventHandler(), this);

    }

    public static ItemStack GOLDEN_FEATHER;
    public static ItemStack NETHERITE_CLOUD_BOOTS;

    public static void registerGoldenFeather() {
        ItemStack goldenFeather = new ItemStack(Material.FEATHER, 1);
        ItemMeta goldenFeatherMeta = goldenFeather.getItemMeta();
        goldenFeatherMeta.setDisplayName("§6§lGolden Feather");
        goldenFeatherMeta.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
        goldenFeatherMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        goldenFeatherMeta.setCustomModelData(124);
        goldenFeather.setItemMeta(goldenFeatherMeta);
        GOLDEN_FEATHER = goldenFeather;

        ShapedRecipe goldenFeatherRecipe = new ShapedRecipe(NamespacedKey.minecraft("goldenfeather"), goldenFeather);
        goldenFeatherRecipe.shape(" F ", "FGF", " F ");
        goldenFeatherRecipe.setIngredient('F', Material.FEATHER);
        goldenFeatherRecipe.setIngredient('G', Material.GOLD_INGOT);

        Bukkit.addRecipe(goldenFeatherRecipe);

        ItemStack netheriteCloudBoots = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta netheriteCloudBootsMeta = netheriteCloudBoots.getItemMeta();
        netheriteCloudBootsMeta.setDisplayName("§bNetherite Cloud Boots");
        ArrayList<String> lore = new ArrayList();
        lore.add(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Prevents Fall Damage and Gives Jump Boost"
                + ChatColor.RESET);

        netheriteCloudBootsMeta.setLore(lore);
        netheriteCloudBootsMeta.setCustomModelData(123);

        netheriteCloudBoots.setItemMeta(netheriteCloudBootsMeta);
        NETHERITE_CLOUD_BOOTS = netheriteCloudBoots;

        ShapelessRecipe netheriteCloudBootsRecipe = new ShapelessRecipe(NamespacedKey.minecraft("netheritecloudboots"),
                netheriteCloudBoots);
        netheriteCloudBootsRecipe.addIngredient(Material.NETHERITE_BOOTS).addIngredient(goldenFeather);

        Bukkit.addRecipe(netheriteCloudBootsRecipe);
    }
}