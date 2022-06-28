package teamaj.teamautojoin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public final class TeamAutoJoin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }


    @Override
    public void onDisable() {
    }


    @EventHandler
    public void PTJoinEvent(PlayerJoinEvent event) {
        String teamName = getConfig().getString("teamName");
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
        Team team = board.getTeam(teamName);
        team.addPlayer(event.getPlayer());
    }
}