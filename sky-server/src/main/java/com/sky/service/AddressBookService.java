package com.sky.service;

import com.sky.entity.AddressBook;
import java.util.List;

public interface AddressBookService {
    /**
     * 查询
     * @param addressBook
     * @return
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     *  新增
     * @param addressBook
     */
    void save(AddressBook addressBook);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    AddressBook getById(Long id);

    /**
     *  修改
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /**
     *  设置默认
     * @param addressBook
     */
    void setDefault(AddressBook addressBook);

    /**
     * 删除
     * @param id
     */
    void deleteById(Long id);

}
