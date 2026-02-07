package library.testdata.users;

public enum UsersEmail {

    STORE1_USER_EMAIL("store1.user@example.test"),
    STORE2_USER_EMAIL("store2.user@example.test");


    private final String value;
    UsersEmail(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
