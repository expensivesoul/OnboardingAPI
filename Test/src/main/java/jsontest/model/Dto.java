package jsontest.model;


import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "entity")
@TypeDef(name="json",typeClass= JsonStringType.class)
public class Dto{
        @Id
        private String checklist_name;
        private String status;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private  String date;

        @Type(type="json")
       @Column(columnDefinition = "json")
       private List<Documents> data;

        public String getChecklist_name() {
            return checklist_name;
        }

        public void setChecklist_name(String checklist_name) {
            this.checklist_name = checklist_name;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public List<Documents> getData() {
            return data;
        }

        public void setData(List<Documents> data) {
            this.data = data;
        }

    }