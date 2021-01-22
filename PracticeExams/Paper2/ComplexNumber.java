package PracticeExams.Paper2;

import java.util.Vector;

public class ComplexNumber {
        private double real; // Real Part
        private double imag; // Imaginary Part

        ComplexNumber() {
                // Complete This Constructor
                real = 1; // Complete This Statement
                imag = 1; // Complete This Statement
        } // End of Constructor

        ComplexNumber(double value) {
                // Complete This Constructor
                real = value; // Complete This Statement
                imag = 1; // Complete This Statement
        } // End of Constructor

        ComplexNumber(double value1, double value2) {
                // Complete This Constructor
                real = value1; // Complete This Statement
                imag = value2; // Complete This Statement
        } // End of Constructor
          // Accessor Methods

        public double getReal() {
                return real;
        }

        public double getImaginary() {
                return imag;
        }

        // Mutator Methods
        public void setReal(double value) {
                this.real = value;
        }

        public void setImaginary(double value) {
                this.imag = value;
        }

        // Method to Add Two Complex Numbers
        public ComplexNumber add(ComplexNumber other) {
                /*
                 * This method adds ‘this’ complex number to ‘other’ and returns the new
                 * resultant ComplexNumber
                 */
                ComplexNumber newComplexNumber = new ComplexNumber();
                double a = this.getReal() + other.getReal();
                newComplexNumber.setReal(a);
                a = this.getImaginary() + other.getImaginary();
                newComplexNumber.setImaginary(a);
                // Complete This Portion
                return newComplexNumber;
        }

        // Method to Multiply Two Complex Numbers
        public ComplexNumber mul(ComplexNumber other) {
                /*
                 * This method multiplies ‘this’ complex number with ‘other’ and returns the new
                 * resultant ComplexNumber
                 */
                // COMPLETE THIS METHOD
                ComplexNumber newComplexNumber = new ComplexNumber();
                double x = ((this.getReal() * other.getReal()) - (this.getImaginary() * other.getImaginary()));

                double y = ((this.getReal() * other.getImaginary()) + (this.getImaginary() * other.getReal()));

                newComplexNumber.setReal(x);

                newComplexNumber.setImaginary(y);
                // Complete This Portion
                return newComplexNumber;
        }

        // Method to Check Equality of Two Complex Numbers
        public boolean equals(ComplexNumber other) {
                /*
                 * This method returns true or false if the state of ‘this’ complex number is
                 * equal to ‘other’ and otherwise it returns false. Two complex number instances
                 * are equal if their real and imaginary part values are also equal.
                 */
                // COMPLETE THIS METHOD
                boolean b1 = this.getReal() == other.getReal();
                boolean b2 = this.getImaginary() == other.getImaginary();
                return b1 && b2;
        }
}// End of Class

class ComplexNumberList {
        private Vector<ComplexNumber> complexNumberList; // list of complex numbers
        // Constructor

        ComplexNumberList() {
                complexNumberList = new Vector<ComplexNumber>();
        }

        public void addComplexNumber(ComplexNumber c) {
                /*
                 * This method adds a ComplexNumber ‘c’ at the end of ‘complexNumberList’
                 * instance field
                 */
                // Complete This Method
            complexNumberList.add(c);
        }

        public Vector<ComplexNumber> complexNumbersWithRealPart(double realValue) {
                /*
                 * This method returns the list of all Complex Numbers from ‘complexNumberList’
                 * instance field which has real value equals to ‘realValue’ an argument to this
                 * method
                 */
                Vector<ComplexNumber> list = new Vector<ComplexNumber>();
                for(ComplexNumber i : complexNumberList){
                    if(i.getReal()==realValue){
                        list.add(i);
                    }
                }
                // Complete This Method
                return list;
        }

public ComplexNumber complexNumbersWithMaxRealPart()
{
 /* This method returns a Complex Number from ‘complexNumberList’ instance field
 which has highest real value */
ComplexNumber maxC;

maxC=complexNumberList.get(0);
// Complete This Method
    for(int i=0;i<complexNumberList.capacity();i++){
        if(complexNumberList.get(i).getReal()>maxC.getReal()){
            maxC=complexNumberList.get(i);
        }
    }
return maxC;
// Note : maxC should store or point to that ComplexNumber instance which highest real part value
}}