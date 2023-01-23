public class User implements Saveable, Reportable {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String report() {
        System.out.println("Report for user: " + name);
        return null;
    }

    @Override
    public void save() {
        Persister persister = new Persister(this);
        persister.save();
    }
}