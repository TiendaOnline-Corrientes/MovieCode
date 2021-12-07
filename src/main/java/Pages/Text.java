package Pages;

public enum Text {

    SCRIPT_TEXT("Will is hunted by a strange entity whereas his friends search for him only to find a lonely"),
    TEXT_TO_VALIDATE("Creators: Matt Duffer, Ross Duffer");
    private String text;
     Text(String text){
        this.text= text;
    }
    public String getText() {
        return text ;
    }
}
