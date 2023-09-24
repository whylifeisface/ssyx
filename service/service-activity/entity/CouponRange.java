package .service-activity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 优惠券范围表
 * </p>
 *
 * @author ssyx
 * @since 2023-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CouponRange implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 购物券编号
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 范围类型； 1->商品(sku) ；2->分类
     */
    private Integer rangeType;

    private Long rangeId;

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
