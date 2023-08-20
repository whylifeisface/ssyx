package org.example.vo.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.model.product.SkuAttrValue;
import org.example.model.product.SkuImage;
import org.example.model.product.SkuInfo;
import org.example.model.product.SkuPoster;

import java.util.List;

@Data
public class SkuInfoVo extends SkuInfo {

	@ApiModelProperty(value = "海报列表")
	private List<SkuPoster> skuPosterList;

	@ApiModelProperty(value = "属性值")
	private List<SkuAttrValue> skuAttrValueList;

	@ApiModelProperty(value = "图片")
	private List<SkuImage> skuImagesList;

}

