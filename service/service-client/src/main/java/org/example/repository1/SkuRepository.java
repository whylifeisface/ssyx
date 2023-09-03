package org.example.repository1;

import org.example.model.search.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SkuRepository  extends ElasticsearchRepository<SkuEs, Long> {

}
