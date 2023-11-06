package me.kamiksss.bootsofcloud;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerEventHandler implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack(
                "https://www.dropbox.com/scl/fo/2br2bj7dfzzu4zeddgrft/h?rlkey=53nvb8u6oq75395gvsaydgasf&dl=1");

    }

    private boolean hasCloudBoots(Player player) {
        if (player.getInventory().getBoots() == null || player.getInventory().getBoots().getLore() == null) {
            return false;
        } else {
            return true;
        }

    }

    @EventHandler
    public void NegateFallDamage(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if (event.getEntity() instanceof Player) {
                Player p = (Player) event.getEntity();

                if (hasCloudBoots(p)) {
                    event.setCancelled(true);
                }
            }
        }

    }

    @EventHandler
    public void SwapArmor(PlayerArmorChangeEvent event) {
        Player p = event.getPlayer();
        if (hasCloudBoots(p)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 5, false, false, false));
        } else {
            p.removePotionEffect(PotionEffectType.JUMP);
        }
    }

    @EventHandler
    public void createParticles(PlayerJumpEvent event) {
        Player p = event.getPlayer();
        if (hasCloudBoots(p)) {
            p.spawnParticle(Particle.LAVA, p.getEyeLocation(), 250);
        }

    }

}
