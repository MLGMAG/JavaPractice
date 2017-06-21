package HomeWork_041;

import java.io.IOException;

/**
 * Created by Magomed on 14.06.2017.
 */

public class DeveloperApp {
    public static void main(String[] args) throws IOException {
        DeveloperDAO DDAO = new DeveloperDAO();
        DeveloperView DevView = new DeveloperView();
        DevView.AppStarter();
    }
}
