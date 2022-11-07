package com.bptn.request;

public class FeedPostRequest {

    private String fromDate;
    private String toDate;
    private String queryKeyword;
    private String userName;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getQueryKeyword() {
        return queryKeyword;
    }

    public void setQueryKeyword(String queryKeyword) {
        this.queryKeyword = queryKeyword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
