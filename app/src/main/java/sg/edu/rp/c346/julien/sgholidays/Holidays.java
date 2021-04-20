package sg.edu.rp.c346.julien.sgholidays;

public class Holidays {
    private String holidayName;
    private String holidayImage;
    private String date;

    public Holidays(String holidayName, String holidayImage, String date) {
        this.holidayName = holidayName;
        this.holidayImage = holidayImage;
        this.date = date;
    }

    public String getName() {
        return holidayName;
    }

    public String getImage() {
        return holidayImage;
    }

    public String getDate() {
        return date;
    }

}
