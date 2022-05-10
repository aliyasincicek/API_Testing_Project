package pojos;

public class RegresInPojo {

   private String name;
   private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public RegresInPojo(String name, String job) {
        this.name = name;
        this.job = job;
    }
    public RegresInPojo(){
    }

    @Override
    public String toString() {
        return "RegresInPojo{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
