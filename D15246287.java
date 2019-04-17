import java.time.LocalDate;  //Brandon Scott
import java.util.*; 

                                             
abstract class Employee { //Abstract Employee class
	private String name, idNumber;
	private LocalDate hireDate;
	
	
	public Employee() {
		name=null;
		setID(null);
		setHireDate(null);
	}
	
	public Employee(String name, String id, int month, int day, int year) {
	name= this.name;
	id=this.getID();
	setHireDate(LocalDate.of(year, month, day));
	
	}
	
	public String getName(){
		return name;
	}
	
	public String getID(){
		return idNumber;
	}
	
	public void setID(String idNumber) {
		this.idNumber = idNumber;
	}

	public LocalDate gethireDate(){
		return getHireDate();
		}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public void setName(String name) {
		this.name= name;
	}	
	
	public String toString() {
		return name + " " + getID() + " " + getHireDate();
	}
	
	public abstract double pay();

	public LocalDate getHireDate() {
		return hireDate;
	}

	
	
}

class SalariedEmployee extends Employee{
	 
	private double salary;
	private double newSalary = salary * 0.07;
	private String status;
	

	
	public SalariedEmployee(double s, String name, String idnum, String stat,int month, int day, int year) {
		super.setName(name);
		salary=s;
		status=stat;
		super.setID(idnum);
		setHireDate(LocalDate.of(year, month, day));
	}
	
	
	
	public void raiseTheSalary() {
    salary= salary+newSalary;	
	}
	
	public String getName(){
		return super.getName();
	}
	
	public String getID(){
		return super.getID();
	}
	
	public LocalDate gethireDate(){
		return super.gethireDate();
		}
	public void setName(String name) {
		name = this.getName();
	}	
	
	public String toString() {
		return "Name:"+ getName()  +" " + "ID Number: " + getID() + " " +
	"Hire date: " + gethireDate() + " " + 
	"Status: "+ status	+ " " + "Salary: " + salary;
	}



	@Override
	public double pay() {
		// TODO Auto-generated method stub
		return salary;
	}
}


class FulltimeEmployee extends Employee{

   private double payRate;
   private int hoursWorked;
   private String status;
   

	//seven param constructor method
	public FulltimeEmployee(String name, String id, int hrs, double payRt, int month, int day, int year) {
		super.setName(name);
		hoursWorked=hrs;
		payRate=payRt;
		super.setID(id);
	status = "Full Time Employee";
	setHireDate(LocalDate.of(year, month, day));
	
	}
	//getters
	public String getName(){
		return super.getName();
	}
	
	public String getID(){
		return super.getID();
	}
	
	public LocalDate gethireDate(){
		return super.gethireDate();
		}
	
	//3 setters for name, payrate and the hours worked.
	public void setName(String name) {
		name = this.getName();
	}	
	
	public void setpayRate(double payRate) {
		payRate = this.payRate;
	}	
	
	public void sethoursWorked(int hoursWorked) {
		hoursWorked = this.hoursWorked;
	}	
	
	
	
   public int overTime() { //methods for calculating overtime hours
	   while(hoursWorked>40){ 
	  return hoursWorked-40;
	   }
	   return hoursWorked;
	   }
   
   public String toString() {
		return "Name:"+ getName() +" " + "ID Number: " + getID() +" " + "Hire date: " + gethireDate() +" " 
		+ "Status: "+ status +" " + "hours worked: " + hoursWorked +" " + "pay rate:" + payRate;
	}

   
   
	@Override
	public double pay() {
		// TODO Auto-generated method stub
		double finalPay;
		if(hoursWorked>40) {
		finalPay= payRate*(hoursWorked-40)*1.5;
		return finalPay;
		}
		finalPay= payRate*hoursWorked;
		return finalPay;
	}
	
	
}


class ParttimeEmployee extends Employee{//ParttimeEmployee class

	private double payRate;
	   private int hoursWorked;
	   private String status;
	   

		//seven param constructor method
		public ParttimeEmployee(String name, String id, int hrs, double payRt, int month, int day, int year) {
		super.setName(name);
		hoursWorked=hrs;
		payRate=payRt;
		super.setID(id);
		status = "Part Time Employee";
		setHireDate(LocalDate.of(year, month, day));
		
		}
		//getters
		public String getName(){
			return super.getName();
		}
		
		public String getID(){
			return super.getID();
		}
		
		public LocalDate gethireDate(){
			return super.gethireDate();
			}
		
		//3 setters for name, payrate and the hours worked.
		public void setName(String name) {
			name = this.getName();
		}	
		
		public void setpayRate(double payRate) {
			payRate = this.payRate;
		}	
		
		public void sethoursWorked(int hoursWorked) {
			hoursWorked = this.hoursWorked;
		}	
		
		
		
	   public int overTime() { //since this worker doesn't get overtime, just return hoursWorked
		   return hoursWorked;
		   }
	   
	   public String toString() {
			return "Name:"+ getName()  + " " + "ID Number:" + getID() + " " + "Hire date:" + gethireDate() 
			+ " " + "Status:"+ status+ " " + "hours worked:" + hoursWorked + " " + "pay rate:" + payRate;
		}

	   
	   
		@Override
		public double pay() {
			double finalPay;
			// TODO Auto-generated method stub
			finalPay= payRate*hoursWorked;
			return finalPay;
		}
		
			

	
	
	
}

class EmployeeDemo {
	
    static SalariedEmployee Sally = new SalariedEmployee(35000.00, "Sally", "1238283" , "Salaried Employee", 12, 10, 1995);
    static SalariedEmployee Billy = new SalariedEmployee(40000.00, "Billy", "2313829", "Salaried Employee", 05, 06, 2000);
	
    static FulltimeEmployee Rahat = new FulltimeEmployee("Rahat", "5930682", 30, 0.7, 03, 02, 2011);
    static FulltimeEmployee Jackson = new FulltimeEmployee("Jackson", "1234567", 50, 0.7, 07, 12, 2005);
	
    static ParttimeEmployee Brandon = new ParttimeEmployee("Brandon", "7654321", 30, 0.7, 11, 04, 2013);
    static ParttimeEmployee Anish = new ParttimeEmployee("Anish", "3962283", 34, 0.7, 07, 03, 2014);
	
}


public class D15246287 extends EmployeeDemo{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(Sally.toString());
		System.out.println(Billy.toString());
		
		System.out.println(Rahat.toString());
		System.out.println(Jackson.toString());
		
		System.out.println(Brandon.toString());
		System.out.println(Anish.toString());
	

		System.out.println(Rahat.overTime());

		System.out.println(Rahat.pay());

		System.out.println(Rahat.toString());
		
		

		System.out.println(Jackson.pay());
		

		System.out.println(Brandon.overTime());

		System.out.println(Anish.overTime());
	

	}
	

}
