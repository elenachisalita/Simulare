package Domain;

public class Agenda {

    private String id;
    private String description;
    private String day;
    private int duration;
    private String hour;

    public Agenda(String id, String description, String day, int duration, String hour) {
        this.id = id;
        this.description = description;
        this.day = day;
        this.duration = duration;
        this.hour = hour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", day='" + day + '\'' +
                ", duration=" + duration +
                ", hour='" + hour + '\'' +
                '}';
    }
}
