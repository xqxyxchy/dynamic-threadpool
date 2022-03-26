package cn.hippo4j.config.service.biz;

import cn.hippo4j.common.monitor.Message;
import cn.hippo4j.config.model.HisRunDataInfo;
import cn.hippo4j.config.model.biz.item.ItemQueryReqDTO;
import cn.hippo4j.config.model.biz.item.ItemRespDTO;
import cn.hippo4j.config.model.biz.monitor.MonitorActiveRespDTO;
import cn.hippo4j.config.model.biz.monitor.MonitorQueryReqDTO;
import cn.hippo4j.config.model.biz.monitor.MonitorRespDTO;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * His run data service.
 *
 * @author chen.ma
 * @date 2021/12/10 21:28
 */
public interface HisRunDataService extends IService<HisRunDataInfo> {

    IPage<MonitorRespDTO> queryPage(MonitorQueryReqDTO reqDTO);
    
    /**
     * Query.
     *
     * @param reqDTO
     * @return
     */
    List<MonitorRespDTO> query(MonitorQueryReqDTO reqDTO);

    /**
     * Query active thread pool monitor.
     *
     * @param reqDTO
     * @return
     */
    MonitorActiveRespDTO queryInfoThreadPoolMonitor(MonitorQueryReqDTO reqDTO);

    /**
     * Query thread pool last task count.
     *
     * @param reqDTO
     * @return
     */
    MonitorRespDTO queryThreadPoolLastTaskCount(MonitorQueryReqDTO reqDTO);

    /**
     * Save.
     *
     * @param message
     */
    void save(Message message);

}
