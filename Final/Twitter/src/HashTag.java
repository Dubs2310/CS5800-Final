public class HashTag extends TweetObservable {
    private String name;

    public HashTag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
