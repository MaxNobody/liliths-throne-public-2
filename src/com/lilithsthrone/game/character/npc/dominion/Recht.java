package com.lilithsthrone.game.character.npc.dominion;

import java.time.Month;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.lilithsthrone.game.character.CharacterImportSetting;
import com.lilithsthrone.game.character.body.Covering;
//import com.lilithsthrone.game.character.body.valueEnums.BodyHair;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.valueEnums.PenisSize;
//import com.lilithsthrone.game.character.body.valueEnums.TesticleSize;
//import com.lilithsthrone.game.character.body.valueEnums.HairLength;
//import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
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

// I know making a whole NPC class for just one scene might seem overkill, but I have some plans for him once player enslavement gets added.

public class Recht extends NPC {

	public Recht() {
		this(false);
	}
	
	public Recht(boolean isImported) {
		super(new NameTriplet("Recht"),
				"Recht works as a slave Hunter for Wallace's shop, the Servants' Hall.", 
				36, Month.JANUARY, 28,
				15,
				Gender.M_P_MALE,
				RacialBody.ALLIGATOR_MORPH, RaceStage.GREATER, new CharacterInventory(10),
				WorldType.SHOPPING_ARCADE, PlaceType.SHOPPING_ARCADE_SERVANTS_HALL, true);

		this.setPersonality(Util.newHashMapOfValues(
				new Value<>(PersonalityTrait.AGREEABLENESS, PersonalityWeight.LOW),
				new Value<>(PersonalityTrait.CONSCIENTIOUSNESS, PersonalityWeight.HIGH),
				new Value<>(PersonalityTrait.EXTROVERSION, PersonalityWeight.LOW),
				new Value<>(PersonalityTrait.NEUROTICISM, PersonalityWeight.LOW),
				new Value<>(PersonalityTrait.ADVENTUROUSNESS, PersonalityWeight.HIGH)));
		
		if(!isImported) {
			this.setSexualOrientation(SexualOrientation.GYNEPHILIC);
			
			this.setEyeCovering(new Covering(BodyCoveringType.EYE_ALLIGATOR_MORPH, Colour.EYE_BROWN));
			this.setHairCovering(new Covering(BodyCoveringType.HAIR_SCALES_ALLIGATOR, Colour.COVERING_BLACK), true);
			this.setSkinCovering(new Covering(BodyCoveringType.ALLIGATOR_SCALES, Colour.COVERING_GREEN), true);
			
			this.setBodySize(90);
			this.setMuscle(90);
			this.setHeight(190);
			
			this.setFemininity(0);
			this.setPenisSize(PenisSize.FOUR_HUGE.getMedianValue());
			this.setPenisVirgin(false);
			
			this.addFetish(Fetish.FETISH_DOMINANT);
			this.addFetish(Fetish.FETISH_SADIST);
			this.addFetish(Fetish.FETISH_NON_CON_DOM);
			
			this.setFetishDesire(Fetish.FETISH_VAGINAL_GIVING, FetishDesire.FOUR_LOVE);
			this.setFetishDesire(Fetish.FETISH_ANAL_GIVING, FetishDesire.FOUR_LOVE);
			this.setFetishDesire(Fetish.FETISH_DEFLOWERING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_IMPREGNATION, FetishDesire.ONE_DISLIKE);
			this.setFetishDesire(Fetish.FETISH_ANAL_RECEIVING, FetishDesire.ZERO_HATE);
			
			this.setMoney(10);
			
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.EYES_PATCH, Colour.CLOTHING_BLACK, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.TORSO_SHORT_SLEEVE_SHIRT, Colour.CLOTHING_GREEN, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.LEG_CARGO_TROUSERS, Colour.CLOTHING_TAN, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.GROIN_BOXERS, Colour.CLOTHING_BLACK, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.SOCK_SOCKS, Colour.CLOTHING_WHITE, false), true, this);
			this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.FOOT_WORK_BOOTS, Colour.CLOTHING_BROWN_DARK, false), true, this);
			
			
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
