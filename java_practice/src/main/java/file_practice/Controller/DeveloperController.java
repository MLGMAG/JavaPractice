package file_practice.Controller;

import file_practice.DAO.DeveloperDAO;

/**
 * Created by Magomed on 14.06.2017.
 */

public class DeveloperController {
    DeveloperDAO DDAO = new DeveloperDAO();

    public void ReadDocument() {
        DDAO.ReadDocument();
    }

    public void Parce() {
        DDAO.Parce();
    }

    public void GetById() {
        DDAO.GetById();
    }

    public void CreateDeveloper() {
        DDAO.CreateDeveloper();
    }

    public void AllIds() {
        DDAO.AllIds();
    }
    public void RemoveDeveloper(){
        DDAO.RemoveDeveloper();
    }
    public void ChangeInfo(){
        DDAO.ChangeInfo();
    }
}
