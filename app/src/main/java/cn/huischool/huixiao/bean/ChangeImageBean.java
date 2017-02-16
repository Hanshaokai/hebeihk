package cn.huischool.huixiao.bean;

import java.util.List;

import cn.huischool.huixiao.framework.BaseResponse;

/**
 * Created by ${han} on 2016/6/8.
 */
public class ChangeImageBean extends BaseResponse {


    /**
     * content : <img src="http://www.huischool.cn/temporaryHtml/image/20160810/20160810112010_713.jpg" alt="" />
     * id : 57aa9d6c0cf26d8718dea2ec
     * title : 0810测试新闻
     * mainImgUrl : http://img-app-index.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/57aa9d6c0cf26d8718dea2eb
     */

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean  {
        private String content;
        private String id;
        private String title;
        private String mainImgUrl;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMainImgUrl() {
            return mainImgUrl;
        }

        public void setMainImgUrl(String mainImgUrl) {
            this.mainImgUrl = mainImgUrl;
        }
    }
}
