package sk.ukf.mvc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Meno nesmie byť prázdne.")
    @Size(min = 2, max = 64, message = "Meno musí mať aspoň 2 a najviac 64 znakov.")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Priezvisko nesmie byť prázdne.")
    @Size(min = 2, max = 64, message = "Priezvisko musí mať aspoň 2 a najviac 64 znakov.")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Dátum narodenia nesmie byť prázdny.")
    @Past(message = "Dátum narodenia musí byť v minulosti.")
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotBlank(message = "Email nesmie byť prázdny")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Neplatný formát e-mailovej adresy."
    )
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Telefónne číslo nesmie byť prázdne.")
    @Pattern(
            regexp = "^\\+421\\d{9}$",
            message = "Telefónne číslo musí začínať +421 a obsahovať presne 9 číslic za ním."
    )
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Pracovná pozícia nesmie byť prázdna.")
    @Column(name = "job_title")
    private String jobTitle;

    @Min(value = 0, message = "Plat nemôže byť záporný.")
    @Column(name = "salary")
    private Float salary;

    @NotNull(message = "Typ úväzku nesmie byť prázdna.")
    @Column(name = "full_time")
    private byte fullTime;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate birthDate, String email, String phone, String jobTitle, Float salary, byte fullTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.fullTime = fullTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public byte getFullTime() {
        return fullTime;
    }

    public void setFullTime(byte fullTime) {
        this.fullTime = fullTime;
    }
}
