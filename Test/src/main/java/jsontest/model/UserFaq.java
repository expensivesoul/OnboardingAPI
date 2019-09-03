package jsontest.model;

import javax.persistence.*;

@Entity
@Table(name="FAQ")
//@NamedQuery()
public class Userfaq {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private long id;
    @Column(name="Question")
    private String question;
    @Column(name="Category")
    private String category;
    @Column(name="Answer")
    private String answer;


    public Userfaq(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", category='" + category + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
