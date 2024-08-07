package dzsivokado.elsonormalpluginom.commands;

import dzsivokado.elsonormalpluginom.Wtroll;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static dzsivokado.elsonormalpluginom.Functions.sendersendmsg;

public class TesztCommand implements CommandExecutor {

    private final Wtroll plugin;

    public TesztCommand(Wtroll plugin) {
        this.plugin = plugin;
    }

    public String asd;


    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            asd = player.getPlayer().getDisplayName();
        } else if (sender instanceof ConsoleCommandSender) {

            asd = "Console";
        }



        if (args[0].equals("asd")) {
            if (sender.hasPermission("wtroll.lookup")) {
                if (args.length == 1) {
                    sendersendmsg(sender, asd);
                } else if (args.length == 2) {
                    String playerName = args[1];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);
                    if (target == null) {
                       sendersendmsg(sender, asd);
                    } else {



                        String ip = String.valueOf(target.getAddress());
                        target.sendMessage(ip);
                    }
                }
            }
        }

        return true;
    }



}