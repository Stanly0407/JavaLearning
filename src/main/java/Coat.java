public class Coat {
    public static String getFullName(String firstName, String lastName) {
        try {
            return firstName.toString() + " " + lastName.toString();
        } catch (NullPointerException npe) {
            System.out.print("Problem?");
        } finally {
            System.out.print("Finished!");
        }
        return null;
    }

    public static void main(String[] args) {


            System.out.print(getFullName("Joyce", "Hopper"));

    }
    String checkZipper = (String)new Object();
}
