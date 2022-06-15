/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import weka.clusterers.EM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author HOAI NGUYEN
 */
public class MyEMModel extends MyKnowledgeModel{
    EM em;
    //Cac constructors

    public MyEMModel() {
    }

    public MyEMModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }
    //Cac phuong thuc
    public  void buildEMModel(String filename) throws  Exception{
        //Doc train set vao bo nho
        setTrainset(filename);
        //Thiet lap mo hinh EM
        em = new EM();
        em.buildClusterer(trainset);
        //Xuat thong so mo hinh
        System.out.println(em);
    }
    public  void predictCluster(String filename) throws  Exception{
        //Doc du lieu vao bo nho
        DataSource ds = new DataSource(filename);
        Instances unlabel = ds.getDataSet();
        //Du doan cluster
        for (int i = 0; i < unlabel.numInstances(); i++){
            double predict = em.clusterInstance(unlabel.instance(i));
            System.out.println("Instance " + i + " belongs to cluster " + predict);
        }
                
    }
}
