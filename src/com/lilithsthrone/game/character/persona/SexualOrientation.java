package com.lilithsthrone.game.character.persona;

import com.lilithsthrone.utils.Colour;

/**
 * @since 0.1.79
 * @version 0.2.11
 * @author Innoxia
 */
public enum SexualOrientation {

	ANDROPHILIC("androphilic", Colour.MASCULINE),

	GYNEPHILIC("gynephilic",Colour.FEMININE),

	AMBIPHILIC("ambiphilic", Colour.ANDROGYNOUS);
	
	private String name;
	private Colour colour;

	private SexualOrientation(String name, Colour colour) {
		this.name = name;
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}
	
	public static SexualOrientation getEnum(String value) {
        if (value.equals("null")) {
        	return null;
        }
        for(SexualOrientation orientation : values())
            if(orientation.name().equalsIgnoreCase(value)) {
            	return orientation;
            }
        throw new IllegalArgumentException();
    }
	
}
