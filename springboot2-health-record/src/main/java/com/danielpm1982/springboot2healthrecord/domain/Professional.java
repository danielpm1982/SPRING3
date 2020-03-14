package com.danielpm1982.springboot2healthrecord.domain;

public class Professional extends Person {
    protected int registryNo;
    protected String profession;
    protected String specialty;
    public Professional() {
    }
    public Professional(Long id, String name, String email, int registryNo, String profession, String specialty) {
        super(id, name, email);
        this.registryNo = registryNo;
        this.profession = profession;
        this.specialty = specialty;
    }
    public int getRegistryNo() {
        return registryNo;
    }
    public void setRegistryNo(int registryNo) {
        this.registryNo = registryNo;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    @Override
    public String toString() {
        return "Professional{" +
                "registryNo=" + registryNo +
                ", profession='" + profession + '\'' +
                ", specialty='" + specialty + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professional that = (Professional) o;
        return registryNo == that.registryNo;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + registryNo;
        return result;
    }
}
