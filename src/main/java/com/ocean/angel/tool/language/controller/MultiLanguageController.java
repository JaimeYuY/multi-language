package com.ocean.angel.tool.language.controller;

import com.ocean.angel.tool.language.common.ResultBean;
import com.ocean.angel.tool.language.constant.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 国际化测试
 * </p>
 *
 * @author Jaime.yu
 * @since 2022-04-22
 */
@Slf4j
@RestController
@RequestMapping("/language/test")
public class MultiLanguageController {

    @GetMapping("/success")
    public ResultBean success() {
        Map<String, String> data = new HashMap<>();
        data.put("a", "a");
        data.put("b", "b");
        return ResultBean.success(data);
    }

    @GetMapping("/error")
    public ResultBean error() {
        return ResultBean.error();
    }

    @GetMapping("/error/param")
    public ResultBean paramError() {
        return ResultBean.error(ResultCode.PARAM_ERROR);
    }

    @GetMapping("/error/internal")
    public ResultBean internalError() {
        return ResultBean.error(ResultCode.SERVICE_INTERNAL_ERROR);
    }

}

