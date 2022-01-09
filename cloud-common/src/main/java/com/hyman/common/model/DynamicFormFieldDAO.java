package com.hyman.common.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "dynamic_form_field")
public class DynamicFormFieldDAO {
    /**
     * 自增ID
     */
    @Id
    private Long id;

    /**
     * 表单编号
     */
    @Column(name = "form_id")
    private String formId;

    /**
     * 表单名称
     */
    @Column(name = "form_name")
    private String formName;

    /**
     * 字段英文名
     */
    @Column(name = "field_en")
    private String fieldEn;

    /**
     * 字段中文名
     */
    @Column(name = "field_name")
    private String fieldName;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 批注
     */
    private String notes;

    /**
     * 是否隐藏(1是2否)
     */
    private Integer isPrivate;

    /**
     * 默认值
     */
    private String predefinedValue;

    /**
     * 字典信息
     */
    private String choices;

    /**
     * 是否必填（1是 2否）
     */
    private Integer required;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 最后一次修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取表单编号
     *
     * @return form_id - 表单编号
     */
    public String getFormId() {
        return formId;
    }

    /**
     * 设置表单编号
     *
     * @param formId 表单编号
     */
    public void setFormId(String formId) {
        this.formId = formId == null ? null : formId.trim();
    }

    /**
     * 获取表单名称
     *
     * @return form_name - 表单名称
     */
    public String getFormName() {
        return formName;
    }

    /**
     * 设置表单名称
     *
     * @param formName 表单名称
     */
    public void setFormName(String formName) {
        this.formName = formName == null ? null : formName.trim();
    }

    /**
     * 获取字段英文名
     *
     * @return field_en - 字段英文名
     */
    public String getFieldEn() {
        return fieldEn;
    }

    /**
     * 设置字段英文名
     *
     * @param fieldEn 字段英文名
     */
    public void setFieldEn(String fieldEn) {
        this.fieldEn = fieldEn == null ? null : fieldEn.trim();
    }

    /**
     * 获取字段中文名
     *
     * @return field_name - 字段中文名
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置字段中文名
     *
     * @param fieldName 字段中文名
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    /**
     * 获取字段类型
     *
     * @return type - 字段类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置字段类型
     *
     * @param type 字段类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取批注
     *
     * @return notes - 批注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置批注
     *
     * @param notes 批注
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    /**
     * 获取是否必填（1是 2否）
     *
     * @return required - 是否必填（1是 2否）
     */
    public Integer getRequired() {
        return required;
    }

    /**
     * 设置是否必填（1是 2否）
     *
     * @param required 是否必填（1是 2否）
     */
    public void setRequired(Integer required) {
        this.required = required;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取最后一次修改时间
     *
     * @return update_date - 最后一次修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置最后一次修改时间
     *
     * @param updateDate 最后一次修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getPredefinedValue() {
        return predefinedValue;
    }

    public void setPredefinedValue(String predefinedValue) {
        this.predefinedValue = predefinedValue;
    }
}