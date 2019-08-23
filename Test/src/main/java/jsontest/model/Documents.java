package jsontest.model;



public class Documents {
    private String order;
    private String document_name;
    private String description;
    private boolean document_status;

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDocument_status() {
        return document_status;
    }

    public void setDocument_status(boolean document_status) {
        this.document_status = document_status;
    }
}
