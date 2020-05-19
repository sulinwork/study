package com.sulin.mybatisplus.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author yinbangshan
 * @version 2019-07-18 16:49:33
 * @email yinbangshan@mbcloud.com
 */
//@Table(name = "activity_base_info")
@Data
public class ActivityBaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    //
//    @Id
    private String id;

    //活动名称
//    @Column(name = "name")
//    @Queryable
    private String name;

    //logo图片活动地址
//    @Column(name = "logo_url")
    private String logoUrl;

    //0-抽奖,1-秒杀
   // @Column(name = "type")
    private Integer type;

    //活动开始时间
    //@Column(name = "start_time")
    private Date startTime;

    //活动结束时间
    //@Column(name = "end_time")
    private Date endTime;

    //0-停用,1-启用
    //@Column(name = "status")
    private Integer status;

    //抽奖限制次数
    //@Column(name = "count_limit")
    private Integer countLimit;

    //备注
    //@Column(name = "remark")
    private String remark;

    ////资质id
    //@Column(name = "qualification_id")
    private String qualificationId;


    //
    //@Column(name = "create_time")
    private Date createTime;

    //
    //@Column(name = "update_time")
    private Date updateTime;

    //
    //@Column(name = "creator_id")
    private String creatorId;

    //
   // @Column(name = "creator_name")
    private String creatorName;

    //
    //@Column(name = "detail_url")
    private String detailUrl;


    //@Column(name = "max_index")
    private Integer maxIndex;

    /**
     * 活动资质参数
     */
    private String params;
}
