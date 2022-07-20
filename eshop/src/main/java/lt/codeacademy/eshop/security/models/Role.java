package lt.codeacademy.eshop.security.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Role implements GrantedAuthority {

    private static final String ROLE_PREFIX = "ROLE_";

    @Id
    private String name;

    @Override
    public String getAuthority() {
        return ROLE_PREFIX + name;
    }
}
