/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Debug.Random;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author HOAI NGUYEN
 */
public class MyKNNModel extends MyKnowledgeModel{
    IBk knn;
    Evaluation eval;

    public MyKNNModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }
    
    public void buildkNN(String filename) throws Exception{
        //Doc train set vao bo nho
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() -1);
        //Huan luyen mo hinh knn
        this.knn = new IBk();
        knn.setOptions(model_options);
        knn.buildClassifier(this.trainset);
    }
    
    public void evaluatekNN(String filename) throws Exception{
        //Doc test set vao bo nho
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() -1);
        //Danh gia mo hinh bang 10-fold  cross-validation
        Random rnd = new Random(1);
        int folds = 10;
        eval = new Evaluation(this.trainset);
        eval.crossValidateModel(knn, this.testset, folds, rnd);
        System.out.println(eval.toSummaryString("\nKet qua danh gia mo hinh 10-fold cross-validation\n----\n", false));
    }
    
    public  void predictClassLabel (String fileIn, String fileOut) throws  Exception{
        //Doc du lieu can du doan vao bo nho
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() -1);
        //Du doan classLabel cho tung instance
        for (int i = 0; i < unlabel.numInstances(); i++){
            double predict = knn.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }
        
        //Xuat ket qua ra fileOut
        BufferedWriter outWriter = new BufferedWriter(new FileWriter(fileOut));
        outWriter.write(unlabel.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();
            
    }

    @Override
    public String toString() {
        return this.knn.toString();
    }
    
    
}
