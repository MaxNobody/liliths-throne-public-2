package com.lilithsthrone.game.character.npc.dominion;

import java.time.Month;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.lilithsthrone.game.character.CharacterImportSetting;
import com.lilithsthrone.game.character.body.Covering;
// import com.lilithsthrone.game.inventory.enchanting.ItemEffect;
import com.lilithsthrone.game.character.body.valueEnums.BodyHair;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.valueEnums.HairLength;
// import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
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
//import com.lilithsthrone.game.inventory.AbstractCoreItem;
import com.lilithsthrone.game.inventory.CharacterInventory;
//import com.lilithsthrone.game.inventory.ItemTag;
//import com.lilithsthrone.game.inventory.Rarity;
//import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
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
public class Eirwen extends NPC {

	public Eirwen() {
		this(false);
	}
	
	public Eirwen(boolean isImported) {
		super(new NameTriplet("Eirwen"),
				"Eirwen is the head slave for Wallace at the Servants' Hall."
						+ "Always calm and composed, she maintains a haughty pose at all time.",
				28, Month.MARCH, 4,
				10,
				Gender.F_V_B_FEMALE,
				RacialBody.FOX_MORPH, RaceStage.GREATER, new CharacterInventory(10),
				WorldType.SHOPPING_ARCADE, PlaceType.SHOPPING_ARCADE_SERVANTS_HALL, true);

		this.setPersonality(Util.newHashMapOfValues(
				new Value<>(PersonalityTrait.AGREEABLENESS, PersonalityWeight.LOW),
				new Value<>(PersonalityTrait.CONSCIENTIOUSNESS, PersonalityWeight.HIGH),
				new Value<>(PersonalityTrait.EXTROVERSION, PersonalityWeight.LOW),
				new Value<>(PersonalityTrait.NEUROTICISM, PersonalityWeight.LOW),
				new Value<>(PersonalityTrait.ADVENTUROUSNESS, PersonalityWeight.AVERAGE)));
		
		if(!isImported) {
			this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
			
			this.setEyeCovering(new Covering(BodyCoveringType.EYE_FOX_MORPH, Colour.EYE_GREEN));
			this.setHairCovering(new Covering(BodyCoveringType.HAIR_FOX_FUR, Colour.COVERING_WHITE), true);
			this.setHairLength(HairLength.FOUR_MID_BACK.getMedianValue());
			this.setSkinCovering(new Covering(BodyCoveringType.FOX_FUR, Colour.COVERING_SILVER), true);
			this.setPubicHair(BodyHair.ZERO_NONE);
			
			this.setBodySize(25);
			this.setMuscle(30);
			this.setHeight(175);
			
			this.setFemininity(75);
			this.setAssVirgin(false);
			this.setFaceVirgin(false);
			this.setVaginaVirgin(false);
			this.setBreastSize(8);
			
			this.addFetish(Fetish.FETISH_DOMINANT);
			this.addFetish(Fetish.FETISH_SUBMISSIVE);
			this.addFetish(Fetish.FETISH_MASOCHIST);
			this.addFetish(Fetish.FETISH_EXHIBITIONIST);
			
			this.setFetishDesire(Fetish.FETISH_VAGINAL_RECEIVING, FetishDesire.FOUR_LOVE);
			this.setFetishDesire(Fetish.FETISH_ANAL_RECEIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_BREASTS_SELF, FetishDesire.THREE_LIKE);
			
			this.setMoney(10);
			
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.NECK_SLAVE_COLLAR, Colour.CLOTHING_GOLD, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.GROIN_CROTCHLESS_THONG, Colour.CLOTHING_WHITE, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.CHEST_OPEN_CUP_BRA, Colour.CLOTHING_WHITE, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.FOOT_HEELS, Colour.CLOTHING_WHITE, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.FINGER_RING, Colour.CLOTHING_GOLD, false), true, this);
			
			
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
