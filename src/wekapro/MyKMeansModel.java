/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import weka.classifiers.Evaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author HOAI NGUYEN
 */
public class MyKMeansModel extends MyKnowledgeModel{
    SimpleKMeans kmeans;
    Evaluation eval;
    
    //Cac constructor

    public MyKMeansModel() {
    }

    public MyKMeansModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }
    
    //Cac phuong thuc
    public void buildKMeansModel(String filename) throws Exception{
        //Doc train set vao bo nho
        setTrainset(filename);
        
        //Thiet lap mo hinh KMeans
        kmeans = new SimpleKMeans();
        kmeans.setNumClusters(3);
        kmeans.setDistanceFunction(new EuclideanDistance());
        kmeans.buildClusterer(trainset);
        //Xuat thong so cua mo hinh ra man hinh
        System.out.println(kmeans);
    }
    public void predictCluster(String filename) throws Exception{
        //Doc du lieu vao bo nho
        DataSource ds = new DataSource(filename);
        Instances unlabel = ds.getDataSet();
        //Du doan cluster
        for( int i = 0; i < unlabel.numInstances(); i++){
            double predict = kmeans.clusterInstance(unlabel.instance(i));
            System.out.println("Instance " + i + " belongs to cluster " + predict);
        }
                
    }
}
