package org.example.sys.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.sys.Ware;
import org.example.sys.mapper.WareMapper;
import org.example.sys.service.WareService;
import org.springframework.stereotype.Service;

@Service
public class WareServiceImp extends ServiceImpl<WareMapper, Ware>  implements WareService {
}
