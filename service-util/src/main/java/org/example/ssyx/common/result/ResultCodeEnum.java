package org.example.ssyx.common.result;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    SERVER_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_RESULT(205,"非法请求"),
    REPEAT_SUBMIT(206,"重复提交"),


    LOGIN_AUTH(208, "未登录"),
    PERMISSION(209, "没有权限"),

    ORDER_PRICE_ERROR(210, "订单商品价格变化"),
    ORDER_STOCK_FAIL(204, "订单库存变化"),
    CREATE_ORDER_FAIL(210, "创建订单失败"),

    COUPON_GET(220, "优惠券已经领取"),
    COUPON_LIMIT_GET(221, "优惠券已经发放完毕"),


    URL_ENCODE_ERROR(216, "URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR(217, "非法回调请求"),
    FETCH_ACCESS_TOKEN_FAILED(218, "获取accessToken失败"),
    FETCH_USERINFO_ERROR(219, "获取用户信息失败");
    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    ResultCodeEnum(int code, String message) {

    }
}
