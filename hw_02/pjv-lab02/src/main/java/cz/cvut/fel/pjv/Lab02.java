/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */

package cz.cvut.fel.pjv;
import java.util.Scanner;

public class Lab02 {
   public static void start(String[] args) {
      homework();
   }

   public static void homework() {
      Scanner scanner = new Scanner(System.in);
      scanner.useDelimiter("\\n");
      int count = 0, lineCount = 0;
      double sum = 0, sumSquare = 0;

      while (scanner.hasNext()) {
         lineCount++;
         if (scanner.hasNextDouble()) {
            double num = scanner.nextDouble();
            sum += num; sumSquare += num * num; count++;       //pouzito pro odchylku(sumSquare)

            if (count == 10) {
               printStatistics(count, sum, sumSquare);
               count = 0; sum = 0; sumSquare = 0;
            }

         } else {
            System.err.println("A number has not been parsed from line " + lineCount);
            scanner.next();
         }
      }


      System.err.println("End of input detected!");
      if (count > 0) {
         printStatistics(count, sum, sumSquare);
      }
      scanner.close();
   }

   public static double calcMean(int count, double sum){
      return sum/count;
   }

   public static double calcVar(int count, double sum, double sumSquare){
      return (sumSquare - sum * sum / count) / (count );
   }


   public static void printStatistics(int count, double sum, double sumSquare) {
      if (count > 1) {
         double mean = calcMean(count, sum);
         double deviation = Math.sqrt(calcVar(count, sum, sumSquare));
         System.out.printf("%2d %.3f %.3f\n", count, mean, deviation);
      }
   }
}
