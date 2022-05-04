/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author HOAI NGUYEN
 */
public class MyKnowledgeModel {
    DataSource source;
    Instances dataset;

    public MyKnowledgeModel() {
    }
    
    //Doc du lieu vao bo nho
    public MyKnowledgeModel(String filename) throws Exception {
        this.source = new DataSource(filename);
        this.dataset = source.getDataSet();
    } 

    //Xuat du lieu ra file
    public  void saveData(String filename) throws IOException{
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Finished");
    }
    
    //Chuyen doi dinh dang du lieu
    public  void saveData2CSV(String filename) throws IOException{
         CSVSaver outData = new  CSVSaver();
         outData.setInstances(this.dataset);
         outData.setFile(new File(filename));
         outData.writeBatch();
         System.out.println("Converted");
        
    }

    @Override
    public String toString() {
        return  dataset.toSummaryString();
    }
    
}
