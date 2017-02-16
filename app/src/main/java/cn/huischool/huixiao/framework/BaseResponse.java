package cn.huischool.huixiao.framework;

import java.io.Serializable;

import cn.huischool.huixiao.R;


public class BaseResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 635436609525604618L;
    public int code = -10000;
    public String message = "网络不可用，请检查网络连接";
    public Object errors = "";


}
