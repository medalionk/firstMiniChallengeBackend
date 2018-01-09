package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.AddressMapper;
import it.crazyones.easyexplore.domain.model.Address;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@AllArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor(force = true)
public class AddressDTO implements DTO<Address> {
    @NotEmpty
    @NonNull
    private String street;

    @NotEmpty
    @NonNull
    private String city;

    @NotEmpty
    @NonNull
    private String country;
    private String zipcode;

    @Override
    public Address asEntity() {
        return AddressMapper.INSTANCE.toEntity(this);
    }
}
