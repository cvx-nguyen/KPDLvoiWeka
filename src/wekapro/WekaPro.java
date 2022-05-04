/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wekapro;

/**
 *
 * @author HOAI NGUYEN
 */
public class WekaPro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //Doc du lieu vao bo nho
        MyKnowledgeModel model = new MyKnowledgeModel("C:\\Program Files\\Weka-3-8-6\\data\\iris.arff");
        System.out.println(model);
        
        //Luu du lieu ra file
        model.saveData("E:\\NetBeans\\Data\\iris.arff");
        
        //Chuyen doi dinh dang du lieu
        model.saveData2CSV("E:\\NetBeans\\Data\\iris_CSV.csv");

    }
    
}
