package at.kingcraft.OnevsOne_arena.Messaging;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import at.kingcraft.OnevsOne_arena.MainClass;
import net.md_5.bungee.api.ChatColor;

public class Messages
{
	private static FileConfiguration config;
	private static File file;
	
	public static String tournamentWin;
	public static String tournamentLose;
	public static String haveToBeInDuel;
	public static String fixed;
	public static String waitingHousePlaced;
	public static String arenaNotThere;
	private static String waitingForOtherPlayers;
	public static String pleaseRespawn;
	public static String arenaIsLoading;
	public static String arenaHasLoaded;
	public static String duelStarts;
	private static String duelStartsTimer;
	public static String youHaveWon;
	public static String youHaveLost;
	public static String thereAreNoMaps;
	private static String youAreFightingAgainst;
	private static String youAreFightingAgainstFFA;
	private static String youAreFightingAgainstRanked;
	private static String hasLifeLeft;
	private static String playerInHasLifeLeft;
	public static String seperatorInHasLifeLfeft;
	private static String hasLifeLeftTeam;
	private static String yourKit;
	public static String thisIsntAllowedInTournament;
	public static String duelHasntBeenStarted;
	public static String duelIsOver;
	public static String timerHasAlreadyBeenStarted;
	public static String timerStarts;
	public static String nearestOneWins;
	public static String oneMinuteLeft;
	public static String qualificationPhaseStarts;
	public static String koPhaseStarts;
	private static String mapLoads;
	private static String tournamentCreate;
	private static String chatFromLobby;
	private static String kitSetting;
	public static String kitSettingSeparator;
	private static String soupsLeft;
	private static String soupsLeftTeam;
	public static String endMatchSpectator;
	private static String stats;
	public static String noPermissionStatsView;
	public static String yourStatistics;
	private static String statisticsOf;
	private static String playerDoesntExists;
	private static String gotELO;
	private static String lostELO;
	public static String thereIsNoDuel;
	public static String thereIsNoTournament;
	
	private static void addDefaults()
	{
		tournamentWin = ChatColor.YELLOW + "Du hast das Turnier gewonnen";
		tournamentLose = ChatColor.YELLOW + "Du bist aus dem Turnier ausgeschieden";
		haveToBeInDuel = ChatColor.RED + "Du musst in einem Duell sein";
		fixed = ChatColor.YELLOW + "Gefixt!";
		waitingHousePlaced = ChatColor.YELLOW + "Warte Haus Position gesetzt";
		arenaNotThere = ChatColor.RED + "Arena nicht vorhanden";
		waitingForOtherPlayers = ChatColor.GRAY + "Waiting for other Players " + ChatColor.YELLOW + "%seconds%";
		pleaseRespawn = ChatColor.RED + "Bitte respawne";
		arenaIsLoading = ChatColor.YELLOW + "Arena wird vorbereitet...";
		arenaHasLoaded = ChatColor.YELLOW + "Arena wurde geladen";
		duelStarts = ChatColor.YELLOW + "Duell startet!";
		duelStartsTimer = ChatColor.YELLOW + "Duell startet in " + ChatColor.GREEN + "%seconds%" + ChatColor.YELLOW + " Sekunden";
		youHaveWon = ChatColor.YELLOW + "Du hast gewonnen!";
		youHaveLost = ChatColor.YELLOW + "Du hast verloren!";
		thereAreNoMaps = ChatColor.RED + "Hier sind keine Maps";
		youAreFightingAgainst = ChatColor.YELLOW + "Du kämpfst gegen " + ChatColor.GREEN + "%player%";
		youAreFightingAgainstFFA = ChatColor.YELLOW + "Du kämpfst in einem FFA gegen " + ChatColor.GREEN + "%player%";
		youAreFightingAgainstRanked = ChatColor.YELLOW + "Du kämpfst gegen " + ChatColor.GREEN + "%player% " + ChatColor.YELLOW + "(ELO: " + ChatColor.BLUE + "%elo%" + ChatColor.YELLOW + ")";
		hasLifeLeft = ChatColor.GREEN + "%player% " + ChatColor.YELLOW + "hat noch " + ChatColor.RED + "%health%♥ " + ChatColor.YELLOW + "Leben übrig";
		playerInHasLifeLeft = ChatColor.GREEN + "%player%";
		seperatorInHasLifeLfeft = ChatColor.YELLOW + " ,";
		hasLifeLeftTeam = "%team% " + ChatColor.YELLOW + "haben noch " + ChatColor.RED + "%health%♥ " + ChatColor.YELLOW + "Leben übrig";
		yourKit = ChatColor.YELLOW + "Dein Kit: " + ChatColor.BLUE + "%name%\n" + ChatColor.YELLOW + "Einstellungen: %settings%";
		thisIsntAllowedInTournament = ChatColor.RED + "Das ist in einem Turnier nicht erlaubt";
		duelHasntBeenStarted = ChatColor.RED + "Das Duell wurde noch nicht gestartet";
		duelIsOver = ChatColor.RED + "Das Duell ist schon vorbei";
		timerHasAlreadyBeenStarted = ChatColor.RED +  "Der Timer wurde schon gestartet";
		timerStarts = ChatColor.YELLOW + "Timer startet";
		nearestOneWins = ChatColor.YELLOW + "Der, der am nähesten zum Mittelpunkt ist gewinnt";
		oneMinuteLeft = ChatColor.YELLOW + "Noch eine Minute";
		qualificationPhaseStarts = ChatColor.GOLD + "Die Qualifikationsphase beginnt";
		koPhaseStarts = ChatColor.GOLD + "Die KO-Phase beginnt";
		mapLoads = ChatColor.BLUE + "%map%" + ChatColor.YELLOW + " wird geladen";
		tournamentCreate = ChatColor.GREEN + "%prefix%%player%" + ChatColor.YELLOW + " hat ein Turnier (%size%vs%size%) erstellt";
		chatFromLobby = "%player%: " + ChatColor.WHITE + "%message%";
		kitSetting = ChatColor.GOLD + "%setting%";
		kitSettingSeparator = ChatColor.GRAY + "; ";
		soupsLeft = ChatColor.GREEN + "%player% " + ChatColor.YELLOW + "hat noch " + ChatColor.BLUE + "%soups% " + ChatColor.YELLOW + " Suppen und " + ChatColor.BLUE + "%recrafts% " + ChatColor.YELLOW + "Recrafts übrig";
		soupsLeftTeam = "%team% " + ChatColor.YELLOW + "haben noch " + ChatColor.BLUE + "%soups% " + ChatColor.YELLOW + "Suppen und " + ChatColor.BLUE + "%recrafts% " + ChatColor.YELLOW + "Recrafts übrig";
		endMatchSpectator = ChatColor.RED + "Das darfst du nicht als Zuschauer";
		stats = ChatColor.YELLOW + "Kills:       " + ChatColor.BLUE + "%kills%" + "\n" + ChatColor.YELLOW + "Tode:        " + ChatColor.BLUE + "%deaths%" + "\n" + ChatColor.YELLOW + "K/T:         " + ChatColor.BLUE + "%kd%" + "\n" + ChatColor.YELLOW + "Spiele:      " + ChatColor.BLUE + "%plays%" + "\n" + ChatColor.YELLOW + "Siege:       " + ChatColor.BLUE + "%wins%" + "\n" + ChatColor.YELLOW + "Niederlagen: " + ChatColor.BLUE + "%loses%" + "\n" + ChatColor.YELLOW + "Wahrscheinlichkeit: " + ChatColor.BLUE + "%winsperplays%" + "%" + "\n" + ChatColor.YELLOW + "Gewonnene Turniere: " + ChatColor.BLUE + "%tournaments%";
		noPermissionStatsView = ChatColor.RED + "Du hast keine Rechte Statistiken anzuschauen";
		yourStatistics = ChatColor.YELLOW + "--- " + ChatColor.GREEN +  "Deine Statistiken" + ChatColor.YELLOW + " ---";
		statisticsOf = ChatColor.YELLOW + "Statistiken von " + ChatColor.GREEN + "%player%";
		playerDoesntExists = ChatColor.RED + "Der Spieler " + ChatColor.BLUE + "%player%" + ChatColor.RED + " existiert nicht";
		gotELO = ChatColor.YELLOW + "Du hast " + ChatColor.BLUE + "%elo% " + ChatColor.YELLOW + "ELO bekommen";
		lostELO = ChatColor.YELLOW + "Du hast " + ChatColor.BLUE + "%elo% " + ChatColor.YELLOW + "ELO verloren";
		thereIsNoDuel = ChatColor.RED + "Es findet kein Duell statt";
		thereIsNoTournament = ChatColor.RED + "Es findet kein Turnier statt";
		
		config.addDefault("tournament-win", tournamentWin);
		config.addDefault("tournament-lose", tournamentLose);
		config.addDefault("have-to-be-in-duel", haveToBeInDuel);
		config.addDefault("fixed", fixed);
		config.addDefault("waitinghouse-placed", waitingHousePlaced);
		config.addDefault("arena-not-there", arenaNotThere);
		config.addDefault("waiting-for-other-players", waitingForOtherPlayers);
		config.addDefault("please-respawn", pleaseRespawn);
		config.addDefault("arena-is-loading", arenaIsLoading);
		config.addDefault("arena-has-loaded", arenaHasLoaded);
		config.addDefault("duel-starts", duelStarts);
		config.addDefault("duel-starts-timer", duelStartsTimer);
		config.addDefault("you-have-won", youHaveWon);
		config.addDefault("you-have-lost", youHaveLost);
		config.addDefault("ther-are-no-maps", thereAreNoMaps);
		config.addDefault("you-are-fighting-against", youAreFightingAgainst);
		config.addDefault("you-are-fighting-against-ffa", youAreFightingAgainstFFA);
		config.addDefault("you-are-fighting-against-ranked", youAreFightingAgainstRanked);
		config.addDefault("has-life-left", hasLifeLeft);
		config.addDefault("player-in-has-life-left", playerInHasLifeLeft);
		config.addDefault("seperator-in-has-life-left", seperatorInHasLifeLfeft);
		config.addDefault("has-life-left-team", hasLifeLeftTeam);
		config.addDefault("your-kit", yourKit);
		config.addDefault("this-isnt-allowed-in-tournament", thisIsntAllowedInTournament);
		config.addDefault("duel-hasnt-been-started", duelHasntBeenStarted);
		config.addDefault("duel-is-over", duelIsOver);
		config.addDefault("timer-has-already-been-started", timerHasAlreadyBeenStarted);
		config.addDefault("timer-starts", timerStarts);
		config.addDefault("nearest-one-wins", nearestOneWins);
		config.addDefault("one-minute-left", oneMinuteLeft);
		config.addDefault("qualification-phase-starts", qualificationPhaseStarts);
		config.addDefault("ko-phase-starts", koPhaseStarts);
		config.addDefault("map-loads", mapLoads);
		config.addDefault("tournament-create", tournamentCreate);
		config.addDefault("chat-from-lobby", chatFromLobby);
		config.addDefault("kit-setting", kitSetting);
		config.addDefault("kit-setting-separator", kitSettingSeparator);
		config.addDefault("soups-left", soupsLeft);
		config.addDefault("soups-left-team", soupsLeftTeam);
		config.addDefault("end-match-spectator", endMatchSpectator);
		config.addDefault("stats", stats);
		config.addDefault("no-permission-stats-view", noPermissionStatsView);
		config.addDefault("your-statistics", yourStatistics);
		config.addDefault("statistics-of", statisticsOf);
		config.addDefault("player-doesnt-exists", playerDoesntExists);
		config.addDefault("got-elo", gotELO);
		config.addDefault("lost-elo", lostELO);
		config.addDefault("there-is-no-duel", thereIsNoDuel);
		config.addDefault("there-is-no-tournament", thereIsNoTournament);
		
		config.options().copyDefaults(true);
		
		try
		{
			config.save(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
	}
	
	public static String waitingForOtherPlayers(String seconds)
	{
		return waitingForOtherPlayers.replaceAll("%seconds%", seconds);
	}
	
	public static String duelStartsTimer(String seconds)
	{
		return duelStartsTimer.replaceAll("%seconds%", seconds);
	}
	
	public static String youAreFightingAgainst(String player)
	{
		return youAreFightingAgainst.replaceAll("%player%", player);
	}
	
	public static String youAreFightingAgainstFFA(String player)
	{
		return youAreFightingAgainstFFA.replaceAll("%player%", player);
	}
	
	public static String youAreFightingAgainstRanked(String player,int elo)
	{
		return youAreFightingAgainstRanked.replaceAll("%player%", player).replaceAll("%elo%",elo+"");
	}
	
	public static String hasLifeLeft(String player,String health)
	{
		return hasLifeLeft.replace("%player%", player).replaceAll("%health%", health);
	}
	
	public static String yourKit(String name,String settings)
	{
		return yourKit.replaceAll("%name%", name).replaceAll("%settings%", settings);
	}
	
	public static String mapLoads(String map)
	{
		return mapLoads.replaceAll("%map%", map);
	}
	
	public static String tournamentCreate(String prefix,String player,String size)
	{
		return tournamentCreate.replaceAll("%prefix%", prefix).replaceAll("%player%", player).replaceAll("%size%", size);
	}
	
	public static String chatFromLobby(String player,String message)
	{
		return chatFromLobby.replaceAll("%player%", player).replaceAll("%message%", message);
	}
	
	public static String kitSetting(String setting)
	{
		return kitSetting.replaceAll("%setting%", setting);
	}
	
	public static String soupsLeft(String player,int soups,int recrafts)
	{
		return soupsLeft.replaceAll("%player%", player).replaceAll("%soups%", soups+"").replaceAll("%recrafts%", recrafts+"");
	}
	
	public static String stats(int kills, int deaths, double kd, int plays, int wins, int loses, double round, int tournamentWins,int elo)
	{
		return stats.replaceAll("%kills%",kills+"").replaceAll("%deaths%", deaths+"").replaceAll("%kd%", kd+"").replaceAll("%plays%", plays+"").replaceAll("%wins%", wins+"").replaceAll("%loses%",loses+"").replaceAll("%winsperplays%",round+"").replaceAll("%tournaments%",tournamentWins+"").replaceAll("%elo%", elo+"");
	}
	
	public static String playerDoesntExists(String player)
	{
		return playerDoesntExists.replaceAll("%player%", player);
	}
	
	public static String statisticsOf(String player)
	{
		return statisticsOf.replaceAll("%player%", player);
	}
	
	public static String playerInHasLifeLeft(String player)
	{
		return playerInHasLifeLeft.replaceAll("%player%", player);
	}
	
	public static String hasLifeLeftTeam(String team,double health)
	{
		return hasLifeLeftTeam.replaceAll("%team%", team).replaceAll("%health%", health+"");
	}
	
	public static String soupsLeftTeam(String team,int soups,int recrafts)
	{
		return soupsLeftTeam.replaceAll("%team%", team).replaceAll("%soups%",soups+"").replaceAll("%recrafts%",recrafts+"");
	}
	
	public static String gotELO(int elo)
	{
		return gotELO.replaceAll("%elo%",elo+"");
	}
	
	public static String lostELO(int elo)
	{
		return lostELO.replaceAll("%elo%",elo+"");
	}
	
	private static void setValues()
	{
		tournamentWin = config.getString("tournament-win");
		tournamentLose = config.getString("tournament-lose");
		haveToBeInDuel = config.getString("have-to-be-in-duel");
		fixed = config.getString("fixed");
		waitingHousePlaced = config.getString("waitinghouse-placed");
		arenaNotThere = config.getString("arena-not-there");
		waitingForOtherPlayers = config.getString("waiting-for-other-players");
		pleaseRespawn = config.getString("please-respawn");
		arenaIsLoading = config.getString("arena-is-loading");
		arenaHasLoaded = config.getString("arena-has-loaded");
		duelStarts = config.getString("duel-starts");
		duelStartsTimer = config.getString("duel-starts-timer");
		youHaveWon = config.getString("you-have-won");
		youHaveLost = config.getString("you-have-lost");
		thereAreNoMaps = config.getString("there-are-no-maps");
		youAreFightingAgainst = config.getString("you-are-fighting-against");
		youAreFightingAgainstFFA = config.getString("you-are-fighting-against-ffa");
		youAreFightingAgainstRanked = config.getString("you-are-fighting-against-ranked");
		hasLifeLeft = config.getString("has-life-left");
		yourKit = config.getString("your-kit");
		thisIsntAllowedInTournament = config.getString("this-isnt-allowed-in-tournament");
		duelHasntBeenStarted = config.getString("duel-hasnt-been-started");
		duelIsOver = config.getString("duel-is-over");
		timerHasAlreadyBeenStarted = config.getString("timer-has-already-been-started");
		timerStarts = config.getString("timer-starts");
		nearestOneWins = config.getString("nearest-one-wins");
		oneMinuteLeft = config.getString("one-minute-left");
		qualificationPhaseStarts = config.getString("qualification-phase-starts");
		koPhaseStarts = config.getString("ko-phase-starts");
		mapLoads = config.getString("map-loads");
		tournamentCreate = config.getString("tournament-create");
		chatFromLobby = config.getString("chat-from-lobby");
		kitSetting = config.getString("kit-setting");
		kitSettingSeparator = config.getString("kit-setting-separator");
		soupsLeft = config.getString("soups-left");
		soupsLeftTeam = config.getString("soups-left-team");
		endMatchSpectator = config.getString("end-match-spectator");
		stats = config.getString("stats");
		noPermissionStatsView = config.getString("no-permission-stats-view");
		yourStatistics = config.getString("your-statistics");
		statisticsOf = config.getString("statistics-of");
		playerDoesntExists = config.getString("player-doesnt-exists");
		playerInHasLifeLeft = config.getString("player-in-has-life-left");
		seperatorInHasLifeLfeft = config.getString("seperator-in-has-life-left");
		hasLifeLeftTeam = config.getString("has-life-left-team");
		gotELO = config.getString("got-elo");
		lostELO = config.getString("lost-elo");
		thereIsNoDuel = config.getString("there-is-no-duel");
		thereIsNoTournament = config.getString("there-is-no-tournament");
	}
	
	public static void setup()
	{
		file = new File("plugins/" + MainClass.getInstance().getName() + "/messages.yml");
		config = YamlConfiguration.loadConfiguration(file);
		
		
		addDefaults();
		setValues();
	}
}
