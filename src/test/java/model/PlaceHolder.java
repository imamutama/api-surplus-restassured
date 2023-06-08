package model;

public class PlaceHolder {
    private String title;
    private String body;
    private int userId;

    public PlaceHolder(String title, String body, int userId) {
        setTitle(title);
        setBody(body);
        setUserId(userId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
