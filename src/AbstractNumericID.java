public abstract class AbstractNumericID {
    protected String id;

    public String getId(){
        return id;
    }

    public void setId(String id){
        if ((id.length()==4) && id.matches(("[a-zA-Z0-9]{4}"))) {
            this.id = id;
        }else {
            throw new IllegalArgumentException("ID must be exactly 4 digits or characters");
        }
    }

    public abstract void print();
}
