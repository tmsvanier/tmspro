
package tmsModelLayer;

import java.util.HashSet;
import java.util.Set;


public class Users {
        String name, address, telephone, email, roleRegistering, passwordreg; 
        int id;
    public Users(String name, String address, String telephone, String email, String roleRegistering, String passwordreg) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.roleRegistering = roleRegistering;
        this.passwordreg = passwordreg;
    }
     public Users(){
         id=0;
         name="";
         address="";
         telephone="";
         email="";
         roleRegistering="";
         passwordreg="";
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleRegistering() {
        return roleRegistering;
    }

    public void setRoleRegistering(String roleRegistering) {
        this.roleRegistering = roleRegistering;
    }

    public String getPasswordreg() {
        return passwordreg;
    }

    public void setPasswordreg(String passwordreg) {
        this.passwordreg = passwordreg;
    }
  
    public void makeCopy(Users tmp){
      tmp.setName(name);
      tmp.setId(id);
      tmp.setAddress(address);
      tmp.setEmail(email);
      tmp.setPasswordreg(passwordreg);
      tmp.setRoleRegistering(roleRegistering);
      tmp.setTelephone(telephone);
        
                
        
    }
     
        
}
