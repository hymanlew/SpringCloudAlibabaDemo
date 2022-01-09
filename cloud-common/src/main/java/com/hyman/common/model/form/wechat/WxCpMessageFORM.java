package com.hyman.common.model.form.wechat;

import com.hyman.common.model.form.wechat.article.MpnewsArticle;
import com.hyman.common.model.form.wechat.article.NewArticle;
import com.hyman.common.model.form.wechat.taskcard.TaskCardButton;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 企业微信消息
 */
@Data
public class WxCpMessageFORM implements Serializable {

    private static final long serialVersionUID = 870930480558465740L;
    private String toUser;
    private String toParty;
    private String toTag;
    private Integer agentId;
    private String msgType;
    private String content;
    private String mediaId;
    private String thumbMediaId;
    private String title;
    private String description;
    private String musicUrl;
    private String hqMusicUrl;
    private String safe;
    private String url;
    private String btnTxt;
    private List<NewArticle> articles = new ArrayList<>();
    private List<MpnewsArticle> mpnewsArticles = new ArrayList<>();
    private String appId;
    private String page;
    private Boolean emphasisFirstItem;
    private Map<String, String> contentItems;

    /**
     * 任务卡片特有的属性.
     */
    private String taskId;
    private List<TaskCardButton> taskButtons = new ArrayList<>();
}
