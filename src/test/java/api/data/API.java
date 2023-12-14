package api.data;

public class API {
    private static int idActivities;

    public static int getIdActivities() {
        return idActivities;
    }

    public static void setIdActivities(int idActivities) {
        API.idActivities = idActivities;
    }
}
