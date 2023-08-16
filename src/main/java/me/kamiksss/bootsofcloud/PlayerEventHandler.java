package me.kamiksss.bootsofcloud;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class PlayerEventHandler implements Listener {

    @EventHandler
    public void NegateFallDamage(EntityDamageEvent event){
        if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
            if (event.getEntity() instanceof Player){
                Player p = (Player) event.getEntity();

                if(p.getInventory().getBoots() == null || p.getInventory().getBoots().lore() == null){
                    return;
                }else{

                if(p.getInventory().getBoots().getLore().contains("§8§oPrevents Fall Damage and Gives Jump Boost")){
                    event.setCancelled(true);
                }
                }
            }
        }

    }

    @EventHandler
    public void SwapArmor(PlayerArmorChangeEvent event){
        Player p = event.getPlayer();
        if (p.getInventory().getBoots() ==null || p.getInventory().getBoots().getLore() ==null) {
            p.removePotionEffect(PotionEffectType.JUMP);
        }
        else if(p.getInventory().getBoots().getLore().contains("§8§oPrevents Fall Damage and Gives Jump Boost")){
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 5, false, false, false) );

        }

        else{
            p.removePotionEffect(PotionEffectType.JUMP);
        }
    }
}
