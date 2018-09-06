package com.lilithsthrone.game.dialogue.places.dominion.shoppingArcade;

import java.text.DecimalFormat;

import com.lilithsthrone.game.character.attributes.AffectionLevel;
import com.lilithsthrone.game.character.attributes.ObedienceLevel;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.dialogue.DialogueFlagValue;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.responses.ResponseEffectsOnly;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

/**
 * @since 0.2.11
 * @version 0.2.11
 * @author Max Nobody
 */
public class ServantsHall {

	public static final DialogueNodeOld EXTERIOR = new DialogueNodeOld("Servants' Hall (Exterior)", "-", false) {
		private static final long serialVersionUID = 1L;

		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_EXTERIOR");
		}
	
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				if (Main.game.getDialogueFlags().values.contains(DialogueFlagValue.wallaceIntroduced)) {
					return new Response("Enter", "Step inside the Servants' Hall", SLAVE_RENTAL_ENTRY_REPEAT);
				} else {
					return new Response("Enter", "Step inside the Servants' Hall", SLAVE_RENTAL_ENTRY);
				}
			} else if (index == 6) {
				return new ResponseEffectsOnly("Arcade Entrance", "Fast travel to the entrance to the arcade."){
					@Override
					public void effects() {
						Main.game.setActiveWorld(Main.game.getWorlds().get(WorldType.SHOPPING_ARCADE), PlaceType.SHOPPING_ARCADE_ENTRANCE, true);
					}
				};
			} else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_ENTRY = new DialogueNodeOld("Servants' Hall", "-", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_ENTRY");
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("I was curious...", "Answer you were just curious as to what kind of shop this was", SLAVE_RENTAL_INTRODUCTION) {
					@Override
					public void effects() {
						Main.game.getDialogueFlags().values.add(DialogueFlagValue.wallaceIntroduced);
						Main.game.getRecht().setLocation(WorldType.EMPTY, PlaceType.GENERIC_EMPTY_TILE, true); // This is only temporary until I'll need him for my grand project involving drama, passion, player enslavement, and A LOT OF DRAMA!
					}
				};
			} else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_INTRODUCTION = new DialogueNodeOld("Servants' Hall", "-", false) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_INTRODUCTION");
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("What the...?", "That was strange.", SLAVE_RENTAL_POST_WTF);
			} else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_POST_WTF = new DialogueNodeOld("Servants' Hall", "-", false) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_POST_WTF");
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Rent a slave", "You'd like to see which of his slaves are avaiable for renting<br>Not yet implemented ;.;", null);
			} else if (index == 2) {
				if (Main.game.getDialogueFlags().values.contains(DialogueFlagValue.freelanceSlaveTrained)) {
					return new Response("Freelance", "Take a freelancing contract<br>Not yet implemented ;.;", null);
				} else {
					return new Response("Freelance", "Begin training to become a freelancer slave<br>Not yet implemented ;.;", null);
				}
			} else if (index == 3) {
				if (Main.game.getDialogueFlags().values.contains(DialogueFlagValue.huntingExplained)) {
					return new Response("Hunting", "Take a hunting contract", SLAVE_RENTAL_HUNT_REPEAT);
				} else {
					return new Response("Hunting", "Take a hunting contract", SLAVE_RENTAL_HUNT);
				}
			} else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_ENTRY_REPEAT = new DialogueNodeOld("Servants' Hall", "-", false) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_ENTRY_REPEAT") ;
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Rent a slave", "You'd like to see which of his slaves are avaiable for renting<br>Not yet implemented ;.;", null);
			} else if (index == 2) {
				if (Main.game.getDialogueFlags().values.contains(DialogueFlagValue.freelanceSlaveTrained)) {
					return new Response("Freelance", "Take a freelancing contract<br>Not yet implemented ;.;", null);
				} else {
					return new Response("Freelance", "Begin training to become a freelancer slave<br>Not yet implemented ;.;", null);
				}
			} else if (index == 3) {
				if (Main.game.getPlayer().getActiveContract() != null) {
					return new Response("Contract", "About that contract you took...", SLAVE_RENTAL_CONTRACT);
				} else if (Main.game.getDialogueFlags().values.contains(DialogueFlagValue.huntingExplained)) {
					return new Response("Hunting", "Take a hunting contract<br>Not yet implemented ;.;", SLAVE_RENTAL_HUNT_REPEAT);
				} else {
					return new Response("Hunting", "Take a hunting contract<br>Not yet implemented ;.;", SLAVE_RENTAL_HUNT);
				}
			} else {
				return null;
			}
		}

		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT = new DialogueNodeOld("Servants' Hall", "-", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_HUNT_EXPLAIN");
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Choose contract", "Choose a target to hunt", SLAVE_RENTAL_HUNT_CHOOSE);
			} else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT_REPEAT = new DialogueNodeOld("Servants' Hall", "-", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_HUNT_REPEAT");
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Choose contract", "Choose a target to hunt", SLAVE_RENTAL_HUNT_CHOOSE);
			} else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT_CHOOSE = new DialogueNodeOld("Servants' Hall", "-", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() { 
			if (Main.game.getPlayer().getAvailableContracts() != null && Main.game.getPlayer().getAvailableContracts().size() == 5) {
				return Main.game.getPlayer().getAvailableContracts().get(0).getDescription(1)
						+ "<br><br>"
						+ Main.game.getPlayer().getAvailableContracts().get(1).getDescription(2)
						+ "<br><br>"
						+ Main.game.getPlayer().getAvailableContracts().get(2).getDescription(3)
						+ "<br><br>"
						+ Main.game.getPlayer().getAvailableContracts().get(3).getDescription(4)
						+ "<br><br>"
						+ Main.game.getPlayer().getAvailableContracts().get(4).getDescription(5);
			} else {
				return "Standby while I analyze the intelligence profile of Max Nobody...<br>Error! Not a number! Did the player enjoy this witticism?";
			}
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Take first contract", "Take the first contract proposed", SLAVE_RENTAL_HUNT_CHOSEN) {
					@Override
					public void effects() {
						Main.game.getPlayer().setActiveContract(0);
					}
				};
			}
			if (index == 2) {
				return new Response("Take second contract", "Take the second contract proposed", SLAVE_RENTAL_HUNT_CHOSEN) {
					@Override
					public void effects() {
						Main.game.getPlayer().setActiveContract(1);
					}
				};
			}
			if (index == 3) {
				return new Response("Take third contract", "Take the third contract proposed", SLAVE_RENTAL_HUNT_CHOSEN) {
					@Override
					public void effects() {
						Main.game.getPlayer().setActiveContract(2);
					}
				};
			}
			if (index == 4) {
				return new Response("Take fourth contract", "Take the fourth contract proposed", SLAVE_RENTAL_HUNT_CHOSEN) {
					@Override
					public void effects() {
						Main.game.getPlayer().setActiveContract(3);
					}
				};
			}
			if (index == 5) {
				return new Response("Take fifth contract", "Take the fifth contract proposed", SLAVE_RENTAL_HUNT_CHOSEN) {
					@Override
					public void effects() {
						Main.game.getPlayer().setActiveContract(4);
					}
				};
			}
			if (index == 0) {
				return new Response("Back", "Don't take any contract", SLAVE_RENTAL_HUNT_REFUSE);
			}
			else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT_CHOSEN = new DialogueNodeOld("Servants' Hall", "-", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_HUNT_CHOSEN");
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Leave", "Leave the shop to complete your hunt", EXTERIOR);
			}
			else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT_REFUSE = new DialogueNodeOld("Servants' Hall", "-", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_HUNT_REFUSE");
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Leave", "Leave the shop", EXTERIOR);
			}
			else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_CONTRACT = new DialogueNodeOld("Servants' Hall", "-", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_HUNT_CONTRACT")+"<p>"+Main.game.getPlayer().getActiveContract().getDescription(0)+"</p>";
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("This is my slave", "Choose which slave you want to sell Wallace", SLAVE_RENTAL_HUNT_LIST);
			} else if (index == 2) {
				return new Response("Give up", "The contract is too hard...", null) {
					@Override
					public void effects() {
						Main.game.getPlayer().setActiveContract(null);
					}
				};
			} else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT_LIST = new DialogueNodeOld("Slave Selection", ".", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() { // TODO : Add a function in SlaveryManagementDialogue to be able to use getSlaveryHeader and getSlaveryEntry. -Max Nobody
			DecimalFormat decimalFormat = new DecimalFormat("#0.00");
			UtilText.nodeContentSB.setLength(0);
			UtilText.nodeContentSB.append("<div class='container-full-width' style='margin-bottom:0;'>"
					+ "<div style='width:20%; float:left; font-weight:bold; margin:0; padding:0;'>"
					+ "Slave"
				+ "</div>"
				+ "<div style='width:20%; float:left; font-weight:bold; margin:0; padding:0;'>"
					+ "Location"
				+ "</div>"
				+ "<div style='float:left; width:15%; font-weight:bold; margin:0; padding:0;'>"
					+ "<b style='color:"+Colour.AFFECTION.toWebHexString()+";'>Affection</b>"
				+"</div>"
				+ "<div style='float:left; width:15%; font-weight:bold; margin:0; padding:0;'>"
					+ "<b style='color:"+Colour.OBEDIENCE.toWebHexString()+";'>Obedience</b>"
				+"</div>"
				+ "<div style='float:left; width:15%; font-weight:bold; margin:0; padding:0;'>"
					+ "<b style='color:"+Colour.CURRENCY_GOLD.toWebHexString()+";'>Value</b>"
				+"</div>"
			+ "</div>");
			int i = 0;
			for(String id : Main.game.getPlayer().getSlavesOwned()) {
				NPC slave = (NPC) Main.game.getNPCById(id);
				AffectionLevel affection = AffectionLevel.getAffectionLevelFromValue(slave.getAffection(Main.game.getPlayer()));
				ObedienceLevel obedience = ObedienceLevel.getObedienceLevelFromValue(slave.getObedienceValue());
				float affectionChange = slave.getDailyAffectionChange();
				float obedienceChange = slave.getDailyObedienceChange();
//				GenericPlace place = Main.game.getPlayerCell().getPlace(); // ?
				
				UtilText.nodeContentSB.append("<div class='container-full-width inner' style='margin-bottom:0;"+(i%2==0?"background:"+Colour.BACKGROUND_ALT.toWebHexString()+";'":"'")+"'>"
				+ "<div style='width:20%; float:left; margin:0; padding:0;'>"
					+ "<b style='color:"+slave.getFemininity().getColour().toWebHexString()+";'>"+slave.getName()+"</b><br/>"
					+ "<span style='color:"+slave.getRace().getColour().toWebHexString()+";'>"+Util.capitaliseSentence((slave.isFeminine()?slave.getSubspecies().getSingularFemaleName():slave.getSubspecies().getSingularMaleName()))+"</span><br/>"
					+ "<span style='color:"+slave.getFemininity().getColour().toWebHexString()+";'>"+Util.capitaliseSentence(slave.getGender().getName())+"</span>"
				+ "</div>"
				+ "<div style='width:20%; float:left; margin:0; padding:0;'>"
					+ "<b style='color:"+slave.getLocationPlace().getColour().toWebHexString()+";'>"+slave.getLocationPlace().getName()+"</b>"
					+",<br/>"
					+ "<span style='color:"+slave.getWorldLocation().getColour().toWebHexString()+";'>"+slave.getWorldLocation().getName()+"</span>"
				+ "</div>"
				+ "<div style='float:left; width:15%; margin:0; padding:0;'>"
					+ "<b style='color:"+affection.getColour().toWebHexString()+";'>"+slave.getAffection(Main.game.getPlayer())+ "</b>"
					+ "<br/><span style='color:"+(affectionChange==0?Colour.BASE_GREY:(affectionChange>0?Colour.GENERIC_GOOD:Colour.GENERIC_BAD)).toWebHexString()+";'>"+(affectionChange>0?"+":"")
						+decimalFormat.format(affectionChange)+"</span>/day"
					+ "<br/>"
					+ "<span style='color:"+affection.getColour().toWebHexString()+";'>"+Util.capitaliseSentence(affection.getName())+"</span>"
				+"</div>"
				+ "<div style='float:left; width:15%; margin:0; padding:0;'>"
					+ "<b style='color:"+obedience.getColour().toWebHexString()+";'>"+slave.getObedienceValue()+ "</b>"
					+ "<br/><span style='color:"+(obedienceChange==0?Colour.BASE_GREY:(obedienceChange>0?Colour.GENERIC_GOOD:Colour.GENERIC_BAD)).toWebHexString()+";'>"+(obedienceChange>0?"+":"")
						+decimalFormat.format(obedienceChange)+"</span>/day"
					+ "<br/>"
					+ "<span style='color:"+obedience.getColour().toWebHexString()+";'>"+Util.capitaliseSentence(obedience.getName())+"</span>"
				+"</div>"
				+ "<div style='float:left; width:15%; margin:0; padding:0;'>"
					+ (Main.game.getDialogueFlags().getSlaveTrader()!=null
						?UtilText.formatAsMoney((int) (slave.getValueAsSlave()*Main.game.getDialogueFlags().getSlaveTrader().getBuyModifier()), "b", Colour.GENERIC_ARCANE)
						:UtilText.formatAsMoney(slave.getValueAsSlave()))+"<br/>"
					+ "<b>"+Util.capitaliseSentence(slave.getSlaveJob().getName(slave))+"</b><br/>"
					+ UtilText.formatAsMoney(slave.getSlaveJob().getFinalDailyIncomeAfterModifiers(slave))+"/day"
				+"</div></div>");
				i++;
			}
			return (UtilText.nodeContentSB.toString());
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			int i = 0;
			for(String id : Main.game.getPlayer().getSlavesOwned()) {
				NPC slave = (NPC) Main.game.getNPCById(id);
				if ((i < 15 ? i == index - 1 : i == index) || (i == 15 && index == 0)) {
					return new Response (slave.getName(), "Give "+slave.getName()+" to Wallace", SLAVE_RENTAL_HUNT_CHECK) {
						@Override
						public void effects() {
							slave.setLocation(WorldType.SHOPPING_ARCADE, PlaceType.SHOPPING_ARCADE_SERVANTS_HALL, true);
						}
					};
				}
				i++;
			}
			while (i%15 != 0) {
				i++;
			}
			if (i == 15 ? index == 0 : i == index) {
				return new Response ("Back", "On second thoughts...", EXTERIOR);
			}
			return null;
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT_CHECK = new DialogueNodeOld("Servants' Hall", "-", true) {
		private static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			UtilText.nodeContentSB.setLength(0);
			UtilText.nodeContentSB.append("<p>You approach the counter, where Wallace awaits you with a predatory smile.</p>"
					+ "<p>[pc.speech(Here's my catch)], you announce"
					+ "<p>[wallace.speech(Oh, nice, really nice! Eirwen!)]</p>"
					+ "<p>The fox-girl, as rigid as usual, step forwards</p>"
					+ "<p>[eirwen.speech(Yes, Master Wallace?)]</p>"
					+ "<p>[wallace.speech(Please check our \"gift\" from [pc.name] matches the contract. There, here's the list.)]</p>"
					+ "<p>[eirwen.speech(Alright, Master Wallace.)]</p>"
					+ "<p>The fox-girl approaches your catch and brutally catch it, before roughly dragging [npc"+ServantsHall.targetSlaveGiven()+".him] to the chains on the left wall. With an expert hand, she attaches [npc"+ServantsHall.targetSlaveGiven()+".name]'s limbs to the wall, and begins examining [npc"+ServantsHall.targetSlaveGiven()+".him] from every angle.</p>");
			return UtilText.nodeContentSB.toString();
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				if (Main.game.getPlayer().getActiveContract().isMatchContract(Main.game.getNonCompanionCharactersPresent().get(targetSlaveGiven() - 1))) {
					return new Response("Next", "Let Eirwen check your slave", SLAVE_RENTAL_HUNT_VALID) {
						@Override
						public void effects() {
							Main.game.getPlayer().incrementMoney((int)(Main.game.getNonCompanionCharactersPresent().get(targetSlaveGiven() - 1).getValueAsSlave() * Main.game.getPlayer().getActiveContract().getValueMultiplier()));
							Main.game.getWallace().addSlave(Main.game.getNonCompanionCharactersPresent().get(targetSlaveGiven() - 1));
							Main.game.getPlayer().setActiveContract(null);
						}
					};
				}
				return new Response("Next", "Let Eirwen check your slave", SLAVE_RENTAL_HUNT_INVALID);
			} else {
				return null;
			}
		}
		
		@Override
		public String getAuthor() {
			return "Max Nobody";
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT_VALID = new DialogueNodeOld ("Servants' Hall", "-", true) {
		public static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_HUNT_COMPLETE")+"<br><br>You gained " + Math.floor(Main.game.getNonCompanionCharactersPresent().get(targetSlaveGiven() - 1).getValueAsSlave() * Main.game.getPlayer().getActiveContract().getValueMultiplier()) + " flames";
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response ("Leave", "You gained money! You can leave now", EXTERIOR) {
					@Override
					public void effects() {
						Main.game.getNonCompanionCharactersPresent().get(targetSlaveGiven() - 1).setLocation(WorldType.EMPTY, PlaceType.GENERIC_EMPTY_TILE, true); // Temporary until Wallace's basement with all his slaves are added
					}
				};
			} else {
				return null;
			}
		}
		
		private int targetSlaveGiven() {
			int i = 1;
			for (NPC target : Main.game.getNonCompanionCharactersPresent()) {
				if (!target.isUnique() && Main.game.getPlayer().hasCompanion(target)) {
					return i;
				}
				i++;
			}
			return 1;
		}
	};
	
	public static final DialogueNodeOld SLAVE_RENTAL_HUNT_INVALID = new DialogueNodeOld ("Servants' Hall", "-", true) {
		public static final long serialVersionUID = 1L;
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/shoppingArcade/servantsHall", "SERVANTS_HALL_HUNT_FAIL");
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response ("Oh sh*t!", "Dammit!", EXTERIOR) {
					@Override
					public void effects() {
						Main.game.getNonCompanionCharactersPresent().get(ServantsHall.targetSlaveGiven() - 1).setLocation(WorldType.SLAVER_ALLEY, PlaceType.SLAVER_ALLEY_SLAVERY_ADMINISTRATION, true);
					}
				};
			} else {
				return null;
			}
		}
	};
	
	private static int targetSlaveGiven() {
		int i = 1;
		for (NPC target : Main.game.getNonCompanionCharactersPresent()) {
			if (!target.isUnique()) {
				return i;
			}
			i++;
		}
		return 1;
	}
}
