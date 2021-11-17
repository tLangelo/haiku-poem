package analysis;

public class HaikuPoem {
    private String author;
    private String id;
    private String title;
    private String text;

    public String getAuthor(){
        return this.author;
    }
    public String getID(){
        return this.id;
    }
    public String getText(){
        return this.text;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
