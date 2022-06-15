/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wekapro;

import weka.classifiers.trees.J48;

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
//Apriori
////        //Doc du lieu vao bo nho
////        MyKnowledgeModel model = new MyKnowledgeModel("C:\\Program Files\\Weka-3-8-6\\data\\iris.arff");
////        System.out.println(model);
////        
////        //Luu du lieu ra file
////        model.saveData("E:\\NetBeans\\Data\\iris.arff");
////        
////        //Chuyen doi dinh dang du lieu
////        model.saveData2CSV("E:\\NetBeans\\Data\\iris_CSV.csv");
            
//            MyAprioriModel model = new MyAprioriModel("C:\\Program Files\\Weka-3-8-6\\data\\supermarket.arff", 
//                                                        "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1", 
//                                                        "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");

//            MyAprioriModel model = new MyAprioriModel("C:\\Program Files\\Weka-3-8-6\\data\\weather.numeric.arff", 
//                                                        "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1", 
//                                                        "-R 2-3");
//            model.mineAssociationRules();
//            System.out.println(model);

//FP-Growth
//              MyFPGrowthModel model = new MyFPGrowthModel("C:\\Program Files\\Weka-3-8-6\\data\\supermarket.arff", 
//                                                            "-P 2 -I -1 -N 10 -T 0 -C 0.8 -D 0.05 -U 1.0 -M 0.2",
//                                                            "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");
//              model.mineAssociationRules();
//              System.out.println(model);
//              MyFPGrowthModel model = new MyFPGrowthModel("C:\\Program Files\\Weka-3-8-6\\data\\weather.nominal.arff", 
//                                                            "-P 2 -I -1 -N 10 -T 0 -C 0.7 -D 0.05 -U 1.0 -M 0.2",
//                                                            "-N -R first-last");
//              model.mineAssociationRules();
//              System.out.println(model);


//Train set & Test set
    //Bộ lọc RemovePercentage
//    MyKnowledgeModel model = new MyKnowledgeModel(
//                "C:\\Program Files\\Weka-3-8-6\\data\\iris.arff", null, null);
//    model.trainset = model.divideTrainTest(model.dataset, 30, false);
//    model.testset = model.divideTrainTest(model.dataset, 30, true);
//    System.out.println(model);
//        System.out.println(model.trainset.toSummaryString());
//        System.out.println(model.testset.toSummaryString());
        
        
    //Bộ lọc Resample
//    MyKnowledgeModel model = new MyKnowledgeModel(
//    am Files\\Weka-3-8-6\\data\\iris.arff", null, null);
//    model.trainset = model            "C:\\Progr.divideTrainTestR(model.dataset, 70, false);
//    model.testset = model.divideTrainTestR(model.dataset, 70, true);
//    System.out.println(model);
//        System.out.println(model.trainset.toSummaryString());
//        System.out.println(model.testset.toSummaryString());

//      MyDecisionTreeModel model = new MyDecisionTreeModel("C:\\Program Files\\Weka-3-8-6\\data\\iris.arff",
//                    "-C 0.25 -M 2", null);
//      model.builDecisionTree();
//      model.evaluateDecisionTree();
//      System.out.print(model);
////      model.saveModel("E:\\NetBeans\\Data\\model\\decisiontree.model", model.tree);
//      model.tree=(J48)model.loadModel("E:\\NetBeans\\Data\\model\\decision-tree.model");
//      model.predietClassLable(model.testset);

//NaiveBayes
//        MyNaiveBayesModel model = new MyNaiveBayesModel();
//        model.buildNavieBayes("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-train.arff");
//        model.evaluteNaivebayes("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-test.arff");
//        model.predictClasslabel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_unlable.arff", 
//                                "E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_predict_nb.arff");
//        System.out.println(model);

//Mo hinh mang neural
//        MyNeuralNetworkModel model = new MyNeuralNetworkModel("", 
//                                "-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a -R",
//                                null);
//        model.buildNeuralNetwork("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-train.arff");
//        model.evaluateNeuralNetwork("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-test.arff");
//        model.predictClassLabel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_unlable.arff", 
//                                "E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_predict_ann.arff");
//        System.out.println(model);

//Mo hinh SVM
//        MySVMModel model = new MySVMModel("",
//                            "-C 1.0 -L 0.001 -P 1.0E-12 -N 0 -V -1 -W 1 -K \"weka.classifiers.functions.supportVector.PolyKernel -E 1.0 -C 250007\" -calibrator \"weka.classifiers.functions.Logistic -R 1.0E-8 -M -1 -num-decimal-places 4\"",
//                            null);
//        model.builSVM("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-train.arff");
//        model.evaluateSVM("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-test.arff");
//        model.predictClassLable("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_unlable.arff", 
//                                "E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_predict_svm.arff");
//        System.out.println(model);
    
//Mo hinh K-lancan
//        MyKNNModel model = new MyKNNModel("",
//                "-K 5 -W 0 -A \"weka.core.neighboursearch.LinearNNSearch -A \\\"weka.core.EuclideanDistance -R first-last\\\"\"", 
//                null);
//        model.buildkNN("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-train.arff");
//        model.evaluatekNN("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-test.arff");
//        model.predictClassLabel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_unlable.arff", 
//                                "E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_predict_knn.arff");
//        System.out.println(model);

//Mo hinh Bagging
//        MyBaggingModel model = new MyBaggingModel("", null, null);
//        model.buildBaggingModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-train.arff");
//        model.evaluateBaggingModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-test.arff");
//        model.predictClassLabel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_unlable.arff", 
//                                "E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_predict_bag.arff");
//        System.out.println("Finished");

//Mo hinh Boosting
//        MyBoostingModel model = new MyBoostingModel("", null, null);
//        model.buildBoostingModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-train.arff");
//        model.evaluateBoostingModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-test.arff");
//        model.predictClassLabel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_unlable.arff", 
//                                "E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_predict_boost.arff");
//        System.out.println("Finished");

//Mo hinh Voting
//        MyVotingModel model = new MyVotingModel("", null, null);
//        model.buildVotingModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-train.arff");
//        model.evaluateVotingModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-test.arff");
//        model.predictClassLabel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_unlable.arff", 
//                                "E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_predict_vote.arff");
//        System.out.println("Finished");

//Mo hinh Blending
//        MyBlendingModel model = new MyBlendingModel("", null, null);
//        model.buildBlendingModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-train.arff");
//        model.evaluateBlendingModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-test.arff");
//        model.predictClassLabel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_unlable.arff", 
//                                "E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_predict_blending.arff");
//        System.out.println("Finished");

//Phuong phap KMeans
//        MyKMeansModel model = new MyKMeansModel("", null, null);
//        model.buildKMeansModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-cluster-train.arff");
//        model.predictCluster("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_cluster_unlable.arff");
//        System.out.println("Finished");

//Phuong phap EM
        MyEMModel model = new MyEMModel("", null, null);
        model.buildEMModel("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris-cluster-train.arff");
        model.predictCluster("E:\\NetBeans\\Data\\Weka\\Data-exp\\iris_cluster_unlable.arff");
        System.out.println("Finished");
    }    
}
