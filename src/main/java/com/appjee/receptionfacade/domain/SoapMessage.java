/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appjee.receptionfacade.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author myal6
 */
@XmlRootElement(name = "soapMessage")
public class SoapMessage implements Serializable {

    //@XmlElement(name="statutOp")
    private Boolean statutOp;
    //@XmlElement(name="info")
    private String info;
    //@XmlElement(name="data")
    private Object[] data;
    //@XmlElement(name="operationName")
    private String operationName;
    //@XmlElement(name="tokenApp")
    private String tokenApp;
    //@XmlElement(name="tokenUser")
    private String tokenUser;
    //@XmlElement(name="appVersion")
    private String appVersion;
    //@XmlElement(name="operationVersion")
    private String operationVersion;

    public Boolean getStatutOp() {
        return statutOp;
    }

    public void setStatutOp(Boolean statutOp) {
        this.statutOp = statutOp;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getTokenApp() {
        return tokenApp;
    }

    public void setTokenApp(String tokenApp) {
        this.tokenApp = tokenApp;
    }

    public String getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(String tokenUser) {
        this.tokenUser = tokenUser;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getOperationVersion() {
        return operationVersion;
    }

    public void setOperationVersion(String operationVersion) {
        this.operationVersion = operationVersion;
    }

    @Override
    public String toString() {
        return "SoapMessage{" + "statutOp=" + statutOp + ", info=" + info + 
                ", data=" + data + ", operationName=" + operationName + 
                ", tokenApp=" + tokenApp + ", tokenUser=" + tokenUser + 
                ", appVersion=" + appVersion + ", operationVersion=" + 
                operationVersion + '}';
    }   
}
