package com.vishal.si.struct;

import java.io.Serializable;

public class Scaffold implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005528652174003921L;
	/**
	 * @param args
	 */
	
	private String IUPACname;

    public String getBMframework() {
        return BMframework;
    }

    public void setBMframework(String BMframework) {
        this.BMframework = BMframework;
    }

    public String getIUPACname() {
        return IUPACname;
    }

    public void setIUPACname(String IUPACname) {
        this.IUPACname = IUPACname;
    }

    public Double getLogP() {
        return logP;
    }

    public void setLogP(Double logP) {
        this.logP = logP;
    }
        private String BMframework;
	private Double logP;

    public String getUniqueSmile() {
        return UniqueSmile;
    }

    public void setUniqueSmile(String UniqueSmile) {
        this.UniqueSmile = UniqueSmile;
    }
        private String UniqueSmile;

}
