package at.Kingcraft.OnevsOne_lobby.Special;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.Kingcraft.OnevsOne_lobby.Duels.Team;
import at.Kingcraft.OnevsOne_lobby.Duels.TeamManager;
import at.Kingcraft.OnevsOne_lobby.Kits.Kit;
import at.Kingcraft.OnevsOne_lobby.Kits.KitManager;
import at.Kingcraft.OnevsOne_lobby.WaitingSnake.RankedQueue;
import net.md_5.bungee.api.ChatColor;

public class RankedMenu extends Menu
{
	private static final int KIT1_POS = 11;
	private static final int KIT2_POS = 13;
	private static final int KIT3_POS = 15;
	private static final int TOP_POS = 31;
	private boolean inRanked = false; 
	
	public RankedMenu(Player owner)
	{
		super(owner, 45, "Ranked (ELO:" + RankedQueue.getELO(owner) + ")", null);
	}
	
	@Override
	protected void setInventoryContents()
	{
		inRanked = true;
		
		toogleLeaveItem();
	}
	
	public void toogleLeaveItem()
	{
		inRanked = !inRanked;
		
		if(!inRanked)
		{
			for(int i = 0;i<inventory.getSize();i++)
			{
				inventory.setItem(i, new ItemStack(Material.AIR));
			}
			
			Kit kit1 = KitManager.getPreKit(15);
			Kit kit2 = KitManager.getPreKit(16);
			Kit kit3 = KitManager.getPreKit(17);
			
			ItemStack top = new ItemStack(Material.EMERALD);
			{
				ItemMeta im = top.getItemMeta();
				im.setDisplayName(ChatColor.YELLOW + "Top-Spieler");
				ArrayList<String> lore = new ArrayList<>();
				lore.add(ChatColor.WHITE + "Hinter diesem Edelstein");
				lore.add(ChatColor.WHITE + "verbergen sich die besten Spieler");
				lore.add(ChatColor.WHITE + "des Netzwerkes");
				im.setLore(lore);
				top.setItemMeta(im);
			}
			
			inventory.setItem(KIT1_POS, kit1.getSymbol(true));
			inventory.setItem(KIT2_POS, kit2.getSymbol(true));
			inventory.setItem(KIT3_POS, kit3.getSymbol(true));
			inventory.setItem(TOP_POS, top);
		}
		else
		{
			ItemStack leave = new ItemStack(Material.INK_SACK,1,(short)1);
			ItemMeta im = leave.getItemMeta();
			im.setDisplayName(ChatColor.RED + "Warteschlange verlassen");
			leave.setItemMeta(im);
			
			for(int i = 0;i<inventory.getSize();i++)
			{
				inventory.setItem(i, leave);
			}
		}
	}

	@Override
	public void onClick(int slot, ClickType ct)
	{
		int kit = -1;
		
		if(ct.isLeftClick())
		{
			if(!inRanked)
			{
				if(slot == TOP_POS)
				{
					MenuManager.getTopMenu(owner).open();
				}
				else
				{
					switch(slot)
					{
					case KIT1_POS:
						kit = 0;
						break;
					case KIT2_POS:
						kit = 1;
						break;
					case KIT3_POS:
						kit = 2;
						break;
					}
					
					if(kit != -1)
					{
						Team t = TeamManager.getTeam(owner);
						if(t == null)
						{
							RankedQueue.addPlayer(owner, kit);
							toogleLeaveItem();
							close();
						}
						return;
					}
				}
			}
			else
			{
				RankedQueue.removePlayer(owner);
				toogleLeaveItem();
				close();
			}
		}	
	}
}
