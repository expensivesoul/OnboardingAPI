package jsontest.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Blog")
public class Userblog implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long id;
    @Column(name="Title")
    private String title;
    @Column(name="Subject")
    private String subject;
    @Column(name="Content")
    private String textAreaContent;
    @Column(name="Url")
    private String url;

    public Userblog(){}

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

    public String getTextAreaContent() {
        return textAreaContent;
    }

    public void setTextAreaContent(String textAreaContent) {
        this.textAreaContent = textAreaContent;
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
                ", content='" + textAreaContent  + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}
