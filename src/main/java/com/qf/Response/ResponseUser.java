package com.qf.Response;

import com.qf.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class ResponseUser<T> {

    private List<T> list;

    private Long total;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }



}
