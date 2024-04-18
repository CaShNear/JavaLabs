package Lab3_4.Variant_6;

public class Constructor {

    private int id;
    private String surname;
    private String name;
    private String post;

    public Constructor(){ }

    public Constructor(int id, String surname, String name, String post){
        setId(id);
        setSurname(surname);
        setName(name);
        setPost(post);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

}
