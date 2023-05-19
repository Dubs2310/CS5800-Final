public class TwoFactorAuth implements AuthStrategy {
    @Override
    public void authenticate(User user) {
        System.out.println(user.getUsername() + " authenticated with 2FA strategy!");
    }
}
