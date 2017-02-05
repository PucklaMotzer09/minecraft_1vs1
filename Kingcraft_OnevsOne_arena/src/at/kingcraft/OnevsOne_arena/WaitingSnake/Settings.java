package at.kingcraft.OnevsOne_arena.WaitingSnake;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import MySQL.MySQL;

public class Settings
{
	public static final int OWN_KIT_MODE = 0;
	public static final int RANDOM_KIT_MODE = 1;
	public static final int NO_KIT_MODE = 2;
	public static final int OWN_MAP_MODE = 0;
	public static final int NO_MAP_MODE = 1;
	
	private static HashMap<UUID,Settings> playerSettings;
	private static MySQL mysql;
	
	private Player owner;
	private int kitMode;
	private int mapMode;
	private boolean quickWS;
	private boolean addToWSOnJoin;
	private String oldSettings;
	
	public static void setup(MySQL mysql)
	{
		playerSettings = new HashMap<>();
		Settings.mysql = mysql;
	}
	
	public Settings(Player owner,int kitMode,int mapMode,boolean qWS,boolean aTWSOJ)
	{
		this.owner = owner;
		quickWS = qWS;
		addToWSOnJoin = aTWSOJ;
		this.kitMode = kitMode;
		this.mapMode = mapMode;
	}
	
	public void setOldSettings(String os)
	{
		oldSettings = os;
	}
	
	public int getKitMode()
	{
		return kitMode;
	}
	
	public boolean isQuickWS()
	{
		return quickWS;
	}
	
	public boolean addToWSOnJoin()
	{
		return addToWSOnJoin;
	}
	
	public void addToWSOnJoin(boolean aoj)
	{
		addToWSOnJoin = aoj;
	}
	
	public static Settings fromString(String str)
	{
		String[] set = str.split("\n");
		int kitMode = Integer.valueOf(set[0]);
		boolean qws = Boolean.valueOf(set[1]);
		boolean aoj = Boolean.valueOf(set[2]);
		int mapMode = Integer.valueOf(set[3]);
		
		return new Settings(null,kitMode,mapMode,qws,aoj);
	}
	
	public void setOwner(Player owner)
	{
		if(this.owner == null)
		{
			this.owner = owner;
		}
	}
	
	public boolean same(Settings set)
	{
		if(this.kitMode == set.getKitMode())
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		String set = String.valueOf(getKitMode()) + "\n";
		set += String.valueOf(quickWS)+ "\n";
		set += String.valueOf(addToWSOnJoin) +"\n";
		set += String.valueOf(mapMode);
		
		return set;
	}
	
	public void loadToMySQL()
	{
		if(!this.toString().equals(oldSettings) &&  mysql.isConnected() && owner != null)
		{
			try
			{
				PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT UUID FROM Duel_Settings_Players WHERE UUID = ?");
				ps.setString(1, owner.getUniqueId().toString());
				ResultSet rs = ps.executeQuery();
				
				if(rs.first())
				{
					ps = mysql.getConnection().prepareStatement("UPDATE Duel_Settings_Players SET Settings = ? WHERE UUID = ?");
					ps.setString(1, this.toString());
					ps.setString(2, owner.getUniqueId().toString());
					ps.executeUpdate();
				}
				else
				{
					ps.close();
					ps = mysql.getConnection().prepareStatement("INSERT INTO Duel_Settings_Players (UUID,Settings) VALUES (?,?)");
					ps.setString(1, owner.getUniqueId().toString());
					ps.setString(2, this.toString());
					ps.executeUpdate();
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void loadSettings(Player p)
	{
		if(mysql.isConnected())
		{
			try
			{
				PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT Settings FROM Duel_Settings_Players WHERE UUID = ?");
				ps.setString(1, p.getUniqueId().toString());
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					Settings set = Settings.fromString(rs.getString(1));
					set.setOwner(p);
					set.setOldSettings(rs.getString(1));
					
					playerSettings.put(p.getUniqueId(), set);
				}
				
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		if(playerSettings.get(p.getUniqueId()) == null)
		{
			Settings set = new Settings(p,Settings.NO_KIT_MODE,Settings.NO_MAP_MODE,false,false);
			set.setOldSettings(set.toString());
			
			playerSettings.put(p.getUniqueId(),set);
		}
	}
	
	public static void setSettings(Player p,Settings set)
	{
		playerSettings.put(p.getUniqueId(), set);
	}
	
	public static Settings getSettings(Player p)
	{
		if(playerSettings.get(p.getUniqueId()) == null)
		{
			playerSettings.put(p.getUniqueId(), new Settings(p,Settings.NO_KIT_MODE,Settings.NO_MAP_MODE,false,false));
		}
		return playerSettings.get(p.getUniqueId());
	}
	
	public static void removeSettings(Player p)
	{
		playerSettings.remove(p.getUniqueId());
	}

	public void setQuickWS(boolean b)
	{
		quickWS = b;
	}
	

}