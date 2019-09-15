package team.hau.sam.pojo.vo;

import java.sql.Date;

public class PeasantHouseholdVo {
    private Integer id;
    private String password;
    private String accountType;
    private String sex;
    private String tel;
    private String name;
    private Date birthday;
    private String address;
    private String remark;

    public PeasantHouseholdVo(Integer id, String password, String accountType, String sex, String tel, String name, Date birthday, String address, String remark) {
        this.id = id;
        this.password = password;
        this.accountType = accountType;
        this.sex = sex;
        this.tel = tel;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "PeasantHouseholdVo{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
