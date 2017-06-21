package HomeWork_041;

import HomeWork_041.DAO.DeveloperDAO;
import HomeWork_041.View.DeveloperView;

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
