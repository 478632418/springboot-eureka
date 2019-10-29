package com.dx.test.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiSort;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "文章实体")
public class Article implements Serializable {
    @ApiModelProperty(value = "文章id", position = 0)
    private Long id;
    @ApiModelProperty(value = "标题", position = 1)
    private String title;
    @ApiModelProperty(value = "作者", position = 2)
    private String author;
    @ApiModelProperty(value = "内容", position = 3)
    private String content;
    @ApiModelProperty(value = "创建人", position = 4)
    private String createUser;
    @ApiModelProperty(value = "创建人id", position = 5)
    private String createUserId;
    @ApiModelProperty(value = "创建时间", position = 6)
    private Date createTime;
    @ApiModelProperty(value = "修改人", position = 7)
    private String modifyUser;
    @ApiModelProperty(value = "修改人id", position = 8)
    private String modifyUserId;
    @ApiModelProperty(value = "修改时间", position = 9)
    private Date modifyTime;

    public Article(Long id, String title, String author, String content, Date createTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime the modifyTime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return the createUser
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser the createUser to set
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return the createUserId
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId the createUserId to set
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @return the modifyUser
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * @param modifyUser the modifyUser to set
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * @return the modifyUserId
     */
    public String getModifyUserId() {
        return modifyUserId;
    }

    /**
     * @param modifyUserId the modifyUserId to set
     */
    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }
}
