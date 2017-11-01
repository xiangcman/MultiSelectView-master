package com.library.multiselct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangcheng on 17/10/27.
 */

public abstract class SelectBean {
    public String name;
    public List<SelectBean> childs = new ArrayList<>();

    public SelectBean(String name) {
        this.name = name;
    }

    public void initializeChild(SelectBean child) {
        childs.add(child);
    }
}
