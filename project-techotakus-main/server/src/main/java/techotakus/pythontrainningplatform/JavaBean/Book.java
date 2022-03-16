package techotakus.pythontrainningplatform.JavaBean;

import lombok.Data;

@Data
public class Book implements java.io.Serializable{
    private int id;
    private String name;
    private int Page;
    private String author;
    public Book(){}
}
