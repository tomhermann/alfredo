package com.zombietank.alfredo.jenkins.domain.server;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
        "_class",
        "name",
        "url"
})
public class View {

    @JsonProperty("_class")
    private String _class;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;

    /**
     * @return The _class
     */
    @JsonProperty("_class")
    public String getClass_() {
        return _class;
    }

    /**
     * @param _class The _class
     */
    @JsonProperty("_class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}
