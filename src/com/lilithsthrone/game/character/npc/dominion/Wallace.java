package com.lilithsthrone.game.character.npc.dominion;

import java.time.Month;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.lilithsthrone.game.character.CharacterImportSetting;
import com.lilithsthrone.game.character.body.Covering;
import com.lilithsthrone.game.character.body.valueEnums.BodyHair;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.valueEnums.PenisSize;
import com.lilithsthrone.game.character.body.valueEnums.TesticleSize;
import com.lilithsthrone.game.character.body.valueEnums.HairLength;
import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
import com.lilithsthrone.game.character.fetishes.Fetish;
import com.lilithsthrone.game.character.fetishes.FetishDesire;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.persona.NameTriplet;
import com.lilithsthrone.game.character.persona.PersonalityTrait;
import com.lilithsthrone.game.character.persona.PersonalityWeight;
import com.lilithsthrone.game.character.persona.SexualOrientation;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.game.slavery.HuntingContract;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

/**
 * @since 0.2.11
 * @version 0.2.11
 * @author Max Nobody
 */
public class Wallace extends NPC {

	public Wallace() {
		this(false);
	}
	
	public Wallace(boolean isImported) {
		super(new NameTriplet("Wallace"),
				"Wallace manages the Servant's Hall shop in the Shopping Arcade."
						+ "He appears nice and friendly, yet, every occasion he has to, he reminds you he's dangerous.", 
				24, Month.JULY, 12,
				25,
				Gender.M_P_MALE,
				RacialBody.WOLF_MORPH, RaceStage.GREATER, new CharacterInventory(10),
				WorldType.SHOPPING_ARCADE, PlaceType.SHOPPING_ARCADE_SERVANTS_HALL, true);

		this.setPersonality(Util.newHashMapOfValues(
				new Value<>(PersonalityTrait.AGREEABLENESS, PersonalityWeight.AVERAGE),
				new Value<>(PersonalityTrait.CONSCIENTIOUSNESS, PersonalityWeight.HIGH),
				new Value<>(PersonalityTrait.EXTROVERSION, PersonalityWeight.AVERAGE),
				new Value<>(PersonalityTrait.NEUROTICISM, PersonalityWeight.LOW),
				new Value<>(PersonalityTrait.ADVENTUROUSNESS, PersonalityWeight.HIGH)));
		
		if(!isImported) {
			this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
			
			this.setEyeCovering(new Covering(BodyCoveringType.EYE_LYCAN, Colour.EYE_BLUE));
			this.setHairCovering(new Covering(BodyCoveringType.HAIR_LYCAN_FUR, Colour.COVERING_BLACK), true);
			this.setHairLength(HairLength.TWO_SHORT.getMedianValue());
			this.setHairStyle(HairStyle.SLICKED_BACK);
			this.setSkinCovering(new Covering(BodyCoveringType.LYCAN_FUR, Colour.COVERING_GREY), true);
			this.setPubicHair(BodyHair.ZERO_NONE);
			
			this.setBodySize(50);
			this.setMuscle(30);
			this.setHeight(182);
			
			this.setPenisSize(PenisSize.THREE_LARGE.getMaximumValue());
			this.setTesticleSize(TesticleSize.THREE_LARGE.getValue());
			this.setFemininity(30);
			this.setPenisVirgin(false);
			
			this.addFetish(Fetish.FETISH_DOMINANT);
			this.addFetish(Fetish.FETISH_SADIST);
			this.addFetish(Fetish.FETISH_NON_CON_DOM);
			this.addFetish(Fetish.FETISH_EXHIBITIONIST);
	
			this.setFetishDesire(Fetish.FETISH_VAGINAL_GIVING, FetishDesire.FOUR_LOVE);
			this.setFetishDesire(Fetish.FETISH_ORAL_GIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_PENIS_GIVING, FetishDesire.FOUR_LOVE);
			
			this.setMoney(10);
			
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.TORSO_OXFORD_SHIRT, Colour.CLOTHING_WHITE, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.WRIST_MENS_WATCH, Colour.CLOTHING_GOLD, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.FINGER_RING, Colour.CLOTHING_GOLD, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.LEG_TROUSERS, Colour.CLOTHING_BLACK, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.GROIN_BOXERS, Colour.CLOTHING_BLACK, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.FOOT_MENS_SMART_SHOES, Colour.CLOTHING_BLACK, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.SOCK_SOCKS, Colour.CLOTHING_WHITE, false), true, this);
			
			dailyReset();
		}
	}
	
	@Override
	public void loadFromXML(Element parentElement, Document doc, CharacterImportSetting... settings) {
		loadNPCVariablesFromXML(this, null, parentElement, doc, settings);
	}

	@Override
	public boolean isUnique() {
		return true;
	}

	@Override
	public void dailyReset() {
		if (Main.game.getPlayer().getAvailableContracts() == null) {
			Main.game.getPlayer().setAvailableContracts(new ArrayList<HuntingContract>());
		}
		Main.game.getPlayer().getAvailableContracts().removeAll(Main.game.getPlayer().getAvailableContracts());
		for (int i = 0; i < 5; i++) {
			Main.game.getPlayer().getAvailableContracts().add(new HuntingContract());
		}
		// TODO : Add slaves for rent
		// TODO : Add freelancing contracts
	}
	
	@Override
	public void changeFurryLevel(){
	}
	
	@Override
	public DialogueNodeOld getEncounterDialogue() {
		return null;
	}

	@Override
	public void endSex() {
	}
}
