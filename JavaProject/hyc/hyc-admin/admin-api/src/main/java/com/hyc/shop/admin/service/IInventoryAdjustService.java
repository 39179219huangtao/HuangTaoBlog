package com.hyc.shop.admin.service;


import java.util.List;

/**
 * 库存校正服务.
 *
 * @author huangtao
 */
public interface IInventoryAdjustService {

    /**
     * 调整仓库库存.
     */
    void repairWarehouseInventoy(Long productSku, Integer warehouseId, Integer changeCount);



}
