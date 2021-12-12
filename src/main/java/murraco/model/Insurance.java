package murraco.model;

import javax.persistence.*;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String phone;
	private String carManu;
	private String carModel;
    private String licencePlate;
    private String insPackage;

    public Insurance() {}

    public Insurance(Long id, String name, String phone, String carManu, String carModel, String licencePlate, String insPackage) {
        this.id = id;
        this.name = name;
        this.phone = phone;
		this.carManu = carManu;
		this.carModel = carModel;
        this.licencePlate = licencePlate;
        this.insPackage = insPackage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarManu() {
        return carManu;
    }

    public void setCarManu(String carManu) {
        this.carManu = carManu;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getInsPackage() {
        return insPackage;
    }

    public void setInsPackage(String insPackage) {
        this.insPackage = insPackage;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
				", carManu='" + carManu + '\'' +
				", carModel='" + carModel + '\'' +
                ", licencePlate='" + licencePlate + '\'' +
                ", insPackage='" + insPackage + '\'' +
                '}';
    }
}
