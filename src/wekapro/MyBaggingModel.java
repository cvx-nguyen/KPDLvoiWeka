package wekapro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.Bagging;
import weka.core.Debug.Random;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;



/**
 *
 * @author HOAI NGUYEN
 */
public class MyBaggingModel extends MyKnowledgeModel{
    Evaluation eval;
    NaiveBayes bayes;
    Bagging bag;
    
    //constructor

    public MyBaggingModel() {
    }

    public MyBaggingModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }
    
    //Cac phuong thuc
    public  void buildBaggingModel (String filename) throws Exception{
        //Doc train set vao bo nho
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() -1);
        //Tao lap classifier co ban
        bayes = new NaiveBayes();
        //Thiet lap mo hinh bagging
        bag = new Bagging();
        bag.setClassifier(bayes);
        bag.setNumIterations(10);
        bag.buildClassifier(trainset);
    }
     public void evaluateBaggingModel (String filename) throws  Exception{
         //Doc test set vao bo nho
         setTestset(filename);
         this.testset.setClassIndex(this.testset.numAttributes() -1);
         //Danh gia mo hinh bang 10-fold cross-validation
         Random  rnd = new Random(1);
         int folds = 10;
         eval = new Evaluation(this.trainset);
         eval.crossValidateModel(bag, testset, folds, rnd);
         System.out.println(eval.toSummaryString(
                            "\nKet qua danh gia mo hinh 10-fold cross-validation\n----\n", false));
     }
    
     public  void predictClassLabel(String fileIn, String fileOut) throws  Exception{
         //Doc du lieu can du doan vao bo nho
         DataSource ds = new DataSource(fileIn);
         Instances unlabel = ds.getDataSet();
         unlabel.setClassIndex(unlabel.numAttributes() -1);
         //Du doan classLabel cho tung instance
         for (int i = 0; i < unlabel.numInstances(); i++){
             double predict = bag.classifyInstance(unlabel.instance(i));
         }
         //Xuat ket qua ra fileOut
         BufferedWriter outWriter = new BufferedWriter(new FileWriter(fileOut));
         outWriter.write(unlabel.toString());
         outWriter.newLine();
         outWriter.flush();
         outWriter.close();
     }
}
