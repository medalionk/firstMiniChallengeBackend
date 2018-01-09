package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.ClientMapper;
import it.crazyones.easyexplore.domain.model.Client;
import lombok.*;

import java.time.Instant;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper=false)
public class ClientDTO extends ResourceDTO<Client> {
    @NonNull
    private String _id;

    @NonNull
    protected String firstName;

    @NonNull
    protected String lastName;

    protected String phone;
    protected String email;
    protected String password;
    protected String profileImage;
    protected AddressDTO address;

    protected Instant createdDate;
    protected Instant lastModifiedDate;

    @Override
    public Client asEntity() {
        return ClientMapper.INSTANCE.toEntity(this);
    }
}
