package com.tool.soat.job.executor;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2023/3/17 18:50
 * @File: InterfaceJob
 * @Software: IntelliJIDEA
 */

@Component
public class InterfaceJob {
    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");

        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println("Hello World XXL Jo11b");
    }
}
