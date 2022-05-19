/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Debug;
import weka.core.Debug.Random;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author HOAI NGUYEN
 */
public class MyNaiveBayesModel extends MyKnowledgeModel{
    NaiveBayes nbayes;

    public MyNaiveBayesModel() {
        super();
    }

    public MyNaiveBayesModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }
    public void buildNavieBayes(String filename) throws Exception{
        //Doc train set vao bo nho
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes()-1);
        //Huan luyen mo hinh NaiveBayes
        this.nbayes = new NaiveBayes();
//        nbayes.setOptions(this.model_options); //Do ko đưa model_options vào nên sẻ tắt đi
        nbayes.buildClassifier(this.trainset);
    }
    public void evaluteNaivebayes(String filename) throws Exception{
        //Doc test set vao bo nho
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes()-1);
        //Danh gia mo hinh bang 10-fold cross-validation
        Random rnd = new Debug.Random(1);
        int folds =10;
        Evaluation eval = new Evaluation(this.trainset);
        eval.crossValidateModel(nbayes, this.testset, folds, rnd);
        System.out.println(eval.toSummaryString("\nKet qua danh gia mo hinh 10-fold cross-validation\n----\n", false));
    }
    
    public void predictClasslabel (String fileIn, String fileOut) throws  Exception{
        //Doc du lieu can du doan vao bo nho
        DataSource ds = new DataSource(fileIn);
        Instances unlabel =ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes()-1);
        //Du doan classLabel cho tung instance
        for(int i = 0; i < unlabel.numInstances(); i++){
            double predict = nbayes.classifyInstance(unlabel.instance(i));
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
        return this.nbayes.toString();
    }
    
}
