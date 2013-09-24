package com.vishal.si.struct;

import java.io.Serializable;

public class Drug implements Serializable {

    /**
     *
     */
    private  final long serialVersionUID = -4187137408422278816L;
    /**
     * @param args
     */
    private String name;
    private String uniqueSMILE;
    private String indication;
    private String drugbankID;
    private String logP;
    private String status;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the uniqueSMILE
     */
    public String getUniqueSMILE() {
        return uniqueSMILE;
    }

    /**
     * @param uniqueSMILE the uniqueSMILE to set
     */
    public void setUniqueSMILE(String uniqueSMILE) {
        this.uniqueSMILE = uniqueSMILE;
    }

    /**
     * @return the indication
     */
    public  String getIndication() {
        return indication;
    }

    /**
     * @param indication the indication to set
     */
    public  void setIndication(String indication) {
        this.indication = indication;
    }

    /**
     * @return the drugbankID
     */
    public  String getDrugbankID() {
        return drugbankID;
    }

    /**
     * @param drugbankID the drugbankID to set
     */
    public  void setDrugbankID(String drugbankID) {
        this.drugbankID = drugbankID;
    }

    /**
     * @return the logP
     */
    public  String getLogP() {
        return logP;
    }

    /**
     * @param logP the logP to set
     */
    public  void setLogP(String logP) {
        this.logP = logP;
    }

    /**
     * @return the status
     */
    public  String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public  void setStatus(String status) {
        this.status = status;
    }
}
