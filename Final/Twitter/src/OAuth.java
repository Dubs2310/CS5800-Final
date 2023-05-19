public class OAuth implements AuthStrategy {
    @Override
    public void authenticate(User user) {
        System.out.println(user.getUsername() + " authenticated with OAuth strategy!");
    }
}
