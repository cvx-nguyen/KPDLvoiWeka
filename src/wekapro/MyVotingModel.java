/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.Vote;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author HOAI NGUYEN
 */
public class MyVotingModel extends MyKnowledgeModel{
    Vote voting;
    Evaluation eval;
    
    //Cac constructors

    public MyVotingModel() {
    }

    public MyVotingModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }
    
    //Cac phuong thuc
    public  void buildVotingModel (String filename) throws Exception{
        //Doc train set vao bo nho
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() -1);
        //Thiet lap Voting model
        voting = new Vote();
        Classifier[] classifiers = {new NaiveBayes(),
                                        new J48(),
                                        new RandomForest()};
        voting.setClassifiers(classifiers);
        voting.setCombinationRule(new SelectedTag(Vote.MAJORITY_VOTING_RULE, 
                                Vote.TAGS_RULES));
        voting.buildClassifier(trainset);
        }
    
    public void evaluateVotingModel (String filename) throws Exception{
        //Doc test set vao bo nho
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() -1);
        //Danh gia mo hinh bang 10-fold cross-validation
        Random rnd = new Random(1);
        int folds = 10;
        eval = new Evaluation(this.trainset);
        eval.crossValidateModel(voting, testset, folds, rnd);
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
             double predict = voting.classifyInstance(unlabel.instance(i));
         }
         //Xuat ket qua ra fileOut
         BufferedWriter outWriter = new BufferedWriter(new FileWriter(fileOut));
         outWriter.write(unlabel.toString());
         outWriter.newLine();
         outWriter.flush();
         outWriter.close();
     }

}
