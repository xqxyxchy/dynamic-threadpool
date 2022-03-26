package cn.hippo4j.config.model.biz.monitor;

import lombok.Data;

/**
 * Monitor resp dto.
 *
 * @author chen.ma
 * @date 2021/12/10 20:23
 */
@Data
public class MonitorRespDTO {

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 项目id
     */
    private String itemId;

    /**
     * 实例id
     */
    private String instanceId;

    /**
     * 线程池id
     */
    private String tpId;

    /**
     * 当前负载
     */
    private Long currentLoad;

    /**
     * 峰值负载
     */
    private Long peakLoad;

    /**
     * 线程数
     */
    private Long poolSize;

    /**
     * 活跃线程数
     */
    private Long activeSize;

    /**
     * 队列容量
     */
    private Long queueCapacity;

    /**
     * 队列元素
     */
    private Long queueSize;

    /**
     * 队列剩余容量
     */
    private Long queueRemainingCapacity;

    /**
     * 已完成任务计数
     */
    private Long completedTaskCount;

    /**
     * 拒绝次数
     */
    private Long rejectCount;

    /**
     * 时间戳
     */
    private Long timestamp;

}
