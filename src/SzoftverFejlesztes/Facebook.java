package SzoftverFejlesztes;

public class Facebook {
    String pageurl;
    String source;
    String followers;
    String date;
    String time;
    String timeZone;
    String interactions;
    String postMessage;
    String postType;
    String postLink;

    public Facebook(String pageurl, String source, String followers, String date, String time, String timeZone, String interactions, String postMessage, String postType, String postLink) {
        this.pageurl = pageurl;
        this.source = source;
        this.followers = followers;
        this.date = date;
        this.time = time;
        this.timeZone = timeZone;
        this.interactions = interactions;
        this.postMessage = postMessage;
        this.postType = postType;
        this.postLink = postLink;
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }
}
