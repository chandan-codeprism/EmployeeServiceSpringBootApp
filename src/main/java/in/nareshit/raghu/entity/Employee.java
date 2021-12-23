package in.nareshit.raghu.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "empTab")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private Long empId;
    @Column(name = "ename")
    private String empName;
    @Column(name = "esal")
    private Double empSal;
    @Column(name = "egen")
    private String empGen;
    @Column(name = "edept")
    private String empDept;
    @Column(name = "eaddr")
    private String empAddr;
}
