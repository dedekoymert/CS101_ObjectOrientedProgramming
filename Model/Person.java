package Model;
//done
public abstract class Person {
	private String id;
	private String name;
	private String email;
	private static int idNumber=1;
	
	public Person(String name){
		this.name=name;
		idGenerator(this.name);
		this.initEmail();
	}
	
	private void idGenerator(String name){
		String[] name1= new String[2];
		name1=name.toLowerCase().split(" ");
		if(idNumber<10)	{
			this.id=name1[0].charAt(0)+""+ name1[1].charAt(0)+"000"+Integer.toString(idNumber);
			idNumber+=1;
		}	
		
		else if(idNumber<100){
			this.id=name1[0].charAt(0)+""+ name1[1].charAt(0)+"00"+Integer.toString(idNumber);
			idNumber+=1;
		}
		
		else if(idNumber<1000){
			this.id=name1[0].charAt(0)+""+ name1[1].charAt(0)+"0"+Integer.toString(idNumber);
			idNumber+=1;
		}
		else{
			this.id=name1[0].charAt(0)+""+ name1[1].charAt(0)+""+Integer.toString(idNumber);
			idNumber+=1;
		}
	}
	
	public abstract void initEmail();
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String toString(){
		return id+", "+name+", "+email;
	}
}
