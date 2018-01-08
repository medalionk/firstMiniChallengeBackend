package it.crazyones.easyexplore.domain.model;

import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * Created by bilal90 on 9/6/2017.
 */

@MappedSuperclass
public abstract class User extends AuditingEntity {
    @NotEmpty
    @NonNull
    @Column(name = "first_name", nullable = false)
    protected String firstName;

    @NotEmpty
    @NonNull
    @Column(name = "last_name", nullable = false)
    protected String lastName;

    @Column(name = "phone")
    protected String phone;

    @Column(name = "email")
    protected String email;

    @Column(name = "password")
    protected String password;

    @Column(name = "profile_image")
    protected String profileImage;

    @Embedded
    protected Address address;
}
