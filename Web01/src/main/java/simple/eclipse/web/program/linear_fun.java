package simple.eclipse.web.program;
//mapowanie kolumny
import javax.persistence.Column;
//mapowanie całej tabeli
import javax.persistence.Entity;
//generowanie klucza glownego
import javax.persistence.GeneratedValue;
//generowanie typu
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="linear_fun")
public class linear_fun {
	 	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="id")
	    protected int id;
	 
	    @Column(name="a")
	    protected int a;
	 
	    @Column(name="x")
	    protected int x;
	 
	    @Column(name="b")
	    protected int b;
	   
	    public linear_fun() {
	    }
	 
	    public linear_fun(int a, int x, int b) {
	        super();
	        this.a = a;
	        this.x = x;
	        this.b = b;
	    }
	    public linear_fun(int id,int a, int x, int b) {
	        super();
	        this.id = id;
	        this.a = a;
	        this.x = x;
	        this.b = b;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public int getA() {
	        return a;
	    }
	    public void setA(int a) {
	        this.a = a;
	    }
	    public int getX() {
	        return x;
	    }
	    public void setX(int x) {
	        this.x = x;
	    }
	    public int getB() {
	        return b;
	    }
	    public void setB(int b){
	    	this.b = b;
	    }
	   
	     
}
