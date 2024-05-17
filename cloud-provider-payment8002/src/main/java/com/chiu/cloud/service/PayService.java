package com.chiu.cloud.service;

import com.chiu.cloud.entities.Pay;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:PayService
 * Package:com.chiu.cloud.service
 * Description:
 *
 * @Author chiu
 * @Create 2024/4/30 下午 12:12
 * @Version 1.0
 */

public interface PayService {

    int add(Pay pay);

    int delete(Integer id);
    int update(Pay pay);
    Pay getById(Integer id);
    List<Pay> getAll();

}
