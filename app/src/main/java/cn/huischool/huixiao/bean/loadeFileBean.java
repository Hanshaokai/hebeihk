package cn.huischool.huixiao.bean;

/**
 * Created by ${han} on 2016/9/7.
 */
public class loadeFileBean {

    private String createTime;
    private String fileName;
    private String fileSize;
    private Boolean isSlected;
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Boolean getSlected() {
        return isSlected;
    }

    public void setSlected(Boolean slected) {
        isSlected = slected;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
