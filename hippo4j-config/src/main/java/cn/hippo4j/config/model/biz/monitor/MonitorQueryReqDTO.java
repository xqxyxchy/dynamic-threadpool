package cn.hippo4j.config.model.biz.monitor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import lombok.Data;

/**
 * Monitor query req dto.
 *
 * @author chen.ma
 * @date 2021/12/10 20:18
 */
@Data
public class MonitorQueryReqDTO extends Page {

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 项目id
     */
    private String itemId;

    /**
     * 线程池id
     */
    private String tpId;

    /**
     * 实例id
     */
    private String instanceId;

    /**
     * 时刻区间
     */
    private long[] datetime;
    
    public boolean hasDatetime() {
        if(datetime == null || datetime.length == 0 || datetime.length != 2) {
            return false;
        }
        
        return true;
    }
    
}
