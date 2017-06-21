package HomeWork_041;

/**
 * Created by Magomed on 14.06.2017.
 */

public class Developer {
    private int id;
    private String FirstName;
    private String LastName;
    private String job;
    private double sellery;

    public Developer(int id, String firstName, String lastName, String job, double sellery) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.job = job;
        this.sellery = sellery;
    }

    public String Default() {
        return FirstName + "," + LastName + "," + job + "," + sellery;
    }

    @Override
    public String toString() {
        return "Developer:\n" + "Id: " + id + "\n" + "FirstName: " + FirstName + "\n" + "LastName: " + LastName + "\n" + "Job: " + job + "\n" + "Sellery: " + sellery + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSellery() {
        return sellery;
    }

    public void setSellery(int sellery) {
        this.sellery = sellery;
    }

}
