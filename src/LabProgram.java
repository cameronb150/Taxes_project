import java.util.Scanner;

public class LabProgram {
    final static int DEPENDENT_STATUS = 0;
    final static int SINGLE_STATUS = 1;
    final static int MARRIED_STATUS = 2;

    // Calculate AGI and repair any negative values
    public static int calcAGI(int wages, int interest, int unemployment) {
        // TODO (step 2)
        int agi = Math.abs(wages) + Math.abs(interest) + Math.abs(unemployment);
        return agi;
    }

    // Calculate deduction depending on single, dependent or married
    public static int getDeduction(int status) {
        // TODO (step 3) - conditional if
        //   Return the deduction amount based on status: (0) dependent = 6000, (1) single = 12000, or (2) married=24000
        //   Return 6000 if the status is anything but 0, 1, or 2
        if (status == SINGLE_STATUS) {
            // (1) single = 12000
            return 12000;
        }

        if (status == MARRIED_STATUS) {
            // (2) married = 24000
            return 24000;
        }

        // status = 0 dependent or anything but 1 or 2
        return 6000;
    }

    // Calculate taxable but not allow negative results
    public static int calcTaxable(int agi, int deduction) {
        /* Complete the method and update the return statement */
        int taxableAmount = agi - deduction;

        if (taxableAmount < 0) {
            taxableAmount = 0;

        }
        return taxableAmount;


    }

    // Calculate tax for single or dependent
    public static int calcTax(int status, int taxable) {
        double taxAmount = 0.0;
        /* Complete the method and update the return statement */

        if (status == DEPENDENT_STATUS || status == SINGLE_STATUS) {
            if (taxable <= 10000) {
                taxAmount = 0.10 * taxable;

            } else if (taxable <= 40000) {
                taxAmount = 1000 + (0.12 * (taxable - 10000));

            } else if (taxable <= 85000) {
                taxAmount = 4600 + (0.22 * (taxable - 40000));

            } else {
                taxAmount = 14500 + (0.24 * (taxable - 85000));

            }
        } else if (status == MARRIED_STATUS) {
            if (taxable <= 20000) {
                taxAmount = 0.10 * taxable;

            } else if (taxable <= 80000) {
                taxAmount = 2000 + (0.12 * (taxable - 20000));

            } else {
                taxAmount = 9200 + (0.22 * (taxable - 80000));

            }
        }


        return (int) Math.round(taxAmount);
    }

    // Calculate tax due and check for negative withheld
    public static int calcTaxDue(int tax, int withheld) {
        /* Complete the method and update the return statement */
        if (withheld < 0) {
            withheld = 0;
        }
        int taxDue = (tax - withheld);

        return taxDue;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // TODO (step 1) - read wages, interest, unemployment, status, withheld from input.
        int wages = scn.nextInt();
        int interest = scn.nextInt();
        int unemployment = scn.nextInt();
        int status = scn.nextInt();
        int withheld = scn.nextInt();

        // TODO (step 2) - assignment to variable and call method
        int agi = calcAGI(wages, interest, unemployment);

        // TODO (step 3) - assign to variable and call the method
        int deduction = getDeduction(status);

        int taxableAmount = calcTaxable(agi, deduction);


        int tax = calcTax(status, taxableAmount);

        int taxDue = calcTaxDue(tax, withheld);


        // TODO (step 2) print out the agi
        System.out.printf("AGI: $%,d\n", agi);
        // TODO (step 3) print out the deduction
        System.out.printf("Deduction: $%,d\n", deduction);

        //taxableAmount = calcTaxable(agi, deduction);
        System.out.printf("Taxable income: $%,d\n", taxableAmount);

        System.out.printf("Federal tax: $%,d\n", tax);

        System.out.printf("Tax due: $%,d\n", taxDue);


    }
}