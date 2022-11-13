 package ATMINTERFACE;
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;
	import java.util.Scanner;

	public class ATMFUNC{


	    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    LocalDateTime now =LocalDateTime.now();
	    float bal=0f;
	    int trans=0;
	    String transHis="";
	    String password;
	    String act_no;
	    String name;
	    String userID;
	    Scanner sc=new Scanner(System.in);

	    public void register(){
	        System.out.println("\nENTER YOUR USER NAME  :");
	        this.userID=sc.nextLine();
	        System.out.println("ENTER YOUR PWD  :");
	        this.password=sc.nextLine();
	        System.out.println("ENTER YOUR AC NUMBER  :");
	        this.act_no=sc.nextLine();
	        System.out.println("Registration completed. Successfully!");
	        System.out.println("please login to your account.");
	    }


	    public boolean login(){
	        boolean isLogin=false;
	        while(!isLogin){
	            System.out.println("\nEnter username : ");
	            String usr=sc.nextLine();
	            if (usr.equals(userID)){
	                System.out.println("Enter PWD : ");
	                String pd=sc.nextLine();
	                while(!isLogin){
	                    if(pd.equals(password)){
	                        System.out.println("Logged-in Successfully!!");
	                        isLogin=true;
	                    }
	                    else{
	                        System.out.println("Invalid login!!");
	                        break;
	                    }
	                }
	            }
	            else{
	                System.out.println("Username not found!!");
	            }
	        }
	        return isLogin;
	    }


	    public void deposit(){
	        System.out.println("\nEnter amount to deposit : ");
	        float damount=sc.nextFloat();
	        try{
	            if(damount<=100000f){
	                bal+=damount;
	                trans+=1;
	                System.out.println("Successfully deposited Rs. "+damount+" at "+dtf.format(now));
	                String s="Rs "+damount+" deposited at "+dtf.format(now)+" .\n";
	                transHis=transHis.concat(s);
	            }
	            else{
	                System.out.println("Sorry!Can't deposit more than one lakh");
	            }
	        }
	        catch(Exception e){
	        }
	    }


	    public void withdraw(){
	        System.out.println("\nEnter amount to withdraw : ");
	        float wamount=sc.nextFloat();
	        try{
	            if (wamount<=bal){
	                bal-=wamount;
	                trans+=1;
	                System.out.println("Successfully withdrawn Rs. "+wamount+" at "+dtf.format(now));
	                String s="Rs "+wamount+" withdrawn at "+dtf.format(now)+" .\n";
	                transHis=transHis.concat(s);
	            }
	            else{
	                System.out.println("Sorry!Can't withdraw.Insufficient amount to withdraw..");
	            }
	        }
	        catch(Exception e){
	        }
	    }



	    public void transfer(){
	        Scanner in = new Scanner(System.in);
	        System.out.println("\nEnter the username you want to transfer to : ");
	        String uname=in.nextLine();
	        System.out.println("Enter the amount to transfer");
	        float tamount=sc.nextFloat();
	        try{
	            if (tamount<=bal){
	                bal-=tamount;
	                trans+=1;
	                System.out.println("Successfully transferred Rs. "+tamount+" at "+dtf.format(now));
	                String s="Rs "+tamount+" transferred to "+uname+" account at "+dtf.format(now)+" .\n";
	                transHis=transHis.concat(s);
	            }
	            else{
	                System.out.println("Sorry!Can't transfer.Insufficient amount to transfer..");
	            }
	        }
	        catch(Exception e){
	        }
	    }



	    public void transHistory(){
	        if(trans==0){
	            System.out.println("\nNo Transactions!!");
	        }
	        else{
	            System.out.println("\n"+transHis);
	        }
	    }


	    public void checkBal(){
	        System.out.println("\nBalance amount is : "+bal);
	    }
	}


