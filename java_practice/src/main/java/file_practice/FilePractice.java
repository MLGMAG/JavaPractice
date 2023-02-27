package file_practice;

import file_practice.DAO.DeveloperDAO;
import file_practice.View.DeveloperView;

import java.io.IOException;

/**
 * Created by Magomed on 14.06.2017.
 */

public class FilePractice {
    public static void main(String[] args) throws IOException {
        DeveloperDAO DDAO = new DeveloperDAO();
        DeveloperView DevView = new DeveloperView();
        DevView.AppStarter();
    }
}
