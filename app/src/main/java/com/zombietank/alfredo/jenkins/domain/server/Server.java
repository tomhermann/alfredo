package com.zombietank.alfredo.jenkins.domain.server;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.zombietank.alfredo.jenkins.domain.job.Job;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
        "_class",
        "assignedLabels",
        "mode",
        "nodeDescription",
        "nodeName",
        "numExecutors",
        "description",
        "jobs",
        "overallLoad",
        "primaryView",
        "quietingDown",
        "slaveAgentPort",
        "unlabeledLoad",
        "useCrumbs",
        "useSecurity",
        "views"
})
public class Server {

    @JsonProperty("_class")
    private String _class;
    @JsonProperty("assignedLabels")
    private List<AssignedLabel> assignedLabels = new ArrayList<AssignedLabel>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("nodeDescription")
    private String nodeDescription;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("numExecutors")
    private Integer numExecutors;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("jobs")
    private List<Job> jobs = new ArrayList<>();
    @JsonProperty("overallLoad")
    private OverallLoad overallLoad;
    @JsonProperty("primaryView")
    private PrimaryView primaryView;
    @JsonProperty("quietingDown")
    private Boolean quietingDown;
    @JsonProperty("slaveAgentPort")
    private Integer slaveAgentPort;
    @JsonProperty("unlabeledLoad")
    private UnlabeledLoad unlabeledLoad;
    @JsonProperty("useCrumbs")
    private Boolean useCrumbs;
    @JsonProperty("useSecurity")
    private Boolean useSecurity;
    @JsonProperty("views")
    private List<View> views = new ArrayList<View>();

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
     * @return The assignedLabels
     */
    @JsonProperty("assignedLabels")
    public List<AssignedLabel> getAssignedLabels() {
        return assignedLabels;
    }

    /**
     * @param assignedLabels The assignedLabels
     */
    @JsonProperty("assignedLabels")
    public void setAssignedLabels(List<AssignedLabel> assignedLabels) {
        this.assignedLabels = assignedLabels;
    }

    /**
     * @return The mode
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * @param mode The mode
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return The nodeDescription
     */
    @JsonProperty("nodeDescription")
    public String getNodeDescription() {
        return nodeDescription;
    }

    /**
     * @param nodeDescription The nodeDescription
     */
    @JsonProperty("nodeDescription")
    public void setNodeDescription(String nodeDescription) {
        this.nodeDescription = nodeDescription;
    }

    /**
     * @return The nodeName
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * @param nodeName The nodeName
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * @return The numExecutors
     */
    @JsonProperty("numExecutors")
    public Integer getNumExecutors() {
        return numExecutors;
    }

    /**
     * @param numExecutors The numExecutors
     */
    @JsonProperty("numExecutors")
    public void setNumExecutors(Integer numExecutors) {
        this.numExecutors = numExecutors;
    }

    /**
     * @return The description
     */
    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     * @return The jobs
     */
    @JsonProperty("jobs")
    public List<Job> getJobs() {
        return jobs;
    }

    /**
     * @param jobs The jobs
     */
    @JsonProperty("jobs")
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     * @return The overallLoad
     */
    @JsonProperty("overallLoad")
    public OverallLoad getOverallLoad() {
        return overallLoad;
    }

    /**
     * @param overallLoad The overallLoad
     */
    @JsonProperty("overallLoad")
    public void setOverallLoad(OverallLoad overallLoad) {
        this.overallLoad = overallLoad;
    }

    /**
     * @return The primaryView
     */
    @JsonProperty("primaryView")
    public PrimaryView getPrimaryView() {
        return primaryView;
    }

    /**
     * @param primaryView The primaryView
     */
    @JsonProperty("primaryView")
    public void setPrimaryView(PrimaryView primaryView) {
        this.primaryView = primaryView;
    }

    /**
     * @return The quietingDown
     */
    @JsonProperty("quietingDown")
    public Boolean getQuietingDown() {
        return quietingDown;
    }

    /**
     * @param quietingDown The quietingDown
     */
    @JsonProperty("quietingDown")
    public void setQuietingDown(Boolean quietingDown) {
        this.quietingDown = quietingDown;
    }

    /**
     * @return The slaveAgentPort
     */
    @JsonProperty("slaveAgentPort")
    public Integer getSlaveAgentPort() {
        return slaveAgentPort;
    }

    /**
     * @param slaveAgentPort The slaveAgentPort
     */
    @JsonProperty("slaveAgentPort")
    public void setSlaveAgentPort(Integer slaveAgentPort) {
        this.slaveAgentPort = slaveAgentPort;
    }

    /**
     * @return The unlabeledLoad
     */
    @JsonProperty("unlabeledLoad")
    public UnlabeledLoad getUnlabeledLoad() {
        return unlabeledLoad;
    }

    /**
     * @param unlabeledLoad The unlabeledLoad
     */
    @JsonProperty("unlabeledLoad")
    public void setUnlabeledLoad(UnlabeledLoad unlabeledLoad) {
        this.unlabeledLoad = unlabeledLoad;
    }

    /**
     * @return The useCrumbs
     */
    @JsonProperty("useCrumbs")
    public Boolean getUseCrumbs() {
        return useCrumbs;
    }

    /**
     * @param useCrumbs The useCrumbs
     */
    @JsonProperty("useCrumbs")
    public void setUseCrumbs(Boolean useCrumbs) {
        this.useCrumbs = useCrumbs;
    }

    /**
     * @return The useSecurity
     */
    @JsonProperty("useSecurity")
    public Boolean getUseSecurity() {
        return useSecurity;
    }

    /**
     * @param useSecurity The useSecurity
     */
    @JsonProperty("useSecurity")
    public void setUseSecurity(Boolean useSecurity) {
        this.useSecurity = useSecurity;
    }

    /**
     * @return The views
     */
    @JsonProperty("views")
    public List<View> getViews() {
        return views;
    }

    /**
     * @param views The views
     */
    @JsonProperty("views")
    public void setViews(List<View> views) {
        this.views = views;
    }

}
