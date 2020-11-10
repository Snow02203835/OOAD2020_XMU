package com.j2ee.mytest.controller;

import com.j2ee.mytest.model.vo.OrderVo;
import com.j2ee.mytest.service.OrderService;
import com.j2ee.mytest.util.Common;
import com.j2ee.mytest.util.ReturnObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(value = "订单服务", tags = "order")
@RestController /*Restful的Controller对象*/
@RequestMapping(value = "/order", produces = "application/json;charset=UTF-8")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    /**
     * 修改订单
     * @param id
     * @return Object
     */
    @ApiOperation(value = "修改订单状态", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "Token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "int", name = "id", value = "订单id", required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
    })
    @PutMapping("orders/{id}")
    public Object updateOrder(@PathVariable("id") Long id) {
        ReturnObject<Object> retObject = orderService.updateOrder(id);
        return Common.decorateReturnObject(retObject);
    }
}