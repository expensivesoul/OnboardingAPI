package OnBoardApp.BlogandFaqOnBoardApp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Blog")
public class userblog implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long id;
    @Column(name="Title")
    private String title;
    @Column(name="Subject")
    private String subject;
    @Column(name="Content")
    private String content;
    @Column(name="Url")
    private String url;

    public userblog(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}
