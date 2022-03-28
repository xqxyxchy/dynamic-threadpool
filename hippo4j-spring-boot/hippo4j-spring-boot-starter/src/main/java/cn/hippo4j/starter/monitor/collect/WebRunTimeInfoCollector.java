package cn.hippo4j.starter.monitor.collect;

import static cn.hippo4j.core.toolkit.IdentifyUtil.getThreadPoolIdentify;

import java.util.List;
import java.util.concurrent.Executor;

import com.google.common.collect.Lists;

import cn.hippo4j.common.model.PoolRunStateInfo;
import cn.hippo4j.common.monitor.AbstractMessage;
import cn.hippo4j.common.monitor.Message;
import cn.hippo4j.common.monitor.MessageTypeEnum;
import cn.hippo4j.common.monitor.RuntimeMessage;
import cn.hippo4j.core.executor.state.AbstractThreadPoolRuntime;
import cn.hippo4j.core.executor.web.WebThreadPoolHandlerChoose;
import cn.hippo4j.core.executor.web.WebThreadPoolRunStateHandler;
import cn.hippo4j.core.executor.web.WebThreadPoolService;
import cn.hippo4j.starter.config.BootstrapProperties;
import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;

/**
 * Thread pool runtime data collection.
 *
 * @author chen.ma
 * @date 2021/12/16 19:46
 */
@AllArgsConstructor
public class WebRunTimeInfoCollector extends AbstractThreadPoolRuntime implements Collector {

    private final BootstrapProperties properties;
    private final WebThreadPoolHandlerChoose webThreadPoolServiceChoose;
    private final WebThreadPoolRunStateHandler webThreadPoolRunStateHandler;

    @Override
    public Message collectMessage() {
        AbstractMessage message = new RuntimeMessage();
        List<Message> runtimeMessages = Lists.newArrayList();
        
        // 容器线程池数据上报
        PoolRunStateInfo webPoolRunState = getWebPoolRunState();
        webPoolRunState.setCurrentLoad(webPoolRunState.getCurrentLoad().replace("%", ""));
        webPoolRunState.setPeakLoad(webPoolRunState.getPeakLoad().replace("%", ""));
        RuntimeMessage runtimeMessage = BeanUtil.toBean(webPoolRunState, RuntimeMessage.class);
        runtimeMessage.setGroupKey(getThreadPoolIdentify("web-pool", properties.getItemId(), properties.getNamespace()));
        runtimeMessages.add(runtimeMessage);

        message.setMessageType(MessageTypeEnum.RUNTIME);
        message.setMessages(runtimeMessages);

        return message;
    }

    @Override
    protected PoolRunStateInfo supplement(PoolRunStateInfo basePoolRunStateInfo) {
        return basePoolRunStateInfo;
    }

    /**
     * Get web pool run state.
     *
     * @return
     */
    private PoolRunStateInfo getWebPoolRunState() {
        WebThreadPoolService webThreadPoolService = webThreadPoolServiceChoose.choose();
        Executor webThreadPool = webThreadPoolService.getWebThreadPool();
        PoolRunStateInfo poolRunState = webThreadPoolRunStateHandler.getPoolRunState(null, webThreadPool);
        return poolRunState;
    }

}
