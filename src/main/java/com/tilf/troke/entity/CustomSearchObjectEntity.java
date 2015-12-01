package com.tilf.troke.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Manu on 2015-11-25.
 */
public class CustomSearchObjectEntity {

    private int idobject;
    private String nameObject;
    private String descObject;
    private int idsubcategory;
    private String subCategoryName;
    private Integer valueObject;
    private int quality;
    private String iduser;
    private String rateable;
    private String issignaled;
    private Date creationdate;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String ismain;


    public String getIsmain() {return ismain;}

    public void setIsmain(String ismain) {this.ismain = ismain;}



    public int getIdobject() {
        return idobject;
    }

    public void setIdobject(int idobject) {
        this.idobject = idobject;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public String getDescObject() {
        return descObject;
    }

    public void setDescObject(String descObject) {
        this.descObject = descObject;
    }

    public int getIdsubcategory() {
        return idsubcategory;
    }

    public void setIdsubcategory(int idsubcategory) {
        this.idsubcategory = idsubcategory;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public Integer getValueObject() {
        return valueObject;
    }

    public void setValueObject(Integer valueObject) {
        this.valueObject = valueObject;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getRateable() {
        return rateable;
    }

    public void setRateable(String rateable) {
        this.rateable = rateable;
    }

    public String getIssignaled() {
        return issignaled;
    }

    public void setIssignaled(String issignaled) {
        this.issignaled = issignaled;
    }

    public String getCreationdate() {
        String date = new SimpleDateFormat("dd-MM-YYYY").format(creationdate);

        return date;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }
}