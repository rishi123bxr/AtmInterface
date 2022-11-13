
package ATMINTERFACE;

import java.util.Scanner;

public class ATM {
	public static void main(String args[]){
        System.out.println("WELCOME TO ATM!!!");
        System.out.println("\nSelect any one option!");
        System.out.println("1.REGISTER\n 2.EXIT");
        System.out.println("Enter your option :");
        Scanner sc=new Scanner(System.in);
        int ch;
        ch=sc.nextInt();
        if (ch==1){
            ATMFUNC Atmm=new ATMFUNC();
           
            while(ch==1){
                System.out.println("\nSelect any one option!");
                System.out.println("1.LOGIN\n2.EXIT");
                System.out.println("Enter your option :");
                int op=sc.nextInt();
                if (op==1){
                    if(Atmm.login()){
                        boolean isFin=false;
                        while(!isFin){
                            System.out.println("\nSelect any option : ");
                            System.out.println("1.DEPOSIT\n2.WITHDRAW\n3.TRANSFER\n4.TRANSACTION HISTORY\n5.CHECK BALANCE\n6.EXIT");
                            System.out.println("Enter your option :");
                            int c=sc.nextInt();
                            switch(c){
                                case 1 : Atmm.deposit();
                                    break;
                                case 2 : Atmm.withdraw();
                                    break;
                                case 3 : Atmm.transfer();
                                    break;
                                case 4 : Atmm.transHistory();
                                    break;
                                case 5 : Atmm.checkBal();
                                    break;
                                case 6 : isFin=true;
                                    break;
                                default: System.out.println("Invalid option!");
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else {
            System.out.print("Please Collect Your Card \n");
            System.exit(0);
        }

}
}
