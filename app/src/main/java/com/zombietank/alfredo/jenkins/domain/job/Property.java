
package com.zombietank.alfredo.jenkins.domain.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
    "_class",
    "wallDisplayBgPicture",
    "wallDisplayName"
})
public class Property {

    @JsonProperty("_class")
    private String _class;
    @JsonProperty("wallDisplayBgPicture")
    private Object wallDisplayBgPicture;
    @JsonProperty("wallDisplayName")
    private Object wallDisplayName;

    /**
     * 
     * @return
     *     The _class
     */
    @JsonProperty("_class")
    public String getClass_() {
        return _class;
    }

    /**
     * 
     * @param _class
     *     The _class
     */
    @JsonProperty("_class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    /**
     * 
     * @return
     *     The wallDisplayBgPicture
     */
    @JsonProperty("wallDisplayBgPicture")
    public Object getWallDisplayBgPicture() {
        return wallDisplayBgPicture;
    }

    /**
     * 
     * @param wallDisplayBgPicture
     *     The wallDisplayBgPicture
     */
    @JsonProperty("wallDisplayBgPicture")
    public void setWallDisplayBgPicture(Object wallDisplayBgPicture) {
        this.wallDisplayBgPicture = wallDisplayBgPicture;
    }

    /**
     * 
     * @return
     *     The wallDisplayName
     */
    @JsonProperty("wallDisplayName")
    public Object getWallDisplayName() {
        return wallDisplayName;
    }

    /**
     * 
     * @param wallDisplayName
     *     The wallDisplayName
     */
    @JsonProperty("wallDisplayName")
    public void setWallDisplayName(Object wallDisplayName) {
        this.wallDisplayName = wallDisplayName;
    }

}
