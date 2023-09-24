package .service-activity.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 优惠券信息
 * </p>
 *
 * @author ssyx
 * @since 2023-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CouponInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 购物券类型 1 现金券 2 满减券
     */
    private Integer couponType;

    /**
     * 优惠卷名字
     */
    private String couponName;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 使用门槛 0->没门槛
     */
    private BigDecimal conditionAmount;

    /**
     * 可以领取的开始日期
     */
    private LocalDate startTime;

    /**
     * 可以领取的结束日期
     */
    private LocalDate endTime;

    /**
     * 使用范围[1->全场通用；2->指定分类；3->指定商品]
     */
    private Integer rangeType;

    /**
     * 使用范围描述
     */
    private String rangeDesc;

    /**
     * 发行数量
     */
    private Integer publishCount;

    /**
     * 每人限领张数
     */
    private Integer perLimit;

    /**
     * 已使用数量
     */
    private Integer useCount;

    /**
     * 领取数量
     */
    private Integer receiveCount;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 发布状态[0-未发布，1-已发布]
     */
    private Boolean publishStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标记（0:不可用 1:可用）
     */
    private Integer isDeleted;


}
