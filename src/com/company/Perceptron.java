package com.company;

public class Perceptron {


    //1: x1 = 0, x2 = 0. Target = 0.
    //2: x1 = 0, x2 =1. Target = 0.
    //And so on...
    public static final int[][][]  data =
                            {{{0, 0}, {0}},  //1
                            {{0,1}, {0}},   //2
                            {{1,0}, {0}},
                            {{1,1}, {1}}};

    public static final double LEARNING_RATE = 0.05;
    public static final double[] INTIAL_WEIGHTS = {Math.random(), Math.random()}; //two random weights to start with (between 0-1)

    public double calculateWeightedSum(int[] data, double[] weights) {
        double weightedSum = 0;

        //ws = data1 * w1 + data2*w2 .... data(n) * w(n). Iterates the amout of datasets.
        for (int i = 0; i < data.length; i++) {
            weightedSum = weightedSum + data[i] * weights[i];
        }
        return weightedSum;
    }

    public int applyActivationFucntion(double weightedSum) {
        int result = 0;

        if(weightedSum >1)
            result = 1;

        //else result = 0;

        return result;
    }

    public double[] adjustWeights(int[] data, double[] weights, double error) {
        double[] adjustedWeights = new double[weights.length];

        //as = learning_rate * error * data1 * w1 +
        //     learning_rate * error *  data2*w2 +
        // ... learning_rate * error * data(n) * w(n). Iterates the amout of datasets.
        for (int i = 0; i < weights.length; i++) {
            adjustedWeights[i] = LEARNING_RATE * error * data[i] + weights[i];
        }
        return adjustedWeights;
    }


//Not in use. translates to the function above instead.
    public double[] applyDeltaRule(double[] input, double[] idealValue, double[] actualValue, double[] weights){

        double[] adjustedWeigts = new double[weights.length];
        for (int i = 0; i < data.length; i++) {
            adjustedWeigts[i] = LEARNING_RATE * input[i] * (idealValue[i] - actualValue[i]);

        }
     return  adjustedWeigts;
    }
}
