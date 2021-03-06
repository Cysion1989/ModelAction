package com.cysion.sample;

import com.cysion.mvcation.base.TActionListener;

import static com.cysion.mvcation.base.MvcAction.Method.Method_POST;

/**
 * Created by xianshang.liu on 2017/4/7.
 */

public class PostAction extends BaseAction {
    public static final int POST01 = 200;
    public static final int POST02 = 201;

    public PostAction(TActionListener aListener) {
        super(aListener);
    }

    @Override
    protected String getUrl(int aTaskId) {
        switch (aTaskId) {
            case POST01:
                return Urls.POST_ONE;
            case POST02:
                return Urls.POST_TWO;
        }
        return Urls.POST_ONE;
    }

    @Override
    protected Method getHttpMethod(int aTaskId) {
        return Method_POST;
    }

    @Override
    protected boolean getTargetDataFromJson(String aResult, int aTaskId) {
        if (aResult.length() > 100) {
            listener.onSuccess(aResult.substring(0, 99), aTaskId);
            return true;
        } else if (aResult.length() > 30) {
            listener.onSuccess(aResult.substring(0, 29), aTaskId);
            return true;
        }
        return false;
    }
}
