
package com.zombietank.alfredo.jenkins.domain.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
    "_class",
    "number",
    "url"
})
public class FirstBuild {

    @JsonProperty("_class")
    private String _class;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("url")
    private String url;

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
     *     The number
     */
    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    /**
     * 
     * @param number
     *     The number
     */
    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}
