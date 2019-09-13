package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="staff"
    ,catalog="mydb"
)
public class Staff  implements java.io.Serializable {


     private Integer id;
     private String name;
     private int age;
     private String address;
     private int income;

    public Staff() {
    }

    public Staff(String name, int age, String address, int income) {
       this.name = name;
       this.age = age;
       this.address = address;
       this.income = income;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="age", nullable=false)
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    
    @Column(name="address", nullable=false, length=100)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="income", nullable=false)
    public int getIncome() {
        return this.income;
    }
    
    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", income=" + income + '}';
    }

    


}


