package com.company;

public class Main {


    public static void main(String[] args) {

        int[][][] data= Perceptron.data;
        double[] weights = Perceptron.INTIAL_WEIGHTS;
        Main driver = new Main();
        Perceptron perceptron = new Perceptron();

        boolean errorsAvailable = true;
        int epochNumber = 0; //start at iteration 0
        double error;
        double[] adjustedWeights;

        //while loop to train neural network. Stop when there's no errors remaining
        while(errorsAvailable) {

            //Epoch = One epoch consists of one full training cycle on the training set.
            //Once every sample in the set is seen, you start again - marking the beginning of the 2nd epoch.
            System.out.println("*********************************** Epoch number: " + epochNumber++ + " ***********************************");

            errorsAvailable = false;

            for (int i = 0; i < data.length; i++) {
                double weightedSum = perceptron.calculateWeightedSum(data[i][0], weights);
                int result = perceptron.applyActivationFucntion(weightedSum);

                error = data[i][1][0] - result; //the target data - the actual data


                if(error != 0 )
                    errorsAvailable = true;


                adjustedWeights = perceptron.adjustWeights(data[i][0], weights, error);
                driver.printVector(data[i], weights, result, error, weightedSum, adjustedWeights);
                weights = adjustedWeights;



            }

        }

    }

    public void printVector(int[][] data, double[] weights, int result, double error, double weightedSum, double[] adjustedWeights) {

        System.out.println("  w1:" + String.format("%.2f", weights[0]) +" |  w2: " + String.format("%.2f", weights[1])
         + "    |  x1: " +data[0][0] + "   |  x2: " +data[0][1] + "   |  Target Res: " + data[1][0] + "  |  Result: " + result +
            "   |  error:  " +error+ "     |   " + String.format("%.2f", weightedSum) +
            "   |  adjusted w1: " + String.format("%.2f", adjustedWeights[0]) + "   |  adjusted w2: "+String.format("%.2f", adjustedWeights[1]));
    }


}
