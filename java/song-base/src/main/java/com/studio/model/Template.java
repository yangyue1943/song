package com.studio.model;import javax.persistence.Table;/** * description: * author:          song * createDate:      2017/10/25 */@Table(name = "studio_Template")public class Template extends BaseModel {    @javax.persistence.Column(name = "templateName")    private String templateName;    @javax.persistence.Column(name = "parentId")    private String parentId;    @javax.persistence.Column(name = "fileName")    private String fileName;    @javax.persistence.Column(name = "fileExtensions")    private String fileExtensions;    @javax.persistence.Column(name = "filePrefix")    private String filePrefix;    private String content;    private String comment;    public String getTemplateName() {        return templateName;    }    public void setTemplateName(String templateName) {        this.templateName = templateName;    }    public String getParentId() {        return parentId;    }    public void setParentId(String parentId) {        this.parentId = parentId;    }    public String getFileName() {        return fileName;    }    public void setFileName(String fileName) {        this.fileName = fileName;    }    public String getFileExtensions() {        return fileExtensions;    }    public void setFileExtensions(String fileExtensions) {        this.fileExtensions = fileExtensions;    }    public String getFilePrefix() {        return filePrefix;    }    public void setFilePrefix(String filePrefix) {        this.filePrefix = filePrefix;    }    public String getContent() {        return content;    }    public void setContent(String content) {        this.content = content;    }    public String getComment() {        return comment;    }    public void setComment(String comment) {        this.comment = comment;    }}